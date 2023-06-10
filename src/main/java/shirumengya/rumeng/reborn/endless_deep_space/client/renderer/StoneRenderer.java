
package shirumengya.rumeng.reborn.endless_deep_space.client.renderer;

import shirumengya.rumeng.reborn.endless_deep_space.entity.StoneEntity;
import shirumengya.rumeng.reborn.endless_deep_space.client.model.Modelcustom_model;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class StoneRenderer extends MobRenderer<StoneEntity, Modelcustom_model<StoneEntity>> {
	public StoneRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelcustom_model(context.bakeLayer(Modelcustom_model.LAYER_LOCATION)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(StoneEntity entity) {
		return new ResourceLocation("endless_deep_space:textures/entities/stone.png");
	}
}
