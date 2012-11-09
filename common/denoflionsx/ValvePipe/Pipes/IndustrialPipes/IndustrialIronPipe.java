package common.denoflionsx.ValvePipe.Pipes.IndustrialPipes;

import buildcraft.api.core.Orientations;
import buildcraft.transport.PipeTransportLiquids;
import buildcraft.transport.pipes.PipeLiquidsIron;
import common.denoflionsx.ValvePipe.ValvePipeMod;

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
    public int getTextureIndex(Orientations direction) {
        return super.getTextureIndex(direction);
    }

}
