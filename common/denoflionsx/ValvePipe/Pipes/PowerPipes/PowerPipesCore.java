package common.denoflionsx.ValvePipe.Pipes.PowerPipes;

import common.denoflionsx.ValvePipe.Interfaces.IPipeCore;
import common.denoflionsx.ValvePipe.Utils.CreatePipe;
import common.denoflionsx.ValvePipe.Utils.GetRecipeMethod;
import common.denoflionsx.ValvePipe.Utils.PipeProperties;

public class PowerPipesCore implements IPipeCore{
    
    public static final int PowerSwitchPipeID = PipeProperties.getOrCreatePipeProperty("PowerSwitchPipe_ItemID", 5562);
    public static final int SandstoneGoldPipeID = PipeProperties.getOrCreatePipeProperty("SandstoneGoldPowerPipe_ItemID", 5564);
    public final String clazzpath = "common.denoflionsx.ValvePipe.Pipes.PowerPipes.PowerPipesRecipes";

    @Override
    public void createActions() {
        
    }

    @Override
    public void createPipes() {
        CreatePipe.Create("Power Switch Pipe", PowerSwitchPipeID, PowerSwitchPipe.class, GetRecipeMethod.getMethod(clazzpath, "PowerSwitchPipeRecipe"));
        CreatePipe.Create("Sandstone Gold Power Pipe", SandstoneGoldPipeID, SandstoneGoldPowerPipe.class, GetRecipeMethod.getMethod(clazzpath, "SandstoneGoldPowerPipeRecipe"));
    }

}