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

public class BrokenBookOpenScreenS2CPacket {
	private final int type;
	private static Minecraft minecraft = Minecraft.getInstance();
	private static final Logger LOGGER = LogUtils.getLogger();
	
    public BrokenBookOpenScreenS2CPacket(int types) {
		this.type = types;
    }

    public BrokenBookOpenScreenS2CPacket(FriendlyByteBuf buf) {
    	this.type = buf.readInt();
    }

    public void toBytes(FriendlyByteBuf buf) {
		buf.writeInt(type);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
        LOGGER.info("Send type " + type + " to Client");
            if (type == 1) {
            	this.minecraft.forceSetScreen(new EndlessDeepSpaceCredits("story:broken_world:broken_book_one", "textures/gui/endless_deep_space_credits_background/broken.png", EndlessDeepSpaceModSounds.C418_0X10C.get(), 0.5F, true, true, Runnables.doNothing()));
            } else if (type == 2) {
            	this.minecraft.forceSetScreen(new EndlessDeepSpaceCredits("story:broken_world:broken_book_two", "textures/gui/endless_deep_space_credits_background/broken.png", EndlessDeepSpaceModSounds.C418_0X10C.get(), 0.5F, true, true, Runnables.doNothing()));
            } else if (type == 3) {
            	this.minecraft.forceSetScreen(new EndlessDeepSpaceCredits("story:broken_world:broken_book_three", "textures/gui/endless_deep_space_credits_background/broken.png", EndlessDeepSpaceModSounds.C418_0X10C.get(), 0.5F, true, true, Runnables.doNothing()));
            } else if (type == 4) {
            	this.minecraft.forceSetScreen(new EndlessDeepSpaceCredits("story:broken_world:broken_book_four", "textures/gui/endless_deep_space_credits_background/broken.png", EndlessDeepSpaceModSounds.C418_0X10C.get(), 0.5F, true, true, Runnables.doNothing()));
            } else if (type == 5) {
            	this.minecraft.forceSetScreen(new EndlessDeepSpaceCredits("story:broken_world:broken_book_five", "textures/gui/endless_deep_space_credits_background/broken.png", EndlessDeepSpaceModSounds.C418_0X10C.get(), 0.5F, true, true, Runnables.doNothing()));
            } else if (type == 6) {
            	this.minecraft.forceSetScreen(new EndlessDeepSpaceCredits("story:broken_world:broken_book_six", "textures/gui/endless_deep_space_credits_background/broken.png", EndlessDeepSpaceModSounds.C418_0X10C.get(), 0.5F, true, true, Runnables.doNothing()));
            } else if (type == 7) {
            	this.minecraft.forceSetScreen(new EndlessDeepSpaceCredits("story:broken_world:broken_book_seven", "textures/gui/endless_deep_space_credits_background/broken.png", EndlessDeepSpaceModSounds.C418_0X10C.get(), 0.5F, true, true, Runnables.doNothing()));
            } else if (type == 8) {
            	this.minecraft.forceSetScreen(new EndlessDeepSpaceCredits("story:broken_world:broken_book_eight", "textures/gui/endless_deep_space_credits_background/broken.png", EndlessDeepSpaceModSounds.C418_0X10C.get(), 0.5F, true, true, Runnables.doNothing()));
            } else if (type == 9) {
            	this.minecraft.forceSetScreen(new EndlessDeepSpaceCredits("story:broken_world:broken_book_nine", "textures/gui/endless_deep_space_credits_background/broken.png", EndlessDeepSpaceModSounds.C418_0X10C.get(), 0.5F, true, true, Runnables.doNothing()));
            } else if (type == 10) {
            	this.minecraft.forceSetScreen(new EndlessDeepSpaceCredits("story:broken_world:broken_book_ten", "textures/gui/endless_deep_space_credits_background/broken.png", EndlessDeepSpaceModSounds.C418_0X10C.get(), 0.5F, true, true, Runnables.doNothing()));
            }
        });
        return true;
    }

}
