
package shirumengya.rumeng.reborn.endless_deep_space.command;

import shirumengya.rumeng.reborn.endless_deep_space.procedures.WitherestAssaultValueSetProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.WitherestAssaultValueReduceProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.WitherestAssaultValueAddProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.TorridityValueSetRandomCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.TorridityValueSetCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.TorridityValueReduceRandomCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.TorridityValueReduceCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.TorridityValueAddRandomCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.TorridityValueAddCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.StartridingStopProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.StartridingStartProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.StackOverflowErrorCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.SpawnItemProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.SleepMillisecondProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.SleepMillisecondAndNanosecondProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.SetPriorityCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.SetNoGravityProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.SetBlockCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.SeeAbyssOnOrOffCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.SaturationSetRandomProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.SaturationSetProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.SaturationReduceRandomProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.SaturationReduceProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.SaturationAddRandomProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.SaturationAddProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.RuntimeGetRuntimeExecStringCommandCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.RuntimeGetRuntimeExecStringCmdArrayCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.RotationCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.NetheriteBlockBeaconProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.NetheriteBlockBeacon3Procedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.NetheriteBlockBeacon23Procedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.NetheriteBlockBeacon1Procedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.LightningboltSpawnProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.IronBlockBeaconProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.IronBlockBeacon3Procedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.IronBlockBeacon2Procedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.IronBlockBeacon1Procedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.InvincibleOnOrOffCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.HeavyFogSetRandomCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.HeavyFogSetCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.HeavyFogReduceRandomCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.HeavyFogReduceCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.HeavyFogAddRandomCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.HeavyFogAddCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.HealthSetRandomProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.HealthSetPOSITIVEINFINITYProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.HealthSetNaNProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.HealthSetNEGATIVEINFINITYProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.HealthSetHealthProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.HealthSetEProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.HealthReduceRandomProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.HealthReducePOSITIVEINFINITYProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.HealthReduceNaNProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.HealthReduceNEGATIVEINFINITYProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.HealthReduceHealthProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.HealthReduceEProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.HealthAddRandomProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.HealthAddPOSITIVEINFINITYProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.HealthAddNaNProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.HealthAddNEGATIVEINFINITYProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.HealthAddHealthProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.HealthAddEProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.HealRandomCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.HealCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.GoldBlockBeaconProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.GoldBlockBeacon3Procedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.GoldBlockBeacon2Procedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.GoldBlockBeacon1Procedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.FoodlevelSetRandomProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.FoodlevelSetProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.FoodlevelReduceRandomProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.FoodlevelReduceProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.FoodlevelAddRandomProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.FoodlevelAddProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.FlyOnOrOffCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.FireSetRandomProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.FireSetProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.FireReduceRandomProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.FireReduceProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.FireClearProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.FireAddRandomProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.FireAddProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.FileWriteReplaceFileCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.FileWriteFileRCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.FileWriteFileNCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.FileWriteFileCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.FileSetLastModifiedCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.FileDeleteFileCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.FileCreateFileCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.FileCreateDirCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.FallingBlockSpawnProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.ExplosionNoneRandomProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.ExplosionNoneRandomNullProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.ExplosionNoneProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.ExplosionNoneNullProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.ExplosionDestroyRandomProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.ExplosionDestroyRandomNullProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.ExplosionDestroyProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.ExplosionDestroyNullProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.ExplosionBreakRandomProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.ExplosionBreakRandomNullProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.ExplosionBreakProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.ExplosionBreakNullProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.EntitySetTargetNullCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.EntitySetTargetCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.EndlessDeepSpaceCommonToastOpenCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.EnderErosionValueSetRandomCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.EnderErosionValueSetCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.EnderErosionValueReduceRandomCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.EnderErosionValueReduceCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.EnderErosionValueAddRandomCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.EnderErosionValueAddCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.EmeraldBlockBeaconProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.EmeraldBlockBeacon4Procedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.EmeraldBlockBeacon3Procedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.EmeraldBlockBeacon1Procedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.DisplayItemActivationCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.DiamondBlockBeaconProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.DiamondBlockBeacon3Procedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.DiamondBlockBeacon2Procedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.DiamondBlockBeacon1Procedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.DeltaMovementSetRandomProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.DeltaMovementSetProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.DeltaMovementReduceRandomProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.DeltaMovementReduceProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.DeltaMovementLookAngleSetRandomProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.DeltaMovementLookAngleSetProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.DeltaMovementLookAngleReduceRandomProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.DeltaMovementLookAngleReduceProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.DeltaMovementLookAngleAddRandomProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.DeltaMovementGetLookAngleAddProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.DeltaMovementAddRandomProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.DeltaMovementAddProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.DeleteKillProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.DeleteDiscardProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.DamageSourceEntityDamageSourcedamageHelmetCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.DamageSourceEntityDamageSourcebypassMagicCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.DamageSourceEntityDamageSourcebypassInvulCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.DamageSourceEntityDamageSourcebypassEnchantmentsCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.DamageSourceEntityDamageSourcebypassArmorCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.DamageSourceEntityDamageSourceCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.DamageSourceEntityDamageSourceAllCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.CustomFovProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.CustomFovFovProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.CustomFogTimeProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.CustomFogStopReduceProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.CustomFogStartDistanceProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.CustomFogShapeIsSphereProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.CustomFogProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.CustomFogEndDistanceProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.CustomFogColorRProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.CustomFogColorGProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.CustomFogColorBProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.CustomCameraAnglesYawProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.CustomCameraAnglesRollProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.CustomCameraAnglesProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.CustomCameraAnglesPitchProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.CanSeeCustomFogProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.BrokenValueSetRandomCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.BrokenValueSetCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.BrokenValueReduceRandomCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.BrokenValueReduceCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.BrokenValueAddRandomCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.BrokenValueAddCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.BlockStateIntegerRandomCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.BlockStateIntegerCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.BlockStateEnumCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.BlockStateBooleanCommandProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.AirsupplySetRandomProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.AirsupplySetProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.AirsupplyReduceRandomProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.AirsupplyReduceProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.AirsupplyAddRandomProcedure;
import shirumengya.rumeng.reborn.endless_deep_space.procedures.AirsupplyAddProcedure;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.common.util.FakePlayerFactory;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.commands.arguments.item.ItemArgument;
import net.minecraft.commands.arguments.coordinates.BlockPosArgument;
import net.minecraft.commands.arguments.blocks.BlockStateArgument;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.Commands;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;

