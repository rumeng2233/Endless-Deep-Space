package shirumengya.rumeng.reborn.endless_deep_space.custom.mixin;

import com.google.common.collect.Lists;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.components.*;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.client.gui.*;
import net.minecraft.client.gui.screens.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.screens.Screen;
import shirumengya.rumeng.reborn.endless_deep_space.custom.client.gui.screens.EndlessDeepSpaceCredits;
import com.google.common.util.concurrent.Runnables;
import net.minecraft.client.sounds.*;
import net.minecraft.sounds.Music;
import net.minecraft.world.level.Level;
import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.*;
import shirumengya.rumeng.reborn.endless_deep_space.custom.sounds.*;
import java.util.Calendar;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import shirumengya.rumeng.reborn.endless_deep_space.entity.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.client.server.IntegratedServer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.sounds.Musics;
import shirumengya.rumeng.reborn.endless_deep_space.*;
import net.minecraft.client.resources.language.I18n;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Queues;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.exceptions.AuthenticationException;
import com.mojang.authlib.minecraft.BanDetails;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import com.mojang.authlib.minecraft.UserApiService;
import com.mojang.authlib.minecraft.UserApiService.UserFlag;
import com.mojang.authlib.properties.PropertyMap;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import com.mojang.blaze3d.pipeline.MainTarget;
import com.mojang.blaze3d.pipeline.RenderTarget;
import com.mojang.blaze3d.pipeline.TextureTarget;
import com.mojang.blaze3d.platform.DisplayData;
import com.mojang.blaze3d.platform.GlDebug;
import com.mojang.blaze3d.platform.GlUtil;
import com.mojang.blaze3d.platform.MacosUtil;
import com.mojang.blaze3d.platform.Window;
import com.mojang.blaze3d.platform.WindowEventHandler;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.systems.TimerQuery;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.BufferUploader;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.datafixers.DataFixer;
import com.mojang.logging.LogUtils;
import com.mojang.math.Matrix4f;
import com.mojang.realmsclient.client.RealmsClient;
import com.mojang.realmsclient.dto.RealmsServer;
import com.mojang.realmsclient.gui.RealmsDataFetcher;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.net.Proxy;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Optional;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.CrashReport;
import net.minecraft.CrashReportCategory;
import net.minecraft.FileUtil;
import net.minecraft.ReportedException;
import net.minecraft.SharedConstants;
import net.minecraft.SystemReport;
import net.minecraft.Util;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.components.toasts.SystemToast;
import net.minecraft.client.gui.components.toasts.ToastComponent;
import net.minecraft.client.gui.components.toasts.TutorialToast;
import net.minecraft.client.gui.font.FontManager;
import net.minecraft.client.gui.screens.BanNoticeScreen;
import net.minecraft.client.gui.screens.ChatScreen;
import net.minecraft.client.gui.screens.ConfirmLinkScreen;
import net.minecraft.client.gui.screens.ConnectScreen;
import net.minecraft.client.gui.screens.DeathScreen;
import net.minecraft.client.gui.screens.GenericDirtMessageScreen;
import net.minecraft.client.gui.screens.InBedChatScreen;
import net.minecraft.client.gui.screens.LevelLoadingScreen;
import net.minecraft.client.gui.screens.LoadingOverlay;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.gui.screens.OutOfMemoryScreen;
import net.minecraft.client.gui.screens.Overlay;
import net.minecraft.client.gui.screens.PauseScreen;
import net.minecraft.client.gui.screens.ProgressScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.gui.screens.WinScreen;
import net.minecraft.client.gui.screens.advancements.AdvancementsScreen;
import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.gui.screens.social.PlayerSocialManager;
import net.minecraft.client.gui.screens.social.SocialInteractionsScreen;
import net.minecraft.client.gui.screens.worldselection.WorldOpenFlows;
import net.minecraft.client.main.GameConfig;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.multiplayer.ClientHandshakePacketListenerImpl;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import net.minecraft.client.multiplayer.ProfileKeyPairManager;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.multiplayer.chat.ChatListener;
import net.minecraft.client.multiplayer.chat.report.ReportEnvironment;
import net.minecraft.client.multiplayer.chat.report.ReportingContext;
import net.minecraft.client.multiplayer.resolver.ServerAddress;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.profiling.ClientMetricsSamplersProvider;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.GpuWarnlistManager;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.RenderBuffers;
import net.minecraft.client.renderer.VirtualScreen;
import net.minecraft.client.renderer.block.BlockModelShaper;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.debug.DebugRenderer;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.ClientPackSource;
import net.minecraft.client.resources.FoliageColorReloadListener;
import net.minecraft.client.resources.GrassColorReloadListener;
import net.minecraft.client.resources.LegacyPackResourcesAdapter;
import net.minecraft.client.resources.MobEffectTextureManager;
import net.minecraft.client.resources.PackResourcesAdapterV4;
import net.minecraft.client.resources.PaintingTextureManager;
import net.minecraft.client.resources.SkinManager;
import net.minecraft.client.resources.SplashManager;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.client.resources.language.LanguageManager;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelManager;
import net.minecraft.client.searchtree.FullTextSearchTree;
import net.minecraft.client.searchtree.IdSearchTree;
import net.minecraft.client.searchtree.SearchRegistry;
import net.minecraft.client.searchtree.SearchTree;
import net.minecraft.client.server.IntegratedServer;
import net.minecraft.client.sounds.MusicManager;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.client.tutorial.Tutorial;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.network.Connection;
import net.minecraft.network.ConnectionProtocol;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.contents.KeybindResolver;
import net.minecraft.network.protocol.game.ServerboundPlayerActionPacket;
import net.minecraft.network.protocol.handshake.ClientIntentionPacket;
import net.minecraft.network.protocol.login.ServerboundHelloPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.Bootstrap;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.Services;
import net.minecraft.server.WorldStem;
import net.minecraft.server.level.progress.ProcessorChunkProgressListener;
import net.minecraft.server.level.progress.StoringChunkProgressListener;
import net.minecraft.server.packs.PackResources;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.minecraft.server.packs.repository.FolderRepositorySource;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackRepository;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.server.packs.resources.ReloadInstance;
import net.minecraft.server.packs.resources.ReloadableResourceManager;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.players.GameProfileCache;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.Musics;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.FileZipper;
import net.minecraft.util.FrameTimer;
import net.minecraft.util.MemoryReserve;
import net.minecraft.util.ModCheck;
import net.minecraft.util.Mth;
import net.minecraft.util.SignatureValidator;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.Unit;
import net.minecraft.util.datafix.DataFixers;
import net.minecraft.util.profiling.ContinuousProfiler;
import net.minecraft.util.profiling.EmptyProfileResults;
import net.minecraft.util.profiling.InactiveProfiler;
import net.minecraft.util.profiling.ProfileResults;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.util.profiling.ResultField;
import net.minecraft.util.profiling.SingleTickProfiler;
import net.minecraft.util.profiling.metrics.profiling.ActiveMetricsRecorder;
import net.minecraft.util.profiling.metrics.profiling.InactiveMetricsRecorder;
import net.minecraft.util.profiling.metrics.profiling.MetricsRecorder;
import net.minecraft.util.profiling.metrics.storage.MetricsPersister;
import net.minecraft.util.thread.ReentrantBlockableEventLoop;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.ChatVisiblity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.ProfilePublicKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PlayerHeadItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.SkullBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.LevelStorageSource;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.commons.io.FileUtils;
import org.lwjgl.util.tinyfd.TinyFileDialogs;
import org.slf4j.Logger;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.monster.warden.Warden;

