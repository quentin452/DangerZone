package fr.iamacat.dangerzone_iamacatfr.proxy;

import cpw.mods.fml.client.registry.RenderingRegistry;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.AppleCowInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.CrystalCowInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.EnchantedGoldenAppleCowInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.GoldenAppleCowInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.model.AppleCowModel;
import fr.iamacat.dangerzone_iamacatfr.entities.model.CrystalCowModel;
import fr.iamacat.dangerzone_iamacatfr.entities.model.EnchantedGoldenAppleCowModel;
import fr.iamacat.dangerzone_iamacatfr.entities.model.GoldenAppleCowModel;
import fr.iamacat.dangerzone_iamacatfr.entities.render.AppleCowRenderer;
import fr.iamacat.dangerzone_iamacatfr.entities.render.CrystalCowRenderer;
import fr.iamacat.dangerzone_iamacatfr.entities.render.EnchantedGoldenAppleCowRenderer;
import fr.iamacat.dangerzone_iamacatfr.entities.render.GoldenAppleCowRenderer;

public class ClientProxy extends CommonProxy {

    @Override
    public void registerRenders() {
        RenderingRegistry
            .registerEntityRenderingHandler(AppleCowInstance.class, new AppleCowRenderer(new AppleCowModel(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(
            CrystalCowInstance.class,
            new CrystalCowRenderer(new CrystalCowModel(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(
            EnchantedGoldenAppleCowInstance.class,
            new EnchantedGoldenAppleCowRenderer(new EnchantedGoldenAppleCowModel(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(
            GoldenAppleCowInstance.class,
            new GoldenAppleCowRenderer(new GoldenAppleCowModel(), 0.5F));
    }
}
