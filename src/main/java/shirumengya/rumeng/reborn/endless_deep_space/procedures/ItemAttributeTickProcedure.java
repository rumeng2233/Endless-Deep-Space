<<<<<<< Updated upstream
package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModEnchantments;
import shirumengya.rumeng.reborn.endless_deep_space.EndlessDeepSpaceMod;
import shirumengya.rumeng.reborn.endless_deep_space.custom.init.EndlessDeepSpaceModAttributes;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.ItemAttributeModifierEvent;
import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nullable;

import java.util.UUID;

@Mod.EventBusSubscriber
public class ItemAttributeTickProcedure {
	@SubscribeEvent
	public static void addAttributeModifier(ItemAttributeModifierEvent event) {
		execute(event, event.getItemStack());
	}

	public static void execute(ItemStack itemstack) {
		execute(null, itemstack);
	}

	private static void execute(@Nullable Event event, ItemStack itemstack) {
		if (itemstack.getItem() == Items.TOTEM_OF_UNDYING) {
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.MAINHAND) {
				_event.addModifier(EndlessDeepSpaceModAttributes.RANDOM_REGENERATION_PROBABILITY.get(),
						(new AttributeModifier(UUID.fromString("6a5773f4-8745-47dd-819d-ce3c7a0b150b"), EndlessDeepSpaceMod.MODID + "." + "random regeneration probability", 0.01, AttributeModifier.Operation.ADDITION)));
				_event.addModifier(EndlessDeepSpaceModAttributes.RANDOM_REGENERATION_HEALTH.get(),
						(new AttributeModifier(UUID.fromString("cc8ca3a0-0172-4a55-b47e-4827551177fe"), EndlessDeepSpaceMod.MODID + "." + "random regeneration health", 1, AttributeModifier.Operation.ADDITION)));
			}
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.OFFHAND) {
				_event.addModifier(EndlessDeepSpaceModAttributes.RANDOM_REGENERATION_PROBABILITY.get(),
						(new AttributeModifier(UUID.fromString("6a5773f4-8745-47dd-819d-ce3c7a0b150b"), EndlessDeepSpaceMod.MODID + "." + "random regeneration probability", 0.01, AttributeModifier.Operation.ADDITION)));
				_event.addModifier(EndlessDeepSpaceModAttributes.RANDOM_REGENERATION_HEALTH.get(),
						(new AttributeModifier(UUID.fromString("cc8ca3a0-0172-4a55-b47e-4827551177fe"), EndlessDeepSpaceMod.MODID + "." + "random regeneration health", 1, AttributeModifier.Operation.ADDITION)));
			}
		}
		if (itemstack.getItem() == Items.TURTLE_HELMET) {
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.HEAD) {
				_event.addModifier(ForgeMod.SWIM_SPEED.get(), (new AttributeModifier(UUID.fromString("5ec71f22-854e-4c56-9285-f1f185093bc9"), EndlessDeepSpaceMod.MODID + "." + "swim speed", 2, AttributeModifier.Operation.ADDITION)));
			}
		}
		if (itemstack.is(ItemTags.create(new ResourceLocation("endless_deep_space:pocket_knife")))) {
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.MAINHAND) {
				_event.addModifier(ForgeMod.ATTACK_RANGE.get(), (new AttributeModifier(UUID.fromString("572cffc5-52d1-4d28-acf4-66b99c62f701"), EndlessDeepSpaceMod.MODID + "." + "attack distance", (-1), AttributeModifier.Operation.ADDITION)));
				_event.addModifier(ForgeMod.REACH_DISTANCE.get(), (new AttributeModifier(UUID.fromString("4b19d26c-89d7-4eb8-9001-ca6abb4453cc"), EndlessDeepSpaceMod.MODID + "." + "reach distance", (-1), AttributeModifier.Operation.ADDITION)));
			}
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.OFFHAND) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE,
						(new AttributeModifier(UUID.fromString("cb68a608-1353-4f65-805e-604f8dbbdaa4"), EndlessDeepSpaceMod.MODID + "." + "attack damage", 0.2, AttributeModifier.Operation.MULTIPLY_TOTAL)));
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_SPEED,
						(new AttributeModifier(UUID.fromString("513b33cc-85d1-42e1-a3f6-2617436a0bae"), EndlessDeepSpaceMod.MODID + "." + "attack speed", 0.2, AttributeModifier.Operation.MULTIPLY_TOTAL)));
			}
		}
		if (itemstack.getItem() == Items.ELYTRA) {
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.CHEST) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR,
						(new AttributeModifier(UUID.fromString("8b44e61c-7409-4cb9-88a7-48596d85edcb"), EndlessDeepSpaceMod.MODID + "." + "armor", 8, AttributeModifier.Operation.ADDITION)));
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR_TOUGHNESS,
						(new AttributeModifier(UUID.fromString("b49f4f42-3388-4ccc-b11c-eaeed578db97"), EndlessDeepSpaceMod.MODID + "." + "armor toughness", 3, AttributeModifier.Operation.ADDITION)));
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.KNOCKBACK_RESISTANCE,
						(new AttributeModifier(UUID.fromString("9d8330a3-fda4-40ef-8874-668c1deba812"), EndlessDeepSpaceMod.MODID + "." + "knockback resistance", 0.1, AttributeModifier.Operation.ADDITION)));
				_event.addModifier(EndlessDeepSpaceModAttributes.RANDOM_REGENERATION_PROBABILITY.get(),
						(new AttributeModifier(UUID.fromString("64894212-85a6-4230-87ac-aacb527cde35"), EndlessDeepSpaceMod.MODID + "." + "random regeneration probability", 0.02, AttributeModifier.Operation.ADDITION)));
				_event.addModifier(EndlessDeepSpaceModAttributes.RANDOM_REGENERATION_HEALTH.get(),
						(new AttributeModifier(UUID.fromString("5e61ab91-d4d5-41a4-a6ed-8e83aedd50af"), EndlessDeepSpaceMod.MODID + "." + "random regeneration health", 2, AttributeModifier.Operation.ADDITION)));
				_event.addModifier(EndlessDeepSpaceModAttributes.DAMAGE_REDUCTION.get(),
						(new AttributeModifier(UUID.fromString("2d82fe63-f302-4a52-a550-85bceed75b79"), EndlessDeepSpaceMod.MODID + "." + "damage reduction", 2, AttributeModifier.Operation.ADDITION)));
			}
		}
		if (EnchantmentHelper.getItemEnchantmentLevel(EndlessDeepSpaceModEnchantments.CANNOT_MINE.get(), itemstack) != 0) {
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.MAINHAND) {
				_event.addModifier(EndlessDeepSpaceModAttributes.CANNOT_MINE.get(), (new AttributeModifier(UUID.fromString("83fe0c4c-e0e4-4a1f-8cea-ae836935d3d4"), EndlessDeepSpaceMod.MODID + "." + "cannot mine",
						(EnchantmentHelper.getItemEnchantmentLevel(EndlessDeepSpaceModEnchantments.CANNOT_MINE.get(), itemstack)), AttributeModifier.Operation.ADDITION)));
			}
		}
		if (EnchantmentHelper.getItemEnchantmentLevel(EndlessDeepSpaceModEnchantments.DAMAGE_INCREASE.get(), itemstack) != 0) {
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.CHEST) {
				_event.addModifier(EndlessDeepSpaceModAttributes.DAMAGE_REDUCTION.get(), (new AttributeModifier(UUID.fromString("17c3f555-d31e-40dd-b4e4-0d4d72f83692"), EndlessDeepSpaceMod.MODID + "." + "damage reduction",
						(-(EnchantmentHelper.getItemEnchantmentLevel(EndlessDeepSpaceModEnchantments.DAMAGE_INCREASE.get(), itemstack) * 4)), AttributeModifier.Operation.ADDITION)));
			}
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.FEET) {
				_event.addModifier(EndlessDeepSpaceModAttributes.DAMAGE_REDUCTION.get(), (new AttributeModifier(UUID.fromString("f86b0e7a-21dc-4d42-a830-866dc37a8bf5"), EndlessDeepSpaceMod.MODID + "." + "damage reduction",
						(-(EnchantmentHelper.getItemEnchantmentLevel(EndlessDeepSpaceModEnchantments.DAMAGE_INCREASE.get(), itemstack) * 4)), AttributeModifier.Operation.ADDITION)));
			}
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.HEAD) {
				_event.addModifier(EndlessDeepSpaceModAttributes.DAMAGE_REDUCTION.get(), (new AttributeModifier(UUID.fromString("c38ab33a-17eb-4f2c-a4ee-ea76c1a3d197"), EndlessDeepSpaceMod.MODID + "." + "damage reduction",
						(-(EnchantmentHelper.getItemEnchantmentLevel(EndlessDeepSpaceModEnchantments.DAMAGE_INCREASE.get(), itemstack) * 4)), AttributeModifier.Operation.ADDITION)));
			}
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.LEGS) {
				_event.addModifier(EndlessDeepSpaceModAttributes.DAMAGE_REDUCTION.get(), (new AttributeModifier(UUID.fromString("43f5f48f-104a-48e4-ba31-0ab9f53cede7"), EndlessDeepSpaceMod.MODID + "." + "damage reduction",
						(-(EnchantmentHelper.getItemEnchantmentLevel(EndlessDeepSpaceModEnchantments.DAMAGE_INCREASE.get(), itemstack) * 4)), AttributeModifier.Operation.ADDITION)));
			}
		}
		if (EnchantmentHelper.getItemEnchantmentLevel(EndlessDeepSpaceModEnchantments.BETTER_PROTECTION.get(), itemstack) != 0) {
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.CHEST) {
				_event.addModifier(EndlessDeepSpaceModAttributes.DAMAGE_REDUCTION.get(), (new AttributeModifier(UUID.fromString("81c2fd33-956b-46d3-9de9-94192ec9aab7"), EndlessDeepSpaceMod.MODID + "." + "damage reduction",
						(EnchantmentHelper.getItemEnchantmentLevel(EndlessDeepSpaceModEnchantments.BETTER_PROTECTION.get(), itemstack)), AttributeModifier.Operation.ADDITION)));
			}
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.FEET) {
				_event.addModifier(EndlessDeepSpaceModAttributes.DAMAGE_REDUCTION.get(), (new AttributeModifier(UUID.fromString("17f35279-8e84-45a8-9926-6975eb753eaa"), EndlessDeepSpaceMod.MODID + "." + "damage reduction",
						(EnchantmentHelper.getItemEnchantmentLevel(EndlessDeepSpaceModEnchantments.BETTER_PROTECTION.get(), itemstack)), AttributeModifier.Operation.ADDITION)));
			}
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.HEAD) {
				_event.addModifier(EndlessDeepSpaceModAttributes.DAMAGE_REDUCTION.get(), (new AttributeModifier(UUID.fromString("9804e659-f8a7-4e87-8419-32b052a04dde"), EndlessDeepSpaceMod.MODID + "." + "damage reduction",
						(EnchantmentHelper.getItemEnchantmentLevel(EndlessDeepSpaceModEnchantments.BETTER_PROTECTION.get(), itemstack)), AttributeModifier.Operation.ADDITION)));
			}
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.LEGS) {
				_event.addModifier(EndlessDeepSpaceModAttributes.DAMAGE_REDUCTION.get(), (new AttributeModifier(UUID.fromString("93d62a22-d15c-4834-b036-65fa5c3f8037"), EndlessDeepSpaceMod.MODID + "." + "damage reduction",
						(EnchantmentHelper.getItemEnchantmentLevel(EndlessDeepSpaceModEnchantments.BETTER_PROTECTION.get(), itemstack)), AttributeModifier.Operation.ADDITION)));
			}
		}
		if (EnchantmentHelper.getItemEnchantmentLevel(EndlessDeepSpaceModEnchantments.DAMAGE_REDUCTION.get(), itemstack) != 0) {
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.CHEST) {
				_event.addModifier(EndlessDeepSpaceModAttributes.DAMAGE_REDUCTION.get(), (new AttributeModifier(UUID.fromString("c9506258-3180-41a7-abc4-f637eee37873"), EndlessDeepSpaceMod.MODID + "." + "damage reduction",
						(EnchantmentHelper.getItemEnchantmentLevel(EndlessDeepSpaceModEnchantments.DAMAGE_REDUCTION.get(), itemstack) * 3), AttributeModifier.Operation.ADDITION)));
			}
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.FEET) {
				_event.addModifier(EndlessDeepSpaceModAttributes.DAMAGE_REDUCTION.get(), (new AttributeModifier(UUID.fromString("9dbc558a-9e55-49cb-be7f-3fdcf7abf055"), EndlessDeepSpaceMod.MODID + "." + "damage reduction",
						(EnchantmentHelper.getItemEnchantmentLevel(EndlessDeepSpaceModEnchantments.DAMAGE_REDUCTION.get(), itemstack) * 3), AttributeModifier.Operation.ADDITION)));
			}
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.HEAD) {
				_event.addModifier(EndlessDeepSpaceModAttributes.DAMAGE_REDUCTION.get(), (new AttributeModifier(UUID.fromString("3f9035a3-c37a-430f-9f52-7f04ff10a29e"), EndlessDeepSpaceMod.MODID + "." + "damage reduction",
						(EnchantmentHelper.getItemEnchantmentLevel(EndlessDeepSpaceModEnchantments.DAMAGE_REDUCTION.get(), itemstack) * 3), AttributeModifier.Operation.ADDITION)));
			}
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.LEGS) {
				_event.addModifier(EndlessDeepSpaceModAttributes.DAMAGE_REDUCTION.get(), (new AttributeModifier(UUID.fromString("10f71fc7-2903-424d-8373-cb04ba645f8f"), EndlessDeepSpaceMod.MODID + "." + "damage reduction",
						(EnchantmentHelper.getItemEnchantmentLevel(EndlessDeepSpaceModEnchantments.DAMAGE_REDUCTION.get(), itemstack) * 3), AttributeModifier.Operation.ADDITION)));
			}
		}
	}
}
=======
package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModItems;
import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModEnchantments;
import shirumengya.rumeng.reborn.endless_deep_space.EndlessDeepSpaceMod;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.ItemAttributeModifierEvent;
import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nullable;

