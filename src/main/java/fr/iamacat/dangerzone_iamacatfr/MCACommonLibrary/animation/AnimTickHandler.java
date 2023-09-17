
package fr.iamacat.dangerzone_iamacatfr.MCACommonLibrary.animation;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import fr.iamacat.dangerzone_iamacatfr.MCACommonLibrary.IMCAnimatedEntity;
import net.minecraft.entity.Entity;

import java.util.ArrayList;

public class AnimTickHandler
{
    private ArrayList<IMCAnimatedEntity> activeEntities;
    private ArrayList<IMCAnimatedEntity> removableEntities;

    public AnimTickHandler() {
        this.activeEntities = new ArrayList<IMCAnimatedEntity>();
        this.removableEntities = new ArrayList<IMCAnimatedEntity>();
        FMLCommonHandler.instance().bus().register((Object)this);
    }

    public void addEntity(final IMCAnimatedEntity entity) {
        this.activeEntities.add(entity);
    }

    @SubscribeEvent
    public void onClientTick(final TickEvent.ClientTickEvent event) {
        if (!this.activeEntities.isEmpty() && event.phase == TickEvent.Phase.START) {
            for (final IMCAnimatedEntity entity : this.activeEntities) {
                entity.getAnimationHandler().animationsUpdate();
                if (((Entity)entity).isDead) {
                    this.removableEntities.add(entity);
                }
            }
            for (final IMCAnimatedEntity entity : this.removableEntities) {
                this.activeEntities.remove(entity);
            }
            this.removableEntities.clear();
        }
    }

    @SubscribeEvent
    public void onServerTick(final TickEvent.ServerTickEvent event) {
        if (!this.activeEntities.isEmpty() && event.phase == TickEvent.Phase.START) {
            for (final IMCAnimatedEntity entity : this.activeEntities) {
                entity.getAnimationHandler().animationsUpdate();
                if (((Entity)entity).isDead) {
                    this.removableEntities.add(entity);
                }
            }
            for (final IMCAnimatedEntity entity : this.removableEntities) {
                this.activeEntities.remove(entity);
            }
            this.removableEntities.clear();
        }
    }

    @SubscribeEvent
    public void onRenderTick(final TickEvent.RenderTickEvent event) {
    }

    @SubscribeEvent
    public void onWorldTick(final TickEvent.WorldTickEvent event) {
    }
}
