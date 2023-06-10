
package shirumengya.rumeng.reborn.endless_deep_space.item;

import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModTabs;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

public class IntertwinedItem extends RecordItem {
	public IntertwinedItem() {
		super(9, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("endless_deep_space:music_disc.intertwined")), new Item.Properties().tab(EndlessDeepSpaceModTabs.TAB_ENDLESS_DEEP_SPACE_TAP).stacksTo(1).rarity(Rarity.RARE), 563);
	}
}
