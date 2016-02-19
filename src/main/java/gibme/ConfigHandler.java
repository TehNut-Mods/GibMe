package gibme;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigHandler {

    public static Configuration config;

    public static double chanceToGib;
    public static int attemptCooldown;
    public static String[] gibMeThese;
    public static String[] gibMeTheseDefault = { "minecraft:flint:0:1" };

    public static void init(File file) {
        config = new Configuration(file);
        syncConfig();
    }

    public static void syncConfig() {
        attemptCooldown = config.get(Configuration.CATEGORY_GENERAL, "attemptCooldown", 1, "Seconds between each attempt to gib.").getInt();
        chanceToGib = config.get(Configuration.CATEGORY_GENERAL, "chanceToGib", 0.2, "Chance to gib an item from the list").getDouble();
        gibMeThese = config.get(Configuration.CATEGORY_GENERAL, "gibMeThese", gibMeTheseDefault, "List of things to gib.\nSyntax is:\nmodid:name:meta:amount").getStringList();

        config.save();
    }
}