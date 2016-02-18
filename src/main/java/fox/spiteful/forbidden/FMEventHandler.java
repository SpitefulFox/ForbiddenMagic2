package fox.spiteful.forbidden;

import fox.spiteful.forbidden.items.ForbiddenItems;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.item.ItemStack;
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

    }

    private void addDrop(LivingDropsEvent event, ItemStack drop) {
        EntityItem entityitem = new EntityItem(event.entityLiving.worldObj, event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ, drop);
        entityitem.setDefaultPickupDelay();
        event.drops.add(entityitem);
    }

}
