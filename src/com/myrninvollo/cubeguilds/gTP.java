package com.Myrninvollo.cubeguilds;

import org.glydar.paraglydar.command.Command;
import org.glydar.paraglydar.command.CommandSender;
import org.glydar.paraglydar.command.CommandSet;
import org.glydar.paraglydar.models.Player;


public class gTP implements CommandSet {
	Main Cg;
	public gTP(Main cg){
		this.Cg = cg;
	}
	/*
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		Player player = (Player) sender;
		if (!(player.hasPermission("guild.teleport"))){
			player.sendMessage("You do not have permission to teleport people on this server!");
			return true;
		}
		if (args.length == 0){
			return false;
		}
		if (this.Cg.config.getBoolean("TP") == false){
			player.sendMessage("Teleporting guild members is disabled on this server!");
			return true;
		}
		if (Util.getPlayer(args[0]) == null){
			player.sendMessage("That player cannot be found");
			return true;
		}
		Player p = Util.getPlayer(args[0]);
		String pi = p.getName();
		
		if (!(this.Cg.config.contains(pi))){
			player.sendMessage("This player is not even in a guild!");
			return true;
		}
		if (!(this.Cg.config.contains(player.getName()))){
			player.sendMessage("You are not even in a guild? how can you invite someone?");
			return true;
		}
		String guildn = this.Cg.config.getString(player.getName() + ".Guild.Name");
		String guildn1 = this.Cg.config.getString(pi + ".Guild.Name");
		String grank = this.Cg.config.getString("Guilds." + guildn + ".Players." + player.getName() + ".Rank");
		if (this.Cg.config.getBoolean("Guilds." + guildn + ".Ranks." + grank + ".TP") == false){
			player.sendMessage("You do not have permission to teleport people in this guild!");
			return true;
		}
		if (!(guildn.equalsIgnoreCase(guildn1))){
			player.sendMessage("This player is not in your guild, you can only teleport members of your own guild!");
			return true;
		}
		//this.Cg.teleport(player, p);
		return true;
	}
	*/
}
