package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BleedingAttributesAddProcedure {
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
			if (entity instanceof LivingEntity && ((LivingEntity) sourceentity).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("endless_deep_space:bleeding_during_attack_probability"))) != null && entity instanceof LivingEntity
					&& ((LivingEntity) sourceentity).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("endless_deep_space:number_of_bleeding_during_attack"))) != null && entity instanceof LivingEntity
					&& ((LivingEntity) sourceentity).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("endless_deep_space:bleeding_damage_during_attack"))) != null) {
				if (Math.random() < ((LivingEntity) sourceentity).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("endless_deep_space:bleeding_during_attack_probability"))).getValue()) {
					CompoundTag dataIndex7 = new CompoundTag();
					entity.saveWithoutId(dataIndex7);
					dataIndex7.putDouble("BleedTime", (new Object() {
						public double getValue() {
							CompoundTag dataIndex5 = new CompoundTag();
							entity.saveWithoutId(dataIndex5);
							return dataIndex5.getDouble("BleedTime");
						}
					}.getValue() + ((LivingEntity) sourceentity).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("endless_deep_space:number_of_bleeding_during_attack"))).getValue()));
					entity.load(dataIndex7);
					CompoundTag dataIndex10 = new CompoundTag();
					entity.saveWithoutId(dataIndex10);
					dataIndex10.putDouble("BleedLevel", (new Object() {
						public double getValue() {
							CompoundTag dataIndex8 = new CompoundTag();
							entity.saveWithoutId(dataIndex8);
							return dataIndex8.getDouble("BleedLevel");
						}
					}.getValue() + ((LivingEntity) sourceentity).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("endless_deep_space:bleeding_damage_during_attack"))).getValue()));
					entity.load(dataIndex10);
				}
			}
		}
	}
}
