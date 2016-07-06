package fox.spiteful.forbidden.items;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ForbiddenItems {

    public static Item resource;
    public static Item demon_chalk;

    public static void enchant(){

        resource = register(new ItemResource(), "resource");
        demon_chalk = register(new ItemChalk(), "demon_chalk");
    }

    public static Item register(Item item, String name){
        item.setRegistryName(name);
        GameRegistry.register(item);
        return item;
    }

}
