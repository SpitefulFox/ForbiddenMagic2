package fox.spiteful.forbidden.blocks;

import fox.spiteful.forbidden.Forbidden;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ForbiddenBlocks {

    public static Block ritual_table;
    public static Block chalk_rune;

    public static void carveMonolith(){

        chalk_rune = new BlockChalk();
        GameRegistry.registerBlock(chalk_rune, ItemBlockNope.class, "chalk_rune");
        ritual_table = new BlockRitual();
        GameRegistry.registerBlock(ritual_table, "ritual_table");

    }

}
