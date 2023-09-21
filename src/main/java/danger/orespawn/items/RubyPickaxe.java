
package danger.orespawn.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RubyPickaxe extends ItemPickaxe {

    private int weaponDamage;

    public RubyPickaxe(final int par1, final Item.ToolMaterial par2) {
        super(par2);
        this.weaponDamage = 12;
        this.maxStackSize = 1;
        this.setMaxDamage(1500);
        this.setCreativeTab(CreativeTabs.tabTools);
    }

    public int getDamageVsEntity(final Entity par1Entity) {
        return this.weaponDamage;
    }

    public int getDamageVsEntity() {
        return this.weaponDamage;
    }

    public String getMaterialName() {
        return "Ruby";
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(
            "OreSpawn:" + this.getUnlocalizedName()
                .substring(5));
    }
}
