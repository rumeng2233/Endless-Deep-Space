
package shirumengya.rumeng.reborn.endless_deep_space.client.renderer;

import shirumengya.rumeng.reborn.endless_deep_space.entity.ScreamingGhastEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.GhastModel;
import com.mojang.blaze3d.vertex.PoseStack;

public class ScreamingGhastRenderer extends MobRenderer<ScreamingGhastEntity, GhastModel<ScreamingGhastEntity>> {

private static final ResourceLocation GHAST_LOCATION = new ResourceLocation("textures/entity/ghast/ghast.png");
private static final ResourceLocation GHAST_SHOOTING_LOCATION = new ResourceLocation("textures/entity/ghast/ghast_shooting.png");

	public ScreamingGhastRenderer(EntityRendererProvider.Context context) {
		super(context, new GhastModel(context.bakeLayer(ModelLayers.GHAST)), 1.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(ScreamingGhastEntity entity) {
		return entity.isCharging() ? GHAST_SHOOTING_LOCATION : GHAST_LOCATION;
	}

	protected void scale(ScreamingGhastEntity p_114757_, PoseStack p_114758_, float p_114759_) {
		float i = ((4.5F * p_114757_.ScreamingGhastDeathTime) / 10);
		if (i < 4.5F) {
			i = 4.5F;
		}
      	p_114758_.scale(i, i, i);
   	}
}
