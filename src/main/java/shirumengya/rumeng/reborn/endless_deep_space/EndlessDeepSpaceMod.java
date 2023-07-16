/*
 *    MCreator note:
 *
 *    If you lock base mod element files, you can edit this file and it won't get overwritten.
 *    If you change your modid or package, you need to apply these changes to this file MANUALLY.
 *
 *    Settings in @Mod annotation WON'T be changed in case of the base mod element
 *    files lock too, so you need to set them manually here in such case.
 *
 *    If you do not lock base mod element files in Workspace settings, this file
 *    will be REGENERATED on each build.
 *
 */
package shirumengya.rumeng.reborn.endless_deep_space;

import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModSounds;
import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModMobEffects;
import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModItems;
import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModEntities;
import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModEnchantments;
import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModBiomes;
import shirumengya.rumeng.reborn.endless_deep_space.init.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.init.BlockInit;
import shirumengya.rumeng.reborn.endless_deep_space.custom.init.ItemInit;
import shirumengya.rumeng.reborn.endless_deep_space.custom.init.CreativeModeTabInit;
import shirumengya.rumeng.reborn.endless_deep_space.custom.init.entity.projectile.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.init.entity.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.init.*;
import net.minecraftforge.network.simple.SimpleChannel;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import java.util.function.Supplier;
import java.util.function.Function;
import java.util.function.BiConsumer;
import java.util.List;
import java.util.ArrayList;
import java.util.AbstractMap;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.common.MinecraftForge;
//import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import shirumengya.rumeng.reborn.endless_deep_space.custom.util.item.bow.*;
import shirumengya.rumeng.reborn.endless_deep_space.init.EndlessDeepSpaceModTabs;
import net.minecraft.world.item.CreativeModeTab;
import shirumengya.rumeng.reborn.endless_deep_space.custom.entity.npc.villager.EndlessDeepSpaceCustomVillagers;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.properties.WoodType;
import shirumengya.rumeng.reborn.endless_deep_space.custom.block.block_entity.wood_type.EndlessDeepSpaceCustomWoodTypes;
import shirumengya.rumeng.reborn.endless_deep_space.custom.block.block_entity.EndlessDeepSpaceCustomBlockEntity;
import shirumengya.rumeng.reborn.endless_deep_space.custom.client.gui.screens.*;
import net.minecraft.client.gui.screens.MenuScreens;
import shirumengya.rumeng.reborn.endless_deep_space.custom.recipe.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.util.item.fishing_rod.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.util.item.crossbow.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.util.item.*;
import java.util.Locale;
<<<<<<< Updated upstream
=======
import net.minecraft.sounds.Music;
import net.minecraft.world.entity.Entity;
import shirumengya.rumeng.reborn.endless_deep_space.custom.event.*;
>>>>>>> Stashed changes

@Mod("endless_deep_space")
public class EndlessDeepSpaceMod {
	public static final Logger LOGGER = LogManager.getLogger(EndlessDeepSpaceMod.class);
	public static final String MODID = "endless_deep_space";
<<<<<<< Updated upstream
	public static final String Version = "0.0.00013886";
=======
	public static final String Version = "0.0.00013893";
>>>>>>> Stashed changes

