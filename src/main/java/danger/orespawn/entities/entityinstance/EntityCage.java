
package danger.orespawn.entities.entityinstance;

import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityDragonPart;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import danger.orespawn.items.CrystalCow;

public class EntityCage extends EntityThrowable {

    private float my_rotation;
    public int my_index;
    private World throwerWorld;
    private EntityPlayer thrower;

    public EntityCage(final World par1World) {
        super(par1World);
        this.my_rotation = 0.0f;
        this.my_index = 160;
        this.throwerWorld = null;
        this.thrower = null;
        this.throwerWorld = par1World;
    }

    public EntityCage(final World par1World, final int i) {
        super(par1World);
        this.my_rotation = 0.0f;
        this.my_index = 160;
        this.throwerWorld = null;
        this.thrower = null;
        this.throwerWorld = par1World;
        this.my_index = i;
    }

    public EntityCage(final World par1World, final EntityPlayer par2EntityLiving, final int i) {
        super(par1World, par2EntityLiving);
        this.my_rotation = 0.0f;
        this.my_index = 160;
        this.throwerWorld = null;
        this.thrower = null;
        this.throwerWorld = par1World;
        this.thrower = par2EntityLiving;
        this.my_index = i;
        if (this.thrower.worldObj != null) {
            this.throwerWorld = this.thrower.worldObj;
        }
    }

    public int getCageIndex() {
        return this.my_index;
    }

