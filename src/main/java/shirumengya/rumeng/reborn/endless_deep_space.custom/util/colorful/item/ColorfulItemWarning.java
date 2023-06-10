package shirumengya.rumeng.reborn.endless_deep_space.custom.util.colorful.item;

import net.minecraft.ChatFormatting;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class ColorfulItemWarning {
  private static final ChatFormatting[] colour = new ChatFormatting[] { 
      ChatFormatting.DARK_RED, ChatFormatting.DARK_RED, ChatFormatting.YELLOW, ChatFormatting.YELLOW, ChatFormatting.DARK_RED, ChatFormatting.DARK_RED, ChatFormatting.YELLOW, ChatFormatting.YELLOW, ChatFormatting.DARK_RED, ChatFormatting.DARK_RED, 
      ChatFormatting.YELLOW, ChatFormatting.YELLOW };
  
  public static String formatting(String input, ChatFormatting[] colours, double delay) {
    StringBuilder sb = new StringBuilder(input.length() * 3);
    if (delay <= 0.0D)
      delay = 0.001D; 
    int offset = (int)Math.floor((System.currentTimeMillis() & 0x3FFFL) / delay) % colours.length;
    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      sb.append(colours[(colours.length + i - offset) % colours.length].toString());
      sb.append(c);
    } 
    return sb.toString();
  }
  
  public static String makeColour(String input) {
    return formatting(input, colour, 80.0D);
  }
  
  public static String makeColour2(String input) {
//    return formatting(input, colour, 59.5D);
    return formatting(input, colour, (double)Mth.nextDouble(RandomSource.create(), 0, 100));
  }
}
