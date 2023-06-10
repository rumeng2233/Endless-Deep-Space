package shirumengya.rumeng.reborn.endless_deep_space.custom.client.renderer.blockentity.guiding_stone;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.item.DyeColor;
import shirumengya.rumeng.reborn.endless_deep_space.custom.block.block_entity.guiding_stone.BrownGuidingStoneBlockEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Matrix4f;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import shirumengya.rumeng.reborn.endless_deep_space.custom.block.block_entity.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.renderer.blockentity.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.config.EndlessDeepSpaceModClientConfig;
import net.minecraft.client.renderer.blockentity.TheEndPortalRenderer;
import net.minecraft.world.phys.Vec3;

@OnlyIn(Dist.CLIENT)
public class BrownGuidingStoneRenderer implements BlockEntityRenderer<BrownGuidingStoneBlockEntity> {
   private static final ResourceLocation BEAM_LOCATION = new ResourceLocation("textures/entity/guiding_stone_beam.png");

   public BrownGuidingStoneRenderer(BlockEntityRendererProvider.Context p_173683_) {
   }

   public void render(BrownGuidingStoneBlockEntity p_112613_, float p_112614_, PoseStack p_112615_, MultiBufferSource p_112616_, int p_112617_, int p_112618_) {
      if (p_112613_.isSpawning()) {
         float f = p_112613_.isSpawning() ? p_112613_.getSpawnPercent(p_112614_) : p_112613_.getCooldownPercent(p_112614_);
//         double d0 = p_112613_.isSpawning() ? (double)p_112613_.getLevel().getMaxBuildHeight() : 50.0D;
         double d0 = (double)EndlessDeepSpaceModClientConfig.GUIDING_STONE_BEAM_RENDERING_HEIGHT.get();
         f = Mth.sin(f * (float)Math.PI);
         int i = Mth.floor((double)f * d0);
         float[] afloat = DyeColor.BROWN.getTextureDiffuseColors();
         long j = p_112613_.getLevel().getGameTime();
         double w = (double)EndlessDeepSpaceModClientConfig.GUIDING_STONE_BEAM_INNER_RADIUS.get();
         double x = (double)EndlessDeepSpaceModClientConfig.GUIDING_STONE_BEAM_OUTER_RADIUS.get();
         float y = (float)w;
         float z = (float)x;
         BeaconRenderer.renderBeaconBeam(p_112615_, p_112616_, BEAM_LOCATION, p_112614_, f, j, -i, i * 2, afloat, y, z);
      }
   }

//   protected RenderType renderType() {
//      return RenderType.endPortal();
//   }

	protected float getOffsetUp() {
      return 1.0F;
   }

   	protected float getOffsetDown() {
      return 0.0F;
   }

   	public boolean shouldRenderOffScreen(BrownGuidingStoneBlockEntity p_112138_) {
      return true;
   }

   	public int getViewDistance() {
      return (int)EndlessDeepSpaceModClientConfig.GUIDING_STONE_RENDERING_DISTANCE.get();
   }

   	public boolean shouldRender(BrownGuidingStoneBlockEntity p_173531_, Vec3 p_173532_) {
      return Vec3.atCenterOf(p_173531_.getBlockPos()).multiply(1.0D, 0.0D, 1.0D).closerThan(p_173532_.multiply(1.0D, 0.0D, 1.0D), (double)this.getViewDistance());
   }
}