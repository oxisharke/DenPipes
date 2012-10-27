package common.denoflionsx.ValvePipe.Managers;

import buildcraft.transport.ItemPipe;
import common.denoflionsx.ValvePipe.API.Interfaces.IDenPipeManager;
import java.util.HashMap;

public class DenPipeManager implements IDenPipeManager{
    
    public static HashMap<String, ItemPipe> pipes = new HashMap();

    @Override
    public ItemPipe getPipeByName(String name) {
        if (pipes.get(name) != null){
            return pipes.get(name);
        }else{
            return null;
        }
    }

    @Override
    public void registerPipe(ItemPipe pipe, String name) {
        pipes.put(name,pipe);
    }
}
