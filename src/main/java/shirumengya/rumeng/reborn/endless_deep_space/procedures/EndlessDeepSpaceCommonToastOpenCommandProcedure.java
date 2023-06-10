package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.EndlessDeepSpaceMod;
import net.minecraft.client.gui.components.toasts.ToastComponent;
import net.minecraft.commands.arguments.item.ItemArgument;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.client.Minecraft;
import javax.annotation.Nullable;
import net.minecraft.network.chat.Component;
import shirumengya.rumeng.reborn.endless_deep_space.custom.client.gui.toasts.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class EndlessDeepSpaceCommonToastOpenCommandProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		ToastComponent toastcomponent = Minecraft.getInstance().getToasts();
	    EndlessDeepSpaceCommonToast.add(toastcomponent, ItemArgument.getItem(arguments, "item").getItem().getDefaultInstance(), Component.translatable(StringArgumentType.getString(arguments, "title")), Component.translatable(StringArgumentType.getString(arguments, "description")), (long)DoubleArgumentType.getDouble(arguments, "time"), (int)DoubleArgumentType.getDouble(arguments, "titlecolor"), (int)DoubleArgumentType.getDouble(arguments, "descriptioncolor"));
	}
}
