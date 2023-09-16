package fr.iamacat.dangerzone_iamacatfr.items;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.event.world.BlockEvent;

public class NetherTracker extends Item {
    public NetherTracker() {
        this.setTextureName(Tags.MODID + ":netherlost");
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isRemote && selected && entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;
            int x = MathHelper.floor_double(player.posX);
            int y = MathHelper.floor_double(player.posY);
            int z = MathHelper.floor_double(player.posZ);

            if (stack != null && stack.getItem() == this) {
                Block blockUnderPlayer = world.getBlock(x, y - 1, z);

                if (blockUnderPlayer == Blocks.netherrack) {
                    // Remplacer le bloc Netherrack par Quartz
                    world.setBlock(x, y - 1, z, Blocks.quartz_block);
                    stack.damageItem(1, player); // Réduire la durabilité de l'item
                }
            }
        }
    }
}
