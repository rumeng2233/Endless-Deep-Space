package shirumengya.rumeng.reborn.endless_deep_space.custom.client.gui.screens;

import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.logging.LogUtils;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import it.unimi.dsi.fastutil.ints.IntSet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.client.GameNarrator;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.util.GsonHelper;
import net.minecraft.util.RandomSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.slf4j.Logger;
import net.minecraft.client.gui.screens.Screen;
import java.util.ArrayList;
import net.minecraft.client.Minecraft;
import org.stringtemplate.v4.ST;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.ForgeRegistries;
import javax.annotation.Nullable;
<<<<<<< Updated upstream
=======
import net.minecraft.sounds.Music;
import shirumengya.rumeng.reborn.endless_deep_space.EndlessDeepSpaceMod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.client.gui.screens.WinScreen;
>>>>>>> Stashed changes

@OnlyIn(Dist.CLIENT)
public class EndlessDeepSpaceCredits extends Screen {
   private static final Logger LOGGER = LogUtils.getLogger();
   private static final ResourceLocation LOGO_LOCATION = new ResourceLocation("textures/gui/title/minecraft.png");
   private static final ResourceLocation EDITION_LOCATION = new ResourceLocation("textures/gui/title/edition.png");
   private static final ResourceLocation VIGNETTE_LOCATION = new ResourceLocation("textures/misc/vignette.png");
   private static final ResourceLocation POEM_BACKGROUND_LOCATION = new ResourceLocation("textures/gui/endless_deep_space_credits_background/poem.png");
   private static final ResourceLocation BROKEN_BACKGROUND_LOCATION = new ResourceLocation("textures/gui/endless_deep_space_credits_background/broken.png");
   private static final ResourceLocation DIRT_BACKGROUND_LOCATION = new ResourceLocation("textures/block/dirt.png");
   private static final ResourceLocation STONE_BACKGROUND_LOCATION = new ResourceLocation("textures/block/stone.png");
   private static final ResourceLocation END_STONE_BACKGROUND_LOCATION = new ResourceLocation("textures/block/end_stone.png");
   private static final ResourceLocation NETHERRACK_BACKGROUND_LOCATION = new ResourceLocation("textures/block/netherrack.png");
   private static final ResourceLocation 野兽先辈_BACKGROUND_LOCATION = new ResourceLocation("textures/gui/aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa.png");
   private static final Component SECTION_HEADING = Component.literal("============").withStyle(ChatFormatting.WHITE);
   private static final String NAME_PREFIX = "           ";
   private static final String OBFUSCATE_TOKEN = "" + ChatFormatting.WHITE + ChatFormatting.OBFUSCATED + ChatFormatting.GREEN + ChatFormatting.AQUA;
   private static final int LOGO_WIDTH = 274;
   private static final float SPEEDUP_FACTOR = 5.0F;
   private static final float SPEEDUP_FACTOR_FAST = 15.0F;
   private final String chapter;
   private final Runnable onFinished;
   private float scroll;
   private List<FormattedCharSequence> lines;
   private IntSet centeredLines;
   private int totalScrollLength;
   private boolean speedupActive;
   private final IntSet speedupModifiers = new IntOpenHashSet();
   private float scrollSpeed;
   private final float unmodifiedScrollSpeed;
   private final String BGtype;
   private final boolean ShouldCloseOnEsc;
   private final boolean CanModifiedScrollSpeed;

   public EndlessDeepSpaceCredits(String chapters, String BGtypes, float ScrollSpeed, boolean CanModifiedScrollSpeed, boolean shouldCloseOnEsc, Runnable p_96878_) {
      super(GameNarrator.NO_TITLE);
      if (this.minecraft == null) this.minecraft = Minecraft.getInstance();
      this.chapter = chapters;
<<<<<<< Updated upstream
      this.BGtype = BGtypes;
=======
      if (BackgroundLocations.equals("vanilla")) {
      	this.BackgroundLocation = GuiComponent.BACKGROUND_LOCATION;
      } else {
      	this.BackgroundLocation = new ResourceLocation(BackgroundLocations);
      }
>>>>>>> Stashed changes
      this.onFinished = p_96878_;
      this.unmodifiedScrollSpeed = ScrollSpeed;
      this.scrollSpeed = this.unmodifiedScrollSpeed;
      this.CanModifiedScrollSpeed = CanModifiedScrollSpeed;
      this.ShouldCloseOnEsc = shouldCloseOnEsc;
   }

