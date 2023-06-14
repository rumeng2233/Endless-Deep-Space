package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.item.ItemArgument;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.client.Minecraft;
import shirumengya.rumeng.reborn.endless_deep_space.custom.networking.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.networking.packet.*;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class DisplayItemActivationCommandProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "player")) {
				if (entity instanceof ServerPlayer _serverPlayer)
					ModMessages.sendToPlayer(new CommonDisplayItemActivationS2CPacket((ItemArgument.getItem(arguments, "itemstack").getItem().getDefaultInstance())), _serverPlayer);
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}
