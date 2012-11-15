package denoflionsx.ValvePipe.API.Interfaces;

import buildcraft.transport.ItemPipe;

public interface IDenPipeManager {
    
    public void registerPipe(ItemPipe pipe, String name);
    
    public ItemPipe getPipeByName(String name);
    
}
