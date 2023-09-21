
package danger.orespawn.proxy;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import danger.orespawn.entities.other.RiderControlMessage;
import danger.orespawn.entities.other.RiderControlMessageHandler;

public class CommonProxyOreSpawn {

    private SimpleNetworkWrapper network;

    public SimpleNetworkWrapper getNetwork() {
        return this.network;
    }

    public void registerRenderThings() {}

    public void registerSoundThings() {}

    public void registerKeyboardInput() {}

    public void registerNetworkStuff() {
        (this.network = NetworkRegistry.INSTANCE.newSimpleChannel("RiderControls"))
            .registerMessage(RiderControlMessageHandler.class, RiderControlMessage.class, 0, Side.SERVER);
    }

    public int setArmorPrefix(final String string) {
        return 0;
    }
}
