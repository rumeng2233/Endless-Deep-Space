package shirumengya.rumeng.reborn.endless_deep_space.custom.commands.data_modify_more;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.arguments.NbtPathArgument;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;

public interface DataAccessor {
   void setData(CompoundTag p_139323_) throws CommandSyntaxException;

   CompoundTag getData() throws CommandSyntaxException;

   Component getModifiedSuccess();

   Component getPrintSuccess(Tag p_139324_);

   Component getPrintSuccess(NbtPathArgument.NbtPath p_139320_, double p_139321_, int p_139322_);
}