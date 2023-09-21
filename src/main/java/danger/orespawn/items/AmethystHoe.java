
package danger.orespawn.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AmethystHoe extends ItemHoe {

    public AmethystHoe(final int par1, final Item.ToolMaterial par2) {
        super(par2);
        this.maxStackSize = 1;
        this.setMaxDamage(2000);
        this.setCreativeTab(CreativeTabs.tabTools);
    }

    public int getDamageVsEntity(final Entity par1Entity) {
        return 5;
    }

    public String getMaterialName() {
        return "Amethyst";
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(
            "OreSpawn:" + this.getUnlocalizedName()
                .substring(5));
    }
}
