
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;
import fr.iamacat.dangerzone_iamacatfr.entities.ai.MyEntityAIWanderALot;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EasterBunny extends EntityAnimal {

    private float moveSpeed;

    public EasterBunny(final World par1World) {
        super(par1World);
        this.moveSpeed = 0.45f;
        this.setSize(0.5f, 0.75f);
        this.moveSpeed = 0.45f;
        this.fireResistance = 100;
        this.experienceValue = 5;
        this.getNavigator()
            .setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIMate((EntityAnimal) this, 1.0));
        this.tasks.addTask(2, new EntityAIAvoidEntity(this, EntityMob.class, 8.0f, 1.0, 1.399999976158142));
        this.tasks.addTask(3, new EntityAIAvoidEntity(this, EntityPlayer.class, 8.0f, 1.0, 1.399999976158142));
        this.tasks.addTask(4, new EntityAIPanic(this, 1.5));
        this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityLiving.class, 8.0f));
        this.tasks.addTask(6, new MyEntityAIWanderALot(this, 16, 1.0));
        this.tasks.addTask(7, new EntityAILookIdle(this));
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
            .setBaseValue(8.0);
    }

    protected void entityInit() {
        super.entityInit();
    }

    public void onUpdate() {
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(this.moveSpeed);
        super.onUpdate();
    }

    public boolean getCanSpawnHere() {
        if (this.posY < 50.0) {
            return false;
        }
        if (!this.worldObj.isDaytime()) {
            return false;
        }
        EasterBunny target = null;
        target = (EasterBunny) this.worldObj
            .findNearestEntityWithinAABB(EasterBunny.class, this.boundingBox.expand(32.0, 8.0, 32.0), this);
        return target == null;
    }

    public boolean isAIEnabled() {
        return true;
    }

    public boolean canBreatheUnderwater() {
        return false;
    }

    public int mygetMaxHealth() {
        return 10;
    }

    protected String getLivingSound() {
        return null;
    }

    protected String getHurtSound() {
        return "orespawn:duck_hurt";
    }

    protected String getDeathSound() {
        return "orespawn:duck_hurt";
    }

    protected float getSoundVolume() {
        return 0.4f;
    }

    protected Item getDropItem() {
        return Items.chicken;
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        int var3 = 0;
        var3 = this.rand.nextInt(3);
        var3 += 2;
        for (int var4 = 0; var4 < var3; ++var4) {
            this.dropItem(Items.chicken, 1);
        }
    }

    protected void updateAITick() {
        if (this.worldObj.rand.nextInt(200) == 1) {
            this.setRevengeTarget(null);
        }
        super.updateAITick();
        if (this.worldObj.rand.nextInt(600) == 1) {
            this.LayAnEgg(1 + this.worldObj.rand.nextInt(3));
        }
    }

    private ItemStack LayAnEgg(final int par1) {
        EntityItem var3 = null;
        int i = 0;
        Item index = null;
        final int val = 0;
        ItemStack is = null;
        i = this.worldObj.rand.nextInt(115);
        switch (i) {
            case 5: {
                index = OreSpawnMain.GirlfriendEgg;
                break;
            }
            case 6: {
                index = OreSpawnMain.RedCowEgg;
                break;
            }
            case 7: {
                index = OreSpawnMain.GoldCowEgg;
                break;
            }
            case 8: {
                index = OreSpawnMain.EnchantedCowEgg;
                break;
            }
            case 9: {
                index = OreSpawnMain.MOTHRAEgg;
                break;
            }
            case 10: {
                index = OreSpawnMain.AloEgg;
                break;
            }
            case 11: {
                index = OreSpawnMain.CryoEgg;
                break;
            }
            case 12: {
                index = OreSpawnMain.CamaEgg;
                break;
            }
            case 13: {
                index = OreSpawnMain.VeloEgg;
                break;
            }
            case 14: {
                index = OreSpawnMain.HydroEgg;
                break;
            }
            case 15: {
                index = OreSpawnMain.BasilEgg;
                break;
            }
            case 16: {
                index = OreSpawnMain.DragonflyEgg;
                break;
            }
            case 17: {
                index = OreSpawnMain.EmperorScorpionEgg;
                break;
            }
            case 18: {
                index = OreSpawnMain.ScorpionEgg;
                break;
            }
            case 19: {
                index = OreSpawnMain.CaveFisherEgg;
                break;
            }
            case 20: {
                index = OreSpawnMain.SpyroEgg;
                break;
            }
            case 21: {
                index = OreSpawnMain.BaryonyxEgg;
                break;
            }
            case 22: {
                index = OreSpawnMain.GammaMetroidEgg;
                break;
            }
            case 23: {
                index = OreSpawnMain.CockateilEgg;
                break;
            }
            case 24: {
                index = OreSpawnMain.KyuubiEgg;
                break;
            }
            case 25: {
                index = OreSpawnMain.AlienEgg;
                break;
            }
            case 26: {
                index = OreSpawnMain.AttackSquidEgg;
                break;
            }
            case 27: {
                index = OreSpawnMain.WaterDragonEgg;
                break;
            }
            case 28: {
                index = OreSpawnMain.CephadromeEgg;
                break;
            }
            case 29: {
                index = OreSpawnMain.DragonEgg;
                break;
            }
            case 30: {
                index = OreSpawnMain.KrakenEgg;
                break;
            }
            case 31: {
                index = OreSpawnMain.LizardEgg;
                break;
            }
            case 32: {
                index = OreSpawnMain.BeeEgg;
                break;
            }
            case 33: {
                index = OreSpawnMain.TrooperBugEgg;
                break;
            }
            case 34: {
                index = OreSpawnMain.SpitBugEgg;
                break;
            }
            case 35: {
                index = OreSpawnMain.StinkBugEgg;
                break;
            }
            case 36: {
                index = OreSpawnMain.OstrichEgg;
                break;
            }
            case 37: {
                index = OreSpawnMain.GazelleEgg;
                break;
            }
            case 38: {
                index = OreSpawnMain.ChipmunkEgg;
                break;
            }
            case 39: {
                index = OreSpawnMain.CreepingHorrorEgg;
                break;
            }
            case 40: {
                index = OreSpawnMain.TerribleTerrorEgg;
                break;
            }
            case 41: {
                index = OreSpawnMain.CliffRacerEgg;
                break;
            }
            case 42: {
                index = OreSpawnMain.TriffidEgg;
                break;
            }
            case 43: {
                index = OreSpawnMain.PitchBlackEgg;
                break;
            }
            case 44: {
                index = OreSpawnMain.LurkingTerrorEgg;
                break;
            }
            case 45: {
                index = OreSpawnMain.GodzillaEgg;
                break;
            }
            case 46: {
                index = OreSpawnMain.SmallWormEgg;
                break;
            }
            case 47: {
                index = OreSpawnMain.MediumWormEgg;
                break;
            }
            case 48: {
                index = OreSpawnMain.LargeWormEgg;
                break;
            }
            case 49: {
                index = OreSpawnMain.CassowaryEgg;
                break;
            }
            case 50: {
                index = OreSpawnMain.CloudSharkEgg;
                break;
            }
            case 51: {
                index = OreSpawnMain.GoldFishEgg;
                break;
            }
            case 52: {
                index = OreSpawnMain.LeafMonsterEgg;
                break;
            }
            case 53: {
                index = OreSpawnMain.TshirtEgg;
                break;
            }
            case 54: {
                index = OreSpawnMain.EnderKnightEgg;
                break;
            }
            case 55: {
                index = OreSpawnMain.EnderReaperEgg;
                break;
            }
            case 56: {
                index = OreSpawnMain.BeaverEgg;
                break;
            }
            case 57: {
                index = OreSpawnMain.RotatorEgg;
                break;
            }
            case 58: {
                index = OreSpawnMain.VortexEgg;
                break;
            }
            case 59: {
                index = OreSpawnMain.PeacockEgg;
                break;
            }
            case 60: {
                index = OreSpawnMain.FairyEgg;
                break;
            }
            case 61: {
                index = OreSpawnMain.DungeonBeastEgg;
                break;
            }
            case 62: {
                index = OreSpawnMain.RatEgg;
                break;
            }
            case 63: {
                index = OreSpawnMain.FlounderEgg;
                break;
            }
            case 64: {
                index = OreSpawnMain.WhaleEgg;
                break;
            }
            case 65: {
                index = OreSpawnMain.IrukandjiEgg;
                break;
            }
            case 66: {
                index = OreSpawnMain.SkateEgg;
                break;
            }
            case 67: {
                index = OreSpawnMain.UrchinEgg;
                break;
            }
            case 68: {
                index = OreSpawnMain.Robot1Egg;
                break;
            }
            case 69: {
                index = OreSpawnMain.Robot2Egg;
                break;
            }
            case 70: {
                index = OreSpawnMain.Robot3Egg;
                break;
            }
            case 71: {
                index = OreSpawnMain.Robot4Egg;
                break;
            }
            case 72: {
                index = OreSpawnMain.GhostEgg;
                break;
            }
            case 73: {
                index = OreSpawnMain.GhostSkellyEgg;
                break;
            }
            case 74: {
                index = OreSpawnMain.BrownAntEgg;
                break;
            }
            case 75: {
                index = OreSpawnMain.RedAntEgg;
                break;
            }
            case 76: {
                index = OreSpawnMain.RainbowAntEgg;
                break;
            }
            case 77: {
                index = OreSpawnMain.UnstableAntEgg;
                break;
            }
            case 78: {
                index = OreSpawnMain.TermiteEgg;
                break;
            }
            case 79: {
                index = OreSpawnMain.ButterflyEgg;
                break;
            }
            case 80: {
                index = OreSpawnMain.MothEgg;
                break;
            }
            case 81: {
                index = OreSpawnMain.MosquitoEgg;
                break;
            }
            case 82: {
                index = OreSpawnMain.FireflyEgg;
                break;
            }
            case 83: {
                index = OreSpawnMain.TRexEgg;
                break;
            }
            case 84: {
                index = OreSpawnMain.HerculesEgg;
                break;
            }
            case 85: {
                index = OreSpawnMain.MantisEgg;
                break;
            }
            case 86: {
                index = OreSpawnMain.StinkyEgg;
                break;
            }
            case 87: {
                index = OreSpawnMain.Robot5Egg;
                break;
            }
            case 88: {
                index = OreSpawnMain.CoinEgg;
                break;
            }
            case 89: {
                index = OreSpawnMain.BoyfriendEgg;
                break;
            }
            case 90: {
                index = OreSpawnMain.TheKingEgg;
                break;
            }
            case 91: {
                index = OreSpawnMain.ThePrinceEgg;
                break;
            }
            case 92: {
                index = OreSpawnMain.EasterBunnyEgg;
                break;
            }
            case 93: {
                index = OreSpawnMain.MolenoidEgg;
                break;
            }
            case 94: {
                index = OreSpawnMain.SeaMonsterEgg;
                break;
            }
            case 95: {
                index = OreSpawnMain.SeaViperEgg;
                break;
            }
            case 96: {
                index = OreSpawnMain.CaterKillerEgg;
                break;
            }
            case 97: {
                index = OreSpawnMain.LeonEgg;
                break;
            }
            case 98: {
                index = OreSpawnMain.HammerheadEgg;
                break;
            }
            case 99: {
                index = OreSpawnMain.RubberDuckyEgg;
                break;
            }
            case 100: {
                index = OreSpawnMain.CrystalCowEgg;
                break;
            }
            case 101: {
                index = OreSpawnMain.CriminalEgg;
                break;
            }
            case 102: {
                index = OreSpawnMain.TheQueenEgg;
                break;
            }
            case 103: {
                index = OreSpawnMain.BrutalflyEgg;
                break;
            }
            case 104: {
                index = OreSpawnMain.NastysaurusEgg;
                break;
            }
            case 105: {
                index = OreSpawnMain.PointysaurusEgg;
                break;
            }
            case 106: {
                index = OreSpawnMain.CricketEgg;
                break;
            }
            case 107: {
                index = OreSpawnMain.ThePrincessEgg;
                break;
            }
            case 108: {
                index = OreSpawnMain.FrogEgg;
                break;
            }
            case 109: {
                index = OreSpawnMain.JefferyEgg;
                break;
            }
            case 110: {
                index = OreSpawnMain.AntRobotEgg;
                break;
            }
            case 111: {
                index = OreSpawnMain.SpiderRobotEgg;
                break;
            }
            case 112: {
                index = OreSpawnMain.SpiderDriverEgg;
                break;
            }
            case 113: {
                index = OreSpawnMain.CrabEgg;
                break;
            }
            default: {
                index = null;
                break;
            }
        }
        if (index == null) {
            return null;
        }
        is = new ItemStack(index, par1, val);
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

    public EasterBunny spawnBabyAnimal(final EntityAgeable par1EntityAgeable) {
        return new EasterBunny(this.worldObj);
    }

    public boolean isWheat(final ItemStack par1ItemStack) {
        return par1ItemStack != null && par1ItemStack.getItem() == Items.apple;
    }

    public boolean isBreedingItem(final ItemStack par1ItemStack) {
        return par1ItemStack.getItem() == OreSpawnMain.MyCrystalApple;
    }
}
