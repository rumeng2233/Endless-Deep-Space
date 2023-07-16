
package shirumengya.rumeng.reborn.endless_deep_space.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BowItem;
import shirumengya.rumeng.reborn.endless_deep_space.custom.entity.projectile.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.init.entity.projectile.*;
import net.minecraft.world.entity.projectile.AbstractArrow;
import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModTabs;

public class GravityBowItem extends BowItem {
	public GravityBowItem() {
		super(new Item.Properties().tab(EndlessDeepSpaceModTabs.TAB_ENDLESS_DEEP_SPACE_TAP).durability(384).rarity(Rarity.COMMON));
	}

	@Override
	public AbstractArrow customArrow(AbstractArrow arrow) {
		return new GravityArrow(ProjectileInit.GRAVITY_ARROW.get(), arrow.getLevel(), arrow.getOwner());
	}
}
