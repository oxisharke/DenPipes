package common.denoflionsx.ValvePipe.Proxy;

import buildcraft.transport.ItemPipe;
import buildcraft.transport.TransportProxyClient;
import java.io.File;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.MinecraftForgeClient;

public class ProxyClient extends Proxy {

    @Override
    public String preloadTexture(String texture) {
        MinecraftForgeClient.preloadTexture(texture);
        return texture;
    }

    @Override
    public void registerPipe(ItemPipe pipe, Class c, String name) {
        super.registerPipe(pipe, c, name);
        MinecraftForgeClient.registerItemRenderer(pipe.shiftedIndex, TransportProxyClient.pipeItemRenderer);
    }

    @Override
    public String getConfigDir() {
        return Minecraft.getMinecraftDir() + File.separator + "config" + File.separator + "denoflionsx" + File.separator + "ValvePipe" + File.separator;
    }
}