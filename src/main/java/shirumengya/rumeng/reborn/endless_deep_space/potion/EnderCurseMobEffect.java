
package shirumengya.rumeng.reborn.endless_deep_space.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.world.item.ItemStack;

public class EnderCurseMobEffect extends MobEffect {
	public EnderCurseMobEffect() {
		super(MobEffectCategory.HARMFUL, -58325);
	}

	@Override
	public String getDescriptionId() {
		return "effect.endless_deep_space.ender_curse";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}

	public List<ItemStack> getCurativeItems() {
	return new ArrayList();
	}
}
