package denoflionsx.ValvePipe.API.Interfaces;

import buildcraft.api.gates.IAction;

public interface IDenActionManager {
    
    public void registerAction(IAction action, String name);
    
    public IAction getActionByName(String name);
    
}
