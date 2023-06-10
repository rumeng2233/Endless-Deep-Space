package shirumengya.rumeng.reborn.endless_deep_space.custom.client.renderer.entity.layers;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.WitherBossModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import shirumengya.rumeng.reborn.endless_deep_space.entity.WitherestEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.renderer.entity.layers.EnergySwirlLayer;

@OnlyIn(Dist.CLIENT)
public class WitherestArmorLayer extends EnergySwirlLayer<WitherestEntity, WitherBossModel<WitherestEntity>> {
//   private static final ResourceLocation WITHER_ARMOR_LOCATION = new ResourceLocation("textures/entity/wither/wither_armor.png");
   private static final ResourceLocation WITHER_ARMOR_LOCATION = new ResourceLocation("textures/entity/creeper/creeper_armor.png");
   private static final ResourceLocation WITHER_ARMOR_LOCATION_ONE = new ResourceLocation("textures/misc/enchanted_item_glint.png");
   private final WitherBossModel<WitherestEntity> model;

   public WitherestArmorLayer(RenderLayerParent<WitherestEntity, WitherBossModel<WitherestEntity>> p_174554_, EntityModelSet p_174555_) {
      super(p_174554_);
      this.model = new WitherBossModel<>(p_174555_.bakeLayer(ModelLayers.WITHER_ARMOR));
   }

   protected float xOffset(float p_117702_) {
      return Mth.cos(p_117702_ * 0.02F) * 3.0F;
   }

   protected ResourceLocation getTextureLocation() {
      return WITHER_ARMOR_LOCATION;
   }

   protected EntityModel<WitherestEntity> model() {
      return this.model;
   }
}