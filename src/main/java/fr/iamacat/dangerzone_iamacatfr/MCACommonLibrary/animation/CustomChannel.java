
package fr.iamacat.dangerzone_iamacatfr.MCACommonLibrary.animation;

import java.util.HashMap;

import fr.iamacat.dangerzone_iamacatfr.MCAClientLibrary.MCAModelRenderer;
import fr.iamacat.dangerzone_iamacatfr.MCACommonLibrary.IMCAnimatedEntity;

public class CustomChannel extends Channel {

    public CustomChannel(final String _name) {
        super(_name);
        this.mode = 3;
    }

    protected void initializeAllFrames() {}

    public KeyFrame getPreviousRotationKeyFrameForBox(final String boxName, final float currentFrame) {
        return null;
    }

    public KeyFrame getNextRotationKeyFrameForBox(final String boxName, final float currentFrame) {
        return null;
    }

    public KeyFrame getPreviousTranslationKeyFrameForBox(final String boxName, final float currentFrame) {
        return null;
    }

    public KeyFrame getNextTranslationKeyFrameForBox(final String boxName, final float currentFrame) {
        return null;
    }

    public int getKeyFramePosition(final KeyFrame keyFrame) {
        return -1;
    }

    public void update(final HashMap<String, MCAModelRenderer> parts, final IMCAnimatedEntity entity) {}
}
