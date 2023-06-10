package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;

import javax.swing.*;
import javax.annotation.Nullable;
import java.awt.event.*;
import java.awt.*;
import shirumengya.rumeng.reborn.endless_deep_space.EndlessDeepSpaceMod;
//import org.lwjgl.glfw.GLFW;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.lang3.time.StopWatch;
import java.lang.*;
import java.io.*;
import java.util.concurrent.TimeUnit;
import javax.swing.Timer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CloseMinecraftGUIProcedure {
	public static final Logger LOGGER = LogManager.getLogger(CloseMinecraftGUIProcedure.class);
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		execute();
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
		if (!GraphicsEnvironment.isHeadless()) {
			CloseMinecraftGUIProcedure.LOGGER.debug("Old java.awt.headless:" + System.getProperty("java.awt.headless"));
			System.setProperty("java.awt.headless", "false");
			CloseMinecraftGUIProcedure.LOGGER.debug("New java.awt.headless:" + System.getProperty("java.awt.headless"));
			try {
			Thread.currentThread().sleep(100);
			} catch (InterruptedException interruptedexception) {
			}
			if (!GraphicsEnvironment.isHeadless()) {
				CloseMinecraftGUIProcedure.LOGGER.debug("No Error!");
        	} else {
        		CloseMinecraftGUIProcedure.LOGGER.fatal("One Error!! java.awt.headless:null");
        		CloseMinecraftGUIProcedure.LOGGER.warn("Write once,Run anywhere× Write once,Debug everywhere√");
        		CloseMinecraftGUIProcedure.LOGGER.warn("一次编译，到处运行× 一次编译，到处调试√");
        	}
			try {
			Thread.currentThread().sleep(100);
			} catch (InterruptedException interruptedexception) {
			}
			StopWatch stopWatch = new StopWatch();
			stopWatch.start();
			JFrame CloseMinecraftGUI = new JFrame("Close Minecraft");
			JButton CloseMinecraftGUIButton = new JButton("Close Minecraft");
			JProgressBar CloseMinecraftGUIProgressBar = new JProgressBar();
			CloseMinecraftGUIProgressBar.setIndeterminate(true);
			CloseMinecraftGUIProgressBar.setBorderPainted(true);
			CloseMinecraftGUIProgressBar.updateUI();
//			CloseMinecraftGUIProgressBar.setBackground(Color.pink);
			JPanel CloseMinecraftGUIPanel = new JPanel();
//			CloseMinecraftGUIButton.setMnemonic(GLFW.GLFW_KEY_J);
			JLabel CloseMinecraftGUIPlayMinecraftTimeLabel = new JLabel("times  412250400000000 114514");
			CloseMinecraftGUIPanel.add(CloseMinecraftGUIButton);
			CloseMinecraftGUIPanel.add(CloseMinecraftGUIProgressBar);
			CloseMinecraftGUIPanel.add(CloseMinecraftGUIPlayMinecraftTimeLabel);
//			CloseMinecraftGUIPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
//			CloseMinecraftGUIPanel.setLayout(new FlowLayout());
			CloseMinecraftGUI.add(CloseMinecraftGUIPanel);
			Toolkit tk = Toolkit.getDefaultToolkit();
			java.awt.Image icon = tk.getImage(EndlessDeepSpaceMod.class.getClassLoader().getResource("java/gui/icon/CloseMinecraftGUIIcon.png"));
			CloseMinecraftGUI.setIconImage(icon);
			CloseMinecraftGUI.pack();
//			CloseMinecraftGUI.setSize(300, 75);
//			CloseMinecraftGUI.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			CloseMinecraftGUI.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
//			CloseMinecraftGUI.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//			CloseMinecraftGUI.setResizable(false);
			CloseMinecraftGUI.setAlwaysOnTop(true);
			CloseMinecraftGUI.setLocationRelativeTo(null);
			CloseMinecraftGUI.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
 				CloseMinecraftGUIPlayMinecraftTimeLabel.setText(stopWatch.getTime(TimeUnit.SECONDS) + "s");
            }
 
            @Override
            public void windowClosing(WindowEvent e) {
            	CloseMinecraftGUIProcedure.LOGGER.error("This window cannot be closed");
            	JOptionPane.showMessageDialog(CloseMinecraftGUI,"This window cannot be closed!","Cannot be closed!",0);
            	CloseMinecraftGUIPlayMinecraftTimeLabel.setText(stopWatch.getTime(TimeUnit.SECONDS) + "s");
            }
 
            @Override
            public void windowClosed(WindowEvent e) {
 				stopWatch.stop();
 				CloseMinecraftGUIProcedure.LOGGER.debug(stopWatch.getTime(TimeUnit.SECONDS));
            }
 
            @Override
            public void windowIconified(WindowEvent e) {
            	CloseMinecraftGUIPlayMinecraftTimeLabel.setText(stopWatch.getTime(TimeUnit.SECONDS) + "s");
            }
 
            @Override
            public void windowDeiconified(WindowEvent e) {
 				CloseMinecraftGUIPlayMinecraftTimeLabel.setText(stopWatch.getTime(TimeUnit.SECONDS) + "s");
            }
 
            @Override
            public void windowActivated(WindowEvent e) {
 				CloseMinecraftGUIPlayMinecraftTimeLabel.setText(stopWatch.getTime(TimeUnit.SECONDS) + "s");
            }
 
            @Override
            public void windowDeactivated(WindowEvent e) {
 				CloseMinecraftGUIPlayMinecraftTimeLabel.setText(stopWatch.getTime(TimeUnit.SECONDS) + "s");
            }
        });
			CloseMinecraftGUIButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CloseMinecraftGUIButton.setEnabled(false);
				CloseMinecraftGUIButton.setText("Stopping!");
				CloseMinecraftGUI.setTitle("Stopping!");
				CloseMinecraftGUIProcedure.LOGGER.info("Closing window");
				CustomShutdownHookProcedure.LOGGER.info("Stopping!");
				CloseMinecraftGUIProcedure.LOGGER.debug("run " + stopWatch.getTime(TimeUnit.DAYS) + "d");
				CloseMinecraftGUIProcedure.LOGGER.debug("run " + stopWatch.getTime(TimeUnit.HOURS) + "h");
				CloseMinecraftGUIProcedure.LOGGER.debug("run " + stopWatch.getTime(TimeUnit.MINUTES) + "min");
				CloseMinecraftGUIProcedure.LOGGER.debug("run " + stopWatch.getTime(TimeUnit.SECONDS) + "s");
				CloseMinecraftGUIProcedure.LOGGER.debug("run " + stopWatch.getTime(TimeUnit.MILLISECONDS) + "ms");
				CloseMinecraftGUIProcedure.LOGGER.debug("run " + stopWatch.getTime(TimeUnit.NANOSECONDS) + "ns");
				try {
				if (SystemTray.isSupported()) {
					CloseMinecraftGUIProcedure cm = new CloseMinecraftGUIProcedure();
            		cm.displayCloseTray();
        		} else {
            		CloseMinecraftGUIProcedure.LOGGER.error("System tray not supported!");
        		}
         		} catch (AWTException awtexception) {
         		}
				Runtime.getRuntime().halt(0);
			}
		});
			CloseMinecraftGUI.setVisible(true);
			Thread CloseMinecraftGUITimer = new Thread("CloseMinecraftGUITimer"){
            	@Override
            	public void run() {
                	while (true) {
						CloseMinecraftGUIPlayMinecraftTimeLabel.setText(stopWatch.getTime(TimeUnit.NANOSECONDS) + "ns");
					}
            	}
        	};
        	CloseMinecraftGUITimer.start();
		} else {
			CloseMinecraftGUIProcedure.LOGGER.fatal("One Error!! java.awt.headless:null");
		}
	}

	public void displayCloseTray() throws AWTException {
        SystemTray tray = SystemTray.getSystemTray();
        Image image = Toolkit.getDefaultToolkit().getImage(EndlessDeepSpaceMod.class.getClassLoader().getResource("java/gui/icon/CloseMinecraftGUIIcon.png"));
        TrayIcon trayIcon = new TrayIcon(image, "Endless Deep Space Mod");
        trayIcon.setImageAutoSize(true);
        trayIcon.setToolTip("Endless Deep Space Mod");
        tray.add(trayIcon);
        trayIcon.displayMessage("Stopping Minecraft!", "Endless Deep Space Mod", TrayIcon.MessageType.INFO);
    }
}