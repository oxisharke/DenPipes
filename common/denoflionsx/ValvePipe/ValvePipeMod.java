package common.denoflionsx.ValvePipe;

import common.denoflionsx.ValvePipe.Core.ValvePipeCore;
import common.denoflionsx.ValvePipe.Proxy.Proxy;
import common.denoflionsx.ValvePipe.Version.Version;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = "ValvePipe", name = "Valve Pipe", version = Version.version, dependencies = "required-after:BuildCraft|Transport;required-after:BuildCraft|Energy")
@NetworkMod(clientSideRequired = true, serverSideRequired = true)
public class ValvePipeMod {

    @Mod.Instance("vp")
    public static ValvePipeMod vp;
    @SidedProxy(clientSide = "common.denoflionsx.ValvePipe.Proxy.ProxyClient", serverSide = "common.denoflionsx.ValvePipe.Proxy.ProxyServer")
    public static Proxy proxy;
    public static ValvePipeCore Core;

    public ValvePipeMod() {
        vp = this;
        Core = new ValvePipeCore();
    }

    @Mod.PreInit
    public void preLoad(FMLPreInitializationEvent event) {
        Core.loadTexture();
    }

    @Mod.Init
    public void load(FMLInitializationEvent event) {
        Core.createAction();
    }

    @Mod.PostInit
    public void modsLoaded(FMLPostInitializationEvent evt) {
        Core.createPipe();
    }
}
