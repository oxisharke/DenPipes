package common.denoflionsx.ValvePipe.Pipes.IndustrialPipes;

import buildcraft.transport.ItemPipe;
import common.denoflionsx.ValvePipe.API.ValvePipeManagers;
import common.denoflionsx.ValvePipe.Items.CustomPlate;
import common.denoflionsx.ValvePipe.Utils.StringUtil;
import common.denoflionsx.ValvePipe.ValvePipeMod;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.src.Block;
import net.minecraft.src.ItemStack;

public class IndustrialPipeRecipes {

    public static void CobblestoneRecipe(ItemPipe pipe) {
        if (pipe == null) {
            ValvePipeMod.Core.print("Recipe Failed!");
        }
        GameRegistry.addRecipe(new ItemStack(pipe, 8, 0), new Object[]{"BGB", "WgW", "BGB",
                    Character.valueOf('B'), ValvePipeManagers.ItemManager.getItemByName("item." + StringUtil.removeWhiteSpaceLowerCase(CustomPlate.names.BRONZE_WATER.getName())),
                    Character.valueOf('G'), ValvePipeManagers.ItemManager.getItemByName("item.goldplate"),
                    Character.valueOf('g'), new ItemStack(Block.glass), Character.valueOf('W'), ValvePipeManagers.ItemManager.getItemByName("item.cobblestoneplate")});
    }

    public static void StoneRecipe(ItemPipe pipe) {
        if (pipe == null) {
            ValvePipeMod.Core.print("Recipe Failed!");
        }
        GameRegistry.addRecipe(new ItemStack(pipe, 8, 0), new Object[]{"BGB", "WgW", "BGB",
                    Character.valueOf('B'), ValvePipeManagers.ItemManager.getItemByName("item." + StringUtil.removeWhiteSpaceLowerCase(CustomPlate.names.BRONZE_WATER.getName())),
                    Character.valueOf('G'), ValvePipeManagers.ItemManager.getItemByName("item.goldplate"),
                    Character.valueOf('g'), new ItemStack(Block.glass), Character.valueOf('W'), ValvePipeManagers.ItemManager.getItemByName("item.stoneplate")});
    }
}
