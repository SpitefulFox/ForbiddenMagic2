package fox.spiteful.forbidden.api.crafting;

import net.minecraft.item.ItemStack;

import java.util.ArrayList;

public class ForbiddenCrafting {

    private static ArrayList<ItemStack> hoomin = new ArrayList<ItemStack>();

    public static boolean isHumanFlesh(ItemStack input){
        for(ItemStack stack : hoomin){
            if(stack.isItemEqual(input))
                return true;
        }
        return false;
    }

    public static void addHumanFlesh(ItemStack flesh){
        if(!isHumanFlesh(flesh))
            hoomin.add(flesh.copy());
    }

    public static ArrayList<ItemStack> getListHumanFlesh(){
        return hoomin;
    }

}
