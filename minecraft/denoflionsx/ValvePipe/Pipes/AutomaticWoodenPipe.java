package denoflionsx.ValvePipe.Pipes;

import buildcraft.api.gates.IAction;
import buildcraft.transport.pipes.PipeItemsWood;
import denoflionsx.ValvePipe.Actions.Extract;
import denoflionsx.ValvePipe.Core.ValvePipeCore;
import denoflionsx.ValvePipe.ValvePipeMod;
import java.util.HashMap;
import java.util.LinkedList;
import net.minecraftforge.common.ForgeDirection;

public class AutomaticWoodenPipe extends PipeItemsWood {

    public AutomaticWoodenPipe(int itemID) {
        super(itemID);
    }
    
    @Override
    public LinkedList<IAction> getActions() {
        LinkedList<IAction> a = super.getActions();
        a.add(ValvePipeCore.extractAction);
        return a;
    }

    @Override
    protected void actionsActivated(HashMap<Integer, Boolean> actions) {
        super.actionsActivated(actions);
        for (Integer i : actions.keySet()) {
            if (actions.get(i).booleanValue() && buildcraft.api.gates.ActionManager.actions[i.intValue()] instanceof Extract) {
                this.getPowerProvider().receiveEnergy(1, ForgeDirection.DOWN);
            }
        }
    }

    @Override
    public String getTextureFile() {
        return ValvePipeMod.Core.texture;
    }

    @Override
    public int getTextureIndex(ForgeDirection direction) {
        return 3;
    }
}
