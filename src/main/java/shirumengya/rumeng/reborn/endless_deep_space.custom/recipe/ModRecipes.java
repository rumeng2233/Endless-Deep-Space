package shirumengya.rumeng.reborn.endless_deep_space.custom.recipe;

import shirumengya.rumeng.reborn.endless_deep_space.EndlessDeepSpaceMod;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, "endless_deep_space.custom");

    public static final RegistryObject<RecipeSerializer<ConversionTableRecipe>> CONVERSION_TABLE_RECIPE =
            REGISTRY.register("conversion", () -> ConversionTableRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        REGISTRY.register(eventBus);
    }
}
