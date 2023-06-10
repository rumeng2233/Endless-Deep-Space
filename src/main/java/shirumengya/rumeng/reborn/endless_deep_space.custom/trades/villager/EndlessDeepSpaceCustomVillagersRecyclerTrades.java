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

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EndlessDeepSpaceCustomVillagersRecyclerTrades {
	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		if (event.getType() == EndlessDeepSpaceCustomVillagers.RECYCLER.get()) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.POISONOUS_POTATO, 8),
					new ItemStack(Items.EMERALD), 50, 2, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Blocks.OAK_LOG, 6),
					new ItemStack(Items.EMERALD), 50, 2, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Blocks.WHEAT, 5),
					new ItemStack(Items.EMERALD), 50, 2, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.SUSPICIOUS_STEW),
					new ItemStack(Items.EMERALD), 50, 2, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.WHEAT_SEEDS, 8),
					new ItemStack(Items.EMERALD), 50, 4, 0.04f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Blocks.SUGAR_CANE, 6),
					new ItemStack(Items.EMERALD), 50, 4, 0.04f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.BOOK, 4),
					new ItemStack(Items.EMERALD), 50, 4, 0.04f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Blocks.NETHERRACK, 10),
					new ItemStack(Items.EMERALD), 50, 4, 0.04f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.AMETHYST_SHARD, 2),
					new ItemStack(Items.EMERALD), 50, 6, 0.03f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.SLIME_BALL, 4),
					new ItemStack(Items.EMERALD), 50, 6, 0.03f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.GOLD_NUGGET, 9),
					new ItemStack(Items.EMERALD), 50, 6, 0.03f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.QUARTZ, 4),
					new ItemStack(Items.EMERALD), 50, 6, 0.03f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.GOLD_INGOT),
					new ItemStack(Items.EMERALD, 2), 50, 8, 0.02f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.DIAMOND),
					new ItemStack(Items.EMERALD, 2), 50, 8, 0.02f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.IRON_INGOT),
					new ItemStack(Items.EMERALD, 2), 50, 8, 0.02f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.ECHO_SHARD),
					new ItemStack(Items.EMERALD, 2), 50, 8, 0.02f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.COPPER_INGOT, 2),
					new ItemStack(Items.EMERALD, 2), 50, 8, 0.02f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.REDSTONE, 2),
					new ItemStack(Items.EMERALD, 2), 50, 8, 0.02f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.TOTEM_OF_UNDYING),
					new ItemStack(Items.EMERALD, 10), 50, 5, 0f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.NETHERITE_INGOT),
					new ItemStack(Items.EMERALD, 20), 50, 10, 0f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.NETHERITE_SCRAP),
					new ItemStack(Items.EMERALD, 15), 50, 10, 0f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.NETHER_STAR),
					new ItemStack(Items.EMERALD, 40), 50, 10, 0f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.ENCHANTED_BOOK),
					new ItemStack(Items.EMERALD, 5), 50, 10, 0f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.NAUTILUS_SHELL),
					new ItemStack(Items.EMERALD, 4), 50, 10, 0f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Blocks.DEAD_BUSH),
					new ItemStack(Items.EMERALD, 10), 50, 10, 0f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Blocks.CHORUS_FLOWER),
					new ItemStack(Items.EMERALD, 20), 50, 10, 0f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.END_CRYSTAL),
					new ItemStack(Items.EMERALD, 50), 50, 10, 0f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.GHAST_TEAR),
					new ItemStack(Items.EMERALD, 40), 50, 10, 0f));
		}
	}
}
