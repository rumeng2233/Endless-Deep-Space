/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package shirumengya.rumeng.reborn.endless_deep_space.custom.init;

import shirumengya.rumeng.reborn.endless_deep_space.EndlessDeepSpaceMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import shirumengya.rumeng.reborn.endless_deep_space.init.*;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.EntityType;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EndlessDeepSpaceModAttributes {
	public static final DeferredRegister<Attribute> REGISTRY = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, EndlessDeepSpaceMod.MODID);
	public static final RegistryObject<Attribute> RANDOM_REGENERATION_PROBABILITY = REGISTRY.register("random_regeneration_probability",
			() -> (new RangedAttribute(EndlessDeepSpaceMod.MODID + ".attribute" + ".random_regeneration_probability", 0, 0, 1)).setSyncable(true));
	public static final RegistryObject<Attribute> RANDOM_REGENERATION_HEALTH = REGISTRY.register("random_regeneration_health",
			() -> (new RangedAttribute(EndlessDeepSpaceMod.MODID + ".attribute" + ".random_regeneration_health", 0, 0, 2048)).setSyncable(true));
	public static final RegistryObject<Attribute> HEAL_UNABLE = REGISTRY.register("heal_unable",
			() -> (new RangedAttribute(EndlessDeepSpaceMod.MODID + ".attribute" + ".heal_unable", 0, 0, 1)).setSyncable(true));
	public static final RegistryObject<Attribute> CANNOT_BE_PLACED = REGISTRY.register("cannot_be_placed",
			() -> (new RangedAttribute(EndlessDeepSpaceMod.MODID + ".attribute" + ".cannot_be_placed", 0, 0, 10)).setSyncable(true));
	public static final RegistryObject<Attribute> CANNOT_MINE = REGISTRY.register("cannot_mine",
			() -> (new RangedAttribute(EndlessDeepSpaceMod.MODID + ".attribute" + ".cannot_mine", 0, 0, 10)).setSyncable(true));
	public static final RegistryObject<Attribute> TELEPORT_FAILURE_PROBABILITY = REGISTRY.register("teleport_failure_probability",
			() -> (new RangedAttribute(EndlessDeepSpaceMod.MODID + ".attribute" + ".teleport_failure_probability", 0, 0, 10)).setSyncable(true));
	public static final RegistryObject<Attribute> DAMAGE_REDUCTION = REGISTRY.register("damage_reduction",
			() -> (new RangedAttribute(EndlessDeepSpaceMod.MODID + ".attribute" + ".damage_reduction", 0, -2000000000, 2000000000))
					.setSyncable(true));
	public static final RegistryObject<Attribute> DAMAGE_PROTECTION_TIME = REGISTRY.register("damage_protection_time",
			() -> (new RangedAttribute(EndlessDeepSpaceMod.MODID + ".attribute" + ".damage_protection_time", 20, -2000000000, 2000000000))
					.setSyncable(true));
	public static final RegistryObject<Attribute> DESTROY_SPEED = REGISTRY.register("destroy_speed",
			() -> (new RangedAttribute(EndlessDeepSpaceMod.MODID + ".attribute" + ".destroy_speed", 1, -2000000000, 2000000000))
					.setSyncable(true));
	public static final RegistryObject<Attribute> MAX_SHIELD = REGISTRY.register("max_shield",
			() -> (new RangedAttribute(EndlessDeepSpaceMod.MODID + ".attribute" + ".max_shield", 0, 0, 2000000000))
					.setSyncable(true));

	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			REGISTRY.register(FMLJavaModLoadingContext.get().getModEventBus());
		});
	}

	@SubscribeEvent
	public static void addAttributes(EntityAttributeModificationEvent event) {
		event.add(EntityType.PLAYER, RANDOM_REGENERATION_PROBABILITY.get());
		event.add(EndlessDeepSpaceModEntities.MAD_WITCH.get(), RANDOM_REGENERATION_PROBABILITY.get());
		event.add(EndlessDeepSpaceModEntities.WITHEREST.get(), RANDOM_REGENERATION_PROBABILITY.get());
		event.add(EntityType.ENDER_DRAGON, RANDOM_REGENERATION_PROBABILITY.get());
		event.add(EntityType.WARDEN, RANDOM_REGENERATION_PROBABILITY.get());
		event.add(EntityType.WITHER, RANDOM_REGENERATION_PROBABILITY.get());
		event.add(EntityType.PLAYER, RANDOM_REGENERATION_HEALTH.get());
		event.add(EndlessDeepSpaceModEntities.MAD_WITCH.get(), RANDOM_REGENERATION_HEALTH.get());
		event.add(EndlessDeepSpaceModEntities.WITHEREST.get(), RANDOM_REGENERATION_HEALTH.get());
		event.add(EntityType.ENDER_DRAGON, RANDOM_REGENERATION_HEALTH.get());
		event.add(EntityType.WARDEN, RANDOM_REGENERATION_HEALTH.get());
		event.add(EntityType.WITHER, RANDOM_REGENERATION_HEALTH.get());
		event.add(EntityType.PLAYER, HEAL_UNABLE.get());
		event.add(EntityType.PLAYER, CANNOT_BE_PLACED.get());
		event.add(EntityType.PLAYER, CANNOT_MINE.get());
		event.add(EntityType.ENDERMAN, TELEPORT_FAILURE_PROBABILITY.get());
		event.add(EntityType.SHULKER, TELEPORT_FAILURE_PROBABILITY.get());
		event.add(EntityType.PLAYER, TELEPORT_FAILURE_PROBABILITY.get());
		event.add(EntityType.PLAYER, DAMAGE_REDUCTION.get());
		event.add(EntityType.PLAYER, DESTROY_SPEED.get());
		event.add(EntityType.WITHER, MAX_SHIELD.get(), 600);
		event.add(EndlessDeepSpaceModEntities.WITHEREST.get(), MAX_SHIELD.get(), 600);
		event.add(EndlessDeepSpaceModEntities.THUNDER_DROWNED.get(), MAX_SHIELD.get(), 60);
	}
}
