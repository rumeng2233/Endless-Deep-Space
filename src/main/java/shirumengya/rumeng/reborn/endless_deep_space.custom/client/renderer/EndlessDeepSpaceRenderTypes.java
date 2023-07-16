package shirumengya.rumeng.reborn.endless_deep_space.custom.client.renderer;

import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ShaderInstance;
import java.io.IOException;
import javax.annotation.Nullable;
import net.minecraft.client.renderer.blockentity.TheEndPortalRenderer;

public class EndlessDeepSpaceRenderTypes extends RenderType {
	
	@Nullable
   	public static ShaderInstance RendertypeEnchantingTableBeamShader;
   	@Nullable
   	public static ShaderInstance RendertypeTheVoidCubeCommonShader;
   	@Nullable
   	public static ShaderInstance RendertypeTheVoidCubeHurtShader;
   	@Nullable
   	public static ShaderInstance RendertypeTheVoidCubeDeathShader;
   	@Nullable
   	public static ShaderInstance RendertypeTheVoidCubeBossProgressOneShader;
   	@Nullable
   	public static ShaderInstance RendertypeTheVoidCubeBossProgressTwoShader;
   	@Nullable
   	public static ShaderInstance RendertypeTheVoidCubeBossProgressThreeShader;

   	public static final RenderStateShard.ShaderStateShard RENDERTYPE_ENCHANTING_TABLE_BEAM_SHADER = new RenderStateShard.ShaderStateShard(EndlessDeepSpaceRenderTypes::getRendertypeEnchantingTableBeamShader);
   	public static final RenderStateShard.ShaderStateShard RENDERTYPE_THE_VOID_CUBE_COMMON_SHADER = new RenderStateShard.ShaderStateShard(EndlessDeepSpaceRenderTypes::getRendertypeTheVoidCubeCommonShader);
   	public static final RenderStateShard.ShaderStateShard RENDERTYPE_THE_VOID_CUBE_HURT_SHADER = new RenderStateShard.ShaderStateShard(EndlessDeepSpaceRenderTypes::getRendertypeTheVoidCubeHurtShader);
   	public static final RenderStateShard.ShaderStateShard RENDERTYPE_THE_VOID_CUBE_DEATH_SHADER = new RenderStateShard.ShaderStateShard(EndlessDeepSpaceRenderTypes::getRendertypeTheVoidCubeDeathShader);
   	public static final RenderStateShard.ShaderStateShard RENDERTYPE_THE_VOID_CUBE_BOSS_PROGRESS_ONE_SHADER = new RenderStateShard.ShaderStateShard(EndlessDeepSpaceRenderTypes::getRendertypeTheVoidCubeBossProgressOneShader);
   	public static final RenderStateShard.ShaderStateShard RENDERTYPE_THE_VOID_CUBE_BOSS_PROGRESS_TWO_SHADER = new RenderStateShard.ShaderStateShard(EndlessDeepSpaceRenderTypes::getRendertypeTheVoidCubeBossProgressTwoShader);
   	public static final RenderStateShard.ShaderStateShard RENDERTYPE_THE_VOID_CUBE_BOSS_PROGRESS_THREE_SHADER = new RenderStateShard.ShaderStateShard(EndlessDeepSpaceRenderTypes::getRendertypeTheVoidCubeBossProgressThreeShader);
	
    public EndlessDeepSpaceRenderTypes(String name, VertexFormat vertexFormat, VertexFormat.Mode mode, int bufferSize, boolean crumbling, boolean sort, Runnable setup, Runnable clear) {
        super(name, vertexFormat, mode, bufferSize, crumbling, sort, setup, clear);
    }

    public static RenderType LikeEndPortalRender(ResourceLocation resourceLocation1, ResourceLocation resourceLocation2) {
    	return create("like_end_portal_render", DefaultVertexFormat.POSITION, VertexFormat.Mode.QUADS, 256, false, false, 
    		RenderType.CompositeState.builder()
    		.setShaderState(RENDERTYPE_END_PORTAL_SHADER)
    		.setTextureState(RenderStateShard.MultiTextureStateShard.builder()
    		.add(resourceLocation1, false, false)
    		.add(resourceLocation2, false, false).build())
    		.createCompositeState(false));
    }

