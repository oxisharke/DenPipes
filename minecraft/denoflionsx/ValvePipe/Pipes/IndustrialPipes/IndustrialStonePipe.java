package denoflionsx.ValvePipe.Pipes.IndustrialPipes;

import buildcraft.transport.PipeTransportLiquids;
import buildcraft.transport.pipes.PipeLiquidsStone;
import denoflionsx.ValvePipe.Utils.PipeUtils;
import denoflionsx.ValvePipe.ValvePipeMod;
import net.minecraftforge.common.ForgeDirection;

public class IndustrialStonePipe extends PipeLiquidsStone {
    
    public int tex = 0;

    public IndustrialStonePipe(int itemID) {
        super(itemID);
        ((PipeTransportLiquids) transport).flowRate = 80 * 2;
        ((PipeTransportLiquids) transport).travelDelay = 4;
        PipeUtils.forcePipeCapacity(transport, ((PipeTransportLiquids) transport).getTanks(ForgeDirection.UNKNOWN)[0].getCapacity() * IndustrialPipesCore.PipeCapacityMultiplier);
        this.tex = 6;
    }

    @Override
    public String getTextureFile() {
        return ValvePipeMod.Core.texture;
    }

    @Override
    public int getTextureIndex(ForgeDirection direction) {
        return tex;
    }
 
}
