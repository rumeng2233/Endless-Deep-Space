package shirumengya.rumeng.reborn.endless_deep_space.custom.potion;

import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.entity.ai.attributes.Attribute;

public class AttributeEffect extends MobEffect {
	
	public AttributeEffect(MobEffectCategory category, int color, Attribute attribute, String uuid, double num, AttributeModifier.Operation operation) {
		super(category, color);
		this.addAttributeModifier(attribute, uuid, num, operation);
	}
	
}
