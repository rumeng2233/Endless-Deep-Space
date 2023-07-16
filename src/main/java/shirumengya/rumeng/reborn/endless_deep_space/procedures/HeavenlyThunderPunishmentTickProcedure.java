package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModEnchantments;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import javax.annotation.Nullable;
import shirumengya.rumeng.reborn.endless_deep_space.custom.entity.*;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.monster.Monster;

@Mod.EventBusSubscriber
public class HeavenlyThunderPunishmentTickProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity sourceentity) {
		execute(null, world, x, y, z, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity sourceentity) {
		if (sourceentity == null)
			return;
		if (EnchantmentHelper.getItemEnchantmentLevel(EndlessDeepSpaceModEnchantments.HEAVENLY_THUNDER_PUNISHMENT.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Monster.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
						.collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator == sourceentity) && !(entityiterator instanceof ColorfulLightningBolt)) {
						if (world instanceof ServerLevel _level) {
							ColorfulLightningBolt entityToSpawn = new ColorfulLightningBolt(_level, Mth.nextInt(RandomSource.create(), 0, 255), Mth.nextInt(RandomSource.create(), 0, 255), Mth.nextInt(RandomSource.create(), 0, 255));
							entityToSpawn.setPos(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ());
							entityToSpawn.setVisualOnly(false);
							entityToSpawn.setDamage(2.0F);
							_level.addFreshEntity(entityToSpawn);
						}
					}
				}
			}
		}
	}
}
