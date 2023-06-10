package shirumengya.rumeng.reborn.endless_deep_space.custom.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import net.minecraft.client.model.BookModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.entity.EnchantmentTableBlockEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.renderer.blockentity.*;
import net.minecraft.world.phys.Vec3;
import net.minecraft.client.renderer.*;
import com.mojang.math.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.config.EndlessDeepSpaceModClientConfig;
import net.minecraft.core.Direction;

@OnlyIn(Dist.CLIENT)
public class EnchantTableRendererOverride implements BlockEntityRenderer<EnchantmentTableBlockEntity> {
   public static final Material BOOK_LOCATION = new Material(TextureAtlas.LOCATION_BLOCKS, new ResourceLocation("entity/enchanting_table_book"));
   private static final ResourceLocation BEAM_LOCATION = new ResourceLocation("textures/entity/enchanting_table_beam.png");
   private final BookModel bookModel;

   public EnchantTableRendererOverride(BlockEntityRendererProvider.Context p_173619_) {
      this.bookModel = new BookModel(p_173619_.bakeLayer(ModelLayers.BOOK));
   }

   public void render(EnchantmentTableBlockEntity p_112418_, float p_112419_, PoseStack p_112420_, MultiBufferSource p_112421_, int p_112422_, int p_112423_) {
      p_112420_.pushPose();
      p_112420_.translate(0.5D, 0.75D, 0.5D);
      float f = (float)p_112418_.time + p_112419_;
//      p_112420_.translate(0.0D, (double)(0.1F + Mth.sin(f * 0.1F) * 0.01F), 0.0D);
      double w = (double)EndlessDeepSpaceModClientConfig.ENCHANTING_TABLE_BOOK_FLOATS_UP_AND_DOWN_SPEED_TWO.get();
      float y = (float)w;
      p_112420_.translate(0.0D, (double)(EndlessDeepSpaceModClientConfig.ENCHANTING_TABLE_BOOK_FLOATS_UP_AND_DOWN_SPEED_ONE.get() + Mth.sin(f * y) * EndlessDeepSpaceModClientConfig.ENCHANTING_TABLE_BOOK_FLOATS_UP_AND_DOWN_SPEED_THREE.get()), 0.0D);

      float f1;
     for(f1 = p_112418_.rot - p_112418_.oRot; f1 >= (float)Math.PI; f1 -= ((float)Math.PI * 2F)) {
      }

      while(f1 < -(float)Math.PI) {
         f1 += ((float)Math.PI * 2F);
      }

      float f2 = p_112418_.oRot + f1 * p_112419_;
      double x = (double)EndlessDeepSpaceModClientConfig.ENCHANTING_TABLE_BOOK_ROTATION_DOUBLE_SPEED.get();
      float z = (float)x;
      if (EndlessDeepSpaceModClientConfig.ENCHANTING_TABLE_BOOK_REVERSE_ROTATION.get() == true) {
      	p_112420_.mulPose(Vector3f.YP.rotation(f2 * z));
		} else if (EndlessDeepSpaceModClientConfig.ENCHANTING_TABLE_BOOK_REVERSE_ROTATION.get() == false) {
			p_112420_.mulPose(Vector3f.YP.rotation(-f2 * z));
		}
      p_112420_.mulPose(Vector3f.ZP.rotationDegrees(80.0F));
      float f3 = Mth.lerp(p_112419_, p_112418_.oFlip, p_112418_.flip);
      float f4 = Mth.frac(f3 + 0.25F) * 1.6F - 0.3F;
      float f5 = Mth.frac(f3 + 0.75F) * 1.6F - 0.3F;
      float f6 = Mth.lerp(p_112419_, p_112418_.oOpen, p_112418_.open);
      this.bookModel.setupAnim(f, Mth.clamp(f4, 0.0F, 1.0F), Mth.clamp(f5, 0.0F, 1.0F), f6);
      VertexConsumer vertexconsumer = BOOK_LOCATION.buffer(p_112421_, RenderType::entitySolid);
      float[] afloat = {1f, 1f, 1f};
      long j = p_112418_.getLevel().getGameTime();
      double d0 = 25.0D;
      float f0 = Mth.clamp(((float)100L + p_112419_) / 200.0F, 0.0F, 1.0F);
      f0 = Mth.sin(f0 * (float)Math.PI);
      int i = Mth.floor((double)f0 * d0);
      BeaconRenderer.renderBeaconBeam(p_112420_, p_112421_, BEAM_LOCATION, p_112419_, f, j, i, -i * 2, afloat, 0.2F, 0.25F);
      BeaconRenderer.renderBeaconBeam(p_112420_, p_112421_, BEAM_LOCATION, p_112419_, f, j, -i, i * 2, afloat, 0.2F, 0.25F);
      BeaconRenderer.renderBeaconBeam(p_112420_, p_112421_, BEAM_LOCATION, p_112419_, f0, j, -i, i * 2, afloat, 0.2F, 0.25F);
      Matrix4f matrix4f = p_112420_.last().pose();
      this.renderCube(p_112418_, matrix4f, p_112421_.getBuffer(RenderType.endGateway()));
      this.bookModel.render(p_112420_, vertexconsumer, p_112422_, p_112423_, 2.0F, 1.0F, 1.0F, 2.0F);
      p_112420_.popPose();
   }

