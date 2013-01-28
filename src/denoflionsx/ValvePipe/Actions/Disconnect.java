package denoflionsx.ValvePipe.Actions;

import buildcraft.api.gates.Action;
import denoflionsx.ValvePipe.ValvePipeMod;

public class Disconnect extends Action{
    
    public static final int ID = 957;

    public Disconnect() {
        super(ID);
    }

    @Override
    public String getTexture() {
        return ValvePipeMod.Core.texture;
    }

    @Override
    public String getDescription() {
        return "Disconnect";
    }

    @Override
    public int getIndexInTexture() {
        return 18;
    }
}
