
package shirumengya.rumeng.reborn.endless_deep_space.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class NauseaMobEffect extends MobEffect {
	public NauseaMobEffect() {
		super(MobEffectCategory.HARMFUL, -3342490);
	}

	@Override
	public String getDescriptionId() {
		return "effect.endless_deep_space.nausea";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
