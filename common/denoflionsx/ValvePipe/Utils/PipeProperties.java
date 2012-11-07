package common.denoflionsx.ValvePipe.Utils;

import common.denoflionsx.ValvePipe.ValvePipeMod;
import net.minecraftforge.common.Property;

public class PipeProperties {
    
    public static String getOrCreatePipeProperty(String key, String defaultValue){
        String cat;
        if (key.contains("ItemID")){
            cat = "item";
        }else{
            cat = "general";
        }
        Property p = ValvePipeMod.Core.config.get(cat, key, defaultValue);
        return p.value;
    }
    
    public static int getOrCreatePipeProperty(String key, int defaultValue){
        return Integer.valueOf(getOrCreatePipeProperty(key,String.valueOf(defaultValue)));
    }
    
}
