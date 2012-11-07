package common.denoflionsx.ValvePipe.Managers;

import common.denoflionsx.ValvePipe.API.Interfaces.IDenItemManager;
import common.denoflionsx.ValvePipe.ValvePipeMod;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.src.ItemStack;

public class DenItemManager implements IDenItemManager{
    
    public static final HashMap<String, ItemStack> items = new HashMap();

    @Override
    public void printAllItemNames() {
        for (Map.Entry<String,ItemStack> entry : items.entrySet()) {
            ValvePipeMod.Core.print(entry.getKey());
        }
    }
    
    @Override
    public ItemStack getItemByName(String name) {
        if (items.get(name) != null){
            return items.get(name);
        }else{
            return null;
        }
    }

    @Override
    public void registerItem(ItemStack item) {
        items.put(item.getItem().getItemNameIS(item),item);
    }
}
