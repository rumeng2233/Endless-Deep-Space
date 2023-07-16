
package shirumengya.rumeng.reborn.endless_deep_space.client.renderer;

import shirumengya.rumeng.reborn.endless_deep_space.entity.TheVoidCubeEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.SlimeModel;
import shirumengya.rumeng.reborn.endless_deep_space.custom.client.renderer.EndlessDeepSpaceRenderTypes;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Matrix4f;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Direction;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.math.Matrix4f;
import net.minecraft.client.renderer.texture.TextureAtlas;
import com.mojang.math.Vector3f;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class TheVoidCubeRenderer extends MobRenderer<TheVoidCubeEntity, SlimeModel<TheVoidCubeEntity>> {

	public static final ResourceLocation END_SKY_LOCATION = new ResourceLocation("textures/environment/end_sky.png");
   	public static final ResourceLocation END_PORTAL_LOCATION = new ResourceLocation("textures/entity/end_portal.png");
   	public static final ResourceLocation EYE_OF_ENDER_LOCATION = new ResourceLocation("textures/item/ender_eye.png");
   	public static final ResourceLocation WHITE_LOCATION = new ResourceLocation("endless_deep_space:textures/white.png");
   	private static final float HALF_SQRT_3 = (float)(Math.sqrt(3.0D) / 2.0D);

	public TheVoidCubeRenderer(EntityRendererProvider.Context context) {
		super(context, new SlimeModel(context.bakeLayer(ModelLayers.SLIME)), 0.5f);
	}

	public void render(TheVoidCubeEntity p_115455_, float p_115456_, float p_115457_, PoseStack p_115458_, MultiBufferSource p_115459_, int p_115460_) {
		Matrix4f matrix4f = p_115458_.last().pose();
      	this.renderCube(p_115455_, matrix4f, p_115459_.getBuffer(this.renderType(p_115455_)));
      	if (p_115455_.TheVoidCubeDeathTime > 0) {
      		this.renderLightningBolt(p_115455_, p_115456_, p_115457_, p_115458_, p_115459_, p_115460_);
      		this.renderLikeEnderDragonDeathAnimation(p_115455_, p_115456_, p_115457_, p_115458_, p_115459_, p_115460_);
      	}
	}

	private void renderCube(TheVoidCubeEntity p_173691_, Matrix4f p_173692_, VertexConsumer p_173693_) {
		float i = this.getSize1(p_173691_);
		float j = this.getSize2(p_173691_);
      	this.renderFace(p_173691_, p_173692_, p_173693_, j, i, j + 5, i + 5, i, i, i, i, Direction.SOUTH);
      	this.renderFace(p_173691_, p_173692_, p_173693_, j, i, i + 5, j + 5, j, j, j, j, Direction.NORTH);
      	this.renderFace(p_173691_, p_173692_, p_173693_, i, i, i + 5, j + 5, j, i, i, j, Direction.EAST);
      	this.renderFace(p_173691_, p_173692_, p_173693_, j, j, j + 5, i + 5, j, i, i, j, Direction.WEST);
      	this.renderFace(p_173691_, p_173692_, p_173693_, j, i, j + 5, j + 5, j, j, i, i, Direction.DOWN);
      	this.renderFace(p_173691_, p_173692_, p_173693_, j, i, i + 5, i + 5, i, i, j, j, Direction.UP);
   	}

   	private void renderFace(TheVoidCubeEntity p_173695_, Matrix4f p_173696_, VertexConsumer p_173697_, float p_173698_, float p_173699_, float p_173700_, float p_173701_, float p_173702_, float p_173703_, float p_173704_, float p_173705_, Direction p_173706_) {
       	p_173697_.vertex(p_173696_, p_173698_, p_173700_, p_173702_).endVertex();
       	p_173697_.vertex(p_173696_, p_173699_, p_173700_, p_173703_).endVertex();
       	p_173697_.vertex(p_173696_, p_173699_, p_173701_, p_173704_).endVertex();
       	p_173697_.vertex(p_173696_, p_173698_, p_173701_, p_173705_).endVertex();
   	}

   	public float getSize1(TheVoidCubeEntity p_173691_) {
   		return 5.0F/* + ((5.0F * p_173691_.TheVoidCubeDeathTime) / 10)*/;
   	}

   	public float getSize2(TheVoidCubeEntity p_173691_) {
   		return -5.0F/* - ((5.0F * p_173691_.TheVoidCubeDeathTime) / 10)*/;
   	}

   	protected RenderType renderType(TheVoidCubeEntity p_115455_) {
   		if (p_115455_.TheVoidCubeDeathTime > 0) {
   			return EndlessDeepSpaceRenderTypes.TheVoidCubeDeath(p_115455_.TheVoidCubeDeathTime >= 100 ? EYE_OF_ENDER_LOCATION : END_SKY_LOCATION, END_PORTAL_LOCATION);
   		} else if (p_115455_.hurtTime > 0) {
   			return EndlessDeepSpaceRenderTypes.TheVoidCubeHurt(END_SKY_LOCATION, END_PORTAL_LOCATION);
   		} else if (p_115455_.getIntegerData(p_115455_.BossProgress) == 1) {
   			return EndlessDeepSpaceRenderTypes.TheVoidCubeBossProgressOne(END_SKY_LOCATION, END_PORTAL_LOCATION);
   		} else if (p_115455_.getIntegerData(p_115455_.BossProgress) == 2) {
   			return EndlessDeepSpaceRenderTypes.TheVoidCubeBossProgressTwo(END_SKY_LOCATION, END_PORTAL_LOCATION);
   		} else if (p_115455_.getIntegerData(p_115455_.BossProgress) >= 3) {
   			return EndlessDeepSpaceRenderTypes.TheVoidCubeBossProgressThree(END_PORTAL_LOCATION, END_PORTAL_LOCATION);
   		} else {
      		return EndlessDeepSpaceRenderTypes.TheVoidCubeCommon(END_SKY_LOCATION, END_PORTAL_LOCATION);
   		}
   	}

   	private void renderLightningBolt(TheVoidCubeEntity p_115266_, float p_115267_, float p_115268_, PoseStack p_115269_, MultiBufferSource p_115270_, int p_115271_) {
   		float[] afloat = new float[8];
      	float[] afloat1 = new float[8];
      	float f = 0.0F;
      	float f1 = 0.0F;
      	RandomSource randomsource = RandomSource.create(p_115266_.seed);
      	for(int i = 7; i >= 0; --i) {
         	afloat[i] = f;
         	afloat1[i] = f1;
         	f += (float)(randomsource.nextInt(11) - 5);
         	f1 += (float)(randomsource.nextInt(11) - 5);
      	}
      	VertexConsumer vertexconsumer = p_115270_.getBuffer(RenderType.lightning());
      	Matrix4f matrix4f = p_115269_.last().pose();
      	for(int j = 0; j < 4; ++j) {
         	RandomSource randomsource1 = RandomSource.create(p_115266_.seed);
         	for(int k = 0; k < 3; ++k) {
            	int l = 7;
            	int i1 = 0;
            	if (k > 0) {
               		l = 7 - k;
            	}
            	if (k > 0) {
               		i1 = l - 2;
            	}
            	float f2 = afloat[l] - f;
            	float f3 = afloat1[l] - f1;
            	for(int j1 = l; j1 >= i1; --j1) {
               		float f4 = f2;
               		float f5 = f3;
               		if (k == 0) {
                  		f2 += (float)(randomsource1.nextInt(11) - 5);
                  		f3 += (float)(randomsource1.nextInt(11) - 5);
               		} else {
                  		f2 += (float)(randomsource1.nextInt(31) - 15);
                  		f3 += (float)(randomsource1.nextInt(31) - 15);
               		}
               		float f6 = 0.5F;
               		float f7 = 0.45F;
               		float f8 = 0.45F;
               		float f9 = 0.5F;
               		float f10 = 0.1F + (float)j * 0.2F;
               		if (k == 0) {
                  		f10 *= (float)j1 * 0.1F + 1.0F;
               		}
               		float f11 = 0.1F + (float)j * 0.2F;
               		if (k == 0) {
                  		f11 *= ((float)j1 - 1.0F) * 0.1F + 1.0F;
               		}
               		quad(matrix4f, vertexconsumer, f2, f3, j1, f4, f5, f10, f11, false, false, true, false);
               		quad(matrix4f, vertexconsumer, f2, f3, j1, f4, f5, f10, f11, true, false, true, true);
               		quad(matrix4f, vertexconsumer, f2, f3, j1, f4, f5, f10, f11, true, true, false, true);
               		quad(matrix4f, vertexconsumer, f2, f3, j1, f4, f5, f10, f11, false, true, false, false);
            	}
         	}
      	}
   	}

   	private static void quad(Matrix4f p_115273_, VertexConsumer p_115274_, float p_115275_, float p_115276_, int p_115277_, float p_115278_, float p_115279_, float p_115283_, float p_115284_, boolean p_115285_, boolean p_115286_, boolean p_115287_, boolean p_115288_) {
   		int color = Mth.nextInt(RandomSource.create(), 0, 255);
      	p_115274_.vertex(p_115273_, p_115275_ + (p_115285_ ? p_115284_ : -p_115284_), (float)(p_115277_ * 16), p_115276_ + (p_115286_ ? p_115284_ : -p_115284_)).color(color, color, color, 76).endVertex();
      	p_115274_.vertex(p_115273_, p_115278_ + (p_115285_ ? p_115283_ : -p_115283_), (float)((p_115277_ + 1) * 16), p_115279_ + (p_115286_ ? p_115283_ : -p_115283_)).color(color, color, color, 76).endVertex();
      	p_115274_.vertex(p_115273_, p_115278_ + (p_115287_ ? p_115283_ : -p_115283_), (float)((p_115277_ + 1) * 16), p_115279_ + (p_115288_ ? p_115283_ : -p_115283_)).color(color, color, color, 76).endVertex();
      	p_115274_.vertex(p_115273_, p_115275_ + (p_115287_ ? p_115284_ : -p_115284_), (float)(p_115277_ * 16), p_115276_ + (p_115288_ ? p_115284_ : -p_115284_)).color(color, color, color, 76).endVertex();
   	}

   	private void renderLikeEnderDragonDeathAnimation(TheVoidCubeEntity p_114208_, float p_114209_, float p_114210_, PoseStack p_114211_, MultiBufferSource p_114212_, int p_114213_) {
   		float f5 = ((float)p_114208_.TheVoidCubeDeathTime + p_114210_) / 200.0F;
       	float f7 = Math.min(f5 > 0.8F ? (f5 - 0.8F) / 0.2F : 0.0F, 1.0F);
       	RandomSource randomsource = RandomSource.create(432L);
       	VertexConsumer vertexconsumer2 = p_114212_.getBuffer(RenderType.lightning());
       	p_114211_.pushPose();
       	p_114211_.translate(0.0D, 5.0D, 0.0D);
       	p_114211_.scale(10.0F, 10.0F, 10.0F);
       	for(int i = 0; (float)i < (f5 + f5 * f5) / 2.0F * 60.0F; ++i) {
          	p_114211_.mulPose(Vector3f.XP.rotationDegrees(randomsource.nextFloat() * 360.0F));
       		p_114211_.mulPose(Vector3f.YP.rotationDegrees(randomsource.nextFloat() * 360.0F));
          	p_114211_.mulPose(Vector3f.ZP.rotationDegrees(randomsource.nextFloat() * 360.0F));
           	p_114211_.mulPose(Vector3f.XP.rotationDegrees(randomsource.nextFloat() * 360.0F));
           	p_114211_.mulPose(Vector3f.YP.rotationDegrees(randomsource.nextFloat() * 360.0F));
           	p_114211_.mulPose(Vector3f.ZP.rotationDegrees(randomsource.nextFloat() * 360.0F + f5 * 90.0F));
           	float f3 = randomsource.nextFloat() * 20.0F + 5.0F + f7 * 10.0F;
           	float f4 = randomsource.nextFloat() * 2.0F + 1.0F + f7 * 2.0F;
           	Matrix4f matrix4f = p_114211_.last().pose();
           	int j = (int)(255.0F * (1.0F - f7));
           	vertex01(vertexconsumer2, matrix4f, j);
           	vertex2(vertexconsumer2, matrix4f, f3, f4);
           	vertex3(vertexconsumer2, matrix4f, f3, f4);
           	vertex01(vertexconsumer2, matrix4f, j);
           	vertex3(vertexconsumer2, matrix4f, f3, f4);
           	vertex4(vertexconsumer2, matrix4f, f3, f4);
           	vertex01(vertexconsumer2, matrix4f, j);
           	vertex4(vertexconsumer2, matrix4f, f3, f4);
           	vertex2(vertexconsumer2, matrix4f, f3, f4);
       	}
      	p_114211_.popPose();
   	}

   	private static void vertex01(VertexConsumer p_114220_, Matrix4f p_114221_, int p_114222_) {
      	p_114220_.vertex(p_114221_, 0.0F, 0.0F, 0.0F).color(0, 255, 175, p_114222_).endVertex();
   	}

   	private static void vertex2(VertexConsumer p_114215_, Matrix4f p_114216_, float p_114217_, float p_114218_) {
      	p_114215_.vertex(p_114216_, -HALF_SQRT_3 * p_114218_, p_114217_, -0.5F * p_114218_).color(0, 255, 175, 0).endVertex();
   	}

   	private static void vertex3(VertexConsumer p_114224_, Matrix4f p_114225_, float p_114226_, float p_114227_) {
      	p_114224_.vertex(p_114225_, HALF_SQRT_3 * p_114227_, p_114226_, -0.5F * p_114227_).color(0, 255, 175, 0).endVertex();
   	}

   	private static void vertex4(VertexConsumer p_114229_, Matrix4f p_114230_, float p_114231_, float p_114232_) {
      	p_114229_.vertex(p_114230_, 0.0F, p_114231_, 1.0F * p_114232_).color(0, 255, 175, 0).endVertex();
   	}

	@Override
	public ResourceLocation getTextureLocation(TheVoidCubeEntity entity) {
		return TextureAtlas.LOCATION_BLOCKS;
	}

	@Override
	protected boolean isBodyVisible(TheVoidCubeEntity entity) {
		return false;
	}
}
