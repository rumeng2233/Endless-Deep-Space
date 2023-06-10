
package shirumengya.rumeng.reborn.endless_deep_space.custom.block.block_entity.guiding_stone;

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
import net.minecraft.util.Mth;

public class BlueGuidingStoneBlockEntity extends BlockEntity {

   	private long age = 100L;
   	private float time;
	
    public BlueGuidingStoneBlockEntity(BlockPos pos, BlockState state) {
        super(EndlessDeepSpaceCustomBlockEntity.BLUE_GUIDING_STONE.get(), pos, state);
    }

	public static void tick(Level level, BlockPos pos, BlockState state, BlueGuidingStoneBlockEntity pEntity) {
//		++pEntity.age;
		pEntity.age = 100L;
    }

	public boolean isSpawning() {
      return this.age < 200L;
   }

   	public float getSpawnPercent(float p_59934_) {
      return Mth.clamp(((float)this.age + p_59934_) / 200.0F, 0.0F, 1.0F);
   }

	public float getCooldownPercent(float p_59968_) {
      return 1.0F - Mth.clamp(((float)this.time - p_59968_) / 200.0F, 0.0F, 1.0F);
   }
}