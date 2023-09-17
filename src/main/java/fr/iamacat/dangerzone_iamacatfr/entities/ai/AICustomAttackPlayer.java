package fr.iamacat.dangerzone_iamacatfr.entities.ai;

import java.util.List;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;

public class AICustomAttackPlayer extends EntityAIBase {

    private final EntityCreature entity;
    private EntityLivingBase target;

    public AICustomAttackPlayer(EntityCreature entity) {
        this.entity = entity;
        this.setMutexBits(1); // Assurez-vous de régler correctement les bits mutex en fonction de votre configuration.
    }

    @Override
    public boolean shouldExecute() {
        List<EntityPlayer> players = entity.worldObj.getEntitiesWithinAABB(
            EntityPlayer.class,
            entity.getBoundingBox()
                .expand(16.0D, 4.0D, 16.0D));
        if (!players.isEmpty()) {
            target = players.get(0); // Prend le premier joueur trouvé, vous pouvez personnaliser cette logique de
                                     // sélection
            return true;
        }
        return false;
    }

    @Override
    public void startExecuting() {
        super.startExecuting();
        entity.setAttackTarget(target);
    }

    @Override
    public boolean continueExecuting() {
        return target != null && target.isEntityAlive() && entity.getDistanceSqToEntity(target) <= 16.0D;
    }
}
