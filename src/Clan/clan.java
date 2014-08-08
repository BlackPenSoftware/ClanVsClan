package Clan;

import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import Executer.cvc;


public class clan extends JavaPlugin implements Listener{

	int MainVersion = 0;
	int MidVersion = 2;
	int SubVersion = 0;
	
	String MinecraftVersion = "1.7.9";
	
	 String Clan_1Admin = "Admin";
	 String Clan_2Admin = "Admin";
	 String Clan_3Admin = "Admin";
	 String Clan_4Admin = "Admin";
	
	 String PlayerLogName = "Player";
	 
	 FileConfiguration config = getConfig();
	 
	public String[][] Clan_1_Player_List = {
			
	        	{}
	        
		};
	
	public String[][] Clan_2_Player_List = {
			
        		{}
        
	};
	
	public String[][] Clan_3_Player_List = {
			
        		{}
        
	};
	
	public String[][] Clan_4_Player_List = {
			
        		{}
        
	};
	
	 
	public final Logger logger = Logger.getLogger("Minecraft");
	
	
	
public void onDisable(){

	System.out.println("[Clan Vs Clan] Clan Vs Clan v" + MainVersion + "." + MidVersion + "." + SubVersion + " Has Been Disabled.");
  }

public void initConfig() {

	 
	
     
     config.addDefault("Clan_1.Admin.UserName.ClanAdmin", Clan_1Admin);
     
     config.addDefault("Clan_1.Admin.Ballance", 1000);
     
     
     config.addDefault("Clan_1.Home.X", 0.0D);
     
     config.addDefault("Clan_1.Home.Y", 60.0D);
     
     config.addDefault("Clan_1.Home.Z", 0.0D);
     
     config.addDefault("Clan_1.Home.Yaw", 0.0D);
     
     config.addDefault("Clan_1.Home.Pitch", 0.0D);
     
     
     config.addDefault("Clan_1.Players.Names", Clan_1_Player_List);
     
     	config.addDefault("Clan_1.Land.ClaimSize.1", true);
     	config.addDefault("Clan_1.Land.ClaimSize.1.Cost", 10000);
     	
     	config.addDefault("Clan_1.Land.ClaimSize.2", false);
     	config.addDefault("Clan_1.Land.ClaimSize.2.Cost", 100000);
     	
     	config.addDefault("Clan_1.Land.ClaimSize.3", false);
     	config.addDefault("Clan_1.Land.ClaimSize.3.Cost", 1000000);
     	
     	config.addDefault("Clan_1.Land.ClaimSize.4", false);
     	config.addDefault("Clan_1.Land.ClaimSize.4.Cost", 10000000);
     	
     	config.addDefault("Clan_1.Land.ClaimSize.5", false);
     	config.addDefault("Clan_1.Land.ClaimSize.5.Cost", 100000000);
     	
     	config.addDefault("Clan_1.Land.ClaimSize.6", false);
     	config.addDefault("Clan_1.Land.ClaimSize.6.Cost", 1000000000);
     	
     	config.addDefault("Clan_1.Land.ClaimSize.7", false);
     	config.addDefault("Clan_1.Land.ClaimSize.7.Cost", 200000000);
     	
     	config.addDefault("Clan_1.Land.ClaimSize.8", false);
     	config.addDefault("Clan_1.Land.ClaimSize.8.Cost", 300000000);
     	
     	config.addDefault("Clan_1.Land.ClaimSize.9", false);
     	config.addDefault("Clan_1.Land.ClaimSize.9.Cost", 400000000);
     	
     	config.addDefault("Clan_1.Land.ClaimSize.10", false);
     	config.addDefault("Clan_1.Land.ClaimSize.10.Cost", 500000000);
     	
        
     	
     	
     config.addDefault("Clan_2.Admin.UserName.ClanAdmin", Clan_2Admin);
     
     config.addDefault("Clan_2.Admin.Ballance", 100);
     
     config.addDefault("Clan_2.Players.Names", Clan_2_Player_List);
     
     
 config.addDefault("Clan_2.Home.X", 0.0D);
     
     config.addDefault("Clan_2.Home.Y", 60.0D);
     
     config.addDefault("Clan_2.Home.Z", 0.0D);
     
     config.addDefault("Clan_2.Home.Yaw", 0.0D);
     
     config.addDefault("Clan_2.Home.Pitch", 0.0D);
     
     
     config.addDefault("Clan_2.Land.ClaimSize.1", true);
  	config.addDefault("Clan_2.Land.ClaimSize.1.Cost", 10000);
  	
  	config.addDefault("Clan_2.Land.ClaimSize.2", false);
  	config.addDefault("Clan_2.Land.ClaimSize.2.Cost", 100000);
  	
  	config.addDefault("Clan_2.Land.ClaimSize.3", false);
  	config.addDefault("Clan_2.Land.ClaimSize.3.Cost", 1000000);
  	
  	config.addDefault("Clan_2.Land.ClaimSize.4", false);
  	config.addDefault("Clan_2.Land.ClaimSize.4.Cost", 10000000);
  	
  	config.addDefault("Clan_2.Land.ClaimSize.5", false);
  	config.addDefault("Clan_2.Land.ClaimSize.5.Cost", 100000000);
  	
  	config.addDefault("Clan_2.Land.ClaimSize.6", false);
  	config.addDefault("Clan_2.Land.ClaimSize.6.Cost", 1000000000);
  	
  	config.addDefault("Clan_2.Land.ClaimSize.7", false);
  	config.addDefault("Clan_2.Land.ClaimSize.7.Cost", 200000000);
  	
  	config.addDefault("Clan_2.Land.ClaimSize.8", false);
  	config.addDefault("Clan_2.Land.ClaimSize.8.Cost", 300000000);
  	
  	config.addDefault("Clan_2.Land.ClaimSize.9", false);
  	config.addDefault("Clan_2.Land.ClaimSize.9.Cost", 400000000);
  	
  	config.addDefault("Clan_2.Land.ClaimSize.10", false);
  	config.addDefault("Clan_2.Land.ClaimSize.10.Cost", 500000000);
 		
  	
  	
  	
 	config.addDefault("Clan_3.Admin.UserName.ClanAdmin", Clan_3Admin);
 	
 	config.addDefault("Clan_3.Admin.Ballance", 100);
 	
 	
 config.addDefault("Clan_3.Home.X", 0.0D);
     
     config.addDefault("Clan_3.Home.Y", 60.0D);
     
     config.addDefault("Clan_3.Home.Z", 0.0D);
     
     config.addDefault("Clan_3.Home.Yaw", 0.0D);
     
     config.addDefault("Clan_3.Home.Pitch", 0.0D);
 	
 	
 	config.addDefault("Clan_3.Players.Names", Clan_3_Player_List);
 	
 	config.addDefault("Clan_3.Land.ClaimSize.1", true);
 	config.addDefault("Clan_3.Land.ClaimSize.1.Cost", 10000);
 	
 	config.addDefault("Clan_3.Land.ClaimSize.2", false);
 	config.addDefault("Clan_3.Land.ClaimSize.2.Cost", 100000);
 	
 	config.addDefault("Clan_3.Land.ClaimSize.3", false);
 	config.addDefault("Clan_3.Land.ClaimSize.3.Cost", 1000000);
 	
 	config.addDefault("Clan_3.Land.ClaimSize.4", false);
 	config.addDefault("Clan_3.Land.ClaimSize.4.Cost", 10000000);
 	
 	config.addDefault("Clan_3.Land.ClaimSize.5", false);
 	config.addDefault("Clan_3.Land.ClaimSize.5.Cost", 100000000);
 	
 	config.addDefault("Clan_3.Land.ClaimSize.6", false);
 	config.addDefault("Clan_3.Land.ClaimSize.6.Cost", 1000000000);
 	
 	config.addDefault("Clan_3.Land.ClaimSize.7", false);
 	config.addDefault("Clan_3.Land.ClaimSize.7.Cost", 200000000);
 	
 	config.addDefault("Clan_3.Land.ClaimSize.8", false);
 	config.addDefault("Clan_3.Land.ClaimSize.8.Cost", 300000000);
 	
 	config.addDefault("Clan_3.Land.ClaimSize.9", false);
 	config.addDefault("Clan_3.Land.ClaimSize.9.Cost", 400000000);
 	
 	config.addDefault("Clan_3.Land.ClaimSize.10", false);
 	config.addDefault("Clan_3.Land.ClaimSize.10.Cost", 500000000);
 	
 	
 	
 	
     config.addDefault("Clan_4.Admin.UserName.ClanAdmin", Clan_4Admin);
     
     config.addDefault("Clan_4.Admin.Ballance", 100);
     
     
 config.addDefault("Clan_1.Home.X", 0.0D);
     
     config.addDefault("Clan_4.Home.Y", 60.0D);
     
     config.addDefault("Clan_4.Home.Z", 0.0D);
     
     config.addDefault("Clan_4.Home.Yaw", 0.0D);
     
     config.addDefault("Clan_4.Home.Pitch", 0.0D);
     
     
     config.addDefault("Clan_4.Players.Names", Clan_4_Player_List);
     
     config.addDefault("Clan_4.Land.ClaimSize.1", true);
  	config.addDefault("Clan_4.Land.ClaimSize.1.Cost", 10000);
  	
  	config.addDefault("Clan_4.Land.ClaimSize.2", false);
  	config.addDefault("Clan_4.Land.ClaimSize.2.Cost", 100000);
  	
  	config.addDefault("Clan_4.Land.ClaimSize.3", false);
  	config.addDefault("Clan_4.Land.ClaimSize.3.Cost", 1000000);
  	
  	config.addDefault("Clan_4.Land.ClaimSize.4", false);
  	config.addDefault("Clan_4.Land.ClaimSize.4.Cost", 10000000);
  	
  	config.addDefault("Clan_4.Land.ClaimSize.5", false);
  	config.addDefault("Clan_4.Land.ClaimSize.5.Cost", 100000000);
  	
  	config.addDefault("Clan_4.Land.ClaimSize.6", false);
  	config.addDefault("Clan_4.Land.ClaimSize.6.Cost", 1000000000);
  	
  	config.addDefault("Clan_4.Land.ClaimSize.7", false);
  	config.addDefault("Clan_4.Land.ClaimSize.7.Cost", 200000000);
  	
  	config.addDefault("Clan_4.Land.ClaimSize.8", false);
  	config.addDefault("Clan_4.Land.ClaimSize.8.Cost", 300000000);
  	
  	config.addDefault("Clan_4.Land.ClaimSize.9", false);
  	config.addDefault("Clan_4.Land.ClaimSize.9.Cost", 400000000);
  	
  	config.addDefault("Clan_4.Land.ClaimSize.10", false);
  	config.addDefault("Clan_4.Land.ClaimSize.10.Cost", 500000000);
 	
 	config.options().copyDefaults(true);
 		
     saveConfig();
	
}

public void configReload(){
	
	reloadConfig();
	
}

public void configSave(){
	
	saveConfig();
	
}



 

@Override
public void onEnable() {
    
       initConfig();
	  
	  System.out.println(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_RED + "Clan Vs Clan v" + MainVersion + "." + MidVersion + "." + SubVersion + " Is Running.");
	  System.out.println(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_RED + "**** THIS IS A DEVELOPMENT BUILD USE WITH CAUTION ****");
	  System.out.println(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_RED+ "This Version Is To Be Used With Minecraft Version " + MinecraftVersion);
	  
	  PluginManager pm = getServer().getPluginManager();
	  pm.registerEvents(this, this);
	  
	  registerCommands();
	  
	
	  
    }


public void registerCommands(){
	
	getCommand("cvc").setExecutor(new cvc(this));
   
}
	
int Max = 100;

List<String> Clan_1 = config.getStringList("Clan_1.Players.Names");

List<String> Clan_2 = config.getStringList("Clan_2.Players.Names");

List<String> Clan_3 = config.getStringList("Clan_3.Players.Names");

List<String> Clan_4 = config.getStringList("Clan_4.Players.Names");

int i = 0;

@EventHandler(priority = EventPriority.HIGHEST)
public void playerMove(PlayerMoveEvent event) {

	Player player = event.getPlayer();

	i = i + 1;

	
	// CLAN 1 BAL //
	ScoreboardManager Clan_1_Bal_Board_Manager = Bukkit.getScoreboardManager();
	
	Scoreboard board = Clan_1_Bal_Board_Manager.getNewScoreboard();
	
	Team Clan_1_Bal_Board_Team = board.registerNewTeam("Clan_1");
	
	Clan_1_Bal_Board_Team.setPrefix("* Clan 1 * ");
	
	Objective Clan_1_Bal_Board_Objective = board.registerNewObjective("test", "dummy");
	
	Clan_1_Bal_Board_Objective.setDisplaySlot(DisplaySlot.SIDEBAR);
	 
	//Setting the display name of the scoreboard/objective
	Clan_1_Bal_Board_Objective.setDisplayName("Balance");
	
	Score score = Clan_1_Bal_Board_Objective.getScore(ChatColor.BLUE + "Clan 1: "); //Get a fake offline player
	
	int Clan_1_Bal = getConfig().getInt("Clan_1.Admin.Ballance");
	
	score.setScore(Clan_1_Bal);
	
	//reloadConfig();

	
	board.resetScores(player);
	

	
	// CLAN 2 //
	
		Score Clan_2_Score = Clan_1_Bal_Board_Objective.getScore(ChatColor.BLUE + "Clan 2: "); //Get a fake offline player
		
		//int Clan_2_Bal = (Integer) config.get("Clan_2.Admin.Ballance");
		
		Clan_2_Score.setScore(999);
		
		
		
		// CLAN 3 //
		
		Score Clan_3_Score = Clan_1_Bal_Board_Objective.getScore(ChatColor.BLUE + "Clan 3: "); //Get a fake offline player
		
		//int Clan_3_Bal = (Integer) config.get("Clan_3.Admin.Ballance");
		
		Clan_3_Score.setScore(998);
		
		
		// CLAN 4//
		
		Score Clan_4_Score = Clan_1_Bal_Board_Objective.getScore(ChatColor.BLUE + "Clan 4: "); //Get a fake offline player
		
		//int Clan_4_Bal = (Integer) config.get("Clan_4.Admin.Ballance");
		
		Clan_4_Score.setScore(997);
	
	
	player.setScoreboard(board);
	
	
	   Location loc = player.getLocation();
	   
	  
	   if(Clan_4.contains(player.getName())){
	   
	  
	   if(loc.getBlockX() > Max){
		   
		  player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_RED + "You Have Left Your Town");
		
		 // event.setCancelled(true);
		  
		  player.teleport(new Location(Bukkit.getWorld("world"), Max - 5, loc.getBlockY(), loc.getBlockZ()));
		   
		  
		  
	   }
	
	   
	   
	   if(loc.getBlockZ() > Max){
		   
			  player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_RED + "You Have Left Your Town");
			
		
		 // event.setCancelled(true);
		  
		  player.teleport(new Location(Bukkit.getWorld("world"), loc.getX(), loc.getBlockY(), Max - 5));
		   
		  
	   }
	   
	   
	   if(loc.getBlockX() * -1 > 0){
		   
			  player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_RED + "You Have Left Your Town");
			
