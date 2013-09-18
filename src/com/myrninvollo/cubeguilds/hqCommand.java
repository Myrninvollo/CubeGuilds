package com.Myrninvollo.cubeguilds;

import org.glydar.paraglydar.command.Command;
import org.glydar.paraglydar.command.CommandSender;
import org.glydar.paraglydar.command.CommandSet;
import org.glydar.paraglydar.models.Player;
import org.glydar.paraglydar.scheduler.GlydarRunnable;




public class hqCommand implements CommandSet {
	Main Cg;
	public hqCommand(Main cg){
		this.Cg = cg;
	}

/*
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (args.length <= 0){
			return false;
		}
		if (args[0].equalsIgnoreCase("set")){
			Player player = (Player) sender;
			if (!(this.Cg.config.contains(player.getName()))){
				player.sendMessage("You are not even in a guild? how can you expect to create a guild Headquarters?");
				return true;
			}
			String guildn = this.Cg.config.getString(player.getName() + ".Guild.Name");
			String grank = this.Cg.config.getString("Guilds." + guildn + ".Players." + player.getName() + ".Rank");
			String leader = this.Cg.config.getString("Guilds." + guildn + ".DefTerm.Leader");
			if (!(grank.equalsIgnoreCase(leader))){
				player.sendMessage("Only a guild leader can set the guild headquarters!");
				return true;
			}
			
			
			double X = loc.getX();
			double Y = loc.getY();
			double Z = loc.getZ();
			String world = loc.getWorld().getName();
			this.Cg.config.set("Guilds." + guildn + ".HQ.X", X);
			this.Cg.config.set("Guilds." + guildn + ".HQ.Y", Y);
			this.Cg.config.set("Guilds." + guildn + ".HQ.Z", Z);
			this.Cg.config.set("Guilds." + guildn + ".HQ.World", world);
			this.Cg.saveConfig();
			player.sendMessage("Guild Headquarters successfully saved!");
			return true;
		}
		if (args[0].equalsIgnoreCase("tp")){
			Player player = (Player) sender;
			if (!(this.Cg.config.contains(player.getName()))){
				player.sendMessage("You are not even in a guild? how can you expect to create a guild Headquarters?");
				return true;
			}
			String guild = this.Cg.config.getString(player.getName() + ".Guild.Name");
			if (this.Cg.config.getConfigurationSection("Guilds." + guild + ".HQ") == null){
				player.sendMessage("Your guild does not have a Headquarters set!");
				return true;
			}
			final double X1 = this.Cg.config.getDouble("Guilds." + guild + ".HQ.X");
			final double Y1 = this.Cg.config.getDouble("Guilds." + guild + ".HQ.Y");
			final double Z1 = this.Cg.config.getDouble("Guilds." + guild + ".HQ.Z");
			final String world1 = this.Cg.config.getString("Guilds." + guild + ".HQ.World");
			final Location gloc = new Location(Bukkit.getWorld(world1), X1, Y1, Z1);
			final Location ploc = player.getLocation();
			final Player p = player;
			new GlydarRunnable(){
				Integer i = 5;
				@Override
				public void run(){
					p.sendMessage("§2HQ teleport timer: §4" + i);
					if (i == 0){
						p.teleport(gloc);
						cancel();
						return;
					}
					if (p.getLocation().getX() != ploc.getX()){
						p.sendMessage("You must stand in one place to enter your guild hall!");
						cancel();
						return;
					}
					if (p.getLocation().getY() != ploc.getY()){
						p.sendMessage("You must stand in one place to enter your guild hall!");
						cancel();
						return;
					}
					if (p.getLocation().getZ() != ploc.getZ()){
						p.sendMessage("You must stand in one place to enter your guild hall!");
						cancel();
						return;
					}
					i--;
				}
			}.runTaskTimer(this.Cg,0,20);
			return true;
		}
		return false;

	}
*/
}
