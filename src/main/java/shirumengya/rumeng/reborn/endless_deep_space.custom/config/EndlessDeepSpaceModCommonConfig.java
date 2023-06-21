package shirumengya.rumeng.reborn.endless_deep_space.custom.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class EndlessDeepSpaceModCommonConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;
    public static final ForgeConfigSpec.ConfigValue<Boolean> MAD_WITCH_IMMUNE;
    public static final ForgeConfigSpec.ConfigValue<Integer> BROKEN_VALUE_MAX;
    public static final ForgeConfigSpec.ConfigValue<Double> ENDER_EROSION_GROWTH_RATE;
    public static final ForgeConfigSpec.ConfigValue<Integer> CONVERSION_ITEM_TIME;
    public static final ForgeConfigSpec.ConfigValue<Double> ENDER_CURSE_INCREASES_CHANCE;
    public static final ForgeConfigSpec.ConfigValue<Double> ENDER_EROSION_PROTECTION_REDUCES_CHANCE;
    public static final ForgeConfigSpec.ConfigValue<Double> GAIN_ENDER_CURSE_WHEN_ATTACKED_IN_THE_END;
    public static final ForgeConfigSpec.ConfigValue<Integer> GAIN_ENDER_CURSE_SECONDS_WHEN_ATTACKED_IN_THE_END;
    public static final ForgeConfigSpec.ConfigValue<Boolean> ALLOWS_ENDLESS_DEEP_SPACE_MOD_TO_EXECUTE_JAVA_COMMANDS;
    public static final ForgeConfigSpec.ConfigValue<Boolean> KICK_PLAYER_IN_HARDCORE;
    public static final ForgeConfigSpec.ConfigValue<Double> BEST_SHARPNESS_BASE_DAMAGE_INCREASED;
    public static final ForgeConfigSpec.ConfigValue<Double> BEST_SHARPNESS_BONUS_DAMAGE_INCREASED;
    public static final ForgeConfigSpec.ConfigValue<Integer> FILL_BIG_MAX_FILL_AREA;
    public static final ForgeConfigSpec.ConfigValue<Integer> CLONE_BIG_MAX_CLONE_AREA;
    public static final ForgeConfigSpec.ConfigValue<Integer> GIVE_MORE_MAX_FILL_AREA;
    public static final ForgeConfigSpec.ConfigValue<Boolean> SCREAMING_GHAST_CANNOT_REGENERATE_HEALTH;

    static {
        BUILDER.push("Endless Deep Space Mod Common Config");
        
        MAD_WITCH_IMMUNE = BUILDER.comment("Mad Witch are immune to damage other than players")
                .define("Mad Witch Immune", true);

        BROKEN_VALUE_MAX = BUILDER.comment("The maximum broken value")
                .define("Broken Value Max", 6000);

        ENDER_EROSION_GROWTH_RATE = BUILDER.comment("Growth rate of Ender Erosion per game tick")
                .define("Ender Erosion growth rate", 0.001);

        CONVERSION_ITEM_TIME = BUILDER.comment("Conversion Table conversion item time")
                .define("Conversion Item Time", 200);

        ENDER_CURSE_INCREASES_CHANCE = BUILDER.comment("Ender Curse increases chance of Ender Erosion")
                .define("Ender Curse increases chance of Ender Erosion", 0.04);

        ENDER_EROSION_PROTECTION_REDUCES_CHANCE = BUILDER.comment("Ender Erosion Protection reduces Ender Erosion chance")
                .define("Ender Erosion Protection reduces Ender Erosion chance", 0.005);

        GAIN_ENDER_CURSE_WHEN_ATTACKED_IN_THE_END = BUILDER.comment("Player gain Ender Curse chance when attacked in the end")
                .define("Player gain Ender Curse chance when attacked in the end", 0.05);

        GAIN_ENDER_CURSE_SECONDS_WHEN_ATTACKED_IN_THE_END = BUILDER.comment("Increases the number of seconds of Ender Erosion when the player is attacked in the end")
                .define("Increases the number of seconds of Ender Erosion when the player is attacked in the end", 30);

        ALLOWS_ENDLESS_DEEP_SPACE_MOD_TO_EXECUTE_JAVA_COMMANDS = BUILDER.comment("WARNING: Setting this parameter to true will allow Endless Deep Space Mod to execute Java commands, and the author is not responsible for any accidents that occur after setting this to true!")
                .define("Allows Endless Deep Space Mod to execute Java commands", false);

        KICK_PLAYER_IN_HARDCORE = BUILDER.comment("If the player dies in Hardcore mode, he will no longer be able to enter that save")
                .define("If the player dies in Hardcore mode, he will no longer be able to enter that save", true);

        BEST_SHARPNESS_BASE_DAMAGE_INCREASED = BUILDER.comment("Best Sharpness base damage increased")
                .define("Best Sharpness base damage increased", 13606829811.0);

        BEST_SHARPNESS_BONUS_DAMAGE_INCREASED = BUILDER.comment("Best Sharpness increases bonus damage per level")
                .define("Best Sharpness increases bonus damage per level", 13738609715.0);

        FILL_BIG_MAX_FILL_AREA = BUILDER.comment("The fill_big command max fill area")
                .define("fill_big command max fill area", 32768);

        CLONE_BIG_MAX_CLONE_AREA = BUILDER.comment("The clone_big command max clone area")
                .define("clone_big command max clone area", 32768);

        GIVE_MORE_MAX_FILL_AREA = BUILDER.comment("The give_more command max give area")
                .define("give_more command max give area", 100);

         SCREAMING_GHAST_CANNOT_REGENERATE_HEALTH = BUILDER.comment("If disabled, the Screaming Ghast will be able to restore health")
                .define("Screaming Ghast cannot regenerate health", true);
        
        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
