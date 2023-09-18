
package fr.iamacat.dangerzone_iamacatfr.api;

import com.google.common.base.Optional;

import fr.iamacat.dangerzone_iamacatfr.items.SubItemPotion;

public enum SubItemPotionList {

    STRENGTH,
    REGENERATION,
    POISON,
    WEAKNESS,
    MOVE_SPEED,
    MOVE_SLOW,
    FIRE_RESISTANCE,
    NIGHT_VISION,
    BLINDNESS,
    HEAL,
    HARM,
    INVISIBILITY,
    BUBBLING,
    INCENDIARY,
    SLOWFALL,
    CLEANSING,
    THORNS,
    JUMP,
    DIG_SPEED,
    DIG_SLOW,
    RESISTANCE,
    WATER_BREATHING,
    CURSE;

    private Optional<SubItemPotion> subItem;

    private SubItemPotionList() {
        this.subItem = Optional.absent();
    }

    public boolean isPresent() {
        return this.subItem.isPresent();
    }

    public SubItemPotion get() {
        return (SubItemPotion) this.subItem.get();
    }

    public void set(final SubItemPotion potion) {
        this.subItem = Optional.of((SubItemPotion) potion);
    }

    public void clear() {
        this.subItem = Optional.absent();
    }
}
