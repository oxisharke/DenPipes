package denoflionsx.ValvePipe.Actions;

import buildcraft.api.gates.Action;
import denoflionsx.ValvePipe.ValvePipeMod;

public class Pump extends Action{
    
    public static final int ID = 955;

    public Pump() {
        super(ID);
    }

    @Override
    public String getTexture() {
        return ValvePipeMod.Core.texture;
    }

    @Override
    public String getDescription() {
        return "Pump";
    }

    @Override
    public int getIndexInTexture() {
        return 16;
    }
}
