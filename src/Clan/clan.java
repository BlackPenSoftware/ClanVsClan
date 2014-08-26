package Clan;

import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
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
	int MidVersion = 3;
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


	config.addDefault("Claims.Price.InTenThousands", 5);
	
     
     config.addDefault("Clan_1.Admin.UserName.ClanAdmin", Clan_1Admin);
     
     config.addDefault("Clan_1.Admin.Ballance", 1000);
     
     
     config.addDefault("Clan_1.Home.X", 0.0D);
     
     config.addDefault("Clan_1.Home.Y", 60.0D);
     
     config.addDefault("Clan_1.Home.Z", 0.0D);
     
     config.addDefault("Clan_1.Home.Yaw", 0.0D);
     
     config.addDefault("Clan_1.Home.Pitch", 0.0D);
     
     
     config.addDefault("Clan_1.Players.Names", Clan_1_Player_List);
     
     
     config.addDefault("Clan_1.Land.World.Name", "world");
     

  	config.addDefault("Clan_1.Land.ClaimSize.Size", Max);
  	

     	
        
     	
     	
     config.addDefault("Clan_2.Admin.UserName.ClanAdmin", Clan_2Admin);
     
     config.addDefault("Clan_2.Admin.Ballance", 100);
     
     config.addDefault("Clan_2.Players.Names", Clan_2_Player_List);
     
     
     config.addDefault("Clan_2.Land.World.Name", "Clan_2");
     
     
     config.addDefault("Clan_2.Home.X", 0.0D);
     
     config.addDefault("Clan_2.Home.Y", 60.0D);
     
     config.addDefault("Clan_2.Home.Z", 0.0D);
     
     config.addDefault("Clan_2.Home.Yaw", 0.0D);
     
     config.addDefault("Clan_2.Home.Pitch", 0.0D);
     
     
  	config.addDefault("Clan_2.Players.Names", Clan_2_Player_List);

  	config.addDefault("Clan_2.Land.ClaimSize.Size", Max_2);
  	

 		
  	
  	
  	
 	config.addDefault("Clan_3.Admin.UserName.ClanAdmin", Clan_3Admin);
 	
 	config.addDefault("Clan_3.Admin.Ballance", 100);
 	
 	
 	config.addDefault("Clan_3.Home.X", 0.0D);
     
     config.addDefault("Clan_3.Home.Y", 60.0D);
     
     config.addDefault("Clan_3.Home.Z", 0.0D);
     
     config.addDefault("Clan_3.Home.Yaw", 0.0D);
     
     config.addDefault("Clan_3.Home.Pitch", 0.0D);
 	
     
     config.addDefault("Clan_3.Land.World.Name", "Clan_3");
     
 	
 	config.addDefault("Clan_3.Players.Names", Clan_3_Player_List);

 	config.addDefault("Clan_3.Land.ClaimSize.Size", Max_3);
 	

 	
 	
 	
 	
     config.addDefault("Clan_4.Admin.UserName.ClanAdmin", Clan_4Admin);
     
     config.addDefault("Clan_4.Admin.Ballance", 100);
     
     
     config.addDefault("Clan_1.Home.X", 0.0D);
     
     config.addDefault("Clan_4.Home.Y", 60.0D);
     
     config.addDefault("Clan_4.Home.Z", 0.0D);
     
     config.addDefault("Clan_4.Home.Yaw", 0.0D);
     
     config.addDefault("Clan_4.Home.Pitch", 0.0D);
     
     
     config.addDefault("Clan_4.Land.World.Name", "Clan_4");
     
     
     config.addDefault("Clan_4.Players.Names", Clan_4_Player_List);
     

  	config.addDefault("Clan_4.Land.ClaimSize.Size", Max_4);

 	
 	config.options().copyDefaults(true);
 		
     saveConfig();
	
}

public void configReload(){
	
	reloadConfig();
	
}

public void configSave(){
	
	saveConfig();
	
}



int Max = 100;
int Max_2 = 100;
int Max_3 = 100;
int Max_4 = 100;
 
public void Max_100(){
	
	//Max = Max + 100;
	
	//config.get("Clan_1.Land.ClaimSize.Size");
	
	saveConfig();
	
}

public void Max_2_100(){
	
	Max_2 = Max_2 + 100;
	
	config.set("Clan_2.Land.ClaimSize.Size", Max_2);
	
	saveConfig();
	
}

public void Max_3_100(){
	
	Max_3 = Max_3 + 100;

	config.set("Clan_3.Land.ClaimSize.Size", Max_3);
	
	saveConfig();
	
}

