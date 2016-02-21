package fox.spiteful.forbidden.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityFireproofItem extends EntityItem {

    public EntityFireproofItem(World world){
        super(world);
        this.isImmuneToFire = true;
    }

    public EntityFireproofItem(World world, ItemStack stack){
        super(world);
        setEntityItemStack(stack);
        this.isImmuneToFire = true;
    }

    public EntityFireproofItem(World world, Entity original, ItemStack stack) {
        this(world, original.posX, original.posY, original.posZ, stack);
        this.setPickupDelay(20);
        this.motionX = original.motionX;
        this.motionY = original.motionY;
        this.motionZ = original.motionZ;
        this.setEntityItemStack(stack);
        this.isImmuneToFire = true;
    }

    public EntityFireproofItem(World world, double x, double y, double z, ItemStack stack) {
        super(world, x, y, z);
        this.setEntityItemStack(stack);
        this.isImmuneToFire = true;
    }

    @Override
    protected void dealFireDamage(int damage) {}

    @Override
    public boolean attackEntityFrom(DamageSource source, float damage)
    {
        if (source.isFireDamage()) {
            return false;
        }
        else
            return super.attackEntityFrom(source, damage);
    }

    @Override
    public void onUpdate()
    {
        if(this.isBurning())
            this.extinguish();
        super.onUpdate();
    }
}
