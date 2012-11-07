package common.denoflionsx.ValvePipe.Pipes.PowerPipes;

import buildcraft.api.core.Orientations;
import buildcraft.transport.Pipe;
import buildcraft.transport.PipeTransport;
import buildcraft.transport.PipeTransportPower;
import buildcraft.transport.pipes.PipeLogic;
import buildcraft.transport.pipes.PipeLogicSandstone;
import common.denoflionsx.ValvePipe.ValvePipeMod;

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
    public int getTextureIndex(Orientations direction) {
        return 9;
    }
}
