package denoflionsx.ValvePipe.Pipes;

import buildcraft.BuildCraftEnergy;
import buildcraft.BuildCraftSilicon;
import buildcraft.BuildCraftTransport;
import buildcraft.transport.ItemPipe;
import denoflionsx.ValvePipe.API.ValvePipeManagers;
import cpw.mods.fml.common.registry.GameRegistry;
import denoflionsx.ValvePipe.ValvePipeMod;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class PipeRecipes {

    public static void ValvePipeRecipe(ItemPipe valvepipe) {
        if (ValvePipeMod.Core.config.get("tuning", "EasyRecipes", false).getBoolean(false)) {
            GameRegistry.addShapelessRecipe(new ItemStack(valvepipe, 8, 0), new Object[]{new ItemStack(BuildCraftTransport.pipeLiquidsWood), new ItemStack(BuildCraftEnergy.engineBlock, 1, 0)});
            return;
        }
        GameRegistry.addShapelessRecipe(new ItemStack(valvepipe, 8, 0), new Object[]{new ItemStack(BuildCraftTransport.pipeLiquidsWood), new ItemStack(BuildCraftEnergy.engineBlock, 1, 0), new ItemStack(BuildCraftSilicon.redstoneChipset, 1, 4)});
    }

    public static void CobbleStoneGoldPipeRecipe(ItemPipe pipe) {
        GameRegistry.addRecipe(new ItemStack(pipe, 16, 0), new Object[]{"WGW", "SgS", "WGW", Character.valueOf('W'), new ItemStack(BuildCraftTransport.pipeWaterproof), Character.valueOf('G'), ValvePipeManagers.ItemManager.getItemByName("item.goldplate"), Character.valueOf('S'), ValvePipeManagers.ItemManager.getItemByName("item.cobblestoneplate"), Character.valueOf('g'), new ItemStack(Block.glass)});
    }

    public static void StoneGoldPipeRecipe(ItemPipe pipe) {
        GameRegistry.addRecipe(new ItemStack(pipe, 16, 0), new Object[]{"WGW", "SgS", "WGW", Character.valueOf('W'), new ItemStack(BuildCraftTransport.pipeWaterproof), Character.valueOf('G'), ValvePipeManagers.ItemManager.getItemByName("item.goldplate"), Character.valueOf('S'), ValvePipeManagers.ItemManager.getItemByName("item.stoneplate"), Character.valueOf('g'), new ItemStack(Block.glass)});
    }

    public static void AutomaticWoodenPipeRecipe(ItemPipe pipe) {
        if (ValvePipeMod.Core.config.get("tuning", "EasyRecipes", false).getBoolean(false)) {
            GameRegistry.addShapelessRecipe(new ItemStack(pipe, 8, 0), new Object[]{new ItemStack(BuildCraftTransport.pipeItemsWood), new ItemStack(BuildCraftEnergy.engineBlock, 1, 0)});
            return;
        }
        GameRegistry.addShapelessRecipe(new ItemStack(pipe, 8, 0), new Object[]{new ItemStack(BuildCraftTransport.pipeItemsWood), new ItemStack(BuildCraftEnergy.engineBlock, 1, 0), new ItemStack(BuildCraftSilicon.redstoneChipset, 1, 4)});
    }

    public static void SandstoneGoldPipeRecipe(ItemPipe pipe) {
        GameRegistry.addRecipe(new ItemStack(pipe, 16, 0), new Object[]{"WGW", "SgS", "WGW", Character.valueOf('W'), new ItemStack(BuildCraftTransport.pipeWaterproof), Character.valueOf('G'), ValvePipeManagers.ItemManager.getItemByName("item.goldplate"), Character.valueOf('S'), ValvePipeManagers.ItemManager.getItemByName("item.sandstoneplate"), Character.valueOf('g'), new ItemStack(Block.glass)});
    }
    
    public static void AutomaticEmeraldPipeRecipe(ItemPipe pipe){
        if (ValvePipeMod.Core.config.get("tuning", "EasyRecipes", false).getBoolean(false)){
            GameRegistry.addShapelessRecipe(new ItemStack(pipe,8,0), new Object[]{new ItemStack(BuildCraftTransport.pipeItemsEmerald), new ItemStack(BuildCraftEnergy.engineBlock,1,0)});
            return;
        }
        GameRegistry.addShapelessRecipe(new ItemStack(pipe,8,0), new Object[]{new ItemStack(BuildCraftTransport.pipeItemsEmerald), new ItemStack(BuildCraftEnergy.engineBlock,1,0), new ItemStack(BuildCraftSilicon.redstoneChipset, 1, 4)});
    }
}