   private float calculateScrollSpeed() {
   	if (this.CanModifiedScrollSpeed == true) {
      return this.speedupActive ? this.unmodifiedScrollSpeed * (5.0F + (float)this.speedupModifiers.size() * 15.0F) : this.unmodifiedScrollSpeed;
   	} else {
   	  return this.unmodifiedScrollSpeed;
   	}
   }

   public void tick() {
   if (this.minecraft == null) this.minecraft = Minecraft.getInstance();
      this.minecraft.getMusicManager().tick();
      this.minecraft.getSoundManager().tick(false);
      float f = (float)(this.totalScrollLength + this.height + this.height + 24);
      if (this.scroll > f) {
         this.respawn();
      }

   }

   public boolean keyPressed(int p_169469_, int p_169470_, int p_169471_) {
      if (p_169469_ != 341 && p_169469_ != 345) {
         if (p_169469_ == 32) {
            this.speedupActive = true;
         }
      } else {
         this.speedupModifiers.add(p_169469_);
      }

      this.scrollSpeed = this.calculateScrollSpeed();
      return super.keyPressed(p_169469_, p_169470_, p_169471_);
   }

   public boolean keyReleased(int p_169476_, int p_169477_, int p_169478_) {
      if (p_169476_ == 32) {
         this.speedupActive = false;
      } else if (p_169476_ == 341 || p_169476_ == 345) {
         this.speedupModifiers.remove(p_169476_);
      }

      this.scrollSpeed = this.calculateScrollSpeed();
      return super.keyReleased(p_169476_, p_169477_, p_169478_);
   }

   public void onClose() {
      this.respawn();
   }

   private void respawn() {
   if (this.minecraft == null) this.minecraft = Minecraft.getInstance();
<<<<<<< Updated upstream
      this.onFinished.run();
      this.minecraft.setScreen((Screen)null);
=======
   	  if (this.onFinished != null) {
      	this.onFinished.run();
   	  }
      this.minecraft.setScreen(screen);
>>>>>>> Stashed changes
   }

