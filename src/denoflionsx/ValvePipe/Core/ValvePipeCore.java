package denoflionsx.ValvePipe.Core;

import denoflionsx.ValvePipe.API.ValvePipeManagers;
import denoflionsx.ValvePipe.Actions.Extract;
import denoflionsx.ValvePipe.Actions.Pump;
import denoflionsx.ValvePipe.Creative.ValvePipeTab;
import denoflionsx.ValvePipe.Interfaces.IPipeCore;
import denoflionsx.ValvePipe.Items.ItemsCore;
import denoflionsx.ValvePipe.Managers.DenActionManager;
import denoflionsx.ValvePipe.Managers.DenItemManager;
import denoflionsx.ValvePipe.Managers.DenPipeManager;
import denoflionsx.ValvePipe.Pipes.*;
import denoflionsx.ValvePipe.Pipes.IndustrialPipes.IndustrialPipesCore;
import denoflionsx.ValvePipe.Pipes.PowerPipes.PowerPipesCore;
import denoflionsx.ValvePipe.Utils.CreatePipe;
import denoflionsx.ValvePipe.Utils.GetRecipeMethod;
import denoflionsx.ValvePipe.Utils.PipeProperties;
import denoflionsx.ValvePipe.Utils.ReflectUtils;
import denoflionsx.ValvePipe.ValvePipeMod;
import java.io.File;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.Configuration;

public class ValvePipeCore implements IPipeCore {

    public static final String clazzpath = "denoflionsx.ValvePipe.Pipes.PipeRecipes";
    public static Pump pumpAction;
    public static Extract extractAction;
    public String texture = "";
    public File configFile;
    public Configuration config;
    public IPipeCore IndustrialPipes;
    public PowerPipesCore PowerPipes;
    public IPipeCore Items;
    public CreativeTabs tab = new ValvePipeTab();

    public void loadTexture() {
        print("-------------------------");
        print("Valve Pipe by denoflions.");
        print("-------------------------");
        print("Setting up...");
        configFile = new File(ValvePipeMod.proxy.getConfigDir() + "ValvePipe.cfg");
        config = new Configuration(configFile);
        texture = ValvePipeMod.proxy.preloadTexture("/denoflionsx/ValvePipe/gfx/pipe_sheet.png");
        Items = new ItemsCore();
        IndustrialPipes = new IndustrialPipesCore();
        PowerPipes = new PowerPipesCore();
    }

    @Override
    public void createPipes() {
        ValvePipeManagers.PipeManager = new DenPipeManager();
        ValvePipeManagers.ItemManager = new DenItemManager();
        if (configFile.exists()) {
            config.load();
        }
        Items.createPipes();
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
        // Check and make sure Emerald Pipe exists before trying to make the automatic pipe.
        if (ReflectUtils.doesPipeExist("pipeItemsEmerald")) {
            id = PipeProperties.getOrCreatePipeProperty("AutomaticEmeraldPipe_ItemID", 5565);
            CreatePipe.Create("Automatic Emerald Pipe", id, AutomaticEmeraldPipe.class, GetRecipeMethod.getMethod(clazzpath, "AutomaticEmeraldPipeRecipe"));
        }
        //----------------------------------------
        IndustrialPipes.createPipes();
        PowerPipes.createPipes();
        config.save();
    }

    @Override
    public void createActions() {
        ValvePipeManagers.ActionManager = new DenActionManager();
        this.Items.createActions();
        this.IndustrialPipes.createActions();
        this.PowerPipes.createActions();
        pumpAction = new Pump();
        extractAction = new Extract();
        ValvePipeManagers.ActionManager.registerAction(pumpAction, "Pump");
        ValvePipeManagers.ActionManager.registerAction(extractAction, "Extract");
        ValvePipeManagers.ActionManager.registerAction(PowerPipesCore.flowAction, "Disconnect");
    }

    public void print(String msg) {
        System.out.println("[ValvePipe]: " + msg);
    }
}
