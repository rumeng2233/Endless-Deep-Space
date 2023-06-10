
package shirumengya.rumeng.reborn.endless_deep_space.network;

import shirumengya.rumeng.reborn.endless_deep_space.procedures.CrashGameProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.EndlessDeepSpaceMod;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class QuicklyForceStopTheJavaVirtualMachineMessage {
	int type, pressedms;

	public QuicklyForceStopTheJavaVirtualMachineMessage(int type, int pressedms) {
		this.type = type;
		this.pressedms = pressedms;
	}

	public QuicklyForceStopTheJavaVirtualMachineMessage(FriendlyByteBuf buffer) {
		this.type = buffer.readInt();
		this.pressedms = buffer.readInt();
	}

	public static void buffer(QuicklyForceStopTheJavaVirtualMachineMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.type);
		buffer.writeInt(message.pressedms);
	}

	public static void handler(QuicklyForceStopTheJavaVirtualMachineMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			pressAction(context.getSender(), message.type, message.pressedms);
		});
		context.setPacketHandled(true);
	}

	public static void pressAction(Player entity, int type, int pressedms) {
		Level world = entity.level;
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(entity.blockPosition()))
			return;
		if (type == 0) {

			CrashGameProcedure.execute();
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		EndlessDeepSpaceMod.addNetworkMessage(QuicklyForceStopTheJavaVirtualMachineMessage.class, QuicklyForceStopTheJavaVirtualMachineMessage::buffer, QuicklyForceStopTheJavaVirtualMachineMessage::new,
				QuicklyForceStopTheJavaVirtualMachineMessage::handler);
	}
}
