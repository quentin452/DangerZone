package fr.iamacat.dangerzone_iamacatfr.items;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EmeraldHoe extends ItemHoe {

    public EmeraldHoe(ToolMaterial material) {
        super(material);
        setTextureName(Tags.MODID + ":ultimatehoe");
    }


}
