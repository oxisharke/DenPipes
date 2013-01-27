package denoflionsx.ValvePipe.Pipes;

import buildcraft.api.gates.IAction;
import buildcraft.transport.PipeTransportLiquids;
import buildcraft.transport.pipes.PipeLiquidsWood;
import denoflionsx.ValvePipe.Actions.Pump;
import denoflionsx.ValvePipe.Core.ValvePipeCore;
import denoflionsx.ValvePipe.ValvePipeMod;
import java.util.HashMap;
import java.util.LinkedList;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.liquids.LiquidContainerRegistry;

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
        if (liquidToExtract <= LiquidContainerRegistry.BUCKET_VOLUME) {
            liquidToExtract += this.getPowerProvider().useEnergy(100, 100, true) * LiquidContainerRegistry.BUCKET_VOLUME;
        }
    }

    @Override
    protected void actionsActivated(HashMap<Integer, Boolean> actions) {
        super.actionsActivated(actions);
        for (Integer i : actions.keySet()) {
            if (actions.get(i).booleanValue() && buildcraft.api.gates.ActionManager.actions[i.intValue()] instanceof Pump) {
                this.getPowerProvider().receiveEnergy(100, ForgeDirection.DOWN);
            }
        }
    }
    

    @Override
    public String getTextureFile() {
        return ValvePipeMod.Core.texture;
    }

     @Override
    public int getTextureIndex(ForgeDirection direction) {
        if (direction == ForgeDirection.UNKNOWN) {
            return 0;
        } else {
            int metadata = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);

            if (metadata == direction.ordinal()) {
                return 14;
            } else {
                return 0;
            }
        }
    }
     
}
