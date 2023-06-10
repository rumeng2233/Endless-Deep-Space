package shirumengya.rumeng.reborn.endless_deep_space.custom.client.renderer.entity.layers;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import shirumengya.rumeng.reborn.endless_deep_space.entity.MadWitchEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.renderer.entity.layers.EnergySwirlLayer;
import net.minecraft.client.model.WitchModel;

@OnlyIn(Dist.CLIENT)
public class MadWitchArmorLayer extends EnergySwirlLayer<MadWitchEntity, WitchModel<MadWitchEntity>> {
   private static final ResourceLocation ARMOR_LOCATION = new ResourceLocation("endless_deep_space:textures/entities/mad_witch_armor.png");
   private final WitchModel<MadWitchEntity> model;

   public MadWitchArmorLayer(RenderLayerParent<MadWitchEntity, WitchModel<MadWitchEntity>> p_174554_, EntityModelSet p_174555_) {
      super(p_174554_);
      this.model = new WitchModel<>(p_174555_.bakeLayer(ModelLayers.WITCH));
   }

   protected float xOffset(float p_117702_) {
      return Mth.cos(p_117702_ * 0.02F) * 3.0F;
   }

   protected ResourceLocation getTextureLocation() {
      return ARMOR_LOCATION;
   }

   protected EntityModel<MadWitchEntity> model() {
      return this.model;
   }
}