    private void renderCube(EnchantmentTableBlockEntity p_173691_, Matrix4f p_173692_, VertexConsumer p_173693_) {
      this.renderFace(p_173691_, p_173692_, p_173693_, 0.25F, 0.75F, 0.25F, 0.75F, 0.75F, 0.75F, 0.75F, 0.75F, Direction.SOUTH);
      this.renderFace(p_173691_, p_173692_, p_173693_, 0.25F, 0.75F, 0.75F, 0.25F, 0.25F, 0.25F, 0.25F, 0.25F, Direction.NORTH);
      this.renderFace(p_173691_, p_173692_, p_173693_, 0.75F, 0.75F, 0.75F, 0.25F, 0.25F, 0.75F, 0.75F, 0.25F, Direction.EAST);
      this.renderFace(p_173691_, p_173692_, p_173693_, 0.25F, 0.25F, 0.25F, 0.75F, 0.25F, 0.75F, 0.75F, 0.25F, Direction.WEST);
      this.renderFace(p_173691_, p_173692_, p_173693_, 0.25F, 0.75F, 0.25F, 0.25F, 0.25F, 0.25F, 0.75F, 0.75F, Direction.DOWN);
      this.renderFace(p_173691_, p_173692_, p_173693_, 0.25F, 0.75F, 0.75F, 0.75F, 0.75F, 0.75F, 0.25F, 0.25F, Direction.UP);
   }

    private void renderFace(EnchantmentTableBlockEntity p_173695_, Matrix4f p_173696_, VertexConsumer p_173697_, float p_173698_, float p_173699_, float p_173700_, float p_173701_, float p_173702_, float p_173703_, float p_173704_, float p_173705_, Direction p_173706_) {
         p_173697_.vertex(p_173696_, p_173698_, p_173700_, p_173702_).endVertex();
         p_173697_.vertex(p_173696_, p_173699_, p_173700_, p_173703_).endVertex();
         p_173697_.vertex(p_173696_, p_173699_, p_173701_, p_173704_).endVertex();
         p_173697_.vertex(p_173696_, p_173698_, p_173701_, p_173705_).endVertex();
   }
   
   	public boolean shouldRenderOffScreen(EnchantmentTableBlockEntity p_112138_) {
      return true;
   }

   	public int getViewDistance() {
      return Integer.MAX_VALUE;
   }

   	public boolean shouldRender(EnchantmentTableBlockEntity p_173531_, Vec3 p_173532_) {
      return true;
   }
}