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
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import shirumengya.rumeng.reborn.endless_deep_space.custom.client.gui.toasts.*;
import net.minecraft.client.gui.components.toasts.ToastComponent;

public class SendEndlessDeepSpaceCommonRecipeTipToastS2CPacket {
	private final ItemStack item;
	private final ItemStack recipeitem;
	private final Component title;
	private final Component description;
	private final long time;
	private final int titlecolor;
	private final int descriptioncolor;
	private static Minecraft minecraft = Minecraft.getInstance();
	private static final Logger LOGGER = LogUtils.getLogger();
	
    public SendEndlessDeepSpaceCommonRecipeTipToastS2CPacket(ItemStack item, ItemStack recipeitem, Component title, Component description, long time, int titlecolor, int descriptioncolor) {
    	this.item = item;
    	this.recipeitem = recipeitem;
    	this.title = title;
    	this.description = description;
    	this.time = time;
    	this.titlecolor = titlecolor;
    	this.descriptioncolor = descriptioncolor;
    }

    public SendEndlessDeepSpaceCommonRecipeTipToastS2CPacket(FriendlyByteBuf buf) {
    	this.item = buf.readItem();
    	this.recipeitem = buf.readItem();
    	this.title = buf.readComponent();
    	this.description = buf.readComponent();
    	this.time = buf.readLong();
    	this.titlecolor = buf.readInt();
    	this.descriptioncolor = buf.readInt();
    }

    public void toBytes(FriendlyByteBuf buf) {
    	buf.writeItem(item);
    	buf.writeItem(recipeitem);
    	buf.writeComponent(title);
    	buf.writeComponent(description);
    	buf.writeLong(time);
    	buf.writeInt(titlecolor);
    	buf.writeInt(descriptioncolor);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
        	LOGGER.info("Send [ItemStack Namespace:" + ForgeRegistries.ITEMS.getKey(item.getItem()).toString() + ";\nRecipeItemStack Namespace:" + ForgeRegistries.ITEMS.getKey(recipeitem.getItem()).toString() + ";\nTitle:" + title.toString() + ";\nDescription:" + description.toString() + ";\nTime:" + time + ";\nTitle Colour:" + titlecolor + ";\nDescription Colour:" + descriptioncolor + "] to Client");
        	ToastComponent toastcomponent = this.minecraft.getToasts();
        	EndlessDeepSpaceCommonRecipeTipToast.add(toastcomponent, item, recipeitem, title, description, time, titlecolor, descriptioncolor);
        });
        return true;
    }

}
