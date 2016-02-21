package fox.spiteful.forbidden.api.crafting;

import net.minecraft.item.ItemStack;

import java.util.ArrayList;

public class ForbiddenCrafting {

    private static ArrayList<ItemStack> hoomin = new ArrayList<ItemStack>();

    public static boolean isHumanFlesh(ItemStack input){
        for(ItemStack stack : hoomin){
            if(stack.getItem() == input.getItem() && stack.getItemDamage() == input.getItemDamage())
                return true;
        }
        return false;
    }

    public static void addHumanFlesh(ItemStack flesh){
        if(!isHumanFlesh(flesh))
            hoomin.add(flesh);
    }

    public static ArrayList<ItemStack> getListHumanFlesh(){
        return hoomin;
    }

}
