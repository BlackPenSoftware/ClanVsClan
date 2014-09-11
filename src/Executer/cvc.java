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
	 
  public static Inventory ClanMainInventory = Bukkit.createInventory(null, 18, "Clan Main");
    
    
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
        if((commandLabel.equalsIgnoreCase("CvC") && args.length == 0)){
            if(sender instanceof Player){
            	@SuppressWarnings("unused")
				Player player = (Player) sender;
  
                  sender.sendMessage(ChatColor.GOLD + "==================[CvC 1 / 2]===================");

				  sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GREEN + "/CvC SetAdmin (Clan Number / Name) (Player Name)" + ChatColor.DARK_PURPLE + " This Command Is Used To Assign Clan Admins.");
				  
				  sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.GREEN + "/CvC ExpandCost " + ChatColor.DARK_PURPLE + "This Command Allows For The Admins Of The Clan To Check How Much It Will Cost To Expand Their Claim To The Next Size."); 
				  
				  sender.sendMessage(ChatColor.GOLD + "================================================");
				  

            }
            
            return true;
            
            
            	
            }else if((commandLabel.equalsIgnoreCase("CvC") && args[0].equalsIgnoreCase("Bal"))){
            	
            	FileConfiguration config = plugin.getConfig(); 
            	
            	List<String> Clan_1 = config.getStringList("Clan_1.Players.Names");

        		List<String> Clan_2 = config.getStringList("Clan_2.Players.Names");

        		List<String> Clan_3 = config.getStringList("Clan_3.Players.Names");

        		List<String> Clan_4 = config.getStringList("Clan_4.Players.Names");
            	
            	 
            	 
            	if(sender instanceof Player){
            		if(Clan_1.contains(((Player) sender).getDisplayName())){
            			sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "Your Personal Balance Is " + ChatColor.GREEN + "$" + config.get("Clan_1.Players." + sender.getName().toString() + ".Bal"));
            		}
            		
            		if(Clan_2.contains(((Player) sender).getDisplayName())){
            			sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "Your Personal Balance Is " + ChatColor.GREEN + "$" + config.get("Clan_2.Players." + sender.getName().toString() + ".Bal"));
            		}
            		
            		if(Clan_3.contains(((Player) sender).getDisplayName())){
            			sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "Your Personal Balance Is " + ChatColor.GREEN + "$" + config.get("Clan_3.Players." + sender.getName().toString() + ".Bal"));
            		}
            		
            		if(Clan_4.contains(((Player) sender).getDisplayName())){
            			sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "Your Personal Balance Is " + ChatColor.GREEN + "$" + config.get("Clan_4.Players." + sender.getName().toString() + ".Bal"));
            		}
            	 }
            	
            	return true;
            	
            }else if((commandLabel.equalsIgnoreCase("CvC") && args[0].equalsIgnoreCase("Expand"))){
             
            	   FileConfiguration config = plugin.getConfig();
            	   
            	  
            	   if( (Integer)config.get("Clan_1.Land.ClaimSize.Size") >= 1000 ){
            		   
        			   sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "Your Clan Is Already At Max Size: " + (Integer)config.get("Clan_1.Land.ClaimSize.Size") + "x" + (Integer)config.get("Clan_1.Land.ClaimSize.Size"));
          			 
        				return true;
        			   
        		   
        		   }
            	   
            	   if( (Integer)config.get("Clan_2.Land.ClaimSize.Size") >= 1000){
            		   
        			   sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "Your Clan Is Already At Max Size: " + (Integer)config.get("Clan_2.Land.ClaimSize.Size") + "x" + (Integer)config.get("Clan_2.Land.ClaimSize.Size"));
          			 
        		   
        				return true;
        			   
        		   }
  
  
  
            	   if( (Integer)config.get("Clan_3.Land.ClaimSize.Size") >= 1000){
	   
            		   	sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "Your Clan Is Already At Max Size: " + (Integer)config.get("Clan_3.Land.ClaimSize.Size") + "x" + (Integer)config.get("Clan_3.Land.ClaimSize.Size"));
		 
            			return true;
  
            	   }
  
  
  
            	   if( (Integer)config.get("Clan_4.Land.ClaimSize.Size") >= 1000){
	   
            		   		sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "Your Clan Is Already At Max Size: " + (Integer)config.get("Clan_4.Land.ClaimSize.Size") + "x" + (Integer)config.get("Clan_4.Land.ClaimSize.Size"));
		 
            		   		return true;
            		   		
  
            	   }
            	   
            	   
            	   
            	   if(sender.getName().equalsIgnoreCase((String) config.get("Clan_1.Admin.UserName"))){
            		   

            		   
            		   //int Clan_1_Bal = plugin.getConfig().getInt("Clan_1.Admin.Ballance");
            		   
            		   int bal = plugin.getConfig().getInt("Clan_1.Admin.Ballance");
            		   
            		   //int claim = plugin.getConfig().getInt("Clan_1.Land.ClaimSize");
            		   
            		   if( bal >= (Integer)config.get("Clan_1.Land.ClaimSize.Size") * 500 && (Integer)config.get("Clan_1.Land.ClaimSize.Size") < 1000){
            			   
            			   
            			 
            			   
            			   config.set("Clan_1.Admin.Ballance", (Integer)config.get("Clan_1.Admin.Ballance") - (Integer)config.get("Clan_1.Land.ClaimSize.Size") * 500);
            			  
            			   
            			   config.set("Clan_1.Land.ClaimSize.Size", (Integer)config.get("Clan_1.Land.ClaimSize.Size") + 100);
            			   
            			
            			   plugin.saveConfig();
            			   
            			  
                		   sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "You Have Expanded Your Clan's Claim To " + (Integer)config.get("Clan_1.Land.ClaimSize.Size") + "x" + (Integer)config.get("Clan_1.Land.ClaimSize.Size"));
            			 
            	
                		return true;
            		  
            		   
            	   }
            	   
            	   
            	   
            	   
                		   if(sender.getName().equalsIgnoreCase((String) config.get("Clan_2.Admin.UserName"))){
                    		   

                    		   
                    		   //int Clan_1_Bal = plugin.getConfig().getInt("Clan_1.Admin.Ballance");
                    		   
                    		   int bal_2 = plugin.getConfig().getInt("Clan_2.Admin.Ballance");
                    		   
                    		   //int claim = plugin.getConfig().getInt("Clan_1.Land.ClaimSize");
                    		   
                    		   if( bal_2 >= (Integer)config.get("Clan_2.Land.ClaimSize.Size") * 500 && (Integer)config.get("Clan_2.Land.ClaimSize.Size") < 1000){
                    			   
                    			   
                    			 
                    			   
                    			   config.set("Clan_2.Admin.Ballance", (Integer)config.get("Clan_2.Admin.Ballance") - (Integer)config.get("Clan_2.Land.ClaimSize.Size") * 500);
                    			  
                    			   
                    			   config.set("Clan_2.Land.ClaimSize.Size", (Integer)config.get("Clan_2.Land.ClaimSize.Size") + 100);
                    			   
                    			
                    			   plugin.saveConfig();
                    			   
                    			  
                        		   sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "You Have Expanded Your Clan's Claim To " + (Integer)config.get("Clan_2.Land.ClaimSize.Size") + "x" + (Integer)config.get("Clan_2.Land.ClaimSize.Size"));
                    			 
                    	
                        			return true;
                    		  
                    		   
                    	   }
            	   
            	   
                    		   if(sender.getName().equalsIgnoreCase((String) config.get("Clan_3.Admin.UserName"))){
                        		   

                        		   
                        		   //int Clan_1_Bal = plugin.getConfig().getInt("Clan_1.Admin.Ballance");
                        		   
                        		   int bal_3 = plugin.getConfig().getInt("Clan_3.Admin.Ballance");
                        		   
                        		   //int claim = plugin.getConfig().getInt("Clan_1.Land.ClaimSize");
                        		   
                        		   if( bal_3 >= (Integer)config.get("Clan_3.Land.ClaimSize.Size") * 500 && (Integer)config.get("Clan_3.Land.ClaimSize.Size") < 1000){
                        			   
                        			   
                        			 
                        			   
                        			   config.set("Clan_3.Admin.Ballance", (Integer)config.get("Clan_3.Admin.Ballance") - (Integer)config.get("Clan_3.Land.ClaimSize.Size") * 500);
                        			  
                        			   
                        			   config.set("Clan_3.Land.ClaimSize.Size", (Integer)config.get("Clan_3.Land.ClaimSize.Size") + 100);
                        			   
                        			
                        			   plugin.saveConfig();
                        			   
                        			  
                            		   sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "You Have Expanded Your Clan's Claim To " + (Integer)config.get("Clan_3.Land.ClaimSize.Size") + "x" + (Integer)config.get("Clan_3.Land.ClaimSize.Size"));
                        			 
                        	
                            			return true;
                        		  
                        		   
                        	   }
                        		   
                        		   if(sender.getName().equalsIgnoreCase((String) config.get("Clan_4.Admin.UserName"))){
                            		   

                            		   
                            		   //int Clan_1_Bal = plugin.getConfig().getInt("Clan_1.Admin.Ballance");
                            		   
                            		   int bal_4 = plugin.getConfig().getInt("Clan_4.Admin.Ballance");
                            		   
                            		   //int claim = plugin.getConfig().getInt("Clan_1.Land.ClaimSize");
                            		   
                            		   if( bal_4 >= (Integer)config.get("Clan_4.Land.ClaimSize.Size") * 500 && (Integer)config.get("Clan_4.Land.ClaimSize.Size") < 1000){
                            			   
                            			   
                            			 
                            			   
                            			   config.set("Clan_4.Admin.Ballance", (Integer)config.get("Clan_4.Admin.Ballance") - (Integer)config.get("Clan_4.Land.ClaimSize.Size") * 500);
                            			  
                            			   
                            			   config.set("Clan_4.Land.ClaimSize.Size", (Integer)config.get("Clan_4.Land.ClaimSize.Size") + 100);
                            			   
                            			
                            			   plugin.saveConfig();
                            			   
                            			  
                                		   sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "You Have Expanded Your Clan's Claim To " + (Integer)config.get("Clan_4.Land.ClaimSize.Size") + "x" + (Integer)config.get("Clan_4.Land.ClaimSize.Size"));
                            			 
                            	
                                		
                                			return true;
                            		   
                            	   }
                            		   
                            		   
                        		   }
                    		   }
                	
                		   }
                	
            	   }
                		   
                		   return true;
                		   
                		   
          
            }else if((commandLabel.equalsIgnoreCase("CvC") && args[0].equalsIgnoreCase("ExpandCost"))){
                
         	   FileConfiguration config = plugin.getConfig();
         	 
         	  List<String> Clan_1 = config.getStringList("Clan_1.Players.Names");

         		List<String> Clan_2 = config.getStringList("Clan_2.Players.Names");

         		List<String> Clan_3 = config.getStringList("Clan_3.Players.Names");

         		List<String> Clan_4 = config.getStringList("Clan_4.Players.Names");
         		
         		if(Clan_1.contains(sender.getName())){
         			
         			int ClaimSize_1 = (Integer)config.get("Clan_1.Land.ClaimSize.Size");
         			
         			if(ClaimSize_1 < 1000){
         			
         			sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + " To Expand Your Clans Claim To " + ChatColor.GOLD + ClaimSize_1 + ChatColor.DARK_PURPLE + "x" + ChatColor.GOLD + ClaimSize_1 + ChatColor.DARK_PURPLE + " Your Clan Needs " + ChatColor.GOLD + "$" + (ClaimSize_1 + 100) * 500);
         			
         			
         			}else{
         				
         				sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "Your Clan Is At Max Size");
         				
         			}
         			 return true;
         		}
         		
         			if(Clan_2.contains(sender.getName())){
         			
         				int ClaimSize_2 = (Integer)config.get("Clan_2.Land.ClaimSize.Size");
             			
             			if(ClaimSize_2 < 1000){
             			
             			sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + " To Expand Your Clans Claim To " + ChatColor.GOLD + ClaimSize_2 + ChatColor.DARK_PURPLE + "x" + ChatColor.GOLD + ClaimSize_2 + ChatColor.DARK_PURPLE + " Your Clan Needs " + ChatColor.GOLD + "$" + (ClaimSize_2 + 100) * 500);
             			
             			
             			}else{
             				
             				sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "Your Clan Is At Max Size");
             				
             			}
             			 return true;
         				}

         					if(Clan_3.contains(sender.getName())){
		
         						int ClaimSize_3 = (Integer)config.get("Clan_3.Land.ClaimSize.Size");
         	         			
         	         			if(ClaimSize_3 < 1000){
         	         			
         	         			sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + " To Expand Your Clans Claim To " + ChatColor.GOLD + ClaimSize_3 + ChatColor.DARK_PURPLE + "x" + ChatColor.GOLD + ClaimSize_3 + ChatColor.DARK_PURPLE + " Your Clan Needs " + ChatColor.GOLD + "$" + (ClaimSize_3 + 100) * 500);
         	         			
         	         			
         	         			}else{
         	         				
         	         				sender.sendMessage(ChatColor.BLUE + "[Clan Vs Clan] " + ChatColor.DARK_PURPLE + "Your Clan Is At Max Size");
         	         				
         	         			}
         	         			 return true;
         						}

         							if(Clan_4.contains(sender.getName())){
		
         								int ClaimSize_4 = (Integer)config.get("Clan_4.Land.ClaimSize.Size");
         			         			
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
			  		DiamondChest_Lore.add("This Helmet Costs $5000");
			  		DiamondChest_Lore.add("Click Me To Buy!");
			  		DiamondChest.addEnchantment(Enchantment.PROTECTION_FIRE, 4);
			  		DiamondChest.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
			  		DiamondChest.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 4);
	  		
			  		
			  		ItemStack DiamondLegs = new ItemStack(Material.DIAMOND_LEGGINGS);
			  		ItemMeta DiamondLegsMeta = DiamondLegs.getItemMeta();
			  		DiamondLegsMeta.setDisplayName("Diamond Chestplate");
			  		DiamondLegs.setItemMeta(DiamondLegsMeta);
					ArrayList<String> DiamondLegs_Lore = new ArrayList<String>();
			  		DiamondLegs_Lore.add("This Helmet Costs $3500");
			  		DiamondLegs_Lore.add("Click Me To Buy!");
			  		DiamondLegs.addEnchantment(Enchantment.PROTECTION_FIRE, 4);
			  		DiamondLegs.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
			  		DiamondLegs.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 4);
			  		
			  		
			  		
			  		ItemStack DiamondBoots = new ItemStack(Material.DIAMOND_BOOTS);
			  		ItemMeta DiamondBootsMeta = DiamondBoots.getItemMeta();
			  		DiamondBootsMeta.setDisplayName("Diamond Boots");
			  		DiamondBoots.setItemMeta(DiamondBootsMeta);
					ArrayList<String> DiamondBoots_Lore = new ArrayList<String>();
			  		DiamondBoots_Lore.add("This Helmet Costs $3200");
			  		DiamondBoots_Lore.add("Click Me To Buy!");
			  		DiamondBoots.addEnchantment(Enchantment.PROTECTION_FIRE, 4);
			  		DiamondBoots.addEnchantment(Enchantment.PROTECTION_FALL, 4);
			  		
			  		
			  		ItemStack DiamondSword = new ItemStack(Material.DIAMOND_SWORD);
			  		ItemMeta DiamondSwordMeta = DiamondSword.getItemMeta();
			  		DiamondSwordMeta.setDisplayName("Diamond Sword");
			  		DiamondSword.setItemMeta(DiamondSwordMeta);
					ArrayList<String> DiamondSword_Lore = new ArrayList<String>();
			  		DiamondSword_Lore.add("This Sword Costs $10000");
			  		DiamondSword_Lore.add("Click Me To Buy!");
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
  		
  		
  		ClanMainInventory.setItem(4, PaperBuy);
  		
  		ClanMainInventory.setItem(13, PaperSell);
  		
  		
  		
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
     		  
     		// config.set("Clan_1.Admin.Ballance", 1000);
     		 
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
