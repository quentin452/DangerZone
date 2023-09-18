
package fr.iamacat.dangerzone_iamacatfr.angeldragon;

import fr.iamacat.dangerzone_iamacatfr.util.libs.MCACommonLibrary.animation.Channel;
import fr.iamacat.dangerzone_iamacatfr.util.libs.MCACommonLibrary.animation.KeyFrame;
import fr.iamacat.dangerzone_iamacatfr.util.libs.MCACommonLibrary.math.Quaternion;
import fr.iamacat.dangerzone_iamacatfr.util.libs.MCACommonLibrary.math.Vector3f;

public class ChannelSqueak extends Channel {

    public ChannelSqueak(final String _name, final float _fps, final int _totalFrames, final byte _mode) {
        super(_name, _fps, _totalFrames, _mode);
    }

    @Override
    protected void initializeAllFrames() {
        final KeyFrame frame0 = new KeyFrame();
        frame0.modelRenderersRotations.put("jaw", new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
        frame0.modelRenderersTranslations.put("jaw", new Vector3f(0.0f, 0.0f, 0.0f));
        this.keyFrames.put(0, frame0);
        final KeyFrame frame2 = new KeyFrame();
        frame2.modelRenderersRotations.put("jaw", new Quaternion(0.06975647f, 0.0f, 0.0f, 0.9975641f));
        frame2.modelRenderersTranslations.put("jaw", new Vector3f(0.0f, 0.0f, 0.0f));
        this.keyFrames.put(1, frame2);
        final KeyFrame frame3 = new KeyFrame();
        frame3.modelRenderersRotations.put("jaw", new Quaternion(0.0f, 0.0f, 0.0f, 1.0f));
        frame3.modelRenderersTranslations.put("jaw", new Vector3f(0.0f, 0.0f, 0.0f));
        this.keyFrames.put(2, frame3);
    }
}
