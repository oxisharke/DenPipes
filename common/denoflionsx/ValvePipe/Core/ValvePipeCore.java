package common.denoflionsx.ValvePipe.Core;

import common.denoflionsx.ValvePipe.API.ValvePipeManagers;
import common.denoflionsx.ValvePipe.Actions.Extract;
import common.denoflionsx.ValvePipe.Actions.Pump;
import common.denoflionsx.ValvePipe.Creative.ValvePipeTab;
import common.denoflionsx.ValvePipe.Interfaces.IPipeCore;
import common.denoflionsx.ValvePipe.Items.ItemsCore;
import common.denoflionsx.ValvePipe.Managers.DenActionManager;
import common.denoflionsx.ValvePipe.Managers.DenItemManager;
import common.denoflionsx.ValvePipe.Managers.DenPipeManager;
import common.denoflionsx.ValvePipe.Pipes.*;
import common.denoflionsx.ValvePipe.Pipes.IndustrialPipes.IndustrialPipesCore;
import common.denoflionsx.ValvePipe.Pipes.PowerPipes.PowerPipesCore;
import common.denoflionsx.ValvePipe.Utils.CreatePipe;
import common.denoflionsx.ValvePipe.Utils.GetRecipeMethod;
import common.denoflionsx.ValvePipe.Utils.PipeProperties;
import common.denoflionsx.ValvePipe.ValvePipeMod;
import java.io.File;
import net.minecraft.src.CreativeTabs;
import net.minecraftforge.common.Configuration;

public class ValvePipeCore implements IPipeCore{

    public static final String clazzpath = "common.denoflionsx.ValvePipe.Pipes.PipeRecipes";
    public static Pump pumpAction;
    public static Extract extractAction;
    public String texture = "";
    public File configFile;
    public Configuration config;
    public IPipeCore IndustrialPipes;
    public IPipeCore PowerPipes;
    public IPipeCore Items;
    public CreativeTabs tab = new ValvePipeTab();

    public void loadTexture() {
        print("-------------------------");
        print("Valve Pipe by denoflions.");
        print("-------------------------");
        print("Setting up...");
        configFile = new File(ValvePipeMod.proxy.getConfigDir() + "ValvePipe.cfg");
        config = new Configuration(configFile);
        texture = ValvePipeMod.proxy.preloadTexture("/common/denoflionsx/ValvePipe/gfx/pipe_sheet.png");
        Items = new ItemsCore();
        IndustrialPipes = new IndustrialPipesCore();
        PowerPipes = new PowerPipesCore();
    }

    public void createPipes() {
        ValvePipeManagers.PipeManager = new DenPipeManager();
        ValvePipeManagers.ItemManager = new DenItemManager();
        Items.createPipes();
        if (configFile.exists()) {
            config.load();
        }
        int id = PipeProperties.getOrCreatePipeProperty("ValvePipe_ItemID", 5555);
        CreatePipe.Create("Valve Pipe", id, ValvePipe.class, GetRecipeMethod.getMethod(clazzpath, "ValvePipeRecipe"));
        //-------------------------------
        id = PipeProperties.getOrCreatePipeProperty("CobblestoneGoldPipe_ItemID", 5556);
        CreatePipe.Create("Cobblestone Golden Waterproof Pipe", id, CobblestoneGoldPipe.class, GetRecipeMethod.getMethod(clazzpath, "CobbleStoneGoldPipeRecipe"));
        //---------------------------------------
        id = PipeProperties.getOrCreatePipeProperty("StoneGoldPipe_ItemID", 5557);
        CreatePipe.Create("Stone Golden Waterproof Pipe", id, StoneGoldPipe.class, GetRecipeMethod.getMethod(clazzpath, "StoneGoldPipeRecipe"));
        //-----------------------------------
        id = PipeProperties.getOrCreatePipeProperty("AutomaticWoodenPipe_ItemID", 5558);
        CreatePipe.Create("Automatic Wooden Transport Pipe", id, AutomaticWoodenPipe.class, GetRecipeMethod.getMethod(clazzpath, "AutomaticWoodenPipeRecipe"));
        //----------------------------------------
        id = PipeProperties.getOrCreatePipeProperty("SandstoneGoldPipe_ItemID", 5559);
        CreatePipe.Create("Sandstone Golden Waterproof Pipe", id, SandstoneGoldPipe.class, GetRecipeMethod.getMethod(clazzpath, "SandstoneGoldPipeRecipe"));
        //----------------------------------------
        IndustrialPipes.createPipes();
        PowerPipes.createPipes();
        config.save();
    }

    public void createActions() {
        ValvePipeManagers.ActionManager = new DenActionManager();
        this.Items.createActions();
        this.IndustrialPipes.createActions();
        this.PowerPipes.createActions();
        pumpAction = new Pump();
        extractAction = new Extract();
        ValvePipeManagers.ActionManager.registerAction(pumpAction, "Pump");
        ValvePipeManagers.ActionManager.registerAction(extractAction, "Extract");
    }

    public void print(String msg) {
        System.out.println("[ValvePipe]: " + msg);
    }
}
