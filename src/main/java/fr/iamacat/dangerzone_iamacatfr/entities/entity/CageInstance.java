
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import fr.iamacat.dangerzone_iamacatfr.DangerZone;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.bosses.BeeInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.render.WhaleRenderer;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityDragonPart;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class CageInstance extends EntityThrowable {

    private float my_rotation;
    public int my_index;
    private World throwerWorld;
    private EntityPlayer thrower;

    public CageInstance(final World par1World) {
        super(par1World);
        this.my_rotation = 0.0f;
        this.my_index = 160;
        this.throwerWorld = null;
        this.thrower = null;
        this.throwerWorld = par1World;
    }

    public CageInstance(final World par1World, final int i) {
        super(par1World);
        this.my_rotation = 0.0f;
        this.my_index = 160;
        this.throwerWorld = null;
        this.thrower = null;
        this.throwerWorld = par1World;
        this.my_index = i;
    }

    public CageInstance(final World par1World, final EntityPlayer par2EntityLiving, final int i) {
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
                    this.dropItem(DangerZone.CageEmpty, 1);
                    this.setDead();
                }
                return;
            }
            if (par1MovingObjectPosition.entityHit instanceof SpiderDriver) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedSpiderDriver, 1);
            } else if (par1MovingObjectPosition.entityHit instanceof EntitySpider) {
                if (par1MovingObjectPosition.entityHit instanceof EntityCaveSpider) {
                    par1MovingObjectPosition.entityHit.setDead();
                    this.dropItem(DangerZone.CagedCaveSpider, 1);
                } else {
                    par1MovingObjectPosition.entityHit.setDead();
                    this.dropItem(DangerZone.CagedSpider, 1);
                }
            }
            if (par1MovingObjectPosition.entityHit instanceof CrabInstance) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedCrab, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof EntityBat) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedBat, 2);
            }
            if (par1MovingObjectPosition.entityHit instanceof EntityPig) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedPig, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof EntitySquid) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedSquid, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof EntityChicken) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedChicken, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof EntityCreeper) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedCreeper, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof EntityHorse) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedHorse, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof EntitySkeleton) {
                final EntitySkeleton sk = (EntitySkeleton) par1MovingObjectPosition.entityHit;
                if (sk.getSkeletonType() != 0) {
                    this.dropItem(DangerZone.CagedWitherSkeleton, 1);
                } else {
                    this.dropItem(DangerZone.CagedSkeleton, 1);
                }
                par1MovingObjectPosition.entityHit.setDead();
            }
            if (par1MovingObjectPosition.entityHit instanceof EntityZombie) {
                if (par1MovingObjectPosition.entityHit instanceof EntityPigZombie) {
                    par1MovingObjectPosition.entityHit.setDead();
                    this.dropItem(DangerZone.CagedZombiePigman, 1);
                } else {
                    par1MovingObjectPosition.entityHit.setDead();
                    this.dropItem(DangerZone.CagedZombie, 1);
                }
            }
            if (par1MovingObjectPosition.entityHit instanceof EntitySlime) {
                if (par1MovingObjectPosition.entityHit instanceof EntityMagmaCube) {
                    par1MovingObjectPosition.entityHit.setDead();
                    this.dropItem(DangerZone.CagedMagmaCube, 1);
                } else {
                    par1MovingObjectPosition.entityHit.setDead();
                    this.dropItem(DangerZone.CagedSlime, 1);
                }
            }
            if (par1MovingObjectPosition.entityHit instanceof EntityGhast) {
                if (this.rand.nextInt(10) < 2) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(DangerZone.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedGhast, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof EntityEnderman) {
                if (this.rand.nextInt(10) < 2) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(DangerZone.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedEnderman, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof EntitySilverfish) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedSilverfish, 2);
            }
            if (par1MovingObjectPosition.entityHit instanceof EntityWitch) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedWitch, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof EntitySheep) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedSheep, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof EntityWolf) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedWolf, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof EntityOcelot) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedOcelot, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof EntityBlaze) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedBlaze, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof GirlfriendInstance) {
                final GirlfriendInstance gf = (GirlfriendInstance) par1MovingObjectPosition.entityHit;
                if (!gf.isTamed()) {
                    par1MovingObjectPosition.entityHit.setDead();
                    this.dropItem(DangerZone.CagedGirlfriend, 1);
                }
            }
            if (par1MovingObjectPosition.entityHit instanceof BoyfriendInstance) {
                final BoyfriendInstance gf2 = (BoyfriendInstance) par1MovingObjectPosition.entityHit;
                if (!gf2.isTamed()) {
                    par1MovingObjectPosition.entityHit.setDead();
                    this.dropItem(DangerZone.CagedBoyfriend, 1);
                }
            }
            if (par1MovingObjectPosition.entityHit instanceof EntityDragon) {
                if (this.rand.nextInt(10) < 5) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(DangerZone.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                final EntityDragon dr = (EntityDragon) par1MovingObjectPosition.entityHit;
                dr.setDead();
                this.dropItem(DangerZone.CagedEnderDragon, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof EntityDragonPart) {
                if (this.rand.nextInt(10) < 5) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(DangerZone.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                final EntityDragonPart dp = (EntityDragonPart) par1MovingObjectPosition.entityHit;
                final EntityDragon dr2 = (EntityDragon) dp.entityDragonObj;
                dr2.setDead();
                this.dropItem(DangerZone.CagedEnderDragon, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof EntitySnowman) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedSnowGolem, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof EntityIronGolem) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedIronGolem, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof EntityWither) {
                if (this.rand.nextInt(10) < 2) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(DangerZone.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedWitherBoss, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof CrystalCowInstance) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedCrystalCow, 1);
                if (!this.worldObj.isRemote) {
                    this.setDead();
                }
                return;
            }
            if (par1MovingObjectPosition.entityHit instanceof EnchantedGoldenAppleCowInstance) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedEnchantedCow, 1);
                if (!this.worldObj.isRemote) {
                    this.setDead();
                }
                return;
            }
            if (par1MovingObjectPosition.entityHit instanceof GoldenAppleCowInstance) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedGoldCow, 1);
                if (!this.worldObj.isRemote) {
                    this.setDead();
                }
                return;
            }
            if (par1MovingObjectPosition.entityHit instanceof AppleCowInstance) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedRedCow, 1);
                if (!this.worldObj.isRemote) {
                    this.setDead();
                }
                return;
            }
            if (par1MovingObjectPosition.entityHit instanceof EntityCow) {
                if (par1MovingObjectPosition.entityHit instanceof EntityMooshroom) {
                    par1MovingObjectPosition.entityHit.setDead();
                    this.dropItem(DangerZone.CagedMooshroom, 1);
                } else {
                    par1MovingObjectPosition.entityHit.setDead();
                    this.dropItem(DangerZone.CagedCow, 1);
                }
                if (!this.worldObj.isRemote) {
                    this.setDead();
                }
                return;
            }
            if (par1MovingObjectPosition.entityHit instanceof EntityVillager) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedVillager, 1);
                if (!this.worldObj.isRemote) {
                    this.setDead();
                }
                return;
            }
            if (par1MovingObjectPosition.entityHit instanceof Mothra) {
                if (this.rand.nextInt(10) < 4) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(DangerZone.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedMOTHRA, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof AlosaurusInstance) {
                if (this.rand.nextInt(10) < 4) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(DangerZone.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedAlo, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof CryolophosaurusInstance) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedCryo, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof CamarasaurusInstance) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedCama, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof VelocityRaptor) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedVelo, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Hydrolisc) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedHydro, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof BasiliskInstance) {
                if (this.rand.nextInt(10) < 6) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(DangerZone.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedBasil, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof DragonflyInstance) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedDragonfly, 2);
            }
            if (par1MovingObjectPosition.entityHit instanceof EmperorScorpion) {
                if (this.rand.nextInt(10) < 7) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(DangerZone.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedEmperorScorpion, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof CephadromeInstance) {
                if (this.rand.nextInt(10) < 7) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(DangerZone.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedCephadrome, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof DragonInstance) {
                if (this.rand.nextInt(10) < 7) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(DangerZone.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedDragon, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Scorpion) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedScorpion, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof CaveFisherInstance) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedCaveFisher, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Spyro) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedSpyro, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof BaryonyxInstance) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedBaryonyx, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof GammaMetroid) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedGammaMetroid, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof CockateilInstance) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedCockateil, 4);
            }
            if (par1MovingObjectPosition.entityHit instanceof AttackSquidInstance) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedAttackSquid, 6);
            }
            if (par1MovingObjectPosition.entityHit instanceof Kyuubi) {
                if (this.rand.nextInt(10) < 3) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(DangerZone.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedKyuubi, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof WaterDragon) {
                if (this.rand.nextInt(10) < 6) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(DangerZone.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedWaterDragon, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Kraken) {
                if (this.rand.nextInt(100) < 95) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(DangerZone.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedKraken, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Lizard) {
                if (this.rand.nextInt(10) < 2) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(DangerZone.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedLizard, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof AlienInstance) {
                if (this.rand.nextInt(10) < 5) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(DangerZone.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedAlien, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof BeeInstance) {
                if (this.rand.nextInt(10) < 3) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(DangerZone.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedBee, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Firefly) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedFirefly, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof ChipMunkInstance) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedChipmunk, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Gazelle) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedGazelle, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Ostrich) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedOstrich, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof TrooperBug) {
                if (this.rand.nextInt(10) < 6) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(DangerZone.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedTrooper, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof SpitBug) {
                if (this.rand.nextInt(10) < 3) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(DangerZone.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedSpit, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof StinkBug) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedStink, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof CreepingHorrorInstance) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedCreepingHorror, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof TerribleTerror) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedTerribleTerror, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof CliffRacerInstance) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedCliffRacer, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Triffid) {
                if (this.rand.nextInt(10) < 6) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(DangerZone.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedTriffid, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof PitchBlack) {
                if (this.rand.nextInt(10) < 7) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(DangerZone.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedPitchBlack, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof LurkingTerror) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedLurkingTerror, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof WormSmall) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedSmallWorm, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof WormMedium) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedMediumWorm, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof CassowaryInstance) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedCassowary, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof CloudSharkInstance) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedCloudShark, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof GoldFish) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedGoldFish, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof LeafMonster) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedLeafMonster, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof WormLarge) {
                if (this.rand.nextInt(10) < 5) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(DangerZone.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedLargeWorm, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof EnderKnight) {
                if (this.rand.nextInt(10) < 3) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(DangerZone.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedEnderKnight, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof EnderReaper) {
                if (this.rand.nextInt(10) < 2) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(DangerZone.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedEnderReaper, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof BeaverInstance) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedBeaver, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Urchin) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedUrchin, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Flounder) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedFlounder, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Skate) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedSkate, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Rotator) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedRotator, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Peacock) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedPeacock, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof FairyInstance) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedFairy, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof DungeonBeastInstance) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedDungeonBeast, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Vortex) {
                if (this.rand.nextInt(10) < 3) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(DangerZone.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedVortex, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Rat) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedRat, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof WhaleRenderer.WhaleInstance) {
                if (this.rand.nextInt(10) < 2) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(DangerZone.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedWhale, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Irukandji) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedIrukandji, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Stinky) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedStinky, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Mantis) {
                if (this.rand.nextInt(10) < 3) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(DangerZone.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedMantis, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof TRex) {
                if (this.rand.nextInt(10) < 4) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(DangerZone.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedTRex, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof HerculesBeetle) {
                if (this.rand.nextInt(10) < 5) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(DangerZone.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedHercules, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof EasterBunnyInstance) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedEasterBunny, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof CaterKillerInstance) {
                if (this.rand.nextInt(10) < 7) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(DangerZone.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedCaterKiller, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Molenoid) {
                if (this.rand.nextInt(10) < 5) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(DangerZone.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedMolenoid, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof SeaMonster) {
                if (this.rand.nextInt(10) < 3) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(DangerZone.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedSeaMonster, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof SeaViper) {
                if (this.rand.nextInt(10) < 4) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(DangerZone.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedSeaViper, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof RubberDucky) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedRubberDucky, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Leon) {
                if (this.rand.nextInt(10) < 7) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(DangerZone.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedLeon, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Hammerhead) {
                if (this.rand.nextInt(10) < 7) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(DangerZone.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedHammerhead, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof BandPInstance) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedCriminal, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof CricketInstance) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedCricket, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Frog) {
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedFrog, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof BrutalflyInstance) {
                if (this.rand.nextInt(10) < 5) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(DangerZone.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedBrutalfly, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Nastysaurus) {
                if (this.rand.nextInt(10) < 7) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(DangerZone.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedNastysaurus, 1);
            }
            if (par1MovingObjectPosition.entityHit instanceof Pointysaurus) {
                if (this.rand.nextInt(10) < 2) {
                    if (!this.worldObj.isRemote) {
                        this.dropItem(DangerZone.CageEmpty, 1);
                        this.setDead();
                    }
                    return;
                }
                par1MovingObjectPosition.entityHit.setDead();
                this.dropItem(DangerZone.CagedPointysaurus, 1);
            }
        } else if (!this.worldObj.isRemote) {
            this.dropItem(DangerZone.CageEmpty, 1);
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
