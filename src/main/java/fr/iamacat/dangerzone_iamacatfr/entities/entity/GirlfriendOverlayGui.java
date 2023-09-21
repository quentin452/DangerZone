
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import org.lwjgl.opengl.GL11;

public class GirlfriendOverlayGui extends Gui {

    private Minecraft mc;
    private static final ResourceLocation texture;

    public GirlfriendOverlayGui(final Minecraft mc) {
        this.mc = mc;
    }

    @SubscribeEvent
    public void onRenderOverlay(final RenderGameOverlayEvent event) {
        if (event.isCancelable() || event.type != RenderGameOverlayEvent.ElementType.HOTBAR) {
            return;
        }
        final int u = 0;
        final int v = 0;
        String outstring = null;
        final int color = 16725044;
        final FontRenderer fr = this.mc.fontRenderer;
        final int barWidth = 182;
        final int barHeight = 5;
        float gfHealth = 0.0f;
        Entity entity = null;
        EntityPlayer player = null;
        if (this.mc.gameSettings.hideGUI || this.mc.currentScreen != null) {
            return;
        }
        player = (EntityPlayer) this.mc.thePlayer;
        if (player == null) {
            return;
        }
        OreSpawnMain.current_dimension = player.worldObj.provider.dimensionId;
        if (this.mc.gameSettings.fancyGraphics) {
            OreSpawnMain.FastGraphicsLeaves = 0;
        } else {
            OreSpawnMain.FastGraphicsLeaves = 1;
        }
        if (OreSpawnMain.GuiOverlayEnable == 0) {
            return;
        }
        entity = this.mc.pointedEntity;
        if (entity == null) {
            entity = OreSpawnMain.getPointedAtEntity((World) this.mc.theWorld, player, 16.0);
            if (entity == null) {
                return;
            }
            if (!(entity instanceof EntityLivingBase)) {
                return;
            }
        }
        if (entity instanceof Girlfriend) {
            Girlfriend gf = null;
            gf = (Girlfriend) entity;
            if (!gf.func_152114_e(player)) {
                return;
            }
            if (gf.passenger != 0) {
                return;
            }
            if (gf.hasCustomNameTag()) {
                outstring = gf.getCustomNameTag();
            }
            if (outstring == null || outstring.equals("")) {
                outstring = "Girlfriend";
            }
            gfHealth = gf.getGirlfriendHealth() / gf.getMaxHealth();
        }
        if (entity instanceof Boyfriend) {
            Boyfriend gf2 = null;
            gf2 = (Boyfriend) entity;
            if (!gf2.func_152114_e(player)) {
                return;
            }
            if (gf2.passenger != 0) {
                return;
            }
            if (gf2.hasCustomNameTag()) {
                outstring = gf2.getCustomNameTag();
            }
            if (outstring == null || outstring.equals("")) {
                outstring = "Boyfriend";
            }
            gfHealth = gf2.getBoyfriendHealth() / gf2.getMaxHealth();
        }
        if (entity instanceof ThePrince) {
            ThePrince gf3 = null;
            gf3 = (ThePrince) entity;
            if (!gf3.func_152114_e(player)) {
                return;
            }
            if (gf3.hasCustomNameTag()) {
                outstring = gf3.getCustomNameTag();
            }
            if (outstring == null || outstring.equals("")) {
                outstring = "The Toddler Prince";
            }
            gfHealth = gf3.getHealth() / gf3.getMaxHealth();
        }
        if (entity instanceof ThePrincess) {
            ThePrincess gf4 = null;
            gf4 = (ThePrincess) entity;
            if (!gf4.func_152114_e(player)) {
                return;
            }
            if (gf4.hasCustomNameTag()) {
                outstring = gf4.getCustomNameTag();
            }
            if (outstring == null || outstring.equals("")) {
                outstring = "The Toddler Princess";
            }
            gfHealth = gf4.getHealth() / gf4.getMaxHealth();
        }
        if (entity instanceof ThePrinceTeen) {
            ThePrinceTeen gf5 = null;
            gf5 = (ThePrinceTeen) entity;
            if (!gf5.func_152114_e(player)) {
                return;
            }
            if (gf5.hasCustomNameTag()) {
                outstring = gf5.getCustomNameTag();
            }
            if (outstring == null || outstring.equals("")) {
                outstring = "The Young Prince";
            }
            if (gf5.getActivity() != 0) {
                return;
            }
            gfHealth = gf5.getHealth() / gf5.getMaxHealth();
        }
        if (entity instanceof ThePrinceAdult) {
            ThePrinceAdult gf6 = null;
            gf6 = (ThePrinceAdult) entity;
            if (!gf6.func_152114_e(player)) {
                return;
            }
            if (gf6.hasCustomNameTag()) {
                outstring = gf6.getCustomNameTag();
            }
            if (outstring == null || outstring.equals("")) {
                outstring = "The Young Adult Prince";
            }
            if (gf6.getActivity() != 0) {
                return;
            }
            gfHealth = gf6.getHealth() / gf6.getMaxHealth();
        }
        if (entity instanceof Dragon) {
            Dragon df = null;
            df = (Dragon) entity;
            if (df.hasCustomNameTag()) {
                outstring = df.getCustomNameTag();
            }
            if (outstring == null || outstring.equals("")) {
                outstring = "Dragon";
            }
            if (df.getActivity() != 0) {
                return;
            }
            gfHealth = df.getDragonHealth() / df.getMaxHealth();
        }
        if (entity instanceof EmperorScorpion) {
            final EmperorScorpion e = (EmperorScorpion) entity;
            outstring = "Emperor Scorpion";
            gfHealth = e.getEmperorScorpionHealth() / e.getMaxHealth();
        }
        if (entity instanceof Basilisk) {
            final Basilisk e2 = (Basilisk) entity;
            outstring = "Basilisk";
            gfHealth = e2.getBasiliskHealth() / e2.getMaxHealth();
        }
        if (entity instanceof Mothra) {
            final Mothra e3 = (Mothra) entity;
            outstring = "Mothra!";
            gfHealth = e3.getMothraHealth() / e3.getMaxHealth();
        }
        if (entity instanceof Spyro) {
            final Spyro e4 = (Spyro) entity;
            if (e4.hasCustomNameTag()) {
                outstring = e4.getCustomNameTag();
            }
            if (outstring == null || outstring.equals("")) {
                outstring = "Baby Dragon";
            }
            gfHealth = e4.getSpyroHealth() / e4.getMaxHealth();
        }
        if (entity instanceof WormLarge) {
            final WormLarge e5 = (WormLarge) entity;
            if (!e5.noClip) {
                outstring = "Worm";
                gfHealth = e5.getHealth() / e5.getMaxHealth();
            }
        }
        if (entity instanceof Alien) {
            final Alien e6 = (Alien) entity;
            outstring = "Alien!";
            gfHealth = e6.getAlienHealth() / e6.getMaxHealth();
        }
        if (entity instanceof WaterDragon) {
            final WaterDragon e7 = (WaterDragon) entity;
            if (e7.hasCustomNameTag()) {
                outstring = e7.getCustomNameTag();
            }
            if (outstring == null || outstring.equals("")) {
                outstring = "WaterDragon";
            }
            gfHealth = e7.getWaterDragonHealth() / e7.getMaxHealth();
        }
        if (entity instanceof Kraken) {
            final Kraken e8 = (Kraken) entity;
            outstring = "Kraken";
            gfHealth = e8.getKrakenHealth() / e8.getMaxHealth();
        }
        if (entity instanceof Cephadrome) {
            final Cephadrome e9 = (Cephadrome) entity;
            outstring = "Cephadrome";
            gfHealth = e9.getCephadromeHealth() / e9.getMaxHealth();
            if (e9.getActivity() != 0) {
                return;
            }
        }
        if (entity instanceof TrooperBug) {
            final TrooperBug e10 = (TrooperBug) entity;
            outstring = "Jumpy Bug";
            gfHealth = e10.getTrooperBugHealth() / e10.getMaxHealth();
        }
        if (entity instanceof SpitBug) {
            final SpitBug e11 = (SpitBug) entity;
            outstring = "Spit Bug";
            gfHealth = e11.getHealth() / e11.getMaxHealth();
        }
        if (entity instanceof PitchBlack) {
            final PitchBlack e12 = (PitchBlack) entity;
            outstring = "Nightmare";
            gfHealth = e12.getHealth() / e12.getMaxHealth();
        }
        if (entity instanceof Alosaurus) {
            final Alosaurus e13 = (Alosaurus) entity;
            outstring = "Alosaurus";
            gfHealth = e13.getHealth() / e13.getMaxHealth();
        }
        if (entity instanceof Nastysaurus) {
            final Nastysaurus e14 = (Nastysaurus) entity;
            outstring = "Nastysaurus";
            gfHealth = e14.getHealth() / e14.getMaxHealth();
        }
        if (entity instanceof TRex) {
            final TRex e15 = (TRex) entity;
            outstring = "T. Rex";
            gfHealth = e15.getHealth() / e15.getMaxHealth();
        }
        if (entity instanceof Kyuubi) {
            final Kyuubi e16 = (Kyuubi) entity;
            outstring = "Kyuubi";
            gfHealth = e16.getHealth() / e16.getMaxHealth();
        }
        if (entity instanceof Robot2) {
            final Robot2 e17 = (Robot2) entity;
            outstring = "Robo-Pounder";
            gfHealth = e17.getHealth() / e17.getMaxHealth();
        }
        if (entity instanceof Robot4) {
            final Robot4 e18 = (Robot4) entity;
            outstring = "Robo-Warrior";
            gfHealth = e18.getRobot4Health() / e18.getMaxHealth();
        }
        if (entity instanceof Triffid) {
            final Triffid e19 = (Triffid) entity;
            outstring = "Triffid";
            gfHealth = e19.getHealth() / e19.getMaxHealth();
        }
        if (entity instanceof Godzilla) {
            final Godzilla e20 = (Godzilla) entity;
            outstring = "Mobzilla";
            gfHealth = e20.getHealth() / e20.getMaxHealth();
        }
        if (entity instanceof Vortex) {
            final Vortex e21 = (Vortex) entity;
            outstring = "Vortex";
            gfHealth = e21.getHealth() / e21.getMaxHealth();
        }
        if (entity instanceof Irukandji) {
            final Irukandji e22 = (Irukandji) entity;
            outstring = "Irukandji";
            gfHealth = e22.getHealth() / e22.getMaxHealth();
        }
        if (entity instanceof Mantis) {
            final Mantis e23 = (Mantis) entity;
            outstring = "Mantis";
            gfHealth = e23.getHealth() / e23.getMaxHealth();
        }
        if (entity instanceof HerculesBeetle) {
            final HerculesBeetle e24 = (HerculesBeetle) entity;
            outstring = "Hercules Beetle";
            gfHealth = e24.getHealth() / e24.getMaxHealth();
        }
        if (entity instanceof TheKing) {
            final TheKing e25 = (TheKing) entity;
            outstring = "The King";
            gfHealth = e25.getHealth() / e25.getMaxHealth();
        }
        if (entity instanceof TheQueen) {
            final TheQueen e26 = (TheQueen) entity;
            outstring = "The Queen";
            gfHealth = e26.getHealth() / e26.getMaxHealth();
        }
        if (entity instanceof SeaViper) {
            final SeaViper e27 = (SeaViper) entity;
            outstring = "Sea Viper";
            gfHealth = e27.getHealth() / e27.getMaxHealth();
        }
        if (entity instanceof SeaMonster) {
            final SeaMonster e28 = (SeaMonster) entity;
            outstring = "Sea Monster";
            gfHealth = e28.getHealth() / e28.getMaxHealth();
        }
        if (entity instanceof Molenoid) {
            final Molenoid e29 = (Molenoid) entity;
            outstring = "Molenoid";
            gfHealth = e29.getHealth() / e29.getMaxHealth();
        }
        if (entity instanceof CaterKiller) {
            final CaterKiller e30 = (CaterKiller) entity;
            outstring = "CaterKiller";
            gfHealth = e30.getHealth() / e30.getMaxHealth();
        }
        if (entity instanceof Leon) {
            final Leon e31 = (Leon) entity;
            if (e31.hasCustomNameTag()) {
                outstring = e31.getCustomNameTag();
            }
            if (outstring == null || outstring.equals("")) {
                outstring = "Leonopteryx";
            }
            gfHealth = e31.getHealth() / e31.getMaxHealth();
        }
        if (entity instanceof Hammerhead) {
            final Hammerhead e32 = (Hammerhead) entity;
            outstring = "Hammerhead";
            gfHealth = e32.getHealth() / e32.getMaxHealth();
        }
        if (entity instanceof BandP) {
            final BandP e33 = (BandP) entity;
            if (e33.getWhat() == 0) {
                outstring = "Banker";
            } else {
                outstring = "Politician";
            }
            gfHealth = e33.getHealth() / e33.getMaxHealth();
        }
        if (entity instanceof SpiderRobot) {
            final SpiderRobot e34 = (SpiderRobot) entity;
            outstring = "Giant Robot Spider";
            gfHealth = e34.getHealth() / e34.getMaxHealth();
        }
        if (entity instanceof GiantRobot) {
            final GiantRobot e35 = (GiantRobot) entity;
            outstring = "Jeffery";
            gfHealth = e35.getHealth() / e35.getMaxHealth();
        }
        if (entity instanceof AntRobot) {
            final AntRobot e36 = (AntRobot) entity;
            outstring = "Giant Robot Red Ant";
            gfHealth = e36.getHealth() / e36.getMaxHealth();
        }
        if (entity instanceof Crab) {
            final Crab e37 = (Crab) entity;
            final float myf = e37.getCrabScale();
            if (myf > 0.75f) {
                outstring = "Very Large Crab";
                gfHealth = e37.getHealth() / e37.getMaxHealth();
            }
        }
        if (outstring == null) {
            return;
        }
        final ScaledResolution res = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
        final int width = res.getScaledWidth();
        final int barWidthFilled = (int) (gfHealth * (barWidth + 1));
        final int x = width / 2 - barWidth / 2;
        int y = 25;
        if (player.isInsideOfMaterial(Material.water) || player.getTotalArmorValue() > 0) {
            y -= 10;
        }
        fr.drawStringWithShadow(outstring, width / 2 - fr.getStringWidth(outstring) / 2, y - 10, color);
        this.mc.renderEngine.bindTexture(GirlfriendOverlayGui.texture);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.drawTexturedModalRect(x, y, u, v, barWidth, barHeight);
        if (barWidthFilled > 0) {
            this.drawTexturedModalRect(x, y, u, v + barHeight, barWidthFilled, barHeight);
        }
    }

    static {
        texture = new ResourceLocation(Tags.MODID+":girlfriendgui.png");
    }
}
