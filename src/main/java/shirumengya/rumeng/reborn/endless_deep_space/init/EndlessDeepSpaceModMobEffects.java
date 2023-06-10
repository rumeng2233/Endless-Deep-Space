
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package shirumengya.rumeng.reborn.endless_deep_space.init;

import shirumengya.rumeng.reborn.endless_deep_space.potion.VisualImpairmentMobEffect;
import shirumengya.rumeng.reborn.endless_deep_space.potion.TotemOfUndyingMobEffect;
import shirumengya.rumeng.reborn.endless_deep_space.potion.ShortSightedMobEffect;
import shirumengya.rumeng.reborn.endless_deep_space.potion.SharpEyesMobEffect;
import shirumengya.rumeng.reborn.endless_deep_space.potion.NauseaMobEffect;
import shirumengya.rumeng.reborn.endless_deep_space.potion.ManmachineseparationMobEffect;
import shirumengya.rumeng.reborn.endless_deep_space.potion.InvincibleEffectMobEffect;
import shirumengya.rumeng.reborn.endless_deep_space.potion.EnderErosionProtectionMobEffect;
import shirumengya.rumeng.reborn.endless_deep_space.potion.EnderCurseMobEffect;
import shirumengya.rumeng.reborn.endless_deep_space.potion.ColorfulMobEffect;
import shirumengya.rumeng.reborn.endless_deep_space.EndlessDeepSpaceMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

public class EndlessDeepSpaceModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, EndlessDeepSpaceMod.MODID);
	public static final RegistryObject<MobEffect> INVINCIBLE = REGISTRY.register("invincible", () -> new InvincibleEffectMobEffect());
	public static final RegistryObject<MobEffect> ENDER_EROSION_PROTECTION = REGISTRY.register("ender_erosion_protection", () -> new EnderErosionProtectionMobEffect());
	public static final RegistryObject<MobEffect> ENDER_CURSE = REGISTRY.register("ender_curse", () -> new EnderCurseMobEffect());
	public static final RegistryObject<MobEffect> SHARP_EYES = REGISTRY.register("sharp_eyes", () -> new SharpEyesMobEffect());
	public static final RegistryObject<MobEffect> COLORFUL = REGISTRY.register("colorful", () -> new ColorfulMobEffect());
	public static final RegistryObject<MobEffect> NAUSEA = REGISTRY.register("nausea", () -> new NauseaMobEffect());
	public static final RegistryObject<MobEffect> MAN_MACHINE_SEPARATION = REGISTRY.register("man_machine_separation", () -> new ManmachineseparationMobEffect());
	public static final RegistryObject<MobEffect> SHORT_SIGHTED = REGISTRY.register("short_sighted", () -> new ShortSightedMobEffect());
	public static final RegistryObject<MobEffect> VISUAL_IMPAIRMENT = REGISTRY.register("visual_impairment", () -> new VisualImpairmentMobEffect());
	public static final RegistryObject<MobEffect> TOTEM_OF_UNDYING = REGISTRY.register("totem_of_undying", () -> new TotemOfUndyingMobEffect());
}
