
package danger.orespawn.entities.entityinstance;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import danger.orespawn.entities.ai.MyEntityAIWander;
import danger.orespawn.utils.GenericTargetSorter;

public class Peacock extends EntityAnimal {

    private float moveSpeed;
    int my_blink;
    int blinkcount;
    int blinker;
    private GenericTargetSorter TargetSorter;

    public Peacock(final World par1World) {
        super(par1World);
        this.moveSpeed = 0.38f;
        this.my_blink = 0;
        this.blinkcount = 0;
        this.blinker = 0;
        this.TargetSorter = null;
        this.setSize(0.65f, 1.2f);
        this.fireResistance = 100;
        this.experienceValue = 8;
        this.my_blink = 20 + this.rand.nextInt(50);
        this.blinkcount = 0;
        this.blinker = 0;
        this.TargetSorter = new GenericTargetSorter(this);
        this.getNavigator()
            .setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIMate((EntityAnimal) this, 1.0));
        this.tasks.addTask(2, new EntityAIAvoidEntity(this, EntityMob.class, 8.0f, 1.0, 1.399999976158142));
        this.tasks.addTask(
            3,
            new EntityAIAvoidEntity(this, EntityPlayer.class, 12.0f, 1.2000000476837158, 1.600000023841858));
        this.tasks.addTask(4, new EntityAIPanic(this, 1.5));
        this.tasks.addTask(5, new MyEntityAIWander(this, 1.0f));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        if (OreSpawnMain.PlayNicely == 0) {
            this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, Termite.class, 6, true));
        }
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(this.moveSpeed);
        this.getAttributeMap()
            .registerAttribute(SharedMonsterAttributes.attackDamage);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(4.0);
    }

    protected void entityInit() {
        super.entityInit();
    }

    public int getBlink() {
        return this.blinker;
    }

    public void onUpdate() {
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(this.moveSpeed);
        super.onUpdate();
        ++this.blinkcount;
        if (this.blinkcount > this.my_blink) {
            this.blinkcount = 0;
            if (this.blinker > 0) {
                this.blinker = 0;
                this.my_blink = 50 + this.worldObj.rand.nextInt(300);
            } else {
                this.blinker = 1;
                this.my_blink = 25 + this.worldObj.rand.nextInt(100);
            }
        }
    }

    public boolean getCanSpawnHere() {
        for (int k = -1; k < 1; ++k) {
            for (int j = -1; j < 1; ++j) {
                for (int i = 1; i < 3; ++i) {
                    final Block bid = this.worldObj
                        .getBlock((int) this.posX + j, (int) this.posY + i, (int) this.posZ + k);
                    if (bid != Blocks.air) {
                        return false;
                    }
                }
            }
        }
        long t = this.worldObj.getWorldTime();
        t %= 24000L;
        return t <= 12000L && this.posY >= 50.0 && this.posY <= 100.0 && this.findBuddies() <= 2;
    }

    public boolean isAIEnabled() {
        return true;
    }

    public boolean canBreatheUnderwater() {
        return false;
    }

    public int mygetMaxHealth() {
        return 15;
    }

    protected String getLivingSound() {
        if (this.worldObj.rand.nextInt(8) != 1) {
            return null;
        }
        return "orespawn:peacocklive";
    }

    protected String getHurtSound() {
        return "orespawn:peacockhit";
    }

    protected String getDeathSound() {
        return "orespawn:peacockdead";
    }

    protected float getSoundVolume() {
        return 0.4f;
    }

    protected Item getDropItem() {
        return OreSpawnMain.MyRawPeacock;
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        this.dropItem(OreSpawnMain.MyRawPeacock, 1);
        if (this.worldObj.rand.nextInt(3) == 1) {
            this.dropItem(OreSpawnMain.MyRawPeacock, 1);
        }
        if (this.worldObj.rand.nextInt(2) == 1) {
            this.dropItem(OreSpawnMain.MyPeacockFeather, 1);
        }
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        final boolean var4 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), 6.0f);
        return var4;
    }

    private ItemStack LayAnEgg(final Item index, final int par1) {
        EntityItem var3 = null;
        final ItemStack is = new ItemStack(index, par1, 0);
        var3 = new EntityItem(
            this.worldObj,
            this.posX + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2),
            this.posY + 1.0,
            this.posZ + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2),
            is);
        if (var3 != null) {
            this.worldObj.spawnEntityInWorld(var3);
        }
        return is;
    }

    protected void updateAITasks() {
        if (this.worldObj.rand.nextInt(200) == 1) {
            this.setRevengeTarget(null);
        }
        super.updateAITasks();
        if (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
            return;
        }
        if (this.worldObj.rand.nextInt(10) == 1) {
            final EntityLivingBase e = this.findSomethingToAttack();
            if (e != null) {
                if (this.getDistanceSqToEntity(e) < 4.0) {
                    this.attackEntityAsMob(e);
                } else {
                    this.getNavigator()
                        .tryMoveToEntityLiving(e, 1.2);
                }
            }
        }
        if (this.worldObj.rand.nextInt(5000) == 1) {
            this.LayAnEgg(OreSpawnMain.PeacockEgg, 1 + this.worldObj.rand.nextInt(3));
        }
    }

    private boolean isSuitableTarget(final EntityLivingBase par1EntityLiving, final boolean par2) {
        return this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && par1EntityLiving != null
            && par1EntityLiving != this
            && par1EntityLiving.isEntityAlive()
            && this.getEntitySenses()
                .canSee(par1EntityLiving)
            && par1EntityLiving instanceof Termite;
    }

    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        final List var5 = this.worldObj
            .getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(10.0, 2.0, 10.0));
        Collections.sort((List<Object>) var5, (Comparator<? super Object>) this.TargetSorter);
        final Iterator var6 = var5.iterator();
        Entity var7 = null;
        EntityLivingBase var8 = null;
        while (var6.hasNext()) {
            var7 = (Entity) var6.next();
            var8 = (EntityLivingBase) var7;
            if (this.isSuitableTarget(var8, false)) {
                return var8;
            }
        }
        return null;
    }

    protected boolean canDespawn() {
        if (this.isChild()) {
            this.func_110163_bv();
            return false;
        }
        return !this.isNoDespawnRequired();
    }

    public EntityAgeable createChild(final EntityAgeable entityageable) {
        return (EntityAgeable) this.spawnBabyAnimal(entityageable);
    }

    public Peacock spawnBabyAnimal(final EntityAgeable par1EntityAgeable) {
        return new Peacock(this.worldObj);
    }

    public boolean isWheat(final ItemStack par1ItemStack) {
        return par1ItemStack != null && par1ItemStack.getItem() == Items.apple;
    }

    public boolean isBreedingItem(final ItemStack par1ItemStack) {
        return par1ItemStack.getItem() == OreSpawnMain.MyCrystalApple;
    }

    private int findBuddies() {
        final List var5 = this.worldObj.getEntitiesWithinAABB(Peacock.class, this.boundingBox.expand(16.0, 10.0, 16.0));
        return var5.size();
    }
}
