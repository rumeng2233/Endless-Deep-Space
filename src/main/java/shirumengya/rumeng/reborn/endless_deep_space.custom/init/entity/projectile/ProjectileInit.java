
package shirumengya.rumeng.reborn.endless_deep_space.custom.init.entity.projectile;

import shirumengya.rumeng.reborn.endless_deep_space.EndlessDeepSpaceMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import shirumengya.rumeng.reborn.endless_deep_space.custom.entity.projectile.*;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ProjectileInit {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, "endless_deep_space.custom");
	
	public static final RegistryObject<EntityType<EnderDragonWindBomb>> ENDER_DRAGON_WIND_BOMB = register("ender_dragon_wind_bomb",
			EntityType.Builder.<EnderDragonWindBomb>of(EnderDragonWindBomb::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(8.0f, 8.0f));
	public static final RegistryObject<EntityType<PenetratingBowArrow>> PENETRATING_BOW_ARROW = register("penetrating_bow_arrow",
			EntityType.Builder.<PenetratingBowArrow>of(PenetratingBowArrow::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
<<<<<<< Updated upstream
=======
	public static final RegistryObject<EntityType<ScreamingGhastFirball>> SCREAMING_GHAST_FIRBALL = register("screaming_ghast_firball",
			EntityType.Builder.<ScreamingGhastFirball>of(ScreamingGhastFirball::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(1.0f, 1.0f));
	public static final RegistryObject<EntityType<ScreamingGhastMagicBullet>> SCREAMING_GHAST_MAGIC_BULLET = register("screaming_ghast_magic_bullet",
			EntityType.Builder.<ScreamingGhastMagicBullet>of(ScreamingGhastMagicBullet::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.3125f, 0.3125f));
	public static final RegistryObject<EntityType<TrackingArrow>> TRACKING_ARROW = register("tracking_arrow",
			EntityType.Builder.<TrackingArrow>of(TrackingArrow::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<ScreamingGhastGravityBomb>> SCREAMING_GHAST_GRAVITY_BOMB = register("screaming_ghast_gravity_bomb",
			EntityType.Builder.<ScreamingGhastGravityBomb>of(ScreamingGhastGravityBomb::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<GravityArrow>> GRAVITY_ARROW = register("gravity_arrow",
			EntityType.Builder.<GravityArrow>of(GravityArrow::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<AntigravityArrow>> ANTIGRAVITY_ARROW = register("antigravity_arrow",
			EntityType.Builder.<AntigravityArrow>of(AntigravityArrow::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
>>>>>>> Stashed changes

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			
		});
	}
}
