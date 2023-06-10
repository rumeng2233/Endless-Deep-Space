package shirumengya.rumeng.reborn.endless_deep_space.custom.trades.villager;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.common.BasicItemListing;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.npc.VillagerProfession;
import shirumengya.rumeng.reborn.endless_deep_space.custom.entity.npc.villager.EndlessDeepSpaceCustomVillagers;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EndlessDeepSpaceCustomVillagersDimensionTravelerTrades {
	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		if (event.getType() == EndlessDeepSpaceCustomVillagers.DIMENSION_TRAVELER.get()) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 5),
					new ItemStack(Items.FLINT_AND_STEEL), 20, 2, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 6),
					new ItemStack(Items.ENDER_EYE), 20, 4, 0.04f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.FLINT_AND_STEEL),
					new ItemStack(Items.EMERALD, 3), 20, 0, 0f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.ENDER_EYE),
					new ItemStack(Items.EMERALD, 4), 20, 0, 0f));
		}
	}
}
