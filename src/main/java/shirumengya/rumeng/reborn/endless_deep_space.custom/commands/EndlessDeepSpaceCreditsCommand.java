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
import net.minecraft.commands.arguments.ResourceLocationArgument;
import net.minecraft.client.Minecraft;
import shirumengya.rumeng.reborn.endless_deep_space.custom.client.gui.screens.*;
import net.minecraft.resources.ResourceLocation;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import net.minecraft.commands.synchronization.SuggestionProviders;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.google.common.util.concurrent.Runnables;
import net.minecraftforge.registries.ForgeRegistries;
import com.mojang.brigadier.arguments.StringArgumentType;
import shirumengya.rumeng.reborn.endless_deep_space.custom.networking.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.networking.packet.*;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

@Mod.EventBusSubscriber
public class EndlessDeepSpaceCreditsCommand {

   	@SubscribeEvent
   	public static void register(RegisterCommandsEvent event) {
   
   	RequiredArgumentBuilder<CommandSourceStack, ResourceLocation> requiredargumentbuilder = Commands.argument("musics", ResourceLocationArgument.id()).suggests(SuggestionProviders.AVAILABLE_SOUNDS);
   
      	event.getDispatcher().register(Commands.literal("endless_deep_space_credits").requires((p_136734_) -> {
         	return p_136734_.hasPermission(2);
      	})
      	.then(Commands.argument("player", EntityArgument.players())
      	.then(Commands.argument("chapters", StringArgumentType.string())
      	.then(Commands.argument("BackgroundLocations", StringArgumentType.string())
      	.then(requiredargumentbuilder
      	.then(Commands.argument("ScrollSpeed", FloatArgumentType.floatArg())
      	.then(Commands.argument("CanModifiedScrollSpeed", BoolArgumentType.bool())
      	.then(Commands.argument("shouldCloseOnEsc", BoolArgumentType.bool())
	  	.executes((p_138593_) -> {
	  			try {
					for (Entity entityiterator : EntityArgument.getEntities(p_138593_, "player")) {
						if (entityiterator instanceof ServerPlayer _serverPlayer)
							ModMessages.sendToPlayer(new OpenEndlessDeepSpaceCreditsS2CPacket(StringArgumentType.getString(p_138593_, "chapters"), 
	         																 					StringArgumentType.getString(p_138593_, "BackgroundLocations"), 
         																 						ResourceLocationArgument.getId(p_138593_, "musics"), 
         																 						FloatArgumentType.getFloat(p_138593_, "ScrollSpeed"), 
         																 						BoolArgumentType.getBool(p_138593_, "CanModifiedScrollSpeed"),
         																 						BoolArgumentType.getBool(p_138593_, "shouldCloseOnEsc")), _serverPlayer);
					}
				} catch (CommandSyntaxException e) {
					
				}
			if (EntityArgument.getEntities(p_138593_, "player").size() == 1) {
         		p_138593_.getSource().sendSuccess(Component.translatable("commands.endless_deep_space_credits.success.single", EntityArgument.getEntities(p_138593_, "player").iterator().next().getDisplayName()), true);
      		} else {
         		p_138593_.getSource().sendSuccess(Component.translatable("commands.endless_deep_space_credits.success.multiple", EntityArgument.getEntities(p_138593_, "player").size()), true);
      		}
    		return EntityArgument.getEntities(p_138593_, "player").size();
      	})))))))));
   	}
}