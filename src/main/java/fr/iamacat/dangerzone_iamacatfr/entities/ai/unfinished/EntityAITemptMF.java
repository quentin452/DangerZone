

package fr.iamacat.dangerzone_iamacatfr.entities.ai.unfinished;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.EntityGenericCreature;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;

public class EntityAITemptMF extends EntityAIBase
{
    private EntityGenericCreature temptedEntity;
    private float speed;
    private double targetX;
    private double targetY;
    private double targetZ;
    private double field_75278_f;
    private double field_75279_g;
    private boolean shouldHop;
    private int slimeJumpDelay;
    private boolean returnVal;
    private EntityPlayer temptingPlayer;
    private int delayTemptCounter;
    private boolean isRunning;
    private ArrayList<Item> breedingFood;
    private boolean scaredByPlayerMovement;
    private boolean field_75286_m;

    public EntityAITemptMF(final EntityGenericCreature par1EntityCreature, final float par2, final ArrayList<Item> par3, final boolean par4) {
        this.shouldHop = false;
        this.slimeJumpDelay = 0;
        this.returnVal = false;
        this.delayTemptCounter = 0;
        this.temptedEntity = par1EntityCreature;
        this.speed = par2;
        this.breedingFood = par3;
        this.scaredByPlayerMovement = par4;
        this.setMutexBits(3);
    }

    public EntityAITemptMF(final EntityGenericCreature par1EntityCreature, final float par2, final ArrayList<Item> par3, final boolean par4, final boolean shouldHop) {
        this(par1EntityCreature, par2, par3, par4);
        this.shouldHop = shouldHop;
    }

    public boolean shouldExecute() {
        if (this.delayTemptCounter > 0) {
            --this.delayTemptCounter;
            return false;
        }
        this.temptingPlayer = this.temptedEntity.worldObj.getClosestPlayerToEntity((Entity)this.temptedEntity, 10.0);
        this.returnVal = false;
        if (this.temptingPlayer == null) {
            return false;
        }
        final ItemStack var1 = this.temptingPlayer.getCurrentEquippedItem();
        if (var1 != null) {
            for (int i = 0; i < this.breedingFood.size(); ++i) {
                if (this.breedingFood.get(i).equals(var1.getItem())) {
                    this.returnVal = true;
                    break;
                }
            }
        }
        return this.returnVal;
    }

    public boolean continueExecuting() {
        if (this.shouldHop) {
            this.tryToHop();
        }
        if (this.scaredByPlayerMovement) {
            if (this.temptedEntity.getDistanceSqToEntity((Entity)this.temptingPlayer) < 36.0) {
                if (this.temptingPlayer.getDistanceSq(this.targetX, this.targetY, this.targetZ) > 0.010000000000000002) {
                    return false;
                }
                if (Math.abs(this.temptingPlayer.rotationPitch - this.field_75278_f) > 5.0 || Math.abs(this.temptingPlayer.rotationYaw - this.field_75279_g) > 5.0) {
                    return false;
                }
            }
            else {
                this.targetX = this.temptingPlayer.posX;
                this.targetY = this.temptingPlayer.posY;
                this.targetZ = this.temptingPlayer.posZ;
            }
            this.field_75278_f = this.temptingPlayer.rotationPitch;
            this.field_75279_g = this.temptingPlayer.rotationYaw;
        }
        return this.shouldExecute();
    }

    public void startExecuting() {
        if (this.shouldHop) {
            this.tryToHop();
        }
        this.targetX = this.temptingPlayer.posX;
        this.targetY = this.temptingPlayer.posY;
        this.targetZ = this.temptingPlayer.posZ;
        this.isRunning = true;
        this.field_75286_m = this.temptedEntity.getNavigator().getAvoidsWater();
        this.temptedEntity.getNavigator().setAvoidsWater(false);
    }

    public void resetTask() {
        if (this.shouldHop) {
            this.tryToHop();
        }
        this.temptingPlayer = null;
        this.temptedEntity.getNavigator().clearPathEntity();
        this.delayTemptCounter = 100;
        this.isRunning = false;
        this.temptedEntity.getNavigator().setAvoidsWater(this.field_75286_m);
    }

    public void updateTask() {
        this.temptedEntity.getLookHelper().setLookPositionWithEntity((Entity)this.temptingPlayer, 30.0f, (float)this.temptedEntity.getVerticalFaceSpeed());
        if (this.temptedEntity.getDistanceSqToEntity((Entity)this.temptingPlayer) < 6.25) {
            this.temptedEntity.getNavigator().clearPathEntity();
        }
        else {
            this.temptedEntity.getNavigator().tryMoveToEntityLiving((Entity)this.temptingPlayer, (double)this.speed);
        }
        if (this.shouldHop) {
            this.tryToHop();
        }
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    public void tryToHop() {
        if (this.temptedEntity.onGround) {
            if (this.temptedEntity.onGround && this.slimeJumpDelay-- <= 0) {
                this.slimeJumpDelay = this.getJumpDelay();
                this.temptedEntity.getJumpHelper().setJumping();
                this.temptedEntity.getNavigator().setSpeed((double)this.speed);
            }
            else {
                this.temptedEntity.getNavigator().setSpeed(0.0);
            }
        }
    }

    protected int getJumpDelay() {
        return this.temptedEntity.getRNG().nextInt(20) + 10;
    }
}
