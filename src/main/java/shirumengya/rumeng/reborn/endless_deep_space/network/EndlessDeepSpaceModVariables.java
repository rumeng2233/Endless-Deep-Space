package shirumengya.rumeng.reborn.endless_deep_space.network;

import shirumengya.rumeng.reborn.endless_deep_space.EndlessDeepSpaceMod;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EndlessDeepSpaceModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		EndlessDeepSpaceMod.addNetworkMessage(SavedDataSyncMessage.class, SavedDataSyncMessage::buffer, SavedDataSyncMessage::new, SavedDataSyncMessage::handler);
		EndlessDeepSpaceMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level.isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level.isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level.isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.invincible = original.invincible;
			clone.fly = original.fly;
			clone.see_abyss = original.see_abyss;
			clone.player_kick_in_hardcore = original.player_kick_in_hardcore;
			clone.can_see_custom_fog = original.can_see_custom_fog;
			clone.custom_camera_angles = original.custom_camera_angles;
			clone.custom_camera_angles_yaw = original.custom_camera_angles_yaw;
			clone.custom_camera_angles_pitch = original.custom_camera_angles_pitch;
			clone.custom_camera_angles_roll = original.custom_camera_angles_roll;
			clone.custom_fov = original.custom_fov;
			clone.custom_fov_fov = original.custom_fov_fov;
			clone.first_in_mod = original.first_in_mod;
			clone.no_physics = original.no_physics;
			if (!event.isWasDeath()) {
				clone.broken_value = original.broken_value;
				clone.torridity_value = original.torridity_value;
				clone.ender_erosion_value = original.ender_erosion_value;
				clone.hot_bar = original.hot_bar;
			}
		}

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level.isClientSide()) {
				SavedData mapdata = MapVariables.get(event.getEntity().level);
				SavedData worlddata = WorldVariables.get(event.getEntity().level);
				if (mapdata != null)
					EndlessDeepSpaceMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					EndlessDeepSpaceMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level.isClientSide()) {
				SavedData worlddata = WorldVariables.get(event.getEntity().level);
				if (worlddata != null)
					EndlessDeepSpaceMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "endless_deep_space_worldvars";

		public static WorldVariables load(CompoundTag tag) {
			WorldVariables data = new WorldVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level level && !level.isClientSide())
				EndlessDeepSpaceMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(level::dimension), new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(e -> WorldVariables.load(e), WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "endless_deep_space_mapvars";
		public double heavy_fog_time = 0;
		public boolean custom_fog = false;
		public double custom_fog_time = 0;
		public double custom_fog_color_r = 0;
		public double custom_fog_color_g = 0;
		public double custom_fog_color_b = 0;
		public double custom_fog_end_distance = 0.0;
		public double custom_fog_start_distance = 0;
		public boolean custom_fog_shape_is_sphere = true;
		public boolean custom_fog_stop_reduce = false;

		public static MapVariables load(CompoundTag tag) {
			MapVariables data = new MapVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
			heavy_fog_time = nbt.getDouble("heavy_fog_time");
			custom_fog = nbt.getBoolean("custom_fog");
			custom_fog_time = nbt.getDouble("custom_fog_time");
			custom_fog_color_r = nbt.getDouble("custom_fog_color_r");
			custom_fog_color_g = nbt.getDouble("custom_fog_color_g");
			custom_fog_color_b = nbt.getDouble("custom_fog_color_b");
			custom_fog_end_distance = nbt.getDouble("custom_fog_end_distance");
			custom_fog_start_distance = nbt.getDouble("custom_fog_start_distance");
			custom_fog_shape_is_sphere = nbt.getBoolean("custom_fog_shape_is_sphere");
			custom_fog_stop_reduce = nbt.getBoolean("custom_fog_stop_reduce");
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			nbt.putDouble("heavy_fog_time", heavy_fog_time);
			nbt.putBoolean("custom_fog", custom_fog);
			nbt.putDouble("custom_fog_time", custom_fog_time);
			nbt.putDouble("custom_fog_color_r", custom_fog_color_r);
			nbt.putDouble("custom_fog_color_g", custom_fog_color_g);
			nbt.putDouble("custom_fog_color_b", custom_fog_color_b);
			nbt.putDouble("custom_fog_end_distance", custom_fog_end_distance);
			nbt.putDouble("custom_fog_start_distance", custom_fog_start_distance);
			nbt.putBoolean("custom_fog_shape_is_sphere", custom_fog_shape_is_sphere);
			nbt.putBoolean("custom_fog_stop_reduce", custom_fog_stop_reduce);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				EndlessDeepSpaceMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(e -> MapVariables.load(e), MapVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class SavedDataSyncMessage {
		public int type;
		public SavedData data;

		public SavedDataSyncMessage(FriendlyByteBuf buffer) {
			this.type = buffer.readInt();
			this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
			if (this.data instanceof MapVariables _mapvars)
				_mapvars.read(buffer.readNbt());
			else if (this.data instanceof WorldVariables _worldvars)
				_worldvars.read(buffer.readNbt());
		}

		public SavedDataSyncMessage(int type, SavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(SavedDataSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeInt(message.type);
			buffer.writeNbt(message.data.save(new CompoundTag()));
		}

		public static void handler(SavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("endless_deep_space", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public boolean invincible = false;
		public boolean fly = false;
		public double broken_value = 0;
		public double torridity_value = 0;
		public double ender_erosion_value = 0;
		public boolean see_abyss = false;
		public boolean player_kick_in_hardcore = false;
		public boolean can_see_custom_fog = false;
		public boolean custom_camera_angles = false;
		public double custom_camera_angles_yaw = 0;
		public double custom_camera_angles_pitch = 0;
		public double custom_camera_angles_roll = 0;
		public boolean custom_fov = false;
		public double custom_fov_fov = 70.0;
		public boolean first_in_mod = true;
		public double hot_bar = 0;
		public boolean no_physics = false;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				EndlessDeepSpaceMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putBoolean("invincible", invincible);
			nbt.putBoolean("fly", fly);
			nbt.putDouble("broken_value", broken_value);
			nbt.putDouble("torridity_value", torridity_value);
			nbt.putDouble("ender_erosion_value", ender_erosion_value);
			nbt.putBoolean("see_abyss", see_abyss);
			nbt.putBoolean("player_kick_in_hardcore", player_kick_in_hardcore);
			nbt.putBoolean("can_see_custom_fog", can_see_custom_fog);
			nbt.putBoolean("custom_camera_angles", custom_camera_angles);
			nbt.putDouble("custom_camera_angles_yaw", custom_camera_angles_yaw);
			nbt.putDouble("custom_camera_angles_pitch", custom_camera_angles_pitch);
			nbt.putDouble("custom_camera_angles_roll", custom_camera_angles_roll);
			nbt.putBoolean("custom_fov", custom_fov);
			nbt.putDouble("custom_fov_fov", custom_fov_fov);
			nbt.putBoolean("first_in_mod", first_in_mod);
			nbt.putDouble("hot_bar", hot_bar);
			nbt.putBoolean("no_physics", no_physics);
			return nbt;
		}

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
			invincible = nbt.getBoolean("invincible");
			fly = nbt.getBoolean("fly");
			broken_value = nbt.getDouble("broken_value");
			torridity_value = nbt.getDouble("torridity_value");
			ender_erosion_value = nbt.getDouble("ender_erosion_value");
			see_abyss = nbt.getBoolean("see_abyss");
			player_kick_in_hardcore = nbt.getBoolean("player_kick_in_hardcore");
			can_see_custom_fog = nbt.getBoolean("can_see_custom_fog");
			custom_camera_angles = nbt.getBoolean("custom_camera_angles");
			custom_camera_angles_yaw = nbt.getDouble("custom_camera_angles_yaw");
			custom_camera_angles_pitch = nbt.getDouble("custom_camera_angles_pitch");
			custom_camera_angles_roll = nbt.getDouble("custom_camera_angles_roll");
			custom_fov = nbt.getBoolean("custom_fov");
			custom_fov_fov = nbt.getDouble("custom_fov_fov");
			first_in_mod = nbt.getBoolean("first_in_mod");
			hot_bar = nbt.getDouble("hot_bar");
			no_physics = nbt.getBoolean("no_physics");
		}
	}

	public static class PlayerVariablesSyncMessage {
		public PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.invincible = message.data.invincible;
					variables.fly = message.data.fly;
					variables.broken_value = message.data.broken_value;
					variables.torridity_value = message.data.torridity_value;
					variables.ender_erosion_value = message.data.ender_erosion_value;
					variables.see_abyss = message.data.see_abyss;
					variables.player_kick_in_hardcore = message.data.player_kick_in_hardcore;
					variables.can_see_custom_fog = message.data.can_see_custom_fog;
					variables.custom_camera_angles = message.data.custom_camera_angles;
					variables.custom_camera_angles_yaw = message.data.custom_camera_angles_yaw;
					variables.custom_camera_angles_pitch = message.data.custom_camera_angles_pitch;
					variables.custom_camera_angles_roll = message.data.custom_camera_angles_roll;
					variables.custom_fov = message.data.custom_fov;
					variables.custom_fov_fov = message.data.custom_fov_fov;
					variables.first_in_mod = message.data.first_in_mod;
					variables.hot_bar = message.data.hot_bar;
					variables.no_physics = message.data.no_physics;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
