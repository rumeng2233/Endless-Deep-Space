
package shirumengya.rumeng.reborn.endless_deep_space.custom.block;

import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;
import shirumengya.rumeng.reborn.endless_deep_space.custom.block.block_entity.EndlessDeepSpaceCustomBlockEntity;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;
import shirumengya.rumeng.reborn.endless_deep_space.custom.block.block_entity.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.client.gui.screens.*;
import shirumengya.rumeng.reborn.endless_deep_space.init.*;
import net.minecraft.util.RandomSource;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.*;
import java.util.List;
import java.util.Collections;
import shirumengya.rumeng.reborn.endless_deep_space.custom.networking.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.networking.packet.*;
import com.google.common.util.concurrent.Runnables;

public class BrokenBookBlock extends BaseEntityBlock {
	public BrokenBookBlock() {
		super(BlockBehaviour.Properties.of(Material.DECORATION).sound(SoundType.STONE).strength(-1, 2147483647).noOcclusion()
				.isRedstoneConductor((bs, br, bp) -> false));
	}

	@Override
	public boolean shouldDisplayFluidOverlay(BlockState state, BlockAndTintGetter world, BlockPos pos, FluidState fluidstate) {
		return true;
	}

	@Override
	public boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
		return adjacentBlockState.getBlock() == this ? true : super.skipRendering(state, adjacentBlockState, side);
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(this, 1));
	}

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        if (pState.getBlock() != pNewState.getBlock()) {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
//            if (blockEntity instanceof StarCubeBlockEntity) {
//                ((StarCubeBlockEntity) blockEntity).drops();
//            }
        }
        super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new BrokenBookBlockEntity(pos, state);
    }

   @Nullable
   public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_153182_, BlockState p_153183_, BlockEntityType<T> p_153184_) {
      return p_153182_.isClientSide ? createTickerHelper(p_153184_, EndlessDeepSpaceCustomBlockEntity.BROKEN_BOOK.get(), BrokenBookBlockEntity::bookAnimationTick) : null;
   }

   	@Override
	public InteractionResult use(BlockState blockstate, Level world, BlockPos pos, Player entity, InteractionHand hand, BlockHitResult hit) {
		super.use(blockstate, world, pos, entity, hand, hit);

		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		double hitX = hit.getLocation().x;
		double hitY = hit.getLocation().y;
		double hitZ = hit.getLocation().z;
		Direction direction = hit.getDirection();
		if (entity instanceof ServerPlayer _serverPlayer)
		this.OpenBook((ServerPlayer)_serverPlayer);
		world.destroyBlock(new BlockPos(x, y, z), false);
		return InteractionResult.SUCCESS;
	}

	public void OpenBook(ServerPlayer player) {
		if (Math.random() < 0.1) {
			ModMessages.sendToPlayer(new BrokenBookOpenScreenS2CPacket(1), player);
		} else if (Math.random() < 0.1) {
			ModMessages.sendToPlayer(new BrokenBookOpenScreenS2CPacket(2), player);
		} else if (Math.random() < 0.1) {
			ModMessages.sendToPlayer(new BrokenBookOpenScreenS2CPacket(3), player);
		} else if (Math.random() < 0.1) {
			ModMessages.sendToPlayer(new BrokenBookOpenScreenS2CPacket(4), player);
		} else if (Math.random() < 0.1) {
			ModMessages.sendToPlayer(new BrokenBookOpenScreenS2CPacket(5), player);
		} else if (Math.random() < 0.1) {
			ModMessages.sendToPlayer(new BrokenBookOpenScreenS2CPacket(6), player);
		} else if (Math.random() < 0.1) {
			ModMessages.sendToPlayer(new BrokenBookOpenScreenS2CPacket(7), player);
		} else if (Math.random() < 0.1) {
			ModMessages.sendToPlayer(new BrokenBookOpenScreenS2CPacket(8), player);
		} else if (Math.random() < 0.1) {
			ModMessages.sendToPlayer(new BrokenBookOpenScreenS2CPacket(9), player);
		} else {
			ModMessages.sendToPlayer(new BrokenBookOpenScreenS2CPacket(10), player);
		}
	}


//	@OnlyIn(Dist.CLIENT)
//	@Override
//	public void animateTick(BlockState blockstate, Level world, BlockPos pos, RandomSource random) {
//		super.animateTick(blockstate, world, pos, random);
//		Player entity = Minecraft.getInstance().player;
//		int x = pos.getX();
//		int y = pos.getY();
//		int z = pos.getZ();
//		for (int l = 0; l < 50; ++l) {
//			double x0 = x + random.nextFloat();
//			double y0 = y + random.nextFloat();
//			double z0 = z + random.nextFloat();
//			double dx = (random.nextFloat() - 0.5D) * 1D;
//			double dy = (random.nextFloat() - 0.5D) * 1D;
//			double dz = (random.nextFloat() - 0.5D) * 1D;
//			world.addParticle(ParticleTypes.PORTAL, x0, y0, z0, dx, dy, dz);
//		}
//	}

}
