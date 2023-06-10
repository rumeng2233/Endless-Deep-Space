package shirumengya.rumeng.reborn.endless_deep_space.custom.client.gui.screens;

import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EndlessDeepSpaceCustomMenuTypes {
    public static final DeferredRegister<MenuType<?>> REGISTRY =DeferredRegister.create(ForgeRegistries.MENU_TYPES, "endless_deep_space.custom");

    public static final RegistryObject<MenuType<ConversionTableMenu>> CONVERSION_TABLE_MENU = registerMenuType(ConversionTableMenu::new, "conversion_table_menu");

    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> registerMenuType(IContainerFactory<T> factory, String name) {
        return REGISTRY.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        REGISTRY.register(eventBus);
    }
}
