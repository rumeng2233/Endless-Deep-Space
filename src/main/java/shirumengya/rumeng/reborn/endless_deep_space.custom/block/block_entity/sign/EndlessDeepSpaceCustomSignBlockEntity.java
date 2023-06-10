package shirumengya.rumeng.reborn.endless_deep_space.custom.block.block_entity.sign;

import shirumengya.rumeng.reborn.endless_deep_space.custom.block.block_entity.EndlessDeepSpaceCustomBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class EndlessDeepSpaceCustomSignBlockEntity extends SignBlockEntity {
    public EndlessDeepSpaceCustomSignBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(pWorldPosition, pBlockState);
    }

    @Override
    public BlockEntityType<?> getType() {
        return EndlessDeepSpaceCustomBlockEntity.SIGN_BLOCK_ENTITY.get();
    }
}
