package shirumengya.rumeng.reborn.endless_deep_space.custom.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffectInstance;

public class PotionInit {
	public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(ForgeRegistries.POTIONS, "endless_deep_space.custom");
	public static final RegistryObject<Potion> DAMAGE_INCREASE_POTIOM = REGISTRY.register("damage_increase_potion",
			() -> new Potion(new MobEffectInstance(MobEffectInit.DAMAGE_INCREASE.get(), 4800, 10, false, true)));
}
