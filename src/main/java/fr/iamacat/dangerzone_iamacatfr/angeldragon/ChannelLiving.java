
package fr.iamacat.dangerzone_iamacatfr.angeldragon;

import fr.iamacat.dangerzone_iamacatfr.MCACommonLibrary.animation.Channel;
import fr.iamacat.dangerzone_iamacatfr.MCACommonLibrary.animation.KeyFrame;
import fr.iamacat.dangerzone_iamacatfr.MCACommonLibrary.math.Quaternion;
import fr.iamacat.dangerzone_iamacatfr.MCACommonLibrary.math.Vector3f;

public class ChannelLiving extends Channel {

    public ChannelLiving(final String _name, final float _fps, final int _totalFrames, final byte _mode) {
        super(_name, _fps, _totalFrames, _mode);
    }

    @Override
    protected void initializeAllFrames() {
        final KeyFrame frame0 = new KeyFrame();
        frame0.modelRenderersRotations
            .put("lear1", new Quaternion(3.8064612E-4f, 0.00871823f, 0.043617725f, 0.9990102f));
        frame0.modelRenderersRotations.put("rear2", new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
        frame0.modelRenderersRotations
            .put("lwing1", new Quaternion(-0.15642852f, -0.008619097f, -0.001365131f, 0.98765075f));
        frame0.modelRenderersRotations.put("neck4", new Quaternion(-0.02617695f, 0.0f, 0.0f, 0.99965733f));
        frame0.modelRenderersRotations.put("lhorn2", new Quaternion(0.12186935f, 0.0f, 0.0f, 0.99254614f));
        frame0.modelRenderersRotations.put("tail2", new Quaternion(-0.0784591f, 0.0f, 0.0f, 0.9969173f));
        frame0.modelRenderersRotations.put("neck2", new Quaternion(-0.25881904f, 0.0f, 0.0f, 0.9659258f));
        frame0.modelRenderersRotations.put("tail6", new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
        frame0.modelRenderersRotations.put("neck1", new Quaternion(-0.32556814f, 0.0f, 0.0f, 0.94551855f));
        frame0.modelRenderersRotations
            .put("rear1", new Quaternion(-3.8064612E-4f, 0.00871823f, -0.043617725f, 0.9990102f));
        frame0.modelRenderersRotations.put("nose", new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
        frame0.modelRenderersRotations.put("body2", new Quaternion(-0.08715574f, 0.0f, 0.0f, 0.9961947f));
        frame0.modelRenderersRotations.put("tail4", new Quaternion(0.043619387f, 0.0f, 0.0f, 0.99904823f));
        frame0.modelRenderersRotations.put("lhorn1", new Quaternion(0.15643448f, 0.0f, 0.0f, 0.98768836f));
        frame0.modelRenderersRotations.put("lwing2", new Quaternion(0.08715574f, 0.0f, 0.0f, 0.9961947f));
        frame0.modelRenderersRotations.put("rhorn1", new Quaternion(0.15643448f, 0.0f, 0.0f, 0.98768836f));
        frame0.modelRenderersRotations.put("lear3", new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
        frame0.modelRenderersRotations.put("tail3", new Quaternion(0.06104854f, 0.0f, 0.0f, 0.9981348f));
        frame0.modelRenderersRotations.put("rwing1", new Quaternion(-0.15643448f, 0.0f, 0.0f, 0.98768836f));
        frame0.modelRenderersRotations.put("bodymain", new Quaternion(0.08715574f, 0.0f, 0.0f, 0.9961947f));
        frame0.modelRenderersRotations.put("tail1", new Quaternion(-0.11320321f, 0.0f, 0.0f, 0.9935719f));
        frame0.modelRenderersRotations.put("lear2", new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
        frame0.modelRenderersRotations.put("rhorn2", new Quaternion(0.12186935f, 0.0f, 0.0f, 0.99254614f));
        frame0.modelRenderersRotations.put("lwing3", new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
        frame0.modelRenderersRotations.put("head", new Quaternion(-0.12186935f, 0.0f, 0.0f, 0.99254614f));
        frame0.modelRenderersRotations.put("rwing3", new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
        frame0.modelRenderersRotations.put("neck3", new Quaternion(-0.09584575f, 0.0f, 0.0f, 0.9953962f));
        frame0.modelRenderersRotations.put("rwing2", new Quaternion(0.08715574f, 0.0f, 0.0f, 0.9961947f));
        frame0.modelRenderersRotations.put("tail5", new Quaternion(0.0784591f, 0.0f, 0.0f, 0.9969173f));
        frame0.modelRenderersRotations.put("rear3", new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
        frame0.modelRenderersRotations.put("jaw", new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
        frame0.modelRenderersRotations.put("tailfin", new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
        frame0.modelRenderersTranslations.put("lear1", new Vector3f(0.0f, 0.0f, 0.0f));
        frame0.modelRenderersTranslations.put("rear2", new Vector3f(0.0f, 0.0f, 0.0f));
        frame0.modelRenderersTranslations.put("lwing1", new Vector3f(2.0f, 6.0f, 8.0f));
        frame0.modelRenderersTranslations.put("neck4", new Vector3f(0.0f, -0.5f, 4.0f));
        frame0.modelRenderersTranslations.put("lhorn2", new Vector3f(0.0f, 0.0f, 0.0f));
        frame0.modelRenderersTranslations.put("tail2", new Vector3f(0.0f, 1.0f, -2.0f));
        frame0.modelRenderersTranslations.put("neck2", new Vector3f(0.0f, 0.0f, 3.0f));
        frame0.modelRenderersTranslations.put("tail6", new Vector3f(0.0f, 1.0f, -5.0f));
        frame0.modelRenderersTranslations.put("neck1", new Vector3f(0.0f, 2.0f, 9.0f));
        frame0.modelRenderersTranslations.put("rear1", new Vector3f(0.0f, 0.0f, 0.0f));
        frame0.modelRenderersTranslations.put("nose", new Vector3f(0.0f, 0.0f, 0.0f));
        frame0.modelRenderersTranslations.put("body2", new Vector3f(0.0f, 0.0f, 2.0f));
        frame0.modelRenderersTranslations.put("tail4", new Vector3f(0.0f, 0.0f, -5.0f));
        frame0.modelRenderersTranslations.put("lhorn1", new Vector3f(0.0f, 0.0f, 0.0f));
        frame0.modelRenderersTranslations.put("lwing2", new Vector3f(0.0f, 0.0f, 0.0f));
        frame0.modelRenderersTranslations.put("rhorn1", new Vector3f(0.0f, 0.0f, 0.0f));
        frame0.modelRenderersTranslations.put("lear3", new Vector3f(0.0f, 0.0f, 0.0f));
        frame0.modelRenderersTranslations.put("tail3", new Vector3f(0.0f, -1.0f, -10.0f));
        frame0.modelRenderersTranslations.put("rwing1", new Vector3f(-2.0f, 6.0f, 8.0f));
        frame0.modelRenderersTranslations.put("bodymain", new Vector3f(0.0f, -17.0f, 0.0f));
        frame0.modelRenderersTranslations.put("tail1", new Vector3f(0.0f, 1.5f, -5.0f));
        frame0.modelRenderersTranslations.put("lear2", new Vector3f(0.0f, 0.0f, 0.0f));
        frame0.modelRenderersTranslations.put("rhorn2", new Vector3f(0.0f, 0.0f, 0.0f));
        frame0.modelRenderersTranslations.put("lwing3", new Vector3f(0.0f, -1.0f, 0.0f));
        frame0.modelRenderersTranslations.put("head", new Vector3f(0.0f, 2.0f, 3.0f));
        frame0.modelRenderersTranslations.put("rwing3", new Vector3f(0.0f, -1.0f, 0.0f));
        frame0.modelRenderersTranslations.put("neck3", new Vector3f(0.0f, -0.5f, 3.0f));
        frame0.modelRenderersTranslations.put("rwing2", new Vector3f(-1.0f, 0.0f, 0.0f));
        frame0.modelRenderersTranslations.put("tail5", new Vector3f(0.0f, 0.0f, -5.0f));
        frame0.modelRenderersTranslations.put("rear3", new Vector3f(0.0f, 0.0f, 0.0f));
        frame0.modelRenderersTranslations.put("jaw", new Vector3f(0.0f, 0.0f, 0.0f));
        frame0.modelRenderersTranslations.put("tailfin", new Vector3f(0.0f, 0.0f, -3.0f));
        this.keyFrames.put(0, frame0);
        final KeyFrame frame2 = new KeyFrame();
        frame2.modelRenderersRotations
            .put("lear1", new Quaternion(3.8064612E-4f, 0.00871823f, 0.043617725f, 0.9990102f));
        frame2.modelRenderersRotations.put("rear2", new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
        frame2.modelRenderersRotations
            .put("lwing1", new Quaternion(-0.15634733f, -0.00725369f, -0.009983848f, 0.98762506f));
        frame2.modelRenderersRotations.put("neck4", new Quaternion(-0.034899496f, 0.0f, 0.0f, 0.99939084f));
        frame2.modelRenderersRotations.put("lhorn2", new Quaternion(0.12186935f, 0.0f, 0.0f, 0.99254614f));
        frame2.modelRenderersRotations
            .put("tail2", new Quaternion(-0.07845611f, 0.008699634f, 6.846761E-4f, 0.99687934f));
        frame2.modelRenderersRotations.put("neck2", new Quaternion(-0.26723838f, 0.0f, 0.0f, 0.96363044f));
        frame2.modelRenderersRotations.put("tail6", new Quaternion(0.0f, 0.008726535f, 0.0f, 0.9999619f));
        frame2.modelRenderersRotations.put("neck1", new Quaternion(-0.33380687f, 0.0f, 0.0f, 0.9426415f));
        frame2.modelRenderersRotations
            .put("rear1", new Quaternion(-3.8064612E-4f, 0.00871823f, -0.043617725f, 0.9990102f));
        frame2.modelRenderersRotations.put("nose", new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
        frame2.modelRenderersRotations.put("body2", new Quaternion(-0.08715574f, 0.0f, 0.0f, 0.9961947f));
        frame2.modelRenderersRotations
            .put("tail4", new Quaternion(0.043617725f, 0.00871823f, -3.8064612E-4f, 0.9990102f));
        frame2.modelRenderersRotations.put("lhorn1", new Quaternion(0.15643448f, 0.0f, 0.0f, 0.98768836f));
        frame2.modelRenderersRotations.put("lwing2", new Quaternion(0.08715574f, 0.0f, 0.0f, 0.9961947f));
        frame2.modelRenderersRotations.put("rhorn1", new Quaternion(0.15643448f, 0.0f, 0.0f, 0.98768836f));
        frame2.modelRenderersRotations.put("lear3", new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
        frame2.modelRenderersRotations
            .put("tail3", new Quaternion(0.061046217f, 0.008710259f, -5.3274224E-4f, 0.99809676f));
        frame2.modelRenderersRotations
            .put("rwing1", new Quaternion(-0.15642852f, -0.001365131f, 0.008619097f, 0.98765075f));
        frame2.modelRenderersRotations.put("bodymain", new Quaternion(0.08715574f, 0.0f, 0.0f, 0.9961947f));
        frame2.modelRenderersRotations.put("tail1", new Quaternion(-0.1131989f, 0.00867044f, 9.878718E-4f, 0.993534f));
        frame2.modelRenderersRotations.put("lear2", new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
        frame2.modelRenderersRotations.put("rhorn2", new Quaternion(0.12186935f, 0.0f, 0.0f, 0.99254614f));
        frame2.modelRenderersRotations.put("lwing3", new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
        frame2.modelRenderersRotations.put("head", new Quaternion(-0.06975647f, 0.0f, 0.0f, 0.9975641f));
        frame2.modelRenderersRotations.put("rwing3", new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
        frame2.modelRenderersRotations.put("neck3", new Quaternion(-0.104528464f, 0.0f, 0.0f, 0.9945219f));
        frame2.modelRenderersRotations.put("rwing2", new Quaternion(0.08715574f, 0.0f, 0.0f, 0.9961947f));
        frame2.modelRenderersRotations
            .put("tail5", new Quaternion(0.07845611f, 0.008699634f, -6.846761E-4f, 0.99687934f));
        frame2.modelRenderersRotations.put("rear3", new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
        frame2.modelRenderersRotations.put("jaw", new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
        frame2.modelRenderersRotations.put("tailfin", new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
        frame2.modelRenderersTranslations.put("lear1", new Vector3f(0.0f, 0.0f, 0.0f));
        frame2.modelRenderersTranslations.put("rear2", new Vector3f(0.0f, 0.0f, 0.0f));
        frame2.modelRenderersTranslations.put("lwing1", new Vector3f(2.0f, 6.0f, 8.0f));
        frame2.modelRenderersTranslations.put("neck4", new Vector3f(0.0f, -0.5f, 4.0f));
        frame2.modelRenderersTranslations.put("lhorn2", new Vector3f(0.0f, 0.0f, 0.0f));
        frame2.modelRenderersTranslations.put("tail2", new Vector3f(0.0f, 1.0f, -2.0f));
        frame2.modelRenderersTranslations.put("neck2", new Vector3f(0.0f, 0.0f, 3.0f));
        frame2.modelRenderersTranslations.put("tail6", new Vector3f(0.0f, 1.0f, -5.0f));
        frame2.modelRenderersTranslations.put("neck1", new Vector3f(0.0f, 2.0f, 9.0f));
        frame2.modelRenderersTranslations.put("rear1", new Vector3f(0.0f, 0.0f, 0.0f));
        frame2.modelRenderersTranslations.put("nose", new Vector3f(0.0f, 0.0f, 0.0f));
        frame2.modelRenderersTranslations.put("body2", new Vector3f(0.0f, 0.0f, 2.0f));
        frame2.modelRenderersTranslations.put("tail4", new Vector3f(0.0f, 0.0f, -5.0f));
        frame2.modelRenderersTranslations.put("lhorn1", new Vector3f(0.0f, 0.0f, 0.0f));
        frame2.modelRenderersTranslations.put("lwing2", new Vector3f(0.0f, 0.0f, 0.0f));
        frame2.modelRenderersTranslations.put("rhorn1", new Vector3f(0.0f, 0.0f, 0.0f));
        frame2.modelRenderersTranslations.put("lear3", new Vector3f(0.0f, 0.0f, 0.0f));
        frame2.modelRenderersTranslations.put("tail3", new Vector3f(0.0f, -1.0f, -10.0f));
        frame2.modelRenderersTranslations.put("rwing1", new Vector3f(-2.0f, 6.0f, 8.0f));
        frame2.modelRenderersTranslations.put("bodymain", new Vector3f(0.0f, -17.0f, 0.0f));
        frame2.modelRenderersTranslations.put("tail1", new Vector3f(0.0f, 1.5f, -5.0f));
        frame2.modelRenderersTranslations.put("lear2", new Vector3f(0.0f, 0.0f, 0.0f));
        frame2.modelRenderersTranslations.put("rhorn2", new Vector3f(0.0f, 0.0f, 0.0f));
        frame2.modelRenderersTranslations.put("lwing3", new Vector3f(0.0f, -1.0f, 0.0f));
        frame2.modelRenderersTranslations.put("head", new Vector3f(0.0f, 2.0f, 3.0f));
        frame2.modelRenderersTranslations.put("rwing3", new Vector3f(0.0f, -1.0f, 0.0f));
        frame2.modelRenderersTranslations.put("neck3", new Vector3f(0.0f, -0.5f, 3.0f));
        frame2.modelRenderersTranslations.put("rwing2", new Vector3f(-1.0f, 0.0f, 0.0f));
        frame2.modelRenderersTranslations.put("tail5", new Vector3f(0.0f, 0.0f, -5.0f));
        frame2.modelRenderersTranslations.put("rear3", new Vector3f(0.0f, 0.0f, 0.0f));
        frame2.modelRenderersTranslations.put("jaw", new Vector3f(0.0f, 0.0f, 0.0f));
        frame2.modelRenderersTranslations.put("tailfin", new Vector3f(0.0f, 0.0f, -3.0f));
        this.keyFrames.put(1, frame2);
        final KeyFrame frame3 = new KeyFrame();
        frame3.modelRenderersRotations
            .put("lear1", new Quaternion(3.8064612E-4f, 0.00871823f, 0.043617725f, 0.9990102f));
        frame3.modelRenderersRotations.put("rear2", new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
        frame3.modelRenderersRotations
            .put("lwing1", new Quaternion(-0.15642852f, -0.008619097f, -0.001365131f, 0.98765075f));
        frame3.modelRenderersRotations.put("neck4", new Quaternion(-0.02617695f, 0.0f, 0.0f, 0.99965733f));
        frame3.modelRenderersRotations.put("lhorn2", new Quaternion(0.12186935f, 0.0f, 0.0f, 0.99254614f));
        frame3.modelRenderersRotations.put("tail2", new Quaternion(-0.0784591f, 0.0f, 0.0f, 0.9969173f));
        frame3.modelRenderersRotations.put("neck2", new Quaternion(-0.25881904f, 0.0f, 0.0f, 0.9659258f));
        frame3.modelRenderersRotations.put("tail6", new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
        frame3.modelRenderersRotations.put("neck1", new Quaternion(-0.33380687f, 0.0f, 0.0f, 0.9426415f));
        frame3.modelRenderersRotations
            .put("rear1", new Quaternion(-3.8064612E-4f, 0.00871823f, -0.043617725f, 0.9990102f));
        frame3.modelRenderersRotations.put("nose", new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
        frame3.modelRenderersRotations.put("body2", new Quaternion(-0.08715574f, 0.0f, 0.0f, 0.9961947f));
        frame3.modelRenderersRotations.put("tail4", new Quaternion(0.043619387f, 0.0f, 0.0f, 0.99904823f));
        frame3.modelRenderersRotations.put("lhorn1", new Quaternion(0.15643448f, 0.0f, 0.0f, 0.98768836f));
        frame3.modelRenderersRotations.put("lwing2", new Quaternion(0.08715574f, 0.0f, 0.0f, 0.9961947f));
        frame3.modelRenderersRotations.put("rhorn1", new Quaternion(0.15643448f, 0.0f, 0.0f, 0.98768836f));
        frame3.modelRenderersRotations.put("lear3", new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
        frame3.modelRenderersRotations.put("tail3", new Quaternion(0.06104854f, 0.0f, 0.0f, 0.9981348f));
        frame3.modelRenderersRotations.put("rwing1", new Quaternion(-0.15643448f, 0.0f, 0.0f, 0.98768836f));
        frame3.modelRenderersRotations.put("bodymain", new Quaternion(0.08715574f, 0.0f, 0.0f, 0.9961947f));
        frame3.modelRenderersRotations.put("tail1", new Quaternion(-0.11320321f, 0.0f, 0.0f, 0.9935719f));
        frame3.modelRenderersRotations.put("lear2", new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
        frame3.modelRenderersRotations.put("rhorn2", new Quaternion(0.12186935f, 0.0f, 0.0f, 0.99254614f));
        frame3.modelRenderersRotations.put("lwing3", new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
        frame3.modelRenderersRotations.put("head", new Quaternion(-0.12186935f, 0.0f, 0.0f, 0.99254614f));
        frame3.modelRenderersRotations.put("rwing3", new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
        frame3.modelRenderersRotations.put("neck3", new Quaternion(-0.09584575f, 0.0f, 0.0f, 0.9953962f));
        frame3.modelRenderersRotations.put("rwing2", new Quaternion(0.08715574f, 0.0f, 0.0f, 0.9961947f));
        frame3.modelRenderersRotations.put("tail5", new Quaternion(0.0784591f, 0.0f, 0.0f, 0.9969173f));
        frame3.modelRenderersRotations.put("rear3", new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
        frame3.modelRenderersRotations.put("jaw", new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
        frame3.modelRenderersRotations.put("tailfin", new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
        frame3.modelRenderersTranslations.put("lear1", new Vector3f(0.0f, 0.0f, 0.0f));
        frame3.modelRenderersTranslations.put("rear2", new Vector3f(0.0f, 0.0f, 0.0f));
        frame3.modelRenderersTranslations.put("lwing1", new Vector3f(2.0f, 6.0f, 8.0f));
        frame3.modelRenderersTranslations.put("neck4", new Vector3f(0.0f, -0.5f, 4.0f));
        frame3.modelRenderersTranslations.put("lhorn2", new Vector3f(0.0f, 0.0f, 0.0f));
        frame3.modelRenderersTranslations.put("tail2", new Vector3f(0.0f, 1.0f, -2.0f));
        frame3.modelRenderersTranslations.put("neck2", new Vector3f(0.0f, 0.0f, 3.0f));
        frame3.modelRenderersTranslations.put("tail6", new Vector3f(0.0f, 1.0f, -5.0f));
        frame3.modelRenderersTranslations.put("neck1", new Vector3f(0.0f, 2.0f, 9.0f));
        frame3.modelRenderersTranslations.put("rear1", new Vector3f(0.0f, 0.0f, 0.0f));
        frame3.modelRenderersTranslations.put("nose", new Vector3f(0.0f, 0.0f, 0.0f));
        frame3.modelRenderersTranslations.put("body2", new Vector3f(0.0f, 0.0f, 2.0f));
        frame3.modelRenderersTranslations.put("tail4", new Vector3f(0.0f, 0.0f, -5.0f));
        frame3.modelRenderersTranslations.put("lhorn1", new Vector3f(0.0f, 0.0f, 0.0f));
        frame3.modelRenderersTranslations.put("lwing2", new Vector3f(0.0f, 0.0f, 0.0f));
        frame3.modelRenderersTranslations.put("rhorn1", new Vector3f(0.0f, 0.0f, 0.0f));
        frame3.modelRenderersTranslations.put("lear3", new Vector3f(0.0f, 0.0f, 0.0f));
        frame3.modelRenderersTranslations.put("tail3", new Vector3f(0.0f, -1.0f, -10.0f));
        frame3.modelRenderersTranslations.put("rwing1", new Vector3f(-2.0f, 6.0f, 8.0f));
        frame3.modelRenderersTranslations.put("bodymain", new Vector3f(0.0f, -17.0f, 0.0f));
        frame3.modelRenderersTranslations.put("tail1", new Vector3f(0.0f, 1.5f, -5.0f));
        frame3.modelRenderersTranslations.put("lear2", new Vector3f(0.0f, 0.0f, 0.0f));
        frame3.modelRenderersTranslations.put("rhorn2", new Vector3f(0.0f, 0.0f, 0.0f));
        frame3.modelRenderersTranslations.put("lwing3", new Vector3f(0.0f, -1.0f, 0.0f));
        frame3.modelRenderersTranslations.put("head", new Vector3f(0.0f, 2.0f, 3.0f));
        frame3.modelRenderersTranslations.put("rwing3", new Vector3f(0.0f, -1.0f, 0.0f));
        frame3.modelRenderersTranslations.put("neck3", new Vector3f(0.0f, -0.5f, 3.0f));
        frame3.modelRenderersTranslations.put("rwing2", new Vector3f(-1.0f, 0.0f, 0.0f));
        frame3.modelRenderersTranslations.put("tail5", new Vector3f(0.0f, 0.0f, -5.0f));
        frame3.modelRenderersTranslations.put("rear3", new Vector3f(0.0f, 0.0f, 0.0f));
        frame3.modelRenderersTranslations.put("jaw", new Vector3f(0.0f, 0.0f, 0.0f));
        frame3.modelRenderersTranslations.put("tailfin", new Vector3f(0.0f, 0.0f, -3.0f));
        this.keyFrames.put(2, frame3);
        final KeyFrame frame4 = new KeyFrame();
        frame4.modelRenderersRotations
            .put("lear1", new Quaternion(3.8064612E-4f, 0.00871823f, 0.043617725f, 0.9990102f));
        frame4.modelRenderersRotations.put("rear2", new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
        frame4.modelRenderersRotations
            .put("lwing1", new Quaternion(-0.15634733f, -0.00725369f, -0.009983848f, 0.98762506f));
        frame4.modelRenderersRotations.put("lhorn2", new Quaternion(0.12186935f, 0.0f, 0.0f, 0.99254614f));
        frame4.modelRenderersRotations.put("neck4", new Quaternion(-0.02617695f, 0.0f, 0.0f, 0.99965733f));
        frame4.modelRenderersRotations
            .put("tail2", new Quaternion(-0.07845611f, -0.008699634f, -6.846761E-4f, 0.99687934f));
        frame4.modelRenderersRotations.put("neck2", new Quaternion(-0.25881904f, 0.0f, 0.0f, 0.9659258f));
        frame4.modelRenderersRotations.put("tail6", new Quaternion(0.0f, -0.008726535f, 0.0f, 0.9999619f));
        frame4.modelRenderersRotations.put("neck1", new Quaternion(-0.32556814f, 0.0f, 0.0f, 0.94551855f));
        frame4.modelRenderersRotations
            .put("rear1", new Quaternion(-3.8064612E-4f, 0.00871823f, -0.043617725f, 0.9990102f));
        frame4.modelRenderersRotations.put("nose", new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
        frame4.modelRenderersRotations.put("body2", new Quaternion(-0.08715574f, 0.0f, 0.0f, 0.9961947f));
        frame4.modelRenderersRotations
            .put("tail4", new Quaternion(0.043617725f, -0.00871823f, 3.8064612E-4f, 0.9990102f));
        frame4.modelRenderersRotations.put("lhorn1", new Quaternion(0.15643448f, 0.0f, 0.0f, 0.98768836f));
        frame4.modelRenderersRotations.put("lwing2", new Quaternion(0.08715574f, 0.0f, 0.0f, 0.9961947f));
        frame4.modelRenderersRotations.put("rhorn1", new Quaternion(0.15643448f, 0.0f, 0.0f, 0.98768836f));
        frame4.modelRenderersRotations.put("lear3", new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
        frame4.modelRenderersRotations
            .put("tail3", new Quaternion(0.061046217f, -0.008710259f, 5.3274224E-4f, 0.99809676f));
        frame4.modelRenderersRotations
            .put("rwing1", new Quaternion(-0.15642852f, 0.001365131f, -0.008619097f, 0.98765075f));
        frame4.modelRenderersRotations.put("bodymain", new Quaternion(0.08715574f, 0.0f, 0.0f, 0.9961947f));
        frame4.modelRenderersRotations
            .put("tail1", new Quaternion(-0.1131989f, -0.00867044f, -9.878718E-4f, 0.993534f));
        frame4.modelRenderersRotations.put("rhorn2", new Quaternion(0.12186935f, 0.0f, 0.0f, 0.99254614f));
        frame4.modelRenderersRotations.put("lear2", new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
        frame4.modelRenderersRotations.put("lwing3", new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
        frame4.modelRenderersRotations.put("head", new Quaternion(-0.12186935f, 0.0f, 0.0f, 0.99254614f));
        frame4.modelRenderersRotations.put("rwing3", new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
        frame4.modelRenderersRotations.put("neck3", new Quaternion(-0.09584575f, 0.0f, 0.0f, 0.9953962f));
        frame4.modelRenderersRotations.put("rwing2", new Quaternion(0.08715574f, 0.0f, 0.0f, 0.9961947f));
        frame4.modelRenderersRotations
            .put("tail5", new Quaternion(0.07845611f, -0.008699634f, 6.846761E-4f, 0.99687934f));
        frame4.modelRenderersRotations.put("jaw", new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
        frame4.modelRenderersRotations.put("rear3", new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
        frame4.modelRenderersRotations.put("tailfin", new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
        frame4.modelRenderersTranslations.put("lear1", new Vector3f(0.0f, 0.0f, 0.0f));
        frame4.modelRenderersTranslations.put("rear2", new Vector3f(0.0f, 0.0f, 0.0f));
        frame4.modelRenderersTranslations.put("lwing1", new Vector3f(2.0f, 6.0f, 8.0f));
        frame4.modelRenderersTranslations.put("lhorn2", new Vector3f(0.0f, 0.0f, 0.0f));
        frame4.modelRenderersTranslations.put("neck4", new Vector3f(0.0f, -0.5f, 4.0f));
        frame4.modelRenderersTranslations.put("tail2", new Vector3f(0.0f, 1.0f, -2.0f));
        frame4.modelRenderersTranslations.put("neck2", new Vector3f(0.0f, 0.0f, 3.0f));
        frame4.modelRenderersTranslations.put("tail6", new Vector3f(0.0f, 1.0f, -5.0f));
        frame4.modelRenderersTranslations.put("neck1", new Vector3f(0.0f, 2.0f, 9.0f));
        frame4.modelRenderersTranslations.put("rear1", new Vector3f(0.0f, 0.0f, 0.0f));
        frame4.modelRenderersTranslations.put("nose", new Vector3f(0.0f, 0.0f, 0.0f));
        frame4.modelRenderersTranslations.put("body2", new Vector3f(0.0f, 0.0f, 2.0f));
        frame4.modelRenderersTranslations.put("tail4", new Vector3f(0.0f, 0.0f, -5.0f));
        frame4.modelRenderersTranslations.put("lhorn1", new Vector3f(0.0f, 0.0f, 0.0f));
        frame4.modelRenderersTranslations.put("lwing2", new Vector3f(0.0f, 0.0f, 0.0f));
        frame4.modelRenderersTranslations.put("rhorn1", new Vector3f(0.0f, 0.0f, 0.0f));
        frame4.modelRenderersTranslations.put("lear3", new Vector3f(0.0f, 0.0f, 0.0f));
        frame4.modelRenderersTranslations.put("tail3", new Vector3f(0.0f, -1.0f, -10.0f));
        frame4.modelRenderersTranslations.put("rwing1", new Vector3f(-2.0f, 6.0f, 8.0f));
        frame4.modelRenderersTranslations.put("bodymain", new Vector3f(0.0f, -17.0f, 0.0f));
        frame4.modelRenderersTranslations.put("tail1", new Vector3f(0.0f, 1.5f, -5.0f));
        frame4.modelRenderersTranslations.put("rhorn2", new Vector3f(0.0f, 0.0f, 0.0f));
        frame4.modelRenderersTranslations.put("lear2", new Vector3f(0.0f, 0.0f, 0.0f));
        frame4.modelRenderersTranslations.put("lwing3", new Vector3f(0.0f, -1.0f, 0.0f));
        frame4.modelRenderersTranslations.put("head", new Vector3f(0.0f, 2.0f, 3.0f));
        frame4.modelRenderersTranslations.put("rwing3", new Vector3f(0.0f, -1.0f, 0.0f));
        frame4.modelRenderersTranslations.put("neck3", new Vector3f(0.0f, -0.5f, 3.0f));
        frame4.modelRenderersTranslations.put("rwing2", new Vector3f(-1.0f, 0.0f, 0.0f));
        frame4.modelRenderersTranslations.put("tail5", new Vector3f(0.0f, 0.0f, -5.0f));
        frame4.modelRenderersTranslations.put("jaw", new Vector3f(0.0f, 0.0f, 0.0f));
        frame4.modelRenderersTranslations.put("rear3", new Vector3f(0.0f, 0.0f, 0.0f));
        frame4.modelRenderersTranslations.put("tailfin", new Vector3f(0.0f, 0.0f, -3.0f));
        this.keyFrames.put(3, frame4);
    }
}