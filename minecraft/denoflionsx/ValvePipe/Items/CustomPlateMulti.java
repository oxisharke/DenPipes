package denoflionsx.ValvePipe.Items;

import denoflionsx.ValvePipe.API.ValvePipeManagers;
import denoflionsx.ValvePipe.Utils.PipeProperties;
import denoflionsx.ValvePipe.Utils.StringUtil;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.LanguageRegistry;
import java.util.HashMap;
import java.util.List;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class CustomPlateMulti extends CustomPlate {

    private final static int ItemID = PipeProperties.getOrCreatePipeProperty("Plates_ItemID", 5563);
    private HashMap<Integer, Integer> texture;
    private HashMap<Integer, String> name;

    public CustomPlateMulti() {
        super(ItemID);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
        if (Loader.isModLoaded("Railcraft")) {
            Crafting = mode.RAILCRAFT;
        }
        texture = new HashMap();
        for (textures t : textures.values()) {
            texture.put(t.getMeta(), t.getIndex());
        }
        name = new HashMap();
        for (names n : names.values()) {
            name.put(n.getMeta(), StringUtil.removeWhiteSpaceLowerCase("item." + n.getName()));
            LanguageRegistry.instance().addStringLocalization(StringUtil.removeWhiteSpaceLowerCase("item." + n.getName() + ".name"), n.getName());
        }
        //----------------------------
        // Run all the recipe methods.
        //----------------------------
        for (int i = 0; i < 6; i++) {
            ValvePipeManagers.ItemManager.registerItem(new ItemStack(this, 1, i));
        }
        if (OreDictionary.getOres("ingotBronze") != null) {
            CustomPlateRecipes.BronzePlateRecipe(this);
        }
        CustomPlateRecipes.BronzeWaterproofRecipe(this);
        CustomPlateRecipes.CobblestonePlateRecipe(this);
        CustomPlateRecipes.StonePlateRecipe(this);
        CustomPlateRecipes.SandstonePlateRecipe(this);
        CustomPlateRecipes.GoldPlateRecipe(this);
        //----------------------------
    }

    @Override
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List) {
        for (int i = 0; i < 5; i++) {
            par3List.add(new ItemStack(this, 1, i));
        }
    }

    @Override
    public int getIconFromDamage(int par1) {
        return texture.get(par1);
    }

    @Override
    public String getItemNameIS(ItemStack par1ItemStack) {
        return name.get(par1ItemStack.getItemDamage());
    }
}
