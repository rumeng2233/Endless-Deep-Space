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
import net.minecraft.world.item.ItemStack;

public class CommonDisplayItemActivationS2CPacket {
	private final ItemStack item;
	private static Minecraft minecraft = Minecraft.getInstance();
	private static final Logger LOGGER = LogUtils.getLogger();
	
    public CommonDisplayItemActivationS2CPacket(ItemStack items) {
		this.item = items;
    }

    public CommonDisplayItemActivationS2CPacket(FriendlyByteBuf buf) {
    	this.item = buf.readItem();
    }

    public void toBytes(FriendlyByteBuf buf) {
		buf.writeItem(item);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
        LOGGER.info("Send ItemStack Name:" + item.getDisplayName().getString() + " Namespace:" + ForgeRegistries.ITEMS.getKey(item.getItem()).toString() + " to Client");
        this.minecraft.gameRenderer.displayItemActivation(item);
        });
        return true;
    }

}
