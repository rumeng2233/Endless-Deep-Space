
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package shirumengya.rumeng.reborn.endless_deep_space.init;

import shirumengya.rumeng.reborn.endless_deep_space.world.inventory.PlayerModelViewerMenu;
import shirumengya.rumeng.reborn.endless_deep_space.EndlessDeepSpaceMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

public class EndlessDeepSpaceModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, EndlessDeepSpaceMod.MODID);
	public static final RegistryObject<MenuType<PlayerModelViewerMenu>> PLAYER_MODEL_VIEWER = REGISTRY.register("player_model_viewer", () -> IForgeMenuType.create(PlayerModelViewerMenu::new));
}
