package shirumengya.rumeng.reborn.endless_deep_space.custom.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.Dynamic2CommandExceptionType;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import java.util.Collection;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.arguments.ItemEnchantmentArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;

@Mod.EventBusSubscriber
public class EnchantHighCommand {
   private static final DynamicCommandExceptionType ERROR_NOT_LIVING_ENTITY = new DynamicCommandExceptionType((p_137029_) -> {
      return Component.translatable("commands.enchant.failed.entity", p_137029_);
   });
   private static final DynamicCommandExceptionType ERROR_NO_ITEM = new DynamicCommandExceptionType((p_137027_) -> {
      return Component.translatable("commands.enchant.failed.itemless", p_137027_);
   });
   private static final SimpleCommandExceptionType ERROR_NOTHING_HAPPENED = new SimpleCommandExceptionType(Component.translatable("commands.enchant.failed"));

   @SubscribeEvent
   public static void register(RegisterCommandsEvent event) {
      event.getDispatcher().register(Commands.literal("enchant_high").requires((p_137013_) -> {
         return p_137013_.hasPermission(2);
      }).then(Commands.argument("targets", EntityArgument.entities()).then(Commands.argument("enchantment", ItemEnchantmentArgument.enchantment()).executes((p_137025_) -> {
         return enchant(p_137025_.getSource(), EntityArgument.getEntities(p_137025_, "targets"), ItemEnchantmentArgument.getEnchantment(p_137025_, "enchantment"), 1);
      }).then(Commands.argument("level", IntegerArgumentType.integer(0)).executes((p_137011_) -> {
         return enchant(p_137011_.getSource(), EntityArgument.getEntities(p_137011_, "targets"), ItemEnchantmentArgument.getEnchantment(p_137011_, "enchantment"), IntegerArgumentType.getInteger(p_137011_, "level"));
      })))));
   }

   private static int enchant(CommandSourceStack p_137015_, Collection<? extends Entity> p_137016_, Enchantment p_137017_, int p_137018_) throws CommandSyntaxException {
         int i = 0;

         for(Entity entity : p_137016_) {
            if (entity instanceof LivingEntity) {
               LivingEntity livingentity = (LivingEntity)entity;
               ItemStack itemstack = livingentity.getMainHandItem();
               if (!itemstack.isEmpty()) {
                     itemstack.enchant(p_137017_, p_137018_);
                     ++i;
               } else if (p_137016_.size() == 1) {
                  throw ERROR_NO_ITEM.create(livingentity.getName().getString());
               }
            } else if (p_137016_.size() == 1) {
               throw ERROR_NOT_LIVING_ENTITY.create(entity.getName().getString());
            }
         }

         if (i == 0) {
            throw ERROR_NOTHING_HAPPENED.create();
         } else {
            if (p_137016_.size() == 1) {
               p_137015_.sendSuccess(Component.translatable("commands.enchant.success.single", p_137017_.getFullname(p_137018_), p_137016_.iterator().next().getDisplayName()), true);
            } else {
               p_137015_.sendSuccess(Component.translatable("commands.enchant.success.multiple", p_137017_.getFullname(p_137018_), p_137016_.size()), true);
            }

            return i;
       }
   }
}