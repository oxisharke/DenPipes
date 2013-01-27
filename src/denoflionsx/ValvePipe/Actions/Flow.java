package denoflionsx.ValvePipe.Actions;

import buildcraft.api.gates.Action;
import denoflionsx.ValvePipe.ValvePipeMod;

public class Flow extends Action{
    
    public static final int ID = 957;

    public Flow() {
        super(ID);
    }

    @Override
    public String getTexture() {
        return ValvePipeMod.Core.texture;
    }

    @Override
    public String getDescription() {
        return "Flow";
    }

    @Override
    public int getIndexInTexture() {
        return 19;
    }
}
