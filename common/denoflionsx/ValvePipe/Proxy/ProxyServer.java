package common.denoflionsx.ValvePipe.Proxy;

import buildcraft.transport.ItemPipe;

public class ProxyServer extends Proxy{

    @Override
    public String getConfigDir() {
        return super.getConfigDir();
    }

    @Override
    public String preloadTexture(String texture) {
        return super.preloadTexture(texture);
    }

    @Override
    public void registerPipe(ItemPipe pipe, Class c, String name) {
        super.registerPipe(pipe, c, name);
    }
}
