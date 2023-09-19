
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import fr.iamacat.dangerzone_iamacatfr.entities.ai.MyEntityAIWanderALot;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
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

public class EasterBunnyInstance extends EntityAnimal {

    private float moveSpeed;

    public EasterBunnyInstance(final World par1World) {
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
        EasterBunnyInstance target = null;
        target = (EasterBunnyInstance) this.worldObj
            .findNearestEntityWithinAABB(EasterBunnyInstance.class, this.boundingBox.expand(32.0, 8.0, 32.0), this);
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
        return Tags.MODID + ":duck_hurt";
    }

    protected String getDeathSound() {
        return  Tags.MODID + ":duck_hurt";
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
                index = DangerZone.GirlfriendEgg;
                break;
            }
            case 6: {
                index = DangerZone.RedCowEgg;
                break;
            }
            case 7: {
                index = DangerZone.GoldCowEgg;
                break;
            }
            case 8: {
                index = DangerZone.EnchantedCowEgg;
                break;
            }
            case 9: {
                index = DangerZone.MOTHRAEgg;
                break;
            }
            case 10: {
                index = DangerZone.AloEgg;
                break;
            }
            case 11: {
                index = DangerZone.CryoEgg;
                break;
            }
            case 12: {
                index = DangerZone.CamaEgg;
                break;
            }
            case 13: {
                index = DangerZone.VeloEgg;
                break;
            }
            case 14: {
                index = DangerZone.HydroEgg;
                break;
            }
            case 15: {
                index = DangerZone.BasilEgg;
                break;
            }
            case 16: {
                index = DangerZone.DragonflyEgg;
                break;
            }
            case 17: {
                index = DangerZone.EmperorScorpionEgg;
                break;
            }
            case 18: {
                index = DangerZone.ScorpionEgg;
                break;
            }
            case 19: {
                index = DangerZone.CaveFisherEgg;
                break;
            }
            case 20: {
                index = DangerZone.SpyroEgg;
                break;
            }
            case 21: {
                index = DangerZone.BaryonyxEgg;
                break;
            }
            case 22: {
                index = DangerZone.GammaMetroidEgg;
                break;
            }
            case 23: {
                index = DangerZone.CockateilEgg;
                break;
            }
            case 24: {
                index = DangerZone.KyuubiEgg;
                break;
            }
            case 25: {
                index = DangerZone.AlienEgg;
                break;
            }
            case 26: {
                index = DangerZone.AttackSquidEgg;
                break;
            }
            case 27: {
                index = DangerZone.WaterDragonEgg;
                break;
            }
            case 28: {
                index = DangerZone.CephadromeEgg;
                break;
            }
            case 29: {
                index = DangerZone.DragonEgg;
                break;
            }
            case 30: {
                index = DangerZone.KrakenEgg;
                break;
            }
            case 31: {
                index = DangerZone.LizardEgg;
                break;
            }
            case 32: {
                index = DangerZone.BeeEgg;
                break;
            }
            case 33: {
                index = DangerZone.TrooperBugEgg;
                break;
            }
            case 34: {
                index = DangerZone.SpitBugEgg;
                break;
            }
            case 35: {
                index = DangerZone.StinkBugEgg;
                break;
            }
            case 36: {
                index = DangerZone.OstrichEgg;
                break;
            }
            case 37: {
                index = DangerZone.GazelleEgg;
                break;
            }
            case 38: {
                index = DangerZone.ChipmunkEgg;
                break;
            }
            case 39: {
                index = DangerZone.CreepingHorrorEgg;
                break;
            }
            case 40: {
                index = DangerZone.TerribleTerrorEgg;
                break;
            }
            case 41: {
                index = DangerZone.CliffRacerEgg;
                break;
            }
            case 42: {
                index = DangerZone.TriffidEgg;
                break;
            }
            case 43: {
                index = DangerZone.PitchBlackEgg;
                break;
            }
            case 44: {
                index = DangerZone.LurkingTerrorEgg;
                break;
            }
            case 45: {
                index = DangerZone.GodzillaEgg;
                break;
            }
            case 46: {
                index = DangerZone.SmallWormEgg;
                break;
            }
            case 47: {
                index = DangerZone.MediumWormEgg;
                break;
            }
            case 48: {
                index = DangerZone.LargeWormEgg;
                break;
            }
            case 49: {
                index = DangerZone.CassowaryEgg;
                break;
            }
            case 50: {
                index = DangerZone.CloudSharkEgg;
                break;
            }
            case 51: {
                index = DangerZone.GoldFishEgg;
                break;
            }
            case 52: {
                index = DangerZone.LeafMonsterEgg;
                break;
            }
            case 53: {
                index = DangerZone.TshirtEgg;
                break;
            }
            case 54: {
                index = DangerZone.EnderKnightEgg;
                break;
            }
            case 55: {
                index = DangerZone.EnderReaperEgg;
                break;
            }
            case 56: {
                index = DangerZone.BeaverEgg;
                break;
            }
            case 57: {
                index = DangerZone.RotatorEgg;
                break;
            }
            case 58: {
                index = DangerZone.VortexEgg;
                break;
            }
            case 59: {
                index = DangerZone.PeacockEgg;
                break;
            }
            case 60: {
                index = DangerZone.FairyEgg;
                break;
            }
            case 61: {
                index = DangerZone.DungeonBeastEgg;
                break;
            }
            case 62: {
                index = DangerZone.RatEgg;
                break;
            }
            case 63: {
                index = DangerZone.FlounderEgg;
                break;
            }
            case 64: {
                index = DangerZone.WhaleEgg;
                break;
            }
            case 65: {
                index = DangerZone.IrukandjiEgg;
                break;
            }
            case 66: {
                index = DangerZone.SkateEgg;
                break;
            }
            case 67: {
                index = DangerZone.UrchinEgg;
                break;
            }
            case 68: {
                index = DangerZone.Robot1Egg;
                break;
            }
            case 69: {
                index = DangerZone.Robot2Egg;
                break;
            }
            case 70: {
                index = DangerZone.Robot3Egg;
                break;
            }
            case 71: {
                index = DangerZone.Robot4Egg;
                break;
            }
            case 72: {
                index = DangerZone.GhostEgg;
                break;
            }
            case 73: {
                index = DangerZone.GhostSkellyEgg;
                break;
            }
            case 74: {
                index = DangerZone.BrownAntEgg;
                break;
            }
            case 75: {
                index = DangerZone.RedAntEgg;
                break;
            }
            case 76: {
                index = DangerZone.RainbowAntEgg;
                break;
            }
            case 77: {
                index = DangerZone.UnstableAntEgg;
                break;
            }
            case 78: {
                index = DangerZone.TermiteEgg;
                break;
            }
            case 79: {
                index = DangerZone.ButterflyEgg;
                break;
            }
            case 80: {
                index = DangerZone.MothEgg;
                break;
            }
            case 81: {
                index = DangerZone.MosquitoEgg;
                break;
            }
            case 82: {
                index = DangerZone.FireflyEgg;
                break;
            }
            case 83: {
                index = DangerZone.TRexEgg;
                break;
            }
            case 84: {
                index = DangerZone.HerculesEgg;
                break;
            }
            case 85: {
                index = DangerZone.MantisEgg;
                break;
            }
            case 86: {
                index = DangerZone.StinkyEgg;
                break;
            }
            case 87: {
                index = DangerZone.Robot5Egg;
                break;
            }
            case 88: {
                index = DangerZone.CoinEgg;
                break;
            }
            case 89: {
                index = DangerZone.BoyfriendEgg;
                break;
            }
            case 90: {
                index = DangerZone.TheKingEgg;
                break;
            }
            case 91: {
                index = DangerZone.ThePrinceEgg;
                break;
            }
            case 92: {
                index = DangerZone.EasterBunnyEgg;
                break;
            }
            case 93: {
                index = DangerZone.MolenoidEgg;
                break;
            }
            case 94: {
                index = DangerZone.SeaMonsterEgg;
                break;
            }
            case 95: {
                index = DangerZone.SeaViperEgg;
                break;
            }
            case 96: {
                index = DangerZone.CaterKillerEgg;
                break;
            }
            case 97: {
                index = DangerZone.LeonEgg;
                break;
            }
            case 98: {
                index = DangerZone.HammerheadEgg;
                break;
            }
            case 99: {
                index = DangerZone.RubberDuckyEgg;
                break;
            }
            case 100: {
                index = DangerZone.CrystalCowEgg;
                break;
            }
            case 101: {
                index = DangerZone.CriminalEgg;
                break;
            }
            case 102: {
                index = DangerZone.TheQueenEgg;
                break;
            }
            case 103: {
                index = DangerZone.BrutalflyEgg;
                break;
            }
            case 104: {
                index = DangerZone.NastysaurusEgg;
                break;
            }
            case 105: {
                index = DangerZone.PointysaurusEgg;
                break;
            }
            case 106: {
                index = DangerZone.CricketEgg;
                break;
            }
            case 107: {
                index = DangerZone.ThePrincessEgg;
                break;
            }
            case 108: {
                index = DangerZone.FrogEgg;
                break;
            }
            case 109: {
                index = DangerZone.JefferyEgg;
                break;
            }
            case 110: {
                index = DangerZone.AntRobotEgg;
                break;
            }
            case 111: {
                index = DangerZone.SpiderRobotEgg;
                break;
            }
            case 112: {
                index = DangerZone.SpiderDriverEgg;
                break;
            }
            case 113: {
                index = DangerZone.CrabEgg;
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
            this.posX + rand.nextInt(2) - rand.nextInt(2),
            this.posY + 1.0,
            this.posZ + rand.nextInt(2) - rand.nextInt(2),
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

    public EasterBunnyInstance spawnBabyAnimal(final EntityAgeable par1EntityAgeable) {
        return new EasterBunnyInstance(this.worldObj);
    }

    public boolean isWheat(final ItemStack par1ItemStack) {
        return par1ItemStack != null && par1ItemStack.getItem() == Items.apple;
    }

    public boolean isBreedingItem(final ItemStack par1ItemStack) {
        return par1ItemStack.getItem() == DangerZone.MyCrystalApple;
    }
}
