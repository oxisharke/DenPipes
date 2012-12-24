package denoflionsx.ValvePipe.Pipes.IndustrialPipes;

import buildcraft.transport.ItemPipe;
import denoflionsx.ValvePipe.API.ValvePipeManagers;
import denoflionsx.ValvePipe.Items.CustomPlate;
import denoflionsx.ValvePipe.Utils.StringUtil;
import denoflionsx.ValvePipe.ValvePipeMod;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

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
