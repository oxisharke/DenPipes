package common.denoflionsx.ValvePipe.Pipes.PowerPipes;

import buildcraft.api.core.Orientations;
import buildcraft.core.triggers.ActionRedstoneOutput;
import buildcraft.transport.Pipe;
import buildcraft.transport.PipeTransport;
import buildcraft.transport.PipeTransportPower;
import buildcraft.transport.pipes.PipeLogic;
import common.denoflionsx.ValvePipe.Pipes.PowerPipes.Logic.PipeLogicPowerSwitch;
import common.denoflionsx.ValvePipe.ValvePipeMod;
import java.util.HashMap;

public class PowerSwitchPipe extends Pipe {

    public PowerSwitchPipe(PipeTransport transport, PipeLogic logic, int itemID) {
        super(transport, logic, itemID);
        ((PipeTransportPower) transport).powerResitance = 0.001;
    }

    public PowerSwitchPipe(int itemID) {
        this(new PipeTransportPower(), new PipeLogicPowerSwitch(), itemID);
    }

    @Override
    protected void actionsActivated(HashMap<Integer, Boolean> actions) {
        super.actionsActivated(actions);
        boolean wasFound = false;
        PipeLogicPowerSwitch l = (PipeLogicPowerSwitch) this.logic;
        for (Integer i : actions.keySet()) {
            if (actions.get(i).booleanValue() && buildcraft.api.gates.ActionManager.actions[i.intValue()] instanceof ActionRedstoneOutput) {
                wasFound = true;
            }
        }
        l.updatePower(wasFound);
    }

    @Override
    public String getTextureFile() {
        return ValvePipeMod.Core.texture;
    }

    @Override
    public int getTextureIndex(Orientations direction) {
        return 8;
    }
}
