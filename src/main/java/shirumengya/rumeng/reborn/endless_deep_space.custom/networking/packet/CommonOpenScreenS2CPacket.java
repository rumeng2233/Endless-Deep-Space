package shirumengya.rumeng.reborn.endless_deep_space.custom.networking.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraftforge.network.NetworkEvent;
import shirumengya.rumeng.reborn.endless_deep_space.custom.client.gui.screens.*;
import java.util.function.Supplier;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.Minecraft;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import com.google.common.util.concurrent.Runnables;
import shirumengya.rumeng.reborn.endless_deep_space.init.*;
import net.minecraft.client.gui.screens.*;

public class CommonOpenScreenS2CPacket {
	private final int type;
	private static Minecraft minecraft = Minecraft.getInstance();
	private static final Logger LOGGER = LogUtils.getLogger();
	
    public CommonOpenScreenS2CPacket(int types) {
		this.type = types;
    }

    public CommonOpenScreenS2CPacket(FriendlyByteBuf buf) {
    	this.type = buf.readInt();
    }

    public void toBytes(FriendlyByteBuf buf) {
		buf.writeInt(type);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
        LOGGER.info("Send type " + type + " to Client");
            if (type == 0) {
            	this.minecraft.setScreen(new WinScreen(true, Runnables.doNothing()));
            }
        });
        return true;
    }

}