   protected void init() {
      if (this.lines == null) {
         this.lines = Lists.newArrayList();
         this.centeredLines = new IntOpenHashSet();

         if ((this.chapter).equals("poem_and_credits")) {
           	this.wrapCreditsIO("texts/endless_deep_space.end.txt", this::addPoemFile);
           	this.wrapCreditsIO("texts/end.txt", this::addPoemFile);
         	this.wrapCreditsIO("texts/endless_deep_space.credits.json", this::addCreditsFile);
         	this.wrapCreditsIO("texts/credits.json", this::addCreditsFile);
           	this.wrapCreditsIO("texts/postcredits.txt", this::addPoemFile);
         } else if ((this.chapter).equals("poem")) {
           	this.wrapCreditsIO("texts/endless_deep_space.end.txt", this::addPoemFile);
           	this.wrapCreditsIO("texts/end.txt", this::addPoemFile);
         } else if ((this.chapter).equals("vanilla_poem_and_credits")) {
           	this.wrapCreditsIO("texts/end.txt", this::addPoemFile);
         	this.wrapCreditsIO("texts/credits.json", this::addCreditsFile);
           	this.wrapCreditsIO("texts/postcredits.txt", this::addPoemFile);
         } else if ((this.chapter).equals("vanilla_poem")) {
           	this.wrapCreditsIO("texts/end.txt", this::addPoemFile);
           	this.wrapCreditsIO("texts/postcredits.txt", this::addPoemFile);
         } else if ((this.chapter).equals("vanilla_poem_and_endless_deep_space_credits_and_credits")) {
           	this.wrapCreditsIO("texts/end.txt", this::addPoemFile);
           	this.wrapCreditsIO("texts/endless_deep_space.credits.json", this::addCreditsFile);
         	this.wrapCreditsIO("texts/credits.json", this::addCreditsFile);
           	this.wrapCreditsIO("texts/postcredits.txt", this::addPoemFile);
<<<<<<< Updated upstream
=======
         } else if ((this.chapter).equals("vanilla_poem_and_endless_deep_space_credits")) {
           	this.wrapCreditsIO("texts/end.txt", this::addPoemFile);
           	this.wrapCreditsIO("texts/endless_deep_space.credits.json", this::addCreditsFile);
           	this.wrapCreditsIO("texts/postcredits.txt", this::addPoemFile);
         }	else if ((this.chapter).equals("vanilla_credits")) {
         	this.wrapCreditsIO("texts/credits.json", this::addCreditsFile);
           	this.wrapCreditsIO("texts/postcredits.txt", this::addPoemFile);
>>>>>>> Stashed changes
         } else if ((this.chapter).equals("credits")) {
         	this.wrapCreditsIO("texts/endless_deep_space.credits.json", this::addCreditsFile);
         	this.wrapCreditsIO("texts/credits.json", this::addCreditsFile);
         } else if ((this.chapter).equals("postcredits")) {
           	this.wrapCreditsIO("texts/postcredits.txt", this::addPoemFile);
         } else if ((this.chapter).equals("credits_and_postcredits")) {
         	this.wrapCreditsIO("texts/endless_deep_space.credits.json", this::addCreditsFile);
         	this.wrapCreditsIO("texts/credits.json", this::addCreditsFile);
           	this.wrapCreditsIO("texts/postcredits.txt", this::addPoemFile);
         } else if ((this.chapter).equals("story:broken_world:broken_book_one")) {
           	this.wrapCreditsIO("texts/endless_deep_space_story/broken_world/broken_book/broken_book_one.txt", this::addPoemFile);
         } else if ((this.chapter).equals("story:broken_world:broken_book_two")) {
           	this.wrapCreditsIO("texts/endless_deep_space_story/broken_world/broken_book/broken_book_two.txt", this::addPoemFile);
         } else if ((this.chapter).equals("story:broken_world:broken_book_three")) {
           	this.wrapCreditsIO("texts/endless_deep_space_story/broken_world/broken_book/broken_book_three.txt", this::addPoemFile);
         } else if ((this.chapter).equals("story:broken_world:broken_book_four")) {
           	this.wrapCreditsIO("texts/endless_deep_space_story/broken_world/broken_book/broken_book_four.txt", this::addPoemFile);
         } else if ((this.chapter).equals("story:broken_world:broken_book_five")) {
           	this.wrapCreditsIO("texts/endless_deep_space_story/broken_world/broken_book/broken_book_five.txt", this::addPoemFile);
         } else if ((this.chapter).equals("story:broken_world:broken_book_six")) {
           	this.wrapCreditsIO("texts/endless_deep_space_story/broken_world/broken_book/broken_book_six.json", this::addCreditsFile);
         } else if ((this.chapter).equals("story:broken_world:broken_book_seven")) {
           	this.wrapCreditsIO("texts/endless_deep_space_story/broken_world/broken_book/broken_book_seven.txt", this::addPoemFile);
         } else if ((this.chapter).equals("story:broken_world:broken_book_eight")) {
           	this.wrapCreditsIO("texts/endless_deep_space_story/broken_world/broken_book/broken_book_eight.txt", this::addPoemFile);
         } else if ((this.chapter).equals("story:broken_world:broken_book_nine")) {
           	this.wrapCreditsIO("texts/endless_deep_space_story/broken_world/broken_book/broken_book_nine.txt", this::addPoemFile);
         } else if ((this.chapter).equals("story:broken_world:broken_book_ten")) {
           	this.wrapCreditsIO("texts/endless_deep_space_story/broken_world/broken_book/broken_book_ten.txt", this::addPoemFile);
         }

         this.totalScrollLength = this.lines.size() * 12;
      }
   }

   private void wrapCreditsIO(String p_197399_, EndlessDeepSpaceCredits.CreditsReader p_197400_) {
      try {
         if (this.minecraft == null) this.minecraft = Minecraft.getInstance();
         Reader reader = this.minecraft.getResourceManager().openAsReader(new ResourceLocation(p_197399_));

         try {
            p_197400_.read(reader);
         } catch (Throwable throwable1) {
            if (reader != null) {
               try {
                  reader.close();
               } catch (Throwable throwable) {
                  throwable1.addSuppressed(throwable);
               }
            }

            throw throwable1;
         }

         if (reader != null) {
            reader.close();
         }
      } catch (Exception exception) {
         LOGGER.error("Couldn't load credits", (Throwable)exception);
      }

   }

   private void addPoemFile(Reader p_232818_) throws IOException {
      BufferedReader bufferedreader = new BufferedReader(p_232818_);
      RandomSource randomsource = RandomSource.create(8124371L);

      String s;
      while((s = bufferedreader.readLine()) != null) {
         int i;
         String s1;
         String s2;
         if (this.minecraft == null) this.minecraft = Minecraft.getInstance();
         for(s = s.replaceAll("PLAYERNAME", this.minecraft.getUser().getName()); (i = s.indexOf(OBFUSCATE_TOKEN)) != -1; s = s1 + ChatFormatting.WHITE + ChatFormatting.OBFUSCATED + "XXXXXXXX".substring(0, randomsource.nextInt(4) + 3) + s2) {
            s1 = s.substring(0, i);
            s2 = s.substring(i + OBFUSCATE_TOKEN.length());
         }

         this.addPoemLines(s);
         this.addEmptyLine();
      }

      for(int j = 0; j < 8; ++j) {
         this.addEmptyLine();
      }

   }

