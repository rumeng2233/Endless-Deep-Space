package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ColorPickerGUIProcedure {
	public static final Logger LOGGER = LogManager.getLogger(ColorPickerGUIProcedure.class);
	public static void execute() {
		if (!GraphicsEnvironment.isHeadless()) {
				ColorPickerGUIProcedure.LOGGER.debug("Open Color Picker");
				JFrame ColorPickerGUI = new JFrame("Color Picker");
				JColorChooser ColorPicker = new JColorChooser();
				ColorPicker.showDialog(ColorPickerGUI, "Color Picker", Color.white);
				ColorPickerGUI.pack();
				ColorPickerGUI.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				ColorPickerGUI.setLocationRelativeTo(null);
				ColorPickerGUI.setVisible(false);
				ColorPickerGUI.setAlwaysOnTop(true);
        } else {
        		ColorPickerGUIProcedure.LOGGER.fatal("One Error!! java.awt.headless:null");
        }
	}
}
