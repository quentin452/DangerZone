package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.scoreboard.Team;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import java.util.UUID;

public class GirlFriendInstance extends EntityTameable {

    private boolean isTamed;
    public ResourceLocation textureName;
    private int skinVariant;

    public GirlFriendInstance(World world) {
        super(world);

        // Choisissez aléatoirement la variante de la texture
        this.skinVariant = world.rand.nextInt(40);

        // Utilisez la variante pour initialiser la DataWatcher
        this.dataWatcher.addObject(31, this.skinVariant);

        this.setSize(1.0F, 1.8F);
    }

    public int getSkin() {
        return this.dataWatcher.getWatchableObjectInt(31);
    }

    public void setSkin(int entity) {
        this.dataWatcher.updateObject(31, entity);
    }

    @Override
    public EntityAgeable createChild(EntityAgeable p_90011_1_) {
        return null;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(20D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(0.600000011920929D);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(19, (byte) 0);
        this.dataWatcher.addObject(18, "");

    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        this.setSkin(compound.getInteger("Variant"));

        // Lisez d'autres données de l'entité depuis NBT (si nécessaire)
        if (compound.hasKey("OwnerUUID", 8)) {
            String s = compound.getString("OwnerUUID");
            if (s.length() > 0) {
                this.func_152115_b(s);
                this.setTamed(true);
            }
        }

        this.setSitting(compound.getBoolean("Sitting"));
    }

    @Override
    public boolean interact(EntityPlayer player) {
        if (!player.isSneaking()) {
            System.out.println("Interacting without sneaking...");
            // Essayez d'apprivoiser la Girlfriend
            if (this.attemptTame(player)) {
                System.out.println("Attempted to tame Girlfriend.");
                return true;
            }
            // D'autres interactions si nécessaire
        } else {
            System.out.println("Interacting while sneaking...");
        }

        // D'autres interactions si nécessaire lorsque le joueur sneake
        return super.interact(player);
    }

    public boolean attemptTame(EntityPlayer player) {
        ItemStack heldItem = player.inventory.getCurrentItem();

        if (heldItem != null && Block.getBlockFromItem(heldItem.getItem()) == Blocks.deadbush && !isTamed) {
            // Définir le pourcentage de chance de réussite (par exemple, 50%)
            double successChance = 0.5;

            // Générer un nombre aléatoire entre 0 et 1
            double randomValue = worldObj.rand.nextDouble();

            // Vérifier si l'apprivoisement réussit en fonction du pourcentage de chance
            if (randomValue <= successChance) {
                // Réussi
                isTamed = true;
                this.setTamed(true);

                // Retirez l'objet utilisé pour l'apprivoisement (red rose)
                if (!player.capabilities.isCreativeMode) {
                    heldItem.stackSize--;
                    if (heldItem.stackSize <= 0) {
                        player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
                    }
                }

                // Jouez l'effet d'apprivoisement
                this.playTameEffect(true);

                // Définissez le propriétaire (si vous le souhaitez)
                this.func_152115_b(
                    player.getUniqueID()
                        .toString());

                return true;
            } else {
                // Échec
                // Vous pouvez ajouter un effet ou un message d'échec ici si vous le souhaitez
            }
        }

        return false;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        compound.setInteger("Variant", this.getSkin());

        // Écrivez d'autres données de l'entité dans NBT (si nécessaire)
        if (this.func_152113_b() == null) {
            compound.setString("OwnerUUID", "");
        } else {
            compound.setString("OwnerUUID", this.func_152113_b());
        }

        compound.setBoolean("Sitting", this.isSitting());
    }

    /**
     * Play the taming effect, will either be hearts or smoke depending on status
     */
    protected void playTameEffect(boolean p_70908_1_) {
        String s = "heart";

        if (!p_70908_1_) {
            s = "smoke";
        }

        for (int i = 0; i < 7; ++i) {
            double d0 = this.rand.nextGaussian() * 0.02D;
            double d1 = this.rand.nextGaussian() * 0.02D;
            double d2 = this.rand.nextGaussian() * 0.02D;
            this.worldObj.spawnParticle(
                s,
                this.posX + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width,
                this.posY + 0.5D + (double) (this.rand.nextFloat() * this.height),
                this.posZ + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width,
                d0,
                d1,
                d2);
        }
    }

    @SideOnly(Side.CLIENT)
    public void handleHealthUpdate(byte p_70103_1_) {
        if (p_70103_1_ == 7) {
            this.playTameEffect(true);
        } else if (p_70103_1_ == 6) {
            this.playTameEffect(false);
        } else {
            super.handleHealthUpdate(p_70103_1_);
        }
    }

    @Override
    public ItemStack getHeldItem() {
        return null;
    }

    @Override
    public ItemStack getEquipmentInSlot(int p_71124_1_) {
        return null;
    }

    @Override
    public void setCurrentItemOrArmor(int slotIn, ItemStack itemStackIn) {

    }

    @Override
    public ItemStack[] getLastActiveItems() {
        return new ItemStack[0];
    }

    public void setTamed(boolean p_70903_1_) {
        int b0 = this.dataWatcher.getWatchableObjectByte(16);

        if (p_70903_1_) {
            this.dataWatcher.updateObject(16, (byte) (b0 | 1));
        } else {
            this.dataWatcher.updateObject(16, (byte) (b0 & ~1));
        }
    }

    public boolean isTamed() {
        return (this.dataWatcher.getWatchableObjectInt(16) & 1) != 0;
    }

    public boolean isSitting() {
        return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
    }

    public void setSitting(boolean p_70904_1_) {
        int b0 = this.dataWatcher.getWatchableObjectByte(16);

        if (p_70904_1_) {
            this.dataWatcher.updateObject(16, (byte) (b0 | 1));
        } else {
            this.dataWatcher.updateObject(16, (byte) (b0 & -2));
        }
    }

    public String func_152113_b() {
        return this.dataWatcher.getWatchableObjectString(17);
    }

    public void func_152115_b(String p_152115_1_) {
        this.dataWatcher.updateObject(17, p_152115_1_);
    }

    public EntityLivingBase getOwner() {
        try {
            UUID uuid = UUID.fromString(this.func_152113_b());
            return uuid == null ? null : this.worldObj.func_152378_a(uuid);
        } catch (IllegalArgumentException illegalargumentexception) {
            return null;
        }
    }

    public boolean func_152114_e(EntityLivingBase p_152114_1_) {
        return p_152114_1_ == this.getOwner();
    }

    public boolean func_142018_a(EntityLivingBase p_142018_1_, EntityLivingBase p_142018_2_) {
        return true;
    }

    public Team getTeam() {
        if (this.isTamed()) {
            EntityLivingBase entitylivingbase = this.getOwner();

            if (entitylivingbase != null) {
                return entitylivingbase.getTeam();
            }
        }

        return super.getTeam();
    }

    public boolean isOnSameTeam(EntityLivingBase p_142014_1_) {
        if (this.isTamed()) {
            EntityLivingBase entitylivingbase1 = this.getOwner();

            if (p_142014_1_ == entitylivingbase1) {
                return true;
            }

            if (entitylivingbase1 != null) {
                return entitylivingbase1.isOnSameTeam(p_142014_1_);
            }
        }

        return super.isOnSameTeam(p_142014_1_);
    }
}