   private void addCreditsFile(Reader p_232820_) {
      for(JsonElement jsonelement : GsonHelper.parseArray(p_232820_)) {
         JsonObject jsonobject = jsonelement.getAsJsonObject();
         String s = jsonobject.get("section").getAsString();
         this.addCreditsLine(SECTION_HEADING, true);
         this.addCreditsLine(Component.literal(s).withStyle(ChatFormatting.YELLOW), true);
         this.addCreditsLine(SECTION_HEADING, true);
         this.addEmptyLine();
         this.addEmptyLine();

         for(JsonElement jsonelement1 : jsonobject.getAsJsonArray("titles")) {
            JsonObject jsonobject1 = jsonelement1.getAsJsonObject();
            String s1 = jsonobject1.get("title").getAsString();
            JsonArray jsonarray = jsonobject1.getAsJsonArray("names");
            this.addCreditsLine(Component.literal(s1).withStyle(ChatFormatting.GRAY), false);

            for(JsonElement jsonelement2 : jsonarray) {
               String s2 = jsonelement2.getAsString();
               this.addCreditsLine(Component.literal("           ").append(s2).withStyle(ChatFormatting.WHITE), false);
            }

            this.addEmptyLine();
            this.addEmptyLine();
         }
      }

   }

   private void addEmptyLine() {
      this.lines.add(FormattedCharSequence.EMPTY);
   }

   private void addPoemLines(String p_181398_) {
   if (this.minecraft == null) this.minecraft = Minecraft.getInstance();
      this.lines.addAll(this.minecraft.font.split(Component.literal(p_181398_), 274));
   }

   private void addCreditsLine(Component p_169473_, boolean p_169474_) {
      if (p_169474_) {
         this.centeredLines.add(this.lines.size());
      }

      this.lines.add(p_169473_.getVisualOrderText());
   }

