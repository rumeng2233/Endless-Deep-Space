
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package shirumengya.rumeng.reborn.endless_deep_space.init;

import shirumengya.rumeng.reborn.endless_deep_space.world.features.ores.RagingFireOreFeature;
import shirumengya.rumeng.reborn.endless_deep_space.world.features.ores.FrozenOreFeature;
import shirumengya.rumeng.reborn.endless_deep_space.world.features.ReplicaOfTheEnderAltarFeature;
import shirumengya.rumeng.reborn.endless_deep_space.world.features.ReplicaEndGatewayFeature;
import shirumengya.rumeng.reborn.endless_deep_space.world.features.BrokenTowerFeature;
import shirumengya.rumeng.reborn.endless_deep_space.world.features.BrokenReplicaEnderAltar9Feature;
import shirumengya.rumeng.reborn.endless_deep_space.world.features.BrokenReplicaEnderAltar8Feature;
import shirumengya.rumeng.reborn.endless_deep_space.world.features.BrokenReplicaEnderAltar7Feature;
import shirumengya.rumeng.reborn.endless_deep_space.world.features.BrokenReplicaEnderAltar6Feature;
import shirumengya.rumeng.reborn.endless_deep_space.world.features.BrokenReplicaEnderAltar5Feature;
import shirumengya.rumeng.reborn.endless_deep_space.world.features.BrokenReplicaEnderAltar4Feature;
import shirumengya.rumeng.reborn.endless_deep_space.world.features.BrokenReplicaEnderAltar3Feature;
import shirumengya.rumeng.reborn.endless_deep_space.world.features.BrokenReplicaEnderAltar2Feature;
import shirumengya.rumeng.reborn.endless_deep_space.world.features.BrokenReplicaEnderAltar1Feature;
import shirumengya.rumeng.reborn.endless_deep_space.world.features.BrokenReplicaEnderAltar10Feature;
import shirumengya.rumeng.reborn.endless_deep_space.EndlessDeepSpaceMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.levelgen.feature.Feature;

@Mod.EventBusSubscriber
public class EndlessDeepSpaceModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, EndlessDeepSpaceMod.MODID);
	public static final RegistryObject<Feature<?>> REPLICA_OF_THE_ENDER_ALTAR = REGISTRY.register("replica_of_the_ender_altar", ReplicaOfTheEnderAltarFeature::feature);
	public static final RegistryObject<Feature<?>> BROKEN_REPLICA_ENDER_ALTAR_1 = REGISTRY.register("broken_replica_ender_altar_1", BrokenReplicaEnderAltar1Feature::feature);
	public static final RegistryObject<Feature<?>> BROKEN_REPLICA_ENDER_ALTAR_2 = REGISTRY.register("broken_replica_ender_altar_2", BrokenReplicaEnderAltar2Feature::feature);
	public static final RegistryObject<Feature<?>> BROKEN_REPLICA_ENDER_ALTAR_3 = REGISTRY.register("broken_replica_ender_altar_3", BrokenReplicaEnderAltar3Feature::feature);
	public static final RegistryObject<Feature<?>> BROKEN_REPLICA_ENDER_ALTAR_4 = REGISTRY.register("broken_replica_ender_altar_4", BrokenReplicaEnderAltar4Feature::feature);
	public static final RegistryObject<Feature<?>> BROKEN_REPLICA_ENDER_ALTAR_5 = REGISTRY.register("broken_replica_ender_altar_5", BrokenReplicaEnderAltar5Feature::feature);
	public static final RegistryObject<Feature<?>> BROKEN_REPLICA_ENDER_ALTAR_6 = REGISTRY.register("broken_replica_ender_altar_6", BrokenReplicaEnderAltar6Feature::feature);
	public static final RegistryObject<Feature<?>> BROKEN_REPLICA_ENDER_ALTAR_7 = REGISTRY.register("broken_replica_ender_altar_7", BrokenReplicaEnderAltar7Feature::feature);
	public static final RegistryObject<Feature<?>> BROKEN_REPLICA_ENDER_ALTAR_8 = REGISTRY.register("broken_replica_ender_altar_8", BrokenReplicaEnderAltar8Feature::feature);
	public static final RegistryObject<Feature<?>> BROKEN_REPLICA_ENDER_ALTAR_9 = REGISTRY.register("broken_replica_ender_altar_9", BrokenReplicaEnderAltar9Feature::feature);
	public static final RegistryObject<Feature<?>> BROKEN_REPLICA_ENDER_ALTAR_10 = REGISTRY.register("broken_replica_ender_altar_10", BrokenReplicaEnderAltar10Feature::feature);
	public static final RegistryObject<Feature<?>> REPLICA_END_GATEWAY = REGISTRY.register("replica_end_gateway", ReplicaEndGatewayFeature::feature);
	public static final RegistryObject<Feature<?>> BROKEN_TOWER = REGISTRY.register("broken_tower", BrokenTowerFeature::feature);
	public static final RegistryObject<Feature<?>> RAGING_FIRE_ORE = REGISTRY.register("raging_fire_ore", RagingFireOreFeature::feature);
	public static final RegistryObject<Feature<?>> FROZEN_ORE = REGISTRY.register("frozen_ore", FrozenOreFeature::feature);
}
