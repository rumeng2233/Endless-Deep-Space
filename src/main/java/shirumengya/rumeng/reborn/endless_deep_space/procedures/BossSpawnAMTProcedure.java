package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.custom.init.EndlessDeepSpaceModAttributes;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BossSpawnAMTProcedure {
	@SubscribeEvent
	public static void onEntitySpawned(EntityJoinLevelEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity.getType().is(TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation("endless_deep_space:boss")))) {
			if (((LivingEntity) entity).getAttribute(EndlessDeepSpaceModAttributes.RANDOM_REGENERATION_PROBABILITY.get()) != null
					&& ((LivingEntity) entity).getAttribute(EndlessDeepSpaceModAttributes.RANDOM_REGENERATION_HEALTH.get()) != null) {
				((LivingEntity) entity).getAttribute(EndlessDeepSpaceModAttributes.RANDOM_REGENERATION_PROBABILITY.get())
						.setBaseValue((Mth.nextDouble(RandomSource.create(), 0, 0.1)));
				((LivingEntity) entity).getAttribute(EndlessDeepSpaceModAttributes.RANDOM_REGENERATION_HEALTH.get())
						.setBaseValue((Mth.nextDouble(RandomSource.create(), 0, 1.5)));
			}
		}
	}
}
