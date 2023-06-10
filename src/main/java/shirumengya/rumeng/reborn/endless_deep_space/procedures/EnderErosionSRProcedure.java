package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.network.EndlessDeepSpaceModVariables;
import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModMobEffects;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class EnderErosionSRProcedure {
	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if ((entity.level.dimension()) == (Level.END)) {
				if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.PURPUR_PILLAR
						&& (world.getBlockState(new BlockPos(x + 1, y - 1, z + 1))).getBlock() == Blocks.PURPUR_PILLAR
						&& (world.getBlockState(new BlockPos(x + 1, y - 1, z - 1))).getBlock() == Blocks.PURPUR_PILLAR
						&& (world.getBlockState(new BlockPos(x - 1, y - 1, z + 1))).getBlock() == Blocks.PURPUR_PILLAR
						&& (world.getBlockState(new BlockPos(x - 1, y - 1, z - 1))).getBlock() == Blocks.PURPUR_PILLAR
						&& (world.getBlockState(new BlockPos(x + 2, y - 2, z + 2))).getBlock() == Blocks.PURPUR_PILLAR
						&& (world.getBlockState(new BlockPos(x + 2, y - 2, z - 2))).getBlock() == Blocks.PURPUR_PILLAR
						&& (world.getBlockState(new BlockPos(x - 2, y - 2, z + 2))).getBlock() == Blocks.PURPUR_PILLAR
						&& (world.getBlockState(new BlockPos(x - 2, y - 2, z - 2))).getBlock() == Blocks.PURPUR_PILLAR
						&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.ENDER_EYE) {
					if ((entity instanceof LivingEntity _livEnt
							? _livEnt.hasEffect(EndlessDeepSpaceModMobEffects.ENDER_EROSION_PROTECTION.get())
							: false) == false) {
						if ((entity.getCapability(EndlessDeepSpaceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new EndlessDeepSpaceModVariables.PlayerVariables())).ender_erosion_value > 0) {
							if (entity instanceof LivingEntity _entity)
								_entity.swing(InteractionHand.MAIN_HAND, true);
							if (Math.random() < 0.01) {
								{
									int _setval = (int)(entity.getCapability(EndlessDeepSpaceModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new EndlessDeepSpaceModVariables.PlayerVariables())).ender_erosion_value - (int)1;
									entity.getCapability(EndlessDeepSpaceModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.ender_erosion_value = (int)_setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
							if (new Object() {
								public boolean checkGamemode(Entity _ent) {
									if (_ent instanceof ServerPlayer _serverPlayer) {
										return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
									} else if (_ent.level.isClientSide() && _ent instanceof Player _player) {
										return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
												&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId())
														.getGameMode() == GameType.SURVIVAL;
									}
									return false;
								}
							}.checkGamemode(entity) || new Object() {
								public boolean checkGamemode(Entity _ent) {
									if (_ent instanceof ServerPlayer _serverPlayer) {
										return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.ADVENTURE;
									} else if (_ent.level.isClientSide() && _ent instanceof Player _player) {
										return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
												&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId())
														.getGameMode() == GameType.ADVENTURE;
									}
									return false;
								}
							}.checkGamemode(entity)) {
								if (entity instanceof Player _player) {
									ItemStack _stktoremove = new ItemStack(Items.ENDER_EYE);
									_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1,
											_player.inventoryMenu.getCraftSlots());
								}
							}
						}
					}
				}
			}
		}
	}
}
