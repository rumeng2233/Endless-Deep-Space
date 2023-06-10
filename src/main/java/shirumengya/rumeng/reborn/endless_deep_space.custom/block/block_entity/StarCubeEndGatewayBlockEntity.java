package shirumengya.rumeng.reborn.endless_deep_space.custom.block.block_entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import shirumengya.rumeng.reborn.endless_deep_space.custom.block.block_entity.*;

public class StarCubeEndGatewayBlockEntity extends BlockEntity {
    public StarCubeEndGatewayBlockEntity(BlockPos pos, BlockState state) {
        super(EndlessDeepSpaceCustomBlockEntity.STAR_CUBE_END_GATEWAY.get(), pos, state);
    }

   public boolean shouldRenderFace(Direction p_59980_) {
      return p_59980_.getAxis() == Direction.Axis.X;
   }
}