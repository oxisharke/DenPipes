package common.denoflionsx.ValvePipe.Actions;

import buildcraft.api.gates.Action;
import common.denoflionsx.ValvePipe.ValvePipeMod;

public class Extract extends Action{
    
    public static final int id = 956;

    public Extract(int id) {
        super(id);
    }

    public Extract() {
        this(id);
    }

    @Override
    public String getTexture() {
        return ValvePipeMod.Core.texture;
    }

    @Override
    public String getDescription() {
        return "Extract";
    }

    @Override
    public int getIndexInTexture() {
        return 17;
    }
 
}
