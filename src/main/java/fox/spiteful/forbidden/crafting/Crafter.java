package fox.spiteful.forbidden.crafting;

import fox.spiteful.forbidden.api.crafting.ForbiddenCrafting;
import fox.spiteful.forbidden.items.ForbiddenItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Crafter {

    public static void artsAndCrafts(){

        GameRegistry.addShapelessRecipe(new ItemStack(ForbiddenItems.demon_chalk, 1, 0), new ItemStack(Items.clay_ball), new ItemStack(Items.redstone), new ItemStack(Items.coal, 1, 1), new ItemStack(ForbiddenItems.resource, 1, 1));

        ForbiddenCrafting.addHumanFlesh(new ItemStack(Items.rotten_flesh));
        ForbiddenCrafting.addHumanFlesh(new ItemStack(Items.bone));
        ForbiddenCrafting.addHumanFlesh(new ItemStack(Items.skull, 1, 0));
        ForbiddenCrafting.addHumanFlesh(new ItemStack(Items.skull, 1, 1));
        ForbiddenCrafting.addHumanFlesh(new ItemStack(Items.skull, 1, 2));
        ForbiddenCrafting.addHumanFlesh(new ItemStack(Items.skull, 1, 3));
    }
}
