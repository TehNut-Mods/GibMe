package gibme;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigHandler {

    public static Configuration config;

    public static int chanceToGib;
    public static String[] gibMeThese;
    public static String[] gibMeTheseDefault = { "item:minecraft:flint:0:1" };

    public static void init(File file) {
        config = new Configuration(file);
        syncConfig();
    }

    public static void syncConfig() {
        chanceToGib = config.get(Configuration.CATEGORY_GENERAL, "chanceToGib", 20, "Chance in 10000 to gib an item from the list").getInt();
        gibMeThese = config.get(Configuration.CATEGORY_GENERAL, "gibMeThese", gibMeTheseDefault, "List of things to gib. \nSyntax is: \ntype:modid:name:meta:amount \nValid types are 'item' and 'block'").getStringList();

        config.save();
    }
}
