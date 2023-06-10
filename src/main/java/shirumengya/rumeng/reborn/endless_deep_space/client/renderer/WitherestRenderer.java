
package shirumengya.rumeng.reborn.endless_deep_space.client.renderer;
import shirumengya.rumeng.reborn.endless_deep_space.entity.WitherestEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.WitherBossModel;
import net.minecraft.client.renderer.entity.layers.WitherArmorLayer;
import net.minecraft.core.BlockPos;
import com.mojang.blaze3d.vertex.PoseStack;
import shirumengya.rumeng.reborn.endless_deep_space.custom.client.renderer.entity.layers.WitherestArmorLayer;

public class WitherestRenderer extends MobRenderer<WitherestEntity, WitherBossModel<WitherestEntity>> {

   private static final ResourceLocation WITHER_INVULNERABLE_LOCATION = new ResourceLocation("textures/entity/wither/wither_invulnerable.png");
   private static final ResourceLocation WITHER_LOCATION = new ResourceLocation("textures/entity/wither/wither.png");

	public WitherestRenderer(EntityRendererProvider.Context context) {
		super(context, new WitherBossModel(context.bakeLayer(ModelLayers.WITHER)), 1f);
		this.addLayer(new WitherestArmorLayer(this, context.getModelSet()));
/*		this.addLayer(new EyesLayer<WitherestEntity, WitherBossModel<WitherestEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("endless_deep_space:textures/entities/witherest.png"));
			}
		});*/
	}

	@Override
	protected int getBlockLightLevel(WitherestEntity p_116443_, BlockPos p_116444_) {
      	return 15;
   	}

	@Override
	public ResourceLocation getTextureLocation(WitherestEntity entity) {
		int i = entity.getInvulnerableTicks();
      	return i > 0 && (i > 80 || i / 5 % 2 != 1) ? WITHER_LOCATION : WITHER_INVULNERABLE_LOCATION;
	}

	@Override
   protected void scale(WitherestEntity p_116439_, PoseStack p_116440_, float p_116441_) {
      float f = 2.0F;
      int i = p_116439_.getInvulnerableTicks();
      if (i > 0) {
         f -= ((float)i - p_116441_) / 220.0F * 0.5F;
      }
      if (p_116439_.WitherestDeathTime > 0) {
      	f = 20.0F;
      }
      p_116440_.scale(f, f, f);
   }
}
