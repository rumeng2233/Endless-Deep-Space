package shirumengya.rumeng.reborn.endless_deep_space.custom.commands;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentUtils;
import net.minecraft.network.chat.HoverEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import java.math.BigInteger;
import com.mojang.brigadier.arguments.LongArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;

@Mod.EventBusSubscriber
public class BigIntegerCommand {

   @SubscribeEvent
   public static void register(RegisterCommandsEvent event) {
      event.getDispatcher().register(Commands.literal("big_integer")
      .then(Commands.argument("long", LongArgumentType.longArg())
      .then(Commands.argument("integer", IntegerArgumentType.integer())
	  .executes((p_138593_) -> {
	  	 BigInteger bi = new BigInteger(LongArgumentType.getLong(p_138593_, "long") + "");
         //String i = BigInteger.ONE.shiftLeft(IntegerArgumentType.getInteger(p_138593_, "integer")).toString();
         String i = bi.pow(IntegerArgumentType.getInteger(p_138593_, "integer")).toString();
         Component component = ComponentUtils.wrapInSquareBrackets(Component.literal(String.valueOf(i)).withStyle((p_180514_) -> {
            return p_180514_.withColor(ChatFormatting.AQUA).withClickEvent(new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, String.valueOf(i))).withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, Component.translatable("chat.copy.click"))).withInsertion(String.valueOf(i));
         }));
         p_138593_.getSource().sendSuccess(Component.translatable("commands.big_integer.success", component), false);
         return 0;
      }))));
   }
}