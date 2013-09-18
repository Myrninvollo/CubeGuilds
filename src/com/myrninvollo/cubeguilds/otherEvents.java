package com.Myrninvollo.cubeguilds;

public class otherEvents {

	/*

	@EventHandler
	public void guildBreak(BlockBreakEvent event){
		Player p = event.getPlayer();
		if (config.getBoolean("No Build") == true){
			Location loc = p.getLocation();
			for (String guild : config.getConfigurationSection("Guilds").getKeys(false)){
				if (config.getConfigurationSection("Guilds." + guild + ".HQ") != null){
					double X1 = config.getDouble("Guilds." + guild + ".HQ.X");
					double Y1 = config.getDouble("Guilds." + guild + ".HQ.Y");
					double Z1 = config.getDouble("Guilds." + guild + ".HQ.Z");
					String world1 = config.getString("Guilds." + guild + ".HQ.World");
					if (p.getWorld().getName().equalsIgnoreCase(world1)){
						Location gloc = new Location(Bukkit.getWorld(world1), X1, Y1, Z1);
						if (loc.distance(gloc) <= 50){
							if (!(config.contains(p.getName()))){
								p.sendMessage("You cannot build in the headquarters of " + guild + ".");
								event.setCancelled(true);
								return;
							}
							if(!(config.getString(p.getName() + "Guild.Name").equalsIgnoreCase(guild))){
							p.sendMessage("You cannot build in the headquarters of " + guild + ".");
							event.setCancelled(true);
							return;
							}
						}
					}
				}
			}
		}
	}
	@EventHandler
	public void guildUse(PlayerBucketEmptyEvent event){
		Player p = event.getPlayer();
		if (config.getBoolean("No Build") == true){
			Location loc = p.getLocation();
			for (String guild : config.getConfigurationSection("Guilds").getKeys(false)){
				if (config.getConfigurationSection("Guilds." + guild + ".HQ") != null){
					double X1 = config.getDouble("Guilds." + guild + ".HQ.X");
					double Y1 = config.getDouble("Guilds." + guild + ".HQ.Y");
					double Z1 = config.getDouble("Guilds." + guild + ".HQ.Z");
					String world1 = config.getString("Guilds." + guild + ".HQ.World");
					if (p.getWorld().getName().equalsIgnoreCase(world1)){
						Location gloc = new Location(Bukkit.getWorld(world1), X1, Y1, Z1);
						if (loc.distance(gloc) <= 50){
							if (!(config.contains(p.getName()))){
								p.sendMessage("You cannot build in the headquarters of " + guild + ".");
								event.setCancelled(true);
								
								return;
							}
							if(!(config.getString(p.getName() + "Guild.Name").equalsIgnoreCase(guild))){
							p.sendMessage("You cannot build in the headquarters of " + guild + ".");
							event.setCancelled(true);
							return;
							}
						}
					}
				}
			}
		}
	}
	@EventHandler
	public void guildUse(PlayerBucketFillEvent event){
		Player p = event.getPlayer();
		if (config.getBoolean("No Build") == true){
			Location loc = p.getLocation();
			for (String guild : config.getConfigurationSection("Guilds").getKeys(false)){
				if (config.getConfigurationSection("Guilds." + guild + ".HQ") != null){
					double X1 = config.getDouble("Guilds." + guild + ".HQ.X");
					double Y1 = config.getDouble("Guilds." + guild + ".HQ.Y");
					double Z1 = config.getDouble("Guilds." + guild + ".HQ.Z");
					String world1 = config.getString("Guilds." + guild + ".HQ.World");
					if (p.getWorld().getName().equalsIgnoreCase(world1)){
						Location gloc = new Location(Bukkit.getWorld(world1), X1, Y1, Z1);
						if (loc.distance(gloc) <= 50){
							if (!(config.contains(p.getName()))){
								p.sendMessage("You cannot build in the headquarters of " + guild + ".");
								event.setCancelled(true);
								return;
							}
							if(!(config.getString(p.getName() + "Guild.Name").equalsIgnoreCase(guild))){
							p.sendMessage("You cannot build in the headquarters of " + guild + ".");
							event.setCancelled(true);
							return;
							}
						}
					}
				}
			}
		}
	}
	@EventHandler
	public void guildPlace(BlockPlaceEvent event){
		Player p = event.getPlayer();
		if (config.getBoolean("No Build") == true){
			Location loc = p.getLocation();
			for (String guild : config.getConfigurationSection("Guilds").getKeys(false)){
				if (config.getConfigurationSection("Guilds." + guild + ".HQ") != null){
					double X1 = config.getDouble("Guilds." + guild + ".HQ.X");
					double Y1 = config.getDouble("Guilds." + guild + ".HQ.Y");
					double Z1 = config.getDouble("Guilds." + guild + ".HQ.Z");
					String world1 = config.getString("Guilds." + guild + ".HQ.World");
					if (p.getWorld().getName().equalsIgnoreCase(world1)){
						Location gloc = new Location(Bukkit.getWorld(world1), X1, Y1, Z1);
						if (loc.distance(gloc) <= 50){
							if (!(config.contains(p.getName()))){
								p.sendMessage("You cannot build in the headquarters of " + guild + ".");
								event.setCancelled(true);
								return;
							}
							if(!(config.getString(p.getName() + "Guild.Name").equalsIgnoreCase(guild))){
							p.sendMessage("You cannot build in the headquarters of " + guild + ".");
							event.setCancelled(true);
							return;
							}
						}
					}
				}
			}
		}
	}
	

	@EventHandler(priority = EventPriority.HIGH)
	public void onPlayerClick(InventoryClickEvent event){
		Player player = (Player)event.getWhoClicked();
		if (config.contains(player.getName())){
			String guildn = config.getString(player.getName() + ".Guild.Name");
			if (event.getInventory().getTitle().equalsIgnoreCase("Ranks:")){
				ItemStack itm = event.getCurrentItem();
				if (itm != null){
					ItemMeta rim = itm.getItemMeta();
					if (rim != null){
						event.setCancelled(true);
						event.setResult(Result.DENY);
						final String rname = rim.getDisplayName();
						player.closeInventory();
						final Player p = player;
						new BukkitRunnable(){
							@Override
							public void run(){
								p.performCommand("grank edit " + rname);
								cancel();
								return;
							}
						}.runTaskLater(plugin, 8);
					}
				}
			}
			String rank = null;
			for (String key : config.getConfigurationSection("Guilds." + guildn + ".Ranks").getKeys(false)){
				if (event.getInventory().getTitle().contains(key)){
					rank = key;
				}
			}
			if (rank != null){
				event.setCancelled(true);
				event.setResult(Result.DENY);
				ItemStack item = event.getCurrentItem();
				if(item == null || item.getTypeId() == 0){
					return;
				} else {
					ItemMeta im = event.getCurrentItem().getItemMeta();
					if (im.hasDisplayName()){
						String iname = im.getDisplayName();
						Short green = 5;
						Short red = 14;
						if (config.getBoolean("Guilds." + guildn + ".Ranks." + rank + "." + iname) == false){
							config.set("Guilds." + guildn + ".Ranks." + rank + "." + iname, true);
							ArrayList<String> lore = new ArrayList<String>();
							lore.add("True");
							im.setLore(lore);
							item.setItemMeta(im);
							item.setDurability(green);
							saveConfig();
						} else {
							config.set("Guilds." + guildn + ".Ranks." + rank + "." + iname, false);
							ArrayList<String> lore = new ArrayList<String>();
							lore.add("False");
							im.setLore(lore);
							item.setItemMeta(im);
							item.setDurability(red);
							saveConfig();
						}
					}
				}
			}
		}
	}
	@EventHandler(priority = EventPriority.HIGH)
	public void onPlayerDmg(EntityDamageByEntityEvent event){
		if(event.getEntity() instanceof Player){
			Player a = (Player)event.getEntity();
			Player b = null;
			if(event.getDamager() instanceof Player){
				b = (Player)event.getDamager();
			}
			if(event.getDamager() instanceof Arrow){
				if (((Arrow)event.getDamager()).getShooter() instanceof Player){
					b = (Player)((Arrow)event.getDamager()).getShooter();
				}
			}
			if (b != null){
				if ((config.contains(a.getName())) && (config.contains(b.getName()))){ 
					String guild = config.getString(a.getName() + ".Guild.Name");
					String guild1 = config.getString(b.getName() + ".Guild.Name");
					if (guild.equalsIgnoreCase(guild1)){
						event.setDamage(0);
						event.setCancelled(true);
					}
				}
			}
		}
	}
	
	
	
	
	@EventHandler
	public void onKick(PlayerKickEvent event2){
		event2.setLeaveMessage(null);
	}
	public void teleport(Player p, Player p2){
		final Player player = p;
		final Player player2 = p2;
		final Location loc = player.getLocation();
		final Location Loc = player2.getLocation();
		player.sendMessage("About to teleport, don't move!");
		player2.sendMessage("About to teleport, don't move!");
		new BukkitRunnable(){



			int count = 8;


			@Override
			public void run(){



				player.sendMessage( "Wait " + count + " Seconds." );
				player2.sendMessage( "Wait " + count + " Seconds." );
				count--;
				if (player.getLocation().getX() != loc.getX()){
					player.sendMessage("Cancelled teleport, don't move!");
					player2.sendMessage("Cancelled teleport, don't move!");
					cancel();
				}
				if (player.getLocation().getZ() != loc.getZ()){
					player.sendMessage("Cancelled teleport, don't move!");
					player2.sendMessage("Cancelled teleport, don't move!");
					cancel();
				}
				if (player2.getLocation().getX() != Loc.getX()){
					player.sendMessage("Cancelled teleport, don't move!");
					player2.sendMessage("Cancelled teleport, don't move!");
					cancel();
				}
				if (player2.getLocation().getZ() != Loc.getZ()){
					player.sendMessage("Cancelled teleport, don't move!");
					player2.sendMessage("Cancelled teleport, don't move!");
					cancel();
				}
				if (count == 0){
					player2.teleport(loc);
					cancel();
				}
			}

		}.runTaskTimer(plugin, 20, 20);
	}
	
	
	
	@EventHandler
	public void onQuit(PlayerQuitEvent event1) {
		Player player = event1.getPlayer();
		event1.setQuitMessage(null);
		if (config.contains(player.getName())){
			String guild = config.getString(player.getName() + ".Guild.Name");
			for (String key : config.getConfigurationSection("Guilds." + guild + ".Players").getKeys(false)){
				if (Util.getPlayer(key) != null){
					Player p = Util.getPlayer(key);
					p.sendMessage("�3" + player.getName() + "�2 Has gone offline!");

				}

			}
		}
	}*/
}
