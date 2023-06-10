package shirumengya.rumeng.reborn.endless_deep_space.custom.trades.villager;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.common.BasicItemListing;

import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.npc.VillagerProfession;
import shirumengya.rumeng.reborn.endless_deep_space.custom.entity.npc.villager.EndlessDeepSpaceCustomVillagers;
import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModItems;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EndlessDeepSpaceCustomVillagersMusicCollectorTrades {
	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		if (event.getType() == EndlessDeepSpaceCustomVillagers.MUSIC_COLLECTOR.get()) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.MUSIC_DISC_13),
					new ItemStack(Items.EMERALD, 10), 10, 5, 0f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.MUSIC_DISC_CAT),
					new ItemStack(Items.EMERALD, 10), 10, 5, 0f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.MUSIC_DISC_BLOCKS),
					new ItemStack(Items.EMERALD, 10), 10, 5, 0f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.MUSIC_DISC_CHIRP),
					new ItemStack(Items.EMERALD, 10), 10, 5, 0f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.MUSIC_DISC_FAR),
					new ItemStack(Items.EMERALD, 10), 10, 5, 0f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.MUSIC_DISC_MALL),
					new ItemStack(Items.EMERALD, 10), 10, 5, 0f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.MUSIC_DISC_MELLOHI),
					new ItemStack(Items.EMERALD, 10), 10, 5, 0f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.MUSIC_DISC_STAL),
					new ItemStack(Items.EMERALD, 10), 10, 5, 0f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.MUSIC_DISC_STRAD),
					new ItemStack(Items.EMERALD, 10), 10, 5, 0f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.MUSIC_DISC_WARD),
					new ItemStack(Items.EMERALD, 10), 10, 5, 0f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.MUSIC_DISC_11),
					new ItemStack(Items.EMERALD, 11), 11, 5, 0f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.MUSIC_DISC_WAIT),
					new ItemStack(Items.EMERALD, 10), 10, 5, 0f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.MUSIC_DISC_OTHERSIDE),
					new ItemStack(Items.EMERALD, 10), 10, 5, 0f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.MUSIC_DISC_5),
					new ItemStack(Items.EMERALD, 10), 10, 5, 0f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.MUSIC_DISC_PIGSTEP),
					new ItemStack(Items.EMERALD, 10), 10, 5, 0f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.DISC_FRAGMENT_5),
					new ItemStack(Items.EMERALD, 10), 10, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(EndlessDeepSpaceModItems.MUSIC_DISC_THE_LOST.get()),
					new ItemStack(Items.EMERALD, 10), 10, 5, 0f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(EndlessDeepSpaceModItems.MUSIC_DISC_INTERTWINED.get()),
					new ItemStack(Items.EMERALD, 12), 10, 5, 0f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 20),
					new ItemStack(Items.MUSIC_DISC_13), 10, 5, 1f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 20),
					new ItemStack(Items.MUSIC_DISC_CAT), 10, 5, 1f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 20),
					new ItemStack(Items.MUSIC_DISC_BLOCKS), 10, 5, 1f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 20),
					new ItemStack(Items.MUSIC_DISC_CHIRP), 10, 5, 1f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 20),
					new ItemStack(Items.MUSIC_DISC_FAR), 10, 5, 1f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 20),
					new ItemStack(Items.MUSIC_DISC_MALL), 10, 5, 1f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 20),
					new ItemStack(Items.MUSIC_DISC_MELLOHI), 10, 5, 1f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 20),
					new ItemStack(Items.MUSIC_DISC_STAL), 10, 5, 1f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 20),
					new ItemStack(Items.MUSIC_DISC_STRAD), 10, 5, 1f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 20),
					new ItemStack(Items.MUSIC_DISC_WARD), 10, 5, 1f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 11), new ItemStack(Blocks.DRAGON_HEAD),
					new ItemStack(Items.MUSIC_DISC_11), 10, 5, 0f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 20),
					new ItemStack(Items.MUSIC_DISC_WAIT), 10, 5, 1f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 20),
					new ItemStack(Items.MUSIC_DISC_OTHERSIDE), 10, 5, 1f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 20),
					new ItemStack(Items.MUSIC_DISC_5), 10, 5, 1f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 20),
					new ItemStack(Items.MUSIC_DISC_PIGSTEP), 10, 5, 1f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 20),
					new ItemStack(Items.DISC_FRAGMENT_5), 10, 5, 1f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD, 20),
					new ItemStack(EndlessDeepSpaceModItems.MUSIC_DISC_THE_LOST.get()), 10, 5, 0f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD, 22),
					new ItemStack(EndlessDeepSpaceModItems.MUSIC_DISC_INTERTWINED.get()), 10, 5, 0f));
		}
	}
}
