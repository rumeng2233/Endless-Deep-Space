package shirumengya.rumeng.reborn.endless_deep_space.custom.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class EndlessDeepSpaceModClientConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;
    public static final ForgeConfigSpec.ConfigValue<Boolean> SEND_TO_TOP_OF_THE_HOTBAR;
    public static final ForgeConfigSpec.ConfigValue<Integer> STAR_CUBE_RENDERING_DISTANCE;
    public static final ForgeConfigSpec.ConfigValue<Integer> GUIDING_STONE_RENDERING_DISTANCE;
    public static final ForgeConfigSpec.ConfigValue<Double> GUIDING_STONE_BEAM_RENDERING_HEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Double> GUIDING_STONE_BEAM_INNER_RADIUS;
    public static final ForgeConfigSpec.ConfigValue<Double> GUIDING_STONE_BEAM_OUTER_RADIUS;
    public static final ForgeConfigSpec.ConfigValue<Double> ENCHANTING_TABLE_BOOK_FLOATS_UP_AND_DOWN_SPEED_ONE;
    public static final ForgeConfigSpec.ConfigValue<Double> ENCHANTING_TABLE_BOOK_FLOATS_UP_AND_DOWN_SPEED_TWO;
    public static final ForgeConfigSpec.ConfigValue<Double> ENCHANTING_TABLE_BOOK_FLOATS_UP_AND_DOWN_SPEED_THREE;
    public static final ForgeConfigSpec.ConfigValue<Boolean> ENCHANTING_TABLE_BOOK_REVERSE_ROTATION;
    public static final ForgeConfigSpec.ConfigValue<Double> ENCHANTING_TABLE_BOOK_ROTATION_DOUBLE_SPEED;
    public static final ForgeConfigSpec.ConfigValue<Boolean> P_M_V_R_B;
    public static final ForgeConfigSpec.ConfigValue<Integer> P_M_V_M_S;
    public static final ForgeConfigSpec.ConfigValue<Integer> P_M_V_R_M_S;
    public static final ForgeConfigSpec.ConfigValue<Boolean> P_M_V_E_R_M_S;
    public static final ForgeConfigSpec.ConfigValue<Integer> P_M_V_R_M_P_X;
    public static final ForgeConfigSpec.ConfigValue<Integer> P_M_V_R_M_P_Y;
    public static final ForgeConfigSpec.ConfigValue<Boolean> O_C_R_T_C;
    public static final ForgeConfigSpec.ConfigValue<Boolean> O_C_R_T_P;
    public static final ForgeConfigSpec.ConfigValue<Integer> C_R_T_P_X;
    public static final ForgeConfigSpec.ConfigValue<Integer> C_R_T_P_Y;
    public static final ForgeConfigSpec.ConfigValue<Boolean> O_C_R_T_C_B;
    public static final ForgeConfigSpec.ConfigValue<Integer> C_R_T_C_B;
    public static final ForgeConfigSpec.ConfigValue<Integer> C_R_T_C_B_S;
    public static final ForgeConfigSpec.ConfigValue<Integer> C_R_T_C_B_E;
    public static final ForgeConfigSpec.ConfigValue<Integer> C_R_T_C_BO_S;
    public static final ForgeConfigSpec.ConfigValue<Integer> C_R_T_C_BO_E;
    public static final ForgeConfigSpec.ConfigValue<Boolean> O_C_R_T_M_W;
    public static final ForgeConfigSpec.ConfigValue<Integer> C_R_T_M_W;

    static {
        BUILDER.push("Endless Deep Space Mod Client Config");

        SEND_TO_TOP_OF_THE_HOTBAR = BUILDER.comment("Send info to the top of the player's hotbar")
                .define("Send to the top of the player's hotbar", false);
        STAR_CUBE_RENDERING_DISTANCE = BUILDER.comment("The maximum rendering distance of the Star Cube")
                .define("Star Cube rendering distance", 256);
        GUIDING_STONE_RENDERING_DISTANCE = BUILDER.comment("The maximum rendering distance of the Guiding Stone")
                .define("Guiding Stone rendering distance", 256);
        GUIDING_STONE_BEAM_RENDERING_HEIGHT = BUILDER.comment("Guiding Stone beam maximum rendering height")
                .define("Guiding Stone beam maximum rendering height", 320.0);
		GUIDING_STONE_BEAM_INNER_RADIUS = BUILDER.comment("Guiding Stone beam inner radius")
                .define("Guiding Stone beam inner radius", 0.15);
        GUIDING_STONE_BEAM_OUTER_RADIUS = BUILDER.comment("Guiding Stone beam outer radius")
                .define("Guiding Stone beam outer radius", 0.175);
        ENCHANTING_TABLE_BOOK_FLOATS_UP_AND_DOWN_SPEED_ONE = BUILDER.comment("Enchanting Table Book floats up and down speed one")
                .define("Enchanting Table Book floats up and down speed one", 0.1);
        ENCHANTING_TABLE_BOOK_FLOATS_UP_AND_DOWN_SPEED_TWO = BUILDER.comment("Enchanting Table Book floats up and down speed two")
                .define("Enchanting Table Book floats up and down speed two", 0.1);
        ENCHANTING_TABLE_BOOK_FLOATS_UP_AND_DOWN_SPEED_THREE = BUILDER.comment("Enchanting Table Book floats up and down speed three")
                .define("Enchanting Table Book floats up and down speed three", 0.01);
        ENCHANTING_TABLE_BOOK_REVERSE_ROTATION = BUILDER.comment("Enchanting Table Book reverse rotation")
                .define("Enchanting Table Book reverse rotation", false);
        ENCHANTING_TABLE_BOOK_ROTATION_DOUBLE_SPEED = BUILDER.comment("Enchanting Table Book rotation double speed")
                .define("Enchanting Table Book rotation double speed", 1.0);
        P_M_V_R_B = BUILDER.comment("Player model viewer render background")
                .define("Player model viewer render background", true);
        P_M_V_M_S = BUILDER.comment("Player model viewer model size")
                .define("Player model viewer model size", 80);
        P_M_V_R_M_S = BUILDER.comment("Player model viewer relative model size")
                .define("Player model viewer relative model size", 3);
        P_M_V_E_R_M_S = BUILDER.comment("Player Model Viewer Enable Relative Model Size")
                .define("Player Model Viewer Enable Relative Model Size", false);
        P_M_V_R_M_P_X = BUILDER.comment("Player model viewer relative model position X")
                .define("Player model viewer relative model position X", 0);
        P_M_V_R_M_P_Y = BUILDER.comment("Player model viewer relative model position Y")
                .define("Player model viewer relative model position Y", 70);
        O_C_R_T_C = BUILDER.comment("Open the Custom Render Tooltip Color")
                .define("Open the Custom Render Tooltip Color", true);
        O_C_R_T_P = BUILDER.comment("Open the Custom Render Tooltip Pre")
                .define("Open the Custom Render Tooltip Pre", true);
		C_R_T_P_X = BUILDER.comment("Sets the X origin of the Custom Tooltip")
                .define("Sets the X origin of the Custom Tooltip", 0);
        C_R_T_P_Y = BUILDER.comment("Sets the Y origin of the Custom Tooltip")
                .define("Sets the Y origin of the Custom Tooltip", 20);
        O_C_R_T_C_B = BUILDER.comment("Open the Custom Render Tooltip Color Background")
                .define("Open the Custom Render Tooltip Color Background", true);
        C_R_T_C_B = BUILDER.comment("Sets the new color for the tooltip background.This sets both the gradient start and end color for the background to this color")
                .define("Sets the new color for the tooltip background.This sets both the gradient start and end color for the background to this color", -267386864);
        C_R_T_C_B_S = BUILDER.comment("Sets the new start color for the gradient of the tooltip background")
                .define("Sets the new start color for the gradient of the tooltip background", 0);
        C_R_T_C_B_E = BUILDER.comment("Sets the new end color for the gradient of the tooltip background")
                .define("Sets the new end color for the gradient of the tooltip background", 0);
        C_R_T_C_BO_S = BUILDER.comment("Sets the new start color for the gradient of the tooltip Border")
                .define("Sets the new start color for the gradient of the tooltip Border", -114514);
        C_R_T_C_BO_E = BUILDER.comment("Sets the new end color for the gradient of the tooltip Border")
                .define("Sets the new end color for the gradient of the tooltip Border", -114514);
        O_C_R_T_M_W = BUILDER.comment("Open the Custom Render Tooltip Max Width")
                .define("Open the Custom Render Tooltip Max Width", false);
        C_R_T_M_W = BUILDER.comment("Sets the maximum width of the tooltip.Use -1 for unlimited maximum width")
                .define("Sets the maximum width of the tooltip.Use -1 for unlimited maximum width", -1);
        
        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
