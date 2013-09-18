package com.Myrninvollo.cubeguilds;

import org.glydar.paraglydar.event.EventHandler;
import org.glydar.paraglydar.event.Listener;
import org.glydar.paraglydar.event.events.ChatEvent;
import org.glydar.paraglydar.event.events.PlayerJoinEvent;
import org.glydar.paraglydar.models.Player;

public class onChatListener implements Listener {
	
	Main Cg;
	public onChatListener(Main cg){
		this.Cg = cg;
	}
	
	 @EventHandler
	  public void onChat(ChatEvent event) {
		 
		 Player player = event.getPlayer();
			if (this.Cg.config.getBoolean("Guild Names in Chat") == true){
				if (this.Cg.config.contains(player.getName())){
					String guild = this.Cg.config.getString(player.getName() + ".Guild.Name");
					String tag = this.Cg.config.getString("Guilds." + guild + ".Tag");
					if (this.Cg.config.getBoolean("Chat") == true){
						event.setMessage("[" +  tag +  "] " + event.getMessage());
					}
				}
			}
		 
	 }
}
