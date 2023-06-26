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

public class OpenEndlessDeepSpaceCreditsS2CPacket {
	private final String chapters;
	private final String BackgroundLocations;
	private final ResourceLocation musics;
	private final float ScrollSpeed;
	private final boolean CanModifiedScrollSpeed;
	private final boolean shouldCloseOnEsc;
	private static Minecraft minecraft = Minecraft.getInstance();
	private static final Logger LOGGER = LogUtils.getLogger();
	
    public OpenEndlessDeepSpaceCreditsS2CPacket(String chapters, String BackgroundLocations, ResourceLocation musics, float ScrollSpeed, boolean CanModifiedScrollSpeed, boolean shouldCloseOnEsc) {
    	this.chapters = chapters;
    	this.BackgroundLocations = BackgroundLocations;
    	this.musics = musics;
    	this.ScrollSpeed = ScrollSpeed;
    	this.CanModifiedScrollSpeed = CanModifiedScrollSpeed;
    	this.shouldCloseOnEsc = shouldCloseOnEsc;
    }

    public OpenEndlessDeepSpaceCreditsS2CPacket(FriendlyByteBuf buf) {
    	this.chapters = buf.readUtf();
    	this.BackgroundLocations = buf.readUtf();
    	this.musics = buf.readResourceLocation();
    	this.ScrollSpeed = buf.readFloat();
    	this.CanModifiedScrollSpeed = buf.readBoolean();
    	this.shouldCloseOnEsc = buf.readBoolean();
    }

    public void toBytes(FriendlyByteBuf buf) {
		buf.writeUtf(chapters);
		buf.writeUtf(BackgroundLocations);
		buf.writeResourceLocation(musics);
		buf.writeFloat(ScrollSpeed);
		buf.writeBoolean(CanModifiedScrollSpeed);
		buf.writeBoolean(shouldCloseOnEsc);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
        	LOGGER.info("Send [Chapters:" + chapters + ";\nBackgroundLocations:" + BackgroundLocations + ";\nMusics:" + musics + ";\nScrollSpeed:" + ScrollSpeed + ";\nCanModifiedScrollSpeed:" + CanModifiedScrollSpeed + ";\nShouldCloseOnEsc:" + shouldCloseOnEsc + "] to Client");
        	this.minecraft.forceSetScreen(new EndlessDeepSpaceCredits(this.chapters, this.BackgroundLocations, ForgeRegistries.SOUND_EVENTS.getValue(this.musics), this.ScrollSpeed, this.CanModifiedScrollSpeed, this.shouldCloseOnEsc, Runnables.doNothing()));
        });
        return true;
    }

}