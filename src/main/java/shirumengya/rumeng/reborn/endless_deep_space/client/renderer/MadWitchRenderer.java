
package shirumengya.rumeng.reborn.endless_deep_space.client.renderer;

import shirumengya.rumeng.reborn.endless_deep_space.entity.MadWitchEntity;
import shirumengya.rumeng.reborn.endless_deep_space.custom.client.renderer.entity.layers.MadWitchArmorLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.WitchModel;

public class MadWitchRenderer extends MobRenderer<MadWitchEntity, WitchModel<MadWitchEntity>> {
	public MadWitchRenderer(EntityRendererProvider.Context context) {
		super(context, new WitchModel(context.bakeLayer(ModelLayers.WITCH)), 0.5f);
		this.addLayer(new MadWitchArmorLayer(this, context.getModelSet()));
	}

	@Override
	public ResourceLocation getTextureLocation(MadWitchEntity entity) {
		return new ResourceLocation("endless_deep_space:textures/entities/mad_witch.png");
	}
}
