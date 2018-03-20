package leo.extinguish;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import scala.actors.threadpool.Arrays;

public class CommandExtinguish extends CommandBase {
	@Override
	public String getName() {
		return "extinguish";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "commands.extinguish.usage";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		World world = sender.getEntityWorld();
		BlockPos senderPos = sender.getPosition();
		
		int rangeOver2 = ExtinguishConfig.extinguishDefaultRange;
		if (args.length > 0) {
			try {
				rangeOver2 = Integer.parseInt(args[0]) / 2;
			} catch (NumberFormatException e) {
				throw new WrongUsageException("commands.extinguish.usage", new Object[0]);
			}
		}
		
		for (int i = -rangeOver2; i < rangeOver2; i++) {
			for (int j = -rangeOver2; j < rangeOver2; j++) {
				for (int k = -rangeOver2; k < rangeOver2; k++) {
					BlockPos pos = new BlockPos(i + senderPos.getX(), j + senderPos.getY(), k + senderPos.getZ());
					
					if (Arrays.asList(ExtinguishConfig.fireBlocks).contains(world.getBlockState(pos).getBlock().getRegistryName().toString())) {
						world.setBlockToAir(pos);
					}
				}
			}
		}
	}
	
	@Override
	public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args,
			BlockPos targetPos) {
		return super.getTabCompletions(server, sender, args, targetPos);
	}
	
	@Override
	public int getRequiredPermissionLevel() {
		return ExtinguishConfig.extinguishCommandPermissionLevel;
	}
}
