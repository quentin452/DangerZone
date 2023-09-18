package fr.iamacat.dangerzone_iamacatfr;

import java.io.File;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.config.DangerZoneConfig;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.FairyInstance;
import fr.iamacat.dangerzone_iamacatfr.init.*;
import fr.iamacat.dangerzone_iamacatfr.network.ISidedProxy;
import fr.iamacat.dangerzone_iamacatfr.network.PZPacketHandler;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

@Mod(modid = Tags.MODID, version = Tags.VERSION, name = Tags.MODNAME, acceptedMinecraftVersions = Tags.MCVERSION)
public class DangerZone {

    private File BaseDir;
    private static DangerZoneConfig Config;
    @Mod.Instance(Tags.MODID)
    public static DangerZone instance;
    @SideOnly(Side.CLIENT)
    public static InputConfusedMovement confusedMovementInput;

    @SidedProxy(clientSide = Tags.CLIENTPROXY, serverSide = Tags.SERVERPROXY)
    public static ISidedProxy packetProxy;
    public static PZPacketHandler packetHandler;

    public static Configuration config;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        BaseDir = new File(event.getModConfigurationDirectory(), Tags.MODID);
        Config = new DangerZoneConfig(event.getSuggestedConfigurationFile());

        if (!BaseDir.exists()) BaseDir.mkdir();

        packetProxy.registerRenders();
        EntityInitDangerZone.preInit(event);
        SpawnEggInitDangerZone.preInit(event);
        ItemInitDangerZone.init();
        ItemInitDangerZone.register();
        BlockInitDangerZone.init();
        BlockInitDangerZone.register();
        TileEntityInitDangerZone.init();
        TileEntityInitDangerZone.register();
        RecipeHandler.preInit(event);
        DimensionInitDangerZone.preInit(event);
        EntitySpawningHandler.preInit(event);
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandlerDangerZone());
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {}

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(packetProxy);
    }

    public static FairyInstance getFairy(int fairyID) {
        for (WorldServer dim : DimensionManager.getWorlds()) {
            if (dim != null) {
                List<Entity> entities = dim.loadedEntityList;
                if (entities != null && !entities.isEmpty()) {
                    for (Entity entity : entities) {
                        if (entity instanceof FairyInstance && entity.getEntityId() == fairyID)
                            return (FairyInstance) entity;
                    }
                }
            }
        }
        return null;
    }

}
