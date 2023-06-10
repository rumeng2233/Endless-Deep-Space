package shirumengya.rumeng.reborn.endless_deep_space.custom.init;

import shirumengya.rumeng.reborn.endless_deep_space.custom.config.*;
import shirumengya.rumeng.reborn.endless_deep_space.EndlessDeepSpaceMod;

import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@Mod.EventBusSubscriber(modid = EndlessDeepSpaceMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ConfigInit {
	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ModLoadingContext.get().registerConfig(Type.COMMON, EndlessDeepSpaceModCommonConfig.SPEC, "endless_deep_space-common.toml");
			ModLoadingContext.get().registerConfig(Type.CLIENT, EndlessDeepSpaceModClientConfig.SPEC, "endless_deep_space-client.toml");
		});
	}
}
