package dev_Tools.demonek.listeners;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import dev_Tools.demonek.Main;

public class Stoniarka {

	public static void createRecipe(){
		ItemStack sg = new ItemStack(Material.ENDER_STONE, 1);;
	    ShapedRecipe stonegenerator = new ShapedRecipe(sg).shape(new String[] { 
	      "ABC", 
	      "DEF", 
	      "GHI" })
	      .setIngredient('A', Material.REDSTONE)
	      .setIngredient('B', Material.STONE)
	      .setIngredient('C', Material.REDSTONE)
	      
	      .setIngredient('D', Material.STONE)
	      .setIngredient('E', Material.PISTON_BASE)
	      .setIngredient('F', Material.STONE)
	      
	      .setIngredient('G', Material.REDSTONE)
	      .setIngredient('H', Material.STONE)
	      .setIngredient('I', Material.REDSTONE);
	    Main.getInstance().getServer().addRecipe(stonegenerator); 
	}
}