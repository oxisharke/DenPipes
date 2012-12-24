package denoflionsx.ValvePipe.Items;

import denoflionsx.ValvePipe.Interfaces.IPipeCore;
import denoflionsx.ValvePipe.ValvePipeMod;
import net.minecraft.item.Item;

public class ItemsCore implements IPipeCore {

    public static Item Plates;

    @Override
    public void createActions() {
    }

    @Override
    public void createPipes() {
        Plates = new CustomPlateMulti();
        Plates.setCreativeTab(ValvePipeMod.Core.tab);
    }
}
