package common.denoflionsx.ValvePipe.Utils;

import buildcraft.api.liquids.ILiquidTank;
import buildcraft.transport.PipeTransport;
import buildcraft.transport.PipeTransportLiquids;

public class PipeUtils {

    public static void forcePipeCapacity(PipeTransport pipe, int capacity) {
        for (ILiquidTank tank : ((PipeTransportLiquids) pipe).getTanks()) {
            tank.setCapacity(capacity);
        }
    }
}
