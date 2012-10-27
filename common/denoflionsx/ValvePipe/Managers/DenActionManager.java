package common.denoflionsx.ValvePipe.Managers;

import buildcraft.api.gates.IAction;
import common.denoflionsx.ValvePipe.API.Interfaces.IDenActionManager;
import java.util.HashMap;

public class DenActionManager implements IDenActionManager{
    
    public static HashMap<String, IAction> actions = new HashMap();

    @Override
    public IAction getActionByName(String name) {
        if (actions.get(name) != null){
            return actions.get(name);
        }else{
            return null;
        }
    }

    @Override
    public void registerAction(IAction action, String name) {
        actions.put(name,action);
    }

}