@Mixin(Minecraft.class)
public class MinecraftMixin {
	
//@Final
@Shadow
IntegratedServer singleplayerServer;
ServerData currentServer;
	
	@Overwrite
	public void pauseGame(boolean p_91359_) {
      if (Minecraft.getInstance().screen == null) {
         boolean flag = Minecraft.getInstance().hasSingleplayerServer() && !this.singleplayerServer.isPublished();
         if (flag) {
            Minecraft.getInstance().setScreen(new PauseScreen(!p_91359_));
         } else {
            Minecraft.getInstance().setScreen(new PauseScreen(true));
         }

      }
   	}

   @Overwrite
   public Music getSituationalMusic() {
   	  if (Calendar.getInstance().get(Calendar.MONTH) == 3 && Calendar.getInstance().get(Calendar.DAY_OF_MONTH) == 1) {
         return EndlessDeepSpaceMusics.NEVER_GONNA_GIVE_YOU_UP;
   	  } else if (Minecraft.getInstance().screen instanceof EndlessDeepSpaceCredits) {
         return Musics.CREDITS;
      } else if (Minecraft.getInstance().screen instanceof WinScreen) {
         return Musics.CREDITS;
      } else if (Minecraft.getInstance().player != null) {
		  if (!Minecraft.getInstance().player.level.getEntitiesOfClass(Warden.class, AABB.ofSize(new Vec3(Minecraft.getInstance().player.getX(), Minecraft.getInstance().player.getY(), Minecraft.getInstance().player.getZ()), 49, 51, 49), e -> true).isEmpty()) {
		  	return EndlessDeepSpaceMusics.MUSIC_C418_0X10C;
		  }
      	  if (!Minecraft.getInstance().player.level.getEntitiesOfClass(MadWitchEntity.class, AABB.ofSize(new Vec3(Minecraft.getInstance().player.getX(), Minecraft.getInstance().player.getY(), Minecraft.getInstance().player.getZ()), 256, 256, 256), e -> true).isEmpty()
      	  	|| !Minecraft.getInstance().player.level.getEntitiesOfClass(WitherestEntity.class, AABB.ofSize(new Vec3(Minecraft.getInstance().player.getX(), Minecraft.getInstance().player.getY(), Minecraft.getInstance().player.getZ()), 256, 256, 256), e -> true).isEmpty()
      	  	|| !Minecraft.getInstance().player.level.getEntitiesOfClass(WitherBoss.class, AABB.ofSize(new Vec3(Minecraft.getInstance().player.getX(), Minecraft.getInstance().player.getY(), Minecraft.getInstance().player.getZ()), 76, 76, 76), e -> true).isEmpty()
      	  	|| !Minecraft.getInstance().player.level.getEntitiesOfClass(Ghast.class, AABB.ofSize(new Vec3(Minecraft.getInstance().player.getX(), Minecraft.getInstance().player.getY(), Minecraft.getInstance().player.getZ()), 100, 100, 100), e -> true).isEmpty()) {
         	return EndlessDeepSpaceMusics.MINECRAFT_MUSIC_BIOME_NETHER_WASTES;
      	  } 
      	  if (Minecraft.getInstance().player.level.dimension() == Level.END) {
             return Minecraft.getInstance().gui.getBossOverlay().shouldPlayMusic() ? Musics.END_BOSS : Musics.END;
          } else if (Minecraft.getInstance().player.level.dimension() == (ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("endless_deep_space:nihility")))) {
         	return EndlessDeepSpaceMusics.MINECRAFT_MUSIC_BIOME_NETHER_WASTES;
          } else if (Minecraft.getInstance().player.isUnderWater()) {
	         return Musics.UNDER_WATER;
	      } else {
            Holder<Biome> holder = Minecraft.getInstance().player.level.getBiome(Minecraft.getInstance().player.blockPosition());
            return Minecraft.getInstance().player.level.dimension() != Level.NETHER && Minecraft.getInstance().player.getAbilities().instabuild && Minecraft.getInstance().player.getAbilities().mayfly ? Musics.CREATIVE : holder.value().getBackgroundMusic().orElse(Musics.GAME);
	      } 
   	  } else if (Calendar.getInstance().get(Calendar.MONTH) == 8 && Calendar.getInstance().get(Calendar.DAY_OF_MONTH) == 28) {
      	return EndlessDeepSpaceMusics.GENSHIN_IMPACT_MAIN_THEME;
      } else {
      	return Musics.MENU;
      }
   }

   @Overwrite
   private String createTitle() {
      StringBuilder stringbuilder = new StringBuilder("Minecraft");
      if (Minecraft.checkModStatus().shouldReportAsModified()) {
         stringbuilder.append("*");
      }

      stringbuilder.append(" ");
      stringbuilder.append(SharedConstants.getCurrentVersion().getName());
      ClientPacketListener clientpacketlistener = Minecraft.getInstance().getConnection();
      if (clientpacketlistener != null && clientpacketlistener.getConnection().isConnected()) {
         stringbuilder.append(" - ");
         if (this.singleplayerServer != null && !this.singleplayerServer.isPublished()) {
            stringbuilder.append(I18n.get("title.singleplayer"));
         } else if (Minecraft.getInstance().isConnectedToRealms()) {
            stringbuilder.append(I18n.get("title.multiplayer.realms"));
         } else if (this.singleplayerServer == null && (this.currentServer == null || !this.currentServer.isLan())) {
            stringbuilder.append(I18n.get("title.multiplayer.other"));
         } else {
            stringbuilder.append(I18n.get("title.multiplayer.lan"));
         }
      }
      stringbuilder.append(" | ");
      stringbuilder.append("Endless Deep Space");
      stringbuilder.append(" - ");
      stringbuilder.append(EndlessDeepSpaceMod.Version);

      return stringbuilder.toString();
   }
}
