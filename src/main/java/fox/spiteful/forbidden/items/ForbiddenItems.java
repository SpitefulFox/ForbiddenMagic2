package fox.spiteful.forbidden.items;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ForbiddenItems {

    public static Item resource;
    public static Item demon_chalk;

    public static void enchant(){

        resource = new ItemResource();
        GameRegistry.registerItem(resource, "resource");
        demon_chalk = new ItemChalk();
        GameRegistry.registerItem(demon_chalk, "demon_chalk");

    }

}
