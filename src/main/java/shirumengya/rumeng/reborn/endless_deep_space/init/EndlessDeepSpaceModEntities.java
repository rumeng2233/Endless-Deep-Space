
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package shirumengya.rumeng.reborn.endless_deep_space.init;

import shirumengya.rumeng.reborn.endless_deep_space.entity.WitherestEntity;
<<<<<<< Updated upstream
=======
import shirumengya.rumeng.reborn.endless_deep_space.entity.ThunderDrownedEntity;
import shirumengya.rumeng.reborn.endless_deep_space.entity.TheVoidCubeEntity;
>>>>>>> Stashed changes
import shirumengya.rumeng.reborn.endless_deep_space.entity.StoneEntity;
import shirumengya.rumeng.reborn.endless_deep_space.entity.ScreamingGhastEntity;
import shirumengya.rumeng.reborn.endless_deep_space.entity.MadWitchEntity;
import shirumengya.rumeng.reborn.endless_deep_space.entity.IEntity;
import shirumengya.rumeng.reborn.endless_deep_space.entity.EnderBowEntity;
import shirumengya.rumeng.reborn.endless_deep_space.EndlessDeepSpaceMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EndlessDeepSpaceModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, EndlessDeepSpaceMod.MODID);
	public static final RegistryObject<EntityType<WitherestEntity>> WITHEREST = register("witherest", EntityType.Builder.<WitherestEntity>of(WitherestEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(128)
			.setUpdateInterval(3).setCustomClientFactory(WitherestEntity::new).fireImmune().sized(0.9f, 3.5f));
	public static final RegistryObject<EntityType<StoneEntity>> STONE = register("stone",
			EntityType.Builder.<StoneEntity>of(StoneEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(StoneEntity::new).fireImmune().sized(1f, 1f));
	public static final RegistryObject<EntityType<IEntity>> I = register("i",
			EntityType.Builder.<IEntity>of(IEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(IEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<MadWitchEntity>> MAD_WITCH = register("mad_witch",
			EntityType.Builder.<MadWitchEntity>of(MadWitchEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).setCustomClientFactory(MadWitchEntity::new).fireImmune().sized(0.6f, 1.95f));
	public static final RegistryObject<EntityType<EnderBowEntity>> ENDER_BOW = register("projectile_ender_bow",
			EntityType.Builder.<EnderBowEntity>of(EnderBowEntity::new, MobCategory.MISC).setCustomClientFactory(EnderBowEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
<<<<<<< Updated upstream
	public static final RegistryObject<EntityType<GhastlierEntity>> GHASTLIER = register("ghastlier",
			EntityType.Builder.<GhastlierEntity>of(GhastlierEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(100).setUpdateInterval(3).setCustomClientFactory(GhastlierEntity::new)

					.sized(4f, 4f));
=======
	public static final RegistryObject<EntityType<ScreamingGhastEntity>> SCREAMING_GHAST = register("screaming_ghast", EntityType.Builder.<ScreamingGhastEntity>of(ScreamingGhastEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(640).setUpdateInterval(3).setCustomClientFactory(ScreamingGhastEntity::new).fireImmune().sized(4f, 4f));
	public static final RegistryObject<EntityType<TheVoidCubeEntity>> THE_VOID_CUBE = register("the_void_cube", EntityType.Builder.<TheVoidCubeEntity>of(TheVoidCubeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(4096).setUpdateInterval(3).setCustomClientFactory(TheVoidCubeEntity::new).fireImmune().sized(10f, 10f));
	public static final RegistryObject<EntityType<ThunderDrownedEntity>> THUNDER_DROWNED = register("thunder_drowned",
			EntityType.Builder.<ThunderDrownedEntity>of(ThunderDrownedEntity::new, MobCategory.WATER_CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(320).setUpdateInterval(3).setCustomClientFactory(ThunderDrownedEntity::new)

					.sized(0.6f, 1.95f));
>>>>>>> Stashed changes

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			WitherestEntity.init();
			StoneEntity.init();
			IEntity.init();
			MadWitchEntity.init();
<<<<<<< Updated upstream
			GhastlierEntity.init();
=======
			ScreamingGhastEntity.init();
			TheVoidCubeEntity.init();
			ThunderDrownedEntity.init();
>>>>>>> Stashed changes
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(WITHEREST.get(), WitherestEntity.createAttributes().build());
		event.put(STONE.get(), StoneEntity.createAttributes().build());
		event.put(I.get(), IEntity.createAttributes().build());
		event.put(MAD_WITCH.get(), MadWitchEntity.createAttributes().build());
<<<<<<< Updated upstream
		event.put(GHASTLIER.get(), GhastlierEntity.createAttributes().build());
=======
		event.put(SCREAMING_GHAST.get(), ScreamingGhastEntity.createAttributes().build());
		event.put(THE_VOID_CUBE.get(), TheVoidCubeEntity.createAttributes().build());
		event.put(THUNDER_DROWNED.get(), ThunderDrownedEntity.createAttributes().build());
>>>>>>> Stashed changes
	}
}
