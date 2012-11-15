package common.denoflionsx.ValvePipe.Pipes.IndustrialPipes;

import buildcraft.api.core.Orientations;
import buildcraft.transport.PipeTransportLiquids;
import buildcraft.transport.pipes.PipeLiquidsCobblestone;
import common.denoflionsx.ValvePipe.Utils.PipeUtils;
import common.denoflionsx.ValvePipe.ValvePipeMod;

public class IndustrialCobblestonePipe extends PipeLiquidsCobblestone {
    
    public int textureID = 0;

    public IndustrialCobblestonePipe(int itemID) {
        super(itemID);
        ((PipeTransportLiquids) transport).flowRate = 80 * 2;
        ((PipeTransportLiquids) transport).travelDelay = 1;
        PipeUtils.forcePipeCapacity(transport, ((PipeTransportLiquids) transport).getTanks()[0].getCapacity() * IndustrialPipesCore.PipeCapacityMultiplier);
        textureID = 7;
    }

    @Override
    public String getTextureFile() {
        return ValvePipeMod.Core.texture;
    }

    @Override
    public int getTextureIndex(Orientations direction) {
        return textureID;
    }

}
