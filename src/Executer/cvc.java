package Executer;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Clan.clan;



public class cvc implements CommandExecutor{
	 
    @SuppressWarnings("unused")
    private clan plugin;
    public cvc(clan plugin){
        this.plugin = plugin;
 
    }
 
    int Bal = 1000;
    
 
    
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
        if((commandLabel.equalsIgnoreCase("CvC") && args.length == 0)){
            if(sender instanceof Player){
            	Player player = (Player) sender;
  
                  sender.sendMessage(ChatColor.GOLD + "==================[CvC 1 / 2]===================");

				  sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GREEN + "/CvC SetAdmin (Clan Number / Name) (Player Name)" + ChatColor.DARK_PURPLE + " This Command Is Used To Assign Clan Admins.");

				  sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GREEN + "/CvC Claim (Clan Number / Name) " + ChatColor.DARK_PURPLE + "This Command Allows For Admins To Set The Main Starting Claim For Clans.");
				  
				  sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GREEN + "/CvC ExpandCost " + ChatColor.DARK_PURPLE + "This Command Allows For The Admins Of The Clan To Check How Much It Will Cost To Expand Their Claim To The Next Size."); 
				  
				  sender.sendMessage(ChatColor.GOLD + "================================================");
				  

            }
            
            return true;
            
            
            	
            }else if((commandLabel.equalsIgnoreCase("CvC") && args[0].equalsIgnoreCase("Expand"))){
             
            	
            	
            	
            	return true;
            	
            }else if((commandLabel.equalsIgnoreCase("CvC") && args[0].equalsIgnoreCase("setAdmin"))){
            	
            	Player playerName = Bukkit.getPlayer(args[2]);
            	
            	   FileConfiguration config = plugin.getConfig();
            	   
            	
            	if(args[1].equalsIgnoreCase("1") && playerName.getName().toString() != config.get("Clan_2.Admin.UserName").toString() && playerName.getName().toString() != config.get("Clan_3.Admin.UserName").toString() && playerName.getName().toString() != config.get("Clan_4.Admin.UserName").toString()){

            	   	 

            	     sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GOLD + playerName.getDisplayName() + ChatColor.DARK_PURPLE + " Is The New Clan 1 Leader!");

            	     playerName.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GOLD + "You" + ChatColor.DARK_PURPLE + " Are The New Clan 1 Leader!");

            	     config.set("Clan_1.Admin.UserName", null);

            	     config.set("Clan_1.Admin.UserName", playerName.getDisplayName());

            	    plugin.configSave();

            	     plugin.reloadConfig();
            	     
            	     }

            	   	 

            	     if(args[1].equalsIgnoreCase("2") && playerName.getName().toString() != config.get("Clan_1.Admin.UserName").toString() && playerName.getName().toString() != config.get("Clan_3.Admin.UserName").toString() && playerName.getName().toString() != config.get("Clan_4.Admin.UserName").toString() ){

            	   	 

            	     sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GOLD + playerName.getDisplayName() + ChatColor.DARK_PURPLE + " Is The New Clan 2 Leader!");

            	   	 

            	     playerName.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GOLD + "You" + ChatColor.DARK_PURPLE + " Are The New Clan 2 Leader!");

            	     config.set("Clan_2.Admin.UserName", null);

            	     config.set("Clan_2.Admin.UserName", playerName.getDisplayName());

            	     plugin.configSave();

            	     plugin.reloadConfig();
            	     
            	     }

            	   	 

            	     if(args[1].equalsIgnoreCase("3") && playerName.getName().toString() != config.get("Clan_1.Admin.UserName").toString() && playerName.getName().toString() != config.get("Clan_2.Admin.UserName").toString() && playerName.getName().toString() != config.get("Clan_4.Admin.UserName").toString() ){

            	   	 

            	     sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GOLD + playerName.getDisplayName() + ChatColor.DARK_PURPLE + " Is The New Clan 3 Leader!");

            	    

            	     playerName.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GOLD + "You" + ChatColor.DARK_PURPLE + " Are The New Clan 3 Leader!");

            	     config.set("Clan_3.Admin.UserName", null);

            	     config.set("Clan_3.Admin.UserName", playerName.getDisplayName());

            	     plugin.configSave();

            	     plugin.reloadConfig();
            	     }



            	     if(args[1].equalsIgnoreCase("4") && playerName.getName() != config.get("Clan_1.Admin.UserName") && playerName.getName() != config.get("Clan_2.Admin.UserName") && playerName.getName() != config.get("Clan_3.Admin.UserName") ){

            	   	 

            	     sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GOLD + playerName.getDisplayName() + ChatColor.DARK_PURPLE + " Is The New Clan 4 Leader!");



            	     playerName.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GOLD + "You" + ChatColor.DARK_PURPLE + " Are The New Clan 4 Leader!");

            	     config.set("Clan_4.Admin.UserName", null);

            	     config.set("Clan_4.Admin.UserName", playerName.getDisplayName());

            	     plugin.configSave();

            	     plugin.reloadConfig();
            	     
            	     }
            
        
            return true;
            
            
        }else if((commandLabel.equalsIgnoreCase("CvC") && args[0].equalsIgnoreCase("2"))){
        	
       	 		sender.sendMessage(ChatColor.GOLD + "==================[CvC 2 / 2]===================");
       	 
			  sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GREEN + "/CvC Expand " + ChatColor.DARK_PURPLE + "This Command Allows For The Admins Of The Clan To Expand Their Claim.");
			  
			  sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GREEN + "/CvC Bal " + ChatColor.DARK_PURPLE + "This Command Allows For The Admins Of A Clan To Check The Amount Of Money The Clan Has.");
			  
			  
			  sender.sendMessage(ChatColor.GOLD + "================================================");
       	
       return true;	
       
        }else if((commandLabel.equalsIgnoreCase("CvC") && args[0].equalsIgnoreCase("Bal"))){
        	
        	   FileConfiguration config = plugin.getConfig();
    
        	   
        	   if(sender.getName().equalsIgnoreCase((String) config.get("Clan_1.Admin.UserName"))){

   	 		sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "Your Clan Ballance Is " + ChatColor.GREEN + "$" + config.get("Clan_1.Admin.Ballance"));
 
   	 		plugin.saveConfig();
   	 		
        	}
        	   
        	   if(sender.getName().equalsIgnoreCase((String) config.get("Clan_2.Admin.UserName"))){

          	 		sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "Your Clan Ballance Is " + ChatColor.GREEN + "$" + config.get("Clan_2.Admin.Ballance"));
        
          	 		plugin.saveConfig();
          	 		
               	}
        	   
        	   
        	   
        	   if(sender.getName().equalsIgnoreCase((String) config.get("Clan_3.Admin.UserName"))){

          	 		sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "Your Clan Ballance Is " + ChatColor.GREEN + "$" + config.get("Clan_3.Admin.Ballance"));
        
          	 		plugin.saveConfig();
          	 		
               	}
        	   
        	   
        	   if(sender.getName().equalsIgnoreCase((String) config.get("Clan_4.Admin.UserName"))){

          	 		sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "Your Clan Ballance Is " + ChatColor.GREEN + "$" + config.get("Clan_4.Admin.Ballance"));
        
          	 		plugin.saveConfig();
          	 		
               	}else{
        		
        	 sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_RED + "You Are Not The Clan Leader!");
        		
        	}

        	return true;	
        
        
        }else if((commandLabel.equalsIgnoreCase("CvC") && args[0].equalsIgnoreCase("Sell"))){
        	
        //	FileConfiguration config = plugin.getConfig();
     	   
     	  
     	   
     	  Inventory ClanSellInventory = Bukkit.createInventory(null, 18, "Clan Shop");
     	  
     	 ItemStack item = new ItemStack(Material.DIAMOND);
  		ItemMeta meta = item.getItemMeta();
  		meta.setDisplayName("Sell Diamonds");
  		ArrayList<String> Lore = new ArrayList<String>();
  		Lore.add("Diamonds Are Worth $500 Each");
  		Lore.add("Click Me To Sell A Diamond");
  		meta.setLore(Lore);
  		item.setItemMeta(meta);

  		
  		 ItemStack Cobbleitem = new ItemStack(Material.COBBLESTONE);
   		ItemMeta Cobblemeta = Cobbleitem.getItemMeta();
   		Cobblemeta.setDisplayName("Sell Cobble Stone");
   		ArrayList<String> CobbleLore = new ArrayList<String>();
   		CobbleLore.add("Diamonds Are Worth $32 For 32");
   		CobbleLore.add("Click Me To Sell 32x Cobble Stone");
   		Cobblemeta.setLore(CobbleLore);
   		Cobbleitem.setItemMeta(Cobblemeta);
  		
     	  
  		ClanSellInventory.setItem(0, item);
  		
  		ClanSellInventory.setItem(1, Cobbleitem);
  		
     
     	  
     	   
     	  if(sender instanceof Player){
				
     		  Player player = (Player) sender;
     		  
     		 player.openInventory(ClanSellInventory);
     		  
     		// config.set("Clan_1.Admin.Ballance", 1000);
     		 
     		plugin.saveConfig();
     			
     		
     		
     		 
     		
     	
     		
     	  } 
     	  
     	   
     	   
     	   return true;
     	   
     	   
        }else if((commandLabel.equalsIgnoreCase("CvC") && args[0].equalsIgnoreCase("Class") && args[1].equalsIgnoreCase("Join"))){
        	
        	FileConfiguration config = plugin.getConfig();
        	
        	
        	List<String> Clan_1 = config.getStringList("Clan_1.Players.Names");

        	List<String> Clan_2 = config.getStringList("Clan_2.Players.Names");

        	List<String> Clan_3 = config.getStringList("Clan_3.Players.Names");

        	List<String> Clan_4 = config.getStringList("Clan_4.Players.Names");
        	
        	
     	   
     	  if(sender instanceof Player){
          	  
          	
     		  
     		  Player player = (Player) sender;
     		 
     		 if(Clan_1.contains(player.getName())){
     			 
     			if(args[2].equalsIgnoreCase("Archer")){
        			 
        			 config.set("Clan_1.Players.PlayerClass." + player.getDisplayName() + ".Class", "Archer");
        			 
        			 player.sendMessage("You Are Now An Archer");
        			 
        			
        			 
        		 }
     			
     			if(args[2].equalsIgnoreCase("Miner")){
       			 
       			 config.set("Clan_1.Players.PlayerClass." + player.getDisplayName() + ".Class", "Miner");
       			 
       			 player.sendMessage("You Are Now A Miner");
       			 
       			 ItemStack item = new ItemStack(Material.IRON_PICKAXE);
  	       		ItemMeta meta = item.getItemMeta();
  	       		meta.setDisplayName("Miners Pick");
  	       		item.setItemMeta(meta);
  			 
  			 player.getInventory().addItem(item);
       			 
       		 }
 
     			 
     		 }
     		 
     		if(Clan_2.contains(player.getName())){
     			
     			if(args[2].equalsIgnoreCase("Archer")){
       			 
       			 config.set("Clan_2.PlayerClass.PlayerClass." + player.getDisplayName() + ".Class", "Archer");
       			 
       			 player.sendMessage("You Are Now An Archer");
       			 
       			 
       			 
       		 }
    			
    			if(args[2].equalsIgnoreCase("Miner")){
      			 
      			 config.set("Clan_2.PlayerClass.PlayerClass." + player.getDisplayName() + ".Class", "Miner");
      			 
      			 player.sendMessage("You Are Now A Miner");

       			 
       			 ItemStack item = new ItemStack(Material.IRON_PICKAXE);
  	       		ItemMeta meta = item.getItemMeta();
  	       		meta.setDisplayName("Miners Pick");
  	       		item.setItemMeta(meta);
  			 
  			 player.getInventory().addItem(item);
      			 
      		 }
     			
     		}
     		
     		if(Clan_3.contains(player.getName())){
     		
     			if(args[2].equalsIgnoreCase("Archer")){
       			 
       			 config.set("Clan_3.PlayerClass.PlayerClass." + player.getDisplayName() + ".Class", "Archer");
       			 
       			 player.sendMessage("You Are Now An Archer");
       			 
       			 
       			 
       		 }
    			
    			if(args[2].equalsIgnoreCase("Miner")){
      			 
      			 config.set("Clan_3.PlayerClass.PlayerClass." + player.getDisplayName() + ".Class", "Miner");
      			 
      			 player.sendMessage("You Are Now A Miner");
      			 

       			 
       			 ItemStack item = new ItemStack(Material.IRON_PICKAXE);
  	       		ItemMeta meta = item.getItemMeta();
  	       		meta.setDisplayName("Miners Pick");
  	       		item.setItemMeta(meta);
  			 
  			 player.getInventory().addItem(item);
      		 }
     			
     		
     		}
     		
     		if(Clan_4.contains(player.getName())){
     			
     			if(args[2].equalsIgnoreCase("Archer")){
       			 
       			 config.set("Clan_4.PlayerClass.PlayerClass." + player.getDisplayName() + ".Class", "Archer");
       			 
       			 player.sendMessage("You Are Now An Archer");
       			 
       			 
       			 
       		 }
    			
    			if(args[2].equalsIgnoreCase("Miner")){
      			 
      			 config.set("Clan_4.PlayerClass.PlayerClass." + player.getDisplayName() + ".Class", "Miner");
      			 
      			 player.sendMessage("You Are Now A Miner");
      			 
      			 

       			 
       			 ItemStack item = new ItemStack(Material.IRON_PICKAXE);
  	       		ItemMeta meta = item.getItemMeta();
  	       		meta.setDisplayName("Miners Pick");
  	       		item.setItemMeta(meta);
  			 
  			 player.getInventory().addItem(item);
      		 }
     			
     			
     		}
     		
     		  
     		
     		 
     		plugin.saveConfig();
     			
     		
     		
     		  }
     		
     	
     		
     	  
     	  
     	   
     	   
     	   return true;
     	   
     	   
        }else if((commandLabel.equalsIgnoreCase("CvC") && args[0].equalsIgnoreCase("Expand") && args[1].equalsIgnoreCase("Cost"))){
        	
     	   //FileConfiguration config = plugin.getConfig();
     	   
     	   sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] ");
     	   
     	   return true;
     	   
     	   
        }else if((commandLabel.equalsIgnoreCase("CvC") && args[0].equalsIgnoreCase("SetHome"))){
        	
        	FileConfiguration config = plugin.getConfig();
        	if(sender instanceof Player){
        		
        		Player player = (Player) sender;
        		
        		Location Loc = player.getLocation();
        		
        	
        	
        	
        	 if(sender.getName().equalsIgnoreCase((String) config.get("Clan_1.Admin.UserName"))){
        		 
        		config.set("Clan_1.Home.X", Loc.getX());
        		config.set("Clan_1.Home.Y", Loc.getY());
        		config.set("Clan_1.Home.Z", Loc.getZ());
         		
        		plugin.saveConfig();
        		
        		player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "You Have Created A Clan Home.");
             	
        		return true;
        		
        	 }
        	 
        		 if(sender.getName().equalsIgnoreCase((String) config.get("Clan_2.Admin.UserName"))){
        			 
        			 config.set("Clan_2.Home.X", Loc.getX());
             		config.set("Clan_2.Home.Y", Loc.getY());
             		config.set("Clan_2.Home.Z", Loc.getZ());
              		
             		plugin.saveConfig();
             		
             		player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "You Have Created A Clan Home.");
        		 
             		return true;
             		
        		 }
             		
        			 if(sender.getName().equalsIgnoreCase((String) config.get("Clan_3.Admin.UserName"))){
        				 
        				 	config.set("Clan_3.Home.X", Loc.getX());
        	        		config.set("Clan_3.Home.Y", Loc.getY());
        	        		config.set("Clan_3.Home.Z", Loc.getZ());
        	         		
        	        		plugin.saveConfig();
        	        		
        	        		player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "You Have Created A Clan Home.");
        	        		
        	        		return true;
        	        		
        			 }
        			 
        				 if(sender.getName().equalsIgnoreCase((String) config.get("Clan_4.Admin.UserName"))){
        					 
        					 config.set("Clan_4.Home.X", Loc.getX());
        		        		config.set("Clan_4.Home.Y", Loc.getY());
        		        		config.set("Clan_4.Home.Z", Loc.getZ());
        		         		
        		        		plugin.saveConfig();
        		        		
        		        		player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "You Have Created A Clan Home.");
        					 
        		        		return true;
        			
        			 
        				 
        		 
        	 }else{
        		
        		 player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_RED + "You Are Not A Clan Admin. Ask The Clan Admin To Set A Clan Home.");
             	
        		 
        	 }
        	 
        	 
        	return true;
        }
        	
        }else if((commandLabel.equalsIgnoreCase("CvC") && args[0].equalsIgnoreCase("Home"))){
        	
        	FileConfiguration config = plugin.getConfig();
        	
        	List<String> Clan_1 = config.getStringList("Clan_1.Players.Names");

        	List<String> Clan_2 = config.getStringList("Clan_2.Players.Names");

        	List<String> Clan_3 = config.getStringList("Clan_3.Players.Names");

        	List<String> Clan_4 = config.getStringList("Clan_4.Players.Names");
        	
        	if(sender instanceof Player){
        		
        		Player player = (Player) sender;
        	
        		if(Clan_1.contains(player.getName())){
        		
        		player.teleport(new Location(Bukkit.getWorld("world"), config.getDouble("Clan_1.Home.X"), config.getDouble("Clan_1.Home.Y"), config.getDouble("Clan_1.Home.Z")));
        		
        		return true;
        		}
        		
        		if(Clan_2.contains(player.getName())){
            		
            		player.teleport(new Location(Bukkit.getWorld("world"), config.getDouble("Clan_2.Home.X"), config.getDouble("Clan_2.Home.Y"), config.getDouble("Clan_2.Home.Z")));
            		
            		return true;
            		}
        		
        		if(Clan_3.contains(player.getName())){
            		
            		player.teleport(new Location(Bukkit.getWorld("world"), config.getDouble("Clan_3.Home.X"), config.getDouble("Clan_3.Home.Y"), config.getDouble("Clan_3.Home.Z")));
            		
            		return true;
            		}
        		
        		if(Clan_4.contains(player.getName())){
            		
            		player.teleport(new Location(Bukkit.getWorld("world"), config.getDouble("Clan_4.Home.X"), config.getDouble("Clan_4.Home.Y"), config.getDouble("Clan_4.Home.Z")));
            		
            		return true;
            		}
        		
        		
        	
        		
        	}else{
        	
        	sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan]" + ChatColor.DARK_RED + "The Command You Enterd Is Not Correct Please Try Again");
       
        	 
        	
        }
        	sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan]" + ChatColor.DARK_RED + "The Command You Enterd Is Not Correct Please Try Again");
            

        return true;
    }
		return false;
}
}
