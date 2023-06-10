package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.entity.WitherestEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.projectile.WitherSkull;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.EntityDamageSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.client.Minecraft;
import shirumengya.rumeng.reborn.endless_deep_space.custom.world.damagesource.EndlessDeepSpaceDamageSource;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class WitherestTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("endless_deep_space:assault_value", (entity.getPersistentData().getDouble("endless_deep_space:assault_value") + 1));
		if (entity.getPersistentData().getDouble("endless_deep_space:assault_value") >= 100) {
			entity.getPersistentData().putDouble("endless_deep_space:assault_value", 0);
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(76 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
						.collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof WitherestEntity == false) {
						if (entityiterator instanceof LivingEntity _entity)
							_entity.hurt(EndlessDeepSpaceDamageSource.WrathOfWither(entity), 20);
						world.addParticle(ParticleTypes.SONIC_BOOM, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 0, 0, 0);
						if (entityiterator instanceof Player == true || entityiterator instanceof ServerPlayer == true) {
							if (new Object() {
								public boolean checkGamemode(Entity _ent) {
									if (_ent instanceof ServerPlayer _serverPlayer) {
										return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.ADVENTURE;
									} else if (_ent.level.isClientSide() && _ent instanceof Player _player) {
										return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
												&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.ADVENTURE;
									}
									return false;
								}
							}.checkGamemode(entityiterator) || new Object() {
								public boolean checkGamemode(Entity _ent) {
									if (_ent instanceof ServerPlayer _serverPlayer) {
										return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
									} else if (_ent.level.isClientSide() && _ent instanceof Player _player) {
										return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
												&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
									}
									return false;
								}
							}.checkGamemode(entityiterator)) {
								entityiterator.setDeltaMovement(new Vec3((entityiterator.getLookAngle().x), (entityiterator.getLookAngle().y + 1), (entityiterator.getLookAngle().z)));
							}
						} else {
							entityiterator.setDeltaMovement(new Vec3((entityiterator.getLookAngle().x), (entityiterator.getLookAngle().y + 1), (entityiterator.getLookAngle().z)));
						}
					}
				}
			}
		}
	}
}
