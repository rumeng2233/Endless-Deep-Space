
package shirumengya.rumeng.reborn.endless_deep_space.item;

import shirumengya.rumeng.reborn.endless_deep_space.procedures.GravityCoreDangWuPinZaiShouShangMeiKeFaShengProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModTabs;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;

public class GravityCoreItem extends Item {
	public GravityCoreItem() {
		super(new Item.Properties().tab(EndlessDeepSpaceModTabs.TAB_ENDLESS_DEEP_SPACE_TAP).stacksTo(1).fireResistant().rarity(Rarity.UNCOMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return true;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		GravityCoreDangWuPinZaiShouShangMeiKeFaShengProcedure.execute(world, entity);
	}
}
