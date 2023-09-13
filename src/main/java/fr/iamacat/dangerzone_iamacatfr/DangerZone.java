package fr.iamacat.dangerzone_iamacatfr;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import fr.iamacat.dangerzone_iamacatfr.init.EntityInitDangerZone;
import fr.iamacat.dangerzone_iamacatfr.init.SpawnEggInitDangerZone;
import fr.iamacat.dangerzone_iamacatfr.proxy.CommonProxy;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

@Mod(modid = Tags.MODID, version = Tags.VERSION, name = Tags.MODNAME, acceptedMinecraftVersions = Tags.MCVERSION)
public class DangerZone {

    @Mod.Instance(Tags.MODID)
    public static DangerZone instance;
    @SidedProxy(clientSide = Tags.CLIENTPROXY, serverSide = Tags.SERVERPROXY)
    public static CommonProxy proxy;
    public static Configuration config;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        proxy.registerRenders();
        EntityInitDangerZone.preInit(event);
        SpawnEggInitDangerZone.preInit(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {}

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(proxy);
    }
}
