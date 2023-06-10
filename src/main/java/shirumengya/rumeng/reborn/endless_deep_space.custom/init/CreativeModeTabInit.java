package shirumengya.rumeng.reborn.endless_deep_space.custom.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModItems;
import net.minecraft.world.item.Items;

public class CreativeModeTabInit {
	public static CreativeModeTab ENDLESS_DEEP_SPACE_CUSTOM;
	public static CreativeModeTab ENCHANTED_BOOK_TAB;

	public static void load() {
		ENDLESS_DEEP_SPACE_CUSTOM = new CreativeModeTab("endless_deep_space.custom") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(EndlessDeepSpaceModItems.LOGO.get());
			}

			@Override
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundSuffix("endless_deep_space.custom_search.png");
		
		ENCHANTED_BOOK_TAB = new CreativeModeTab("enchanted_book_tab") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(Items.ENCHANTED_BOOK);
			}

			@Override
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundSuffix("item_search.png");
	}
}
