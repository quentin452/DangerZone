
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import fr.iamacat.dangerzone_iamacatfr.entities.ai.MyEntityAIWanderALot;
import fr.iamacat.dangerzone_iamacatfr.init.ItemInitDangerZone;
import fr.iamacat.dangerzone_iamacatfr.util.Constants;
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
            this.LayAnSpawnEgg(1 + this.worldObj.rand.nextInt(3));
        }
    }

    private ItemStack LayAnSpawnEgg(final int par1) {
        EntityItem var3 = null;
        int i = 0;
        Item index = null;
        final int val = 0;
        ItemStack is = null;
        i = this.worldObj.rand.nextInt(115);
        switch (i) {
            case 5: {
                index = Constants.Girlfriend;
                break;
            }
            case 6: {
                index = Constants.AppleCowSpawnEgg;
                break;
            }
            case 7: {
                index = Constants.GoldenAppleCowSpawnEgg;
                break;
            }
            case 8: {
                index = Constants.EnchantedGoldenAppleCowSpawnEgg;
                break;
            }
            case 9: {
                index = Constants.MOTHRASpawnEgg;
                break;
            }
            case 10: {
                index = Constants.AlosaurusSpawnEgg;
                break;
            }
            case 11: {
                index = Constants.CryolohosaurusSpawnEgg;
                break;
            }
            case 12: {
                index = Constants.CamarasaurusSPawnEgg;
                break;
            }
            case 13: {
                index = Constants.VelocityRaptor;
                break;
            }
            case 14: {
                index = Constants.HydroliscSpawnEgg;
                break;
            }
            case 15: {
                index = Constants.BasiliskSpawnEgg;
                break;
            }
            case 16: {
                index = Constants.DragonflySpawnEgg;
                break;
            }
            case 17: {
                index = Constants.EmperorScorpionEgg;
                break;
            }
            case 18: {
                index = Constants.ScorpionSpawnEgg;
                break;
            }
            case 19: {
                index = Constants.CaveFisherSpawnEgg;
                break;
            }
            case 20: {
                index = Constants.BabyDragonSpawnEgg;
                break;
            }
            case 21: {
                index = Constants.BrayonyxSPawnEgg;
                break;
            }
            case 22: {
                index = Constants.WtfSpawnEgg;
                break;
            }
            case 23: {
                index = Constants.BirdSpawnEgg;
                break;
            }
            case 24: {
                index = Constants.KyuubiSpawnEgg;
                break;
            }
            case 25: {
                index = Constants.AlienSpawnEgg;
                break;
            }
            case 26: {
                index = Constants.AttackSquidSpawnEgg;
                break;
            }
            case 27: {
                index = Constants.WaterDragonSpawnEgg;
                break;
            }
            case 28: {
                index = Constants.CepahdromeSPawnEgg;
                break;
            }
            case 29: {
                index = Constants.DragonSpawnEgg;
                break;
            }
            case 30: {
                index = Constants.KrakenSpawnEgg;
                break;
            }
            case 31: {
                index = Constants.LizardSPawnEgg;
                break;
            }
            case 32: {
                index = Constants.BeeSpawnEgg;
                break;
            }
            case 33: {
                index = Constants.TrooperBugSpawnEgg;
                break;
            }
            case 34: {
                index = Constants.SpitbugSpawnEgg;
                break;
            }
            case 35: {
                index = Constants.StinkBugSpawnEgg;
                break;
            }
            case 36: {
                index = Constants.OstrichSpawnEgg;
                break;
            }
            case 37: {
                index = Constants.GazelleSpawnEgg;
                break;
            }
            case 38: {
                index = Constants.ChipmunkSpawnEgg;
                break;
            }
            case 39: {
                index = Constants.CreepingHorrorSpawnEgg;
                break;
            }
            case 40: {
                index = Constants.TerribleTerrorSpawnEgg;
                break;
            }
            case 41: {
                index = Constants.CliffRacerSpawnEgg;
                break;
            }
            case 42: {
                index = Constants.TriffidSpawnEgg;
                break;
            }
            case 43: {
                index = Constants.NightMareSpawnEgg;
                break;
            }
            case 44: {
                index = Constants.LurkingTerrorSpawnEgg;
                break;
            }
            case 45: {
                index = Constants.MobzillaSpawnEgg;
                break;
            }
            case 46: {
                index = Constants.SmallWormSpawnEgg;
                break;
            }
            case 47: {
                index = Constants.MediumWormSpawnEgg;
                break;
            }
            case 48: {
                index = Constants.LargeWormSpawnEgg;
                break;
            }
            case 49: {
                index = Constants.CassowarySpawnEgg;
                break;
            }
            case 50: {
                index = Constants.CloudSharkSpawnEgg;
                break;
            }
            case 51: {
                index = Constants.GoldFishSpawnEgg;
                break;
            }
            case 52: {
                index = Constants.LeafMonsterSpawnEgg;
                break;
            }
            case 53: {
                index = Constants.TshirtSpawnEgg;
                break;
            }
            case 54: {
                index = Constants.EnderKnightSpawnEgg;
                break;
            }
            case 55: {
                index = Constants.EnderReaperSpawnEgg;
                break;
            }
            case 56: {
                index = Constants.BeaverSpawnEgg;
                break;
            }
            case 57: {
                index = Constants.RotatorSpawnEgg;
                break;
            }
            case 58: {
                index = Constants.VortexSpawnEgg;
                break;
            }
            case 59: {
                index = Constants.PeacockSpawnEgg;
                break;
            }
            case 60: {
                index = Constants.FairySpawnEgg;
                break;
            }
            case 61: {
                index = Constants.DungeonBeastSpawnEgg;
                break;
            }
            case 62: {
                index = Constants.RatSpawnEgg;
                break;
            }
            case 63: {
                index = Constants.FlounderSPawnEgg;
                break;
            }
            case 64: {
                index = Constants.WhaleSpawnEgg;
                break;
            }
            case 65: {
                index = Constants.IrukandjiSpawnEgg;
                break;
            }
            case 66: {
                index = Constants.SkateSpawnEgg;
                break;
            }
            case 67: {
                index = Constants.crystalUrchinSpawnEgg;
                break;
            }
            case 68: {
                index = Constants.RoboGunnerSpawnEgg;
                break;
            }
            case 69: {
                index = Constants.RoboPounderSpawnEgg;
                break;
            }
            case 70: {
                index = Constants.RoboSniperSpawnEgg;
                break;
            }
            case 71: {
                index = Constants.RoboWarriorSpawnEgg;
                break;
            }
            case 72:
            case 73: {
                index = Constants.GhostSpawnEgg;
                break;
            }
            case 74: {
                index = Constants.BrownAntSpawnEgg;
                break;
            }
            case 75: {
                index = Constants.RedAntSpawnEgg;
                break;
            }
            case 76: {
                index = Constants.RainBowAntSPawnEgg;
                break;
            }
            case 77: {
                index = Constants.UnstableAntSpawnEgg;
                break;
            }
            case 78: {
                index = Constants.termiteSPawnEgg;
                break;
            }
            case 79: {
                index = Constants.ButterflySpawnEgg;
                break;
            }
            case 80: {
                index = Constants.MothSpawnEgg;
                break;
            }
            case 81: {
                index = Constants.MosquitoSpawnEgg;
                break;
            }
            case 82: {
                index = Constants.FireflySpawnEgg;
                break;
            }
            case 83: {
                index = Constants.TrexSpawnEgg;
                break;
            }
            case 84: {
                index = Constants.HerculesBeetleSPawnEgg;
                break;
            }
            case 85: {
                index = Constants.MantisSpawnEgg;
                break;
            }
            case 86: {
                index = Constants.StinkySpawnEgg;
                break;
            }
            case 87: {
                index = Constants.GiantSpiderRobotSpawnEgg;
                break;
            }
            case 88: {
                index = Constants.CoinSpawnEgg;
                break;
            }
            case 89: {
                index = Constants.Boyfriend;
                break;
            }
            case 90: {
                index = Constants.TheKingSpawnEgg;
                break;
            }
            case 91: {
                index = Constants.ThePrinceSpawnEgg;
                break;
            }
            case 92: {
                index = Constants.EasterbunnySpawnEgg;
                break;
            }
            case 93: {
                index = Constants.MolenoidSpawnEgg;
                break;
            }
            case 94: {
                index = Constants.SeaMonsterSpawnEgg;
                break;
            }
            case 95: {
                index = Constants.SeaViperSpawnEgg;
                break;
            }
            case 96: {
                index = Constants.CaterKillerSpawnEgg;
                break;
            }
            case 97: {
                index = Constants.LeonopteryxSpawnEgg;
                break;
            }
            case 98: {
                index = Constants.HammerheadSpawnEgg;
                break;
            }
            case 99: {
                index = Constants.RubberDuckySpawnegg;
                break;
            }
            case 100: {
                index = Constants.CrystalCowSpawnEgg;
                break;
            }
            case 101: {
                index = Constants.CriminalSpawnegg;
                break;
            }
            case 102: {
                index = Constants.TheQueenSpawnEgg;
                break;
            }
            case 103: {
                index = Constants.BrutalflySpawnEgg;
                break;
            }
            case 104: {
                index = Constants.NastysaurusSpawnEgg;
                break;
            }
            case 105: {
                index = Constants.PointysaurusSpawnEgg;
                break;
            }
            case 106: {
                index = Constants.CricketSpawnEgg;
                break;
            }
            case 107: {
                index = Constants.ThePrincessSpawnEgg;
                break;
            }
            case 108: {
                index = Constants.FrogSpawnEgg;
                break;
            }
            case 109: {
                index = Constants.JefferySpawnEgg;
                break;
            }
            case 110: {
                index = Constants.RedAntRobot;
                break;
            }
            case 111:
            case 112: {
                index = Constants.SpiderDriverSpawnEgg;
                break;
            }
            case 113: {
                index = Constants.CrabSpawnEgg;
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
        return par1ItemStack.getItem() == ItemInitDangerZone.CrystalAppleItem;
    }
}