    public static RenderType LikeEndGatewayRender(ResourceLocation resourceLocation1, ResourceLocation resourceLocation2) {
    	return create("like_end_gateway_render", DefaultVertexFormat.POSITION, VertexFormat.Mode.QUADS, 256, false, false, 
    		RenderType.CompositeState.builder()
    		.setShaderState(RENDERTYPE_END_GATEWAY_SHADER)
    		.setTextureState(RenderStateShard.MultiTextureStateShard.builder()
    		.add(resourceLocation1, false, false)
    		.add(resourceLocation2, false, false).build())
    		.createCompositeState(false));
    }

    public static RenderType EnchantingTableBeam(ResourceLocation resourceLocation1, ResourceLocation resourceLocation2) {
    	return create("enchanting_table_beam", DefaultVertexFormat.POSITION, VertexFormat.Mode.QUADS, 256, false, false, 
    		RenderType.CompositeState.builder()
    		.setShaderState(RENDERTYPE_ENCHANTING_TABLE_BEAM_SHADER)
    		.setTextureState(RenderStateShard.MultiTextureStateShard.builder()
    		.add(resourceLocation1, false, false)
    		.add(resourceLocation2, false, false).build())
    		.createCompositeState(false));
    }

    public static RenderType TheVoidCubeCommon(ResourceLocation resourceLocation1, ResourceLocation resourceLocation2) {
    	return create("the_void_cube_common", DefaultVertexFormat.POSITION, VertexFormat.Mode.QUADS, 256, false, false, 
    		RenderType.CompositeState.builder()
    		.setShaderState(RENDERTYPE_THE_VOID_CUBE_COMMON_SHADER)
    		.setTextureState(RenderStateShard.MultiTextureStateShard.builder()
    		.add(resourceLocation1, false, false)
    		.add(resourceLocation2, false, false).build())
    		.createCompositeState(false));
    }

    public static RenderType TheVoidCubeHurt(ResourceLocation resourceLocation1, ResourceLocation resourceLocation2) {
    	return create("the_void_cube_hurt", DefaultVertexFormat.POSITION, VertexFormat.Mode.QUADS, 256, false, false, 
    		RenderType.CompositeState.builder()
    		.setShaderState(RENDERTYPE_THE_VOID_CUBE_HURT_SHADER)
    		.setTextureState(RenderStateShard.MultiTextureStateShard.builder()
    		.add(resourceLocation1, false, false)
    		.add(resourceLocation2, false, false).build())
    		.createCompositeState(false));
    }

    public static RenderType TheVoidCubeDeath(ResourceLocation resourceLocation1, ResourceLocation resourceLocation2) {
    	return create("the_void_cube_death", DefaultVertexFormat.POSITION, VertexFormat.Mode.QUADS, 256, false, false, 
    		RenderType.CompositeState.builder()
    		.setShaderState(RENDERTYPE_THE_VOID_CUBE_DEATH_SHADER)
    		.setTextureState(RenderStateShard.MultiTextureStateShard.builder()
    		.add(resourceLocation1, false, false)
    		.add(resourceLocation2, false, false).build())
    		.createCompositeState(false));
    }

    public static RenderType TheVoidCubeBossProgressOne(ResourceLocation resourceLocation1, ResourceLocation resourceLocation2) {
    	return create("the_void_cube_boss_progress_one", DefaultVertexFormat.POSITION, VertexFormat.Mode.QUADS, 256, false, false, 
    		RenderType.CompositeState.builder()
    		.setShaderState(RENDERTYPE_THE_VOID_CUBE_BOSS_PROGRESS_ONE_SHADER)
    		.setTextureState(RenderStateShard.MultiTextureStateShard.builder()
    		.add(resourceLocation1, false, false)
    		.add(resourceLocation2, false, false).build())
    		.createCompositeState(false));
    }

    public static RenderType TheVoidCubeBossProgressTwo(ResourceLocation resourceLocation1, ResourceLocation resourceLocation2) {
    	return create("the_void_cube_boss_progress_two", DefaultVertexFormat.POSITION, VertexFormat.Mode.QUADS, 256, false, false, 
    		RenderType.CompositeState.builder()
    		.setShaderState(RENDERTYPE_THE_VOID_CUBE_BOSS_PROGRESS_TWO_SHADER)
    		.setTextureState(RenderStateShard.MultiTextureStateShard.builder()
    		.add(resourceLocation1, false, false)
    		.add(resourceLocation2, false, false).build())
    		.createCompositeState(false));
    }

