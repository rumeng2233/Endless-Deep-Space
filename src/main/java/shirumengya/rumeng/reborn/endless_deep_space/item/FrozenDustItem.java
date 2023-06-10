
package shirumengya.rumeng.reborn.endless_deep_space.item;

import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModTabs;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class FrozenDustItem extends Item {
	public FrozenDustItem() {
		super(new Item.Properties().tab(EndlessDeepSpaceModTabs.TAB_ENDLESS_DEEP_SPACE_TAP).stacksTo(64).rarity(Rarity.COMMON));
	}
}
