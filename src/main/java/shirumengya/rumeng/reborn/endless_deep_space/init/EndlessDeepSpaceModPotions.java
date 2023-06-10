
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package shirumengya.rumeng.reborn.endless_deep_space.init;

import shirumengya.rumeng.reborn.endless_deep_space.EndlessDeepSpaceMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffectInstance;

public class EndlessDeepSpaceModPotions {
	public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(ForgeRegistries.POTIONS, EndlessDeepSpaceMod.MODID);
	public static final RegistryObject<Potion> ENDER_EROSION_PROTECTION_POTIOM_SHORT = REGISTRY.register("ender_erosion_protection_potiom_short",
			() -> new Potion(new MobEffectInstance(EndlessDeepSpaceModMobEffects.ENDER_EROSION_PROTECTION.get(), 4800, 0, false, true)));
	public static final RegistryObject<Potion> ENDER_EROSION_PROTECTION_POTIOM_MEDIUM = REGISTRY.register("ender_erosion_protection_potiom_medium",
			() -> new Potion(new MobEffectInstance(EndlessDeepSpaceModMobEffects.ENDER_EROSION_PROTECTION.get(), 9600, 0, false, true)));
	public static final RegistryObject<Potion> ENDER_EROSION_PROTECTION_POTIOM_LONG = REGISTRY.register("ender_erosion_protection_potiom_long",
			() -> new Potion(new MobEffectInstance(EndlessDeepSpaceModMobEffects.ENDER_EROSION_PROTECTION.get(), 14400, 0, false, true)));
}
