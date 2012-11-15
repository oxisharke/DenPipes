package denoflionsx.ValvePipe.Pipes;

import buildcraft.transport.PipeTransportLiquids;
import buildcraft.transport.pipes.PipeLiquidsStone;
import denoflionsx.ValvePipe.ValvePipeMod;
import net.minecraftforge.common.ForgeDirection;

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
    public int getTextureIndex(ForgeDirection direction) {
        return 2;
    }
}
