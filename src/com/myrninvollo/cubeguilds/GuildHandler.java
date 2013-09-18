package com.Myrninvollo.cubeguilds;



import org.glydar.paraglydar.command.Command;
import org.glydar.paraglydar.command.CommandOutcome;
import org.glydar.paraglydar.command.CommandSender;
import org.glydar.paraglydar.command.CommandSet;
import org.glydar.paraglydar.models.Player;
import org.glydar.paraglydar.permissions.Permission.PermissionDefault;

public class GuildHandler implements CommandSet {
	Main Cg;
	public GuildHandler(Main cg){
		this.Cg = cg;
	}
	
	//public boolean onCommand(CommandSender sender, Command cmd, String label,
			//String[] args) {
	@Command(name = "guild", usage = "- create, invite, leave, join, gmotd, kick, disband, tag, accept, deny, quit, list, tp", permission = "guild.use", permissionDefault = PermissionDefault.TRUE)
	public CommandOutcome execute(CommandSender sender, String[] args) {
		Player player = (Player) sender;
		if (args.length == 0){
			return CommandOutcome.WRONG_USAGE;
		}
		/* dissabled untill permisiions are a viald option
		if (!(player.hasPermission("guild.create"))){
			player.sendMessage("You do not have permission to use this command!");
			return CommandOutcome.SUCCESS;
		}
		*/
		if (args[0].equalsIgnoreCase("create")){
			if (args.length != 3){
				player.sendMessage("Please use /guild create guildname tag");
				return CommandOutcome.SUCCESS;
			}
			if (args[2].length() != 4){
				player.sendMessage("Guild tags must be 4 letters!");
				return CommandOutcome.SUCCESS;
			}
			if (this.Cg.config.contains("Guilds")){
				
				for (String guilds : this.Cg.config.getConfigurationSection("Guilds").getKeys(false)){
					if (args[2].equalsIgnoreCase(this.Cg.config.getString("Guilds." + guilds + ".Tag"))){
						player.sendMessage("This guild tag already exists!");
						return CommandOutcome.SUCCESS;
					}
				}
			}
			if (this.Cg.config.contains(player.getName())){
				player.sendMessage("You are already in a guild! you can't create a new one!");
				return CommandOutcome.SUCCESS;
			}
			if(this.Cg.config.contains(args[1].replaceAll("_", " "))){
				player.sendMessage("A guild named " + args[1].replaceAll("_", " ") + " already exists!");
				return CommandOutcome.SUCCESS;
			}
			this.Cg.config.set("Guilds." + args[1].replaceAll("_", " ") + ".Players." + player.getName() + ".Rank", "Leader");
			this.Cg.config.set("Guilds." + args[1].replaceAll("_", " ") + ".Leader", player.getName());
			this.Cg.config.set("Guilds." + args[1].replaceAll("_", " ") + ".Tag", args[2]);
			this.Cg.config.set(player.getName() + ".Guild.Name", args[1].replaceAll("_", " "));
			this.Cg.config.set("Guilds." + args[1].replaceAll("_", " ") + ".DefTerm.Leader", "Leader");
			this.Cg.config.set("Guilds." + args[1].replaceAll("_", " ") + ".Ranks.Leader.Invite", true);
			this.Cg.config.set("Guilds." + args[1].replaceAll("_", " ") + ".Ranks.Leader.Ochat", true);
			this.Cg.config.set("Guilds." + args[1].replaceAll("_", " ") + ".Ranks.Leader.Kick", true);
			this.Cg.config.set("Guilds." + args[1].replaceAll("_", " ") + ".Ranks.Leader.Gmotd", true);
			this.Cg.config.set("Guilds." + args[1].replaceAll("_", " ") + ".Ranks.Leader.Disband", true);
			this.Cg.config.set("Guilds." + args[1].replaceAll("_", " ") + ".Ranks.Leader.Gchat", true);
			this.Cg.config.set("Guilds." + args[1].replaceAll("_", " ") + ".Ranks.Leader.Gbank", true);
			this.Cg.config.set("Guilds." + args[1].replaceAll("_", " ") + ".Ranks.Leader.Addslot", true);
			this.Cg.config.set("Guilds." + args[1].replaceAll("_", " ") + ".Ranks.Leader.Withdrawl", true);
			this.Cg.config.set("Guilds." + args[1].replaceAll("_", " ") + ".Ranks.Leader.Deposit", true);
			this.Cg.config.set("Guilds." + args[1].replaceAll("_", " ") + ".Ranks.Leader.GbRanks", true);
			this.Cg.config.set("Guilds." + args[1].replaceAll("_", " ") + ".Ranks.Leader.RankSet", true);
			this.Cg.config.set("Guilds." + args[1].replaceAll("_", " ") + ".Ranks.Leader.RankTitle", true);
			this.Cg.config.set("Guilds." + args[1].replaceAll("_", " ") + ".Ranks.Leader.CreateRank", true);
			this.Cg.config.set("Guilds." + args[1].replaceAll("_", " ") + ".Ranks.Leader.DeleteRank", true);
			this.Cg.config.set("Guilds." + args[1].replaceAll("_", " ") + ".Ranks.Leader.PlayerInfo", true);
			this.Cg.config.set("Guilds." + args[1].replaceAll("_", " ") + ".Ranks.Leader.RankPerms", true);
			this.Cg.config.set("Guilds." + args[1].replaceAll("_", " ") + ".Ranks.Leader.PlayerNotes", true);
			this.Cg.config.set("Guilds." + args[1].replaceAll("_", " ") + ".Ranks.Leader.PlayerNotesView", true);
			this.Cg.config.set("Guilds." + args[1].replaceAll("_", " ") + ".Ranks.Leader.PlayerNotesSet", true);
			this.Cg.config.set("Guilds." + args[1].replaceAll("_", " ") + ".Ranks.Leader.TP", true);
			this.Cg.config.set("Guilds." + args[1].replaceAll("_", " ") + ".Ranks.Leader.Title", "Guild Master");
			this.Cg.config.set("Guilds." + args[1].replaceAll("_", " ") + ".Ranks.Newbies.Invite", false);
			this.Cg.config.set("Guilds." + args[1].replaceAll("_", " ") + ".Ranks.Newbies.Ochat", false);
			this.Cg.config.set("Guilds." + args[1].replaceAll("_", " ") + ".Ranks.Newbies.Kick", false);
			this.Cg.config.set("Guilds." + args[1].replaceAll("_", " ") + ".Ranks.Newbies.Gmotd", false);
			this.Cg.config.set("Guilds." + args[1].replaceAll("_", " ") + ".Ranks.Newbies.Disband", false);
			this.Cg.config.set("Guilds." + args[1].replaceAll("_", " ") + ".Ranks.Newbies.Gchat", true);
			this.Cg.config.set("Guilds." + args[1].replaceAll("_", " ") + ".Ranks.Newbies.Gbank", false);
			this.Cg.config.set("Guilds." + args[1].replaceAll("_", " ") + ".Ranks.Newbies.Addslot", false);
			this.Cg.config.set("Guilds." + args[1].replaceAll("_", " ") + ".Ranks.Newbies.Withdrawl", false);
			this.Cg.config.set("Guilds." + args[1].replaceAll("_", " ") + ".Ranks.Newbies.Deposit", false);
			this.Cg.config.set("Guilds." + args[1].replaceAll("_", " ") + ".Ranks.Newbies.GbRanks", false);
			this.Cg.config.set("Guilds." + args[1].replaceAll("_", " ") + ".Ranks.Newbies.RankSet", false);
			this.Cg.config.set("Guilds." + args[1].replaceAll("_", " ") + ".Ranks.Newbies.RankTitle", false);
			this.Cg.config.set("Guilds." + args[1].replaceAll("_", " ") + ".Ranks.Newbies.CreateRank", false);
			this.Cg.config.set("Guilds." + args[1].replaceAll("_", " ") + ".Ranks.Newbies.DeleteRank", false);
			this.Cg.config.set("Guilds." + args[1].replaceAll("_", " ") + ".Ranks.Newbies.PlayerInfo", false);
			this.Cg.config.set("Guilds." + args[1].replaceAll("_", " ") + ".Ranks.Newbies.RankPerms", false);
			this.Cg.config.set("Guilds." + args[1].replaceAll("_", " ") + ".Ranks.Newbies.PlayerNotes", false);
			this.Cg.config.set("Guilds." + args[1].replaceAll("_", " ") + ".Ranks.Newbies.PlayerNotesView", false);
			this.Cg.config.set("Guilds." + args[1].replaceAll("_", " ") + ".Ranks.Newbies.PlayerNotesSet", false);
			this.Cg.config.set("Guilds." + args[1].replaceAll("_", " ") + ".Ranks.Newbies.TP", false);
			this.Cg.config.set("Guilds." + args[1].replaceAll("_", " ") + ".Ranks.Newbies.Title", "Newbies");
			this.Cg.config.set("Guilds." + args[1].replaceAll("_", " ") + ".DefTerm.Default", "Newbies");
			this.Cg.saveConfig();
			player.sendMessage("Congratulations " + player.getName() + " you are now the leader of the newly created guild " + args[1].replaceAll("_", " "));
			return CommandOutcome.SUCCESS;
		}
		if (args[0].equalsIgnoreCase("invite")){
			if (args.length != 2){
				player.sendMessage("Improper usage of the guild invite command, please just use /guild invite playername");
				return CommandOutcome.SUCCESS;
			}
			if (Util.getPlayer(args[1]) ==  null){
				player.sendMessage("This player cannot be found");
				return CommandOutcome.SUCCESS;
			}
			Player p = Util.getPlayer(args[1]);
			String pi = p.getName();
			String guildn = this.Cg.config.getString(player.getName() + ".Guild.Name");
			String grank = this.Cg.config.getString("Guilds." + guildn + ".Players." + player.getName() + ".Rank");
			if (!(this.Cg.config.contains(player.getName()))){
				player.sendMessage("You are not even in a guild? how can you invite someone?");
				return CommandOutcome.SUCCESS;
			}
			if (this.Cg.config.getBoolean("Guilds." + guildn + ".Ranks." + grank + ".Invite") == false){
				player.sendMessage("You do not have permission to invite people to this guild!");
				return CommandOutcome.SUCCESS;
			}
			if (this.Cg.config.contains(pi)){
				player.sendMessage(pi + " is already in a guild!");
				return CommandOutcome.SUCCESS;
			}
			if (this.Cg.config.contains("Pending." + pi)){
				player.sendMessage("This player already has a pending guild invite from " + this.Cg.config.getString("Pending." + pi + ".Guild"));
				return CommandOutcome.SUCCESS;
			}
			this.Cg.config.set("Pending." + pi + ".Guild", guildn);
			this.Cg.saveConfig();
			player.sendMessage("You have invited " + pi + " To join " + guildn);
			p.sendMessage("You have a pending guild invite from '" + guildn + "' type </guild accept> to join this guild. or </guild deny> to turn it down.");
			return CommandOutcome.SUCCESS;
		}
		if (args[0].equalsIgnoreCase("accept")){
			if (!(this.Cg.config.contains("Pending." + player.getName()))){
				player.sendMessage("You do not have any pending guild invites!");
				return CommandOutcome.SUCCESS;
			}

			String guildn = this.Cg.config.getString("Pending." + player.getName() + ".Guild");
			if (!(this.Cg.config.contains("Guilds." + guildn))){
				player.sendMessage("This guild no longer exists!");
				this.Cg.config.set("Pending." + player.getName(), null);
				return CommandOutcome.SUCCESS;
			}
			String newbies = this.Cg.config.getString("Guilds." + guildn + ".DefTerm.Default");
			this.Cg.config.set("Guilds." + guildn + ".Players." + player.getName() + ".Rank", newbies);
			this.Cg.config.set(player.getName() + ".Guild.Name", guildn);
			this.Cg.config.set("Pending." + player.getName(), null);
			this.Cg.saveConfig();
			if (this.Cg.config.getBoolean("Chat") == true){
				//player.setDisplayName("�F[�2" + guildn + "�f]" + player.getName());
			}
			for (String key : this.Cg.config.getConfigurationSection("Guilds." + guildn + ".Players").getKeys(false)){
				if (Util.getPlayer(key) == null){
				} else {
					if (Util.getPlayer(key).getName() == player.getName()){
						player.sendMessage("You Have Joined  " + guildn + "!!!");
					} else {
						Player p = Util.getPlayer(key);
						p.sendMessage(player.getName() + " Has Joined The Guild!");
					}
				}
			}
			return CommandOutcome.SUCCESS;
		}
		if (args[0].equalsIgnoreCase("deny")){
			if (!(this.Cg.config.contains("Pending." + player.getName()))){
				player.sendMessage("You do not have any pending guild invites!");
				return CommandOutcome.SUCCESS;
			}
			String guildn = this.Cg.config.getString("Pending." + player.getName() + ".Guild");
			String lead = this.Cg.config.getString("Guilds." + guildn + ".Leader");
			if (Util.getPlayer(lead) != null){
			} else {
				Player gleader = Util.getPlayer(lead);
				gleader.sendMessage(player.getName() + " has declined your guild invite.");
			}
			player.sendMessage("You have declined joining " + guildn + ".");
			this.Cg.config.set("Pending." + player.getName(), null);
			this.Cg.saveConfig();
			return CommandOutcome.SUCCESS;
		}		
		if (args[0].equalsIgnoreCase("gmotd")){
			StringBuilder buffer = new StringBuilder();
			for (int i = 1; i < args.length; i++) {
				buffer.append(' ').append(args[i]);
			}
			String s = buffer.toString();
			s = s.replaceAll("&", "�");
			String guildn = this.Cg.config.getString(player.getName() + ".Guild.Name");
			String grank = this.Cg.config.getString("Guilds." + guildn + ".Players." + player.getName() + ".Rank");
			if (!(this.Cg.config.contains(player.getName()))){
				player.sendMessage("You are not even in a guild? how can you set the Gmotd?");
				return CommandOutcome.SUCCESS;
			}
			if (this.Cg.config.getBoolean("Guilds." + guildn + ".Ranks." + grank + ".Gmotd") == false){
				player.sendMessage("You do not have permission to set the Gmotd!");
				return CommandOutcome.SUCCESS;
			}
			this.Cg.config.set("Guilds." + guildn + ".Gmotd", s);
			this.Cg.saveConfig();
			player.sendMessage("You have saved the gmotd as" + s);
			return CommandOutcome.SUCCESS;
			}
		if (args[0].equalsIgnoreCase("Kick")){
			String guildn = this.Cg.config.getString(player.getName() + ".Guild.Name");
			String grank = this.Cg.config.getString("Guilds." + guildn + ".Players." + player.getName() + ".Rank");
			if (args.length != 2){
				player.sendMessage("Please include the name of the person you want to kick.");
				return CommandOutcome.SUCCESS;
			}
			if (!(this.Cg.config.contains(player.getName()))){
				player.sendMessage("You are not even in a guild? How can you kick someone?");
				return CommandOutcome.SUCCESS;
			}
			if (this.Cg.config.getBoolean("Guilds." + guildn + ".Ranks." + grank + ".Kick") == false){
				player.sendMessage("You do not have permission to kick someone from the guild!");
				return CommandOutcome.SUCCESS;
			}
			if (!(this.Cg.config.contains("Guilds." + guildn + ".Players." + Util.getPlayer(args[1]).getName()))){
				player.sendMessage("This player is not a member of your guild!");
				return CommandOutcome.SUCCESS;
			}
			String prank = this.Cg.config.getString("Guilds." + guildn + ".Players." + args[1] + ".Rank");
			if (prank.equalsIgnoreCase("Leader")){
				player.sendMessage("You cannot kick a guild leader!");
				return CommandOutcome.SUCCESS;
			}
			this.Cg.config.set("Guilds." + guildn + ".Players." + args[1], null);
			this.Cg.config.set(args[1], null);
			if (Util.getPlayer(args[1]) != null){
				Player p = Util.getPlayer(args[1]);
				p.sendMessage("You have been removed from " + guildn + ".");
				//p.setName(p.getName());
			}
			player.sendMessage("You have removed " + args[1] + " from " + guildn + ".");
			this.Cg.saveConfig();
			return CommandOutcome.SUCCESS;
		}
		if (args[0].equalsIgnoreCase("disband")){
			String guildn = this.Cg.config.getString(player.getName() + ".Guild.Name");
			String grank = this.Cg.config.getString("Guilds." + guildn + ".Players." + player.getName() + ".Rank");
			if (!(this.Cg.config.contains(player.getName()))){
				player.sendMessage("You are not even in a guild? How can you disband it?");
				return CommandOutcome.SUCCESS;
			}
			if (this.Cg.config.getBoolean("Guilds." + guildn + ".Ranks." + grank + ".Disband") == false){
				player.sendMessage("You do not have permission to disband the guild!");
				return CommandOutcome.SUCCESS;
			}
			for (String key : this.Cg.config.getConfigurationSection("Guilds." + guildn + ".Players").getKeys(false)){
				this.Cg.config.set(key, null);

				if (Util.getPlayer(key) != null){
				} else {
					if (Util.getPlayer(key).getName() == player.getName()){
						player.sendMessage("You Have Disbanded  " + guildn + "!!!");
						
					} else {
						Player p = Util.getPlayer(key);
						
						p.sendMessage(" " + player.getName() + " Has Disbanded The Guild!");
					}
				}
			}
			this.Cg.config.set("Guilds." + guildn, null);
			this.Cg.saveConfig();
			return CommandOutcome.SUCCESS;
		}
		if (args[0].equalsIgnoreCase("quit")){
			String guildn = this.Cg.config.getString(player.getName() + ".Guild.Name");
			if (!(this.Cg.config.contains(player.getName()))){
				player.sendMessage("You are not even in a guild? How can you quit?");
				return CommandOutcome.SUCCESS;
			}
			for (String key : this.Cg.config.getConfigurationSection("Guilds." + guildn + ".Players").getKeys(false)){
                if (Util.getPlayer(key) != null){
                    continue;
                } else {
				if (Util.getPlayer(key).getName() == player.getName()){
					player.sendMessage("You Have Left  " + guildn + "!!!");
				} else {

						Player p = Util.getPlayer(key);
						p.sendMessage(player.getName() + " Has Quit The Guild!");
					}
				}
			}
			this.Cg.config.set("Guilds." + guildn + ".Players." + player.getName(), null);
			this.Cg.config.set(player.getName(), null);
			
			return CommandOutcome.SUCCESS;
		}
		if (args[0].equalsIgnoreCase("List")){
			if (args.length != 1){
				player.sendMessage("Improper usage! Please use /guild list");
				return CommandOutcome.SUCCESS;
			}
			String guildn = this.Cg.config.getString(player.getName() + ".Guild.Name");
			if (!(this.Cg.config.contains(player.getName()))){
				player.sendMessage("You are not even in a guild? how can you expect to list online members?");
				return CommandOutcome.SUCCESS;
			}
			for (String key : this.Cg.config.getConfigurationSection("Guilds." + guildn + ".Players").getKeys(false)){
				if (Util.getPlayer(key) != null){
					Player p = Util.getPlayer(key);
					String name = p.getName();
					String rank = this.Cg.config.getString("Guilds." + guildn + ".Players." + name + ".Rank");
					String title = this.Cg.config.getString("Guilds." + guildn + ".Ranks." + rank + ".Title");
					player.sendMessage("[" + title + "]" + " " + name + " - Status Online\n");
				} else {
					String rank = this.Cg.config.getString("Guilds." + guildn + ".Players." + key + ".Rank");
					String title = this.Cg.config.getString("Guilds." + guildn + ".Ranks." + rank + ".Title");
					player.sendMessage("[" + title + "]" + " " + key + " - Status Offline\n");				
				}
			}

			player.sendMessage("List complete");
			return CommandOutcome.SUCCESS;
		}
		if (args[0].equalsIgnoreCase("tag")){
			if ((!player.isAdmin())){
				player.sendMessage("Only ops can use this command!");
				return CommandOutcome.SUCCESS;
			}
			Boolean tag = this.Cg.config.getBoolean("Guild Names in Chat");
			if (tag == true){
				this.Cg.config.set("Guild Names in Chat", false);
				player.sendMessage("Guild tags disabled.");
			} else {
				this.Cg.config.set("Guild Names in Chat", true);
				player.sendMessage("Guild tags enabled.");
			}
			this.Cg.saveConfig();
			return CommandOutcome.SUCCESS;
		}
		if (args[0].equalsIgnoreCase("TP")){
			if (!(player.isAdmin())){
				player.sendMessage("Only ops can change the default server teleport behavior!");
				return CommandOutcome.SUCCESS;
			}
			if (args.length != 2){
				player.sendMessage("wrong usage! please use /guild tp on  or guild tp off!");
				return CommandOutcome.SUCCESS;
			}
			if (args[1].equalsIgnoreCase("on")){
				this.Cg.config.set("TP", true);
				player.sendMessage("Teleporting guild members is now allowed on your server!");
				return CommandOutcome.SUCCESS;
			}
			if (args[1].equalsIgnoreCase("off")){
				this.Cg.config.set("TP", false);
				player.sendMessage("Teleporting guild members is no longer allowed on your server!");
				return CommandOutcome.SUCCESS;
			}
		}

		return CommandOutcome.WRONG_USAGE;
	}
}
