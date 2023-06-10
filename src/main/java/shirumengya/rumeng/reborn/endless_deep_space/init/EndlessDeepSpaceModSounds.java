
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package shirumengya.rumeng.reborn.endless_deep_space.init;

import shirumengya.rumeng.reborn.endless_deep_space.EndlessDeepSpaceMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

public class EndlessDeepSpaceModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, EndlessDeepSpaceMod.MODID);
	public static final RegistryObject<SoundEvent> ENTITY_MAD_WITCH_BLOCK = REGISTRY.register("entity.mad_witch.block", () -> new SoundEvent(new ResourceLocation("endless_deep_space", "entity.mad_witch.block")));
	public static final RegistryObject<SoundEvent> MUSIC_SEE = REGISTRY.register("music.see", () -> new SoundEvent(new ResourceLocation("endless_deep_space", "music.see")));
	public static final RegistryObject<SoundEvent> MUSIC_DISC_INTERTWINED = REGISTRY.register("music_disc.intertwined", () -> new SoundEvent(new ResourceLocation("endless_deep_space", "music_disc.intertwined")));
	public static final RegistryObject<SoundEvent> MUSIC_DISC_THE_LOST = REGISTRY.register("music_disc.the_lost", () -> new SoundEvent(new ResourceLocation("endless_deep_space", "music_disc.the_lost")));
	public static final RegistryObject<SoundEvent> NEVER_GONNA_GIVE_YOU_UP = REGISTRY.register("never_gonna_give_you_up", () -> new SoundEvent(new ResourceLocation("endless_deep_space", "never_gonna_give_you_up")));
	public static final RegistryObject<SoundEvent> GENSHIN_IMPACT_MAIN_THEME = REGISTRY.register("genshin_impact_main_theme", () -> new SoundEvent(new ResourceLocation("endless_deep_space", "genshin_impact_main_theme")));
	public static final RegistryObject<SoundEvent> C418_0X10C = REGISTRY.register("c418_0x10c", () -> new SoundEvent(new ResourceLocation("endless_deep_space", "c418_0x10c")));
}
