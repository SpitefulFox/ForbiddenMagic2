package fox.spiteful.forbidden.entity;

import fox.spiteful.forbidden.items.ForbiddenItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityHumanItem extends EntityItem {

    public EntityHumanItem(World world){
        super(world);
    }

    public EntityHumanItem(World world, ItemStack stack){
        super(world);
        setEntityItemStack(stack);
    }

    public EntityHumanItem(World world, Entity original, ItemStack stack) {
        this(world, original.posX, original.posY, original.posZ, stack);
        this.setPickupDelay(20);
        this.motionX = original.motionX;
        this.motionY = original.motionY;
        this.motionZ = original.motionZ;
        this.setEntityItemStack(stack);
    }

    public EntityHumanItem(World world, double x, double y, double z, ItemStack stack) {
        super(world, x, y, z);
        this.setEntityItemStack(stack);
    }

    @Override
    protected void dealFireDamage(int damage) {
        if(worldObj.isRemote)
            return;
        EntityItem drop = new EntityFireproofItem(this.worldObj, this, new ItemStack(ForbiddenItems.resource, this.getEntityItem().stackSize, 1));
        drop.setDefaultPickupDelay();
        this.worldObj.spawnEntityInWorld(drop);
        this.setDead();
    }
}
