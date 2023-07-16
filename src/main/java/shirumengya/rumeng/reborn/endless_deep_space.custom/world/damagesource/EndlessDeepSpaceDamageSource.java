package shirumengya.rumeng.reborn.endless_deep_space.custom.world.damagesource;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.damagesource.DamageSource;
import javax.annotation.Nullable;
import net.minecraft.world.damagesource.EntityDamageSource;

public class EndlessDeepSpaceDamageSource {
<<<<<<< Updated upstream
	public static final DamageSource BROKEN_VALUE = (new DamageSource("broken_value")).bypassArmor().bypassInvul().bypassMagic().bypassEnchantments();
   	public static final DamageSource ENDER_EROSION = (new DamageSource("ender_erosion")).bypassArmor().bypassInvul().bypassMagic().bypassEnchantments();
=======
	public static final DamageSource BROKEN_VALUE = new DamageSource("broken_value").bypassArmor().bypassInvul().bypassMagic().bypassEnchantments();
   	public static final DamageSource ENDER_EROSION = new DamageSource("ender_erosion").bypassArmor().bypassInvul().bypassMagic().bypassEnchantments();
   	public static final DamageSource FORCE_OF_GRAVITY = new DamageSource("torn_to_shreds_by_the_force_of_gravity").bypassArmor().bypassInvul().bypassMagic().bypassEnchantments();
   	public static final DamageSource COLORFUL_LIGHTNING_BOLT = new DamageSource("colorful_lightning_bolt").bypassArmor().bypassInvul().bypassMagic().bypassEnchantments();
   	/*public static final DamageSource BLEEDING = (new DamageSource("died_from_bleeding")).bypassArmor().bypassInvul().bypassMagic().bypassEnchantments();*/
   	
>>>>>>> Stashed changes
   	public static DamageSource WrathOfWither(@Nullable Entity p_19371_) {
      	return new EntityDamageSource("wrath_of_wither", p_19371_).bypassMagic().bypassEnchantments().bypassInvul();
   	}
   	public static DamageSource ScreamingGhastFirball(@Nullable Entity p_19371_) {
      	return new EntityDamageSource("screaming_ghast_firball", p_19371_).bypassMagic().bypassEnchantments().bypassInvul().bypassArmor();
   	}
}