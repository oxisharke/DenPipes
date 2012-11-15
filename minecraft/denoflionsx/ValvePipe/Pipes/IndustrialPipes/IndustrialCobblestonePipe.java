package denoflionsx.ValvePipe.Pipes.IndustrialPipes;

import buildcraft.transport.PipeTransportLiquids;
import buildcraft.transport.pipes.PipeLiquidsCobblestone;
import denoflionsx.ValvePipe.Utils.PipeUtils;
import denoflionsx.ValvePipe.ValvePipeMod;
import net.minecraftforge.common.ForgeDirection;

public class IndustrialCobblestonePipe extends PipeLiquidsCobblestone {
    
    public int textureID = 0;

    public IndustrialCobblestonePipe(int itemID) {
        super(itemID);
        ((PipeTransportLiquids) transport).flowRate = 80 * 2;
        ((PipeTransportLiquids) transport).travelDelay = 1;
        PipeUtils.forcePipeCapacity(transport, ((PipeTransportLiquids) transport).getTanks(ForgeDirection.UNKNOWN)[0].getCapacity() * IndustrialPipesCore.PipeCapacityMultiplier);
        textureID = 7;
    }

    @Override
    public String getTextureFile() {
        return ValvePipeMod.Core.texture;
    }

    @Override
    public int getTextureIndex(ForgeDirection direction) {
        return textureID;
    }

}