			 // event.setCancelled(true);
			  
			  player.teleport(new Location(Bukkit.getWorld("world"), Max - Max + 5 , loc.getBlockY(), loc.getBlockZ()));
			   
			  
		   }
		
		   
		   
		   if(loc.getBlockZ() * -1 > 0){
			   
				  player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_RED + "You Have Left Your Town");
				
			
			 // event.setCancelled(true);
			  
			  player.teleport(new Location(Bukkit.getWorld("world"), loc.getX(), loc.getBlockY(), Max - Max + 5));
			   
			  
		   }
	   
	  } 
		   

}


@EventHandler 

public void OnPlayerLogin(PlayerJoinEvent event){
	
	Player player = event.getPlayer();

	
	
	Random Random = new Random();

	int pick = Random.nextInt(4);

	if(!Clan_1.contains(player.getName())){
		
		if(!Clan_2.contains(player.getName())){
			
			if(!Clan_3.contains(player.getName())){
				
				if(!Clan_4.contains(player.getName())){
	
	if(pick == 1){


	player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "You Are Now A Member Of " + ChatColor.GOLD + "Clan 1!");

	
	
	 Clan_1.add(player.getName());
		 
		// add to config
		config.set("Clan_1.Players.Names", Clan_1);
		 
		// save
		saveConfig();

	}


	if(pick == 2){


		player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "You Are Now A Member Of " + ChatColor.GOLD + "Clan 2!");


	
	
	 Clan_2.add(player.getName());
		 
		// add to config
		config.set("Clan_2.Players.Names", Clan_2);
		 
		// save
		saveConfig();

	}


	if(pick == 3){


		player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "You Are Now A Member Of " + ChatColor.GOLD + "Clan 3!");

	
	 Clan_3.add(player.getName());
		 
		// add to config
		config.set("Clan_3.Players.Names", Clan_3);
		 
		// save
		saveConfig();

	}


	if(pick == 4){


		player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "You Are Now A Member Of " + ChatColor.GOLD + "Clan 4!");

	
	
	 Clan_4.add(player.getName());
		 
		// add to config
		config.set("Clan_4.Players.Names", Clan_4);
		 
		// save
		saveConfig();

	}


	}
			}
		}
	}
}

	
}




