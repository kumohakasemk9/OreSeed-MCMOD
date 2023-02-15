import cpw.mods.fml.relauncher.*;

import java.util.ArrayList;
import java.util.Random;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockChest;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class OreSeed extends BlockBush implements IGrowable {
	@SideOnly(Side.CLIENT)
	private IIcon[] icon;
	
	public OreSeed() {
		super(Material.plants);
		setBlockName("oreseedmod.oreseedblock");
		setResistance(2.5F);
		setTickRandomly(true);
		setStepSound(Block.soundTypeGrass);
		setCreativeTab(null);
		float f = 0.5F;
		setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
	}
	
	public boolean canPlaceBlockAt(World wd,int x,int y,int z) {
		return wd.getBlock(x, y - 1, z) == Blocks.farmland;
	}
	
	public boolean canBlockStay(World wd,int x,int y,int z) {
		return canPlaceBlockAt(wd,x,y,z);
	}
	
	public void updateTick(World wd,int x,int y,int z,Random RND) {
		super.updateTick(wd, x, y, z, RND);
		if(RND.nextInt(14)!=0) {return;}
		if(wd.getBlockLightValue(x, y+1, z) < 7) {return;}
		growUp(wd,x,y,z,RND);
	}
	
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
		ArrayList<ItemStack> r = new ArrayList();
		r.add(new ItemStack(OreSeedCore.oreSeedObj,1));
		return r;
	}
	
	public int quantityDropped(Random par1Random)
	{
		return 1;
	}
	
	private void growUp(World wd,int x,int y,int z,Random RND) {
		int years_old = wd.getBlockMetadata(x, y, z);
		if(years_old < 7) {years_old++;} 
		if(years_old==7) {
			boolean youLucky = RND.nextInt(100) == 1 ? true : false;
			Block creation_ore = youLucky ? Blocks.iron_block : Blocks.iron_ore;
			if(RND.nextInt(4) == 1) {creation_ore = Blocks.coal_ore;} 
			if(RND.nextInt(5) == 1) {creation_ore = youLucky ? Blocks.quartz_block : Blocks.quartz_ore;}
			if(RND.nextInt(12) == 1) {creation_ore = youLucky ? Blocks.gold_block : Blocks.gold_ore;}
			if(RND.nextInt(30) == 1) {creation_ore = youLucky ? Blocks.redstone_block : Blocks.redstone_ore;}
			if(RND.nextInt(40) == 1) {creation_ore = youLucky ? Blocks.lapis_block : Blocks.lapis_ore;}
			if(RND.nextInt(60) == 1) {creation_ore = youLucky ? Blocks.diamond_block : Blocks.diamond_ore;}
			if(RND.nextInt(100) == 1) {creation_ore = youLucky ? Blocks.emerald_block : Blocks.emerald_ore;}
			wd.setBlock(x, y, z, creation_ore);
		}
		
		wd.setBlockMetadataWithNotify(x, y, z, years_old,0);
	}
	public boolean func_149851_a(World wd, int x, int y, int z, boolean arg4) {
		return wd.getBlockMetadata(x, y, z) != 7;
	}

	public boolean func_149852_a(World wd, Random RND, int x, int y,int z) {
		growUp(wd,x,y,z,RND);
		return true;
	}

	public void func_149853_b(World arg0, Random arg1, int arg2, int arg3,
			int arg4) {
	}
	
	public int getRenderType() {return 1;}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int Metadata) {return icon[Metadata];}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister ir) {
		icon = new IIcon[8];
		icon[0] = ir.registerIcon("minecraft:wheat_stage_0");
		icon[1] = ir.registerIcon("minecraft:wheat_stage_1");
		icon[2] = ir.registerIcon("minecraft:wheat_stage_2");
		icon[3] = ir.registerIcon("minecraft:wheat_stage_3");
		icon[4] = ir.registerIcon("minecraft:wheat_stage_4");
		icon[5] = ir.registerIcon("minecraft:wheat_stage_5");
		icon[6] = ir.registerIcon("minecraft:wheat_stage_6");
		icon[7] = ir.registerIcon("minecraft:wheat_stage_7");
	}
}
