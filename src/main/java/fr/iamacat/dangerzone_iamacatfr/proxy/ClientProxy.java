package fr.iamacat.dangerzone_iamacatfr.proxy;

import cpw.mods.fml.client.registry.RenderingRegistry;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.unfinished.AppleCowInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.model.unfinished.AppleCowModel;
import fr.iamacat.dangerzone_iamacatfr.entities.render.unfinished.AppleCowRenderer;

public class ClientProxy extends CommonProxy {

    @Override
    public void registerRenders() {
        RenderingRegistry
            .registerEntityRenderingHandler(AppleCowInstance.class, new AppleCowRenderer(new AppleCowModel(), 0.5F));
    }
}