    public static RenderType TheVoidCubeBossProgressThree(ResourceLocation resourceLocation1, ResourceLocation resourceLocation2) {
    	return create("the_void_cube_boss_progress_three", DefaultVertexFormat.POSITION, VertexFormat.Mode.QUADS, 256, false, false, 
    		RenderType.CompositeState.builder()
    		.setShaderState(RENDERTYPE_THE_VOID_CUBE_BOSS_PROGRESS_THREE_SHADER)
    		.setTextureState(RenderStateShard.MultiTextureStateShard.builder()
    		.add(resourceLocation1, false, false)
    		.add(resourceLocation2, false, false).build())
    		.createCompositeState(false));
    }

    public static ShaderInstance getRendertypeEnchantingTableBeamShader() {
    	try {
    		RendertypeEnchantingTableBeamShader = new ShaderInstance(Minecraft.getInstance().getResourceManager(), "endless_deep_space:rendertype_enchanting_table_beam", DefaultVertexFormat.POSITION);
    	} catch (IOException ioexception) {
    	}
    	return RendertypeEnchantingTableBeamShader;
    }

    public static ShaderInstance getRendertypeTheVoidCubeCommonShader() {
    	try {
    		RendertypeTheVoidCubeCommonShader = new ShaderInstance(Minecraft.getInstance().getResourceManager(), "endless_deep_space:rendertype_the_void_cube_common", DefaultVertexFormat.POSITION);
    	} catch (IOException ioexception) {
    	}
    	return RendertypeTheVoidCubeCommonShader;
    }

    public static ShaderInstance getRendertypeTheVoidCubeHurtShader() {
    	try {
    		RendertypeTheVoidCubeHurtShader = new ShaderInstance(Minecraft.getInstance().getResourceManager(), "endless_deep_space:rendertype_the_void_cube_hurt", DefaultVertexFormat.POSITION);
    	} catch (IOException ioexception) {
    	}
    	return RendertypeTheVoidCubeHurtShader;
    }

    public static ShaderInstance getRendertypeTheVoidCubeDeathShader() {
    	try {
    		RendertypeTheVoidCubeDeathShader = new ShaderInstance(Minecraft.getInstance().getResourceManager(), "endless_deep_space:rendertype_the_void_cube_death", DefaultVertexFormat.POSITION);
    	} catch (IOException ioexception) {
    	}
    	return RendertypeTheVoidCubeDeathShader;
    }

    public static ShaderInstance getRendertypeTheVoidCubeBossProgressOneShader() {
    	try {
    		RendertypeTheVoidCubeBossProgressOneShader = new ShaderInstance(Minecraft.getInstance().getResourceManager(), "endless_deep_space:rendertype_the_void_cube_boss_progress_one", DefaultVertexFormat.POSITION);
    	} catch (IOException ioexception) {
    	}
    	return RendertypeTheVoidCubeBossProgressOneShader;
    }

    public static ShaderInstance getRendertypeTheVoidCubeBossProgressTwoShader() {
    	try {
    		RendertypeTheVoidCubeBossProgressTwoShader = new ShaderInstance(Minecraft.getInstance().getResourceManager(), "endless_deep_space:rendertype_the_void_cube_boss_progress_two", DefaultVertexFormat.POSITION);
    	} catch (IOException ioexception) {
    	}
    	return RendertypeTheVoidCubeBossProgressTwoShader;
    }

    public static ShaderInstance getRendertypeTheVoidCubeBossProgressThreeShader() {
    	try {
    		RendertypeTheVoidCubeBossProgressThreeShader = new ShaderInstance(Minecraft.getInstance().getResourceManager(), "endless_deep_space:rendertype_the_void_cube_boss_progress_three", DefaultVertexFormat.POSITION);
    	} catch (IOException ioexception) {
    	}
    	return RendertypeTheVoidCubeBossProgressThreeShader;
    }
}
