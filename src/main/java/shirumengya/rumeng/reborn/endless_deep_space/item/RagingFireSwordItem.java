
package shirumengya.rumeng.reborn.endless_deep_space.item;

import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModTabs;
import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModItems;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class RagingFireSwordItem extends SwordItem {
	public RagingFireSwordItem() {
		super(new Tier() {
			public int getUses() {
				return 2766;
			}

			public float getSpeed() {
				return 9f;
			}

			public float getAttackDamageBonus() {
				return 11f;
			}

			public int getLevel() {
				return 5;
			}

			public int getEnchantmentValue() {
				return 28;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(EndlessDeepSpaceModItems.RAGING_FIRE_DUST.get()));
			}
		}, 3, -2.4f, new Item.Properties().tab(EndlessDeepSpaceModTabs.TAB_ENDLESS_DEEP_SPACE_TAP).fireResistant());
	}
}
