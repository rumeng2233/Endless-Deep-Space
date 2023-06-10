
package shirumengya.rumeng.reborn.endless_deep_space.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.world.item.ItemStack;

public class InvincibleEffectMobEffect extends MobEffect {
	public InvincibleEffectMobEffect() {
		super(MobEffectCategory.NEUTRAL, -65536);
	}

	@Override
	public String getDescriptionId() {
		return "effect.endless_deep_space.invincible";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}

	public List<ItemStack> getCurativeItems() {
    return new ArrayList();
	}
}
