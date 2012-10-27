package common.denoflionsx.ValvePipe.Pipes;

import buildcraft.api.core.Orientations;
import buildcraft.api.gates.IAction;
import buildcraft.api.liquids.LiquidManager;
import buildcraft.transport.PipeTransportLiquids;
import buildcraft.transport.pipes.PipeLiquidsWood;
import common.denoflionsx.ValvePipe.Actions.Pump;
import common.denoflionsx.ValvePipe.Core.ValvePipeCore;
import common.denoflionsx.ValvePipe.ValvePipeMod;
import java.util.HashMap;
import java.util.LinkedList;

public class ValvePipe extends PipeLiquidsWood {

    public ValvePipe(int itemID) {
        super(itemID);
        this.getPowerProvider().configure(50, 1, 200, 1, 200);
        ((PipeTransportLiquids) transport).flowRate = 80;
        ((PipeTransportLiquids) transport).travelDelay = 4;
    }

    @Override
    public LinkedList<IAction> getActions() {
        LinkedList<IAction> actions = super.getActions();
        actions.add(ValvePipeCore.pumpAction);
        return actions;
    }

    @Override
    public void doWork() {
        super.doWork();
        if (liquidToExtract <= LiquidManager.BUCKET_VOLUME) {
            liquidToExtract += this.getPowerProvider().useEnergy(100, 100, true) * LiquidManager.BUCKET_VOLUME;
        }
    }

    @Override
    protected void actionsActivated(HashMap<Integer, Boolean> actions) {
        super.actionsActivated(actions);
        for (Integer i : actions.keySet()) {
            if (actions.get(i).booleanValue() && buildcraft.api.gates.ActionManager.actions[i.intValue()] instanceof Pump) {
                this.getPowerProvider().receiveEnergy(100, Orientations.XNeg);
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

    @Override
    public int getTextureIndexForItem() {
        return 0;
    }
    
    
}
