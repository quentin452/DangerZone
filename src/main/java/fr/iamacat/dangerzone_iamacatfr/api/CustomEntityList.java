

package fr.iamacat.dangerzone_iamacatfr.api;

import com.google.common.base.CharMatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Optional;

public enum CustomEntityList
{
    CREEPERBLOSSOMPRIMED,
    ARMADILLO,
    SANDWORM,
    LIZARD,
    MUMMYPHARAOH,
    MUMMY,
    VULTURE,
    TREEENT,
    MAMMOTH,
    FOX,
    BOAR,
    MIMIC,
    ALLIGATOR,
    FROG,
    PENGUIN,
    BEAVER,
    BLACKBEAR,
    BROWNBEAR,
    POLARBEAR,
    OSTRICH,
    RHINO,
    RABBIT,
    REDFINCH,
    BLUEFINCH,
    GREENFINCH,
    GORILLA,
    GIRAFFE,
    ELEPHANT,
    HORSE,
    EAGLE,
    HORNBILL,
    PELICAN,
    MINOTAUR,
    HAUNTEDARMOR,
    CENTIPEDE,
    HORSERANDOM,
    LIZARDSPIT,
    FOLLOWER,
    YELLOWFINCH,
    GOAT,
    DUCK,
    DUCKEGG,
    DEER,
    SKELETONN,
    FISHA,
    RIPPERFIN,
    OSTRICHEGG,
    GIANTRAT,
    FISHB,
    CROW,
    CAMEL,
    MONKEY,
    THROWINGROCK,
    RAVAGERANT,
    BEETLEAS,
    BEETLEBS,
    BLOOMDOOM,
    PZBAT,
    ZEBRA;

    public Optional<? extends CustomMobData> modData;
    private static final HashMap<String, CustomEntityList> lookupEnum;

    private CustomEntityList() {
        this.modData = Optional.empty();
    }

    public static CustomEntityList getByName(final String mobName) {
        if (mobName == null) {
            return null;
        }
        final String[] nameParts = CharMatcher.anyOf((CharSequence)" ").removeFrom((CharSequence)mobName).toLowerCase().split("\\.");
        CustomEntityList result;
        if (nameParts.length > 1) {
            result = CustomEntityList.lookupEnum.get(nameParts[nameParts.length - 1]);
        }
        else {
            result = CustomEntityList.lookupEnum.get(nameParts[0]);
        }
        if (result == null) {}
        return result;
    }

    public static CustomEntityList getByEntity(final Entity entity) {
        final String mobName = EntityList.getEntityString(entity);
        if (mobName != null) {
            return getByName(mobName);
        }
        return null;
    }

    static {
        lookupEnum = new HashMap<String, CustomEntityList>();
        for (final CustomEntityList entry : EnumSet.allOf(CustomEntityList.class)) {
            CustomEntityList.lookupEnum.put(entry.toString().toLowerCase(), entry);
        }
    }
}
