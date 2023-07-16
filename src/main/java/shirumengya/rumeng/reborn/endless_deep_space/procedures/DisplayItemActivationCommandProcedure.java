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
import net.minecraft.world.item.ItemStack;

public class DisplayItemActivationCommandProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "player")) {
				if (entityiterator instanceof ServerPlayer _serverPlayer)
					ModMessages.sendToPlayer(new CommonDisplayItemActivationS2CPacket((new ItemStack(ItemArgument.getItem(arguments, "itemstack").getItem()))), _serverPlayer);
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}