   private void renderBg() {
      RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
      if ((this.BGtype).equals("poem")) {
      	RenderSystem.setShaderTexture(0, POEM_BACKGROUND_LOCATION);
      } else if ((this.BGtype).equals("vanilla")) {
      	RenderSystem.setShaderTexture(0, GuiComponent.BACKGROUND_LOCATION);
      } else if ((this.BGtype).equals("broken")) {
      	RenderSystem.setShaderTexture(0, BROKEN_BACKGROUND_LOCATION);
      } else if ((this.BGtype).equals("dirt")) {
      	RenderSystem.setShaderTexture(0, DIRT_BACKGROUND_LOCATION);
      } else if ((this.BGtype).equals("stone")) {
      	RenderSystem.setShaderTexture(0, STONE_BACKGROUND_LOCATION);
      } else if ((this.BGtype).equals("end_stone")) {
      	RenderSystem.setShaderTexture(0, END_STONE_BACKGROUND_LOCATION);
      } else if ((this.BGtype).equals("netherrack")) {
      	RenderSystem.setShaderTexture(0, NETHERRACK_BACKGROUND_LOCATION);
      } else if ((this.BGtype).equals("野兽先辈")) {
      	RenderSystem.setShaderTexture(0, 野兽先辈_BACKGROUND_LOCATION);
      }
      int i = this.width;
      float f = -this.scroll * 0.5F;
      float f1 = (float)this.height - 0.5F * this.scroll;
      float f2 = 0.015625F;
      float f3 = this.scroll / this.unmodifiedScrollSpeed;
      float f4 = f3 * 0.02F;
      float f5 = (float)(this.totalScrollLength + this.height + this.height + 24) / this.unmodifiedScrollSpeed;
      float f6 = (f5 - 20.0F - f3) * 0.005F;
      if (f6 < f4) {
         f4 = f6;
      }

      if (f4 > 1.0F) {
         f4 = 1.0F;
      }

      f4 *= f4;
      f4 = f4 * 96.0F / 255.0F;
      Tesselator tesselator = Tesselator.getInstance();
      BufferBuilder bufferbuilder = tesselator.getBuilder();
      bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR);
      bufferbuilder.vertex(0.0D, (double)this.height, (double)this.getBlitOffset()).uv(0.0F, f * 0.015625F).color(f4, f4, f4, 1.0F).endVertex();
      bufferbuilder.vertex((double)i, (double)this.height, (double)this.getBlitOffset()).uv((float)i * 0.015625F, f * 0.015625F).color(f4, f4, f4, 1.0F).endVertex();
      bufferbuilder.vertex((double)i, 0.0D, (double)this.getBlitOffset()).uv((float)i * 0.015625F, f1 * 0.015625F).color(f4, f4, f4, 1.0F).endVertex();
      bufferbuilder.vertex(0.0D, 0.0D, (double)this.getBlitOffset()).uv(0.0F, f1 * 0.015625F).color(f4, f4, f4, 1.0F).endVertex();
      tesselator.end();
   }

   public void render(PoseStack p_96884_, int p_96885_, int p_96886_, float p_96887_) {
   if (this.minecraft == null) this.minecraft = Minecraft.getInstance();
   if (this.lines != null) {
      this.scroll += p_96887_ * this.scrollSpeed;
      this.renderBg();
      int i = this.width / 2 - 137;
      int j = this.height + 50;
      float f = -this.scroll;
      p_96884_.pushPose();
      p_96884_.translate(0.0D, (double)f, 0.0D);
      RenderSystem.setShaderTexture(0, LOGO_LOCATION);
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      RenderSystem.enableBlend();
      this.blitOutlineBlack(i, j, (p_96890_, p_96891_) -> {
         this.blit(p_96884_, p_96890_ + 0, p_96891_, 0, 0, 155, 44);
         this.blit(p_96884_, p_96890_ + 155, p_96891_, 0, 45, 155, 44);
      });
      RenderSystem.disableBlend();
      RenderSystem.setShaderTexture(0, EDITION_LOCATION);
      blit(p_96884_, i + 88, j + 37, 0.0F, 0.0F, 98, 14, 128, 16);
      int k = j + 100;

      for(int l = 0; l < this.lines.size(); ++l) {
         if (l == this.lines.size() - 1) {
            float f1 = (float)k + f - (float)(this.height / 2 - 6);
            if (f1 < 0.0F) {
               p_96884_.translate(0.0D, (double)(-f1), 0.0D);
            }
         }

         if ((float)k + f + 12.0F + 8.0F > 0.0F && (float)k + f < (float)this.height) {
            FormattedCharSequence formattedcharsequence = this.lines.get(l);
            if (this.centeredLines.contains(l)) {
               this.font.drawShadow(p_96884_, formattedcharsequence, (float)(i + (274 - this.font.width(formattedcharsequence)) / 2), (float)k, 16777215);
            } else {
               this.font.drawShadow(p_96884_, formattedcharsequence, (float)i, (float)k, 16777215);
            }
         }

         k += 12;
      }

      p_96884_.popPose();
      RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
      RenderSystem.setShaderTexture(0, VIGNETTE_LOCATION);
      RenderSystem.enableBlend();
      RenderSystem.blendFunc(GlStateManager.SourceFactor.ZERO, GlStateManager.DestFactor.ONE_MINUS_SRC_COLOR);
      int i1 = this.width;
      int j1 = this.height;
      Tesselator tesselator = Tesselator.getInstance();
      BufferBuilder bufferbuilder = tesselator.getBuilder();
      bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR);
      bufferbuilder.vertex(0.0D, (double)j1, (double)this.getBlitOffset()).uv(0.0F, 1.0F).color(1.0F, 1.0F, 1.0F, 1.0F).endVertex();
      bufferbuilder.vertex((double)i1, (double)j1, (double)this.getBlitOffset()).uv(1.0F, 1.0F).color(1.0F, 1.0F, 1.0F, 1.0F).endVertex();
      bufferbuilder.vertex((double)i1, 0.0D, (double)this.getBlitOffset()).uv(1.0F, 0.0F).color(1.0F, 1.0F, 1.0F, 1.0F).endVertex();
      bufferbuilder.vertex(0.0D, 0.0D, (double)this.getBlitOffset()).uv(0.0F, 0.0F).color(1.0F, 1.0F, 1.0F, 1.0F).endVertex();
      tesselator.end();
      RenderSystem.disableBlend();
      super.render(p_96884_, p_96885_, p_96886_, p_96887_);
   } else {
   	LOGGER.error("java.lang.NullPointerException: Cannot invoke 'java.util.List.size()' because 'this.lines' is null");
   	Minecraft.getInstance().setScreen((Screen)null);
   	}
  }

  public boolean shouldCloseOnEsc() {
      return this.ShouldCloseOnEsc;
  }

   @FunctionalInterface
   @OnlyIn(Dist.CLIENT)
   interface CreditsReader {
      void read(Reader p_232822_) throws IOException;
   }
}