
package shirumengya.rumeng.reborn.endless_deep_space.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class ShortSightedMobEffect extends MobEffect {
	public ShortSightedMobEffect() {
		super(MobEffectCategory.HARMFUL, -39322);
	}

	@Override
	public String getDescriptionId() {
		return "effect.endless_deep_space.short_sighted";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
