package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModItems;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;
import shirumengya.rumeng.reborn.endless_deep_space.custom.world.damagesource.EndlessDeepSpaceDamageSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import javax.annotation.Nullable;
import net.minecraft.world.phys.Vec3;
import net.minecraft.network.protocol.game.ClientboundSetEntityMotionPacket;
import net.minecraft.server.level.ServerPlayer;

@Mod.EventBusSubscriber
public class GravityCoreCannotAntigravityCoreInProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(EndlessDeepSpaceModItems.GRAVITY_CORE.get())) : false)
				&& (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(EndlessDeepSpaceModItems.ANTIGRAVITY_CORE.get())) : false)) {
				Vec3 vec3 = entity.getDeltaMovement();
				entity.push(-vec3.x, -vec3.y, -vec3.z);
				if (entity instanceof ServerPlayer player) {
                	player.connection.send(new ClientboundSetEntityMotionPacket(entity));
            	}
				entity.hurt(EndlessDeepSpaceDamageSource.FORCE_OF_GRAVITY, Float.MAX_VALUE);
		}
	}
}