	public EndlessDeepSpaceMod() {
		MinecraftForge.EVENT_BUS.register(this);

		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		EndlessDeepSpaceModSounds.REGISTRY.register(bus);

		EndlessDeepSpaceModItems.REGISTRY.register(bus);
		
		EndlessDeepSpaceModEntities.REGISTRY.register(bus);

		EndlessDeepSpaceModMobEffects.REGISTRY.register(bus);

		EndlessDeepSpaceModEnchantments.REGISTRY.register(bus);

		EndlessDeepSpaceModMenus.REGISTRY.register(bus);
		
		EndlessDeepSpaceModBiomes.REGISTRY.register(bus);

		BlockInit.REGISTRY.register(bus);

		ItemInit.REGISTRY.register(bus);

		bus.addListener(this::clientSetup);

		EndlessDeepSpaceModTabs.load();

		CreativeModeTabInit.load();

		bus.addListener(this::commonSetup);

		EndlessDeepSpaceCustomVillagers.register(bus);

		ProjectileInit.REGISTRY.register(bus);

		bus.addListener(this::setup);

		EndlessDeepSpaceCustomBlockEntity.REGISTRY.register(bus);

		EndlessDeepSpaceCustomMenuTypes.REGISTRY.register(bus);

		ModRecipes.REGISTRY.register(bus);

		EndlessDeepSpaceModFeatures.REGISTRY.register(bus);

		EndlessDeepSpaceModPotions.REGISTRY.register(bus);

		EndlessDeepSpaceModBlocks.REGISTRY.register(bus);

//		EndlessDeepSpaceModBlockEntities.REGISTRY.register(bus);

		EndlessDeepSpaceModParticleTypes.REGISTRY.register(bus);

//		EndlessDeepSpaceModFluidTypes.REGISTRY.register(bus);

//		EndlessDeepSpaceModFluids.REGISTRY.register(bus);

		EndlessDeepSpaceModPaintings.REGISTRY.register(bus);

		EntityInit.REGISTRY.register(bus);

		MobEffectInit.REGISTRY.register(bus);
		
		PotionInit.REGISTRY.register(bus);

	}

	private static final String PROTOCOL_VERSION = "1";
	public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(new ResourceLocation(MODID, MODID), () -> PROTOCOL_VERSION,
			PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
	private static int messageID = 0;

	public static <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder,
			BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
		PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
		messageID++;
	}

	private static final List<AbstractMap.SimpleEntry<Runnable, Integer>> workQueue = new ArrayList<>();

	public static void queueServerWork(int tick, Runnable action) {
		workQueue.add(new AbstractMap.SimpleEntry(action, tick));
	}

	@SubscribeEvent
	public void tick(TickEvent.ServerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			List<AbstractMap.SimpleEntry<Runnable, Integer>> actions = new ArrayList<>();
			workQueue.forEach(work -> {
				work.setValue(work.getValue() - 1);
				if (work.getValue() == 0)
					actions.add(work);
			});
			actions.forEach(e -> e.getKey().run());
			workQueue.removeAll(actions);
		}
	}

    private void clientSetup(final FMLClientSetupEvent event) {
        BowItemProperties.addCustomBowItemProperties();
        WoodType.register(EndlessDeepSpaceCustomWoodTypes.PETRIFIED_OAK);
        BlockEntityRenderers.register(EndlessDeepSpaceCustomBlockEntity.SIGN_BLOCK_ENTITY.get(), SignRenderer::new);
        WoodType.register(EndlessDeepSpaceCustomWoodTypes.TRANSPARENT);
        MenuScreens.register(EndlessDeepSpaceCustomMenuTypes.CONVERSION_TABLE_MENU.get(), ConversionTableScreen::new);
        FishingRodItemProperties.addCustomFishingRodItemProperties();
        CrossbowItemProperties.addCustomCrossbowItemProperties();
<<<<<<< Updated upstream
=======
        SpecialItemProperties.addCustomSpecialItemProperties();
        //StatsInit.init();
>>>>>>> Stashed changes
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            EndlessDeepSpaceCustomVillagers.registerPOIs();
        });
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            Sheets.addWoodType(EndlessDeepSpaceCustomWoodTypes.PETRIFIED_OAK);
            Sheets.addWoodType(EndlessDeepSpaceCustomWoodTypes.TRANSPARENT);
        });
    }

    public static ResourceLocation prefix(String name) {
		return new ResourceLocation(MODID, name.toLowerCase(Locale.ROOT));
	}
<<<<<<< Updated upstream
=======

	public static void addBoss(Entity entity){
        CustomBossBarEvent.addBoss(entity);
    }

    public static void removeBoss(Entity entity){
        CustomBossBarEvent.removeBoss(entity);
    }

    /*@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
            StatsInit.init();
        });
	}*/
>>>>>>> Stashed changes
}
