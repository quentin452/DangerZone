package fr.iamacat.dangerzone_iamacatfr.proxy;

import cpw.mods.fml.client.registry.RenderingRegistry;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.*;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.unfinished.BoyFriendInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.unfinished.GirlFriendInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.model.AppleCowModel;
import fr.iamacat.dangerzone_iamacatfr.entities.model.CrystalCowModel;
import fr.iamacat.dangerzone_iamacatfr.entities.model.EnchantedGoldenAppleCowModel;
import fr.iamacat.dangerzone_iamacatfr.entities.model.GoldenAppleCowModel;
import fr.iamacat.dangerzone_iamacatfr.entities.render.*;
import fr.iamacat.dangerzone_iamacatfr.entities.render.unfinished.BoyFriendRenderer;
import fr.iamacat.dangerzone_iamacatfr.entities.render.unfinished.GirlFriendRenderer;
import net.minecraft.client.model.ModelBiped;

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

        RenderingRegistry.registerEntityRenderingHandler(BrownAntInstance.class, new BrownAntRenderer());
        RenderingRegistry.registerEntityRenderingHandler(RedAntInstance.class, new RedAntRenderer());
        RenderingRegistry.registerEntityRenderingHandler(RainbowAntInstance.class, new RainBowAntRenderer());
        RenderingRegistry.registerEntityRenderingHandler(UnstableAntInstance.class, new UnstableAntRenderer());
        RenderingRegistry.registerEntityRenderingHandler(TermiteInstance.class, new TermiteRenderer());

        RenderingRegistry.registerEntityRenderingHandler(
            GirlFriendInstance.class,
            new GirlFriendRenderer(new ModelBiped(0.5f), 0.5f)
        );
        RenderingRegistry.registerEntityRenderingHandler(BoyFriendInstance.class, new BoyFriendRenderer(new ModelBiped(0.5f), 0.5f));
    }
}
