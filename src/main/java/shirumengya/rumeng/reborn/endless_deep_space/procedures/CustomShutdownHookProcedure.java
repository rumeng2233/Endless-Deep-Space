package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraft.network.chat.Component;
import javax.swing.*;
import javax.annotation.Nullable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.annotation.Nullable;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CustomShutdownHookProcedure {
	public static final Logger LOGGER = LogManager.getLogger(CustomShutdownHookProcedure.class);
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		execute();
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
		CustomShutdownHookProcedure.LOGGER.info("Adding shutdown hook");
		Runtime.getRuntime().addShutdownHook(new Thread("CustomShutdownHook"){
		public void run() {
                CustomShutdownHookProcedure.LOGGER.info("Stopping!");
            }
        });
	}
}
