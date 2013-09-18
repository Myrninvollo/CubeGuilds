package com.Myrninvollo.cubeguilds;

import org.glydar.paraglydar.command.Command;
import org.glydar.paraglydar.command.CommandOutcome;
import org.glydar.paraglydar.command.CommandSender;
import org.glydar.paraglydar.command.CommandSet;
import org.glydar.paraglydar.models.Player;
import org.glydar.paraglydar.permissions.Permission.PermissionDefault;


public class gcHandler implements CommandSet {
	Main Cg;
	
	public gcHandler(Main cg){
		this.Cg = cg;
	}
	
	//public boolean onCommand(CommandSender sender, Command cmd, String label,
			//String[] args) {
	@Command(name = "g", usage = "- Guild Chat", permission = "guild.use", permissionDefault = PermissionDefault.TRUE)
	public CommandOutcome execute(CommandSender sender, String[] args) {
		Player player = (Player) sender;
		String guildn = this.Cg.config.getString(player.getName() + ".Guild.Name");
		String grank = this.Cg.config.getString("Guilds." + guildn + ".Players." + player.getName() + ".Rank");
		if (!(this.Cg.config.contains(player.getName()))){
			player.sendMessage("You are not even in a guild? how can you expect to talk in one?");
			return CommandOutcome.SUCCESS;
		}
		if (this.Cg.config.getBoolean("Guilds." + guildn + ".Ranks." + grank + ".Gchat") == false){
			player.sendMessage("You do not have permission to talk in this guild!");
			return CommandOutcome.SUCCESS;
		}
		StringBuilder buffer = new StringBuilder();
		for (int i = 0; i < args.length; i++) {
			buffer.append(' ').append(args[i]);
		}
		String s = buffer.toString();
		
		String title = this.Cg.config.getString("Guilds." + guildn + ".Ranks." + grank + ".Title");
		
		for (String key : this.Cg.config.getConfigurationSection("Guilds." + guildn + ".Players").getKeys(false)){
				if (Util.getPlayer(key) != null){
				Player p = Util.getPlayer(key);
				p.sendMessage("[" + title + "]" + player.getName() + ": " + s);
				}				
		}
		
		return CommandOutcome.SUCCESS;
	}

}
