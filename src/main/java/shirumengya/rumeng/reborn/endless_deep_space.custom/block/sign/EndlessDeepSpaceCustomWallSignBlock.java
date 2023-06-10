package shirumengya.rumeng.reborn.endless_deep_space.custom.block.sign;

import shirumengya.rumeng.reborn.endless_deep_space.custom.block.block_entity.sign.EndlessDeepSpaceCustomSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class EndlessDeepSpaceCustomWallSignBlock extends WallSignBlock {
    public EndlessDeepSpaceCustomWallSignBlock(Properties p_58068_, WoodType p_58069_) {
        super(p_58068_, p_58069_);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new EndlessDeepSpaceCustomSignBlockEntity(pPos, pState);
    }
}
