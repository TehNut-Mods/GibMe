package gibme;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

@Mod(modid = ModInformation.ID, name = ModInformation.NAME, version = ModInformation.VERSION, dependencies = ModInformation.DEPEND)
public class GibMe {

    public static Logger logger = LogManager.getLogger(ModInformation.NAME);

    @Mod.Instance
    public static GibMe instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ConfigHandler.init(new File(event.getModConfigurationDirectory(), "༼ つ ◕_◕ ༽つ.cfg"));
        MinecraftForge.EVENT_BUS.register(new EventHandler());
    }
}
