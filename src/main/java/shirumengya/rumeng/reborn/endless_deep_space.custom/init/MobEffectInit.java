package shirumengya.rumeng.reborn.endless_deep_space.custom.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import shirumengya.rumeng.reborn.endless_deep_space.custom.init.EndlessDeepSpaceModAttributes;
import net.minecraft.world.effect.MobEffectCategory;
import shirumengya.rumeng.reborn.endless_deep_space.custom.potion.*;

public class MobEffectInit {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, "endless_deep_space.custom");
	public static final RegistryObject<MobEffect> DAMAGE_REDUCTION = REGISTRY.register("damage_reduction", () -> new AttributeEffect(MobEffectCategory.BENEFICIAL, -3355444, EndlessDeepSpaceModAttributes.DAMAGE_REDUCTION.get(), "16ef6614-38da-439c-8e71-a922bed92b87", 2.0D, AttributeModifier.Operation.ADDITION));
	public static final RegistryObject<MobEffect> DAMAGE_INCREASE = REGISTRY.register("damage_increase", () -> new AttributeEffect(MobEffectCategory.HARMFUL, -3355444, EndlessDeepSpaceModAttributes.DAMAGE_REDUCTION.get(), "31812b62-1133-4868-8803-7b02e20f11fd", -2.0D, AttributeModifier.Operation.ADDITION));
}
