package common.denoflionsx.ValvePipe.Pipes;

import buildcraft.BuildCraftEnergy;
import buildcraft.BuildCraftSilicon;
import buildcraft.BuildCraftTransport;
import buildcraft.transport.ItemPipe;
import common.denoflionsx.ValvePipe.API.ValvePipeManagers;
import common.denoflionsx.ValvePipe.ValvePipeMod;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.src.Block;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.Property;

public class PipeRecipes {

    public static void ValvePipeRecipe(ItemPipe valvepipe) {
        Property prop = ValvePipeMod.Core.config.get("general", "ValvePipe_AmountPerCraft", 8);
        int craft = prop.getInt();
        GameRegistry.addShapelessRecipe(new ItemStack(valvepipe, craft, 0), new Object[]{new ItemStack(BuildCraftTransport.pipeLiquidsWood), new ItemStack(BuildCraftEnergy.engineBlock, 1, 0), new ItemStack(BuildCraftSilicon.redstoneChipset,1,4)});
    }

    public static void CobbleStoneGoldPipeRecipe(ItemPipe pipe) {
        Property prop = ValvePipeMod.Core.config.get("general", "CobblestoneGoldPipe_AmountPerCraft", 16);
        int craft = prop.getInt();
        GameRegistry.addRecipe(new ItemStack(pipe,craft,0), new Object[]{"WGW","SgS","WGW",Character.valueOf('W'),new ItemStack(BuildCraftTransport.pipeWaterproof), Character.valueOf('G'), ValvePipeManagers.ItemManager.getItemByName("item.goldplate"), Character.valueOf('S'), ValvePipeManagers.ItemManager.getItemByName("item.cobblestoneplate"), Character.valueOf('g'), new ItemStack(Block.glass)});
    }

    public static void StoneGoldPipeRecipe(ItemPipe pipe) {
        Property prop = ValvePipeMod.Core.config.get("general", "StoneGoldPipe_AmountPerCraft", 16);
        int craft = prop.getInt();
        GameRegistry.addShapelessRecipe(new ItemStack(pipe, craft, 0), new Object[]{new ItemStack(BuildCraftTransport.pipeLiquidsStone), new ItemStack(BuildCraftTransport.pipeLiquidsGold)});
    }
    
    public static void AutomaticWoodenPipeRecipe(ItemPipe pipe){
        Property prop = ValvePipeMod.Core.config.get("general", "AutomaticWoodenPipe_AmountPerCraft", 8);
        int craft = prop.getInt();
        GameRegistry.addShapelessRecipe(new ItemStack(pipe,craft,0), new Object[]{new ItemStack(BuildCraftTransport.pipeItemsWood), new ItemStack(BuildCraftEnergy.engineBlock,1,0), new ItemStack(BuildCraftSilicon.redstoneChipset,1,4)});
    }
    
    public static void SandstoneGoldPipeRecipe(ItemPipe pipe){
        Property prop = ValvePipeMod.Core.config.get("general", "SandstoneGoldPipe_AmountPerCraft", 2);
        int craft = prop.getInt();
        GameRegistry.addShapelessRecipe(new ItemStack(pipe,craft,0), new Object[]{new ItemStack(BuildCraftTransport.pipeLiquidsSandstone), new ItemStack(BuildCraftTransport.pipeLiquidsGold)});
    }
}
