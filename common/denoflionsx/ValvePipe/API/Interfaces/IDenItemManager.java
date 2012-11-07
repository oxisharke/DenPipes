package common.denoflionsx.ValvePipe.API.Interfaces;

import net.minecraft.src.ItemStack;

public interface IDenItemManager {
    
    public void registerItem(ItemStack item);
    
    public ItemStack getItemByName(String name);
    
    public void printAllItemNames();
    
}
