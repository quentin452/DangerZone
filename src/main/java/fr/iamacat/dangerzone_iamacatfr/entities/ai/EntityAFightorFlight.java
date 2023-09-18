
package fr.iamacat.dangerzone_iamacatfr.entities.ai;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import fr.iamacat.dangerzone_iamacatfr.angeldragon.EntityAIAvoidEntity;
import fr.iamacat.dangerzone_iamacatfr.api.CustomEntityList;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.EntityGenericCreature;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.EntityGenericTameable;

public class EntityAFightorFlight {

    private int isHurt;
    private float aggroLevel;
    private double aggroRange;
    private EntityGenericCreature entity;
    private EntityAIAvoidEntity aiEntityAvoidEntity;
    private World worldObj;
    private CustomEntityList entityEntry;
    private EntityPlayer entityplayer;
    private boolean temptingItem;
    public float angerLevel;
    public float fleeLevel;

    public EntityAFightorFlight() {
        this.isHurt = 0;
    }

    public EntityAFightorFlight setEntity(final EntityGenericCreature par1, final World par2, final float par3,
        final double par4) {
        this.entity = par1;
        this.worldObj = par2;
        this.aggroLevel = par3;
        this.aggroRange = par4;
        this.aiEntityAvoidEntity = new EntityAIAvoidEntity(this.entity, EntityPlayer.class, 16.0f, 1.3, 1.2);
        return this;
    }

    public EntityAFightorFlight setEntity(final EntityGenericCreature par1, final World par2, final float par3,
        final double par4, final boolean shouldHop) {
        this.entity = par1;
        this.worldObj = par2;
        this.aggroLevel = par3;
        this.aggroRange = par4;
        this.aiEntityAvoidEntity = new EntityAIAvoidEntity(this.entity, EntityPlayer.class, 16.0f, 1.3, 1.2, shouldHop);
        return this;
    }

    public void updateEntityAFF(final World worldobj) {
        final ArrayList<Item> emptyList = new ArrayList<Item>();
        this.updateEntityAFF(worldobj, emptyList);
    }

    public void updateEntityAFF(final World worldobj, final ArrayList<Item> temptItem) {
        ItemStack var1 = null;
        this.entityplayer = this.worldObj.getClosestPlayerToEntity((Entity) this.entity, this.aggroRange);
        this.temptingItem = false;
        if (this.entityplayer != null && !temptItem.isEmpty()) {
            var1 = this.entityplayer.getCurrentEquippedItem();
            for (int i = 0; i < temptItem.size(); ++i) {
                if (var1 != null && temptItem.get(i) != null
                    && temptItem.get(i)
                        .equals(var1.getItem())) {
                    this.entity.setAngerLevel(0);
                    this.entity.setFleeTick(0);
                    this.temptingItem = true;
                    break;
                }
            }
        }
        if (this.aggroRange != 0.0 && !this.temptingItem && !((EntityGenericTameable) this.entity).isTamed()) {
            if (this.entityplayer != null && this.entity.canEntityBeSeen((Entity) this.entityplayer)) {
                if (this.aggroLevel > 0.0f) {
                    final Random rand = new Random();
                    final int dieRoll = rand.nextInt(100);
                    if (this.aggroLevel >= dieRoll) {
                        if (this.entity.getAngerLevel() == 0 && this.entity.getFleeTick() == 0) {
                            this.entity.tasks.removeTask((EntityAIBase) this.aiEntityAvoidEntity);
                            this.entity.setAngerLevel(400);
                        }
                    } else if (this.entity.getAngerLevel() == 0 && this.entity.getFleeTick() == 0) {
                        this.entity.tasks.addTask(1, (EntityAIBase) this.aiEntityAvoidEntity);
                        this.entity.setFleeTick(400);
                    }
                } else {
                    this.entity.tasks.addTask(1, (EntityAIBase) this.aiEntityAvoidEntity);
                    this.entity.setFleeTick(400);
                }
            } else {
                this.entity.setAngerLevel(0);
                this.entity.setFleeTick(0);
            }
        }
    }
}
