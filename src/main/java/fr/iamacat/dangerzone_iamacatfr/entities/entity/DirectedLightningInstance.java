package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityWeatherEffect;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.List;

public class DirectedLightningInstance extends EntityWeatherEffect {

    private int lightningState;
    public long boltVertex;
    private int boltLivingTime;
    private Entity user;

    public DirectedLightningInstance(World world) {
        super(world);
        this.lightningState = 2;
        this.boltVertex = this.rand.nextLong();
    }

    public DirectedLightningInstance(World world, double x, double y, double z, Entity user) {
        super(world);
        this.setLocationAndAngles(x, y, z, 0.0F, 0.0F);
        this.lightningState = 2;
        this.boltVertex = this.rand.nextLong();
        this.boltLivingTime = this.rand.nextInt(3) + 1;
        this.user = user;
        if (!world.isRemote) this.setUserID(user);

        if (!world.isRemote && world.getGameRules()
            .getGameRuleBooleanValue("doFireTick")
            && world.difficultySetting.getDifficultyId() >= 2
            && world.doChunksNearChunkExist(
                MathHelper.floor_double(x),
                MathHelper.floor_double(y),
                MathHelper.floor_double(z),
                10)) {
            int i = MathHelper.floor_double(x);
            int j = MathHelper.floor_double(y);
            int k = MathHelper.floor_double(z);

            if (world.getBlock(i, j, k)
                .getMaterial() == Material.air && Blocks.fire.canPlaceBlockAt(world, i, j, k)) {
                world.setBlock(i, j, k, Blocks.fire);
            }

            for (i = 0; i < 4; ++i) {
                j = MathHelper.floor_double(x) + this.rand.nextInt(3) - 1;
                k = MathHelper.floor_double(y) + this.rand.nextInt(3) - 1;
                int l = MathHelper.floor_double(z) + this.rand.nextInt(3) - 1;

                if (world.getBlock(j, k, l)
                    .getMaterial() == Material.air && Blocks.fire.canPlaceBlockAt(world, j, k, l)) {
                    world.setBlock(j, k, l, Blocks.fire);
                }
            }
        }
    }

    @Override
    public void onUpdate() {
        super.onUpdate();

        if (this.lightningState == 2) {
            if (this.user != null) this.worldObj
                .playSoundAtEntity(this.user, Tags.MODID + ":random.directedlightning", 0.3F, rand.nextFloat() * 0.5F);
            this.worldObj
                .playSoundAtEntity(this, Tags.MODID + ":random.directedlightning", 0.4F, rand.nextFloat() * 0.3F);
            this.worldObj.playSoundEffect(
                this.posX,
                this.posY,
                this.posZ,
                "random.explode",
                0.1F + rand.nextFloat(),
                0.1F + this.rand.nextFloat() * 0.2F);
        }

        --this.lightningState;

        if (this.lightningState < 0) {
            if (this.boltLivingTime == 0) {
                this.setDead();
            } else if (this.lightningState < -this.rand.nextInt(10)) {
                --this.boltLivingTime;
                this.lightningState = 1;
                this.boltVertex = this.rand.nextLong();

                if (!this.worldObj.isRemote && this.worldObj.getGameRules()
                    .getGameRuleBooleanValue("doFireTick")
                    && this.worldObj.doChunksNearChunkExist(
                        MathHelper.floor_double(this.posX),
                        MathHelper.floor_double(this.posY),
                        MathHelper.floor_double(this.posZ),
                        10)) {
                    int i = MathHelper.floor_double(this.posX);
                    int j = MathHelper.floor_double(this.posY);
                    int k = MathHelper.floor_double(this.posZ);

                    if (this.worldObj.getBlock(i, j, k)
                        .getMaterial() == Material.air && Blocks.fire.canPlaceBlockAt(this.worldObj, i, j, k)) {
                        this.worldObj.setBlock(i, j, k, Blocks.fire);
                    }
                }
            }
        }

        if (this.lightningState >= 0) {
            if (!this.worldObj.isRemote) {
                double d0 = 3.0D;
                List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(
                    this,
                    AxisAlignedBB.getBoundingBox(
                        this.posX - d0,
                        this.posY - d0,
                        this.posZ - d0,
                        this.posX + d0,
                        this.posY + 6.0D + d0,
                        this.posZ + d0));

                for (int l = 0; l < list.size(); ++l) {
                    Entity entity = (Entity) list.get(l);
                    if (this.user != entity && !entity.isImmuneToFire()) {
                        entity.attackEntityFrom(DamageSource.inFire, 5.0F);
                        entity.setFire(8);
                    }
                }
            }
        }
    }

    public int getUserID() {
        return this.dataWatcher.getWatchableObjectInt(3);
    }

    private void setUserID(Entity entity) {
        if (entity == null) return;
        this.dataWatcher.updateObject(3, entity.getEntityId());
    }

    @Override
    protected void entityInit() {
        this.dataWatcher.addObject(3, 0);
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound p_70037_1_) {}

    @Override
    protected void writeEntityToNBT(NBTTagCompound p_70014_1_) {}
}
