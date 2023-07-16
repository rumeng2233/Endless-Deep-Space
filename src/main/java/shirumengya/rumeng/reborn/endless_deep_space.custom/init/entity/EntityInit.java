
package shirumengya.rumeng.reborn.endless_deep_space.custom.init.entity;

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
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import shirumengya.rumeng.reborn.endless_deep_space.custom.entity.*;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityInit {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, "endless_deep_space.custom");

<<<<<<< Updated upstream
=======
	public static final RegistryObject<EntityType<BossItem>> BOSS_ITEM = register("boss_item",
			EntityType.Builder.<BossItem>of(BossItem::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.25f, 0.25f));

	public static final RegistryObject<EntityType<LikeEnderDragonDeathAnimationEffect>> LIKE_ENDER_DRAGON_DEATH_ANIMATION_EFFECT = register("ender_dragon_death_animation_effect",
			EntityType.Builder.<LikeEnderDragonDeathAnimationEffect>of(LikeEnderDragonDeathAnimationEffect::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).fireImmune().sized(0.5f, 0.5f));

	public static final RegistryObject<EntityType<SuperBomb>> SUPER_BOMB = register("super_bomb",
			EntityType.Builder.<SuperBomb>of(SuperBomb::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).fireImmune().noSummon().sized(0.5f, 0.5f));

	public static final RegistryObject<EntityType<ColorfulLightningBolt>> COLORFUL_LIGHTNING_BOLT = register("colorful_lightning_bolt",
			EntityType.Builder.<ColorfulLightningBolt>of(ColorfulLightningBolt::new, MobCategory.MISC).noSave().sized(0.0F, 0.0F).clientTrackingRange(16).updateInterval(Integer.MAX_VALUE));

>>>>>>> Stashed changes
	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}
}
