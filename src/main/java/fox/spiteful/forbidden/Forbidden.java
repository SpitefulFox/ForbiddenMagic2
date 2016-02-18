package fox.spiteful.forbidden;

import fox.spiteful.forbidden.blocks.ForbiddenBlocks;
import fox.spiteful.forbidden.items.ForbiddenItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(
        modid = "ForbiddenMagic",
        name = "Forbidden Magic 2"
)
public class Forbidden {

    @Mod.Instance("SchoolsMagic")
    public static Forbidden instance;
    @SidedProxy(clientSide = "fox.spiteful.forbidden.client.ClientProxy", serverSide = "fox.spiteful.forbidden.Proxy")
    public static Proxy proxy;

    @Mod.EventHandler
    public void bell(FMLPreInitializationEvent event)
    {
        instance = this;
        Config.configurate(event.getSuggestedConfigurationFile());
        ForbiddenItems.enchant();
        ForbiddenBlocks.carveMonolith();
        proxy.stupidJsonBullshit();
    }

    @Mod.EventHandler
    public void book(FMLInitializationEvent event)
    {

        MinecraftForge.EVENT_BUS.register(new FMEventHandler());
    }

    @Mod.EventHandler
    public void candle(FMLPostInitializationEvent event)
    {

    }


}
