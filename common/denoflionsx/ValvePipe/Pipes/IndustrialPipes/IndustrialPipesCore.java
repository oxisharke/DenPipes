package common.denoflionsx.ValvePipe.Pipes.IndustrialPipes;

import common.denoflionsx.ValvePipe.Interfaces.IPipeCore;
import common.denoflionsx.ValvePipe.Utils.CreatePipe;
import common.denoflionsx.ValvePipe.Utils.GetRecipeMethod;
import common.denoflionsx.ValvePipe.Utils.PipeProperties;
import common.denoflionsx.ValvePipe.ValvePipeMod;
import net.minecraftforge.oredict.OreDictionary;

public class IndustrialPipesCore implements IPipeCore {

    public final String clazzpath = "common.denoflionsx.ValvePipe.Pipes.IndustrialPipes.IndustrialPipeRecipes";
    public final int cobble = PipeProperties.getOrCreatePipeProperty("IndustrialCobble_ItemID", 5560);
    public final int stone = PipeProperties.getOrCreatePipeProperty("IndustrialStone_ItemID", 5561);
    public static int PipeCapacityMultiplier = 4;

    @Override
    public void createPipes() {
        if (OreDictionary.getOres("ingotBronze") != null) {
            CreatePipe.Create("Cobblestone Industrial Waterproof Pipe", cobble, IndustrialCobblestonePipe.class, GetRecipeMethod.getMethod(clazzpath, "CobblestoneRecipe"));
            CreatePipe.Create("Stone Industrial Waterproof Pipe", stone, IndustrialStonePipe.class, GetRecipeMethod.getMethod(clazzpath, "StoneRecipe"));
        } else {
            ValvePipeMod.Core.print("Your mod configuration does not meet the minimum requirements to use Industrial Pipes. Please install a mod that has Bronze Ingots.");
        }
    }

    @Override
    public void createActions() {
    }

}