import java.util.UUID;

@Mod.EventBusSubscriber
public class ItemAttributeTickProcedure {
	@SubscribeEvent
	public static void addAttributeModifier(ItemAttributeModifierEvent event) {
		execute(event, event.getItemStack());
	}

	public static void execute(ItemStack itemstack) {
		execute(null, itemstack);
	}

	private static void execute(@Nullable Event event, ItemStack itemstack) {
		if (itemstack.getItem() == EndlessDeepSpaceModItems.ENCHANTED_TOTEM_OF_UNDYING.get() || itemstack.getItem() == Items.TOTEM_OF_UNDYING) {
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.MAINHAND) {
				_event.addModifier(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("endless_deep_space:random_regeneration_probability")),
						(new AttributeModifier(UUID.fromString("40ba92a7-94aa-49d0-b328-6df891ddd428"), EndlessDeepSpaceMod.MODID + "." + "random_regeneration_probability", 0.01, AttributeModifier.Operation.ADDITION)));
				_event.addModifier(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("endless_deep_space:random_regeneration_health")),
						(new AttributeModifier(UUID.fromString("55c61470-b0c1-4ad4-8d91-07a2ab6bad48"), EndlessDeepSpaceMod.MODID + "." + "random_regeneration_health", 1, AttributeModifier.Operation.ADDITION)));
			}
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.OFFHAND) {
				_event.addModifier(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("endless_deep_space:random_regeneration_probability")),
						(new AttributeModifier(UUID.fromString("b942186f-40ea-4d96-ab9e-b069bdd6b557"), EndlessDeepSpaceMod.MODID + "." + "random_regeneration_probability", 0.01, AttributeModifier.Operation.ADDITION)));
				_event.addModifier(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("endless_deep_space:random_regeneration_health")),
						(new AttributeModifier(UUID.fromString("465c02a3-77cd-4f93-90c7-8126c58bbd21"), EndlessDeepSpaceMod.MODID + "." + "random_regeneration_health", 1, AttributeModifier.Operation.ADDITION)));
			}
		}
		if (itemstack.getItem() == Items.TURTLE_HELMET) {
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.HEAD) {
				_event.addModifier(ForgeMod.SWIM_SPEED.get(), (new AttributeModifier(UUID.fromString("0632879b-61b5-4820-988d-969efe143a3d"), EndlessDeepSpaceMod.MODID + "." + "swim_speed", 2, AttributeModifier.Operation.ADDITION)));
				_event.addModifier(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("endless_deep_space:destroy_speed")),
						(new AttributeModifier(UUID.fromString("77565857-b940-4c6f-a39e-b12b4b462f9e"), EndlessDeepSpaceMod.MODID + "." + "destroy_speed", 1, AttributeModifier.Operation.ADDITION)));
			}
		}
		if (itemstack.getItem() == Items.ELYTRA) {
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.CHEST) {
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR,
						(new AttributeModifier(UUID.fromString("12e03493-fa2e-4c98-b56a-48d902e6a77e"), EndlessDeepSpaceMod.MODID + "." + "armor", 8, AttributeModifier.Operation.ADDITION)));
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR_TOUGHNESS,
						(new AttributeModifier(UUID.fromString("dc77739b-a2fc-4ef1-bc5e-bc0cbb545e79"), EndlessDeepSpaceMod.MODID + "." + "armor_toughness", 3, AttributeModifier.Operation.ADDITION)));
				_event.addModifier(net.minecraft.world.entity.ai.attributes.Attributes.KNOCKBACK_RESISTANCE,
						(new AttributeModifier(UUID.fromString("805cb0ba-05ad-4280-ba44-bdbb3c61d617"), EndlessDeepSpaceMod.MODID + "." + "knockback_resistance", 0.1, AttributeModifier.Operation.ADDITION)));
				_event.addModifier(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("endless_deep_space:random_regeneration_probability")),
						(new AttributeModifier(UUID.fromString("2063189a-7550-4847-86c8-0c058f95822d"), EndlessDeepSpaceMod.MODID + "." + "random_regeneration_probability", 0.02, AttributeModifier.Operation.ADDITION)));
				_event.addModifier(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("endless_deep_space:random_regeneration_health")),
						(new AttributeModifier(UUID.fromString("7d48b130-224a-46f1-a8e5-8ffbc4bc5daa"), EndlessDeepSpaceMod.MODID + "." + "random_regeneration_health", 2, AttributeModifier.Operation.ADDITION)));
				_event.addModifier(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("endless_deep_space:damage_reduction")),
						(new AttributeModifier(UUID.fromString("689f359f-f34b-40bb-a1dd-1838ca9b7dcb"), EndlessDeepSpaceMod.MODID + "." + "damage_reduction", 2, AttributeModifier.Operation.ADDITION)));
			}
		}
		if (EnchantmentHelper.getItemEnchantmentLevel(EndlessDeepSpaceModEnchantments.CANNOT_MINE.get(), itemstack) != 0) {
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.MAINHAND) {
				_event.addModifier(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("endless_deep_space:cannot_mine")), (new AttributeModifier(UUID.fromString("21e5c09b-0b71-4370-9eec-ef7b266cffb6"),
						EndlessDeepSpaceMod.MODID + "." + "cannot_mine", (EnchantmentHelper.getItemEnchantmentLevel(EndlessDeepSpaceModEnchantments.CANNOT_MINE.get(), itemstack)), AttributeModifier.Operation.ADDITION)));
			}
		}
		if (EnchantmentHelper.getItemEnchantmentLevel(EndlessDeepSpaceModEnchantments.DAMAGE_INCREASE.get(), itemstack) != 0) {
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.HEAD) {
				_event.addModifier(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("endless_deep_space:damage_reduction")), (new AttributeModifier(UUID.fromString("38033744-f894-4f09-8897-d6c52484c8ae"),
						EndlessDeepSpaceMod.MODID + "." + "damage_increase", ((-(EnchantmentHelper.getItemEnchantmentLevel(EndlessDeepSpaceModEnchantments.DAMAGE_INCREASE.get(), itemstack))) * 4), AttributeModifier.Operation.ADDITION)));
			}
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.CHEST) {
				_event.addModifier(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("endless_deep_space:damage_reduction")), (new AttributeModifier(UUID.fromString("637ab6bc-0ec8-4079-b00c-7cabcbe97245"),
						EndlessDeepSpaceMod.MODID + "." + "damage_increase", ((-(EnchantmentHelper.getItemEnchantmentLevel(EndlessDeepSpaceModEnchantments.DAMAGE_INCREASE.get(), itemstack))) * 4), AttributeModifier.Operation.ADDITION)));
			}
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.LEGS) {
				_event.addModifier(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("endless_deep_space:damage_reduction")), (new AttributeModifier(UUID.fromString("6b05198c-8748-431f-b10e-1e38b7195257"),
						EndlessDeepSpaceMod.MODID + "." + "damage_increase", ((-(EnchantmentHelper.getItemEnchantmentLevel(EndlessDeepSpaceModEnchantments.DAMAGE_INCREASE.get(), itemstack))) * 4), AttributeModifier.Operation.ADDITION)));
			}
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.FEET) {
				_event.addModifier(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("endless_deep_space:damage_reduction")), (new AttributeModifier(UUID.fromString("fe277078-3f47-4de9-8cd4-5f3d824e3d0d"),
						EndlessDeepSpaceMod.MODID + "." + "damage_increase", ((-(EnchantmentHelper.getItemEnchantmentLevel(EndlessDeepSpaceModEnchantments.DAMAGE_INCREASE.get(), itemstack))) * 4), AttributeModifier.Operation.ADDITION)));
			}
		}
		if (EnchantmentHelper.getItemEnchantmentLevel(EndlessDeepSpaceModEnchantments.BETTER_PROTECTION.get(), itemstack) != 0) {
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.HEAD) {
				_event.addModifier(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("endless_deep_space:damage_reduction")), (new AttributeModifier(UUID.fromString("42164ac0-3536-4b84-89fa-04e0a0c8b1a3"),
						EndlessDeepSpaceMod.MODID + "." + "damage_reduction", (EnchantmentHelper.getItemEnchantmentLevel(EndlessDeepSpaceModEnchantments.BETTER_PROTECTION.get(), itemstack)), AttributeModifier.Operation.ADDITION)));
			}
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.CHEST) {
				_event.addModifier(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("endless_deep_space:damage_reduction")), (new AttributeModifier(UUID.fromString("903a5348-eaac-4c82-ad17-f9cc778a5d1a"),
						EndlessDeepSpaceMod.MODID + "." + "damage_reduction", (EnchantmentHelper.getItemEnchantmentLevel(EndlessDeepSpaceModEnchantments.BETTER_PROTECTION.get(), itemstack)), AttributeModifier.Operation.ADDITION)));
			}
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.LEGS) {
				_event.addModifier(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("endless_deep_space:damage_reduction")), (new AttributeModifier(UUID.fromString("036cc212-a27f-4256-a948-926ec0a72c02"),
						EndlessDeepSpaceMod.MODID + "." + "damage_reduction", (EnchantmentHelper.getItemEnchantmentLevel(EndlessDeepSpaceModEnchantments.BETTER_PROTECTION.get(), itemstack)), AttributeModifier.Operation.ADDITION)));
			}
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.FEET) {
				_event.addModifier(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("endless_deep_space:damage_reduction")), (new AttributeModifier(UUID.fromString("68c5f6e4-ce7d-48c1-92d0-7d222375449b"),
						EndlessDeepSpaceMod.MODID + "." + "damage_reduction", (EnchantmentHelper.getItemEnchantmentLevel(EndlessDeepSpaceModEnchantments.BETTER_PROTECTION.get(), itemstack)), AttributeModifier.Operation.ADDITION)));
			}
		}
		if (EnchantmentHelper.getItemEnchantmentLevel(EndlessDeepSpaceModEnchantments.DAMAGE_REDUCTION.get(), itemstack) != 0) {
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.HEAD) {
				_event.addModifier(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("endless_deep_space:damage_reduction")), (new AttributeModifier(UUID.fromString("56bb1f47-7884-4ae3-90a1-cb141f5ea2a3"),
						EndlessDeepSpaceMod.MODID + "." + "damage_reduction", (EnchantmentHelper.getItemEnchantmentLevel(EndlessDeepSpaceModEnchantments.DAMAGE_REDUCTION.get(), itemstack) * 3), AttributeModifier.Operation.ADDITION)));
			}
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.CHEST) {
				_event.addModifier(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("endless_deep_space:damage_reduction")), (new AttributeModifier(UUID.fromString("db859eec-17c4-4ffe-ae2c-296c3342c3f2"),
						EndlessDeepSpaceMod.MODID + "." + "damage_reduction", (EnchantmentHelper.getItemEnchantmentLevel(EndlessDeepSpaceModEnchantments.DAMAGE_REDUCTION.get(), itemstack) * 3), AttributeModifier.Operation.ADDITION)));
			}
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.LEGS) {
				_event.addModifier(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("endless_deep_space:damage_reduction")), (new AttributeModifier(UUID.fromString("0226c5ae-e519-423e-b8ac-40420a48ae86"),
						EndlessDeepSpaceMod.MODID + "." + "damage_reduction", (EnchantmentHelper.getItemEnchantmentLevel(EndlessDeepSpaceModEnchantments.DAMAGE_REDUCTION.get(), itemstack) * 3), AttributeModifier.Operation.ADDITION)));
			}
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.FEET) {
				_event.addModifier(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("endless_deep_space:damage_reduction")), (new AttributeModifier(UUID.fromString("4e5599e1-5b85-4eb4-8f22-2ecbc66cceba"),
						EndlessDeepSpaceMod.MODID + "." + "damage_reduction", (EnchantmentHelper.getItemEnchantmentLevel(EndlessDeepSpaceModEnchantments.DAMAGE_REDUCTION.get(), itemstack) * 3), AttributeModifier.Operation.ADDITION)));
			}
		}
		if (EnchantmentHelper.getItemEnchantmentLevel(EndlessDeepSpaceModEnchantments.DISABILITY.get(), itemstack) != 0) {
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.MAINHAND) {
				_event.addModifier(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("endless_deep_space:destroy_speed")), (new AttributeModifier(UUID.fromString("3e0b4931-3a94-4dc6-89c4-99934f1c82c9"),
						EndlessDeepSpaceMod.MODID + "." + "destroy_speed", (-(EnchantmentHelper.getItemEnchantmentLevel(EndlessDeepSpaceModEnchantments.DISABILITY.get(), itemstack) * 2)), AttributeModifier.Operation.ADDITION)));
			}
		}
		if (EnchantmentHelper.getItemEnchantmentLevel(EndlessDeepSpaceModEnchantments.PHYSICAL_STRENGTH.get(), itemstack) != 0) {
			if (event instanceof ItemAttributeModifierEvent _event && _event.getSlotType() == EquipmentSlot.MAINHAND) {
				_event.addModifier(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("endless_deep_space:destroy_speed")), (new AttributeModifier(UUID.fromString("fef4aebd-93d3-44c1-8cf2-62b2ad1e4574"),
						EndlessDeepSpaceMod.MODID + "." + "destroy_speed", (EnchantmentHelper.getItemEnchantmentLevel(EndlessDeepSpaceModEnchantments.PHYSICAL_STRENGTH.get(), itemstack)), AttributeModifier.Operation.ADDITION)));
			}
		}
	}
}
>>>>>>> Stashed changes
