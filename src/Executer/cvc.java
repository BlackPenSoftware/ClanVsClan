package Executer;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Clan.clan;



public class cvc implements CommandExecutor{
	 
	
    private clan plugin;
    public cvc(clan plugin){
        this.plugin = plugin;
 
    }
 
 
    int Bal = 1000;
    
 
  public static Inventory ClanSellInventory = Bukkit.createInventory(null, 18, "Clan Sell");
	  
  public static Inventory ClanBuyInventory = Bukkit.createInventory(null, 18, "Clan Buy");
	 
  public static Inventory ClanMainInventory = Bukkit.createInventory(null, 9, "Shop");
    
    
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
        if((commandLabel.equalsIgnoreCase("CvC") && args.length == 0)){
            if(sender instanceof Player){
            	@SuppressWarnings("unused")
				Player player = (Player) sender;
  
                  sender.sendMessage(ChatColor.GOLD + "==================[CvC 1 / 3]===================");

				  sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GREEN + "/CvC SetAdmin (Clan Number / Name) (Player Name)" + ChatColor.DARK_PURPLE + " This Command Is Used To Assign Clan Admins.");
				  
				  sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GREEN + "/CvC ExpandCost " + ChatColor.DARK_PURPLE + "This Command Allows For The Admins Of The Clan To Check How Much It Will Cost To Expand Their Claim To The Next Size."); 
				  
