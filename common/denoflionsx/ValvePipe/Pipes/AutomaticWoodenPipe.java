package common.denoflionsx.ValvePipe.Pipes;

import buildcraft.api.core.Orientations;
import buildcraft.api.gates.IAction;
import buildcraft.transport.pipes.PipeItemsWood;
import common.denoflionsx.ValvePipe.Actions.Extract;
import common.denoflionsx.ValvePipe.Core.ValvePipeCore;
import common.denoflionsx.ValvePipe.ValvePipeMod;
import java.util.HashMap;
import java.util.LinkedList;

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
                this.getPowerProvider().receiveEnergy(1, Orientations.XNeg);
            }
        }
    }

    @Override
    public String getTextureFile() {
        return ValvePipeMod.Core.texture;
    }

    @Override
    public int getTextureIndex(Orientations direction) {
        return 0;
    }
}
