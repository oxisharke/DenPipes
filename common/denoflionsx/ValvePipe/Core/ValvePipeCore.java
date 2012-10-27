package common.denoflionsx.ValvePipe.Core;

import buildcraft.transport.BlockGenericPipe;
import buildcraft.transport.ItemPipe;
import common.denoflionsx.ValvePipe.API.ValvePipeManagers;
import common.denoflionsx.ValvePipe.Actions.Extract;
import common.denoflionsx.ValvePipe.Actions.Pump;
import common.denoflionsx.ValvePipe.Managers.DenActionManager;
import common.denoflionsx.ValvePipe.Managers.DenPipeManager;
import common.denoflionsx.ValvePipe.Pipes.*;
import common.denoflionsx.ValvePipe.ValvePipeMod;
import java.io.File;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;

public class ValvePipeCore {

    public static ValvePipe pipeItem;
    public static Pump pumpAction;
    public static Extract extractAction;
    public String texture = "";
    public File configFile;
    public Configuration config;

    public void loadTexture() {
        print("-------------------------");
        print("Valve Pipe by denoflions.");
        print("-------------------------");
        print("Setting up...");
        configFile = new File(ValvePipeMod.proxy.getConfigDir() + "ValvePipe.cfg");
        config = new Configuration(configFile);
        texture = ValvePipeMod.proxy.preloadTexture("/common/denoflionsx/ValvePipe/gfx/pipe_sheet.png");
    }

    public void createPipe() {
        ValvePipeManagers.PipeManager = new DenPipeManager();
        if (configFile.exists()) {
            config.load();
        }
        Property prop = config.getOrCreateIntProperty("ValvePipe_ItemID", "item", 5555);
        int id = prop.getInt();
        ItemPipe res = BlockGenericPipe.registerPipe(id, ValvePipe.class);
        ValvePipeMod.proxy.registerPipe(res, ValvePipe.class, "Valve Pipe");
        PipeRecipes.ValvePipeRecipe(res);
        //-------------------------------
        Property prop2 = config.getOrCreateIntProperty("CobblestoneGoldPipe_ItemID", "item", 5556);
        id = prop2.getInt();
        ItemPipe c = BlockGenericPipe.registerPipe(id, CobblestoneGoldPipe.class);
        ValvePipeMod.proxy.registerPipe(c, CobblestoneGoldPipe.class, "Cobblestone Gold Waterproof Pipe");
        PipeRecipes.CobbleStoneGoldPipeRecipe(c);
        //---------------------------------------
        Property prop3 = config.getOrCreateIntProperty("StoneGoldPipe_ItemID", "item", 5557);
        id = prop3.getInt();
        ItemPipe c2 = BlockGenericPipe.registerPipe(id, StoneGoldPipe.class);
        ValvePipeMod.proxy.registerPipe(c2, StoneGoldPipe.class, "Stone Gold Waterproof Pipe");
        PipeRecipes.StoneGoldPipeRecipe(c2);
        //-----------------------------------
        Property prop4 = config.getOrCreateIntProperty("AutomaticWoodenPipe_ItemID", "item", 5558);
        id = prop4.getInt();
        ItemPipe c3 = BlockGenericPipe.registerPipe(id, AutomaticWoodenPipe.class);
        ValvePipeMod.proxy.registerPipe(c3, AutomaticWoodenPipe.class, "Automatic Wooden Pipe");
        PipeRecipes.AutomaticWoodenPipeRecipe(c3);
        //----------------------------------------
        Property prop5 = config.getOrCreateIntProperty("SandstoneGoldPipe_ItemID", "item", 5559);
        id = prop5.getInt();
        ItemPipe c4 = BlockGenericPipe.registerPipe(id, SandstoneGoldPipe.class);
        ValvePipeMod.proxy.registerPipe(c4, SandstoneGoldPipe.class, "Sandstone Gold Pipe");
        PipeRecipes.SandstoneGoldPipeRecipe(c4);
        //----------------------------------------
        config.save();
    }

    public void createAction() {
        ValvePipeManagers.ActionManager = new DenActionManager();
        pumpAction = new Pump();
        extractAction = new Extract();
        ValvePipeManagers.ActionManager.registerAction(pumpAction, "Pump");
        ValvePipeManagers.ActionManager.registerAction(extractAction, "Extract");
    }

    public void print(String msg) {
        System.out.println("[ValvePipe]: " + msg);
    }
}
