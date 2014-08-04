package ClanListener;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;

import Clan.clan;

public class clanlistener implements Listener {

		public static clan plugin;

		@EventHandler
		public void PlayerJoin(PlayerLoginEvent event) {
			
			FileConfiguration config = plugin.getConfig();
			
		Player p = event.getPlayer();
		if(p.hasPlayedBefore()) {

			
			
			//config.set("Clan_1.Players.Names", p.getName().toString());
			
		}

		}
}
