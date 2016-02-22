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

        if(event.entityLiving instanceof EntityCow || event.entityLiving instanceof EntityPig ||
                event.entityLiving instanceof EntitySheep){
            EntityAgeable animal = (EntityAgeable)event.entityLiving;
            if(animal.isChild()){
                addDrop(event, new ItemStack(ForbiddenItems.resource, 1 + event.lootingLevel + randy.nextInt(3), 0));
            }
        }
        else if(event.entityLiving instanceof EntityVillager && event.entityLiving.isBurning()){
            addDrop(event, new ItemStack(ForbiddenItems.resource, 1 + randy.nextInt(3), 1));
        }

    }

    private void addDrop(LivingDropsEvent event, ItemStack drop) {
        EntityItem entityitem = new EntityItem(event.entityLiving.worldObj, event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ, drop);
        entityitem.setDefaultPickupDelay();
        event.drops.add(entityitem);
    }

    @SubscribeEvent
    public void throwItem(ItemTossEvent event){
        if(event.entity.worldObj.isRemote)
            return;
        if(ForbiddenCrafting.isHumanFlesh(event.entityItem.getEntityItem()) && !(event.entityItem instanceof EntityHumanItem)){
            EntityItem drop = new EntityHumanItem(event.entityItem.worldObj, event.entityItem, event.entityItem.getEntityItem());
            drop.setDefaultPickupDelay();
            event.entityItem.worldObj.spawnEntityInWorld(drop);
            event.setCanceled(true);
        }
    }

}
