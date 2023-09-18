
package fr.iamacat.dangerzone_iamacatfr.network;

public class MovementInputProxy {

    public float moveStrafe;
    public float moveForward;
    public boolean jump;
    public boolean sneak;

    public MovementInputProxy() {
        this.moveStrafe = 0.0f;
        this.moveForward = 0.0f;
        this.jump = false;
        this.sneak = false;
    }
}
