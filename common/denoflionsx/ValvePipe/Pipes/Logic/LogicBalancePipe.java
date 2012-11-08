package common.denoflionsx.ValvePipe.Pipes.Logic;

import buildcraft.api.liquids.ITankContainer;
import buildcraft.core.IMachine;
import buildcraft.transport.TileGenericPipe;
import buildcraft.transport.pipes.PipeLogic;
import net.minecraft.src.TileEntity;

public class LogicBalancePipe extends PipeLogic{

    public LogicBalancePipe() {
    }

    @Override
    public boolean isPipeConnected(TileEntity tile) {
        if (tile instanceof IMachine) {
            return true;
        }
        if (tile instanceof ITankContainer){
            if (!(tile instanceof TileGenericPipe)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void updateEntity() {
        
    }

}
