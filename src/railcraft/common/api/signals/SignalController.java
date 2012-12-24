/*
 * This code is the property of CovertJaguar
 * and may only be used with explicit written
 * permission unless otherwise specified on the
 * license page at railcraft.wikispaces.com.
 */
package railcraft.common.api.signals;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import railcraft.common.api.core.WorldCoordinate;

/**
 *
 * @author CovertJaguar <railcraft.wikispaces.com>
 */
public class SignalController extends AbstractPair {

    private SignalAspect aspect = SignalAspect.BLINK_RED;

    public SignalController(String desc, TileEntity tile, byte maxPairings) {
        super(desc, tile, maxPairings);
    }

    @Override
    public void tickClient() {
        super.tickClient();
        if (SignalTools.effectManager != null && SignalTools.effectManager.isTuningAuraActive()) {
            for (WorldCoordinate coord : pairings) {
                SignalReceiver receiver = getReceiverAt(coord);
                if (receiver != null) {
                    SignalTools.effectManager.tuningEffect(getTile(), receiver.getTile());
                }
            }
        }
    }

    public SignalAspect getAspect() {
        return aspect;
    }

    public void registerReceiver(SignalReceiver receiver) {
        addPairing(receiver.getCoords());
        receiver.registerController(this);
    }

    @Deprecated
    public void registerLegacyReceiver(int x, int y, int z) {
        pairings.add(new WorldCoordinate(0, x, y, z));
    }

    @Override
    public boolean isValidPair(TileEntity tile) {
        if (tile instanceof IReceiverTile) {
            SignalReceiver receiver = ((IReceiverTile) tile).getReceiver();
            return receiver.isPairedWith(getCoords());
        }
        return false;
    }

    public SignalReceiver getReceiverAt(WorldCoordinate coord) {
        TileEntity recv = getPairAt(coord);
        if (recv != null) {
            return ((IReceiverTile) recv).getReceiver();
        }
        return null;
    }

    public void updateAspect() {
        for (WorldCoordinate recv : pairings) {
            SignalReceiver receiver = getReceiverAt(recv);
            if (receiver != null) {
                receiver.onControllerAspectChange(this, aspect);
            }
        }
        cleanPairings();
    }

    public void setAspect(SignalAspect aspect) {
        if (this.aspect != aspect) {
            this.aspect = aspect;
            updateAspect();
        }
    }

    @Override
    protected String getTagName() {
        return "controller";
    }

    @Override
    protected void saveNBT(NBTTagCompound data) {
        super.saveNBT(data);
        data.setByte("aspect", (byte) aspect.ordinal());
    }

    @Override
    protected void loadNBT(NBTTagCompound data) {
        super.loadNBT(data);
        aspect = SignalAspect.values()[data.getByte("aspect")];
    }

    public void writePacketData(DataOutputStream data) throws IOException {
        data.writeByte(aspect.ordinal());
    }

    public void readPacketData(DataInputStream data) throws IOException {
        aspect = SignalAspect.values()[data.readByte()];
    }
}
