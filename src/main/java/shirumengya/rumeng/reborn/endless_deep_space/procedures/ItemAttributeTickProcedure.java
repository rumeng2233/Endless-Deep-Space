package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModEnchantments;
import shirumengya.rumeng.reborn.endless_deep_space.EndlessDeepSpaceMod;
import shirumengya.rumeng.reborn.endless_deep_space.custom.init.EndlessDeepSpaceModAttributes;
import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModItems;
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
		if (itemstack.getItem() == Items.TOTEM_OF_UNDYING || itemstack.getItem() == EndlessDeepSpaceModItems.ENCHANTED_TOTEM_OF_UNDYING.get()) {
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
