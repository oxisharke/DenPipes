package common.denoflionsx.ValvePipe.Pipes;

import buildcraft.BuildCraftEnergy;
import buildcraft.BuildCraftTransport;
import buildcraft.transport.ItemPipe;
import common.denoflionsx.ValvePipe.ValvePipeMod;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.Property;

public class PipeRecipes {

    public static void ValvePipeRecipe(ItemPipe valvepipe) {
        Property prop = ValvePipeMod.Core.config.getOrCreateIntProperty("ValvePipe_AmountPerCraft", "general", 8);
        int craft = prop.getInt();
        GameRegistry.addShapelessRecipe(new ItemStack(valvepipe, craft, 0), new Object[]{new ItemStack(BuildCraftTransport.pipeLiquidsWood), new ItemStack(BuildCraftEnergy.engineBlock, 1, 0)});
    }

    public static void CobbleStoneGoldPipeRecipe(ItemPipe pipe) {
        Property prop = ValvePipeMod.Core.config.getOrCreateIntProperty("CobblestoneGoldPipe_AmountPerCraft", "general", 2);
        int craft = prop.getInt();
        GameRegistry.addShapelessRecipe(new ItemStack(pipe, craft, 0), new Object[]{new ItemStack(BuildCraftTransport.pipeLiquidsCobblestone), new ItemStack(BuildCraftTransport.pipeLiquidsGold)});
    }

    public static void StoneGoldPipeRecipe(ItemPipe pipe) {
        Property prop = ValvePipeMod.Core.config.getOrCreateIntProperty("StoneGoldPipe_AmountPerCraft", "general", 2);
        int craft = prop.getInt();
        GameRegistry.addShapelessRecipe(new ItemStack(pipe, craft, 0), new Object[]{new ItemStack(BuildCraftTransport.pipeLiquidsStone), new ItemStack(BuildCraftTransport.pipeLiquidsGold)});
    }
    
    public static void AutomaticWoodenPipeRecipe(ItemPipe pipe){
        Property prop = ValvePipeMod.Core.config.getOrCreateIntProperty("AutomaticWoodenPipe_AmountPerCraft", "general", 8);
        int craft = prop.getInt();
        GameRegistry.addShapelessRecipe(new ItemStack(pipe,craft,0), new Object[]{new ItemStack(BuildCraftTransport.pipeItemsWood), new ItemStack(BuildCraftEnergy.engineBlock,1,0)});
    }
    
    public static void SandstoneGoldPipeRecipe(ItemPipe pipe){
        Property prop = ValvePipeMod.Core.config.getOrCreateIntProperty("SandstoneGoldPipe_AmountPerCraft", "general", 2);
        int craft = prop.getInt();
        GameRegistry.addShapelessRecipe(new ItemStack(pipe,craft,0), new Object[]{new ItemStack(BuildCraftTransport.pipeLiquidsSandstone), new ItemStack(BuildCraftTransport.pipeLiquidsGold)});
    }
}
