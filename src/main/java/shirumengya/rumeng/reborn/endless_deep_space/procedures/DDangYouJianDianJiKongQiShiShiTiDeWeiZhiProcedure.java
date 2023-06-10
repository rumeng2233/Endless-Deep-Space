package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import com.google.common.util.concurrent.Runnables;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import shirumengya.rumeng.reborn.endless_deep_space.custom.client.gui.screens.EndlessDeepSpaceCredits;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
//import shirumengya.rumeng.reborn.endless_deep_space.custom.client.gui.screens.EDSTest;
import net.minecraft.network.protocol.game.*;
import net.minecraft.client.gui.screens.WinScreen;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;

public class DDangYouJianDianJiKongQiShiShiTiDeWeiZhiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
			if (world instanceof Level _level) {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("music.credits")), SoundSource.NEUTRAL, 1, 1, false);
		}
	Minecraft.getInstance().setScreen(new EndlessDeepSpaceCredits("poem_and_credits", "poem", 0.5F, false, false, Runnables.doNothing()));
//	Minecraft.getInstance().setScreen(new EndlessDeepSpaceCredits(true, Runnables.doNothing()));
//	Minecraft.getInstance().setScreen(new EndlessDeepSpaceCredits(true, () -> { Minecraft.getInstance().player.connection.send(new ServerboundClientCommandPacket(ServerboundClientCommandPacket.Action.PERFORM_RESPAWN)); }));
//	Minecraft.getInstance().setScreen(new EDSTest(true, Runnables.doNothing()));
	}
}
