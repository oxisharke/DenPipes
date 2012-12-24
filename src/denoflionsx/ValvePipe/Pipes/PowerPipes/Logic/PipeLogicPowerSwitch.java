package denoflionsx.ValvePipe.Pipes.PowerPipes.Logic;

import buildcraft.api.power.IPowerReceptor;
import buildcraft.core.IMachine;
import buildcraft.transport.Pipe;
import buildcraft.transport.TileGenericPipe;
import buildcraft.transport.pipes.PipeLogic;
import buildcraft.transport.pipes.PipePowerGold;
import buildcraft.transport.pipes.PipePowerStone;
import buildcraft.transport.pipes.PipePowerWood;
import net.minecraft.tileentity.TileEntity;

public class PipeLogicPowerSwitch extends PipeLogic {

    private boolean lastPower = false;

    public PipeLogicPowerSwitch() {
    }

    public void updatePower(boolean power) {
        if (power != lastPower) {
            lastPower = power;
            this.container.scheduleRenderUpdate();
        }
    }

    @Override
    public boolean isPipeConnected(TileEntity tile) {
        if (tile instanceof IMachine) {
            return true;
        }
        if (tile instanceof IPowerReceptor){
            if (!(tile instanceof TileGenericPipe)){
                return true;
            }
        }
        if (lastPower) {
            return false;
        } else {
            if (tile instanceof TileGenericPipe) {
                Pipe pipe = ((TileGenericPipe) tile).pipe;
                if (pipe instanceof PipePowerGold || pipe instanceof PipePowerStone || pipe instanceof PipePowerWood) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}
