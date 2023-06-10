
package shirumengya.rumeng.reborn.endless_deep_space.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class NullItemItem extends Item {
	public NullItemItem() {
		super(new Item.Properties().tab(null).stacksTo(-1).fireResistant().rarity(Rarity.EPIC));
	}
}
