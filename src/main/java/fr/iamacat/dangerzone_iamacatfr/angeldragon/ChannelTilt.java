
package fr.iamacat.dangerzone_iamacatfr.angeldragon;

import fr.iamacat.dangerzone_iamacatfr.util.libs.MCACommonLibrary.animation.Channel;
import fr.iamacat.dangerzone_iamacatfr.util.libs.MCACommonLibrary.animation.KeyFrame;
import fr.iamacat.dangerzone_iamacatfr.util.libs.MCACommonLibrary.math.Quaternion;
import fr.iamacat.dangerzone_iamacatfr.util.libs.MCACommonLibrary.math.Vector3f;

public class ChannelTilt extends Channel {

    public ChannelTilt(final String _name, final float _fps, final int _totalFrames, final byte _mode) {
        super(_name, _fps, _totalFrames, _mode);
    }

    @Override
    protected void initializeAllFrames() {
        final KeyFrame frame0 = new KeyFrame();
        frame0.modelRenderersRotations.put("head", new Quaternion(-0.12186935f, 0.0f, 0.0f, 0.99254614f));
        frame0.modelRenderersTranslations.put("head", new Vector3f(0.0f, 2.0f, 3.0f));
        this.keyFrames.put(0, frame0);
        final KeyFrame frame2 = new KeyFrame();
        frame2.modelRenderersRotations.put("head", new Quaternion(-0.12001788f, 0.17235383f, 0.02116239f, 0.9774671f));
        frame2.modelRenderersTranslations.put("head", new Vector3f(0.0f, 2.0f, 3.0f));
        this.keyFrames.put(1, frame2);
        final KeyFrame frame3 = new KeyFrame();
        frame3.modelRenderersRotations.put("head", new Quaternion(-0.12186935f, 0.0f, 0.0f, 0.99254614f));
        frame3.modelRenderersTranslations.put("head", new Vector3f(0.0f, 2.0f, 3.0f));
        this.keyFrames.put(2, frame3);
    }
}
