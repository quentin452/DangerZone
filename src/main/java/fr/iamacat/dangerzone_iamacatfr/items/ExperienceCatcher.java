package fr.iamacat.dangerzone_iamacatfr.items;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class ExperienceCatcher extends Item {

    public ExperienceCatcher() {
        this.setTextureName(Tags.MODID + ":experiencecatcher");
    }

    public boolean onItemUse(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final World world,
        final int x, final int y, final int z, final int par7, final float par8, final float par9, final float par10) {
        par2EntityPlayer.swingItem();
        if (!world.isRemote) {
            final AxisAlignedBB bb = AxisAlignedBB
                .getBoundingBox(x - 0.5 + par8, y, z - 0.5 + par10, x + 0.5 + par8, y + 2.0, z + 0.5 + par10);
            final List<EntityXPOrb> xpOrbs = world.getEntitiesWithinAABB(EntityXPOrb.class, bb);
            final Random rand = world.rand;

            for (final EntityXPOrb ex : xpOrbs) {
                if (ex.getXpValue() >= 3 && rand.nextInt(5) != 1) {
                    ex.setDead();

                    // Créez un tableau d'objets ItemStack pour les récompenses
                    ItemStack[] rewards = { new ItemStack(Items.experience_bottle), new ItemStack(Items.string),
                        new ItemStack(Items.stick) };

                    // Choisissez aléatoirement l'une des récompenses
                    ItemStack reward = rewards[rand.nextInt(rewards.length)];

                    // Créez une entité d'item pour la récompense
                    EntityItem itemEntity = new EntityItem(
                        par2EntityPlayer.worldObj,
                        x + par8,
                        y + 1.0,
                        z + par10,
                        reward);

                    // Ajoutez l'entité d'item au monde
                    par2EntityPlayer.worldObj.spawnEntityInWorld(itemEntity);
                }
            }

            // Si vous souhaitez réduire la stackSize de par1ItemStack même si aucune orbite XP n'a été collectée
            if (!par2EntityPlayer.capabilities.isCreativeMode) {
                --par1ItemStack.stackSize;
            }

            return true;
        }

        return false;
    }
}
