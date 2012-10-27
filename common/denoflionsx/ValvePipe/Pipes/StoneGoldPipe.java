package common.denoflionsx.ValvePipe.Pipes;

import buildcraft.api.core.Orientations;
import buildcraft.transport.PipeTransportLiquids;
import buildcraft.transport.pipes.PipeLiquidsStone;
import common.denoflionsx.ValvePipe.ValvePipeMod;

public class StoneGoldPipe extends PipeLiquidsStone {

    public StoneGoldPipe(int itemID) {
        super(itemID);
        ((PipeTransportLiquids) transport).flowRate = 80;
        ((PipeTransportLiquids) transport).travelDelay = 4;
    }

    @Override
    public String getTextureFile() {
        return ValvePipeMod.Core.texture;
    }

    @Override
    public int getTextureIndex(Orientations direction) {
        return 2;
    }
}
