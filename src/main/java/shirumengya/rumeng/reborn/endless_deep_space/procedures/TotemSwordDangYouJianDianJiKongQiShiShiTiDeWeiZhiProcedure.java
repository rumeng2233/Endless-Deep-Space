package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.world.InteractionHand;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;
import net.minecraft.world.damagesource.EntityDamageSource;
import shirumengya.rumeng.reborn.endless_deep_space.custom.entity.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.core.BlockPos;

public class TotemSwordDangYouJianDianJiKongQiShiShiTiDeWeiZhiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (Screen.hasAltDown() == true && Screen.hasControlDown() == true) {
			{
				final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
						.collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator == entity) && !(entityiterator instanceof ColorfulLightningBolt)) {
						if (world instanceof ServerLevel _level) {
							ColorfulLightningBolt entityToSpawn = new ColorfulLightningBolt(_level, Mth.nextInt(RandomSource.create(), 0, 255), Mth.nextInt(RandomSource.create(), 0, 255), Mth.nextInt(RandomSource.create(), 0, 255));
							entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ())));
							entityToSpawn.setVisualOnly(false);
							entityToSpawn.setDamage(Float.MAX_VALUE);
							_level.addFreshEntity(entityToSpawn);
						}
					}
					if (entityiterator instanceof Player == false) {
						if (!entityiterator.level.isClientSide())
							entityiterator.discard();
							if (entity instanceof LivingEntity _entity)
							_entity.swing(InteractionHand.MAIN_HAND, true);
					}
				}
			}
		} else if (Screen.hasAltDown() == true) {
			{
				final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
						.collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator == entity) && !(entityiterator instanceof ColorfulLightningBolt)) {
						if (world instanceof ServerLevel _level) {
							ColorfulLightningBolt entityToSpawn = new ColorfulLightningBolt(_level, Mth.nextInt(RandomSource.create(), 0, 255), Mth.nextInt(RandomSource.create(), 0, 255), Mth.nextInt(RandomSource.create(), 0, 255));
							entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ())));
							entityToSpawn.setVisualOnly(true);
							entityToSpawn.setDamage(Float.MAX_VALUE);
							_level.addFreshEntity(entityToSpawn);
						}
					}
					if (!(entityiterator == entity)) {
						entityiterator.hurt(new EntityDamageSource("player", entity).bypassMagic().bypassEnchantments().bypassInvul().bypassArmor(), Float.MAX_VALUE);
						if (entity instanceof LivingEntity _entity)
						_entity.swing(InteractionHand.MAIN_HAND, true);
					}
				}
			}
		} else if (Screen.hasControlDown() == true) {
			{
				final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
						.collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator == entity) && !(entityiterator instanceof ColorfulLightningBolt)) {
						if (world instanceof ServerLevel _level) {
							ColorfulLightningBolt entityToSpawn = new ColorfulLightningBolt(_level, Mth.nextInt(RandomSource.create(), 0, 255), Mth.nextInt(RandomSource.create(), 0, 255), Mth.nextInt(RandomSource.create(), 0, 255));
							entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ())));
							entityToSpawn.setVisualOnly(false);
							entityToSpawn.setDamage(Float.MAX_VALUE);
							_level.addFreshEntity(entityToSpawn);
						}
					}
					if (!(entityiterator == entity)) {
						if (entityiterator instanceof LivingEntity _entity)
							_entity.setHealth(0);
							if (entity instanceof LivingEntity _entity_)
							_entity_.swing(InteractionHand.MAIN_HAND, true);
					}
				}
			}
		} else if (Screen.hasShiftDown() == true) {
			{
				final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
						.collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator == entity) && !(entityiterator instanceof ColorfulLightningBolt)) {
						if (world instanceof ServerLevel _level) {
							ColorfulLightningBolt entityToSpawn = new ColorfulLightningBolt(_level, Mth.nextInt(RandomSource.create(), 0, 255), Mth.nextInt(RandomSource.create(), 0, 255), Mth.nextInt(RandomSource.create(), 0, 255));
							entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ())));
							entityToSpawn.setVisualOnly(true);
							entityToSpawn.setDamage(Float.MAX_VALUE);
							_level.addFreshEntity(entityToSpawn);
						}
					}
					if (entityiterator instanceof Player == false) {
						if (entityiterator instanceof Mob _entity)
							_entity.setNoAi(true);
							if (entity instanceof LivingEntity _entity_)
							_entity_.swing(InteractionHand.MAIN_HAND, true);
					}
				}
			}
		}
	}
}
