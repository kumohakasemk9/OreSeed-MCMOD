import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "ucompprogrammer-ore_seed_mod",name = "Ore Seed Mod",version="0.1")
public class OreSeedCore {
	public static Block oreSeedbkobj;
	public static Item oreSeedObj;
	@EventHandler
	public void preInit(FMLPreInitializationEvent ev) {
		oreSeedbkobj = new OreSeed();
		oreSeedObj = new OreSeedItem();
		GameRegistry.registerItem(oreSeedObj, "oreseedmod.oreseed");
		GameRegistry.registerBlock(oreSeedbkobj, "oreseedmod.oreseedblock");
		GameRegistry.addRecipe(new ItemStack(oreSeedObj,16), "cic","csc","cic",'i',Items.iron_ingot,'s',Items.wheat_seeds,'c',Blocks.cobblestone);
		GameRegistry.addShapelessRecipe(new ItemStack(Items.coal), new ItemStack(Items.coal,1,1));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.flint,4),Blocks.cobblestone);
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.clay), Blocks.dirt, Items.water_bucket);
	}
}
