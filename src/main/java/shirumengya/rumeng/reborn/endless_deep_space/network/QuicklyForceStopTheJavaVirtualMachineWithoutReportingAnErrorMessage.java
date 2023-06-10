
package shirumengya.rumeng.reborn.endless_deep_space.network;

import shirumengya.rumeng.reborn.endless_deep_space.procedures.CrashGameWithoutReportingAnErrorProcedure;
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
public class QuicklyForceStopTheJavaVirtualMachineWithoutReportingAnErrorMessage {
	int type, pressedms;

	public QuicklyForceStopTheJavaVirtualMachineWithoutReportingAnErrorMessage(int type, int pressedms) {
		this.type = type;
		this.pressedms = pressedms;
	}

	public QuicklyForceStopTheJavaVirtualMachineWithoutReportingAnErrorMessage(FriendlyByteBuf buffer) {
		this.type = buffer.readInt();
		this.pressedms = buffer.readInt();
	}

	public static void buffer(QuicklyForceStopTheJavaVirtualMachineWithoutReportingAnErrorMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.type);
		buffer.writeInt(message.pressedms);
	}

	public static void handler(QuicklyForceStopTheJavaVirtualMachineWithoutReportingAnErrorMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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

			CrashGameWithoutReportingAnErrorProcedure.execute();
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		EndlessDeepSpaceMod.addNetworkMessage(QuicklyForceStopTheJavaVirtualMachineWithoutReportingAnErrorMessage.class, QuicklyForceStopTheJavaVirtualMachineWithoutReportingAnErrorMessage::buffer,
				QuicklyForceStopTheJavaVirtualMachineWithoutReportingAnErrorMessage::new, QuicklyForceStopTheJavaVirtualMachineWithoutReportingAnErrorMessage::handler);
	}
}
