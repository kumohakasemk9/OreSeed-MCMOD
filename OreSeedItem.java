 import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.ai.EntitySenses;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class OreSeedItem extends Item {
	public OreSeedItem() {
		super();
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setUnlocalizedName("oreseedmod.oreseed");
		this.setTextureName("minecraft:seeds_wheat");
		this.setMaxStackSize(64);
	}
	
	@Override
	public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int side, float disX, float disY, float disZ) {
		if(world.getBlock(x, y, z) != Blocks.farmland || world.getBlock(x, y + 1, z) != Blocks.air) {return false;}
		world.setBlock(x, y+1, z, OreSeedCore.oreSeedbkobj);
		item.stackSize--;
		return true;
	}
}
