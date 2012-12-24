package denoflionsx.ValvePipe.Items;

import denoflionsx.ValvePipe.ValvePipeMod;
import net.minecraft.item.Item;

public class CustomPlate extends Item {

    public static mode Crafting = mode.VANILLA;

    public CustomPlate(int par1) {
        super(par1);
        this.setTextureFile(ValvePipeMod.Core.texture);
        this.setItemName("customplate");
    }

    public static enum mode {

        RAILCRAFT,
        VANILLA;
    }

    public static enum names {

        BRONZE(0, "Bronze Plate"),
        GOLD(1, "Gold Plate"),
        BRONZE_WATER(2, "Water Resistant Bronze Plate"),
        COBBLESTONE(3, "Cobblestone Plate"),
        STONE(4, "Stone Plate"),
        SANDSTONE(5, "Sandstone Plate");
        private int meta;
        private String name;

        private names(int meta, String name) {
            this.meta = meta;
            this.name = name;
        }

        public int getMeta() {
            return meta;
        }

        public String getName() {
            return name;
        }
    }

    public static enum textures {

        BRONZE(0, 16 + 16),
        GOLD(1, 17 + 16),
        BRONZE_WATER(2, 18 + 16),
        COBBLESTONE(3, 21 + 16),
        STONE(4, 20 + 16),
        SANDSTONE(5, 19 + 16);
        private int meta;
        private int index;

        private textures(int meta, int index) {
            this.meta = meta;
            this.index = index;
        }

        public int getMeta() {
            return meta;
        }

        public int getIndex() {
            return index;
        }
    }
}
