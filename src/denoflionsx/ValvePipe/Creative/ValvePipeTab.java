package denoflionsx.ValvePipe.Creative;

import denoflionsx.ValvePipe.API.ValvePipeManagers;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class ValvePipeTab extends CreativeTabs{

    public ValvePipeTab() {
        super("ValvePipeTab");
    }

    @Override
    public ItemStack getIconItemStack() {
        return new ItemStack(ValvePipeManagers.PipeManager.getPipeByName("Valve Pipe"));
    }

    @Override
    public String getTabLabel() {
        return "Valve Pipe";
    }

    @Override
    public String getTranslatedTabLabel() {
        return getTabLabel();
    }

}
