
package fr.iamacat.dangerzone_iamacatfr.entities.render;

public class MinotaurInfoRenderer {

    public volatile float hipydisplayangle;
    public volatile float hipxdisplayangle;
    public volatile float[] thighdisplayangle;
    public volatile float[] shindisplayangle;
    public int gpcounter;

    public MinotaurInfoRenderer() {
        this.thighdisplayangle = new float[2];
        this.shindisplayangle = new float[2];
    }
}