public void Max_4_100(){
	
	Max_4 = Max_4 + 100;
	
	config.set("Clan_4.Land.ClaimSize.Size", Max_4);
	
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
		
		int Clan_2_Bal = getConfig().getInt("Clan_2.Admin.Ballance");
		
		Clan_2_Score.setScore(Clan_2_Bal);
		
		
		
		// CLAN 3 //
		
		Score Clan_3_Score = Clan_1_Bal_Board_Objective.getScore(ChatColor.BLUE + "Clan 3: "); //Get a fake offline player
		
		int Clan_3_Bal = getConfig().getInt("Clan_3.Admin.Ballance");
		
		Clan_3_Score.setScore(Clan_3_Bal);
		
		
		// CLAN 4//
		
		Score Clan_4_Score = Clan_1_Bal_Board_Objective.getScore(ChatColor.BLUE + "Clan 4: "); //Get a fake offline player
		
		int Clan_4_Bal = getConfig().getInt("Clan_4.Admin.Ballance");
		
		Clan_4_Score.setScore(Clan_4_Bal);
	
	
	player.setScoreboard(board);
	

	
	   Location loc = player.getLocation();
	   
	  
	   if(Clan_1.contains(player.getName())){
	   
	  
	   if(loc.getBlockX() > (Integer)config.get("Clan_1.Land.ClaimSize.Size")){
		   
		  player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_RED + "You Have Left Your Town");
		
		 // event.setCancelled(true);
		  
		  player.teleport(new Location(Bukkit.getWorld(config.get("Clan_1.Land.World.Name").toString()), (Integer)config.get("Clan_1.Land.ClaimSize.Size") - 5, loc.getBlockY(), loc.getBlockZ()));
		   
		  
		  
	   }
	
	   
	   
	   if(loc.getBlockZ() > (Integer)config.get("Clan_1.Land.ClaimSize.Size")){
		   
			  player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_RED + "You Have Left Your Town");
			
		
		 // event.setCancelled(true);
		  
		  player.teleport(new Location(Bukkit.getWorld(config.get("Clan_1.Land.World.Name").toString()), loc.getX(), loc.getBlockY(), (Integer)config.get("Clan_1.Land.ClaimSize.Size") - 5));
		   
		  
	   }
	   
	   
	   if(loc.getBlockX() * -1 > 0){
		   
			  player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_RED + "You Have Left Your Town");
			
			 // event.setCancelled(true);
			  
			  player.teleport(new Location(Bukkit.getWorld(config.get("Clan_1.Land.World.Name").toString()), (Integer)config.get("Clan_1.Land.ClaimSize.Size") - (Integer)config.get("Clan_1.Land.ClaimSize.Size") + 5 , loc.getBlockY(), loc.getBlockZ()));
			   
			  
		   }
		
		   
		   
		   if(loc.getBlockZ() * -1 > 0){
			   
				  player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_RED + "You Have Left Your Town");
				
			
			 // event.setCancelled(true);
			  
			  player.teleport(new Location(Bukkit.getWorld(config.get("Clan_1.Land.World.Name").toString()), loc.getX(), loc.getBlockY(), (Integer)config.get("Clan_1.Land.ClaimSize.Size") - (Integer)config.get("Clan_1.Land.ClaimSize.Size") + 5));
			   
			  
		   }
	   
	  } 
	   
	   

	   
	   

	   if(Clan_2.contains(player.getName())){
	   
	  
	   if(loc.getBlockX() > Max_2){
		   
		  player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_RED + "You Have Left Your Town");
		
		 // event.setCancelled(true);
		  
		  player.teleport(new Location(Bukkit.getWorld(config.get("Clan_2.Land.World.Name").toString()), Max_2 - 5, loc.getBlockY(), loc.getBlockZ()));
		   
		  
		  
	   }
	
	   
	   
	   if(loc.getBlockZ() > Max_2){
		   
			  player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_RED + "You Have Left Your Town");
			
		
		 // event.setCancelled(true);
		  
		  player.teleport(new Location(Bukkit.getWorld(config.get("Clan_2.Land.World.Name").toString()), loc.getX(), loc.getBlockY(), Max_2 - 5));
		   
		  
	   }
	   
	   
	   if(loc.getBlockX() * -1 > 0){
		   
			  player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_RED + "You Have Left Your Town");
			
			 // event.setCancelled(true);
			  
			  player.teleport(new Location(Bukkit.getWorld(config.get("Clan_2.Land.World.Name").toString()), Max_2 - Max_2 + 5 , loc.getBlockY(), loc.getBlockZ()));
			   
			  
		   }
		
		   
		   
		   if(loc.getBlockZ() * -1 > 0){
			   
				  player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_RED + "You Have Left Your Town");
				
			
			 // event.setCancelled(true);
			  
			  player.teleport(new Location(Bukkit.getWorld(config.get("Clan_2.Land.World.Name").toString()), loc.getX(), loc.getBlockY(), Max_2 - Max_2 + 5));
			   
			  
		   }
	   
	  } 
	   
	  
	   
	   if(Clan_3.contains(player.getName())){
		   
			  
		   if(loc.getBlockX() > Max_3){
			   
			  player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_RED + "You Have Left Your Town");
			
			 // event.setCancelled(true);
			  
			  player.teleport(new Location(Bukkit.getWorld(config.get("Clan_3.Land.World.Name").toString()), Max_3 - 5, loc.getBlockY(), loc.getBlockZ()));
			   
			  
			  
		   }
		
		   
		   
		   if(loc.getBlockZ() > Max_3){
			   
				  player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_RED + "You Have Left Your Town");
				
			
			 // event.setCancelled(true);
			  
			  player.teleport(new Location(Bukkit.getWorld(config.get("Clan_3.Land.World.Name").toString()), loc.getX(), loc.getBlockY(), Max_3 - 5));
			   
			  
		   }
		   
		   
		   if(loc.getBlockX() * -1 > 0){
			   
				  player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_RED + "You Have Left Your Town");
				
				 // event.setCancelled(true);
				  
				  player.teleport(new Location(Bukkit.getWorld(config.get("Clan_3.Land.World.Name").toString()), Max_3 - Max_3 + 5 , loc.getBlockY(), loc.getBlockZ()));
				   
				  
			   }
			
			   
			   
			   if(loc.getBlockZ() * -1 > 0){
				   
					  player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_RED + "You Have Left Your Town");
					
				
				 // event.setCancelled(true);
				  
				  player.teleport(new Location(Bukkit.getWorld(config.get("Clan_3.Land.World.Name").toString()), loc.getX(), loc.getBlockY(), Max_3 - Max_3 + 5));
				   
				  
			   }
		   
		  } 
		   
	   
	   
	   if(Clan_4.contains(player.getName())){
		   
			  
		   if(loc.getBlockX() > Max_4){
			   
			  player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_RED + "You Have Left Your Town");
			
			 // event.setCancelled(true);
			  
			  player.teleport(new Location(Bukkit.getWorld(config.get("Clan_4.Land.World.Name").toString()), Max_4 - 5, loc.getBlockY(), loc.getBlockZ()));
			   
			  
			  
		   }
		
		   
		   
		   if(loc.getBlockZ() > Max_4){
			   
				  player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_RED + "You Have Left Your Town");
				
			
			 // event.setCancelled(true);
			  
			  player.teleport(new Location(Bukkit.getWorld(config.get("Clan_4.Land.World.Name").toString()), loc.getX(), loc.getBlockY(), Max_4 - 5));
			   
			  
		   }
		   
		   
		   if(loc.getBlockX() * -1 > 0){
			   
				  player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_RED + "You Have Left Your Town");
				
				 // event.setCancelled(true);
				  
				  player.teleport(new Location(Bukkit.getWorld(config.get("Clan_4.Land.World.Name").toString()), Max_4 - Max_4 + 5 , loc.getBlockY(), loc.getBlockZ()));
				   
				  
			   }
			
			   
			   
			   if(loc.getBlockZ() * -1 > 0){
				   
					  player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_RED + "You Have Left Your Town");
					
				
				 // event.setCancelled(true);
				  
				  player.teleport(new Location(Bukkit.getWorld(config.get("Clan_4.Land.World.Name").toString()), loc.getX(), loc.getBlockY(), Max_4 - Max_4 + 5));
				   
				  
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





