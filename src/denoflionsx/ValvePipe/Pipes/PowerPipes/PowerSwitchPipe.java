package denoflionsx.ValvePipe.Pipes.PowerPipes;

import buildcraft.api.gates.IAction;
import buildcraft.transport.Pipe;
import buildcraft.transport.PipeTransport;
import buildcraft.transport.PipeTransportPower;
import buildcraft.transport.pipes.PipeLogic;
import denoflionsx.ValvePipe.Actions.Flow;
import denoflionsx.ValvePipe.Pipes.PowerPipes.Logic.PipeLogicPowerSwitch;
import denoflionsx.ValvePipe.ValvePipeMod;
import java.util.HashMap;
import java.util.LinkedList;

import net.minecraftforge.common.ForgeDirection;

public class PowerSwitchPipe extends Pipe {

    public PowerSwitchPipe(PipeTransport transport, PipeLogic logic, int itemID) {
        super(transport, logic, itemID);
        ((PipeTransportPower) transport).powerResistance = 0.001;
    }

    public PowerSwitchPipe(int itemID) {
        this(new PipeTransportPower(), new PipeLogicPowerSwitch(), itemID);
    }
    
    @Override
    public LinkedList<IAction> getActions() {
        LinkedList<IAction> actions = super.getActions();
        actions.add(PowerPipesCore.flowAction);
        return actions;
    }

    @Override
    protected void actionsActivated(HashMap<Integer, Boolean> actions) {
        super.actionsActivated(actions);
        boolean wasFound = false;
        PipeLogicPowerSwitch l = (PipeLogicPowerSwitch) this.logic;
        for (Integer i : actions.keySet()) {
            if (actions.get(i).booleanValue() && buildcraft.api.gates.ActionManager.actions[i.intValue()] instanceof Flow) {
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
    public int getTextureIndex(ForgeDirection direction) {
        return 8;
    }
}
