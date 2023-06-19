package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.EndlessDeepSpaceMod;

import shirumengya.rumeng.reborn.endless_deep_space.custom.networking.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.networking.packet.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.item.ItemArgument;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

public class EndlessDeepSpaceCommonToastOpenCommandProcedure {
	public static void execute(double x, double y, double z, CommandContext<CommandSourceStack> arguments) {
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "player")) {
				if (entityiterator instanceof ServerPlayer _serverPlayer)
					ModMessages.sendToPlayer(new SendEndlessDeepSpaceCommonToastS2CPacket((new ItemStack(ItemArgument.getItem(arguments, "item").getItem())), 
																							Component.translatable(StringArgumentType.getString(arguments, "title")), 
																							Component.translatable(StringArgumentType.getString(arguments, "description")), 
																							(long)DoubleArgumentType.getDouble(arguments, "time"), 
																							(int)DoubleArgumentType.getDouble(arguments, "titlecolor"), 
																							(int)DoubleArgumentType.getDouble(arguments, "descriptioncolor")), _serverPlayer);
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}
