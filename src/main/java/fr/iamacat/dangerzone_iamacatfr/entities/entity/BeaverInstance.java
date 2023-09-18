
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import java.util.EnumSet;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import fr.iamacat.dangerzone_iamacatfr.api.CustomEntityList;
import fr.iamacat.dangerzone_iamacatfr.entities.ai.*;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class BeaverInstance extends EntityGenericAnimal implements IAnimals {

    private EntityAFightorFlight EAFF;
    private CustomEntityList entityEntry;
    private float aggroLevel;
    private double aggroRange;

    public BeaverInstance(final World par1World) {
        super(par1World);
        this.setSize(0.63f, 0.8f);
        this.entityEntry = CustomEntityList.getByName(EntityList.getEntityString((Entity) this));
        if (this.entityEntry != null && this.entityEntry.modData.get().entityProperties != null) {
            this.aggroLevel = this.entityEntry.modData.get().entityProperties.aggroLevel;
            this.aggroRange = this.entityEntry.modData.get().entityProperties.aggroRange;
        }
        if (Math.round(this.aggroRange) != 0L) {
            this.EAFF = new EntityAFightorFlight().setEntity(this, this.worldObj, this.aggroLevel, this.aggroRange);
        }
        this.getNavigator()
            .setAvoidsWater(false);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 1.25f));
        this.tasks.addTask(3, new EntityAIAttackOnCollide(this, 1.0f, false));
        this.tasks.addTask(9, new EntityAIWander(this, 1.0f, 120));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, false, false));
        this.targetTasks.addTask(
            4,
            new EntityAINearestAttackableTarget(
                this,
                EnumSet.of(EntityStates.attacking, EntityStates.looking),
                EntityPlayer.class,
                16.0f,
                0,
                true));
    }

    @Override
    protected boolean isValidLocation(final World world, final int xCoord, final int yCoord, final int zCoord) {
        return super.isValidLocation(world, xCoord, yCoord, zCoord)
            && this.worldObj.canBlockSeeTheSky(xCoord, yCoord, zCoord);
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (Math.round(this.aggroRange) != 0L) {
            this.EAFF.updateEntityAFF(this.worldObj);
        }
    }

    public int getTotalArmorValue() {
        return 0;
    }

    protected String getHurtSound() {
        return Tags.MODID + ":sounds/mob/beaverliving.ogg";
    }

    public int getTalkInterval() {
        return 160;
    }

    protected void dropRareDrop(final int par1) {}
}
