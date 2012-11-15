package common.denoflionsx.ValvePipe.Pipes.IndustrialPipes;

import buildcraft.api.core.Orientations;
import buildcraft.transport.PipeTransportLiquids;
import buildcraft.transport.pipes.PipeLiquidsStone;
import common.denoflionsx.ValvePipe.Utils.PipeUtils;
import common.denoflionsx.ValvePipe.ValvePipeMod;

public class IndustrialStonePipe extends PipeLiquidsStone {
    
    public int tex = 0;

    public IndustrialStonePipe(int itemID) {
        super(itemID);
        ((PipeTransportLiquids) transport).flowRate = 80 * 2;
        ((PipeTransportLiquids) transport).travelDelay = 4;
        PipeUtils.forcePipeCapacity(transport, ((PipeTransportLiquids) transport).getTanks()[0].getCapacity() * IndustrialPipesCore.PipeCapacityMultiplier);
        this.tex = 6;
    }

    @Override
    public String getTextureFile() {
        return ValvePipeMod.Core.texture;
    }

    @Override
    public int getTextureIndex(Orientations direction) {
        return tex;
    }
}
