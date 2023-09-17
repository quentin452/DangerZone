package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.bosses.BeeInstance;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityDarkCrystal extends Entity {

    public BeeInstance owner;

    public EntityDarkCrystal(World world)
    {
        this(world, null);
    }

    public EntityDarkCrystal(World p_i1582_1_, BeeInstance owner) {
        super(p_i1582_1_);
        if (owner != null) this.setOwnerID(owner.getEntityId());
        this.setSize(0.445F, 0.665F);
        this.preventEntitySpawning = true;
        this.yOffset = this.height / 2.0F;
        this.isImmuneToFire = true;
    }

    @Override
    protected boolean canTriggerWalking()
    {
        return false;
    }

    @Override
    public boolean canBeCollidedWith()
    {
        return true;
    }

    @Override
    public boolean canBePushed()
    {
        return true;
    }

    @Override
    protected void entityInit() {
        this.dataWatcher.addObject(4, Integer.valueOf(rand.nextInt(10000)));
        this.dataWatcher.addObject(5, Integer.valueOf(0));
    }

    private void incrementRotation()
    {
        int pow = this.dataWatcher.getWatchableObjectInt(4);
        this.dataWatcher.updateObject(4, ++pow);
    }

    public int getRotationTicks()
    {
        return this.dataWatcher.getWatchableObjectInt(4);
    }

    private void updateOwner() {
        Entity entity = this.worldObj.getEntityByID(this.getOwnerID());
        if (entity != null && entity instanceof BeeInstance && !entity.isDead)
        {
            this.owner = (BeeInstance) entity;
        }
        else
        {
            this.owner = null;
        }
    }

    public int getOwnerID()
    {
        return this.dataWatcher.getWatchableObjectInt(5);
    }

    private void setOwnerID(int id)
    {
        this.dataWatcher.updateObject(5, id);
        this.updateOwner();
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();
        this.updateOwner();

        if (this.worldObj.isRemote)
        {
            for (int i = 0; i < 2; i++)
            {
                this.worldObj.spawnParticle("witchMagic", this.posX + ((rand.nextDouble() - rand.nextDouble()) * 0.355D), this.posY + 0.115D + rand.nextDouble(),
                    this.posZ + ((rand.nextDouble() - rand.nextDouble()) * 0.355D), 0.0F, 0.155F * this.rand.nextFloat(), 0.0F);
            }

            if (this.owner != null)
            {
                double d0 = this.owner.posX - this.posX + 0.5D;
                double d1 = this.owner.posY - this.posY + 2.5D;
                double d2 = this.owner.posZ - this.posZ + 0.5D;

                for (int i = 0; i < 4; i++)
                {
                    double d3 = 0.23D * i + (rand.nextDouble() * 0.25D);
                    this.worldObj.spawnParticle("witchMagic", this.posX + d0 * d3, this.posY + d1 * d3 + 0.45D, this.posZ + d2 * d3, 0.0, 0.0, 0.0);
                }
            }
        }
        else
        {
            if (this.owner != null && this.owner.isDead) this.owner = null;
            if (this.owner == null) this.setDead();
            this.incrementRotation();
        }

        if (this.ticksExisted % 20 == 0) this.motionY = MathHelper.sin(this.ticksExisted + this.getEntityId()) * 0.115;
        if (Math.abs(this.motionX) >= 0.225D && Math.abs(this.motionX) <= 0.5D) this.motionX *= 1.125D;
        if (Math.abs(this.motionZ) >= 0.225D && Math.abs(this.motionZ) <= 0.5D) this.motionZ *= 1.125D;
        if (!this.worldObj.isRemote) this.moveEntity(this.motionX, this.motionY, this.motionZ);
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float par2)
    {
        if (this.worldObj.isRemote || this.isEntityInvulnerable() || source.isExplosion()) return false;

        if (source.getEntity() != null)
        {
            this.setDead();
            this.setBeenAttacked();

            if (!this.worldObj.isRemote)
            {
                boolean flag = this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing");
                this.worldObj.createExplosion((Entity)null, this.posX, this.posY, this.posZ, 4.0F, flag);

                float f = this.worldObj.difficultySetting.getDifficultyId() == 2 ? 50.0F : 25.0F;
                if (this.owner != null)
                {
                    this.owner.enyvilEye.attackEntityFrom(DamageSource.magic, f);
                    this.owner.crystalBuffer = 200 + rand.nextInt(100);
                }
            }
            return true;
        }
        return false;
    }



    @Override
    protected void readEntityFromNBT(NBTTagCompound tag) {
        if (tag.hasKey("position")) this.setPosition(tag.getIntArray("position")[0], tag.getIntArray("position")[1], tag.getIntArray("position")[2]);
        if (tag.hasKey("ownerID")) this.setOwnerID(tag.getInteger("ownerID"));
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound tag) {
        tag.setIntArray("position", new int[] {(int) this.posX, (int) this.posY, (int) this.posZ});
        if (this.owner != null) tag.setInteger("ownerID", this.getOwnerID());
    }

    @Override
    public void setFire(int i) {}

    @Override
    public void fall(float f) {}

    @Override
    public void onStruckByLightning(EntityLightningBolt bolt) {}
}
