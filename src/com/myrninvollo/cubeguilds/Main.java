package com.Myrninvollo.cubeguilds;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.glydar.paraglydar.configuration.InvalidConfigurationException;
import org.glydar.paraglydar.configuration.file.FileConfiguration;
import org.glydar.paraglydar.configuration.file.YamlConfiguration;
import org.glydar.paraglydar.plugin.Plugin;



public class Main extends Plugin {
	static Main plugin;
	public static List<String> gbanks = new ArrayList<>();
	
	private File configFile;
	public FileConfiguration config;
    
	//public static Economy econ = null;
	@Override
	public void onEnable(){
		plugin = this;
		
		configFile = new File(getConfigFolder(), "guilds.yml");
        config = new YamlConfiguration();
        
        Conf_check();
        try {
                loadConf();
        } catch (Exception e) {
                e.printStackTrace();
        }
        
        getServer().getEventManager().register(this, new PlayerJoinListner(this));
        getServer().getEventManager().register(this, new onChatListener(this));
        
	    getServer().getCommandManager().register( this, new GuildHandler(this));
		
		getServer().getCommandManager().register( this, new gcHandler(this));
		 getServer().getCommandManager().register( this, new oHandler(this));
		// getServer().getCommandManager().register( this, new gTP(this));
		 getServer().getCommandManager().register( this, new guildslist(this));
		 getServer().getCommandManager().register( this, new lookUpCommand(this));
		// getServer().getCommandManager().register( this, new hqCommand(this));
		
		 getServer().getCommandManager().register( this, new gRankHandler(this));
		 
		
		
		
		
		
		
		
	}
	
	
	// Thanks to aumgn and dzmen:D
    // Save config file
    public void saveConfig() {
            try {
            	config.save(configFile);
            } catch (IOException exc) {
                    getLogger().warning(exc,
                                    "Error while trying to save config file");
            }
    }
    
 // Thanks to dzmen:D
    private void loadConf() throws Exception {
             
        if (!configFile.exists()) {
                config.options()
                                .header("TP = True or false for guilds using TP\r\n"
                                                + "Guild Names in Chat = True or False to allow Guild names in chat\r\n"
                                                + "chat = true or false for Guild Chat\r\n" 
                                                + "Have fun :D");
                config.addDefault("TP", false);
                config.addDefault("Guild Names in Chat", true);
                config.addDefault("Chat", true);
                
                config.options().copyDefaults(true);
                saveConfig();
        }
       ;
        config.load(configFile);

}

    // Thanks to dzmen:D
    private void Conf_check() {  
    if (!(config.contains("TP"))){
		config.set("TP", false);
		
	}
	if (!(config.contains("Guild Names in Chat"))){
		config.set("Guild Names in Chat", true);
		
	}
	if (!(config.contains("Chat"))){
		config.set("Chat", true);
		
	}
	
    }
	
	@Override
	public void onDisable(){
		getLogger().info("CubeGuilds has been Disabled!");
		saveConfig();
	}
	




	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "CubeGuilds";
	}
	@Override
	public String getVersion() {
		// TODO Auto-generated method stub
		return "0.0.1";
	}
}