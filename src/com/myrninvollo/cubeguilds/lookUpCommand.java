package com.Myrninvollo.cubeguilds;

import org.glydar.paraglydar.command.Command;
import org.glydar.paraglydar.command.CommandOutcome;
import org.glydar.paraglydar.command.CommandSender;
import org.glydar.paraglydar.command.CommandSet;
import org.glydar.paraglydar.models.Player;
import org.glydar.paraglydar.permissions.Permission.PermissionDefault;



public class lookUpCommand implements CommandSet {
	Main Cg;
	public lookUpCommand(Main cg){
		this.Cg = cg;
	}

	//public boolean onCommand(CommandSender sender, Command cmd, String label,
			//String[] args) {
	@Command(name = "lookup", usage = "- playername", permission = "guild.use", permissionDefault = PermissionDefault.TRUE)
	public CommandOutcome execute(CommandSender sender, String[] args) {
		Player p = (Player)sender;
		if (args.length != 1){
			p.sendMessage("Improper usage! Please use /lookup {Player name}");
			return CommandOutcome.SUCCESS;
		}
		if (Util.getPlayer(args[0]) == null){
			p.sendMessage("This player could not be found");
			return CommandOutcome.SUCCESS;
		}
		Player player = Util.getPlayer(args[0]);
		//double money = Main.econ.getBalance(player.getName());
		
		
		p.sendMessage("Player Lookup: " + player.getName());
		if (this.Cg.config.contains(player.getName())){
			String guild = this.Cg.config.getString(player.getName() + ".Guild.Name");
			p.sendMessage("Player Lookup: Guild - " + guild);
		}
		
		//p.sendMessage("§APlayer Lookup: §2Money - " + money);
		return CommandOutcome.SUCCESS;
		
	}

}