@EventHandler
public void onClick(InventoryClickEvent event) {
	
	
	
if (event.getInventory().getName().equalsIgnoreCase("Clan Sell")){
	
	Player player = (Player) event.getWhoClicked();


	List<String> Clan_1 = config.getStringList("Clan_1.Players.Names");

	List<String> Clan_2 = config.getStringList("Clan_2.Players.Names");

	List<String> Clan_3 = config.getStringList("Clan_3.Players.Names");

	List<String> Clan_4 = config.getStringList("Clan_4.Players.Names");

	
//Makes it so the code will only work if its in the CustomInv inventory
ItemStack clicked = event.getCurrentItem();
//The item that was clicked
if (clicked.getType() == Material.DIAMOND) {
event.setCancelled(true);

if(event.getInventory().contains(Material.DIAMOND)){
    
	if(Clan_1.contains(player.getName())){
	
	 player.getInventory().removeItem(new ItemStack(Material.DIAMOND, 1));
	 
	player.updateInventory();
	
	config.set("Clan_1.Admin.Ballance", (Integer)config.get("Clan_1.Admin.Ballance") + 500 );
	
	saveConfig();
	
	}
	
	if(event.getInventory().contains(Material.DIAMOND)){
	    
		if(Clan_2.contains(player.getName())){
		
		 player.getInventory().removeItem(new ItemStack(Material.DIAMOND, 1));
		 
		player.updateInventory();
		
		config.set("Clan_2.Admin.Ballance", (Integer)config.get("Clan_2.Admin.Ballance") + 500 );
		
		saveConfig();
		
		}
		
		
		
		if(event.getInventory().contains(Material.DIAMOND)){
		    
			if(Clan_3.contains(player.getName())){
			
			 player.getInventory().removeItem(new ItemStack(Material.DIAMOND, 1));
			 
			player.updateInventory();
			
			config.set("Clan_3.Admin.Ballance", (Integer)config.get("Clan_3.Admin.Ballance") + 500 );
			
			saveConfig();
			
			}
			
			
			
			if(event.getInventory().contains(Material.DIAMOND)){
			    
				if(Clan_4.contains(player.getName())){
				
				 player.getInventory().removeItem(new ItemStack(Material.DIAMOND, 1));
				 
				player.updateInventory();
				
				config.set("Clan_4.Admin.Ballance", (Integer)config.get("Clan_4.Admin.Ballance") + 500 );
				
				saveConfig();
				
				
								}
							}
						}			
					}
			}


}
		
if (clicked.getType() == Material.COBBLESTONE) {
event.setCancelled(true);

if(event.getInventory().contains(Material.COBBLESTONE)){
    
	if(Clan_1.contains(player.getName())){
	
		if(player.getInventory().contains(Material.COBBLESTONE, 32)){
		
	 player.getInventory().removeItem(new ItemStack(Material.COBBLESTONE, 32));
	 
	player.updateInventory();
	
	config.set("Clan_1.Admin.Ballance", (Integer)config.get("Clan_1.Admin.Ballance") + 32 );
	
	saveConfig();
	
		}
	}
	
	if(event.getInventory().contains(Material.COBBLESTONE)){
	    
		if(Clan_2.contains(player.getName())){
		
			if(player.getInventory().contains(Material.COBBLESTONE, 32)){
			
		 player.getInventory().removeItem(new ItemStack(Material.COBBLESTONE, 32));
		 
		player.updateInventory();
		
		config.set("Clan_2.Admin.Ballance", (Integer)config.get("Clan_2.Admin.Ballance") + 32);
		
		saveConfig();
		
		}
	}
		
		
		if(event.getInventory().contains(Material.COBBLESTONE)){
		    
			if(Clan_3.contains(player.getName())){
			
				if(player.getInventory().contains(Material.COBBLESTONE, 32)){
				
			 player.getInventory().removeItem(new ItemStack(Material.COBBLESTONE, 32));
			 
			player.updateInventory();
			
			config.set("Clan_3.Admin.Ballance", (Integer)config.get("Clan_3.Admin.Ballance") + 32 );
			
			saveConfig();
			
			}
		}
			
			
			if(event.getInventory().contains(Material.COBBLESTONE)){
			    
				if(Clan_4.contains(player.getName())){
				
					if(player.getInventory().contains(Material.COBBLESTONE, 32)){
					
				 player.getInventory().removeItem(new ItemStack(Material.COBBLESTONE, 32));
				 
				player.updateInventory();
				
				config.set("Clan_4.Admin.Ballance", (Integer)config.get("Clan_4.Admin.Ballance") + 32 );
				
				saveConfig();
				
										}
									}
								}
							}
						}
					}

}

if (clicked.getType() == Material.IRON_ORE) {
event.setCancelled(true);

if(event.getInventory().contains(Material.IRON_ORE)){
    
	if(Clan_1.contains(player.getName())){
	
		if(player.getInventory().contains(Material.IRON_ORE, 8)){
		
	 player.getInventory().removeItem(new ItemStack(Material.IRON_ORE, 8));
	 
	player.updateInventory();
	
	config.set("Clan_1.Admin.Ballance", (Integer)config.get("Clan_1.Admin.Ballance") + 100 );
	
	saveConfig();
	
		}
	}
	
	if(event.getInventory().contains(Material.IRON_ORE)){
	    
		if(Clan_2.contains(player.getName())){
		
			if(player.getInventory().contains(Material.IRON_ORE, 8)){
			
		 player.getInventory().removeItem(new ItemStack(Material.IRON_ORE, 8));
		 
		player.updateInventory();
		
		config.set("Clan_2.Admin.Ballance", (Integer)config.get("Clan_2.Admin.Ballance") + 100);
		
		saveConfig();
		
		}
	}
		
		
		if(event.getInventory().contains(Material.IRON_ORE)){
		    
			if(Clan_3.contains(player.getName())){
			
				if(player.getInventory().contains(Material.IRON_ORE, 8)){
				
			 player.getInventory().removeItem(new ItemStack(Material.IRON_ORE, 8));
			 
			player.updateInventory();
			
			config.set("Clan_3.Admin.Ballance", (Integer)config.get("Clan_3.Admin.Ballance") + 100 );
			
			saveConfig();
			
			}
		}
			
			
			if(event.getInventory().contains(Material.IRON_ORE)){
			    
				if(Clan_4.contains(player.getName())){
				
					if(player.getInventory().contains(Material.IRON_ORE, 8)){
					
				 player.getInventory().removeItem(new ItemStack(Material.IRON_ORE, 8));
				 
				player.updateInventory();
				
				config.set("Clan_4.Admin.Ballance", (Integer)config.get("Clan_4.Admin.Ballance") + 100 );
				
				saveConfig();
				
										}
									}
								}
							}
						}
					}

}

if (clicked.getType() == Material.GOLD_ORE) {
event.setCancelled(true);

if(event.getInventory().contains(Material.GOLD_ORE)){
    
	if(Clan_1.contains(player.getName())){
	
		if(player.getInventory().contains(Material.GOLD_ORE, 8)){
		
	 player.getInventory().removeItem(new ItemStack(Material.GOLD_ORE, 8));
	 
	player.updateInventory();
	
	config.set("Clan_1.Admin.Ballance", (Integer)config.get("Clan_1.Admin.Ballance") + 150 );
	
	saveConfig();
	
		}
	}
	
	if(event.getInventory().contains(Material.GOLD_ORE)){
	    
		if(Clan_2.contains(player.getName())){
		
			if(player.getInventory().contains(Material.GOLD_ORE, 8)){
			
		 player.getInventory().removeItem(new ItemStack(Material.GOLD_ORE, 8));
		 
		player.updateInventory();
		
		config.set("Clan_2.Admin.Ballance", (Integer)config.get("Clan_2.Admin.Ballance") + 150);
		
		saveConfig();
		
		}
	}
		
		
		if(event.getInventory().contains(Material.GOLD_ORE)){
		    
			if(Clan_3.contains(player.getName())){
			
				if(player.getInventory().contains(Material.GOLD_ORE, 8)){
				
			 player.getInventory().removeItem(new ItemStack(Material.GOLD_ORE, 8));
			 
			player.updateInventory();
			
			config.set("Clan_3.Admin.Ballance", (Integer)config.get("Clan_3.Admin.Ballance") + 150 );
			
			saveConfig();
			
			}
		}
			
			
			if(event.getInventory().contains(Material.GOLD_ORE)){
			    
				if(Clan_4.contains(player.getName())){
				
					if(player.getInventory().contains(Material.GOLD_ORE, 8)){
					
				 player.getInventory().removeItem(new ItemStack(Material.GOLD_ORE, 8));
				 
				player.updateInventory();
				
				config.set("Clan_4.Admin.Ballance", (Integer)config.get("Clan_4.Admin.Ballance") + 150 );
				
				saveConfig();
				
										}
									}
								}
							}
						}
					}


}

				


if (clicked.getType() == Material.LAPIS_ORE) {
event.setCancelled(true);

if(event.getInventory().contains(Material.LAPIS_ORE)){
    
	if(Clan_1.contains(player.getName())){
	
		if(player.getInventory().contains(Material.LAPIS_ORE, 1)){
		
	 player.getInventory().removeItem(new ItemStack(Material.LAPIS_ORE, 1));
	 
	player.updateInventory();
	
	config.set("Clan_1.Admin.Ballance", (Integer)config.get("Clan_1.Admin.Ballance") + 300 );
	
	saveConfig();
	
		}
	}
	
	if(event.getInventory().contains(Material.LAPIS_ORE)){
	    
		if(Clan_2.contains(player.getName())){
		
			if(player.getInventory().contains(Material.LAPIS_ORE, 1)){
			
		 player.getInventory().removeItem(new ItemStack(Material.LAPIS_ORE, 1));
		 
		player.updateInventory();
		
		config.set("Clan_2.Admin.Ballance", (Integer)config.get("Clan_2.Admin.Ballance") + 300);
		
		saveConfig();
		
		}
	}
		
		
		if(event.getInventory().contains(Material.LAPIS_ORE)){
		    
			if(Clan_3.contains(player.getName())){
			
				if(player.getInventory().contains(Material.LAPIS_ORE, 1)){
				
			 player.getInventory().removeItem(new ItemStack(Material.LAPIS_ORE, 1));
			 
			player.updateInventory();
			
			config.set("Clan_3.Admin.Ballance", (Integer)config.get("Clan_3.Admin.Ballance") + 300 );
			
			saveConfig();
			
			}
		}
			
			
			if(event.getInventory().contains(Material.LAPIS_ORE)){
			    
				if(Clan_4.contains(player.getName())){
				
					if(player.getInventory().contains(Material.LAPIS_ORE, 1)){
					
				 player.getInventory().removeItem(new ItemStack(Material.LAPIS_ORE, 1));
				 
				player.updateInventory();
				
				config.set("Clan_4.Admin.Ballance", (Integer)config.get("Clan_4.Admin.Ballance") + 300 );
				
				saveConfig();
				
										}
									}
								}
							}
						}
					}

}

if (clicked.getType() == Material.REDSTONE_ORE) {
event.setCancelled(true);

if(event.getInventory().contains(Material.REDSTONE_ORE)){
    
	if(Clan_1.contains(player.getName())){
	
		if(player.getInventory().contains(Material.REDSTONE_ORE, 8)){
		
	 player.getInventory().removeItem(new ItemStack(Material.REDSTONE_ORE, 8));
	 
	player.updateInventory();
	
	config.set("Clan_1.Admin.Ballance", (Integer)config.get("Clan_1.Admin.Ballance") + 400 );
	
	saveConfig();
	
		}
	}
	
	if(event.getInventory().contains(Material.REDSTONE_ORE)){
	    
		if(Clan_2.contains(player.getName())){
		
			if(player.getInventory().contains(Material.REDSTONE_ORE, 8)){
			
		 player.getInventory().removeItem(new ItemStack(Material.REDSTONE_ORE, 8));
		 
		player.updateInventory();
		
		config.set("Clan_2.Admin.Ballance", (Integer)config.get("Clan_2.Admin.Ballance") + 400);
		
		saveConfig();
		
		}
	}
		
		
		if(event.getInventory().contains(Material.REDSTONE_ORE)){
		    
			if(Clan_3.contains(player.getName())){
			
				if(player.getInventory().contains(Material.REDSTONE_ORE, 8)){
				
			 player.getInventory().removeItem(new ItemStack(Material.REDSTONE_ORE, 8));
			 
			player.updateInventory();
			
			config.set("Clan_3.Admin.Ballance", (Integer)config.get("Clan_3.Admin.Ballance") + 400 );
			
			saveConfig();
			
			}
		}
			
			
			if(event.getInventory().contains(Material.REDSTONE_ORE)){
			    
				if(Clan_4.contains(player.getName())){
				
					if(player.getInventory().contains(Material.REDSTONE_ORE, 8)){
					
				 player.getInventory().removeItem(new ItemStack(Material.REDSTONE_ORE, 8));
				 
				player.updateInventory();
				
				config.set("Clan_4.Admin.Ballance", (Integer)config.get("Clan_4.Admin.Ballance") + 400 );
				
				saveConfig();
				
										}
									}
								}
							}
						}
					}
}


if (clicked.getType() == Material.IRON_INGOT) {
event.setCancelled(true);

if(event.getInventory().contains(Material.IRON_INGOT)){
    
	if(Clan_1.contains(player.getName())){
	
		if(player.getInventory().contains(Material.IRON_INGOT, 8)){
		
	 player.getInventory().removeItem(new ItemStack(Material.IRON_INGOT, 8));
	 
	player.updateInventory();
	
	config.set("Clan_1.Admin.Ballance", (Integer)config.get("Clan_1.Admin.Ballance") + 150 );
	
	saveConfig();
	
		}
	}
	
	if(event.getInventory().contains(Material.IRON_INGOT)){
	    
		if(Clan_2.contains(player.getName())){
		
			if(player.getInventory().contains(Material.IRON_INGOT, 8)){
			
		 player.getInventory().removeItem(new ItemStack(Material.IRON_INGOT, 8));
		 
		player.updateInventory();
		
		config.set("Clan_2.Admin.Ballance", (Integer)config.get("Clan_2.Admin.Ballance") + 150);
		
		saveConfig();
		
		}
	}
		
		
		if(event.getInventory().contains(Material.IRON_INGOT)){
		    
			if(Clan_3.contains(player.getName())){
			
				if(player.getInventory().contains(Material.IRON_INGOT, 8)){
				
			 player.getInventory().removeItem(new ItemStack(Material.IRON_INGOT, 8));
			 
			player.updateInventory();
			
			config.set("Clan_3.Admin.Ballance", (Integer)config.get("Clan_3.Admin.Ballance") + 150 );
			
			saveConfig();
			
			}
		}
			
			
			if(event.getInventory().contains(Material.IRON_INGOT)){
			    
				if(Clan_4.contains(player.getName())){
				
					if(player.getInventory().contains(Material.IRON_INGOT, 8)){
					
				 player.getInventory().removeItem(new ItemStack(Material.IRON_INGOT, 8));
				 
				player.updateInventory();
				
				config.set("Clan_4.Admin.Ballance", (Integer)config.get("Clan_4.Admin.Ballance") + 150 );
				
				saveConfig();
				
										}
									}
								}
							}
						}
					}

}




if (clicked.getType() == Material.GOLD_INGOT) {
event.setCancelled(true);

if(event.getInventory().contains(Material.GOLD_INGOT)){
    
	if(Clan_1.contains(player.getName())){
	
		if(player.getInventory().contains(Material.GOLD_INGOT, 8)){
		
	 player.getInventory().removeItem(new ItemStack(Material.GOLD_INGOT, 8));
	 
	player.updateInventory();
	
	config.set("Clan_1.Admin.Ballance", (Integer)config.get("Clan_1.Admin.Ballance") + 250 );
	
	saveConfig();
	
		}
	}
	
	if(event.getInventory().contains(Material.GOLD_INGOT)){
	    
		if(Clan_2.contains(player.getName())){
		
			if(player.getInventory().contains(Material.GOLD_INGOT, 8)){
			
		 player.getInventory().removeItem(new ItemStack(Material.GOLD_INGOT, 8));
		 
		player.updateInventory();
		
		config.set("Clan_2.Admin.Ballance", (Integer)config.get("Clan_2.Admin.Ballance") + 250);
		
		saveConfig();
		
		}
	}
		
		
		if(event.getInventory().contains(Material.GOLD_INGOT)){
		    
			if(Clan_3.contains(player.getName())){
			
				if(player.getInventory().contains(Material.GOLD_INGOT, 8)){
				
			 player.getInventory().removeItem(new ItemStack(Material.GOLD_INGOT, 8));
			 
			player.updateInventory();
			
			config.set("Clan_3.Admin.Ballance", (Integer)config.get("Clan_3.Admin.Ballance") + 250 );
			
			saveConfig();
			
			}
		}
			
			
			if(event.getInventory().contains(Material.GOLD_INGOT)){
			    
				if(Clan_4.contains(player.getName())){
				
					if(player.getInventory().contains(Material.GOLD_INGOT, 8)){
					
				 player.getInventory().removeItem(new ItemStack(Material.GOLD_INGOT, 8));
				 
				player.updateInventory();
				
				config.set("Clan_4.Admin.Ballance", (Integer)config.get("Clan_4.Admin.Ballance") + 250 );
				
				saveConfig();
				
										}
									}
								}
							}
						}
					}

}


if (clicked.getType() == Material.REDSTONE) {
event.setCancelled(true);

if(event.getInventory().contains(Material.REDSTONE)){
    
	if(Clan_1.contains(player.getName())){
	
		if(player.getInventory().contains(Material.REDSTONE, 8)){
		
	 player.getInventory().removeItem(new ItemStack(Material.REDSTONE, 8));
	 
	player.updateInventory();
	
	config.set("Clan_1.Admin.Ballance", (Integer)config.get("Clan_1.Admin.Ballance") + 300 );
	
	saveConfig();
	
		}
	}
	
	if(event.getInventory().contains(Material.REDSTONE)){
	    
		if(Clan_2.contains(player.getName())){
		
			if(player.getInventory().contains(Material.REDSTONE, 8)){
			
		 player.getInventory().removeItem(new ItemStack(Material.REDSTONE, 8));
		 
		player.updateInventory();
		
		config.set("Clan_2.Admin.Ballance", (Integer)config.get("Clan_2.Admin.Ballance") + 300);
		
		saveConfig();
		
		}
	}
		
		
		if(event.getInventory().contains(Material.GOLD_INGOT)){
		    
			if(Clan_3.contains(player.getName())){
			
				if(player.getInventory().contains(Material.GOLD_INGOT, 8)){
				
			 player.getInventory().removeItem(new ItemStack(Material.GOLD_INGOT, 8));
			 
			player.updateInventory();
			
			config.set("Clan_3.Admin.Ballance", (Integer)config.get("Clan_3.Admin.Ballance") + 300 );
			
			saveConfig();
			
			}
		}
			
			
			if(event.getInventory().contains(Material.REDSTONE)){
			    
				if(Clan_4.contains(player.getName())){
				
					if(player.getInventory().contains(Material.REDSTONE, 8)){
					
				 player.getInventory().removeItem(new ItemStack(Material.REDSTONE, 8));
				 
				player.updateInventory();
				
				config.set("Clan_4.Admin.Ballance", (Integer)config.get("Clan_4.Admin.Ballance") + 300 );
				
				saveConfig();
				
										}
									}
								}
							}
						}
					}
}


if (clicked.getType() == Material.OBSIDIAN) {
event.setCancelled(true);

if(event.getInventory().contains(Material.OBSIDIAN)){
    
	if(Clan_1.contains(player.getName())){
	
		if(player.getInventory().contains(Material.OBSIDIAN, 8)){
		
	 player.getInventory().removeItem(new ItemStack(Material.OBSIDIAN, 8));
	 
	player.updateInventory();
	
	config.set("Clan_1.Admin.Ballance", (Integer)config.get("Clan_1.Admin.Ballance") + 400 );
	
	saveConfig();
	
		}
	}
	
	if(event.getInventory().contains(Material.OBSIDIAN)){
	    
		if(Clan_2.contains(player.getName())){
		
			if(player.getInventory().contains(Material.OBSIDIAN, 8)){
			
		 player.getInventory().removeItem(new ItemStack(Material.OBSIDIAN, 8));
		 
		player.updateInventory();
		
		config.set("Clan_2.Admin.Ballance", (Integer)config.get("Clan_2.Admin.Ballance") + 400);
		
		saveConfig();
		
		}
	}
		
		
		if(event.getInventory().contains(Material.OBSIDIAN)){
		    
			if(Clan_3.contains(player.getName())){
			
				if(player.getInventory().contains(Material.OBSIDIAN, 8)){
				
			 player.getInventory().removeItem(new ItemStack(Material.OBSIDIAN, 8));
			 
			player.updateInventory();
			
			config.set("Clan_3.Admin.Ballance", (Integer)config.get("Clan_3.Admin.Ballance") + 400 );
			
			saveConfig();
			
			}
		}
			
			
			if(event.getInventory().contains(Material.OBSIDIAN)){
			    
				if(Clan_4.contains(player.getName())){
				
					if(player.getInventory().contains(Material.OBSIDIAN, 8)){
					
				 player.getInventory().removeItem(new ItemStack(Material.OBSIDIAN, 8));
				 
				player.updateInventory();
				
				config.set("Clan_4.Admin.Ballance", (Integer)config.get("Clan_4.Admin.Ballance") + 400 );
				
				saveConfig();
				
										}
									}
								}
							}
						}
					}
}


if (clicked.getType() == Material.GLOWSTONE) {
event.setCancelled(true);

if(event.getInventory().contains(Material.GLOWSTONE)){
    
	if(Clan_1.contains(player.getName())){
	
		if(player.getInventory().contains(Material.GLOWSTONE, 8)){
		
	 player.getInventory().removeItem(new ItemStack(Material.GLOWSTONE, 8));
	 
	player.updateInventory();
	
	config.set("Clan_1.Admin.Ballance", (Integer)config.get("Clan_1.Admin.Ballance") + 600 );
	
	saveConfig();
	
		}
	}
	
	if(event.getInventory().contains(Material.GLOWSTONE)){
	    
		if(Clan_2.contains(player.getName())){
		
			if(player.getInventory().contains(Material.GLOWSTONE, 8)){
			
		 player.getInventory().removeItem(new ItemStack(Material.GLOWSTONE, 8));
		 
		player.updateInventory();
		
		config.set("Clan_2.Admin.Ballance", (Integer)config.get("Clan_2.Admin.Ballance") + 600);
		
		saveConfig();
		
		}
	}
		
		
		if(event.getInventory().contains(Material.GLOWSTONE)){
		    
			if(Clan_3.contains(player.getName())){
			
				if(player.getInventory().contains(Material.GLOWSTONE, 8)){
				
			 player.getInventory().removeItem(new ItemStack(Material.GLOWSTONE, 8));
			 
			player.updateInventory();
			
			config.set("Clan_3.Admin.Ballance", (Integer)config.get("Clan_3.Admin.Ballance") + 600 );
			
			saveConfig();
			
			}
		}
			
			
			if(event.getInventory().contains(Material.GLOWSTONE)){
			    
				if(Clan_4.contains(player.getName())){
				
					if(player.getInventory().contains(Material.GLOWSTONE, 8)){
					
				 player.getInventory().removeItem(new ItemStack(Material.GLOWSTONE, 8));
				 
				player.updateInventory();
				
				config.set("Clan_4.Admin.Ballance", (Integer)config.get("Clan_4.Admin.Ballance") + 600 );
				
				saveConfig();
				
										}
									}
								}
							}
						}
					}

}

if (clicked.getType() == Material.BLAZE_ROD) {
event.setCancelled(true);

if(event.getInventory().contains(Material.BLAZE_ROD)){
    
	if(Clan_1.contains(player.getName())){
	
		if(player.getInventory().contains(Material.BLAZE_ROD, 8)){
		
	 player.getInventory().removeItem(new ItemStack(Material.BLAZE_ROD, 8));
	 
	player.updateInventory();
	
	config.set("Clan_1.Admin.Ballance", (Integer)config.get("Clan_1.Admin.Ballance") + 800 );
	
	saveConfig();
	
		}
	}
	
	if(event.getInventory().contains(Material.BLAZE_ROD)){
	    
		if(Clan_2.contains(player.getName())){
		
			if(player.getInventory().contains(Material.BLAZE_ROD, 8)){
			
		 player.getInventory().removeItem(new ItemStack(Material.BLAZE_ROD, 8));
		 
		player.updateInventory();
		
		config.set("Clan_2.Admin.Ballance", (Integer)config.get("Clan_2.Admin.Ballance") + 800);
		
		saveConfig();
		
		}
	}
		
		
		if(event.getInventory().contains(Material.BLAZE_ROD)){
		    
			if(Clan_3.contains(player.getName())){
			
				if(player.getInventory().contains(Material.BLAZE_ROD, 8)){
				
			 player.getInventory().removeItem(new ItemStack(Material.BLAZE_ROD, 8));
			 
			player.updateInventory();
			
			config.set("Clan_3.Admin.Ballance", (Integer)config.get("Clan_3.Admin.Ballance") + 800 );
			
			saveConfig();
			
			}
		}
			
			
			if(event.getInventory().contains(Material.BLAZE_ROD)){
			    
				if(Clan_4.contains(player.getName())){
				
					if(player.getInventory().contains(Material.BLAZE_ROD, 8)){
					
				 player.getInventory().removeItem(new ItemStack(Material.BLAZE_ROD, 8));
				 
				player.updateInventory();
				
				config.set("Clan_4.Admin.Ballance", (Integer)config.get("Clan_4.Admin.Ballance") + 800 );
				
				saveConfig();
				
																				}
																			}
																		}
																	}
																}
															}
														}


													}
												}
											}
										
									
								
							
					

