package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.annotation.Nullable;
import java.io.File;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreateFileProcedure {
	public static final Logger LOGGER = LogManager.getLogger(CreateFileProcedure.class);
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		execute();
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
	CreateFileProcedure.LOGGER.info("Create file");
		File endless_deep_space = new File("endless_deep_space");
			File minecraft = new File("endless_deep_space", "minecraft");
				File minecraft_world = new File("endless_deep_space/minecraft", "world");
				File minecraft_entity = new File("endless_deep_space/minecraft", "entity");
					File minecraft_entity_player = new File("endless_deep_space/minecraft/entity", "player");
			File eds = new File("endless_deep_space", "endless_deep_space");
				File eds_world = new File("endless_deep_space/endless_deep_space", "world");
				File eds_entity = new File("endless_deep_space/endless_deep_space", "entity");
					File eds_entity_player = new File("endless_deep_space/endless_deep_space/entity", "player");
		endless_deep_space.mkdir();
			minecraft.mkdir();
				minecraft_world.mkdir();
				minecraft_entity.mkdir();
					minecraft_entity_player.mkdir();
			eds.mkdir();
				eds_world.mkdir();
				eds_entity.mkdir();
					eds_entity_player.mkdir();
	}
}
