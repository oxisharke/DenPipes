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
 * If you are doing anything more fancy than a 1 to 1 paring, you will probably
 * need to create your own subclass and override onControllerAspectChange().
 *
 * @author CovertJaguar <railcraft.wikispaces.com>
 */
public class SignalReceiver extends AbstractPair {

    private SignalAspect aspect = SignalAspect.BLINK_RED;
    private boolean needsInit = true;

    public SignalReceiver(String desc, TileEntity tile, byte maxPairings) {
        super(desc, tile, maxPairings);
    }

    @Override
    public void tickServer() {
        super.tickServer();
        if (needsInit) {
            needsInit = false;
            if (!pairings.isEmpty()) {
                SignalController controller = getControllerAt(pairings.getFirst());
                if (controller != null) {
                    onControllerAspectChange(controller, controller.getAspect());
                }
            }
        }
    }

    protected void registerController(SignalController controller) {
        addPairing(controller.getCoords());
    }

    @Deprecated
    public void registerLegacyController(int x, int y, int z) {
        pairings.add(new WorldCoordinate(0, x, y, z));
    }

    @Override
    public boolean isValidPair(TileEntity tile) {
        if (tile instanceof IControllerTile) {
            SignalController controller = ((IControllerTile) tile).getController();
            return controller.isPairedWith(getCoords());
        }
        return false;
    }

    public SignalController getControllerAt(WorldCoordinate coord) {
        TileEntity con = getPairAt(coord);
        if (con != null) {
            return ((IControllerTile) con).getController();
        }
        return null;
    }

    public SignalAspect getAspect() {
        return aspect;
    }

    public void setAspect(SignalAspect aspect) {
        this.aspect = aspect;
    }

    public void onControllerAspectChange(SignalController con, SignalAspect aspect) {
        this.aspect = aspect;
        ((IReceiverTile) tile).onControllerAspectChange(con, aspect);
    }

    @Override
    protected String getTagName() {
        return "receiver";
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
