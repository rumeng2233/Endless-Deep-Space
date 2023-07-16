package shirumengya.rumeng.reborn.endless_deep_space.procedures;

import shirumengya.rumeng.reborn.endless_deep_space.init.*;
import shirumengya.rumeng.reborn.endless_deep_space.entity.ScreamingGhastEntity;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import shirumengya.rumeng.reborn.endless_deep_space.custom.networking.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.networking.packet.*;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.network.chat.Component;

public class ScreamAltarZaiFangKuaiShangYouJianProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		world.destroyBlock(new BlockPos(x, y, z), false);
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = new ScreamingGhastEntity(EndlessDeepSpaceModEntities.SCREAMING_GHAST.get(), _level);
			entityToSpawn.moveTo(x, (y + 10), z, world.getRandom().nextFloat() * 360F, 0);
			world.addFreshEntity(entityToSpawn);
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ghast.scream")), SoundSource.BLOCKS, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ghast.scream")), SoundSource.BLOCKS, 1, 1, false);
			}
		}
		ItemStack item = new ItemStack(Items.GHAST_TEAR);
		if (entity instanceof ServerPlayer _serverPlayer)
		ModMessages.sendToPlayer(new CommonDisplayItemActivationS2CPacket(item), _serverPlayer);
	}
}
