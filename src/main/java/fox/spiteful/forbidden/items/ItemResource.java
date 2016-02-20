package fox.spiteful.forbidden.items;

import fox.spiteful.forbidden.Forbidden;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ItemResource extends Item {

    private static final String[] types = {"vellum"};

    public ItemResource(){
        setHasSubtypes(true);
        setUnlocalizedName("forbidden_resource");
        setMaxDamage(0);
        setCreativeTab(Forbidden.tab);
    }
    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return getUnlocalizedName() + "_" + types[stack.getItemDamage() % types.length];
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs par2CreativeTabs, List<ItemStack> list) {
        for (int x = 0; x < types.length; x++) {
            list.add(new ItemStack(this, 1, x));
        }
    }

    public static String[] getTypes(){
        return types;
    }

}