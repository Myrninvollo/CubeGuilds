package com.Myrninvollo.cubeguilds;

import java.util.Iterator;
import java.util.Map.Entry;

import org.glydar.paraglydar.ParaGlydar;
import org.glydar.paraglydar.command.CommandSender;
import org.glydar.paraglydar.models.Player;

import com.Myrninvollo.cubeguilds.Main;

public class Util {
	
	public static String stub = "Bank: ";
	
	
	 // Thanks to dzmen:D
	public static Player getPlayer(String name) {
		  @SuppressWarnings("rawtypes")
	      Iterator iterator = ParaGlydar.getServer().getConnectedPlayers().iterator();

	      Player player;
	      do {
	          if (!iterator.hasNext()) {
	              return null;
	          }
	          player = (Player) iterator.next();
	      } while (!player.getName().equalsIgnoreCase(name));
	      return player;
	  }
	  
	 // Thanks to dzmen:D
	    public static Player getPlayer(CommandSender s) {
	        @SuppressWarnings("rawtypes")
			Iterator iterator = ParaGlydar.getServer().getConnectedPlayers().iterator();
	        Player player;
	            if (!iterator.hasNext()) {
	                return null;
	            }
	            player = (Player) iterator.next();
	        return player;
	    }

	
	public static void sendMessage(Player player, String m){
		player.sendMessage(stub + m);
	}
	/*
	public static Inventory upgradeInventory(Inventory inv, int size){
		if(inv == null)
			return inv;
		if(inv.getSize() == size)
			return inv;
		Inventory temp = Bukkit.createInventory(null, size, "Bank:");
		for(int x = 0; x < inv.getSize(); x++)
			if(inv.getItem(x) != null)
				temp.setItem(x, inv.getItem(x));
		return temp;
	}
	
	public static boolean doesRegionContainLoc(Location loc){
		for(Entry<String, ProtectedRegion> entry : Main.wgPlugin.getRegionManager(loc.getWorld()).getRegions().entrySet())
			if(entry.getValue().contains((int)loc.getX(), (int)loc.getY(), (int)loc.getZ()))
				return true;
		return false;
	}
*/
}
