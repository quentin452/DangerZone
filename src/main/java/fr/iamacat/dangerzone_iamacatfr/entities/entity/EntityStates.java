
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

public enum EntityStates
{
    idle(0),
    looking(1),
    attacking(2),
    fleeing(7),
    following(6),
    inLove(8),
    sitting(9),
    stayStill(11),
    posture(5),
    inCover(10),
    isTempted(12),
    unknown(-1);

    public final int index;

    public int index() {
        return this.index;
    }

    private EntityStates(final int index) {
        this.index = index;
    }

    public static EntityStates getEntityByIndex(final int index) {
        for (final EntityStates entityState : values()) {
            if (entityState.index == index) {
                return entityState;
            }
        }
        return EntityStates.unknown;
    }
}
