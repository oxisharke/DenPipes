package denoflionsx.ValvePipe.Utils;

import denoflionsx.ValvePipe.ValvePipeMod;
import java.lang.reflect.Field;

public class ReflectUtils {
    
    public static boolean doesPipeExist(String name){
        try{
            ValvePipeMod.Core.print("Scanning for " + name + ".");
            Class c = Class.forName("buildcraft.BuildCraftTransport");
            Field fields[] = c.getDeclaredFields();
            for (Field f : fields){
                if (f.getName().equals(name)){
                    return true;
                }
            }
            return false;
        }catch(Exception ex){
            return false;
        }
    }
    
}
