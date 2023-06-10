package shirumengya.rumeng.reborn.endless_deep_space.custom.util.item.crossbow;

import shirumengya.rumeng.reborn.endless_deep_space.custom.init.ItemInit;
import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.core.Registry;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.Items;

public class CrossbowItemProperties {
    public static void addCustomCrossbowItemProperties() {
        makeCrossbow(ItemInit.DURABLE_CROSSBOW.get());
    }

    private static void makeCrossbow(Item item) {
        ItemProperties.register(item, new ResourceLocation("pull"), (p_174610_, p_174611_, p_174612_, p_174613_) -> {
         if (p_174612_ == null) {
            return 0.0F;
         } else {
            return CrossbowItem.isCharged(p_174610_) ? 0.0F : (float)(p_174610_.getUseDuration() - p_174612_.getUseItemRemainingTicks()) / (float)CrossbowItem.getChargeDuration(p_174610_);
         }
      });

        ItemProperties.register(item, new ResourceLocation("pulling"), (p_174605_, p_174606_, p_174607_, p_174608_) -> {
         return p_174607_ != null && p_174607_.isUsingItem() && p_174607_.getUseItem() == p_174605_ && !CrossbowItem.isCharged(p_174605_) ? 1.0F : 0.0F;
      });

      	ItemProperties.register(item, new ResourceLocation("charged"), (p_174600_, p_174601_, p_174602_, p_174603_) -> {
         return p_174602_ != null && CrossbowItem.isCharged(p_174600_) ? 1.0F : 0.0F;
      });

      	ItemProperties.register(item, new ResourceLocation("firework"), (p_174595_, p_174596_, p_174597_, p_174598_) -> {
         return p_174597_ != null && CrossbowItem.isCharged(p_174595_) && CrossbowItem.containsChargedProjectile(p_174595_, Items.FIREWORK_ROCKET) ? 1.0F : 0.0F;
      });
    }
}
