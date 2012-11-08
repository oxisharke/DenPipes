package common.denoflionsx.ValvePipe.Pipes.PowerPipes;

import buildcraft.transport.ItemPipe;
import common.denoflionsx.ValvePipe.API.ValvePipeManagers;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.src.*;
import railcraft.common.api.core.items.ItemRegistry;

public class PowerPipesRecipes {
    
    public static void PowerSwitchPipeRecipe(ItemPipe pipe){
        ItemStack iron = new ItemStack(Item.ingotIron,1,0);
        if (Loader.isModLoaded("Railcraft")){
            iron = ItemRegistry.getItem("part.plate.iron", 1);
        }
        GameRegistry.addRecipe(new ItemStack(pipe,8,0), new Object[]{"RGR","IgI","RGR", Character.valueOf('R'), new ItemStack(Item.redstone), Character.valueOf('G'), ValvePipeManagers.ItemManager.getItemByName("item.goldplate"), Character.valueOf('I'), iron, Character.valueOf('g'), new ItemStack(Block.glass)});
    }
    
    public static void SandstoneGoldPowerPipeRecipe(ItemPipe pipe){
        GameRegistry.addRecipe(new ItemStack(pipe,8,0),new Object[]{"XRX","SgS","XXX", Character.valueOf('R'), new ItemStack(Item.redstone), Character.valueOf('S'), ValvePipeManagers.ItemManager.getItemByName("item.sandstoneplate"),Character.valueOf('g'), new ItemStack(Block.glass)});
    }
}
