package shirumengya.rumeng.reborn.endless_deep_space.custom.networking;

import shirumengya.rumeng.reborn.endless_deep_space.EndlessDeepSpaceMod;
import shirumengya.rumeng.reborn.endless_deep_space.custom.networking.packet.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class ModMessages {
    private static SimpleChannel INSTANCE;

    private static int packetId = 0;
    private static int id() {
        return packetId++;
    }

    public static void register() {
        SimpleChannel net = NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(EndlessDeepSpaceMod.MODID, "messages"))
                .networkProtocolVersion(() -> "1.0")
                .clientAcceptedVersions(s -> true)
                .serverAcceptedVersions(s -> true)
                .simpleChannel();

        INSTANCE = net;

        net.messageBuilder(BrokenBookOpenScreenS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(BrokenBookOpenScreenS2CPacket::new)
                .encoder(BrokenBookOpenScreenS2CPacket::toBytes)
                .consumerMainThread(BrokenBookOpenScreenS2CPacket::handle)
                .add();

        net.messageBuilder(CommonOpenScreenS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(CommonOpenScreenS2CPacket::new)
                .encoder(CommonOpenScreenS2CPacket::toBytes)
                .consumerMainThread(CommonOpenScreenS2CPacket::handle)
                .add();

        net.messageBuilder(CommonDisplayItemActivationS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(CommonDisplayItemActivationS2CPacket::new)
                .encoder(CommonDisplayItemActivationS2CPacket::toBytes)
                .consumerMainThread(CommonDisplayItemActivationS2CPacket::handle)
                .add();
    }

    public static <MSG> void sendToServer(MSG message) {
         INSTANCE.sendToServer(message);
    }

    public static <MSG> void sendToPlayer(MSG message, ServerPlayer player) {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), message);
    }
}
