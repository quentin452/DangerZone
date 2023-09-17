
package fr.iamacat.dangerzone_iamacatfr.angeldragon;

import fr.iamacat.dangerzone_iamacatfr.MCACommonLibrary.animation.Channel;
import fr.iamacat.dangerzone_iamacatfr.MCACommonLibrary.animation.KeyFrame;
import fr.iamacat.dangerzone_iamacatfr.MCACommonLibrary.math.Quaternion;
import fr.iamacat.dangerzone_iamacatfr.MCACommonLibrary.math.Vector3f;

public class ChannelLook extends Channel {

    public ChannelLook(final String _name, final float _fps, final int _totalFrames, final byte _mode) {
        super(_name, _fps, _totalFrames, _mode);
    }

    @Override
    protected void initializeAllFrames() {
        final KeyFrame frame0 = new KeyFrame();
        frame0.modelRenderersRotations.put("lpaw1", new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
        frame0.modelRenderersRotations.put("rleg21", new Quaternion(-0.08715574f, 0.0f, 0.0f, 0.9961947f));
        frame0.modelRenderersRotations.put("lleg21", new Quaternion(-0.08715574f, 0.0f, 0.0f, 0.9961947f));
        frame0.modelRenderersRotations.put("rpaw1", new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
        frame0.modelRenderersRotations.put("rleg2", new Quaternion(-0.09584575f, 0.0f, 0.0f, 0.9953962f));
        frame0.modelRenderersRotations.put("lleg2", new Quaternion(-0.09584575f, 0.0f, 0.0f, 0.9953962f));
        frame0.modelRenderersRotations.put("tail1", new Quaternion(-0.11320321f, 0.0f, 0.0f, 0.9935719f));
        frame0.modelRenderersRotations.put("body2", new Quaternion(-0.08715574f, 0.0f, 0.0f, 0.9961947f));
        frame0.modelRenderersRotations.put("head", new Quaternion(-0.12186935f, 0.0f, 0.0f, 0.99254614f));
        frame0.modelRenderersRotations.put("bodymain", new Quaternion(0.08715574f, 0.0f, 0.0f, 0.9961947f));
        frame0.modelRenderersRotations.put("lleg1", new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
        frame0.modelRenderersRotations.put("rleg1", new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
        frame0.modelRenderersTranslations.put("lpaw1", new Vector3f(0.0f, -6.0f, -2.0f));
        frame0.modelRenderersTranslations.put("rleg21", new Vector3f(-3.0f, 0.0f, -2.0f));
        frame0.modelRenderersTranslations.put("lleg21", new Vector3f(3.0f, 0.0f, -2.0f));
        frame0.modelRenderersTranslations.put("rpaw1", new Vector3f(0.0f, -6.0f, -2.0f));
        frame0.modelRenderersTranslations.put("rleg2", new Vector3f(-2.0f, -7.0f, 1.0f));
        frame0.modelRenderersTranslations.put("lleg2", new Vector3f(2.0f, -7.0f, 1.0f));
        frame0.modelRenderersTranslations.put("tail1", new Vector3f(0.0f, 1.5f, -5.0f));
        frame0.modelRenderersTranslations.put("body2", new Vector3f(0.0f, 0.0f, 2.0f));
        frame0.modelRenderersTranslations.put("head", new Vector3f(0.0f, 2.0f, 3.0f));
        frame0.modelRenderersTranslations.put("bodymain", new Vector3f(0.0f, -17.0f, 0.0f));
        frame0.modelRenderersTranslations.put("lleg1", new Vector3f(2.0f, 2.0f, 10.0f));
        frame0.modelRenderersTranslations.put("rleg1", new Vector3f(-2.0f, 2.0f, 10.0f));
        this.keyFrames.put(0, frame0);
        final KeyFrame frame2 = new KeyFrame();
        frame2.modelRenderersRotations.put("lpaw1", new Quaternion(0.3007058f, 0.0f, 0.0f, 0.95371693f));
        frame2.modelRenderersRotations.put("rleg21", new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
        frame2.modelRenderersRotations.put("lleg21", new Quaternion(0.017452406f, 0.0f, 0.0f, 0.9998477f));
        frame2.modelRenderersRotations.put("rpaw1", new Quaternion(0.3007058f, 0.0f, 0.0f, 0.95371693f));
        frame2.modelRenderersRotations.put("rleg2", new Quaternion(-0.0784591f, 0.0f, 0.0f, 0.9969173f));
        frame2.modelRenderersRotations.put("lleg2", new Quaternion(-0.0784591f, 0.0f, 0.0f, 0.9969173f));
        frame2.modelRenderersRotations.put("tail1", new Quaternion(-0.017452406f, 0.0f, 0.0f, 0.9998477f));
        frame2.modelRenderersRotations
            .put("body2", new Quaternion(0.034898166f, 0.008721219f, -3.0455168E-4f, 0.99935275f));
        frame2.modelRenderersRotations.put("head", new Quaternion(0.0784591f, 0.0f, 0.0f, 0.9969173f));
        frame2.modelRenderersRotations.put("bodymain", new Quaternion(-0.09584575f, 0.0f, 0.0f, 0.9953962f));
        frame2.modelRenderersRotations.put("lleg1", new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
        frame2.modelRenderersRotations.put("rleg1", new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
        frame2.modelRenderersTranslations.put("lpaw1", new Vector3f(0.0f, -6.0f, -2.0f));
        frame2.modelRenderersTranslations.put("rleg21", new Vector3f(-3.0f, 0.0f, -2.0f));
        frame2.modelRenderersTranslations.put("lleg21", new Vector3f(3.0f, 0.0f, -2.0f));
        frame2.modelRenderersTranslations.put("rpaw1", new Vector3f(0.0f, -6.0f, -2.0f));
        frame2.modelRenderersTranslations.put("rleg2", new Vector3f(-2.0f, -7.0f, 1.0f));
        frame2.modelRenderersTranslations.put("lleg2", new Vector3f(2.0f, -7.0f, 1.0f));
        frame2.modelRenderersTranslations.put("tail1", new Vector3f(0.0f, 1.5f, -5.0f));
        frame2.modelRenderersTranslations.put("body2", new Vector3f(0.0f, 0.0f, 2.0f));
        frame2.modelRenderersTranslations.put("head", new Vector3f(0.0f, 2.0f, 3.0f));
        frame2.modelRenderersTranslations.put("bodymain", new Vector3f(0.0f, -17.0f, 0.0f));
        frame2.modelRenderersTranslations.put("lleg1", new Vector3f(2.0f, 2.0f, 10.0f));
        frame2.modelRenderersTranslations.put("rleg1", new Vector3f(-2.0f, 2.0f, 10.0f));
        this.keyFrames.put(1, frame2);
        final KeyFrame frame3 = new KeyFrame();
        frame3.modelRenderersRotations.put("lpaw1", new Quaternion(0.9998477f, 0.0f, 0.0f, 0.017452383f));
        frame3.modelRenderersRotations.put("rleg21", new Quaternion(0.32556814f, 0.0f, 0.0f, 0.94551855f));
        frame3.modelRenderersRotations.put("lleg21", new Quaternion(0.32556814f, 0.0f, 0.0f, 0.94551855f));
        frame3.modelRenderersRotations.put("rpaw1", new Quaternion(0.9659258f, 0.0f, 0.0f, 0.25881907f));
        frame3.modelRenderersRotations.put("rleg2", new Quaternion(-0.0784591f, 0.0f, 0.0f, 0.9969173f));
        frame3.modelRenderersRotations.put("lleg2", new Quaternion(-0.656059f, 0.0f, 0.0f, 0.7547096f));
        frame3.modelRenderersRotations.put("tail1", new Quaternion(0.1650476f, 0.0f, 0.0f, 0.9862856f));
        frame3.modelRenderersRotations
            .put("body2", new Quaternion(-0.087152414f, 0.008693328f, 7.605676E-4f, 0.99615675f));
        frame3.modelRenderersRotations.put("head", new Quaternion(0.0784591f, 0.0f, 0.0f, 0.9969173f));
        frame3.modelRenderersRotations.put("bodymain", new Quaternion(-0.3007058f, 0.0f, 0.0f, 0.95371693f));
        frame3.modelRenderersRotations.put("lleg1", new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
        frame3.modelRenderersRotations.put("rleg1", new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
        frame3.modelRenderersRotations.put("neck4", new Quaternion(-0.02617695f, 0.0f, 0.0f, 0.99965733f));
        frame3.modelRenderersRotations.put("neck3", new Quaternion(0.05233596f, 0.0f, 0.0f, 0.9986295f));
        frame3.modelRenderersTranslations.put("lpaw1", new Vector3f(0.0f, -6.0f, 0.0f));
        frame3.modelRenderersTranslations.put("rleg21", new Vector3f(-3.0f, 0.0f, -2.0f));
        frame3.modelRenderersTranslations.put("lleg21", new Vector3f(3.0f, 0.0f, -2.0f));
        frame3.modelRenderersTranslations.put("rpaw1", new Vector3f(0.0f, -6.0f, 1.0f));
        frame3.modelRenderersTranslations.put("rleg2", new Vector3f(-2.0f, -7.0f, 1.0f));
        frame3.modelRenderersTranslations.put("lleg2", new Vector3f(2.0f, -7.0f, 1.0f));
        frame3.modelRenderersTranslations.put("tail1", new Vector3f(0.0f, 1.5f, -5.0f));
        frame3.modelRenderersTranslations.put("body2", new Vector3f(0.0f, 0.0f, 2.0f));
        frame3.modelRenderersTranslations.put("head", new Vector3f(0.0f, 2.0f, 3.0f));
        frame3.modelRenderersTranslations.put("bodymain", new Vector3f(0.0f, -17.0f, 0.0f));
        frame3.modelRenderersTranslations.put("lleg1", new Vector3f(2.0f, 2.0f, 10.0f));
        frame3.modelRenderersTranslations.put("rleg1", new Vector3f(-2.0f, 2.0f, 10.0f));
        frame3.modelRenderersTranslations.put("neck4", new Vector3f(0.0f, -0.5f, 4.0f));
        frame3.modelRenderersTranslations.put("neck3", new Vector3f(0.0f, -0.5f, 3.0f));
        this.keyFrames.put(2, frame3);
        final KeyFrame frame4 = new KeyFrame();
        frame4.modelRenderersRotations.put("lpaw1", new Quaternion(1.0f, 0.0f, 0.0f, -4.371139E-8f));
        frame4.modelRenderersRotations.put("lleg21", new Quaternion(0.49242356f, 0.0f, 0.0f, 0.87035567f));
        frame4.modelRenderersRotations.put("rleg21", new Quaternion(0.49242356f, 0.0f, 0.0f, 0.87035567f));
        frame4.modelRenderersRotations.put("rpaw1", new Quaternion(1.0f, 0.0f, 0.0f, -4.371139E-8f));
        frame4.modelRenderersRotations.put("rleg2", new Quaternion(-0.8526402f, 0.0f, 0.0f, 0.5224985f));
        frame4.modelRenderersRotations.put("tail1", new Quaternion(0.40673664f, 0.0f, 0.0f, 0.9135454f));
        frame4.modelRenderersRotations.put("lleg2", new Quaternion(-0.777146f, 0.0f, 0.0f, 0.6293204f));
        frame4.modelRenderersRotations.put("bodymain", new Quaternion(-0.49242356f, 0.0f, 0.0f, 0.87035567f));
        frame4.modelRenderersRotations.put("lleg1", new Quaternion(0.27563736f, 0.0f, 0.0f, 0.9612617f));
        frame4.modelRenderersRotations
            .put("rleg1", new Quaternion(0.24011865f, 0.029482864f, 0.118249305f, 0.9630633f));
        frame4.modelRenderersRotations.put("neck4", new Quaternion(0.1391731f, 0.0f, 0.0f, 0.99026805f));
        frame4.modelRenderersRotations.put("neck3", new Quaternion(0.25881904f, 0.0f, 0.0f, 0.9659258f));
        frame4.modelRenderersTranslations.put("lpaw1", new Vector3f(0.0f, -6.0f, 0.0f));
        frame4.modelRenderersTranslations.put("lleg21", new Vector3f(3.0f, 0.0f, -2.0f));
        frame4.modelRenderersTranslations.put("rleg21", new Vector3f(-3.0f, 0.0f, -2.0f));
        frame4.modelRenderersTranslations.put("rpaw1", new Vector3f(0.0f, -6.0f, 1.0f));
        frame4.modelRenderersTranslations.put("rleg2", new Vector3f(-2.0f, -7.0f, 1.0f));
        frame4.modelRenderersTranslations.put("tail1", new Vector3f(0.0f, 1.5f, -5.0f));
        frame4.modelRenderersTranslations.put("lleg2", new Vector3f(2.0f, -7.0f, 1.0f));
        frame4.modelRenderersTranslations.put("bodymain", new Vector3f(0.0f, -17.0f, 0.0f));
        frame4.modelRenderersTranslations.put("lleg1", new Vector3f(2.0f, 2.0f, 10.0f));
        frame4.modelRenderersTranslations.put("rleg1", new Vector3f(-2.0f, 2.0f, 10.0f));
        frame4.modelRenderersTranslations.put("neck4", new Vector3f(0.0f, -0.5f, 4.0f));
        frame4.modelRenderersTranslations.put("neck3", new Vector3f(0.0f, -0.5f, 3.0f));
        this.keyFrames.put(3, frame4);
        final KeyFrame frame5 = new KeyFrame();
        frame5.modelRenderersRotations.put("lpaw1", new Quaternion(1.0f, 0.0f, 0.0f, -4.371139E-8f));
        frame5.modelRenderersRotations.put("rleg21", new Quaternion(0.49242356f, 0.0f, 0.0f, 0.87035567f));
        frame5.modelRenderersRotations.put("lleg21", new Quaternion(0.49242356f, 0.0f, 0.0f, 0.87035567f));
        frame5.modelRenderersRotations.put("rpaw1", new Quaternion(1.0f, 0.0f, 0.0f, -4.371139E-8f));
        frame5.modelRenderersRotations.put("rleg2", new Quaternion(-0.8526402f, 0.0f, 0.0f, 0.5224985f));
        frame5.modelRenderersRotations.put("lleg2", new Quaternion(-0.777146f, 0.0f, 0.0f, 0.6293204f));
        frame5.modelRenderersRotations.put("tail1", new Quaternion(0.3776388f, 0.0f, 0.0f, 0.925953f));
        frame5.modelRenderersRotations.put("bodymain", new Quaternion(-0.49242356f, 0.0f, 0.0f, 0.87035567f));
        frame5.modelRenderersRotations.put("head", new Quaternion(0.08715574f, 0.0f, 0.0f, 0.9961947f));
        frame5.modelRenderersRotations.put("lleg1", new Quaternion(0.27563736f, 0.0f, 0.0f, 0.9612617f));
        frame5.modelRenderersRotations
            .put("rleg1", new Quaternion(0.24011865f, 0.029482864f, 0.118249305f, 0.9630633f));
        frame5.modelRenderersRotations.put("neck4", new Quaternion(0.1391731f, 0.0f, 0.0f, 0.99026805f));
        frame5.modelRenderersRotations.put("neck3", new Quaternion(0.25881904f, 0.0f, 0.0f, 0.9659258f));
        frame5.modelRenderersTranslations.put("lpaw1", new Vector3f(0.0f, -6.0f, 0.0f));
        frame5.modelRenderersTranslations.put("rleg21", new Vector3f(-3.0f, 0.0f, -2.0f));
        frame5.modelRenderersTranslations.put("lleg21", new Vector3f(3.0f, 0.0f, -2.0f));
        frame5.modelRenderersTranslations.put("rpaw1", new Vector3f(0.0f, -6.0f, 1.0f));
        frame5.modelRenderersTranslations.put("rleg2", new Vector3f(-2.0f, -7.0f, 1.0f));
        frame5.modelRenderersTranslations.put("lleg2", new Vector3f(2.0f, -7.0f, 1.0f));
        frame5.modelRenderersTranslations.put("tail1", new Vector3f(0.0f, 1.5f, -5.0f));
        frame5.modelRenderersTranslations.put("bodymain", new Vector3f(0.0f, -17.0f, 0.0f));
        frame5.modelRenderersTranslations.put("head", new Vector3f(0.0f, 2.0f, 3.0f));
        frame5.modelRenderersTranslations.put("lleg1", new Vector3f(2.0f, 2.0f, 10.0f));
        frame5.modelRenderersTranslations.put("rleg1", new Vector3f(-2.0f, 2.0f, 10.0f));
        frame5.modelRenderersTranslations.put("neck4", new Vector3f(0.0f, -0.5f, 4.0f));
        frame5.modelRenderersTranslations.put("neck3", new Vector3f(0.0f, -0.5f, 3.0f));
        this.keyFrames.put(4, frame5);
        final KeyFrame frame6 = new KeyFrame();
        frame6.modelRenderersRotations.put("lpaw1", new Quaternion(1.0f, 0.0f, 0.0f, -4.371139E-8f));
        frame6.modelRenderersRotations.put("rleg21", new Quaternion(0.49242356f, 0.0f, 0.0f, 0.87035567f));
        frame6.modelRenderersRotations.put("lleg21", new Quaternion(0.49242356f, 0.0f, 0.0f, 0.87035567f));
        frame6.modelRenderersRotations.put("rpaw1", new Quaternion(1.0f, 0.0f, 0.0f, -4.371139E-8f));
        frame6.modelRenderersRotations.put("rleg2", new Quaternion(-0.8526402f, 0.0f, 0.0f, 0.5224985f));
        frame6.modelRenderersRotations.put("lleg2", new Quaternion(-0.777146f, 0.0f, 0.0f, 0.6293204f));
        frame6.modelRenderersRotations.put("tail1", new Quaternion(0.38872197f, 0.0f, 0.0f, 0.9213551f));
        frame6.modelRenderersRotations.put("bodymain", new Quaternion(-0.49242356f, 0.0f, 0.0f, 0.87035567f));
        frame6.modelRenderersRotations.put("head", new Quaternion(0.0327948f, -0.01193633f, -0.34181178f, 0.9391202f));
        frame6.modelRenderersRotations.put("lleg1", new Quaternion(0.27563736f, 0.0f, 0.0f, 0.9612617f));
        frame6.modelRenderersRotations
            .put("rleg1", new Quaternion(0.24011865f, 0.029482864f, 0.118249305f, 0.9630633f));
        frame6.modelRenderersRotations.put("neck4", new Quaternion(0.1391731f, 0.0f, 0.0f, 0.99026805f));
        frame6.modelRenderersRotations.put("neck3", new Quaternion(0.25881904f, 0.0f, 0.0f, 0.9659258f));
        frame6.modelRenderersTranslations.put("lpaw1", new Vector3f(0.0f, -6.0f, 0.0f));
        frame6.modelRenderersTranslations.put("rleg21", new Vector3f(-3.0f, 0.0f, -2.0f));
        frame6.modelRenderersTranslations.put("lleg21", new Vector3f(3.0f, 0.0f, -2.0f));
        frame6.modelRenderersTranslations.put("rpaw1", new Vector3f(0.0f, -6.0f, 1.0f));
        frame6.modelRenderersTranslations.put("rleg2", new Vector3f(-2.0f, -7.0f, 1.0f));
        frame6.modelRenderersTranslations.put("lleg2", new Vector3f(2.0f, -7.0f, 1.0f));
        frame6.modelRenderersTranslations.put("tail1", new Vector3f(0.0f, 1.5f, -5.0f));
        frame6.modelRenderersTranslations.put("bodymain", new Vector3f(0.0f, -17.0f, 0.0f));
        frame6.modelRenderersTranslations.put("head", new Vector3f(0.0f, 2.0f, 3.0f));
        frame6.modelRenderersTranslations.put("lleg1", new Vector3f(2.0f, 2.0f, 10.0f));
        frame6.modelRenderersTranslations.put("rleg1", new Vector3f(-2.0f, 2.0f, 10.0f));
        frame6.modelRenderersTranslations.put("neck4", new Vector3f(0.0f, -0.5f, 4.0f));
        frame6.modelRenderersTranslations.put("neck3", new Vector3f(0.0f, -0.5f, 3.0f));
        this.keyFrames.put(5, frame6);
        final KeyFrame frame7 = new KeyFrame();
        frame7.modelRenderersRotations.put("lpaw1", new Quaternion(1.0f, 0.0f, 0.0f, -4.371139E-8f));
        frame7.modelRenderersRotations.put("rleg21", new Quaternion(0.49242356f, 0.0f, 0.0f, 0.87035567f));
        frame7.modelRenderersRotations.put("lleg21", new Quaternion(0.49242356f, 0.0f, 0.0f, 0.87035567f));
        frame7.modelRenderersRotations.put("rpaw1", new Quaternion(1.0f, 0.0f, 0.0f, -4.371139E-8f));
        frame7.modelRenderersRotations.put("rleg2", new Quaternion(-0.8526402f, 0.0f, 0.0f, 0.5224985f));
        frame7.modelRenderersRotations.put("lleg2", new Quaternion(-0.777146f, 0.0f, 0.0f, 0.6293204f));
        frame7.modelRenderersRotations.put("tail1", new Quaternion(0.40640178f, 0.0f, 0.0f, 0.9136945f));
        frame7.modelRenderersRotations.put("bodymain", new Quaternion(-0.49242356f, 0.0f, 0.0f, 0.87035567f));
        frame7.modelRenderersRotations
            .put("head", new Quaternion(0.07372744f, -0.02683459f, -0.34096578f, 0.93679583f));
        frame7.modelRenderersRotations.put("lleg1", new Quaternion(0.27563736f, 0.0f, 0.0f, 0.9612617f));
        frame7.modelRenderersRotations
            .put("rleg1", new Quaternion(0.24011865f, 0.029482864f, 0.118249305f, 0.9630633f));
        frame7.modelRenderersRotations.put("neck4", new Quaternion(0.11182797f, 0.0f, 0.0f, 0.99372756f));
        frame7.modelRenderersRotations.put("neck3", new Quaternion(0.25881904f, 0.0f, 0.0f, 0.9659258f));
        frame7.modelRenderersTranslations.put("lpaw1", new Vector3f(0.0f, -6.0f, 0.0f));
        frame7.modelRenderersTranslations.put("rleg21", new Vector3f(-3.0f, 0.0f, -2.0f));
        frame7.modelRenderersTranslations.put("lleg21", new Vector3f(3.0f, 0.0f, -2.0f));
        frame7.modelRenderersTranslations.put("rpaw1", new Vector3f(0.0f, -6.0f, 1.0f));
        frame7.modelRenderersTranslations.put("rleg2", new Vector3f(-2.0f, -7.0f, 1.0f));
        frame7.modelRenderersTranslations.put("lleg2", new Vector3f(2.0f, -7.0f, 1.0f));
        frame7.modelRenderersTranslations.put("tail1", new Vector3f(0.0f, 1.5f, -5.0f));
        frame7.modelRenderersTranslations.put("bodymain", new Vector3f(0.0f, -17.0f, 0.0f));
        frame7.modelRenderersTranslations.put("head", new Vector3f(0.0f, 2.0f, 3.0f));
        frame7.modelRenderersTranslations.put("lleg1", new Vector3f(2.0f, 2.0f, 10.0f));
        frame7.modelRenderersTranslations.put("rleg1", new Vector3f(-2.0f, 2.0f, 10.0f));
        frame7.modelRenderersTranslations.put("neck4", new Vector3f(0.0f, -0.5f, 4.0f));
        frame7.modelRenderersTranslations.put("neck3", new Vector3f(0.0f, -0.5f, 3.0f));
        this.keyFrames.put(6, frame7);
        final KeyFrame frame8 = new KeyFrame();
        frame8.modelRenderersRotations.put("lpaw1", new Quaternion(1.0f, 0.0f, 0.0f, -4.371139E-8f));
        frame8.modelRenderersRotations.put("rleg21", new Quaternion(0.49242356f, 0.0f, 0.0f, 0.87035567f));
        frame8.modelRenderersRotations.put("lleg21", new Quaternion(0.49242356f, 0.0f, 0.0f, 0.87035567f));
        frame8.modelRenderersRotations.put("rpaw1", new Quaternion(1.0f, 0.0f, 0.0f, -4.371139E-8f));
        frame8.modelRenderersRotations.put("rleg2", new Quaternion(-0.8526402f, 0.0f, 0.0f, 0.5224985f));
        frame8.modelRenderersRotations.put("lleg2", new Quaternion(-0.777146f, 0.0f, 0.0f, 0.6293204f));
        frame8.modelRenderersRotations.put("tail1", new Quaternion(0.4048703f, 0.0f, 0.0f, 0.9143741f));
        frame8.modelRenderersRotations
            .put("head", new Quaternion(0.07829233f, -0.0073290616f, 0.018082514f, 0.99673945f));
        frame8.modelRenderersRotations.put("lleg1", new Quaternion(0.27563736f, 0.0f, 0.0f, 0.9612617f));
        frame8.modelRenderersRotations
            .put("rleg1", new Quaternion(0.24011865f, 0.029482864f, 0.118249305f, 0.9630633f));
        frame8.modelRenderersRotations.put("neck4", new Quaternion(0.1391731f, 0.0f, 0.0f, 0.99026805f));
        frame8.modelRenderersRotations.put("neck3", new Quaternion(0.25881904f, 0.0f, 0.0f, 0.9659258f));
        frame8.modelRenderersTranslations.put("lpaw1", new Vector3f(0.0f, -6.0f, 0.0f));
        frame8.modelRenderersTranslations.put("rleg21", new Vector3f(-3.0f, 0.0f, -2.0f));
        frame8.modelRenderersTranslations.put("lleg21", new Vector3f(3.0f, 0.0f, -2.0f));
        frame8.modelRenderersTranslations.put("rpaw1", new Vector3f(0.0f, -6.0f, 1.0f));
        frame8.modelRenderersTranslations.put("rleg2", new Vector3f(-2.0f, -7.0f, 1.0f));
        frame8.modelRenderersTranslations.put("lleg2", new Vector3f(2.0f, -7.0f, 1.0f));
        frame8.modelRenderersTranslations.put("tail1", new Vector3f(0.0f, 1.5f, -5.0f));
        frame8.modelRenderersTranslations.put("head", new Vector3f(0.0f, 2.0f, 3.0f));
        frame8.modelRenderersTranslations.put("lleg1", new Vector3f(2.0f, 2.0f, 10.0f));
        frame8.modelRenderersTranslations.put("rleg1", new Vector3f(-2.0f, 2.0f, 10.0f));
        frame8.modelRenderersTranslations.put("neck4", new Vector3f(0.0f, -0.5f, 4.0f));
        frame8.modelRenderersTranslations.put("neck3", new Vector3f(0.0f, -0.5f, 3.0f));
        this.keyFrames.put(7, frame8);
        final KeyFrame frame9 = new KeyFrame();
        frame9.modelRenderersRotations.put("lpaw1", new Quaternion(1.0f, 0.0f, 0.0f, -4.371139E-8f));
        frame9.modelRenderersRotations.put("rleg21", new Quaternion(0.49242356f, 0.0f, 0.0f, 0.87035567f));
        frame9.modelRenderersRotations.put("lleg21", new Quaternion(0.49242356f, 0.0f, 0.0f, 0.87035567f));
        frame9.modelRenderersRotations.put("rpaw1", new Quaternion(1.0f, 0.0f, 0.0f, -4.371139E-8f));
        frame9.modelRenderersRotations.put("rleg2", new Quaternion(-0.8526402f, 0.0f, 0.0f, 0.5224985f));
        frame9.modelRenderersRotations.put("lleg2", new Quaternion(-0.777146f, 0.0f, 0.0f, 0.6293204f));
        frame9.modelRenderersRotations.put("tail1", new Quaternion(0.4048703f, 0.0f, 0.0f, 0.9143741f));
        frame9.modelRenderersRotations.put("bodymain", new Quaternion(-0.49242356f, 0.0f, 0.0f, 0.87035567f));
        frame9.modelRenderersRotations.put("head", new Quaternion(0.07074918f, 0.018658586f, 0.34159616f, 0.9369943f));
        frame9.modelRenderersRotations.put("lleg1", new Quaternion(0.27563736f, 0.0f, 0.0f, 0.9612617f));
        frame9.modelRenderersRotations
            .put("rleg1", new Quaternion(0.24011865f, 0.029482864f, 0.118249305f, 0.9630633f));
        frame9.modelRenderersRotations.put("neck4", new Quaternion(0.1391731f, 0.0f, 0.0f, 0.99026805f));
        frame9.modelRenderersRotations.put("neck3", new Quaternion(0.25881904f, 0.0f, 0.0f, 0.9659258f));
        frame9.modelRenderersTranslations.put("lpaw1", new Vector3f(0.0f, -6.0f, 0.0f));
        frame9.modelRenderersTranslations.put("rleg21", new Vector3f(-3.0f, 0.0f, -2.0f));
        frame9.modelRenderersTranslations.put("lleg21", new Vector3f(3.0f, 0.0f, -2.0f));
        frame9.modelRenderersTranslations.put("rpaw1", new Vector3f(0.0f, -6.0f, 1.0f));
        frame9.modelRenderersTranslations.put("rleg2", new Vector3f(-2.0f, -7.0f, 1.0f));
        frame9.modelRenderersTranslations.put("lleg2", new Vector3f(2.0f, -7.0f, 1.0f));
        frame9.modelRenderersTranslations.put("tail1", new Vector3f(0.0f, 1.5f, -5.0f));
        frame9.modelRenderersTranslations.put("bodymain", new Vector3f(0.0f, -17.0f, 0.0f));
        frame9.modelRenderersTranslations.put("head", new Vector3f(0.0f, 2.0f, 3.0f));
        frame9.modelRenderersTranslations.put("lleg1", new Vector3f(2.0f, 2.0f, 10.0f));
        frame9.modelRenderersTranslations.put("rleg1", new Vector3f(-2.0f, 2.0f, 10.0f));
        frame9.modelRenderersTranslations.put("neck4", new Vector3f(0.0f, -0.5f, 4.0f));
        frame9.modelRenderersTranslations.put("neck3", new Vector3f(0.0f, -0.5f, 3.0f));
        this.keyFrames.put(8, frame9);
        final KeyFrame frame10 = new KeyFrame();
        frame10.modelRenderersRotations.put("lpaw1", new Quaternion(0.51428986f, 0.0f, 0.0f, 0.8576164f));
        frame10.modelRenderersRotations.put("rleg21", new Quaternion(0.49242356f, 0.0f, 0.0f, 0.87035567f));
        frame10.modelRenderersRotations.put("lleg21", new Quaternion(0.49242356f, 0.0f, 0.0f, 0.87035567f));
        frame10.modelRenderersRotations.put("rpaw1", new Quaternion(0.54317445f, 0.0f, 0.0f, 0.8396199f));
        frame10.modelRenderersRotations.put("rleg2", new Quaternion(-0.5f, 0.0f, 0.0f, 0.8660254f));
        frame10.modelRenderersRotations.put("lleg2", new Quaternion(-0.3502074f, 0.0f, 0.0f, 0.9366722f));
        frame10.modelRenderersRotations.put("tail1", new Quaternion(0.4048703f, 0.0f, 0.0f, 0.9143741f));
        frame10.modelRenderersRotations.put("bodymain", new Quaternion(-0.49242356f, 0.0f, 0.0f, 0.87035567f));
        frame10.modelRenderersRotations.put("head", new Quaternion(0.07074918f, 0.018658586f, 0.34159616f, 0.9369943f));
        frame10.modelRenderersRotations.put("lleg1", new Quaternion(0.42261827f, 0.0f, 0.0f, 0.90630776f));
        frame10.modelRenderersRotations.put("rleg1", new Quaternion(0.42261827f, 0.0f, 0.0f, 0.90630776f));
        frame10.modelRenderersRotations.put("neck4", new Quaternion(0.1391731f, 0.0f, 0.0f, 0.99026805f));
        frame10.modelRenderersRotations.put("neck3", new Quaternion(0.25881904f, 0.0f, 0.0f, 0.9659258f));
        frame10.modelRenderersTranslations.put("lpaw1", new Vector3f(0.0f, -6.0f, -2.0f));
        frame10.modelRenderersTranslations.put("rleg21", new Vector3f(-3.0f, 0.0f, -2.0f));
        frame10.modelRenderersTranslations.put("lleg21", new Vector3f(3.0f, 0.0f, -2.0f));
        frame10.modelRenderersTranslations.put("rpaw1", new Vector3f(0.0f, -6.0f, 1.0f));
        frame10.modelRenderersTranslations.put("rleg2", new Vector3f(-2.0f, -7.0f, 1.0f));
        frame10.modelRenderersTranslations.put("lleg2", new Vector3f(2.0f, -7.0f, 1.0f));
        frame10.modelRenderersTranslations.put("tail1", new Vector3f(0.0f, 1.5f, -5.0f));
        frame10.modelRenderersTranslations.put("bodymain", new Vector3f(0.0f, -17.0f, 0.0f));
        frame10.modelRenderersTranslations.put("head", new Vector3f(0.0f, 2.0f, 3.0f));
        frame10.modelRenderersTranslations.put("lleg1", new Vector3f(2.0f, 2.0f, 10.0f));
        frame10.modelRenderersTranslations.put("rleg1", new Vector3f(-2.0f, 2.0f, 10.0f));
        frame10.modelRenderersTranslations.put("neck4", new Vector3f(0.0f, -0.5f, 4.0f));
        frame10.modelRenderersTranslations.put("neck3", new Vector3f(0.0f, -0.5f, 3.0f));
        this.keyFrames.put(9, frame10);
        final KeyFrame frame11 = new KeyFrame();
        frame11.modelRenderersRotations.put("lpaw1", new Quaternion(0.26681787f, 0.0f, 0.0f, 0.96374696f));
        frame11.modelRenderersRotations.put("rpaw1", new Quaternion(0.54317445f, 0.0f, 0.0f, 0.8396199f));
        frame11.modelRenderersRotations.put("rleg2", new Quaternion(-0.5f, 0.0f, 0.0f, 0.8660254f));
        frame11.modelRenderersRotations.put("lleg2", new Quaternion(-0.22495106f, 0.0f, 0.0f, 0.97437006f));
        frame11.modelRenderersRotations
            .put("head", new Quaternion(0.07845611f, -0.008699634f, 6.846761E-4f, 0.99687934f));
        frame11.modelRenderersRotations.put("lleg1", new Quaternion(0.26723838f, 0.0f, 0.0f, 0.96363044f));
        frame11.modelRenderersRotations.put("rleg1", new Quaternion(0.26723838f, 0.0f, 0.0f, 0.96363044f));
        frame11.modelRenderersTranslations.put("lpaw1", new Vector3f(0.0f, -6.0f, -2.0f));
        frame11.modelRenderersTranslations.put("rpaw1", new Vector3f(0.0f, -6.0f, -2.0f));
        frame11.modelRenderersTranslations.put("rleg2", new Vector3f(-2.0f, -7.0f, 1.0f));
        frame11.modelRenderersTranslations.put("lleg2", new Vector3f(2.0f, -7.0f, 1.0f));
        frame11.modelRenderersTranslations.put("head", new Vector3f(0.0f, 2.0f, 3.0f));
        frame11.modelRenderersTranslations.put("lleg1", new Vector3f(2.0f, 2.0f, 10.0f));
        frame11.modelRenderersTranslations.put("rleg1", new Vector3f(-2.0f, 2.0f, 10.0f));
        this.keyFrames.put(10, frame11);
        final KeyFrame frame12 = new KeyFrame();
        frame12.modelRenderersRotations.put("lleg21", new Quaternion(-0.08715574f, 0.0f, 0.0f, 0.9961947f));
        frame12.modelRenderersRotations.put("rleg21", new Quaternion(-0.08715574f, 0.0f, 0.0f, 0.9961947f));
        frame12.modelRenderersRotations.put("rpaw1", new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
        frame12.modelRenderersRotations.put("rleg2", new Quaternion(-0.09584575f, 0.0f, 0.0f, 0.9953962f));
        frame12.modelRenderersRotations.put("neck2", new Quaternion(-0.25881904f, 0.0f, 0.0f, 0.9659258f));
        frame12.modelRenderersRotations.put("bodymain", new Quaternion(0.08715574f, 0.0f, 0.0f, 0.9961947f));
        frame12.modelRenderersRotations.put("lleg1", new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
        frame12.modelRenderersRotations.put("rleg1", new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
        frame12.modelRenderersRotations.put("neck4", new Quaternion(-0.02617695f, 0.0f, 0.0f, 0.99965733f));
        frame12.modelRenderersRotations.put("lpaw1", new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
        frame12.modelRenderersRotations.put("neck1", new Quaternion(-0.32556814f, 0.0f, 0.0f, 0.94551855f));
        frame12.modelRenderersRotations.put("lleg2", new Quaternion(-0.09584575f, 0.0f, 0.0f, 0.9953962f));
        frame12.modelRenderersRotations.put("body2", new Quaternion(-0.08715574f, 0.0f, 0.0f, 0.9961947f));
        frame12.modelRenderersRotations.put("tail1", new Quaternion(-0.11320321f, 0.0f, 0.0f, 0.9935719f));
        frame12.modelRenderersRotations.put("head", new Quaternion(-0.12186935f, 0.0f, 0.0f, 0.99254614f));
        frame12.modelRenderersRotations.put("neck3", new Quaternion(-0.09584575f, 0.0f, 0.0f, 0.9953962f));
        frame12.modelRenderersTranslations.put("lleg21", new Vector3f(3.0f, 0.0f, -2.0f));
        frame12.modelRenderersTranslations.put("rleg21", new Vector3f(-3.0f, 0.0f, -2.0f));
        frame12.modelRenderersTranslations.put("rpaw1", new Vector3f(0.0f, -6.0f, -2.0f));
        frame12.modelRenderersTranslations.put("rleg2", new Vector3f(-2.0f, -7.0f, 1.0f));
        frame12.modelRenderersTranslations.put("neck2", new Vector3f(0.0f, 0.0f, 3.0f));
        frame12.modelRenderersTranslations.put("bodymain", new Vector3f(0.0f, -17.0f, 0.0f));
        frame12.modelRenderersTranslations.put("lleg1", new Vector3f(2.0f, 2.0f, 10.0f));
        frame12.modelRenderersTranslations.put("rleg1", new Vector3f(-2.0f, 2.0f, 10.0f));
        frame12.modelRenderersTranslations.put("neck4", new Vector3f(0.0f, -0.5f, 4.0f));
        frame12.modelRenderersTranslations.put("lpaw1", new Vector3f(0.0f, -6.0f, -2.0f));
        frame12.modelRenderersTranslations.put("neck1", new Vector3f(0.0f, 2.0f, 9.0f));
        frame12.modelRenderersTranslations.put("lleg2", new Vector3f(2.0f, -7.0f, 1.0f));
        frame12.modelRenderersTranslations.put("body2", new Vector3f(0.0f, 0.0f, 2.0f));
        frame12.modelRenderersTranslations.put("tail1", new Vector3f(0.0f, 1.5f, -5.0f));
        frame12.modelRenderersTranslations.put("head", new Vector3f(0.0f, 2.0f, 3.0f));
        frame12.modelRenderersTranslations.put("neck3", new Vector3f(0.0f, -0.5f, 3.0f));
        this.keyFrames.put(11, frame12);
    }
}
