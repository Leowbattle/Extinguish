package leo.extinguish;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CommandExtinguish extends CommandBase {
	@Override
	public String getName() {
		return "extinguish";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		World world = sender.getEntityWorld();
		BlockPos senderPos = sender.getPosition();
		for (int i = -100; i < 100; i++) {
			for (int j = -100; j < 100; j++) {
				for (int k = -100; k < 100; k++) {
					BlockPos pos = new BlockPos(i + senderPos.getX(), j + senderPos.getY(), k + senderPos.getZ());
					
					if (world.getBlockState(pos).getBlock().getUnlocalizedName().contains("fire")) {
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
		return Config.extinguishCommandPermissionLevel;
	}
}
