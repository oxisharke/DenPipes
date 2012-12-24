package denoflionsx.ValvePipe.Pipes.PowerPipes;

import buildcraft.transport.Pipe;
import buildcraft.transport.PipeTransport;
import buildcraft.transport.PipeTransportPower;
import buildcraft.transport.pipes.PipeLogic;
import buildcraft.transport.pipes.PipeLogicSandstone;
import denoflionsx.ValvePipe.ValvePipeMod;
import net.minecraftforge.common.ForgeDirection;

public class SandstoneGoldPowerPipe extends Pipe{

    public SandstoneGoldPowerPipe(PipeTransport transport, PipeLogic logic, int itemID) {
        super(transport, logic, itemID);
    }

    public SandstoneGoldPowerPipe(int itemID) {
        this(new PipeTransportPower(), new PipeLogicSandstone(), itemID);
    }

    @Override
    public String getTextureFile() {
        return ValvePipeMod.Core.texture;
    }

    @Override
    public int getTextureIndex(ForgeDirection direction) {
        return 9;
    }
}
