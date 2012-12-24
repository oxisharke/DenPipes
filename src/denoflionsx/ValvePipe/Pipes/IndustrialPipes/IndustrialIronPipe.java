package denoflionsx.ValvePipe.Pipes.IndustrialPipes;

import buildcraft.transport.PipeTransportLiquids;
import buildcraft.transport.pipes.PipeLiquidsIron;
import denoflionsx.ValvePipe.ValvePipeMod;
import net.minecraftforge.common.ForgeDirection;

public class IndustrialIronPipe extends PipeLiquidsIron {

    public IndustrialIronPipe(int itemID) {
        super(itemID);
        ((PipeTransportLiquids) transport).flowRate = 80 * 2;
        ((PipeTransportLiquids) transport).travelDelay = 4;
    }

    @Override
    public String getTextureFile() {
        return ValvePipeMod.Core.texture;
    }

    @Override
    public int getTextureIndex(ForgeDirection direction) {
        return super.getTextureIndex(direction);
    }
}