				  sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GREEN + "/CvC Pay (Player Name) (Ammount To Send) " + ChatColor.DARK_PURPLE + "This Command Allows For Players To Send Money From Their Personal Balance To Another Player."); 
				  
				  
				  sender.sendMessage(ChatColor.GOLD + "================================================");
				  

            }
            
            return true;
            
            
            	
            }else if((commandLabel.equalsIgnoreCase("CvC") && args[0].equalsIgnoreCase("Pay"))){
            	if(sender instanceof Player){
            	Player playerName = Bukkit.getPlayer(args[1]);
            	
            	int ammountout = Integer.parseInt(args[2]);
            	FileConfiguration config = plugin.getConfig(); 
            	
            	List<String> Air = config.getStringList("Air.Players.Names");

        		List<String> Earth = config.getStringList("Earth.Players.Names");

        		List<String> Water = config.getStringList("Water.Players.Names");

        		List<String> Fire = config.getStringList("Fire.Players.Names");
            	
            	
            		if(playerName != null){		 
            			if(ammountout >= 1){
            			
            				sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "You Payed " + ChatColor.DARK_AQUA + playerName.getDisplayName() + ChatColor.GREEN + " $" + ammountout);
            				playerName.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_AQUA + sender.getName() + ChatColor.DARK_PURPLE + " Sent You " + ChatColor.GREEN + "$" + ammountout);
            			
            				if(Air.contains(playerName.getDisplayName()) && (Integer)config.get("Air.Players." + playerName.getName().toString() + ".Bal") > ammountout){
            					config.set("Air.Players." + sender.getName().toString() + ".Bal", (Integer)config.get("Air.Players." + sender.getName().toString() + ".Bal") - ammountout); 
            					config.set("Air.Players." + playerName.getName().toString() + ".Bal", (Integer)config.get("Air.Players." + playerName.getName().toString() + ".Bal") + ammountout); 
            					
            					plugin.configSave();
            					
            				}
            				
            				if(Earth.contains(playerName.getDisplayName()) && (Integer)config.get("Earth.Players." + playerName.getName().toString() + ".Bal") > ammountout){
            					config.set("Earth.Players." + sender.getName().toString() + ".Bal", (Integer)config.get("Earth.Players." + sender.getName().toString() + ".Bal") - ammountout); 
            					config.set("Earth.Players." + playerName.getName().toString() + ".Bal", (Integer)config.get("Earth.Players." + playerName.getName().toString() + ".Bal") + ammountout); 
            					
            					plugin.configSave();
            					
            				}
            				
            				if(Water.contains(playerName.getDisplayName()) && (Integer)config.get("Water.Players." + playerName.getName().toString() + ".Bal") > ammountout){
            					config.set("Water.Players." + sender.getName().toString() + ".Bal", (Integer)config.get("Water.Players." + sender.getName().toString() + ".Bal") - ammountout); 
            					config.set("Water.Players." + playerName.getName().toString() + ".Bal", (Integer)config.get("Water.Players." + playerName.getName().toString() + ".Bal") + ammountout); 
            					
            					plugin.configSave();
            					
            				}
            				
            				if(Fire.contains(playerName.getDisplayName()) && (Integer)config.get("Fire.Players." + playerName.getName().toString() + ".Bal") > ammountout){
            					config.set("Fire.Players." + sender.getName().toString() + ".Bal", (Integer)config.get("Fire.Players." + sender.getName().toString() + ".Bal") - ammountout); 
            					config.set("Fire.Players." + playerName.getName().toString() + ".Bal", (Integer)config.get("Fire.Players." + playerName.getName().toString() + ".Bal") + ammountout); 
            					
            					plugin.configSave();
            					
            				}
            			
            			}
            		}else{
            		
            			sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.RED + "You Need A Player To Send Money To!");
            		
            		}
            	}
            	
            	return true;
            	
            	
            }else if((commandLabel.equalsIgnoreCase("CvC") && args[0].equalsIgnoreCase("Bal"))){
            
            	
            	FileConfiguration config = plugin.getConfig(); 
            	
            	List<String> Air = config.getStringList("Air.Players.Names");

        		List<String> Earth = config.getStringList("Earth.Players.Names");

        		List<String> Water = config.getStringList("Water.Players.Names");

        		List<String> Fire = config.getStringList("Fire.Players.Names");
            	
            	 
            	 
            	if(sender instanceof Player){
            		if(Air.contains(((Player) sender).getDisplayName())){
            			sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "Your Personal Balance Is " + ChatColor.GREEN + "$" + config.get("Air.Players." + sender.getName().toString() + ".Bal"));
            		}
            		
            		if(Earth.contains(((Player) sender).getDisplayName())){
            			sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "Your Personal Balance Is " + ChatColor.GREEN + "$" + config.get("Earth.Players." + sender.getName().toString() + ".Bal"));
            		}
            		
            		if(Water.contains(((Player) sender).getDisplayName())){
            			sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "Your Personal Balance Is " + ChatColor.GREEN + "$" + config.get("Water.Players." + sender.getName().toString() + ".Bal"));
            		}
            		
            		if(Fire.contains(((Player) sender).getDisplayName())){
            			sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "Your Personal Balance Is " + ChatColor.GREEN + "$" + config.get("Fire.Players." + sender.getName().toString() + ".Bal"));
            		}
            	 }
            	
            	return true;
            	
            }else if((commandLabel.equalsIgnoreCase("CvC") && args[0].equalsIgnoreCase("Expand"))){
             
            	   FileConfiguration config = plugin.getConfig();
            	   
            	  
            	   if( (Integer)config.get("Air.Land.ClaimSize.Size") >= 1000 ){
            		   
        			   sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "Your Clan Is Already At Max Size: " + (Integer)config.get("Air.Land.ClaimSize.Size") + "x" + (Integer)config.get("Air.Land.ClaimSize.Size"));
          			 
        				return true;
        			   
        		   
        		   }
            	   
            	   if( (Integer)config.get("Earth.Land.ClaimSize.Size") >= 1000){
            		   
        			   sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "Your Clan Is Already At Max Size: " + (Integer)config.get("Earth.Land.ClaimSize.Size") + "x" + (Integer)config.get("Earth.Land.ClaimSize.Size"));
          			 
        		   
        				return true;
        			   
        		   }
  
  
  
            	   if( (Integer)config.get("Water.Land.ClaimSize.Size") >= 1000){
	   
            		   	sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "Your Clan Is Already At Max Size: " + (Integer)config.get("Water.Land.ClaimSize.Size") + "x" + (Integer)config.get("Water.Land.ClaimSize.Size"));
		 
            			return true;
  
            	   }
  
  
  
            	   if( (Integer)config.get("Fire.Land.ClaimSize.Size") >= 1000){
	   
            		   		sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "Your Clan Is Already At Max Size: " + (Integer)config.get("Fire.Land.ClaimSize.Size") + "x" + (Integer)config.get("Fire.Land.ClaimSize.Size"));
		 
            		   		return true;
            		   		
  
            	   }
            	   
            	   
            	   
            	   if(sender.getName().equalsIgnoreCase((String) config.get("Air.Admin.UserName"))){
            		   

            		   
            		   //int Clan_1_Bal = plugin.getConfig().getInt("Air.Admin.Ballance");
            		   
            		   int bal = plugin.getConfig().getInt("Air.Admin.Ballance");
            		   
            		   //int claim = plugin.getConfig().getInt("Air.Land.ClaimSize");
            		   
            		   if( bal >= (Integer)config.get("Air.Land.ClaimSize.Size") * 500 && (Integer)config.get("Air.Land.ClaimSize.Size") < 1000){
            			   
            			   
            			 
            			   
            			   config.set("Air.Admin.Ballance", (Integer)config.get("Air.Admin.Ballance") - (Integer)config.get("Air.Land.ClaimSize.Size") * 500);
            			  
            			   
            			   config.set("Air.Land.ClaimSize.Size", (Integer)config.get("Air.Land.ClaimSize.Size") + 100);
            			   
            			
            			   plugin.saveConfig();
            			   
            			  
                		   sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "You Have Expanded Your Clan's Claim To " + (Integer)config.get("Air.Land.ClaimSize.Size") + "x" + (Integer)config.get("Air.Land.ClaimSize.Size"));
            			 
            	
                		return true;
            		  
            		   
            	   }
            	   
            	   
            	   
            	   
                		   if(sender.getName().equalsIgnoreCase((String) config.get("Earth.Admin.UserName"))){
                    		   

                    		   
                    		   //int Clan_1_Bal = plugin.getConfig().getInt("Air.Admin.Ballance");
                    		   
                    		   int bal_2 = plugin.getConfig().getInt("Earth.Admin.Ballance");
                    		   
                    		   //int claim = plugin.getConfig().getInt("Air.Land.ClaimSize");
                    		   
                    		   if( bal_2 >= (Integer)config.get("Earth.Land.ClaimSize.Size") * 500 && (Integer)config.get("Earth.Land.ClaimSize.Size") < 1000){
                    			   
                    			   
                    			 
                    			   
                    			   config.set("Earth.Admin.Ballance", (Integer)config.get("Earth.Admin.Ballance") - (Integer)config.get("Earth.Land.ClaimSize.Size") * 500);
                    			  
                    			   
                    			   config.set("Earth.Land.ClaimSize.Size", (Integer)config.get("Earth.Land.ClaimSize.Size") + 100);
                    			   
                    			
                    			   plugin.saveConfig();
                    			   
                    			  
                        		   sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "You Have Expanded Your Clan's Claim To " + (Integer)config.get("Earth.Land.ClaimSize.Size") + "x" + (Integer)config.get("Earth.Land.ClaimSize.Size"));
                    			 
                    	
                        			return true;
                    		  
                    		   
                    	   }
            	   
            	   
                    		   if(sender.getName().equalsIgnoreCase((String) config.get("Water.Admin.UserName"))){
                        		   

                        		   
                        		   //int Clan_1_Bal = plugin.getConfig().getInt("Air.Admin.Ballance");
                        		   
                        		   int bal_3 = plugin.getConfig().getInt("Water.Admin.Ballance");
                        		   
                        		   //int claim = plugin.getConfig().getInt("Air.Land.ClaimSize");
                        		   
                        		   if( bal_3 >= (Integer)config.get("Water.Land.ClaimSize.Size") * 500 && (Integer)config.get("Water.Land.ClaimSize.Size") < 1000){
                        			   
                        			   
                        			 
                        			   
                        			   config.set("Water.Admin.Ballance", (Integer)config.get("Water.Admin.Ballance") - (Integer)config.get("Water.Land.ClaimSize.Size") * 500);
                        			  
                        			   
                        			   config.set("Water.Land.ClaimSize.Size", (Integer)config.get("Water.Land.ClaimSize.Size") + 100);
                        			   
                        			
                        			   plugin.saveConfig();
                        			   
                        			  
                            		   sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "You Have Expanded Your Clan's Claim To " + (Integer)config.get("Water.Land.ClaimSize.Size") + "x" + (Integer)config.get("Water.Land.ClaimSize.Size"));
                        			 
                        	
                            			return true;
                        		  
                        		   
                        	   }
                        		   
                        		   if(sender.getName().equalsIgnoreCase((String) config.get("Fire.Admin.UserName"))){
                            		   

                            		   
                            		   //int Clan_1_Bal = plugin.getConfig().getInt("Air.Admin.Ballance");
                            		   
                            		   int bal_4 = plugin.getConfig().getInt("Fire.Admin.Ballance");
                            		   
                            		   //int claim = plugin.getConfig().getInt("Air.Land.ClaimSize");
                            		   
                            		   if( bal_4 >= (Integer)config.get("Fire.Land.ClaimSize.Size") * 500 && (Integer)config.get("Fire.Land.ClaimSize.Size") < 1000){
                            			   
                            			   
                            			 
                            			   
                            			   config.set("Fire.Admin.Ballance", (Integer)config.get("Fire.Admin.Ballance") - (Integer)config.get("Fire.Land.ClaimSize.Size") * 500);
                            			  
                            			   
                            			   config.set("Fire.Land.ClaimSize.Size", (Integer)config.get("Fire.Land.ClaimSize.Size") + 100);
                            			   
                            			
                            			   plugin.saveConfig();
                            			   
                            			  
                                		   sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "You Have Expanded Your Clan's Claim To " + (Integer)config.get("Fire.Land.ClaimSize.Size") + "x" + (Integer)config.get("Fire.Land.ClaimSize.Size"));
                            			 
                            	
                                		
                                			return true;
                            		   
                            	   }
                            		   
                            		   
                        		   }
                    		   }
                	
                		   }
                	
            	   }
                		   
                		   return true;
                		   
                		   
          
            }else if((commandLabel.equalsIgnoreCase("CvC") && args[0].equalsIgnoreCase("ExpandCost"))){
                
         	   FileConfiguration config = plugin.getConfig();
         	 
         	  List<String> Air = config.getStringList("Air.Players.Names");

         		List<String> Earth = config.getStringList("Earth.Players.Names");

         		List<String> Water = config.getStringList("Water.Players.Names");

         		List<String> Fire = config.getStringList("Fire.Players.Names");
         		
         		if(Air.contains(sender.getName())){
         			
         			int ClaimSize_1 = (Integer)config.get("Air.Land.ClaimSize.Size");
         			
         			if(ClaimSize_1 < 1000){
         			
         			sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + " To Expand Your Clans Claim To " + ChatColor.GOLD + ClaimSize_1 + ChatColor.DARK_PURPLE + "x" + ChatColor.GOLD + ClaimSize_1 + ChatColor.DARK_PURPLE + " Your Clan Needs " + ChatColor.GOLD + "$" + (ClaimSize_1 + 100) * 500);
         			
         			
         			}else{
         				
         				sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "Your Clan Is At Max Size");
         				
         			}
         			 return true;
         		}
         		
         			if(Earth.contains(sender.getName())){
         			
         				int ClaimSize_2 = (Integer)config.get("Earth.Land.ClaimSize.Size");
             			
             			if(ClaimSize_2 < 1000){
             			
             			sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + " To Expand Your Clans Claim To " + ChatColor.GOLD + ClaimSize_2 + ChatColor.DARK_PURPLE + "x" + ChatColor.GOLD + ClaimSize_2 + ChatColor.DARK_PURPLE + " Your Clan Needs " + ChatColor.GOLD + "$" + (ClaimSize_2 + 100) * 500);
             			
             			
             			}else{
             				
             				sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "Your Clan Is At Max Size");
             				
             			}
             			 return true;
         				}

         					if(Water.contains(sender.getName())){
		
         						int ClaimSize_3 = (Integer)config.get("Water.Land.ClaimSize.Size");
         	         			
         	         			if(ClaimSize_3 < 1000){
         	         			
         	         			sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + " To Expand Your Clans Claim To " + ChatColor.GOLD + ClaimSize_3 + ChatColor.DARK_PURPLE + "x" + ChatColor.GOLD + ClaimSize_3 + ChatColor.DARK_PURPLE + " Your Clan Needs " + ChatColor.GOLD + "$" + (ClaimSize_3 + 100) * 500);
         	         			
         	         			
         	         			}else{
         	         				
         	         				sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "Your Clan Is At Max Size");
         	         				
         	         			}
         	         			 return true;
         						}

         							if(Fire.contains(sender.getName())){
		
         								int ClaimSize_4 = (Integer)config.get("Fire.Land.ClaimSize.Size");
         			         			
         			         			if(ClaimSize_4 < 1000){
         			         			
         			         			sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + " To Expand Your Clans Claim To " + ChatColor.GOLD + ClaimSize_4 + ChatColor.DARK_PURPLE + "x" + ChatColor.GOLD + ClaimSize_4 + ChatColor.DARK_PURPLE + " Your Clan Needs " + ChatColor.GOLD + "$" + (ClaimSize_4 + 100) * 500);
         			         			
         			         			
         			         			}else{
         			         				
         			         				sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "Your Clan Is At Max Size");
         			         				
         			         			}
         			         			 return true;
         								}
         	   
         	   return true;
         							
            }else if((commandLabel.equalsIgnoreCase("CvC") && args[0].equalsIgnoreCase("setAdmin") && sender.isOp())){
            	
            	
            	@SuppressWarnings("deprecation")
				Player playerName = Bukkit.getPlayer(args[2]);
            	
            	   FileConfiguration config = plugin.getConfig();
            	   
            	
            	if(args[1].equalsIgnoreCase("1") && playerName.getName().toString() != config.get("Earth.Admin.UserName").toString() && playerName.getName().toString() != config.get("Water.Admin.UserName").toString() && playerName.getName().toString() != config.get("Fire.Admin.UserName").toString()){

            	   	 

            	     sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GOLD + playerName.getDisplayName() + ChatColor.DARK_PURPLE + " Is The New Air Leader!");

            	     playerName.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GOLD + "You" + ChatColor.DARK_PURPLE + " Are The New Air Leader!");

            	     config.set("Air.Admin.UserName", null);

            	     config.set("Air.Admin.UserName", playerName.getDisplayName());

            	    plugin.configSave();

            	     plugin.reloadConfig();
            	     
            	     }

            	   	 

            	     if(args[1].equalsIgnoreCase("2") && playerName.getName().toString() != config.get("Air.Admin.UserName").toString() && playerName.getName().toString() != config.get("Water.Admin.UserName").toString() && playerName.getName().toString() != config.get("Fire.Admin.UserName").toString() ){

            	   	 

            	     sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GOLD + playerName.getDisplayName() + ChatColor.DARK_PURPLE + " Is The New Earth Leader!");

            	   	 

            	     playerName.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GOLD + "You" + ChatColor.DARK_PURPLE + " Are The New Earth Leader!");

            	     config.set("Earth.Admin.UserName", null);

            	     config.set("Earth.Admin.UserName", playerName.getDisplayName());

            	     plugin.configSave();

            	     plugin.reloadConfig();
            	     
            	     }

            	   	 

            	     if(args[1].equalsIgnoreCase("3") && playerName.getName().toString() != config.get("Air.Admin.UserName").toString() && playerName.getName().toString() != config.get("Earth.Admin.UserName").toString() && playerName.getName().toString() != config.get("Fire.Admin.UserName").toString() ){

            	   	 

            	     sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GOLD + playerName.getDisplayName() + ChatColor.DARK_PURPLE + " Is The New Water Leader!");

            	    

            	     playerName.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GOLD + "You" + ChatColor.DARK_PURPLE + " Are The New Water Leader!");

            	     config.set("Water.Admin.UserName", null);

            	     config.set("Water.Admin.UserName", playerName.getDisplayName());

            	     plugin.configSave();

            	     plugin.reloadConfig();
            	     }



            	     if(args[1].equalsIgnoreCase("4") && playerName.getName() != config.get("Air.Admin.UserName") && playerName.getName() != config.get("Earth.Admin.UserName") && playerName.getName() != config.get("Water.Admin.UserName") ){

            	   	 

            	     sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GOLD + playerName.getDisplayName() + ChatColor.DARK_PURPLE + " Is The New Fire Leader!");



            	     playerName.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GOLD + "You" + ChatColor.DARK_PURPLE + " Are The New Fire Leader!");

            	     config.set("Fire.Admin.UserName", null);

            	     config.set("Fire.Admin.UserName", playerName.getDisplayName());

            	     plugin.configSave();

            	     plugin.reloadConfig();
            	     
            	     }
            
        
            return true;
            
            
        }else if((commandLabel.equalsIgnoreCase("CvC") && args[0].equalsIgnoreCase("2"))){
        	
       	 		sender.sendMessage(ChatColor.GOLD + "==================[CvC 2 / 3]===================");
       	 
			  sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GREEN + "/CvC Expand " + ChatColor.DARK_PURPLE + "This Command Allows For The Admins Of The Clan To Expand Their Claim.");
			   
			  sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GREEN + "/CvC Bal " + ChatColor.DARK_PURPLE + "This Command Shows Your Personal Balance."); 
			  
			  sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GREEN + "/CvC Home " + ChatColor.DARK_PURPLE + "This Command Teleports You To Your Clan Home."); 
				 
			  sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GREEN + "/CvC SetHome " + ChatColor.DARK_PURPLE + "This Command Allows Clan Admins To Set Homes."); 
				 
			  
			  sender.sendMessage(ChatColor.GOLD + "================================================");
       	
       return true;	
       
        }else if((commandLabel.equalsIgnoreCase("CvC") && args[0].equalsIgnoreCase("3"))){
        	
   	 		sender.sendMessage(ChatColor.GOLD + "==================[CvC 3 / 3]===================");
   	 
		  sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GREEN + "/CvC Shop " + ChatColor.DARK_PURPLE + "This Command Allows Players To Buy And Sell Items With Personal Money.");
	
		  sender.sendMessage(ChatColor.GOLD + "================================================");
   	
   return true;	
        
        }else if((commandLabel.equalsIgnoreCase("CvC") && args[0].equalsIgnoreCase("Bal"))){
        	
        	   FileConfiguration config = plugin.getConfig();
    
        	   
        	   if(sender.getName().equalsIgnoreCase((String) config.get("Air.Admin.UserName"))){

   	 		sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "Your Clan Ballance Is " + ChatColor.GREEN + "$" + config.get("Air.Admin.Ballance"));
 
   	 		plugin.saveConfig();
   	 		
        	}
        	   
        	   if(sender.getName().equalsIgnoreCase((String) config.get("Earth.Admin.UserName"))){

          	 		sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "Your Clan Ballance Is " + ChatColor.GREEN + "$" + config.get("Earth.Admin.Ballance"));
        
          	 		plugin.saveConfig();
          	 		
               	}
        	   
        	   
        	   
        	   if(sender.getName().equalsIgnoreCase((String) config.get("Water.Admin.UserName"))){

          	 		sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "Your Clan Ballance Is " + ChatColor.GREEN + "$" + config.get("Water.Admin.Ballance"));
        
          	 		plugin.saveConfig();
          	 		
               	}
        	   
        	   
        	   if(sender.getName().equalsIgnoreCase((String) config.get("Fire.Admin.UserName"))){

          	 		sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "Your Clan Ballance Is " + ChatColor.GREEN + "$" + config.get("Fire.Admin.Ballance"));
        
          	 		plugin.saveConfig();
          	 		
               	}else{
        		
        	 sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_RED + "You Are Not The Clan Leader!");
        		
        	}

        	return true;	
        
        
        }else if((commandLabel.equalsIgnoreCase("CvC") && args[0].equalsIgnoreCase("Shop"))){
        	
        //	FileConfiguration config = plugin.getConfig();
     	   
        	 if(sender instanceof Player){
        	
     	   
     	

     	
     	 
     	 
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
   		CobbleLore.add("Cobblstone Is Worth $32 For 32");
   		CobbleLore.add("Click Me To Sell 32x Cobble Stone");
   		Cobblemeta.setLore(CobbleLore);
   		Cobbleitem.setItemMeta(Cobblemeta);
  		
     	  
   	 ItemStack Iron_Ore = new ItemStack(Material.IRON_ORE);
		ItemMeta Iron_Ore_Meta = Iron_Ore.getItemMeta();
		Iron_Ore_Meta.setDisplayName("Sell Iron Ore");
		ArrayList<String> Iron_Ore_Lore = new ArrayList<String>();
		Iron_Ore_Lore.add("Iron Ore Is Worth $100");
		Iron_Ore_Lore.add("Click Me To Sell 32x Iron Ore");
		Iron_Ore_Meta.setLore(Iron_Ore_Lore);
		Iron_Ore.setItemMeta(Iron_Ore_Meta);
	
		
		ItemStack Gold_Ore = new ItemStack(Material.GOLD_ORE);
		ItemMeta Gold_Ore_Meta = Gold_Ore.getItemMeta();
		Gold_Ore_Meta.setDisplayName("Sell Gold Ore");
		ArrayList<String> Gold_Ore_Lore = new ArrayList<String>();
		Gold_Ore_Lore.add("Gold Ore Is Worth $150");
		Gold_Ore_Lore.add("Click Me To Sell 8x Gold Ore");
		Gold_Ore_Meta.setLore(Gold_Ore_Lore);
		Gold_Ore.setItemMeta(Gold_Ore_Meta);
		
		
		ItemStack Lapis_Ore = new ItemStack(Material.LAPIS_ORE);
		ItemMeta Lapis_Ore_Meta = Lapis_Ore.getItemMeta();
		Lapis_Ore_Meta.setDisplayName("Sell Lapis Ore");
		ArrayList<String> Lapis_Ore_Lore = new ArrayList<String>();
		Lapis_Ore_Lore.add("Lapis Ore Is Worth $300");
		Lapis_Ore_Lore.add("Click Me To Sell 1x Lapis Ore");
		Lapis_Ore_Meta.setLore(Lapis_Ore_Lore);
		Lapis_Ore.setItemMeta(Lapis_Ore_Meta);
		
		
		ItemStack RedStone_Ore = new ItemStack(Material.REDSTONE_ORE);
		ItemMeta RedStone_Ore_Meta = RedStone_Ore.getItemMeta();
		RedStone_Ore_Meta.setDisplayName("Sell RedStone Ore");
		ArrayList<String> RedStone_Ore_Lore = new ArrayList<String>();
		RedStone_Ore_Lore.add("Iron Ore Is Worth $400");
		RedStone_Ore_Lore.add("Click Me To Sell 8x RedStone Ore");
		RedStone_Ore_Meta.setLore(RedStone_Ore_Lore);
		RedStone_Ore.setItemMeta(RedStone_Ore_Meta);
		
		ItemStack Iron_Ingot = new ItemStack(Material.IRON_INGOT);
		ItemMeta Iron_Ingot_Meta = Iron_Ingot.getItemMeta();
		Iron_Ingot_Meta.setDisplayName("Sell Iron Ingots");
		ArrayList<String> Iron_Ingot_Lore = new ArrayList<String>();
		Iron_Ingot_Lore.add("Iron Ingot Is Worth $150");
		Iron_Ingot_Lore.add("Click Me To Sell 8x Iron Ingot");
		Iron_Ingot_Meta.setLore(Iron_Ingot_Lore);
		Iron_Ingot.setItemMeta(Iron_Ingot_Meta);
		
		
		ItemStack Gold_Ingots = new ItemStack(Material.GOLD_INGOT);
		ItemMeta Gold_Ingots_Meta = Gold_Ingots.getItemMeta();
		Gold_Ingots_Meta.setDisplayName("Sell Gold Ingots");
		ArrayList<String> Gold_Ingots_Lore = new ArrayList<String>();
		Gold_Ingots_Lore.add("Gold Ingot Is Worth $250");
		Gold_Ingots_Lore.add("Click Me To Sell 8x Gold Ingot");
		Gold_Ingots_Meta.setLore(Gold_Ingots_Lore);
		Gold_Ingots.setItemMeta(Gold_Ingots_Meta);
		
		
		ItemStack RedStone = new ItemStack(Material.REDSTONE);
		ItemMeta RedStone_Meta = RedStone.getItemMeta();
		RedStone_Meta.setDisplayName("Sell RedStone");
		ArrayList<String> RedStone_Lore = new ArrayList<String>();
		RedStone_Lore.add("RedStone Is Worth $300");
		RedStone_Lore.add("Click Me To Sell 8x RedStone");
		RedStone_Meta.setLore(RedStone_Lore);
		RedStone.setItemMeta(RedStone_Meta);
		
		
		ItemStack Obsidian = new ItemStack(Material.OBSIDIAN);
		ItemMeta Obsidian_Meta = Obsidian.getItemMeta();
		Obsidian_Meta.setDisplayName("Sell Obsidian");
		ArrayList<String> Obsidian_Lore = new ArrayList<String>();
		Obsidian_Lore.add("Obsidian Is Worth $400");
		Obsidian_Lore.add("Click Me To Sell 8x Obsidian");
		Obsidian_Meta.setLore(Obsidian_Lore);
		Obsidian.setItemMeta(Obsidian_Meta);
		
		
		ItemStack GlowStone_Block = new ItemStack(Material.GLOWSTONE);
		ItemMeta GlowStone_Block_Meta = Obsidian.getItemMeta();
		GlowStone_Block_Meta.setDisplayName("Sell Obsidian");
		ArrayList<String> GlowStone_Block_Lore = new ArrayList<String>();
		GlowStone_Block_Lore.add("GlowStone Blocks Is Worth $600");
		GlowStone_Block_Lore.add("Click Me To Sell 8x GlowStone Blocks");
		GlowStone_Block_Meta.setLore(GlowStone_Block_Lore);
		GlowStone_Block.setItemMeta(GlowStone_Block_Meta);
		
		
		ItemStack BlazeRod = new ItemStack(Material.BLAZE_ROD);
		ItemMeta BlazeRod_Meta = BlazeRod.getItemMeta();
		BlazeRod_Meta.setDisplayName("Sell Blaze Rods");
		ArrayList<String> BlazeRod_Lore = new ArrayList<String>();
		BlazeRod_Lore.add("Blaze Rods Is Worth $800");
		BlazeRod_Lore.add("Click Me To Sell 8x Blaze Rods");
		BlazeRod_Meta.setLore(BlazeRod_Lore);
		BlazeRod.setItemMeta(BlazeRod_Meta);
		

		
		 ItemStack PaperBuy = new ItemStack(Material.ANVIL);
	  		ItemMeta PaperBuymeta = PaperBuy.getItemMeta();
	  		PaperBuymeta.setDisplayName("Go To Buy");
	  		PaperBuy.setItemMeta(PaperBuymeta);
		
	  		 ItemStack PaperSell = new ItemStack(Material.PAPER);
		  		ItemMeta PaperSellmeta = PaperSell.getItemMeta();
		  		PaperSellmeta.setDisplayName("Go To Sell");
		  		PaperSell.setItemMeta(PaperSellmeta);
		  		
		  		
		  		
		  		// Buy Menu
		  		
		  		
		  		ItemStack DiamondHead = new ItemStack(Material.DIAMOND_HELMET);
				ItemMeta DiamondHead_Meta = DiamondHead.getItemMeta();
				DiamondHead_Meta.setDisplayName("Diamond Helmet");
				ArrayList<String> DiamondHeadLore = new ArrayList<String>();
				DiamondHeadLore.add("This Helmet Costs $2000");
				DiamondHeadLore.add("Click Me To Buy!");
				DiamondHead_Meta.setLore(DiamondHeadLore);
				DiamondHead.setItemMeta(DiamondHead_Meta);
				DiamondHead.addEnchantment(Enchantment.OXYGEN, 3);
		  		DiamondHead.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		  		DiamondHead.addEnchantment(Enchantment.WATER_WORKER, 1);
		  		
		  	
			  		
			  		ItemStack DiamondChest = new ItemStack(Material.DIAMOND_CHESTPLATE);
			  		ItemMeta DiamondChestMeta = DiamondChest.getItemMeta();
			  		DiamondChestMeta.setDisplayName("Diamond Chestplate");
			  		DiamondChest.setItemMeta(DiamondChestMeta);
					ArrayList<String> DiamondChest_Lore = new ArrayList<String>();
			  		DiamondChest_Lore.add("This Chestplate Costs $5000");
			  		DiamondChest_Lore.add("Click Me To Buy!");
			  		DiamondChestMeta.setLore(DiamondChest_Lore);
			  		DiamondChest.setItemMeta(DiamondChestMeta);
			  		DiamondChest.addEnchantment(Enchantment.PROTECTION_FIRE, 4);
			  		DiamondChest.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
			  		DiamondChest.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 4);
	  		
			  		
			  		ItemStack DiamondLegs = new ItemStack(Material.DIAMOND_LEGGINGS);
			  		ItemMeta DiamondLegsMeta = DiamondLegs.getItemMeta();
			  		DiamondLegsMeta.setDisplayName("Diamond Legsplate");
			  		DiamondLegs.setItemMeta(DiamondLegsMeta);
					ArrayList<String> DiamondLegs_Lore = new ArrayList<String>();
			  		DiamondLegs_Lore.add("These Leggings Costs $3500");
			  		DiamondLegs_Lore.add("Click Me To Buy!");
			  		DiamondLegsMeta.setLore(DiamondLegs_Lore);
			  		DiamondLegs.setItemMeta(DiamondLegsMeta);
			  		DiamondLegs.addEnchantment(Enchantment.PROTECTION_FIRE, 4);
			  		DiamondLegs.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
			  		DiamondLegs.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 4);
			  		
			  		
			  		
			  		ItemStack DiamondBoots = new ItemStack(Material.DIAMOND_BOOTS);
			  		ItemMeta DiamondBootsMeta = DiamondBoots.getItemMeta();
			  		DiamondBootsMeta.setDisplayName("Diamond Boots");
			  		DiamondBoots.setItemMeta(DiamondBootsMeta);
					ArrayList<String> DiamondBoots_Lore = new ArrayList<String>();
			  		DiamondBoots_Lore.add("These Boots Costs $3200");
			  		DiamondBoots_Lore.add("Click Me To Buy!");
			  		DiamondBootsMeta.setLore(DiamondBoots_Lore);
			  		DiamondBoots.setItemMeta(DiamondBootsMeta);
			  		DiamondBoots.addEnchantment(Enchantment.PROTECTION_FIRE, 4);
			  		DiamondBoots.addEnchantment(Enchantment.PROTECTION_FALL, 4);
			  		
			  		
			  		ItemStack DiamondSword = new ItemStack(Material.DIAMOND_SWORD);
			  		ItemMeta DiamondSwordMeta = DiamondSword.getItemMeta();
			  		DiamondSwordMeta.setDisplayName("Diamond Sword");
			  		DiamondSword.setItemMeta(DiamondSwordMeta);
					ArrayList<String> DiamondSword_Lore = new ArrayList<String>();
			  		DiamondSword_Lore.add("This Sword Costs $10000");
			  		DiamondSword_Lore.add("Click Me To Buy!");
			  		DiamondSwordMeta.setLore(DiamondSword_Lore);
			  		DiamondSword.setItemMeta(DiamondSwordMeta);
			  		DiamondSword.addEnchantment(Enchantment.DAMAGE_ALL, 5);
			  		DiamondSword.addEnchantment(Enchantment.DURABILITY, 3);
			  		DiamondSword.addEnchantment(Enchantment.FIRE_ASPECT, 2);
			  		DiamondSword.addEnchantment(Enchantment.LOOT_BONUS_MOBS, 3);
			  		
			  		
			  		ItemStack DiamondPickAxe = new ItemStack(Material.DIAMOND_PICKAXE);
			  		ItemMeta DiamondPickAxeMeta = DiamondPickAxe.getItemMeta();
			  		DiamondPickAxeMeta.setDisplayName("Diamond Pickaxe");
			  		DiamondPickAxe.setItemMeta(DiamondPickAxeMeta);
					ArrayList<String> DiamondPickAxe_Lore = new ArrayList<String>();
			  		DiamondPickAxe_Lore.add("This Pickaxe Costs $10000");
			  		DiamondPickAxe_Lore.add("Click Me To Buy!");
			  		DiamondPickAxeMeta.setLore(DiamondPickAxe_Lore);
			  		DiamondPickAxe.setItemMeta(DiamondPickAxeMeta);
			  		DiamondPickAxe.addEnchantment(Enchantment.DIG_SPEED, 5);
			  		DiamondPickAxe.addEnchantment(Enchantment.DURABILITY, 3);
			  		DiamondPickAxe.addEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 2);
			  		
			  		
			  		
			  		ItemStack DiamondAxe = new ItemStack(Material.DIAMOND_AXE);
			  		ItemMeta DiamondAxeMeta = DiamondAxe.getItemMeta();
			  		DiamondAxeMeta.setDisplayName("Diamond Axe");
			  		DiamondAxe.setItemMeta(DiamondAxeMeta);
					ArrayList<String> DiamondAxe_Lore = new ArrayList<String>();
			  		DiamondAxe_Lore.add("This axe Costs $10000");
			  		DiamondAxe_Lore.add("Click Me To Buy!");
			  		DiamondAxeMeta.setLore(DiamondAxe_Lore);
			  		DiamondAxe.setItemMeta(DiamondAxeMeta);
			  		DiamondAxe.addEnchantment(Enchantment.DIG_SPEED, 5);
			  		DiamondAxe.addEnchantment(Enchantment.DURABILITY, 3);
			  		DiamondAxe.addEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 2);
			  		
			  		
			  		
			  		ItemStack DiamondShovel = new ItemStack(Material.DIAMOND_SPADE);
			  		ItemMeta DiamondShovelMeta = DiamondShovel.getItemMeta();
			  		DiamondShovelMeta.setDisplayName("Diamond Spade");
			  		DiamondShovel.setItemMeta(DiamondShovelMeta);
					ArrayList<String> DiamondShovel_Lore = new ArrayList<String>();
			  		DiamondShovel_Lore.add("This Shovel Costs $10000");
			  		DiamondShovel_Lore.add("Click Me To Buy!");
			  		DiamondShovelMeta.setLore(DiamondShovel_Lore);
			  		DiamondShovel.setItemMeta(DiamondShovelMeta);
			  		DiamondShovel.addEnchantment(Enchantment.DIG_SPEED, 5);
			  		DiamondShovel.addEnchantment(Enchantment.DURABILITY, 3);
			  		DiamondShovel.addEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 2);
			  		
			  		
			  		
			  		
			  		
		
   		// Puts The Items In The Inventories //
		
		// Row One //
		
  		ClanSellInventory.setItem(0, item);
  		
  		ClanSellInventory.setItem(1, Cobbleitem);
  		
  		ClanSellInventory.setItem(2, Iron_Ore);
  		
  		ClanSellInventory.setItem(3, Gold_Ore);
  		
  		ClanSellInventory.setItem(4, Lapis_Ore);
  		
  		ClanSellInventory.setItem(5, RedStone_Ore);
  		
  		ClanSellInventory.setItem(6, Iron_Ingot);
  		
  		ClanSellInventory.setItem(7, Gold_Ingots);
  		
  		ClanSellInventory.setItem(8, RedStone);
  		
  		
  		// Row Two //
  		

  		
  		ClanSellInventory.setItem(12, Obsidian);
  		
  		ClanSellInventory.setItem(13, GlowStone_Block);
  		
  		ClanSellInventory.setItem(14, BlazeRod);
  		
  		ClanSellInventory.setItem(17, PaperBuy);
  		
  		
  		ClanMainInventory.setItem(0, PaperBuy);
  		
  		ClanMainInventory.setItem(8, PaperSell);
  		
  		
  		
  		ClanBuyInventory.setItem(17, PaperSell);
     	   
  		
     	 ClanBuyInventory.setItem(2, DiamondHead);
		
     	 ClanBuyInventory.setItem(3, DiamondChest);
     	 
     	ClanBuyInventory.setItem(4, DiamondLegs);
     	
     	ClanBuyInventory.setItem(5, DiamondBoots);
     	
     	ClanBuyInventory.setItem(6, DiamondSword);
     	
     	ClanBuyInventory.setItem(12, DiamondPickAxe);
     	
     	ClanBuyInventory.setItem(13, DiamondAxe);
     	
     	ClanBuyInventory.setItem(14, DiamondShovel);
     	
     	
     	
     	 
     		  Player player = (Player) sender;
     		  
     		 player.openInventory(ClanMainInventory);
     		  
     		// config.set("Air.Admin.Ballance", 1000);
     		 
     		plugin.saveConfig();
     			
     		
     		
     		 
     		
     	
     		
     	  } 
     	  
     	   
     	   
     	   return true;
     	   
     	   
        }else if((commandLabel.equalsIgnoreCase("CvC") && args[0].equalsIgnoreCase("EnlargeCost"))){
        	
        	sender.sendMessage("CVC 1");
        	
        	
        	return true;
        	
        }else if((commandLabel.equalsIgnoreCase("CvC") && args[0].equalsIgnoreCase("Enlarge"))){

        	
        	
        	return true;
        	
        }else if((commandLabel.equalsIgnoreCase("CvC") && args[0].equalsIgnoreCase("SetHome"))){
        	
        	FileConfiguration config = plugin.getConfig();
        	if(sender instanceof Player){
        		
        		Player player = (Player) sender;
        		
        		Location Loc = player.getLocation();
        		
        		String world = player.getWorld().getName();
        		
        	
        	
        	
        	 if(sender.getName().equalsIgnoreCase((String) config.get("Air.Admin.UserName"))){
        		 
        		config.set("Air.Home.World", world); 
        		config.set("Air.Home.X", Loc.getX());
        		config.set("Air.Home.Y", Loc.getY());
        		config.set("Air.Home.Z", Loc.getZ());
         		
        		plugin.saveConfig();
        		
        		player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "You Have Created A Clan Home.");
             	
        		return true;
        		
        	 }
        	 
        		 if(sender.getName().equalsIgnoreCase((String) config.get("Earth.Admin.UserName"))){
        			 
        			 config.set("Earth.Home.World", world); 
        			 config.set("Earth.Home.X", Loc.getX());
             		config.set("Earth.Home.Y", Loc.getY());
             		config.set("Earth.Home.Z", Loc.getZ());
              		
             		plugin.saveConfig();
             		
             		player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "You Have Created A Clan Home.");
        		 
             		return true;
             		
        		 }
             		
        			 if(sender.getName().equalsIgnoreCase((String) config.get("Water.Admin.UserName"))){
        				 	
        				 	config.set("Water.Home.World", world); 
        				 	config.set("Water.Home.X", Loc.getX());
        	        		config.set("Water.Home.Y", Loc.getY());
        	        		config.set("Water.Home.Z", Loc.getZ());
        	         		
        	        		plugin.saveConfig();
        	        		
        	        		player.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "You Have Created A Clan Home.");
        	        		
        	        		return true;
        	        		
        			 }
        			 
        				 if(sender.getName().equalsIgnoreCase((String) config.get("Fire.Admin.UserName"))){
        					 
        					 config.set("Fire.Home.World", world); 
        					 config.set("Fire.Home.X", Loc.getX());
        		        		config.set("Fire.Home.Y", Loc.getY());
        		        		config.set("Fire.Home.Z", Loc.getZ());
        		         		
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
        	
        	List<String> Air = config.getStringList("Air.Players.Names");

        	List<String> Earth = config.getStringList("Earth.Players.Names");

        	List<String> Water = config.getStringList("Water.Players.Names");

        	List<String> Fire = config.getStringList("Fire.Players.Names");
        	
        	if(sender instanceof Player){
        		
        		Player player = (Player) sender;
        	
        		if(Air.contains(player.getName())){
        		
        		player.teleport(new Location(Bukkit.getWorld(config.get("Air.Home.World").toString()), config.getDouble("Air.Home.X"), config.getDouble("Air.Home.Y"), config.getDouble("Air.Home.Z")));
        		
        		return true;
        		}
        		
        		if(Earth.contains(player.getName())){
            		
            		player.teleport(new Location((World) config.get("Earth.Home.World"), config.getDouble("Earth.Home.X"), config.getDouble("Earth.Home.Y"), config.getDouble("Earth.Home.Z")));
            		
            		return true;
            		}
        		
        		if(Water.contains(player.getName())){
            		
            		player.teleport(new Location((World) config.get("Water.Home.World"), config.getDouble("Water.Home.X"), config.getDouble("Water.Home.Y"), config.getDouble("Water.Home.Z")));
            		
            		return true;
            		}
        		
        		if(Fire.contains(player.getName())){
            		
            		player.teleport(new Location((World) config.get("Fire.Home.World"), config.getDouble("Fire.Home.X"), config.getDouble("Fire.Home.Y"), config.getDouble("Fire.Home.Z")));
            		
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
