package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.network.EndlessDeepSpaceModVariables;
import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModMobEffects;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.client.Minecraft;

import javax.annotation.Nullable;

import com.mojang.blaze3d.shaders.FogShape;

@Mod.EventBusSubscriber
public class HeavyFogRenderingFogTickProcedure {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onRenderingFog(ViewportEvent.RenderFog event) {
		execute(event, event.getCamera().getEntity().level, event.getCamera().getEntity(), event);
	}

	public static void execute(LevelAccessor world, Entity entity, ViewportEvent.RenderFog fog) {
		execute(null, world, entity, fog);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, ViewportEvent.RenderFog fog) {
		if (entity == null || fog == null)
			return;
		if (EndlessDeepSpaceModVariables.MapVariables.get(world).heavy_fog_time > 0) {
			if (new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayer _serverPlayer) {
						return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
					} else if (_ent.level.isClientSide() && _ent instanceof Player _player) {
						return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
								&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
					}
					return false;
				}
			}.checkGamemode(entity)) {
				fog.setCanceled(true);
				fog.setNearPlaneDistance(55);
				fog.setFarPlaneDistance(65);
				fog.setFogShape(FogShape.SPHERE);
			} else {
				if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(EndlessDeepSpaceModMobEffects.SHARP_EYES.get()) : false) {
					fog.setCanceled(true);
					fog.setNearPlaneDistance(35);
					fog.setFarPlaneDistance(45);
					fog.setFogShape(FogShape.SPHERE);
				} else {
					if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MobEffects.BLINDNESS) : false) {
						fog.setCanceled(true);
						fog.setNearPlaneDistance(-10);
						fog.setFarPlaneDistance(-10);
						fog.setFogShape(FogShape.SPHERE);
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MobEffects.DARKNESS) : false) == false) {
						fog.setCanceled(true);
						fog.setNearPlaneDistance(5);
						fog.setFarPlaneDistance(15);
						fog.setFogShape(FogShape.SPHERE);
					}
				}
			}
		}
	}
}
