package fox.spiteful.forbidden;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Loader;
import org.apache.logging.log4j.Level;

import java.io.File;

public class Config {


    public static void configurate(File targ) {

        /*Configuration conf = new Configuration(targ);
        try {
            conf.load();

            thaumaturgy = conf.get("compatibility", "Thaumcraft", true, "Disable to stop all Thaumcraft integration").getBoolean(true) && Loader.isModLoaded("Thaumcraft");

        } catch (Exception e) {
            Lumberjack.log(Level.ERROR, e, "Schools of Magic had a problem loading its configuration.");
        } finally {
            conf.save();
        }*/
    }

}
