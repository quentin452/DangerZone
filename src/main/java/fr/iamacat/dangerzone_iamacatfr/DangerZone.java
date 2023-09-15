package fr.iamacat.dangerzone_iamacatfr;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.init.*;
import fr.iamacat.dangerzone_iamacatfr.network.ISidedProxy;
import fr.iamacat.dangerzone_iamacatfr.network.CommonProxy;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

@Mod(modid = Tags.MODID, version = Tags.VERSION, name = Tags.MODNAME, acceptedMinecraftVersions = Tags.MCVERSION)
public class DangerZone {

    @Mod.Instance(Tags.MODID)
    public static DangerZone instance;
    @SideOnly(Side.CLIENT)
    public static InputConfusedMovement confusedMovementInput;

    @SidedProxy(clientSide = Tags.CLIENTPROXY, serverSide = Tags.SERVERPROXY)
    public static ISidedProxy packetProxy;

    public static Configuration config;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        packetProxy.registerRenders();
        EntityInitDangerZone.preInit(event);
        SpawnEggInitDangerZone.preInit(event);
        ItemInitDangerZone.init();
        ItemInitDangerZone.register();
        DimensionInitDangerZone.preInit(event);
        EntitySpawningHandler.preInit(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {}

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(packetProxy);
    }
}
