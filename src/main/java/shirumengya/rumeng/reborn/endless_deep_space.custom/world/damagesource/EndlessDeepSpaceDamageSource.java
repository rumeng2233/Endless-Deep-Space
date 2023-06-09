package shirumengya.rumeng.reborn.endless_deep_space.custom.world.damagesource;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.damagesource.DamageSource;
import javax.annotation.Nullable;
import net.minecraft.world.damagesource.EntityDamageSource;

public class EndlessDeepSpaceDamageSource {
	public static final DamageSource BROKEN_VALUE = (new DamageSource("broken_value")).bypassArmor().bypassInvul().bypassMagic().bypassEnchantments();
   	public static final DamageSource ENDER_EROSION = (new DamageSource("ender_erosion")).bypassArmor().bypassInvul().bypassMagic().bypassEnchantments();
   	public static DamageSource WrathOfWither(@Nullable Entity p_19371_) {
      	return new EntityDamageSource("wrath_of_wither", p_19371_).bypassMagic().bypassEnchantments().bypassInvul();
   	}
}