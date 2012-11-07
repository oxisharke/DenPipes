package common.denoflionsx.ValvePipe.Utils;

import buildcraft.transport.ItemPipe;
import java.lang.reflect.Method;

public class GetRecipeMethod {
    
    public static Method getMethod(String clazz, String method){
        try{
            Class c = Class.forName(clazz);
            Method m = c.getMethod(method, ItemPipe.class);
            return m;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    } 
}
