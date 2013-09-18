package com.Myrninvollo.cubeguilds;

import java.util.ArrayList;

import org.glydar.paraglydar.command.Command;
import org.glydar.paraglydar.command.CommandOutcome;
import org.glydar.paraglydar.command.CommandSender;
import org.glydar.paraglydar.command.CommandSet;
import org.glydar.paraglydar.models.Player;
import org.glydar.paraglydar.permissions.Permission.PermissionDefault;



public class gRankHandler implements CommandSet {
	Main Cg;
	public gRankHandler(Main cg){
		this.Cg = cg;
	}

	//public boolean onCommand(CommandSender sender, Command cmd, String label,
			//String[] args) {
	@Command(name = "grank", usage = "- create, delete, set, title, perms, list, defaults", permission = "guild.use", permissionDefault = PermissionDefault.TRUE)
	public CommandOutcome execute(CommandSender sender, String[] args) {
		
		if (args.length <= 0){
			return CommandOutcome.SUCCESS;
		}
		if (args[0].equalsIgnoreCase("create")){
			Player player = (Player) sender;
			if (args.length != 3){
				player.sendMessage("Improper usage! Please use /grank create rank title");
				return CommandOutcome.SUCCESS;
			}
			String guildn = this.Cg.config.getString(player.getName() + ".Guild.Name");
			String grank = this.Cg.config.getString("Guilds." + guildn + ".Players." + player.getName() + ".Rank");
			if (!(this.Cg.config.contains(player.getName()))){
				player.sendMessage("You are not even in a guild? how can you expect to create a rank one?");
				return CommandOutcome.SUCCESS;
			}
			if (this.Cg.config.getBoolean("Guilds." + guildn + ".Ranks." + grank + ".CreateRank") == false){
				player.sendMessage("You do not have permission to create a rank in this guild!");
				return CommandOutcome.SUCCESS;
			}
			if (this.Cg.config.contains("Guilds." + guildn + ".Ranks." + args[1].replaceAll("_", " "))){
				player.sendMessage("This rank already exists!");
				return CommandOutcome.SUCCESS;
			}
			this.Cg.config.set("Guilds." + guildn + ".Ranks." + args[1].replaceAll("_", " ") + ".Title", args[2].replaceAll("_", " ").replaceAll("&", "§"));
			this.Cg.config.set("Guilds." + guildn + ".Ranks." + args[1].replaceAll("_", " ") + ".Invite", false);
			this.Cg.config.set("Guilds." + guildn + ".Ranks." + args[1].replaceAll("_", " ") + ".Kick", false);
			this.Cg.config.set("Guilds." + guildn + ".Ranks." + args[1].replaceAll("_", " ") + ".Gmotd", false);
			this.Cg.config.set("Guilds." + guildn + ".Ranks." + args[1].replaceAll("_", " ") + ".Disband", false);
			this.Cg.config.set("Guilds." + guildn + ".Ranks." + args[1].replaceAll("_", " ") + ".Gchat", true);
			this.Cg.config.set("Guilds." + guildn + ".Ranks." + args[1].replaceAll("_", " ") + ".Gbank", false);
			this.Cg.config.set("Guilds." + guildn + ".Ranks." + args[1].replaceAll("_", " ") + ".Addslot", false);
			this.Cg.config.set("Guilds." + guildn + ".Ranks." + args[1].replaceAll("_", " ") + ".Withdrawl", false);
			this.Cg.config.set("Guilds." + guildn + ".Ranks." + args[1].replaceAll("_", " ") + ".Deposit", false);
			this.Cg.config.set("Guilds." + guildn + ".Ranks." + args[1].replaceAll("_", " ") + ".GbRanks", false);
			this.Cg.config.set("Guilds." + guildn + ".Ranks." + args[1].replaceAll("_", " ") + ".RankSet", false);
			this.Cg.config.set("Guilds." + guildn + ".Ranks." + args[1].replaceAll("_", " ") + ".RankTitle", false);
			this.Cg.config.set("Guilds." + guildn + ".Ranks." + args[1].replaceAll("_", " ") + ".CreateRank", false);
			this.Cg.config.set("Guilds." + guildn + ".Ranks." + args[1].replaceAll("_", " ") + ".DeleteRank", false);
			this.Cg.config.set("Guilds." + guildn + ".Ranks." + args[1].replaceAll("_", " ") + ".PlayerInfo", false);
			this.Cg.config.set("Guilds." + guildn + ".Ranks." + args[1].replaceAll("_", " ") + ".RankPerms", false);
			this.Cg.config.set("Guilds." + guildn + ".Ranks." + args[1].replaceAll("_", " ") + ".Ochat", false);
			this.Cg.config.set("Guilds." + guildn + ".Ranks." + args[1].replaceAll("_", " ") + ".PlayerNotes", false);
			this.Cg.config.set("Guilds." + guildn + ".Ranks." + args[1].replaceAll("_", " ") + ".PlayerNotesView", false);
			this.Cg.config.set("Guilds." + guildn + ".Ranks." + args[1].replaceAll("_", " ") + ".PlayerNotesSet", false);
			this.Cg.config.set("Guilds." + guildn + ".Ranks." + args[1].replaceAll("_", " ") + ".TP", false);
			this.Cg.saveConfig();
			player.sendMessage("You have successfully created the rank " + args[1].replaceAll("_", " ") + "!");
			return CommandOutcome.SUCCESS;
		}
		if (args[0].equalsIgnoreCase("delete")){
			Player player = (Player) sender;
			if (args.length <=1){
				player.sendMessage("You must include a rank to delete!");
				return CommandOutcome.SUCCESS;
			}
			String guildn = this.Cg.config.getString(player.getName() + ".Guild.Name");
			String grank = this.Cg.config.getString("Guilds." + guildn + ".Players." + player.getName() + ".Rank");
			if (!(this.Cg.config.contains(player.getName()))){
				player.sendMessage("You are not even in a guild? how can you expect to delete a rank?");
				return CommandOutcome.SUCCESS;
			}
			if (this.Cg.config.getBoolean("Guilds." + guildn + ".Ranks." + grank + ".DeleteRank") == false){
				player.sendMessage("You do not have permission to delete a rank in this guild!");
				return CommandOutcome.SUCCESS;
			}
			if (!(this.Cg.config.contains("Guilds." + guildn + ".Ranks." + args[1].replaceAll("_", " ")))){
				player.sendMessage("This rank doesn't exist!");
				return CommandOutcome.SUCCESS;
			}
			String newbies = this.Cg.config.getString("Guilds." + guildn + ".DefTerm.Default");
			for (String key : this.Cg.config.getConfigurationSection("Guilds." + guildn + ".Players").getKeys(false)){
				String rank = this.Cg.config.getString("Guilds." + guildn + ".Players." + key + ".Rank");
				if (args[1].replaceAll("_", " ").equalsIgnoreCase(rank)){
					this.Cg.config.set("Guilds." + guildn + ".Players." + key + ".Rank", newbies);
					if (Util.getPlayer(key) != null){
						Player p = Util.getPlayer(key);
						p.sendMessage(" Your rank has been changed to " + newbies + "!");
					}
				}
			}
			this.Cg.config.set("Guilds." + guildn + ".Ranks." + args[1].replaceAll("_", " "), null);
			this.Cg.saveConfig();
			player.sendMessage("You have successfully deleted the rank " + args[1].replaceAll("_", " ") + "!");
			return CommandOutcome.SUCCESS;
		}
		if (args[0].equalsIgnoreCase("set")){
			Player player = (Player) sender;
			if (args.length != 3){
				player.sendMessage("Improper usage! Please use /grank set playername rank");
				return CommandOutcome.SUCCESS;
			}
			String guildn = this.Cg.config.getString(player.getName() + ".Guild.Name");
			String grank = this.Cg.config.getString("Guilds." + guildn + ".Players." + player.getName() + ".Rank");
			String prank = this.Cg.config.getString("Guilds." + guildn + ".Players." + args[1] + ".Rank");
			
			if (!(this.Cg.config.contains(player.getName()))){
				player.sendMessage("You are not even in a guild? how can you expect to delete a rank?");
				return CommandOutcome.SUCCESS;
			}
			if (this.Cg.config.getBoolean("Guilds." + guildn + ".Ranks." + grank + ".RankSet") == false){
				player.sendMessage("You do not have permission to set a players rank in this guild!");
				return CommandOutcome.SUCCESS;
			}
			if (!(this.Cg.config.contains("Guilds." + guildn + ".Ranks." + args[2].replaceAll("_", " ")))){
				player.sendMessage("This rank doesn't exist!");
				return CommandOutcome.SUCCESS;
			}
			if (!(this.Cg.config.contains("Guilds." + guildn + ".Players." + args[1]))){
				player.sendMessage("That player is not a part of your guild!");
				return CommandOutcome.SUCCESS;
			}
			String leader = this.Cg.config.getString("Guilds." + guildn + ".DefTerm.Leader");
			player.sendMessage("grank = " + grank + "prank = " + prank + "guiln = " + guildn + " leader = " + leader);
			String newbie = this.Cg.config.getString("Guilds." + guildn + ".DefTerm.Default");
			if ((args[2].replaceAll("_", " ").equalsIgnoreCase(leader) && (!(grank.equalsIgnoreCase(leader))))){
				player.sendMessage("You can not promote someone to Guild Leader this way!!");
				return CommandOutcome.SUCCESS;
			}
			if ((args[2].replaceAll("_", " ").equalsIgnoreCase(leader) && (grank.equalsIgnoreCase(leader)))){
				this.Cg.config.set("Guilds." + guildn + ".Players." + args[1] + ".Rank", leader);
				this.Cg.config.set("Guilds." + guildn + ".Players." + player.getName() + ".Rank", newbie);
				this.Cg.config.set("Guilds." + guildn + ".Leader", args[1]);
				this.Cg.saveConfig();
				player.sendMessage("You are no longer the leader of " + guildn + ".");
				for (String key : this.Cg.config.getConfigurationSection("Guilds." + guildn + ".Players").getKeys(false)){
					if (Util.getPlayer(key) != null){
						Player p = Util.getPlayer(key);
						if (!(p.getName().equalsIgnoreCase(args[1]))){
							p.sendMessage(args[1] + " is the new Leader of " + guildn + ".");
						} else {
							p.sendMessage("You are the new Guild leader of " + guildn + "!");
						}
					}
				}
				return CommandOutcome.SUCCESS;
			}
			if (prank.equalsIgnoreCase(grank)){
				player.sendMessage("You can not change someone's rank if their rank is the same as yours!");
				return CommandOutcome.SUCCESS;
			}
			if (args[2].replaceAll("_" , " ").equalsIgnoreCase(grank)){
				player.sendMessage("You can not set someone to the same rank as yours!");
				return CommandOutcome.SUCCESS;
			}

			if (prank.equalsIgnoreCase(leader)){
				player.sendMessage("You cannot change a guild leaders rank in this fashion!");
				return CommandOutcome.SUCCESS;
			}
			for (String key : this.Cg.config.getConfigurationSection("Guilds." + guildn + ".Players").getKeys(false)){
				if (Util.getPlayer(key) != null){
					Player p = Util.getPlayer(key);
					if (!(p.getName().equalsIgnoreCase(args[1]))){
						p.sendMessage(args[1] + " has been changed to the rank " + args[2].replaceAll("_", " ") + ".");
					} else {
						p.sendMessage("You have been moved to the rank " + args[2].replaceAll("_", " ") + ".");
					}
				}
			}
			this.Cg.config.set("Guilds." + guildn + ".Players." + args[1] + ".Rank", args[2].replaceAll("_", " "));

			this.Cg.saveConfig();
			return CommandOutcome.SUCCESS;
		}
		if (args[0].equalsIgnoreCase("title")){
			Player player = (Player) sender;
			if (args.length != 3){
				player.sendMessage("Improper usage! Please use /grank title rankname newtitle");
				return CommandOutcome.SUCCESS;
			}
			String guildn = this.Cg.config.getString(player.getName() + ".Guild.Name");
			String grank = this.Cg.config.getString("Guilds." + guildn + ".Players." + player.getName() + ".Rank");
			if (!(this.Cg.config.contains(player.getName()))){
				player.sendMessage("You are not even in a guild? how can you expect to delete a rank?");
				return CommandOutcome.SUCCESS;
			}
			if (this.Cg.config.getBoolean("Guilds." + guildn + ".Ranks." + grank + ".RankTitle") == false){
				player.sendMessage("You do not have permission to set a rank's Title in this guild!");
				return CommandOutcome.SUCCESS;
			}
			if (!(this.Cg.config.contains("Guilds." + guildn + ".Ranks." + args[1].replaceAll("_", " ")))){
				player.sendMessage("This rank doesn't exist!");
				return CommandOutcome.SUCCESS;
			}
			this.Cg.config.set("Guilds." + guildn + ".Ranks." + args[1].replaceAll("_", " ") + ".Title", args[2].replaceAll("_", " ").replaceAll("&", "§"));
			this.Cg.saveConfig();
			player.sendMessage("You have changed " + args[1].replaceAll("_", " ") + "'s title to " + args[2].replaceAll("_", " ").replaceAll("&", "§") + ".");
			return CommandOutcome.SUCCESS;
		}
		if (args[0].equalsIgnoreCase("perms")){
			Player player = (Player) sender;
			if (args.length != 4){
				player.sendMessage("Improper usage! Please use /grank perms rankname permission_name true/false");
				return CommandOutcome.SUCCESS;
			}
			String guildn = this.Cg.config.getString(player.getName() + ".Guild.Name");
			String grank = this.Cg.config.getString("Guilds." + guildn + ".Players." + player.getName() + ".Rank");
			if (!(this.Cg.config.contains(player.getName()))){
				player.sendMessage("You are not even in a guild? how can you expect to delete a rank?");
				return CommandOutcome.SUCCESS;
			}
			if (this.Cg.config.getBoolean("Guilds." + guildn + ".Ranks." + grank + ".RankPerms") == false){
				player.sendMessage("You do not have permission to set a rank's permissions in this guild!");
				return CommandOutcome.SUCCESS;
			}
			if (!(this.Cg.config.contains("Guilds." + guildn + ".Ranks." + args[1].replaceAll("_", " ")))){
				player.sendMessage("This rank doesn't exist!");
				return CommandOutcome.SUCCESS;
			}
			String leader = this.Cg.config.getString("Guild." + guildn + ".DefTerm.Leader");
			if (args[1].replaceAll("_", " ").equalsIgnoreCase(leader)){
				player.sendMessage("You can not change a guild leaders permissions!");
				return CommandOutcome.SUCCESS;
			}
			if (args[3].equalsIgnoreCase("true")){
				Boolean permbool = true;
				this.Cg.config.set("Guilds." + guildn + ".Ranks." + args[1].replaceAll("_", " ") + "." + args[2].replaceAll("_", " "), permbool);
				this.Cg.saveConfig();
				player.sendMessage("Members with the rank " + args[1].replaceAll("_", " ") + " now have  " + args[2].replaceAll("_", " ") + " permissions.");
				return CommandOutcome.SUCCESS;
			} else {
				Boolean permbool = false;
				this.Cg.config.set("Guilds." + guildn + ".Ranks." + args[1].replaceAll("_", " ") + "." + args[2].replaceAll("_", " "), permbool);
				this.Cg.saveConfig();
				player.sendMessage("Members with the rank " + args[1].replaceAll("_", " ") + " no longer have  " + args[2].replaceAll("_", " ") + " permissions.");
				return CommandOutcome.SUCCESS;
			}

		}
		if (args[0].equalsIgnoreCase("list")){
			Player player = (Player) sender;
			player.sendMessage("The available rank permissions are \nInvite\nKick\nGmotd\nDisband\nGchat\nGbank\nAddslot\nWithdrawl\nDeposit\nGbRanks\nRankSet\nRankTitle\nCreateRank\nDeleteRank\nPlayerInfo\nRankPerms\nOchat\nPlayerNotesView\nPlayerNotesSet\nTitle");
			return CommandOutcome.SUCCESS;
		}
		if (args[0].equalsIgnoreCase("defaults")){
			Player player = (Player) sender;
			
			String guildn = this.Cg.config.getString(player.getName() + ".Guild.Name");
			String grank = this.Cg.config.getString("Guilds." + guildn + ".Players." + player.getName() + ".Rank");
			String leader = this.Cg.config.getString("Guilds." + guildn + ".DefTerm.Leader");
			if (!(grank.equalsIgnoreCase(leader))){
				player.sendMessage("Only a guild leader can change the default rank names!");
				return CommandOutcome.SUCCESS;
			}
			if (args[1].equalsIgnoreCase("leader")){
				this.Cg.config.set("Guilds." + guildn + ".DefTerm.Leader", args[2].replaceAll("&", "§").replaceAll("_", " "));
				this.Cg.saveConfig();
				player.sendMessage("You have changed the leader rank name to " + args[2].replaceAll("&", "§").replaceAll("_", " ") + ".");
				return CommandOutcome.SUCCESS;
			}
			if (args[1].equalsIgnoreCase("newbies")){
				this.Cg.config.set("Guilds." + guildn + ".DefTerm.Default", args[2].replaceAll("&", "§").replaceAll("_", " "));
				this.Cg.saveConfig();
				player.sendMessage("You have changed the default rank name to " + args[2].replaceAll("&", "§").replaceAll("_", " ") + ".");
				return CommandOutcome.SUCCESS;
			}
			player.sendMessage("Improper usage! Please use /grank defaults {leader/newbies} new_rank_name");
			return CommandOutcome.SUCCESS;
		}
		
		
		return CommandOutcome.WRONG_USAGE;
	}
}
