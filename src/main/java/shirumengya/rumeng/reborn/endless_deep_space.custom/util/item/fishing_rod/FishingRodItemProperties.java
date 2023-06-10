package shirumengya.rumeng.reborn.endless_deep_space.custom.util.item.fishing_rod;

import shirumengya.rumeng.reborn.endless_deep_space.custom.init.ItemInit;
import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.player.Player;

public class FishingRodItemProperties {
    public static void addCustomFishingRodItemProperties() {
        makeFishingRod(ItemInit.DURABLE_FISHING_ROD.get());
    }

    private static void makeFishingRod(Item item) {
        ItemProperties.register(item, new ResourceLocation("cast"), (p_174585_, p_174586_, p_174587_, p_174588_) -> {
         if (p_174587_ == null) {
            return 0.0F;
         } else {
            boolean flag = p_174587_.getMainHandItem() == p_174585_;
            boolean flag1 = p_174587_.getOffhandItem() == p_174585_;
            
            return (flag || flag1) && p_174587_ instanceof Player && ((Player)p_174587_).fishing != null ? 1.0F : 0.0F;
         }
      });
    }
}
