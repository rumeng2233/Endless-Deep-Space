
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package shirumengya.rumeng.reborn.endless_deep_space.init;

import shirumengya.rumeng.reborn.endless_deep_space.enchantment.SharpnessWeakenedEnchantment;
import shirumengya.rumeng.reborn.endless_deep_space.enchantment.RepairCostReducedEnchantment;
import shirumengya.rumeng.reborn.endless_deep_space.enchantment.DamageReductionEnchantmentEnchantment;
import shirumengya.rumeng.reborn.endless_deep_space.enchantment.DamageIncreaseEnchantment;
import shirumengya.rumeng.reborn.endless_deep_space.enchantment.CannotMinePickaxeEnchantment;
import shirumengya.rumeng.reborn.endless_deep_space.enchantment.CanNotPickUpEnchantment;
import shirumengya.rumeng.reborn.endless_deep_space.enchantment.BetterSharpnessEnchantment;
import shirumengya.rumeng.reborn.endless_deep_space.enchantment.BetterProtectionEnchantment;
import shirumengya.rumeng.reborn.endless_deep_space.enchantment.BestSharpnessEnchantment;
import shirumengya.rumeng.reborn.endless_deep_space.EndlessDeepSpaceMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.enchantment.Enchantment;

public class EndlessDeepSpaceModEnchantments {
	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, EndlessDeepSpaceMod.MODID);
	public static final RegistryObject<Enchantment> BETTER_SHARPNESS = REGISTRY.register("better_sharpness", () -> new BetterSharpnessEnchantment());
	public static final RegistryObject<Enchantment> BEST_SHARPNESS = REGISTRY.register("best_sharpness", () -> new BestSharpnessEnchantment());
	public static final RegistryObject<Enchantment> CAN_NOT_PICK_UP = REGISTRY.register("can_not_pick_up", () -> new CanNotPickUpEnchantment());
	public static final RegistryObject<Enchantment> SHARPNESS_WEAKENED = REGISTRY.register("sharpness_weakened", () -> new SharpnessWeakenedEnchantment());
	public static final RegistryObject<Enchantment> REPAIR_COST_REDUCED = REGISTRY.register("repair_cost_reduced", () -> new RepairCostReducedEnchantment());
	public static final RegistryObject<Enchantment> CANNOT_MINE = REGISTRY.register("cannot_mine", () -> new CannotMinePickaxeEnchantment());
	public static final RegistryObject<Enchantment> DAMAGE_INCREASE = REGISTRY.register("damage_increase", () -> new DamageIncreaseEnchantment());
	public static final RegistryObject<Enchantment> BETTER_PROTECTION = REGISTRY.register("better_protection", () -> new BetterProtectionEnchantment());
	public static final RegistryObject<Enchantment> DAMAGE_REDUCTION = REGISTRY.register("damage_reduction", () -> new DamageReductionEnchantmentEnchantment());
}
