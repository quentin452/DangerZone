
package danger.orespawn.entities.renderer;

public class RenderGiantRobotInfo {

    public volatile float hipydisplayangle;
    public volatile float hipxdisplayangle;
    public volatile float[] thighdisplayangle;
    public volatile float[] shindisplayangle;
    public int gpcounter;

    public RenderGiantRobotInfo() {
        this.thighdisplayangle = new float[2];
        this.shindisplayangle = new float[2];
    }
}
