
package fr.iamacat.dangerzone_iamacatfr.api;

import net.minecraft.potion.Potion;

import com.google.common.base.Optional;

public enum PotionList {

    INSTANCE;

    public static Optional<? extends Potion> bubbling;
    public static Optional<? extends Potion> incendiary;
    public static Optional<? extends Potion> slowfall;
    public static Optional<? extends Potion> cleansing;
    public static Optional<? extends Potion> curse;
    public static Optional<? extends Potion> thorn;
    public static Optional<? extends Potion> heal2;
    public static Optional<? extends Potion> harm2;

    static {
        PotionList.bubbling = Optional.absent();
        PotionList.incendiary = Optional.absent();
        PotionList.slowfall = Optional.absent();
        PotionList.cleansing = Optional.absent();
        PotionList.curse = Optional.absent();
        PotionList.thorn = Optional.absent();
        PotionList.heal2 = Optional.absent();
        PotionList.harm2 = Optional.absent();
    }
}
