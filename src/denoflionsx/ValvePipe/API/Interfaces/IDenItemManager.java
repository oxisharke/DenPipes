package denoflionsx.ValvePipe.API.Interfaces;

import net.minecraft.item.ItemStack;

public interface IDenItemManager {
    
    public void registerItem(ItemStack item);
    
    public ItemStack getItemByName(String name);
    
    public void printAllItemNames();
    
}
