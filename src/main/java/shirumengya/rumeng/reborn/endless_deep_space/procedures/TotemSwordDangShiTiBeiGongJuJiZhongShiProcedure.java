package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.EntityDamageSource;

public class TotemSwordDangShiTiBeiGongJuJiZhongShiProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		entity.hurt(new EntityDamageSource("player", sourceentity).bypassMagic().bypassEnchantments().bypassInvul().bypassArmor(), Float.MAX_VALUE);
	}
}
