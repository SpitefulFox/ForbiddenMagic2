package fox.spiteful.forbidden.blocks;

import fox.spiteful.forbidden.Forbidden;
import fox.spiteful.forbidden.tile.TileRitualTable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockRitual extends BlockContainer {

    public BlockRitual(){
        super(Material.wood);
        setStepSound(Block.soundTypeStone);
        setHarvestLevel("pickaxe", 0);
        setUnlocalizedName("ritual_table");
        setCreativeTab(Forbidden.tab);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta)
    {
        return new TileRitualTable();
    }

}
