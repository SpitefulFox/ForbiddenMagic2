package fox.spiteful.forbidden.items;

import fox.spiteful.forbidden.Forbidden;
import fox.spiteful.forbidden.blocks.ForbiddenBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemChalk extends Item {

    public ItemChalk(){
        setMaxDamage(50);
        setUnlocalizedName("demon_chalk");
        setCreativeTab(Forbidden.tab);
    }

    /**
     * Called when a Block is right-clicked with this Item
     */
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        IBlockState iblockstate = worldIn.getBlockState(pos);
        Block block = iblockstate.getBlock();

        if (!block.isReplaceable(worldIn, pos))
        {
            pos = pos.offset(side);
        }

        if (!playerIn.canPlayerEdit(pos, side, stack))
        {
            return false;
        }
        else if (stack.stackSize == 0)
        {
            return false;
        }
        else
        {
            if (worldIn.canBlockBePlaced(ForbiddenBlocks.chalk_rune, pos, false, side, (Entity)null, stack))
            {
                IBlockState iblockstate1 = ForbiddenBlocks.chalk_rune.onBlockPlaced(worldIn, pos, side, hitX, hitY, hitZ, 0, playerIn);

                if (worldIn.setBlockState(pos, iblockstate1, 3))
                {
                    iblockstate1 = worldIn.getBlockState(pos);

                    if (iblockstate1.getBlock() == ForbiddenBlocks.chalk_rune)
                    {
                        ItemBlock.setTileEntityNBT(worldIn, playerIn, pos, stack);
                        iblockstate1.getBlock().onBlockPlacedBy(worldIn, pos, iblockstate1, playerIn, stack);
                    }

                    worldIn.playSoundEffect((double)((float)pos.getX() + 0.5F), (double)((float)pos.getY() + 0.5F), (double)((float)pos.getZ() + 0.5F), ForbiddenBlocks.chalk_rune.stepSound.getPlaceSound(), (ForbiddenBlocks.chalk_rune.stepSound.getVolume() + 1.0F) / 2.0F, ForbiddenBlocks.chalk_rune.stepSound.getFrequency() * 0.8F);
                    stack.damageItem(1, playerIn);
                    return true;
                }
            }

            return false;
        }
    }

}
