
package shirumengya.rumeng.reborn.endless_deep_space.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class ManmachineseparationMobEffect extends MobEffect {
	public ManmachineseparationMobEffect() {
		super(MobEffectCategory.HARMFUL, -13108);
	}

	@Override
	public String getDescriptionId() {
		return "effect.endless_deep_space.man_machine_separation";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
