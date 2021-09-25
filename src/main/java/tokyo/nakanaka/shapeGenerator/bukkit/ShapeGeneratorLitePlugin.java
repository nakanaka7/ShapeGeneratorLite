package tokyo.nakanaka.shapeGenerator.bukkit;

import org.bukkit.command.Command;
import org.bukkit.plugin.java.JavaPlugin;
import tokyo.nakanaka.annotation.PublicAPI;
import tokyo.nakanaka.bukkit.BukkitFunctions;
import tokyo.nakanaka.commandSender.CommandSender;
import tokyo.nakanaka.shapeGenerator.MainLite;

import java.util.List;

/**
 * Plugin class of ShapeGeneratorLite
 */
@PublicAPI
public class ShapeGeneratorLitePlugin extends JavaPlugin {
	private MainLite main;
	
	@Override
	public void onEnable() {
		this.main = new MainLite(new BukkitBlockIDListFactory());
	}
	
	@Override
	public boolean onCommand(org.bukkit.command.CommandSender cmdSender0, Command command, String label, String[] args) {
		CommandSender cmdSender = BukkitFunctions.convertCommandSender(cmdSender0);
		this.main.onSgCommand(cmdSender, args);
		return true;
	}
	
	@Override
	public List<String> onTabComplete(org.bukkit.command.CommandSender cmdSender0, Command command, String alias, String[] args){
		CommandSender cmdSender = BukkitFunctions.convertCommandSender(cmdSender0);
		return this.main.onSgTabComplete(cmdSender, args);
	}
	
}
