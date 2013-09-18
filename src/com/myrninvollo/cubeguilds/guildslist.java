package com.Myrninvollo.cubeguilds;

import org.glydar.paraglydar.command.Command;
import org.glydar.paraglydar.command.CommandExecutor;
import org.glydar.paraglydar.command.CommandOutcome;
import org.glydar.paraglydar.command.CommandSender;
import org.glydar.paraglydar.command.CommandSet;
import org.glydar.paraglydar.models.Player;
import org.glydar.paraglydar.permissions.Permission.PermissionDefault;



public class guildslist implements CommandSet {
	Main Cg;
	public guildslist(Main cg){
		this.Cg = cg;
	}

	//public boolean onCommand(CommandSender sender, Command cmd, String label,
			//String[] args) {
	@Command(name = "glist", usage = "- lists guilds on server", permission = "guild.use", permissionDefault = PermissionDefault.TRUE)
	public CommandOutcome execute(CommandSender sender, String[] args) {
		Player player = (Player)sender;
		Integer i = 0;
		for (String guilds : this.Cg.config.getConfigurationSection("Guilds").getKeys(false)){
			i = 0;
			for (String players : this.Cg.config.getConfigurationSection("Guilds." + guilds + ".Players").getKeys(false)){
				if (players != null){
					i++;
				}
				if (i == 1){
					player.sendMessage(" " + guilds + ": " + i + " Player.");
				} else {
					player.sendMessage(" " + guilds + ": " + i + " Players.");
				}

			}
		}
		return CommandOutcome.SUCCESS;
	}
}
