package common.denoflionsx.ValvePipe.Items;

import common.denoflionsx.ValvePipe.Interfaces.IPipeCore;
import common.denoflionsx.ValvePipe.ValvePipeMod;
import net.minecraft.src.Item;

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