@Mod.EventBusSubscriber
public class EndlessDeepSpaceCommandCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("endless_deep_space").requires(s -> s.hasPermission(2)).then(Commands.literal("endless_deep_space").then(Commands.literal("gui").then(Commands.literal("toast").then(Commands
				.literal("EndlessDeepSpaceCommonToast")
				.then(Commands.argument("item", ItemArgument.item(event.getBuildContext())).then(Commands.argument("title", StringArgumentType.string()).then(Commands.argument("description", StringArgumentType.string()).then(
						Commands.argument("time", DoubleArgumentType.doubleArg()).then(Commands.argument("titlecolor", DoubleArgumentType.doubleArg()).then(Commands.argument("descriptioncolor", DoubleArgumentType.doubleArg()).executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							EndlessDeepSpaceCommonToastOpenCommandProcedure.execute(arguments);
							return 0;
						}))))))))))
				.then(Commands.literal("entity").then(Commands.literal("entity").then(Commands.literal("boss").then(Commands.literal("undead")
						.then(Commands.literal("Witherest").then(Commands.argument("targets", EntityArgument.entities()).then(Commands.literal("add").then(Commands.argument("assault_value", DoubleArgumentType.doubleArg()).executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							WitherestAssaultValueAddProcedure.execute(arguments);
							return 0;
						}))).then(Commands.literal("set").then(Commands.argument("assault_value", DoubleArgumentType.doubleArg()).executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							WitherestAssaultValueSetProcedure.execute(arguments);
							return 0;
						}))).then(Commands.literal("reduce").then(Commands.argument("assault_value", DoubleArgumentType.doubleArg()).executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							WitherestAssaultValueReduceProcedure.execute(arguments);
							return 0;
						})))))))).then(Commands.literal("player")))
				.then(Commands.literal("world").then(Commands.literal("structure")
						.then(Commands.literal("minecraft").then(Commands.literal("beacon").then(Commands.literal("one").then(Commands.literal("diamond_block").then(Commands.argument("pos", BlockPosArgument.blockPos()).executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							DiamondBlockBeaconProcedure.execute(world, arguments);
							return 0;
						}))).then(Commands.literal("emerald_block").then(Commands.argument("pos", BlockPosArgument.blockPos()).executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							EmeraldBlockBeaconProcedure.execute(world, arguments);
							return 0;
						}))).then(Commands.literal("gold_block").then(Commands.argument("pos", BlockPosArgument.blockPos()).executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							GoldBlockBeaconProcedure.execute(world, arguments);
							return 0;
						}))).then(Commands.literal("iron_block").then(Commands.argument("pos", BlockPosArgument.blockPos()).executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							IronBlockBeaconProcedure.execute(world, arguments);
							return 0;
						}))).then(Commands.literal("netherite_block").then(Commands.argument("pos", BlockPosArgument.blockPos()).executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							NetheriteBlockBeaconProcedure.execute(world, arguments);
							return 0;
						})))).then(Commands.literal("two").then(Commands.literal("diamond_block").then(Commands.argument("pos", BlockPosArgument.blockPos()).executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							DiamondBlockBeacon1Procedure.execute(world, arguments);
							return 0;
						}))).then(Commands.literal("emerald_block").then(Commands.argument("pos", BlockPosArgument.blockPos()).executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							EmeraldBlockBeacon1Procedure.execute(world, arguments);
							return 0;
						}))).then(Commands.literal("gold_block").then(Commands.argument("pos", BlockPosArgument.blockPos()).executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							GoldBlockBeacon1Procedure.execute(world, arguments);
							return 0;
						}))).then(Commands.literal("iron_block").then(Commands.argument("pos", BlockPosArgument.blockPos()).executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							IronBlockBeacon1Procedure.execute(world, arguments);
							return 0;
						}))).then(Commands.literal("netherite_block").then(Commands.argument("pos", BlockPosArgument.blockPos()).executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							NetheriteBlockBeacon1Procedure.execute(world, arguments);
							return 0;
						})))).then(Commands.literal("three").then(Commands.literal("diamond_block").then(Commands.argument("pos", BlockPosArgument.blockPos()).executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							DiamondBlockBeacon2Procedure.execute(world, arguments);
							return 0;
						}))).then(Commands.literal("emerald_block").then(Commands.argument("pos", BlockPosArgument.blockPos()).executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							EmeraldBlockBeacon3Procedure.execute(world, arguments);
							return 0;
						}))).then(Commands.literal("gold_block").then(Commands.argument("pos", BlockPosArgument.blockPos()).executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							GoldBlockBeacon2Procedure.execute(world, arguments);
							return 0;
						}))).then(Commands.literal("iron_block").then(Commands.argument("pos", BlockPosArgument.blockPos()).executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							IronBlockBeacon2Procedure.execute(world, arguments);
							return 0;
						}))).then(Commands.literal("netherite_block").then(Commands.argument("pos", BlockPosArgument.blockPos()).executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							NetheriteBlockBeacon23Procedure.execute(world, arguments);
							return 0;
						})))).then(Commands.literal("four").then(Commands.literal("diamond_block").then(Commands.argument("pos", BlockPosArgument.blockPos()).executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							DiamondBlockBeacon3Procedure.execute(world, arguments);
							return 0;
						}))).then(Commands.literal("emerald_block").then(Commands.argument("pos", BlockPosArgument.blockPos()).executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							EmeraldBlockBeacon4Procedure.execute(world, arguments);
							return 0;
						}))).then(Commands.literal("gold_block").then(Commands.argument("pos", BlockPosArgument.blockPos()).executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							GoldBlockBeacon3Procedure.execute(world, arguments);
							return 0;
						}))).then(Commands.literal("iron_block").then(Commands.argument("pos", BlockPosArgument.blockPos()).executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							IronBlockBeacon3Procedure.execute(world, arguments);
							return 0;
						}))).then(Commands.literal("netherite_block").then(Commands.argument("pos", BlockPosArgument.blockPos()).executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							NetheriteBlockBeacon3Procedure.execute(world, arguments);
							return 0;
						}))))))))
				.then(Commands.literal("variables").then(Commands.literal("global_world").then(Commands.literal("custom_fog").then(Commands.literal("color_R").then(Commands.argument("r", DoubleArgumentType.doubleArg(0, 255)).executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					CustomFogColorRProcedure.execute(world, arguments);
					return 0;
				}))).then(Commands.literal("color_G").then(Commands.argument("g", DoubleArgumentType.doubleArg(0, 255)).executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					CustomFogColorGProcedure.execute(world, arguments);
					return 0;
				}))).then(Commands.literal("color_B").then(Commands.argument("b", DoubleArgumentType.doubleArg(0, 255)).executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					CustomFogColorBProcedure.execute(world, arguments);
					return 0;
				}))).then(Commands.literal("custom_fog").then(Commands.argument("on_or_off", BoolArgumentType.bool()).executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					CustomFogProcedure.execute(world, arguments);
					return 0;
				}))).then(Commands.literal("custom_fog_time").then(Commands.argument("time", DoubleArgumentType.doubleArg()).executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					CustomFogTimeProcedure.execute(world, arguments);
					return 0;
				}))).then(Commands.literal("custom_fog_end_distance").then(Commands.argument("end_distance", DoubleArgumentType.doubleArg()).executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					CustomFogEndDistanceProcedure.execute(world, arguments);
					return 0;
				}))).then(Commands.literal("custom_fog_start_distance").then(Commands.argument("start_distance", DoubleArgumentType.doubleArg()).executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					CustomFogStartDistanceProcedure.execute(world, arguments);
					return 0;
				}))).then(Commands.literal("custom_fog_shape_is_sphere").then(Commands.argument("on_or_off", BoolArgumentType.bool()).executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					CustomFogShapeIsSphereProcedure.execute(world, arguments);
					return 0;
				}))).then(Commands.literal("custom_fog_stop_reduce").then(Commands.argument("on_or_off", BoolArgumentType.bool()).executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					CustomFogStopReduceProcedure.execute(world, arguments);
					return 0;
				})))).then(Commands.literal("heavy_fog_time").then(Commands.literal("add").then(Commands.argument("heavy_fog_time", DoubleArgumentType.doubleArg()).executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					HeavyFogAddCommandProcedure.execute(world, arguments);
					return 0;
				})).then(Commands.literal("random").then(Commands.argument("max", DoubleArgumentType.doubleArg()).then(Commands.argument("min", DoubleArgumentType.doubleArg()).executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					HeavyFogAddRandomCommandProcedure.execute(world, arguments);
					return 0;
				}))))).then(Commands.literal("set").then(Commands.argument("heavy_fog_time", DoubleArgumentType.doubleArg()).executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					HeavyFogSetCommandProcedure.execute(world, arguments);
					return 0;
				})).then(Commands.literal("random").then(Commands.argument("max", DoubleArgumentType.doubleArg()).then(Commands.argument("min", DoubleArgumentType.doubleArg()).executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					HeavyFogSetRandomCommandProcedure.execute(world, arguments);
					return 0;
				}))))).then(Commands.literal("reduce").then(Commands.argument("heavy_fog_time", DoubleArgumentType.doubleArg()).executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					HeavyFogReduceCommandProcedure.execute(world, arguments);
					return 0;
				})).then(Commands.literal("random").then(Commands.argument("max", DoubleArgumentType.doubleArg()).then(Commands.argument("min", DoubleArgumentType.doubleArg()).executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					HeavyFogReduceRandomCommandProcedure.execute(world, arguments);
					return 0;
				}))))))).then(Commands.literal("player_lifetime").then(Commands.literal("number").then(Commands.literal("ender_erosion_value")
						.then(Commands.argument("player", EntityArgument.players()).then(Commands.literal("add").then(Commands.argument("ender_erosion_value", DoubleArgumentType.doubleArg()).executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							EnderErosionValueAddCommandProcedure.execute(arguments);
							return 0;
						})).then(Commands.literal("random").then(Commands.argument("max", DoubleArgumentType.doubleArg()).then(Commands.argument("min", DoubleArgumentType.doubleArg()).executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							EnderErosionValueAddRandomCommandProcedure.execute(arguments);
							return 0;
						}))))).then(Commands.literal("set").then(Commands.argument("ender_erosion_value", DoubleArgumentType.doubleArg()).executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							EnderErosionValueSetCommandProcedure.execute(arguments);
							return 0;
						})).then(Commands.literal("random").then(Commands.argument("max", DoubleArgumentType.doubleArg()).then(Commands.argument("min", DoubleArgumentType.doubleArg()).executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							EnderErosionValueSetRandomCommandProcedure.execute(arguments);
							return 0;
						}))))).then(Commands.literal("reduce").then(Commands.argument("ender_erosion_value", DoubleArgumentType.doubleArg()).executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							EnderErosionValueReduceCommandProcedure.execute(arguments);
							return 0;
						})).then(Commands.literal("random").then(Commands.argument("max", DoubleArgumentType.doubleArg()).then(Commands.argument("min", DoubleArgumentType.doubleArg()).executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							EnderErosionValueReduceRandomCommandProcedure.execute(arguments);
							return 0;
						}))))))).then(Commands.literal("torridity_value")
								.then(Commands.argument("player", EntityArgument.players()).then(Commands.literal("add").then(Commands.argument("torridity_value", DoubleArgumentType.doubleArg()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									TorridityValueAddCommandProcedure.execute(arguments);
									return 0;
								})).then(Commands.literal("random").then(Commands.argument("max", DoubleArgumentType.doubleArg()).then(Commands.argument("min", DoubleArgumentType.doubleArg()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									TorridityValueAddRandomCommandProcedure.execute(arguments);
									return 0;
								}))))).then(Commands.literal("set").then(Commands.argument("torridity_value", DoubleArgumentType.doubleArg()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									TorridityValueSetCommandProcedure.execute(arguments);
									return 0;
								})).then(Commands.literal("random").then(Commands.argument("max", DoubleArgumentType.doubleArg()).then(Commands.argument("min", DoubleArgumentType.doubleArg()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									TorridityValueSetRandomCommandProcedure.execute(arguments);
									return 0;
								}))))).then(Commands.literal("reduce").then(Commands.argument("torridity_value", DoubleArgumentType.doubleArg()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									TorridityValueReduceCommandProcedure.execute(arguments);
									return 0;
								})).then(Commands.literal("random").then(Commands.argument("max", DoubleArgumentType.doubleArg()).then(Commands.argument("min", DoubleArgumentType.doubleArg()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									TorridityValueReduceRandomCommandProcedure.execute(arguments);
									return 0;
								})))))))
						.then(Commands.literal("broken_value").then(Commands.argument("player", EntityArgument.players()).then(Commands.literal("add").then(Commands.argument("broken_value", DoubleArgumentType.doubleArg()).executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							BrokenValueAddCommandProcedure.execute(arguments);
							return 0;
						})).then(Commands.literal("random").then(Commands.argument("max", DoubleArgumentType.doubleArg()).then(Commands.argument("min", DoubleArgumentType.doubleArg()).executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							BrokenValueAddRandomCommandProcedure.execute(arguments);
							return 0;
						}))))).then(Commands.literal("set").then(Commands.argument("broken_value", DoubleArgumentType.doubleArg()).executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							BrokenValueSetCommandProcedure.execute(arguments);
							return 0;
						})).then(Commands.literal("random").then(Commands.argument("max", DoubleArgumentType.doubleArg()).then(Commands.argument("min", DoubleArgumentType.doubleArg()).executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							BrokenValueSetRandomCommandProcedure.execute(arguments);
							return 0;
						}))))).then(Commands.literal("reduce").then(Commands.argument("broken_value", DoubleArgumentType.doubleArg()).executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							BrokenValueReduceCommandProcedure.execute(arguments);
							return 0;
						})).then(Commands.literal("random").then(Commands.argument("max", DoubleArgumentType.doubleArg()).then(Commands.argument("min", DoubleArgumentType.doubleArg()).executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							BrokenValueReduceRandomCommandProcedure.execute(arguments);
							return 0;
						}))))))))).then(Commands.literal("player_persistent").then(Commands.literal("logic")
								.then(Commands.literal("custom_fov").then(Commands.literal("custom_fov").then(Commands.argument("player", EntityArgument.players()).then(Commands.argument("on_or_off", BoolArgumentType.bool()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									CustomFovProcedure.execute(arguments);
									return 0;
								})))).then(Commands.literal("fov").then(Commands.argument("player", EntityArgument.players()).then(Commands.argument("fov", DoubleArgumentType.doubleArg()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									CustomFovFovProcedure.execute(arguments);
									return 0;
								}))))).then(Commands.literal("custom_camera_angles")
										.then(Commands.literal("custom_camera_angles").then(Commands.argument("player", EntityArgument.players()).then(Commands.argument("on_or_off", BoolArgumentType.bool()).executes(arguments -> {
											ServerLevel world = arguments.getSource().getLevel();
											double x = arguments.getSource().getPosition().x();
											double y = arguments.getSource().getPosition().y();
											double z = arguments.getSource().getPosition().z();
											Entity entity = arguments.getSource().getEntity();
											if (entity == null)
												entity = FakePlayerFactory.getMinecraft(world);
											Direction direction = entity.getDirection();

											CustomCameraAnglesProcedure.execute(arguments);
											return 0;
										})))).then(Commands.literal("custom_camera_angles_yaw").then(Commands.argument("player", EntityArgument.players()).then(Commands.argument("yaw", DoubleArgumentType.doubleArg()).executes(arguments -> {
											ServerLevel world = arguments.getSource().getLevel();
											double x = arguments.getSource().getPosition().x();
											double y = arguments.getSource().getPosition().y();
											double z = arguments.getSource().getPosition().z();
											Entity entity = arguments.getSource().getEntity();
											if (entity == null)
												entity = FakePlayerFactory.getMinecraft(world);
											Direction direction = entity.getDirection();

											CustomCameraAnglesYawProcedure.execute(arguments);
											return 0;
										})))).then(Commands.literal("custom_camera_angles_pitch").then(Commands.argument("player", EntityArgument.players()).then(Commands.argument("pitch", DoubleArgumentType.doubleArg()).executes(arguments -> {
											ServerLevel world = arguments.getSource().getLevel();
											double x = arguments.getSource().getPosition().x();
											double y = arguments.getSource().getPosition().y();
											double z = arguments.getSource().getPosition().z();
											Entity entity = arguments.getSource().getEntity();
											if (entity == null)
												entity = FakePlayerFactory.getMinecraft(world);
											Direction direction = entity.getDirection();

											CustomCameraAnglesPitchProcedure.execute(arguments);
											return 0;
										})))).then(Commands.literal("custom_camera_angles_roll").then(Commands.argument("player", EntityArgument.players()).then(Commands.argument("roll", DoubleArgumentType.doubleArg()).executes(arguments -> {
											ServerLevel world = arguments.getSource().getLevel();
											double x = arguments.getSource().getPosition().x();
											double y = arguments.getSource().getPosition().y();
											double z = arguments.getSource().getPosition().z();
											Entity entity = arguments.getSource().getEntity();
											if (entity == null)
												entity = FakePlayerFactory.getMinecraft(world);
											Direction direction = entity.getDirection();

											CustomCameraAnglesRollProcedure.execute(arguments);
											return 0;
										})))))
								.then(Commands.literal("can_see_custom_fog").then(Commands.argument("player", EntityArgument.players()).then(Commands.argument("on_or_off", BoolArgumentType.bool()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									CanSeeCustomFogProcedure.execute(arguments);
									return 0;
								})))).then(Commands.literal("invincible").then(Commands.argument("player", EntityArgument.players()).then(Commands.argument("on_or_off", BoolArgumentType.bool()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									InvincibleOnOrOffCommandProcedure.execute(arguments);
									return 0;
								})))).then(Commands.literal("fly").then(Commands.argument("player", EntityArgument.players()).then(Commands.argument("on_or_off", BoolArgumentType.bool()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									FlyOnOrOffCommandProcedure.execute(arguments);
									return 0;
								})))).then(Commands.literal("see_abyss").then(Commands.argument("player", EntityArgument.players()).then(Commands.argument("on_or_off", BoolArgumentType.bool()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									SeeAbyssOnOrOffCommandProcedure.execute(arguments);
									return 0;
								}))))))))
				.then(Commands.literal("minecraft").then(Commands.literal("entity")
						.then(Commands.literal("entity").then(Commands.literal("setTarget").then(Commands.argument("entity", EntityArgument.entities()).then(Commands.argument("sourceentity", EntityArgument.entity()).executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							EntitySetTargetCommandProcedure.execute(arguments, entity);
							return 0;
						})).then(Commands.literal("null").executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							EntitySetTargetNullCommandProcedure.execute(arguments);
							return 0;
						})))).then(Commands.literal("damage_source").then(Commands.literal("EntityDamageSource").then(Commands.argument("entity", EntityArgument.entities()).then(Commands.argument("sourceentity", EntityArgument.entity())
								.then(Commands.argument("damage_source", StringArgumentType.string()).then(Commands.literal("null").then(Commands.argument("damage", DoubleArgumentType.doubleArg()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									DamageSourceEntityDamageSourceCommandProcedure.execute(arguments, entity);
									return 0;
								}))).then(Commands.literal("damageHelmet").then(Commands.argument("damage", DoubleArgumentType.doubleArg()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									DamageSourceEntityDamageSourcedamageHelmetCommandProcedure.execute(arguments, entity);
									return 0;
								}))).then(Commands.literal("bypassArmor").then(Commands.argument("damage", DoubleArgumentType.doubleArg()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									DamageSourceEntityDamageSourcebypassArmorCommandProcedure.execute(arguments, entity);
									return 0;
								}))).then(Commands.literal("bypassInvul").then(Commands.argument("damage", DoubleArgumentType.doubleArg()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									DamageSourceEntityDamageSourcebypassInvulCommandProcedure.execute(arguments, entity);
									return 0;
								}))).then(Commands.literal("bypassMagic").then(Commands.argument("damage", DoubleArgumentType.doubleArg()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									DamageSourceEntityDamageSourcebypassMagicCommandProcedure.execute(arguments, entity);
									return 0;
								}))).then(Commands.literal("bypassEnchantments").then(Commands.argument("damage", DoubleArgumentType.doubleArg()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									DamageSourceEntityDamageSourcebypassEnchantmentsCommandProcedure.execute(arguments, entity);
									return 0;
								}))).then(Commands.literal("all").then(Commands.argument("damage", DoubleArgumentType.doubleArg()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									DamageSourceEntityDamageSourceAllCommandProcedure.execute(arguments, entity);
									return 0;
								}))).then(Commands.literal("setThorns").then(Commands.argument("damage", DoubleArgumentType.doubleArg()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									DamageSourceEntityDamageSourceAllCommandProcedure.execute(arguments, entity);
									return 0;
								})))))))).then(Commands.literal("delete").then(Commands.literal("discard").then(Commands.argument("targets", EntityArgument.entities()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									DeleteDiscardProcedure.execute(arguments);
									return 0;
								}))).then(Commands.literal("kill").then(Commands.argument("targets", EntityArgument.entities()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									DeleteKillProcedure.execute(arguments);
									return 0;
								})))).then(Commands.literal("health").then(Commands.argument("targets", EntityArgument.entities()).then(Commands.literal("add").then(Commands.argument("health", DoubleArgumentType.doubleArg()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									HealthAddHealthProcedure.execute(arguments);
									return 0;
								})).then(Commands.literal("NaN").executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									HealthAddNaNProcedure.execute(arguments);
									return 0;
								})).then(Commands.literal("E").executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									HealthAddEProcedure.execute(arguments);
									return 0;
								})).then(Commands.literal("POSITIVE_INFINITY").executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									HealthAddPOSITIVEINFINITYProcedure.execute(arguments);
									return 0;
								})).then(Commands.literal("NEGATIVE_INFINITY").executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									HealthAddNEGATIVEINFINITYProcedure.execute(arguments);
									return 0;
								})).then(Commands.literal("random").then(Commands.argument("max", DoubleArgumentType.doubleArg()).then(Commands.argument("min", DoubleArgumentType.doubleArg()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									HealthAddRandomProcedure.execute(arguments);
									return 0;
								}))))).then(Commands.literal("set").then(Commands.argument("health", DoubleArgumentType.doubleArg()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									HealthSetHealthProcedure.execute(arguments);
									return 0;
								})).then(Commands.literal("NaN").executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									HealthSetNaNProcedure.execute(arguments);
									return 0;
								})).then(Commands.literal("E").executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									HealthSetEProcedure.execute(arguments);
									return 0;
								})).then(Commands.literal("POSITIVE_INFINITY").executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									HealthSetPOSITIVEINFINITYProcedure.execute(arguments);
									return 0;
								})).then(Commands.literal("NEGATIVE_INFINITY").executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									HealthSetNEGATIVEINFINITYProcedure.execute(arguments);
									return 0;
								})).then(Commands.literal("random").then(Commands.argument("max", DoubleArgumentType.doubleArg()).then(Commands.argument("min", DoubleArgumentType.doubleArg()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									HealthSetRandomProcedure.execute(arguments);
									return 0;
								}))))).then(Commands.literal("reduce").then(Commands.argument("health", DoubleArgumentType.doubleArg()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									HealthReduceHealthProcedure.execute(arguments);
									return 0;
								})).then(Commands.literal("NaN").executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									HealthReduceNaNProcedure.execute(arguments);
									return 0;
								})).then(Commands.literal("E").executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									HealthReduceEProcedure.execute(arguments);
									return 0;
								})).then(Commands.literal("POSITIVE_INFINITY").executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									HealthReducePOSITIVEINFINITYProcedure.execute(arguments);
									return 0;
								})).then(Commands.literal("NEGATIVE_INFINITY").executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									HealthReduceNEGATIVEINFINITYProcedure.execute(arguments);
									return 0;
								})).then(Commands.literal("random").then(Commands.argument("max", DoubleArgumentType.doubleArg()).then(Commands.argument("min", DoubleArgumentType.doubleArg()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									HealthReduceRandomProcedure.execute(arguments);
									return 0;
								}))))))).then(Commands.literal("fire").then(Commands.argument("targets", EntityArgument.entities()).then(Commands.literal("add").then(Commands.argument("fire", DoubleArgumentType.doubleArg()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									FireAddProcedure.execute(arguments);
									return 0;
								})).then(Commands.literal("random").then(Commands.argument("max", DoubleArgumentType.doubleArg()).then(Commands.argument("min", DoubleArgumentType.doubleArg()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									FireAddRandomProcedure.execute(arguments);
									return 0;
								}))))).then(Commands.literal("set").then(Commands.argument("fire", DoubleArgumentType.doubleArg()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									FireSetProcedure.execute(arguments);
									return 0;
								})).then(Commands.literal("random").then(Commands.argument("max", DoubleArgumentType.doubleArg()).then(Commands.argument("min", DoubleArgumentType.doubleArg()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									FireSetRandomProcedure.execute(arguments);
									return 0;
								}))))).then(Commands.literal("reduce").then(Commands.argument("fire", DoubleArgumentType.doubleArg()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									FireReduceProcedure.execute(arguments);
									return 0;
								})).then(Commands.literal("random").then(Commands.argument("max", DoubleArgumentType.doubleArg()).then(Commands.argument("min", DoubleArgumentType.doubleArg()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									FireReduceRandomProcedure.execute(arguments);
									return 0;
								}))))).then(Commands.literal("clear").executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									FireClearProcedure.execute(arguments);
									return 0;
								}))))
								.then(Commands.literal("air_supply").then(Commands.argument("targets", EntityArgument.entities()).then(Commands.literal("add").then(Commands.argument("airsupply", DoubleArgumentType.doubleArg()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									AirsupplyAddProcedure.execute(arguments);
									return 0;
								})).then(Commands.literal("random").then(Commands.argument("max", DoubleArgumentType.doubleArg()).then(Commands.argument("min", DoubleArgumentType.doubleArg()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									AirsupplyAddRandomProcedure.execute(arguments);
									return 0;
								}))))).then(Commands.literal("set").then(Commands.argument("airsupply", DoubleArgumentType.doubleArg()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									AirsupplySetProcedure.execute(arguments);
									return 0;
								})).then(Commands.literal("random").then(Commands.argument("max", DoubleArgumentType.doubleArg()).then(Commands.argument("min", DoubleArgumentType.doubleArg()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									AirsupplySetRandomProcedure.execute(arguments);
									return 0;
								}))))).then(Commands.literal("reduce").then(Commands.argument("airsupply", DoubleArgumentType.doubleArg()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									AirsupplyReduceProcedure.execute(arguments);
									return 0;
								})).then(Commands.literal("random").then(Commands.argument("max", DoubleArgumentType.doubleArg()).then(Commands.argument("min", DoubleArgumentType.doubleArg()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									AirsupplyReduceRandomProcedure.execute(arguments);
									return 0;
								}))))))).then(Commands.literal("start_riding").then(Commands.literal("start")
										.then(Commands.argument("sourceentity", EntityArgument.entity()).then(Commands.argument("entity", EntityArgument.entity()).then(Commands.argument("boolean", BoolArgumentType.bool()).executes(arguments -> {
											ServerLevel world = arguments.getSource().getLevel();
											double x = arguments.getSource().getPosition().x();
											double y = arguments.getSource().getPosition().y();
											double z = arguments.getSource().getPosition().z();
											Entity entity = arguments.getSource().getEntity();
											if (entity == null)
												entity = FakePlayerFactory.getMinecraft(world);
											Direction direction = entity.getDirection();

											StartridingStartProcedure.execute(arguments);
											return 0;
										}))))).then(Commands.literal("stop").then(Commands.argument("sourceentity", EntityArgument.entity()).executes(arguments -> {
											ServerLevel world = arguments.getSource().getLevel();
											double x = arguments.getSource().getPosition().x();
											double y = arguments.getSource().getPosition().y();
											double z = arguments.getSource().getPosition().z();
											Entity entity = arguments.getSource().getEntity();
											if (entity == null)
												entity = FakePlayerFactory.getMinecraft(world);
											Direction direction = entity.getDirection();

											StartridingStopProcedure.execute(arguments, entity);
											return 0;
										}))))
								.then(Commands.literal("set_no_gravity").then(Commands.argument("targets", EntityArgument.entities()).then(Commands.argument("nogravity", BoolArgumentType.bool()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									SetNoGravityProcedure.execute(arguments);
									return 0;
								})))).then(Commands.literal("rotation").then(
										Commands.argument("targets", EntityArgument.entities()).then(Commands.argument("YRot", DoubleArgumentType.doubleArg()).then(Commands.argument("XRot", DoubleArgumentType.doubleArg()).executes(arguments -> {
											ServerLevel world = arguments.getSource().getLevel();
											double x = arguments.getSource().getPosition().x();
											double y = arguments.getSource().getPosition().y();
											double z = arguments.getSource().getPosition().z();
											Entity entity = arguments.getSource().getEntity();
											if (entity == null)
												entity = FakePlayerFactory.getMinecraft(world);
											Direction direction = entity.getDirection();

											RotationCommandProcedure.execute(arguments);
											return 0;
										})))))
								.then(Commands.literal("delta_movement").then(Commands.argument("targets", EntityArgument.entities()).then(Commands.literal("getLookAngle").then(Commands.literal("add")
										.then(Commands.argument("vx", DoubleArgumentType.doubleArg()).then(Commands.argument("vy", DoubleArgumentType.doubleArg()).then(Commands.argument("vz", DoubleArgumentType.doubleArg()).executes(arguments -> {
											ServerLevel world = arguments.getSource().getLevel();
											double x = arguments.getSource().getPosition().x();
											double y = arguments.getSource().getPosition().y();
											double z = arguments.getSource().getPosition().z();
											Entity entity = arguments.getSource().getEntity();
											if (entity == null)
												entity = FakePlayerFactory.getMinecraft(world);
											Direction direction = entity.getDirection();

											DeltaMovementGetLookAngleAddProcedure.execute(arguments);
											return 0;
										}))))
										.then(Commands.literal("random")
												.then(Commands.argument("vxMax", DoubleArgumentType.doubleArg())
														.then(Commands.argument("vxMin", DoubleArgumentType.doubleArg()).then(Commands.argument("vyMax", DoubleArgumentType.doubleArg()).then(Commands.argument("vyMin", DoubleArgumentType.doubleArg())
																.then(Commands.argument("vzMax", DoubleArgumentType.doubleArg()).then(Commands.argument("vzMin", DoubleArgumentType.doubleArg()).executes(arguments -> {
																	ServerLevel world = arguments.getSource().getLevel();
																	double x = arguments.getSource().getPosition().x();
																	double y = arguments.getSource().getPosition().y();
																	double z = arguments.getSource().getPosition().z();
																	Entity entity = arguments.getSource().getEntity();
																	if (entity == null)
																		entity = FakePlayerFactory.getMinecraft(world);
																	Direction direction = entity.getDirection();

																	DeltaMovementLookAngleAddRandomProcedure.execute(arguments);
																	return 0;
																})))))))))
										.then(Commands.literal("set").then(
												Commands.argument("vx", DoubleArgumentType.doubleArg()).then(Commands.argument("vy", DoubleArgumentType.doubleArg()).then(Commands.argument("vz", DoubleArgumentType.doubleArg()).executes(arguments -> {
													ServerLevel world = arguments.getSource().getLevel();
													double x = arguments.getSource().getPosition().x();
													double y = arguments.getSource().getPosition().y();
													double z = arguments.getSource().getPosition().z();
													Entity entity = arguments.getSource().getEntity();
													if (entity == null)
														entity = FakePlayerFactory.getMinecraft(world);
													Direction direction = entity.getDirection();

													DeltaMovementLookAngleSetProcedure.execute(arguments);
													return 0;
												}))))
												.then(Commands.literal("random")
														.then(Commands.argument("vxMax", DoubleArgumentType.doubleArg()).then(
																Commands.argument("vxMin", DoubleArgumentType.doubleArg()).then(Commands.argument("vyMax", DoubleArgumentType.doubleArg()).then(Commands.argument("vyMin", DoubleArgumentType.doubleArg())
																		.then(Commands.argument("vzMax", DoubleArgumentType.doubleArg()).then(Commands.argument("vzMin", DoubleArgumentType.doubleArg()).executes(arguments -> {
																			ServerLevel world = arguments.getSource().getLevel();
																			double x = arguments.getSource().getPosition().x();
																			double y = arguments.getSource().getPosition().y();
																			double z = arguments.getSource().getPosition().z();
																			Entity entity = arguments.getSource().getEntity();
																			if (entity == null)
																				entity = FakePlayerFactory.getMinecraft(world);
																			Direction direction = entity.getDirection();

																			DeltaMovementLookAngleSetRandomProcedure.execute(arguments);
																			return 0;
																		})))))))))
										.then(Commands.literal("reduce").then(
												Commands.argument("vx", DoubleArgumentType.doubleArg()).then(Commands.argument("vy", DoubleArgumentType.doubleArg()).then(Commands.argument("vz", DoubleArgumentType.doubleArg()).executes(arguments -> {
													ServerLevel world = arguments.getSource().getLevel();
													double x = arguments.getSource().getPosition().x();
													double y = arguments.getSource().getPosition().y();
													double z = arguments.getSource().getPosition().z();
													Entity entity = arguments.getSource().getEntity();
													if (entity == null)
														entity = FakePlayerFactory.getMinecraft(world);
													Direction direction = entity.getDirection();

													DeltaMovementLookAngleReduceProcedure.execute(arguments);
													return 0;
												}))))
												.then(Commands.literal("random")
														.then(Commands.argument("vxMax", DoubleArgumentType.doubleArg()).then(
																Commands.argument("vxMin", DoubleArgumentType.doubleArg()).then(Commands.argument("vyMax", DoubleArgumentType.doubleArg()).then(Commands.argument("vyMin", DoubleArgumentType.doubleArg())
																		.then(Commands.argument("vzMax", DoubleArgumentType.doubleArg()).then(Commands.argument("vzMin", DoubleArgumentType.doubleArg()).executes(arguments -> {
																			ServerLevel world = arguments.getSource().getLevel();
																			double x = arguments.getSource().getPosition().x();
																			double y = arguments.getSource().getPosition().y();
																			double z = arguments.getSource().getPosition().z();
																			Entity entity = arguments.getSource().getEntity();
																			if (entity == null)
																				entity = FakePlayerFactory.getMinecraft(world);
																			Direction direction = entity.getDirection();

																			DeltaMovementLookAngleReduceRandomProcedure.execute(arguments);
																			return 0;
																		}))))))))))
										.then(Commands.literal("getDeltaMovement").then(Commands.literal("add").then(
												Commands.argument("vx", DoubleArgumentType.doubleArg()).then(Commands.argument("vy", DoubleArgumentType.doubleArg()).then(Commands.argument("vz", DoubleArgumentType.doubleArg()).executes(arguments -> {
													ServerLevel world = arguments.getSource().getLevel();
													double x = arguments.getSource().getPosition().x();
													double y = arguments.getSource().getPosition().y();
													double z = arguments.getSource().getPosition().z();
													Entity entity = arguments.getSource().getEntity();
													if (entity == null)
														entity = FakePlayerFactory.getMinecraft(world);
													Direction direction = entity.getDirection();

													DeltaMovementAddProcedure.execute(arguments);
													return 0;
												}))))
												.then(Commands.literal("random")
														.then(Commands.argument("vxMax", DoubleArgumentType.doubleArg()).then(
																Commands.argument("vxMin", DoubleArgumentType.doubleArg()).then(Commands.argument("vyMax", DoubleArgumentType.doubleArg()).then(Commands.argument("vyMin", DoubleArgumentType.doubleArg())
																		.then(Commands.argument("vzMax", DoubleArgumentType.doubleArg()).then(Commands.argument("vzMin", DoubleArgumentType.doubleArg()).executes(arguments -> {
																			ServerLevel world = arguments.getSource().getLevel();
																			double x = arguments.getSource().getPosition().x();
																			double y = arguments.getSource().getPosition().y();
																			double z = arguments.getSource().getPosition().z();
																			Entity entity = arguments.getSource().getEntity();
																			if (entity == null)
																				entity = FakePlayerFactory.getMinecraft(world);
																			Direction direction = entity.getDirection();

																			DeltaMovementAddRandomProcedure.execute(arguments);
																			return 0;
																		})))))))))
												.then(Commands.literal("set").then(Commands.argument("vx", DoubleArgumentType.doubleArg())
														.then(Commands.argument("vy", DoubleArgumentType.doubleArg()).then(Commands.argument("vz", DoubleArgumentType.doubleArg()).executes(arguments -> {
															ServerLevel world = arguments.getSource().getLevel();
															double x = arguments.getSource().getPosition().x();
															double y = arguments.getSource().getPosition().y();
															double z = arguments.getSource().getPosition().z();
															Entity entity = arguments.getSource().getEntity();
															if (entity == null)
																entity = FakePlayerFactory.getMinecraft(world);
															Direction direction = entity.getDirection();

															DeltaMovementSetProcedure.execute(arguments);
															return 0;
														}))))
														.then(Commands.literal("random")
																.then(Commands.argument("vxMax", DoubleArgumentType.doubleArg())
																		.then(Commands.argument("vxMin", DoubleArgumentType.doubleArg())
																				.then(Commands.argument("vyMax", DoubleArgumentType.doubleArg()).then(Commands.argument("vyMin", DoubleArgumentType.doubleArg())
																						.then(Commands.argument("vzMax", DoubleArgumentType.doubleArg()).then(Commands.argument("vzMin", DoubleArgumentType.doubleArg()).executes(arguments -> {
																							ServerLevel world = arguments.getSource().getLevel();
																							double x = arguments.getSource().getPosition().x();
																							double y = arguments.getSource().getPosition().y();
																							double z = arguments.getSource().getPosition().z();
																							Entity entity = arguments.getSource().getEntity();
																							if (entity == null)
																								entity = FakePlayerFactory.getMinecraft(world);
																							Direction direction = entity.getDirection();

																							DeltaMovementSetRandomProcedure.execute(arguments);
																							return 0;
																						})))))))))
												.then(Commands.literal("reduce").then(Commands.argument("vx", DoubleArgumentType.doubleArg())
														.then(Commands.argument("vy", DoubleArgumentType.doubleArg()).then(Commands.argument("vz", DoubleArgumentType.doubleArg()).executes(arguments -> {
															ServerLevel world = arguments.getSource().getLevel();
															double x = arguments.getSource().getPosition().x();
															double y = arguments.getSource().getPosition().y();
															double z = arguments.getSource().getPosition().z();
															Entity entity = arguments.getSource().getEntity();
															if (entity == null)
																entity = FakePlayerFactory.getMinecraft(world);
															Direction direction = entity.getDirection();

															DeltaMovementReduceProcedure.execute(arguments);
															return 0;
														}))))
														.then(Commands.literal("random")
																.then(Commands.argument("vxMax", DoubleArgumentType.doubleArg())
																		.then(Commands.argument("vxMin", DoubleArgumentType.doubleArg())
																				.then(Commands.argument("vyMax", DoubleArgumentType.doubleArg()).then(Commands.argument("vyMin", DoubleArgumentType.doubleArg())
																						.then(Commands.argument("vzMax", DoubleArgumentType.doubleArg()).then(Commands.argument("vzMin", DoubleArgumentType.doubleArg()).executes(arguments -> {
																							ServerLevel world = arguments.getSource().getLevel();
																							double x = arguments.getSource().getPosition().x();
																							double y = arguments.getSource().getPosition().y();
																							double z = arguments.getSource().getPosition().z();
																							Entity entity = arguments.getSource().getEntity();
																							if (entity == null)
																								entity = FakePlayerFactory.getMinecraft(world);
																							Direction direction = entity.getDirection();

																							DeltaMovementReduceRandomProcedure.execute(arguments);
																							return 0;
																						}))))))))))))
								.then(Commands.literal("heal").then(Commands.argument("targets", EntityArgument.entities()).then(Commands.argument("heal", DoubleArgumentType.doubleArg()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									HealCommandProcedure.execute(arguments);
									return 0;
								})).then(Commands.literal("random").then(Commands.argument("max", DoubleArgumentType.doubleArg()).then(Commands.argument("min", DoubleArgumentType.doubleArg()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									HealRandomCommandProcedure.execute(arguments);
									return 0;
								})))))))
						.then(Commands.literal("player")
								.then(Commands.literal("food_level").then(Commands.argument("player", EntityArgument.players()).then(Commands.literal("add").then(Commands.argument("foodlevel", DoubleArgumentType.doubleArg()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									FoodlevelAddProcedure.execute(arguments);
									return 0;
								})).then(Commands.literal("random").then(Commands.argument("max", DoubleArgumentType.doubleArg()).then(Commands.argument("min", DoubleArgumentType.doubleArg()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									FoodlevelAddRandomProcedure.execute(arguments);
									return 0;
								}))))).then(Commands.literal("set").then(Commands.argument("foodlevel", DoubleArgumentType.doubleArg()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									FoodlevelSetProcedure.execute(arguments);
									return 0;
								})).then(Commands.literal("random").then(Commands.argument("max", DoubleArgumentType.doubleArg()).then(Commands.argument("min", DoubleArgumentType.doubleArg()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									FoodlevelSetRandomProcedure.execute(arguments);
									return 0;
								}))))).then(Commands.literal("reduce").then(Commands.argument("foodlevel", DoubleArgumentType.doubleArg()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									FoodlevelReduceProcedure.execute(arguments);
									return 0;
								})).then(Commands.literal("random").then(Commands.argument("max", DoubleArgumentType.doubleArg()).then(Commands.argument("min", DoubleArgumentType.doubleArg()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									FoodlevelReduceRandomProcedure.execute(arguments);
									return 0;
								})))))))
								.then(Commands.literal("saturation").then(Commands.argument("player", EntityArgument.players()).then(Commands.literal("add").then(Commands.argument("saturation", DoubleArgumentType.doubleArg()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									SaturationAddProcedure.execute(arguments);
									return 0;
								})).then(Commands.literal("random").then(Commands.argument("max", DoubleArgumentType.doubleArg()).then(Commands.argument("min", DoubleArgumentType.doubleArg()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									SaturationAddRandomProcedure.execute(arguments);
									return 0;
								}))))).then(Commands.literal("set").then(Commands.argument("saturation", DoubleArgumentType.doubleArg()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									SaturationSetProcedure.execute(arguments);
									return 0;
								})).then(Commands.literal("random").then(Commands.argument("max", DoubleArgumentType.doubleArg()).then(Commands.argument("min", DoubleArgumentType.doubleArg()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									SaturationSetRandomProcedure.execute(arguments);
									return 0;
								}))))).then(Commands.literal("reduce").then(Commands.argument("saturation", DoubleArgumentType.doubleArg()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									SaturationReduceProcedure.execute(arguments);
									return 0;
								})).then(Commands.literal("random").then(Commands.argument("max", DoubleArgumentType.doubleArg()).then(Commands.argument("min", DoubleArgumentType.doubleArg()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									SaturationReduceRandomProcedure.execute(arguments);
									return 0;
								}))))))).then(Commands.literal("DisplayItemActivation").then(Commands.argument("player", EntityArgument.players()).then(Commands.argument("itemstack", ItemArgument.item(event.getBuildContext())).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									DisplayItemActivationCommandProcedure.execute(world, x, y, z, arguments, entity);
									return 0;
								}))))))
						.then(Commands.literal("world").then(Commands.literal("block_state").then(Commands.argument("pos", BlockPosArgument.blockPos())
								.then(Commands.literal("Boolean").then(Commands.argument("block_state", StringArgumentType.string()).then(Commands.argument("true_or_false", BoolArgumentType.bool()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									BlockStateBooleanCommandProcedure.execute(world, arguments);
									return 0;
								})))).then(Commands.literal("Integer").then(Commands.argument("block_state", StringArgumentType.string()).then(Commands.argument("number", DoubleArgumentType.doubleArg()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									BlockStateIntegerCommandProcedure.execute(world, arguments);
									return 0;
								})).then(Commands.literal("random").then(Commands.argument("max", DoubleArgumentType.doubleArg()).then(Commands.argument("min", DoubleArgumentType.doubleArg()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									BlockStateIntegerRandomCommandProcedure.execute(world, arguments);
									return 0;
								})))))).then(Commands.literal("Enum").then(Commands.argument("block_state", StringArgumentType.string()).then(Commands.argument("enum", StringArgumentType.string()).executes(arguments -> {
									ServerLevel world = arguments.getSource().getLevel();
									double x = arguments.getSource().getPosition().x();
									double y = arguments.getSource().getPosition().y();
									double z = arguments.getSource().getPosition().z();
									Entity entity = arguments.getSource().getEntity();
									if (entity == null)
										entity = FakePlayerFactory.getMinecraft(world);
									Direction direction = entity.getDirection();

									BlockStateEnumCommandProcedure.execute(world, arguments);
									return 0;
								})))))).then(Commands.literal("spawn").then(Commands.literal("explosion").then(Commands.argument("targets", EntityArgument.entity()).then(Commands.argument("pos", BlockPosArgument.blockPos())
										.then(Commands.argument("level", DoubleArgumentType.doubleArg()).then(Commands.argument("fire", BoolArgumentType.bool()).then(Commands.literal("break").executes(arguments -> {
											ServerLevel world = arguments.getSource().getLevel();
											double x = arguments.getSource().getPosition().x();
											double y = arguments.getSource().getPosition().y();
											double z = arguments.getSource().getPosition().z();
											Entity entity = arguments.getSource().getEntity();
											if (entity == null)
												entity = FakePlayerFactory.getMinecraft(world);
											Direction direction = entity.getDirection();

											ExplosionBreakProcedure.execute(world, arguments);
											return 0;
										})).then(Commands.literal("destroy").executes(arguments -> {
											ServerLevel world = arguments.getSource().getLevel();
											double x = arguments.getSource().getPosition().x();
											double y = arguments.getSource().getPosition().y();
											double z = arguments.getSource().getPosition().z();
											Entity entity = arguments.getSource().getEntity();
											if (entity == null)
												entity = FakePlayerFactory.getMinecraft(world);
											Direction direction = entity.getDirection();

											ExplosionDestroyProcedure.execute(world, arguments);
											return 0;
										})).then(Commands.literal("none").executes(arguments -> {
											ServerLevel world = arguments.getSource().getLevel();
											double x = arguments.getSource().getPosition().x();
											double y = arguments.getSource().getPosition().y();
											double z = arguments.getSource().getPosition().z();
											Entity entity = arguments.getSource().getEntity();
											if (entity == null)
												entity = FakePlayerFactory.getMinecraft(world);
											Direction direction = entity.getDirection();

											ExplosionNoneProcedure.execute(world, arguments);
											return 0;
										})))).then(Commands.literal("random").then(Commands.argument("max", DoubleArgumentType.doubleArg())
												.then(Commands.argument("min", DoubleArgumentType.doubleArg()).then(Commands.argument("fire", BoolArgumentType.bool()).then(Commands.literal("break").executes(arguments -> {
													ServerLevel world = arguments.getSource().getLevel();
													double x = arguments.getSource().getPosition().x();
													double y = arguments.getSource().getPosition().y();
													double z = arguments.getSource().getPosition().z();
													Entity entity = arguments.getSource().getEntity();
													if (entity == null)
														entity = FakePlayerFactory.getMinecraft(world);
													Direction direction = entity.getDirection();

													ExplosionBreakRandomProcedure.execute(world, arguments);
													return 0;
												})).then(Commands.literal("destroy").executes(arguments -> {
													ServerLevel world = arguments.getSource().getLevel();
													double x = arguments.getSource().getPosition().x();
													double y = arguments.getSource().getPosition().y();
													double z = arguments.getSource().getPosition().z();
													Entity entity = arguments.getSource().getEntity();
													if (entity == null)
														entity = FakePlayerFactory.getMinecraft(world);
													Direction direction = entity.getDirection();

													ExplosionDestroyRandomProcedure.execute(world, arguments);
													return 0;
												})).then(Commands.literal("none").executes(arguments -> {
													ServerLevel world = arguments.getSource().getLevel();
													double x = arguments.getSource().getPosition().x();
													double y = arguments.getSource().getPosition().y();
													double z = arguments.getSource().getPosition().z();
													Entity entity = arguments.getSource().getEntity();
													if (entity == null)
														entity = FakePlayerFactory.getMinecraft(world);
													Direction direction = entity.getDirection();

													ExplosionNoneRandomProcedure.execute(world, arguments);
													return 0;
												}))))))))
										.then(Commands.literal("null").then(Commands.argument("pos", BlockPosArgument.blockPos())
												.then(Commands.argument("level", DoubleArgumentType.doubleArg()).then(Commands.argument("fire", BoolArgumentType.bool()).then(Commands.literal("break").executes(arguments -> {
													ServerLevel world = arguments.getSource().getLevel();
													double x = arguments.getSource().getPosition().x();
													double y = arguments.getSource().getPosition().y();
													double z = arguments.getSource().getPosition().z();
													Entity entity = arguments.getSource().getEntity();
													if (entity == null)
														entity = FakePlayerFactory.getMinecraft(world);
													Direction direction = entity.getDirection();

													ExplosionBreakNullProcedure.execute(world, arguments);
													return 0;
												})).then(Commands.literal("destroy").executes(arguments -> {
													ServerLevel world = arguments.getSource().getLevel();
													double x = arguments.getSource().getPosition().x();
													double y = arguments.getSource().getPosition().y();
													double z = arguments.getSource().getPosition().z();
													Entity entity = arguments.getSource().getEntity();
													if (entity == null)
														entity = FakePlayerFactory.getMinecraft(world);
													Direction direction = entity.getDirection();

													ExplosionDestroyNullProcedure.execute(world, arguments);
													return 0;
												})).then(Commands.literal("none").executes(arguments -> {
													ServerLevel world = arguments.getSource().getLevel();
													double x = arguments.getSource().getPosition().x();
													double y = arguments.getSource().getPosition().y();
													double z = arguments.getSource().getPosition().z();
													Entity entity = arguments.getSource().getEntity();
													if (entity == null)
														entity = FakePlayerFactory.getMinecraft(world);
													Direction direction = entity.getDirection();

													ExplosionNoneNullProcedure.execute(world, arguments);
													return 0;
												})))).then(Commands.literal("random").then(Commands.argument("max", DoubleArgumentType.doubleArg())
														.then(Commands.argument("min", DoubleArgumentType.doubleArg()).then(Commands.argument("fire", BoolArgumentType.bool()).then(Commands.literal("break").executes(arguments -> {
															ServerLevel world = arguments.getSource().getLevel();
															double x = arguments.getSource().getPosition().x();
															double y = arguments.getSource().getPosition().y();
															double z = arguments.getSource().getPosition().z();
															Entity entity = arguments.getSource().getEntity();
															if (entity == null)
																entity = FakePlayerFactory.getMinecraft(world);
															Direction direction = entity.getDirection();

															ExplosionBreakRandomNullProcedure.execute(world, arguments);
															return 0;
														})).then(Commands.literal("destroy").executes(arguments -> {
															ServerLevel world = arguments.getSource().getLevel();
															double x = arguments.getSource().getPosition().x();
															double y = arguments.getSource().getPosition().y();
															double z = arguments.getSource().getPosition().z();
															Entity entity = arguments.getSource().getEntity();
															if (entity == null)
																entity = FakePlayerFactory.getMinecraft(world);
															Direction direction = entity.getDirection();

															ExplosionDestroyRandomNullProcedure.execute(world, arguments);
															return 0;
														})).then(Commands.literal("none").executes(arguments -> {
															ServerLevel world = arguments.getSource().getLevel();
															double x = arguments.getSource().getPosition().x();
															double y = arguments.getSource().getPosition().y();
															double z = arguments.getSource().getPosition().z();
															Entity entity = arguments.getSource().getEntity();
															if (entity == null)
																entity = FakePlayerFactory.getMinecraft(world);
															Direction direction = entity.getDirection();

															ExplosionNoneRandomNullProcedure.execute(world, arguments);
															return 0;
														})))))))))
										.then(Commands.literal("lightningbolt").then(Commands.argument("pos", BlockPosArgument.blockPos()).then(Commands.argument("setVisualOnly", BoolArgumentType.bool()).executes(arguments -> {
											ServerLevel world = arguments.getSource().getLevel();
											double x = arguments.getSource().getPosition().x();
											double y = arguments.getSource().getPosition().y();
											double z = arguments.getSource().getPosition().z();
											Entity entity = arguments.getSource().getEntity();
											if (entity == null)
												entity = FakePlayerFactory.getMinecraft(world);
											Direction direction = entity.getDirection();

											LightningboltSpawnProcedure.execute(world, arguments);
											return 0;
										}))))
										.then(Commands.literal("item").then(
												Commands.argument("pos", BlockPosArgument.blockPos()).then(Commands.argument("item", ItemArgument.item(event.getBuildContext())).then(Commands.argument("PickUpDelay", DoubleArgumentType.doubleArg())
														.then(Commands.argument("setUnlimitedLifetime", BoolArgumentType.bool()).then(Commands.argument("times", DoubleArgumentType.doubleArg()).executes(arguments -> {
															ServerLevel world = arguments.getSource().getLevel();
															double x = arguments.getSource().getPosition().x();
															double y = arguments.getSource().getPosition().y();
															double z = arguments.getSource().getPosition().z();
															Entity entity = arguments.getSource().getEntity();
															if (entity == null)
																entity = FakePlayerFactory.getMinecraft(world);
															Direction direction = entity.getDirection();

															SpawnItemProcedure.execute(world, arguments);
															return 0;
														})))))))
										.then(Commands.literal("falling_block").then(Commands.argument("block", BlockStateArgument.block(event.getBuildContext()))
												.then(Commands.argument("pos", BlockPosArgument.blockPos()).then(Commands.argument("times", DoubleArgumentType.doubleArg()).executes(arguments -> {
													ServerLevel world = arguments.getSource().getLevel();
													double x = arguments.getSource().getPosition().x();
													double y = arguments.getSource().getPosition().y();
													double z = arguments.getSource().getPosition().z();
													Entity entity = arguments.getSource().getEntity();
													if (entity == null)
														entity = FakePlayerFactory.getMinecraft(world);
													Direction direction = entity.getDirection();

													FallingBlockSpawnProcedure.execute(world, arguments);
													return 0;
												}))))))
								.then(Commands.literal("setBlock").then(Commands.argument("pos", BlockPosArgument.blockPos())
										.then(Commands.argument("block", BlockStateArgument.block(event.getBuildContext())).then(Commands.argument("type", DoubleArgumentType.doubleArg()).executes(arguments -> {
											ServerLevel world = arguments.getSource().getLevel();
											double x = arguments.getSource().getPosition().x();
											double y = arguments.getSource().getPosition().y();
											double z = arguments.getSource().getPosition().z();
											Entity entity = arguments.getSource().getEntity();
											if (entity == null)
												entity = FakePlayerFactory.getMinecraft(world);
											Direction direction = entity.getDirection();

											SetBlockCommandProcedure.execute(world, arguments);
											return 0;
										})))))))
				.then(Commands.literal("java").then(Commands.literal("error").then(Commands.literal("StackOverflowError").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					StackOverflowErrorCommandProcedure.execute();
					return 0;
				}))).then(Commands.literal("setPriority").then(Commands.argument("priority", DoubleArgumentType.doubleArg()).executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					SetPriorityCommandProcedure.execute(arguments, entity);
					return 0;
				}))).then(Commands.literal("sleep").then(Commands.literal("millisecond").then(Commands.argument("millisecond", DoubleArgumentType.doubleArg()).executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					SleepMillisecondProcedure.execute(arguments, entity);
					return 0;
				}))).then(Commands.literal("millisecond_and_nanosecond").then(Commands.argument("millisecond", DoubleArgumentType.doubleArg()).then(Commands.argument("nanosecond", DoubleArgumentType.doubleArg()).executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					SleepMillisecondAndNanosecondProcedure.execute(arguments, entity);
					return 0;
				}))))).then(Commands.literal("Runtime").then(Commands.literal("getRuntime").then(Commands.literal("exec").then(Commands.literal("String_command").then(Commands.argument("command", StringArgumentType.string()).executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					RuntimeGetRuntimeExecStringCommandCommandProcedure.execute(arguments, entity);
					return 0;
				}))).then(Commands.literal("String_cmdArray")
						.then(Commands.argument("exe", StringArgumentType.string()).then(Commands.argument("dir", StringArgumentType.string()).then(Commands.argument("command", StringArgumentType.string()).executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							RuntimeGetRuntimeExecStringCmdArrayCommandProcedure.execute(arguments, entity);
							return 0;
						}))))))))
						.then(Commands.literal("File").then(Commands.literal("setLastModified").then(Commands.argument("file", StringArgumentType.string()).then(Commands.argument("LastModified", DoubleArgumentType.doubleArg()).executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							FileSetLastModifiedCommandProcedure.execute(arguments);
							return 0;
						})))).then(Commands.literal("write").then(Commands.literal("replace").then(Commands.argument("file", StringArgumentType.string()).then(Commands.argument("text", StringArgumentType.string()).executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							FileWriteReplaceFileCommandProcedure.execute(arguments);
							return 0;
						})))).then(Commands.literal("write").then(Commands.argument("file", StringArgumentType.string()).then(Commands.argument("text", StringArgumentType.string()).then(Commands.literal("r").executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							FileWriteFileRCommandProcedure.execute(arguments);
							return 0;
						})).then(Commands.literal("n").executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							FileWriteFileNCommandProcedure.execute(arguments);
							return 0;
						})).then(Commands.literal("null").executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							FileWriteFileCommandProcedure.execute(arguments);
							return 0;
						})))))).then(Commands.literal("create").then(Commands.literal("file").then(Commands.argument("file", StringArgumentType.string()).executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							FileCreateFileCommandProcedure.execute(arguments);
							return 0;
						}))).then(Commands.literal("dir").then(Commands.argument("dir", StringArgumentType.string()).executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							FileCreateDirCommandProcedure.execute(arguments);
							return 0;
						})))).then(Commands.literal("delete").then(Commands.argument("file", StringArgumentType.string()).executes(arguments -> {
							ServerLevel world = arguments.getSource().getLevel();
							double x = arguments.getSource().getPosition().x();
							double y = arguments.getSource().getPosition().y();
							double z = arguments.getSource().getPosition().z();
							Entity entity = arguments.getSource().getEntity();
							if (entity == null)
								entity = FakePlayerFactory.getMinecraft(world);
							Direction direction = entity.getDirection();

							FileDeleteFileCommandProcedure.execute(arguments);
							return 0;
						}))))));
	}
}
