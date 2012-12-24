package denoflionsx.ValvePipe.Utils;

import buildcraft.transport.BlockGenericPipe;
import buildcraft.transport.ItemPipe;
import denoflionsx.ValvePipe.ValvePipeMod;
import java.lang.reflect.Method;

public class CreatePipe {

    public static void Create(String name, int ID, Class clazz, Method recipe) {
        ItemPipe pipe = BlockGenericPipe.registerPipe(ID, clazz);
        ValvePipeMod.proxy.registerPipe(pipe, clazz, name);
        try {
            recipe.invoke(null, pipe);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
