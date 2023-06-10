package shirumengya.rumeng.reborn.endless_deep_space.custom.entity.npc.villager;

import com.google.common.collect.ImmutableSet;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.level.block.Blocks;

import java.lang.reflect.InvocationTargetException;

public class EndlessDeepSpaceCustomVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, "endless_deep_space.custom");
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, "endless_deep_space.custom");
            
    public static final RegistryObject<PoiType> BOOKSHELF_POI = POI_TYPES.register("bookshelf_poi",
            () -> new PoiType(ImmutableSet.copyOf(Blocks.BOOKSHELF.getStateDefinition().getPossibleStates()),
                    1, 1));
    public static final RegistryObject<PoiType> CHEST_POI = POI_TYPES.register("chest_poi",
            () -> new PoiType(ImmutableSet.copyOf(Blocks.CHEST.getStateDefinition().getPossibleStates()),
                    1, 1));
    public static final RegistryObject<PoiType> JUKEBOX_POI = POI_TYPES.register("jukebox_poi",
            () -> new PoiType(ImmutableSet.copyOf(Blocks.JUKEBOX.getStateDefinition().getPossibleStates()),
                    1, 1));
                    
    public static final RegistryObject<VillagerProfession> DIMENSION_TRAVELER = VILLAGER_PROFESSIONS.register("dimension_traveler",
            () -> new VillagerProfession("dimension_traveler", x -> x.get() == BOOKSHELF_POI.get(),
                    x -> x.get() == BOOKSHELF_POI.get(), ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_LIBRARIAN));
    public static final RegistryObject<VillagerProfession> RECYCLER = VILLAGER_PROFESSIONS.register("recycler",
            () -> new VillagerProfession("recycler", x -> x.get() == CHEST_POI.get(),
                    x -> x.get() == CHEST_POI.get(), ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_FISHERMAN));
    public static final RegistryObject<VillagerProfession> MUSIC_COLLECTOR = VILLAGER_PROFESSIONS.register("music_collector",
            () -> new VillagerProfession("music_collector", x -> x.get() == JUKEBOX_POI.get(),
                    x -> x.get() == CHEST_POI.get(), ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_LIBRARIAN));


    public static void registerPOIs() {
        try {

            ObfuscationReflectionHelper.findMethod(PoiType.class,
                    "registerBlockStates", PoiType.class).invoke(null, BOOKSHELF_POI.get());
            ObfuscationReflectionHelper.findMethod(PoiType.class,
                    "registerBlockStates", PoiType.class).invoke(null, CHEST_POI.get());
            ObfuscationReflectionHelper.findMethod(PoiType.class,
                    "registerBlockStates", PoiType.class).invoke(null, JUKEBOX_POI.get());
                    
        } catch (InvocationTargetException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
    }

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
