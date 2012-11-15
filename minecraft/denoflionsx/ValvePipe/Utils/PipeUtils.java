package denoflionsx.ValvePipe.Utils;

import buildcraft.transport.PipeTransport;
import buildcraft.transport.PipeTransportLiquids;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.liquids.ILiquidTank;

public class PipeUtils {

    public static void forcePipeCapacity(PipeTransport pipe, int capacity) {
        for (ILiquidTank tank : ((PipeTransportLiquids) pipe).getTanks(ForgeDirection.UNKNOWN)) {
            tank.setCapacity(capacity);
        }
    }
}
