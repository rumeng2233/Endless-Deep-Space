package shirumengya.rumeng.reborn.endless_deep_space.custom.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.util.Mth;
import net.minecraft.world.item.*;

public class PocketKnifeItem extends SwordItem implements Vanishable {
   private final float attackDamage;
   private final Multimap<Attribute, AttributeModifier> defaultModifiers;

   public PocketKnifeItem(Tier p_43269_, int p_43270_, float p_43271_, Item.Properties p_43272_) {
      super(p_43269_, p_43270_, p_43271_, p_43272_);
      this.attackDamage = (float)p_43270_ + p_43269_.getAttackDamageBonus();
      ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
      builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", (double)this.attackDamage, AttributeModifier.Operation.ADDITION));
      builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", (double)p_43271_, AttributeModifier.Operation.ADDITION));
      this.defaultModifiers = builder.build();
   }

   @Override
   public float getDamage() {
      return this.attackDamage;
   }

   @Override
   public boolean canAttackBlock(BlockState p_43291_, Level p_43292_, BlockPos p_43293_, Player p_43294_) {
      return !p_43294_.isCreative();
   }

   @Override
   public float getDestroySpeed(ItemStack p_43288_, BlockState p_43289_) {
      if (p_43289_.is(Blocks.COBWEB)) {
         return 20.0F;
      } else {
         Material material = p_43289_.getMaterial();
         return material != Material.PLANT && material != Material.REPLACEABLE_PLANT && !p_43289_.is(BlockTags.LEAVES) && material != Material.VEGETABLE ? 1.0F : 1.5F;
      }
   }

   @Override
   public boolean hurtEnemy(ItemStack p_43278_, LivingEntity p_43279_, LivingEntity p_43280_) {
      p_43278_.hurtAndBreak(1, p_43280_, (p_43296_) -> {
         p_43296_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
      });
      return true;
   }

   @Override
   public boolean mineBlock(ItemStack p_43282_, Level p_43283_, BlockState p_43284_, BlockPos p_43285_, LivingEntity p_43286_) {
      if (p_43284_.getDestroySpeed(p_43283_, p_43285_) != 0.0F) {
         p_43282_.hurtAndBreak(4, p_43286_, (p_43276_) -> {
            p_43276_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
         });
      }

      return true;
   }

   @Override
   public boolean isCorrectToolForDrops(BlockState p_43298_) {
      return p_43298_.is(Blocks.COBWEB);
   }

   @Override
   public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot p_43274_) {
      return p_43274_ == EquipmentSlot.MAINHAND ? this.defaultModifiers : super.getDefaultAttributeModifiers(p_43274_);
   }

   @Override
   public boolean canPerformAction(ItemStack stack, net.minecraftforge.common.ToolAction toolAction) {
      return net.minecraftforge.common.ToolActions.DEFAULT_SWORD_ACTIONS.contains(toolAction);
   }

   @Override
   public int getBarColor(ItemStack p_150901_) {
     float f = Math.max(0.0F, ((float)this.getMaxDamage() - (float)p_150901_.getDamageValue()) / (float)this.getMaxDamage());
     return Mth.hsvToRgb(f / 2.0F, 1.0F, 1.0F);
   }
}