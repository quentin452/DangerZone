
package danger.orespawn.entities.renderer;

public class RenderSpiderRobotInfo {

    public volatile float[] ydisplayangle;
    public float[] ywantedangle;
    public float[] ycurrentangle;
    public float[] yvelocity;
    public float[] ymid;
    public float[] yoff;
    public volatile float[] yrange;
    public volatile float[] uddisplayangle;
    public float[] udwantedangle;
    public float[] udcurrentangle;
    public float[] udvelocity;
    public volatile double[] p1xangle;
    public volatile double[] p2xangle;
    public volatile double[] p3xangle;
    public float[] pxvelocity;
    public float[] foot_xpos;
    public float[] foot_ypos;
    public float[] foot_zpos;
    public float[] legoff;
    public float[] realposx;
    public float[] realposy;
    public float[] realposz;
    public int[] footup;
    public float[] uppoint;
    public int[] footingticker;
    public int[] pairedwith;
    public int gpcounter;

    public RenderSpiderRobotInfo() {
        this.ydisplayangle = new float[8];
        this.ywantedangle = new float[8];
        this.ycurrentangle = new float[8];
        this.yvelocity = new float[8];
        this.ymid = new float[8];
        this.yoff = new float[8];
        this.yrange = new float[8];
        this.uddisplayangle = new float[8];
        this.udwantedangle = new float[8];
        this.udcurrentangle = new float[8];
        this.udvelocity = new float[8];
        this.p1xangle = new double[8];
        this.p2xangle = new double[8];
        this.p3xangle = new double[8];
        this.pxvelocity = new float[8];
        this.foot_xpos = new float[8];
        this.foot_ypos = new float[8];
        this.foot_zpos = new float[8];
        this.legoff = new float[8];
        this.realposx = new float[8];
        this.realposy = new float[8];
        this.realposz = new float[8];
        this.footup = new int[8];
        this.uppoint = new float[8];
        this.footingticker = new int[8];
        this.pairedwith = new int[8];
    }
}
