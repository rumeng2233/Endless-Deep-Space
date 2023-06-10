
package shirumengya.rumeng.reborn.endless_deep_space.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class EnderErosionProtectionMobEffect extends MobEffect {
	public EnderErosionProtectionMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -14099730);
	}

	@Override
	public String getDescriptionId() {
		return "effect.endless_deep_space.ender_erosion_protection";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
