package fox.spiteful.forbidden.items;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ForbiddenItems {

    public static Item resource;

    public static void enchant(){

        resource = new ItemResource();
        GameRegistry.registerItem(resource, "Resource");

    }

}
