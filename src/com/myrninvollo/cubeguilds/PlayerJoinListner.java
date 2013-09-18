package com.Myrninvollo.cubeguilds;

import org.glydar.paraglydar.event.EventHandler;
import org.glydar.paraglydar.event.Listener;
import org.glydar.paraglydar.event.events.PlayerJoinEvent;
import org.glydar.paraglydar.models.Player;

public class PlayerJoinListner implements Listener {
	
	Main Cg;
	public PlayerJoinListner(Main cg){
		this.Cg = cg;
	}
	
	 @EventHandler
	  public void onPlayerJoin(PlayerJoinEvent event) {
		 
		 Player player = event.getPlayer();
			//event.setJoinMessage("This Server Is Running CubeGuilds");
			if (this.Cg.config.contains(player.getName())){
				String guild = this.Cg.config.getString(player.getName() + ".Guild.Name");
				for (String key : this.Cg.config.getConfigurationSection("Guilds." + guild + ".Players").getKeys(false)){
					if (Util.getPlayer(key) != null){
						if (Util.getPlayer(key).getName() == player.getName()){

							if (!( this.Cg.config.getString("Guilds." + guild + ".Gmotd") != null)){
								player.sendMessage(this.Cg.config.getString("Guilds." + guild + ".Gmotd"));
							} else {
								player.sendMessage("You are a part of " + guild);
							}
						} else {
							Player p = Util.getPlayer(key);
							p.sendMessage( player.getName() + " Has come online!");
						}
					}

				}
			}
		 
		 
	 }
}
