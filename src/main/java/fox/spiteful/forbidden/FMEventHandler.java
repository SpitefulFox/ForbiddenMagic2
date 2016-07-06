package fox.spiteful.forbidden;

import fox.spiteful.forbidden.api.crafting.ForbiddenCrafting;
import fox.spiteful.forbidden.entity.EntityHumanItem;
import fox.spiteful.forbidden.items.ForbiddenItems;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

public class FMEventHandler {

    private Random randy = new Random();

    @SubscribeEvent
    public void onLivingDrops(LivingDropsEvent event) {

        if(event.getEntityLiving() instanceof EntityCow || event.getEntityLiving() instanceof EntityPig ||
                event.getEntityLiving() instanceof EntitySheep){
            EntityAgeable animal = (EntityAgeable)event.getEntityLiving();
            if(animal.isChild()){
                addDrop(event, new ItemStack(ForbiddenItems.resource, 1 + event.getLootingLevel() + randy.nextInt(3), 0));
            }
        }
        else if(event.getEntityLiving() instanceof EntityVillager && event.getEntityLiving().isBurning()){
            addDrop(event, new ItemStack(ForbiddenItems.resource, 1 + randy.nextInt(3), 1));
        }

    }

    private void addDrop(LivingDropsEvent event, ItemStack drop) {
        EntityItem entityitem = new EntityItem(event.getEntityLiving().worldObj, event.getEntityLiving().posX, event.getEntityLiving().posY, event.getEntityLiving().posZ, drop);
        entityitem.setDefaultPickupDelay();
        event.getDrops().add(entityitem);
    }

    @SubscribeEvent
    public void throwItem(ItemTossEvent event){
        if(event.getEntity().worldObj.isRemote)
            return;
        if(ForbiddenCrafting.isHumanFlesh(event.getEntityItem().getEntityItem()) && !(event.getEntityItem() instanceof EntityHumanItem)){
            EntityItem drop = new EntityHumanItem(event.getEntityItem().worldObj, event.getEntityItem(), event.getEntityItem().getEntityItem());
            drop.setDefaultPickupDelay();
            event.getEntityItem().worldObj.spawnEntityInWorld(drop);
            event.setCanceled(true);
        }
    }

}