    protected void onImpact(final MovingObjectPosition par1MovingObjectPosition) {
        if (par1MovingObjectPosition.entityHit != null && this.rand.nextInt(10) >= 2) {
            if (this.throwerWorld != null) {
                for (int var3 = 0; var3 < 4; ++var3) {
                    this.throwerWorld.spawnParticle(
                        "smoke",
                        par1MovingObjectPosition.entityHit.posX,
                        par1MovingObjectPosition.entityHit.posY + 0.25,
                        par1MovingObjectPosition.entityHit.posZ,
                        0.0,
                        0.0,
                        0.0);
                    this.throwerWorld.spawnParticle(
                        "explode",
                        par1MovingObjectPosition.entityHit.posX,
                        par1MovingObjectPosition.entityHit.posY + 0.25,
                        par1MovingObjectPosition.entityHit.posZ,
                        0.0,
                        0.0,
                        0.0);
                    this.throwerWorld.spawnParticle(
                        "reddust",
                        par1MovingObjectPosition.entityHit.posX,
                        par1MovingObjectPosition.entityHit.posY + 0.25,
                        par1MovingObjectPosition.entityHit.posZ,
                        0.0,
                        0.0,
                        0.0);
                }
                if (this.thrower != null) {
                    this.throwerWorld.playSoundAtEntity(this.thrower, "random.explode", 1.0f, 1.5f);
                }
            }
            if (par1MovingObjectPosition.entityHit instanceof EntityPlayer) {
                if (!this.worldObj.isRemote) {
                    this.dropItem(OreSpawnMain.CageEmpty, 1);
                    this.setDead();
                }
                return;
            }
            if (par1MovingObjectPosition.entityHit instanceof SpiderDriver) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedSpiderDriver, 1);
            } else if (par1MovingObjectPosition.entityHit instanceof EntitySpider) {
                if (par1MovingObjectPosition.entityHit instanceof EntityCaveSpider) {
                    par1MovingObjectPosition.entityHit.setDead();
                    this.dropItem(OreSpawnMain.CagedCaveSpider, 1);
                } else {
                    par1MovingObjectPosition.entityHit.setDead();
                    this.dropItem(OreSpawnMain.CagedSpider, 1);
                }
            }
            if (par1MovingObjectPosition.entityHit instanceof Crab) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedCrab, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof EntityBat) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedBat, 2);
            }
            if (par1MovingObjectPosition.entityHit instanceof EntityPig) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedPig, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof EntitySquid) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedSquid, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof EntityChicken) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedChicken, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof EntityCreeper) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedCreeper, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof EntityHorse) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedHorse, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof EntitySkeleton) {
                final EntitySkeleton sk = (EntitySkeleton) par1MovingObjectPosition.entityHit;
                if (sk.getSkeletonType() != 0) {
                    this.dropItem(OreSpawnMain.CagedWitherSkeleton, 1);
                } else {
                    this.dropItem(OreSpawnMain.CagedSkeleton, 1);
                }
                par1MovingObjectPosition.entityHit.setDead();
            }
            if (par1MovingObjectPosition.entityHit instanceof EntityZombie) {
                if (par1MovingObjectPosition.entityHit instanceof EntityPigZombie) {
                    par1MovingObjectPosition.entityHit.setDead();
                    this.dropItem(OreSpawnMain.CagedZombiePigman, 1);
                } else {
                    par1MovingObjectPosition.entityHit.setDead();
                    this.dropItem(OreSpawnMain.CagedZombie, 1);
                }
            }
            if (par1MovingObjectPosition.entityHit instanceof EntitySlime) {
                if (par1MovingObjectPosition.entityHit instanceof EntityMagmaCube) {
                    par1MovingObjectPosition.entityHit.setDead();
                    this.dropItem(OreSpawnMain.CagedMagmaCube, 1);
                } else {
                    par1MovingObjectPosition.entityHit.setDead();
                    this.dropItem(OreSpawnMain.CagedSlime, 1);
                }
            }
            if (par1MovingObjectPosition.entityHit instanceof EntityGhast) {
                if (this.rand.nextInt(10) < 2) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(OreSpawnMain.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedGhast, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof EntityEnderman) {
                if (this.rand.nextInt(10) < 2) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(OreSpawnMain.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedEnderman, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof EntitySilverfish) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedSilverfish, 2);
            }
            if (par1MovingObjectPosition.entityHit instanceof EntityWitch) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedWitch, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof EntitySheep) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedSheep, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof EntityWolf) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedWolf, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof EntityOcelot) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedOcelot, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof EntityBlaze) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedBlaze, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Girlfriend) {
                final Girlfriend gf = (Girlfriend) par1MovingObjectPosition.entityHit;
                if (!gf.isTamed()) {
                    par1MovingObjectPosition.entityHit.setDead();
                    this.dropItem(OreSpawnMain.CagedGirlfriend, 1);
                }
            }
            if (par1MovingObjectPosition.entityHit instanceof Boyfriend) {
                final Boyfriend gf2 = (Boyfriend) par1MovingObjectPosition.entityHit;
                if (!gf2.isTamed()) {
                    par1MovingObjectPosition.entityHit.setDead();
                    this.dropItem(OreSpawnMain.CagedBoyfriend, 1);
                }
            }
            if (par1MovingObjectPosition.entityHit instanceof EntityDragon) {
                if (this.rand.nextInt(10) < 5) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(OreSpawnMain.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                final EntityDragon dr = (EntityDragon) par1MovingObjectPosition.entityHit;
                dr.setDead();
                this.dropItem(OreSpawnMain.CagedEnderDragon, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof EntityDragonPart) {
                if (this.rand.nextInt(10) < 5) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(OreSpawnMain.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                final EntityDragonPart dp = (EntityDragonPart) par1MovingObjectPosition.entityHit;
                final EntityDragon dr2 = (EntityDragon) dp.entityDragonObj;
                dr2.setDead();
                this.dropItem(OreSpawnMain.CagedEnderDragon, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof EntitySnowman) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedSnowGolem, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof EntityIronGolem) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedIronGolem, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof EntityWither) {
                if (this.rand.nextInt(10) < 2) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(OreSpawnMain.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedWitherBoss, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof CrystalCow) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedCrystalCow, 1);
                if (!this.worldObj.isRemote) {
                    this.setDead();
                }
                return;
            }
            if (par1MovingObjectPosition.entityHit instanceof EnchantedCow) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedEnchantedCow, 1);
                if (!this.worldObj.isRemote) {
                    this.setDead();
                }
                return;
            }
            if (par1MovingObjectPosition.entityHit instanceof GoldCow) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedGoldCow, 1);
                if (!this.worldObj.isRemote) {
                    this.setDead();
                }
                return;
            }
            if (par1MovingObjectPosition.entityHit instanceof RedCow) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedRedCow, 1);
                if (!this.worldObj.isRemote) {
                    this.setDead();
                }
                return;
            }
            if (par1MovingObjectPosition.entityHit instanceof EntityCow) {
                if (par1MovingObjectPosition.entityHit instanceof EntityMooshroom) {
                    par1MovingObjectPosition.entityHit.setDead();
                    this.dropItem(OreSpawnMain.CagedMooshroom, 1);
                } else {
                    par1MovingObjectPosition.entityHit.setDead();
                    this.dropItem(OreSpawnMain.CagedCow, 1);
                }
                if (!this.worldObj.isRemote) {
                    this.setDead();
                }
                return;
            }
            if (par1MovingObjectPosition.entityHit instanceof EntityVillager) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedVillager, 1);
                if (!this.worldObj.isRemote) {
                    this.setDead();
                }
                return;
            }
            if (par1MovingObjectPosition.entityHit instanceof Mothra) {
                if (this.rand.nextInt(10) < 4) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(OreSpawnMain.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedMOTHRA, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Alosaurus) {
                if (this.rand.nextInt(10) < 4) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(OreSpawnMain.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedAlo, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Cryolophosaurus) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedCryo, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Camarasaurus) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedCama, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof VelocityRaptor) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedVelo, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Hydrolisc) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedHydro, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Basilisk) {
                if (this.rand.nextInt(10) < 6) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(OreSpawnMain.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedBasil, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Dragonfly) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedDragonfly, 2);
            }
            if (par1MovingObjectPosition.entityHit instanceof EmperorScorpion) {
                if (this.rand.nextInt(10) < 7) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(OreSpawnMain.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedEmperorScorpion, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Cephadrome) {
                if (this.rand.nextInt(10) < 7) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(OreSpawnMain.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedCephadrome, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Dragon) {
                if (this.rand.nextInt(10) < 7) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(OreSpawnMain.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedDragon, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Scorpion) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedScorpion, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof CaveFisher) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedCaveFisher, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Spyro) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedSpyro, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Baryonyx) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedBaryonyx, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof GammaMetroid) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedGammaMetroid, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Cockateil) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedCockateil, 4);
            }
            if (par1MovingObjectPosition.entityHit instanceof AttackSquid) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedAttackSquid, 6);
            }
            if (par1MovingObjectPosition.entityHit instanceof Kyuubi) {
                if (this.rand.nextInt(10) < 3) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(OreSpawnMain.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedKyuubi, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof WaterDragon) {
                if (this.rand.nextInt(10) < 6) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(OreSpawnMain.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedWaterDragon, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Kraken) {
                if (this.rand.nextInt(100) < 95) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(OreSpawnMain.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedKraken, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Lizard) {
                if (this.rand.nextInt(10) < 2) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(OreSpawnMain.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedLizard, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Alien) {
                if (this.rand.nextInt(10) < 5) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(OreSpawnMain.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedAlien, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Bee) {
                if (this.rand.nextInt(10) < 3) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(OreSpawnMain.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedBee, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Firefly) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedFirefly, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Chipmunk) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedChipmunk, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Gazelle) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedGazelle, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Ostrich) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedOstrich, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof TrooperBug) {
                if (this.rand.nextInt(10) < 6) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(OreSpawnMain.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedTrooper, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof SpitBug) {
                if (this.rand.nextInt(10) < 3) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(OreSpawnMain.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedSpit, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof StinkBug) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedStink, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof CreepingHorror) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedCreepingHorror, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof TerribleTerror) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedTerribleTerror, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof CliffRacer) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedCliffRacer, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Triffid) {
                if (this.rand.nextInt(10) < 6) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(OreSpawnMain.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedTriffid, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof PitchBlack) {
                if (this.rand.nextInt(10) < 7) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(OreSpawnMain.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedPitchBlack, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof LurkingTerror) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedLurkingTerror, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof WormSmall) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedSmallWorm, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof WormMedium) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedMediumWorm, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Cassowary) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedCassowary, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof CloudShark) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedCloudShark, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof GoldFish) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedGoldFish, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof LeafMonster) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedLeafMonster, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof WormLarge) {
                if (this.rand.nextInt(10) < 5) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(OreSpawnMain.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedLargeWorm, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof EnderKnight) {
                if (this.rand.nextInt(10) < 3) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(OreSpawnMain.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedEnderKnight, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof EnderReaper) {
                if (this.rand.nextInt(10) < 2) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(OreSpawnMain.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedEnderReaper, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Beaver) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedBeaver, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Urchin) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedUrchin, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Flounder) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedFlounder, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Skate) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedSkate, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Rotator) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedRotator, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Peacock) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedPeacock, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Fairy) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedFairy, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof DungeonBeast) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedDungeonBeast, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Vortex) {
                if (this.rand.nextInt(10) < 3) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(OreSpawnMain.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedVortex, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Rat) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedRat, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Whale) {
                if (this.rand.nextInt(10) < 2) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(OreSpawnMain.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedWhale, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Irukandji) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedIrukandji, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Stinky) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedStinky, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Mantis) {
                if (this.rand.nextInt(10) < 3) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(OreSpawnMain.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedMantis, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof TRex) {
                if (this.rand.nextInt(10) < 4) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(OreSpawnMain.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedTRex, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof HerculesBeetle) {
                if (this.rand.nextInt(10) < 5) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(OreSpawnMain.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedHercules, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof EasterBunny) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedEasterBunny, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof CaterKiller) {
                if (this.rand.nextInt(10) < 7) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(OreSpawnMain.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedCaterKiller, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Molenoid) {
                if (this.rand.nextInt(10) < 5) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(OreSpawnMain.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedMolenoid, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof SeaMonster) {
                if (this.rand.nextInt(10) < 3) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(OreSpawnMain.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedSeaMonster, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof SeaViper) {
                if (this.rand.nextInt(10) < 4) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(OreSpawnMain.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedSeaViper, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof RubberDucky) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedRubberDucky, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Leon) {
                if (this.rand.nextInt(10) < 7) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(OreSpawnMain.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedLeon, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Hammerhead) {
                if (this.rand.nextInt(10) < 7) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(OreSpawnMain.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedHammerhead, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof BandP) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedCriminal, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Cricket) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedCricket, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Frog) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedFrog, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Brutalfly) {
                if (this.rand.nextInt(10) < 5) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(OreSpawnMain.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedBrutalfly, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Nastysaurus) {
                if (this.rand.nextInt(10) < 7) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(OreSpawnMain.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedNastysaurus, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Pointysaurus) {
                if (this.rand.nextInt(10) < 2) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(OreSpawnMain.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(OreSpawnMain.CagedPointysaurus, 1);
            }
        } else if (!this.worldObj.isRemote) {
            this.dropItem(OreSpawnMain.CageEmpty, 1);
        }
        if (!this.worldObj.isRemote) {
            this.setDead();
        }
    }

    public void onUpdate() {
        super.onUpdate();
        this.my_rotation += 20.0f;
        while (this.my_rotation > 360.0f) {
            this.my_rotation -= 360.0f;
        }
        final float my_rotation = this.my_rotation;
        this.prevRotationPitch = my_rotation;
        this.rotationPitch = my_rotation;
    }
}
