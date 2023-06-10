
package shirumengya.rumeng.reborn.endless_deep_space.item;

import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModTabs;
import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModItems;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.HoeItem;

public class FrozenHoeItem extends HoeItem {
	public FrozenHoeItem() {
		super(new Tier() {
			public int getUses() {
				return 3115;
			}

			public float getSpeed() {
				return 10f;
			}

			public float getAttackDamageBonus() {
				return 3f;
			}

			public int getLevel() {
				return 6;
			}

			public int getEnchantmentValue() {
				return 35;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(EndlessDeepSpaceModItems.FROZEN_DUST.get()));
			}
		}, 0, 0f, new Item.Properties().tab(EndlessDeepSpaceModTabs.TAB_ENDLESS_DEEP_SPACE_TAP));
	}
}
