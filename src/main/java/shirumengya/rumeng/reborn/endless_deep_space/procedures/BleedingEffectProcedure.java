package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModEnchantments;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.CompoundTag;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BleedingEffectProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level, event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (!world.isClientSide()) {
			if (EnchantmentHelper.getItemEnchantmentLevel(EndlessDeepSpaceModEnchantments.BLEEDING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
				if (Math.random() < 0.2) {
					CompoundTag dataIndex6 = new CompoundTag();
					entity.saveWithoutId(dataIndex6);
					dataIndex6.putDouble("BleedTime", (new Object() {
						public double getValue() {
							CompoundTag dataIndex3 = new CompoundTag();
							entity.saveWithoutId(dataIndex3);
							return dataIndex3.getDouble("BleedTime");
						}
					}.getValue() + EnchantmentHelper.getItemEnchantmentLevel(EndlessDeepSpaceModEnchantments.BLEEDING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) * 2));
					entity.load(dataIndex6);
					CompoundTag dataIndex10 = new CompoundTag();
					entity.saveWithoutId(dataIndex10);
					dataIndex10.putDouble("BleedLevel", (new Object() {
						public double getValue() {
							CompoundTag dataIndex7 = new CompoundTag();
							entity.saveWithoutId(dataIndex7);
							return dataIndex7.getDouble("BleedLevel");
						}
					}.getValue() + EnchantmentHelper.getItemEnchantmentLevel(EndlessDeepSpaceModEnchantments.BLEEDING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))));
					entity.load(dataIndex10);
				}
			}
		}
	}
}
