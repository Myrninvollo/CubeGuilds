package com.Myrninvollo.cubeguilds;

import org.glydar.paraglydar.command.Command;
import org.glydar.paraglydar.command.CommandOutcome;
import org.glydar.paraglydar.command.CommandSender;
import org.glydar.paraglydar.command.CommandSet;
import org.glydar.paraglydar.permissions.Permission.PermissionDefault;



public class gBankHandler implements CommandSet{
	
		Main Cg;
	
	public gBankHandler(Main cg){
		this.Cg = cg;
	}
	/*
	//public boolean onCommand(CommandSender sender, Command cmd, String label,
			//String[] args) {
	@Command(name = "gbank", usage = "- comming soon", permission = "guild.create", permissionDefault = PermissionDefault.TRUE)
	public CommandOutcome execute(CommandSender sender, String[] args) {
		//gbank //add //rank access //withdrawl //deposit
		return CommandOutcome.WRONG_USAGE;
	}
*/
}
