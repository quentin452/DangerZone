package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import fr.iamacat.dangerzone_iamacatfr.util.Helper;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Facing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderHell;

import java.util.LinkedList;
import java.util.List;

public class RatInstance extends DungeonMobInstance {

    public List<int[]> blocksConverted;

    public RatInstance(World par1World) {
        super(par1World);
        this.setSize(1.8F, 0.5F);

        this.experienceValue = 30;
        this.ignoreHeight = false;

        this.blocksConverted = new LinkedList();
    }

    public boolean getCanSpawnHere() {
        if (this.worldObj.provider instanceof WorldProviderHell) return super.getCanSpawnHere();

        if (this.worldObj.canBlockSeeTheSky((int) this.posX, (int) this.posY, (int) this.posZ)) return false;

        if (this.posY > 32.0D && !this.ignoreHeight) return false;

        return super.getCanSpawnHere();
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(25.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(0.4D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(4.0D);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance)
            .setBaseValue(0.0D);
    }

    public int getTotalArmorValue() {
        return 8;
    }

    public int getAttackStrength(Entity par1Entity) {
        return 4;
    }

    protected String getLivingSound() {
        return "mob.silverfish.say";
    }

    protected String getHurtSound() {
        return "mob.silverfish.hit";
    }

    protected String getDeathSound() {
        return "mob.silverfish.kill";
    }

    protected void dropFewItems(boolean par1, int par2) {
        int var3;
        int var4;

        var3 = this.rand.nextInt(3);

        for (var4 = 0; var4 < var3; var4++) {
            this.dropItem(Items.fire_charge, 1);
        }
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();

        int foo;

        if (Helper.getDifficulty(this.worldObj) < 1) foo = 0;
        else if (Helper.getDifficulty(this.worldObj) < 3) foo = 1;
        else foo = 2;
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, 0);
    }

    protected void updateEntityActionState() {
        super.updateEntityActionState();

        if (!this.worldObj.isRemote) {
            if (this.entityToAttack == null && !this.hasPath()) {
                int i;
                int j;
                int k;
                Block l;

                i = MathHelper.floor_double(this.posX);
                j = MathHelper.floor_double(this.posY + 0.5D);
                k = MathHelper.floor_double(this.posZ);

                for (int l1 = 0; l1 < 6; l1++) {
                    // int l1 = this.rand.nextInt(6);

                    l = this.worldObj.getBlock(
                        i + Facing.offsetsXForSide[l1],
                        j + Facing.offsetsYForSide[l1],
                        k + Facing.offsetsZForSide[l1]);

                    if (l == Blocks.stone) {
                        this.worldObj.setBlock(
                            i + Facing.offsetsXForSide[l1],
                            j + Facing.offsetsYForSide[l1],
                            k + Facing.offsetsZForSide[l1],
                            Blocks.lava,
                            0,
                            3);
                        int[] foo = { i + Facing.offsetsXForSide[l1], j + Facing.offsetsYForSide[l1],
                            k + Facing.offsetsZForSide[l1] };
                        this.blocksConverted.add(foo);
                    } else this.updateWanderPath();
                }
            } else if (this.entityToAttack != null && !this.hasPath()) this.entityToAttack = null;
        }
    }

    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);

        int foo = this.blocksConverted.size();

        par1NBTTagCompound.setInteger("BlockCount", foo);

        for (int i = 0; i < foo; i++) {
            par1NBTTagCompound.setIntArray("Block[" + i + "]", this.blocksConverted.get(i));
        }

    }

    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);

        int foo = par1NBTTagCompound.getInteger("BlockCount");

        for (int i = 0; i < foo; i++) {
            this.blocksConverted.add(par1NBTTagCompound.getIntArray("Block[" + i + "]"));
        }
    }

    protected Entity findPlayerToAttack() {
        double d0 = 16.0D;
        return this.worldObj.getClosestVulnerablePlayerToEntity(this, d0);
    }

    protected void attackEntity(Entity par1Entity, float par2) {
        if (this.attackTime <= 0 && par2 < 1.2F
            && this.boundingBox.expand(1.5D, 1.5D, 1.5D)
                .intersectsWith(par1Entity.boundingBox)) {
            this.attackTime = 20;
            this.attackEntityAsMob(par1Entity);
        }
    }

    public float getBlockPathWeight(int par1, int par2, int par3) {
        return this.worldObj.getBlock(par1, par2, par3) == Blocks.stone ? 10.0F
            : super.getBlockPathWeight(par1, par2, par3);
    }

    protected void despawnEntity() {
        super.despawnEntity();
    }

    public void onDeath(DamageSource par1DamageSource) {
        super.onDeath(par1DamageSource);
    }
}
