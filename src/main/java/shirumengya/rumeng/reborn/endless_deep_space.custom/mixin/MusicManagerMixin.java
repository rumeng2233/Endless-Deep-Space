package shirumengya.rumeng.reborn.endless_deep_space.custom.mixin;

import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.sounds.Music;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.client.sounds.*;
import org.spongepowered.asm.mixin.*;

@Mixin(MusicManager.class)
public class MusicManagerMixin {
@Final
@Shadow
Minecraft minecraft;
SoundInstance currentMusic;
int nextSongDelay = 100;
RandomSource random = RandomSource.create();

	@Overwrite
	public void tick() {
      Music music = this.minecraft.getSituationalMusic();
      if (this.currentMusic != null) {
         if (!music.getEvent().getLocation().equals(this.currentMusic.getLocation()) && music.replaceCurrentMusic()) {
            this.minecraft.getSoundManager().stop(this.currentMusic);
            this.nextSongDelay = Mth.nextInt(this.random, 0, music.getMinDelay() / 2);
         }
         if (!this.minecraft.getSoundManager().isActive(this.currentMusic)) {
            this.currentMusic = null;
            this.nextSongDelay = Math.min(this.nextSongDelay, Mth.nextInt(this.random, music.getMinDelay(), music.getMaxDelay()));
         }
      }
      this.nextSongDelay = Math.min(this.nextSongDelay, music.getMaxDelay());
      if (this.currentMusic == null && this.nextSongDelay-- <= 0) {
         this.startPlaying(music);
      }
   }

   @Overwrite
   public void startPlaying(Music p_120185_) {
      this.currentMusic = SimpleSoundInstance.forMusic(p_120185_.getEvent());
      if (this.currentMusic.getSound() != SoundManager.EMPTY_SOUND) {
         this.minecraft.getSoundManager().play(this.currentMusic);
      }

      this.nextSongDelay = Integer.MAX_VALUE;
   }
}
