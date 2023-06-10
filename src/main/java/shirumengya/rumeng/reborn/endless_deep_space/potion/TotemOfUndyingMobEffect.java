
package shirumengya.rumeng.reborn.endless_deep_space.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class TotemOfUndyingMobEffect extends MobEffect {
	public TotemOfUndyingMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -256);
	}

	@Override
	public String getDescriptionId() {
		return "effect.endless_deep_space.totem_of_undying";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
