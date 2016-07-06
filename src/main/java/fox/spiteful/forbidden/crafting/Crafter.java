package fox.spiteful.forbidden.crafting;

import fox.spiteful.forbidden.api.crafting.ForbiddenCrafting;
import fox.spiteful.forbidden.items.ForbiddenItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Crafter {

    public static void artsAndCrafts(){

        GameRegistry.addShapelessRecipe(new ItemStack(ForbiddenItems.demon_chalk, 1, 0),
                new ItemStack(Items.CLAY_BALL), new ItemStack(Items.REDSTONE),
                new ItemStack(Items.COAL, 1, 1), new ItemStack(ForbiddenItems.resource, 1, 1));

        ForbiddenCrafting.addHumanFlesh(new ItemStack(Items.ROTTEN_FLESH));
        ForbiddenCrafting.addHumanFlesh(new ItemStack(Items.BONE));
        ForbiddenCrafting.addHumanFlesh(new ItemStack(Blocks.SKULL, 1, 0));
        ForbiddenCrafting.addHumanFlesh(new ItemStack(Blocks.SKULL, 1, 1));
        ForbiddenCrafting.addHumanFlesh(new ItemStack(Blocks.SKULL, 1, 2));
        ForbiddenCrafting.addHumanFlesh(new ItemStack(Blocks.SKULL, 1, 3));
    }
}
