package denoflionsx.ValvePipe.API;

import denoflionsx.ValvePipe.API.Interfaces.IDenActionManager;
import denoflionsx.ValvePipe.API.Interfaces.IDenItemManager;
import denoflionsx.ValvePipe.API.Interfaces.IDenPipeManager;

public class ValvePipeManagers {
    
    // Holds instance of all pipe objects.
    public static IDenPipeManager PipeManager;
    
    // Holds instance of all action objects.
    public static IDenActionManager ActionManager;
    
    // Holds instance of all ItemStack objects (non-pipes).
    public static IDenItemManager ItemManager;
    
}
