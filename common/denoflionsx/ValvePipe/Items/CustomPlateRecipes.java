package common.denoflionsx.ValvePipe.Items;

import buildcraft.BuildCraftTransport;
import common.denoflionsx.ValvePipe.API.ValvePipeManagers;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import railcraft.common.api.crafting.RailcraftCraftingManager;

public class CustomPlateRecipes {

    public static void BronzePlateRecipe(Item plate) {
        if (CustomPlate.Crafting.equals(CustomPlate.mode.RAILCRAFT)) {
            for (ItemStack b : OreDictionary.getOres("ingotBronze")) {
                RailcraftCraftingManager.rollingMachine.addRecipe(new ItemStack(plate, 9, 0), new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), b});
            }
        } else {
            for (ItemStack b : OreDictionary.getOres("ingotBronze")) {
                GameRegistry.addRecipe(new ItemStack(plate, 8, 0), new Object[]{"XXX", "XZX", "XXX", Character.valueOf('X'), b, Character.valueOf('Z'), ValvePipeManagers.ItemManager.getItemByName("item.stoneplate")});
            }
        }
    }

    public static void GoldPlateRecipe(Item plate) {
        if (CustomPlate.Crafting.equals(CustomPlate.mode.RAILCRAFT)) {
            RailcraftCraftingManager.rollingMachine.addRecipe(new ItemStack(plate, 9, 1), new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), new ItemStack(Item.ingotGold)});
        } else {
            GameRegistry.addRecipe(new ItemStack(plate, 8, 1), new Object[]{"XXX", "XZX", "XXX", Character.valueOf('X'), new ItemStack(Item.ingotGold),Character.valueOf('Z'), ValvePipeManagers.ItemManager.getItemByName("item.stoneplate")});
        }
    }

    public static void BronzeWaterproofRecipe(Item plate) {
        GameRegistry.addShapelessRecipe(new ItemStack(plate, 1, 2), new Object[]{new ItemStack(plate, 1, 0), new ItemStack(BuildCraftTransport.pipeWaterproof)});
    }

    public static void CobblestonePlateRecipe(Item plate) {
        if (CustomPlate.Crafting.equals(CustomPlate.mode.RAILCRAFT)) {
            RailcraftCraftingManager.rollingMachine.addRecipe(new ItemStack(plate, 9, 3), new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), new ItemStack(Block.cobblestone)});
        } else {
            GameRegistry.addRecipe(new ItemStack(plate, 9, 3), new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), new ItemStack(Block.cobblestone)});
        }
    }

    public static void StonePlateRecipe(Item plate) {
        if (CustomPlate.Crafting.equals(CustomPlate.mode.RAILCRAFT)) {
            RailcraftCraftingManager.rollingMachine.addRecipe(new ItemStack(plate, 9, 4), new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'), new ItemStack(Block.stone)});
        } else {
            GameRegistry.addRecipe(new ItemStack(plate, 8, 4), new Object[]{"XXX", "XZX", "XXX", Character.valueOf('X'), new ItemStack(Block.stone),Character.valueOf('Z'), ValvePipeManagers.ItemManager.getItemByName("item.cobblestoneplate")});
        }
    }

    public static void SandstonePlateRecipe(Item plate) {
        if (CustomPlate.Crafting.equals(CustomPlate.mode.RAILCRAFT)) {
            RailcraftCraftingManager.rollingMachine.addRecipe(new ItemStack(plate, 9, 5), new Object[]{"XXX", "XXX", "XXX", Character.valueOf('X'),  new ItemStack(Block.sandStone)});
        } else {
            GameRegistry.addRecipe(new ItemStack(plate, 8, 5), new Object[]{"XXX", "XZX", "XXX", Character.valueOf('X'), new ItemStack(Block.sandStone),Character.valueOf('Z'), ValvePipeManagers.ItemManager.getItemByName("item.stoneplate")});
        }
    }
}
