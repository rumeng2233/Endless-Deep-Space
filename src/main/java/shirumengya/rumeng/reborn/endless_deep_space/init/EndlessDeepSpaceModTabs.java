
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package shirumengya.rumeng.reborn.endless_deep_space.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class EndlessDeepSpaceModTabs {
	public static CreativeModeTab TAB_ENDLESS_DEEP_SPACE_TAP;

	public static void load() {
		TAB_ENDLESS_DEEP_SPACE_TAP = new CreativeModeTab("tabendless_deep_space_tap") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(EndlessDeepSpaceModItems.LOGO.get());
			}

			@Override
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundSuffix("item_search.png");
	}
}
