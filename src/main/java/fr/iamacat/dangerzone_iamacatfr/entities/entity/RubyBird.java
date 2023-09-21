
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.world.World;

public class RubyBird extends Cockateil {

    public RubyBird(final World par1World) {
        super(par1World);
    }

    protected void entityInit() {
        super.entityInit();
        this.setBirdType(this.birdtype = 5);
        this.setFlyUp();
    }

    protected String getLivingSound() {
        if (this.worldObj.isDaytime() && !this.worldObj.isRaining()) {
            return Tags.MODID + ":rubybird";
        }
        return null;
    }

    public boolean getCanSpawnHere() {
        return true;
    }
}
