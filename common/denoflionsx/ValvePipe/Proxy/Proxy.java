package common.denoflionsx.ValvePipe.Proxy;

import buildcraft.transport.ItemPipe;
import common.denoflionsx.ValvePipe.API.ValvePipeManagers;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import java.io.File;
import net.minecraft.src.Item;

public class Proxy {

    public String preloadTexture(String texture) {
        return texture;
    }

    public void registerPipe(ItemPipe pipe, Class c, String name) {
        ValvePipeManagers.PipeManager.registerPipe(pipe, name);
        Item i = (Item) pipe;
        try {
            ObfuscationReflectionHelper.setPrivateValue(Item.class,i,"bZ",name);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public String getConfigDir(){
        return "./" + File.separator + "config" + File.separator + "denoflionsx" + File.separator;
    }
}
