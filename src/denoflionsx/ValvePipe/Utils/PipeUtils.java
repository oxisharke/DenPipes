package denoflionsx.ValvePipe.Utils;

import buildcraft.transport.PipeTransport;
import buildcraft.transport.PipeTransportLiquids;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.liquids.ILiquidTank;
import net.minecraftforge.liquids.LiquidTank;

public class PipeUtils {

    public static void forcePipeCapacity(PipeTransport pipe, int capacity) {
        for (ILiquidTank tank : ((PipeTransportLiquids) pipe).getTanks(ForgeDirection.UNKNOWN)) {
            LiquidTank t = (LiquidTank)tank;
            t.setCapacity(capacity);
        }
    }
}
