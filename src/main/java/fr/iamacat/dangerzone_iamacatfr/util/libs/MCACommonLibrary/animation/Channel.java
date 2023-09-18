
package fr.iamacat.dangerzone_iamacatfr.util.libs.MCACommonLibrary.animation;

import java.util.HashMap;
import java.util.Map;

public class Channel {

    public static final byte LINEAR = 0;
    public static final byte LOOP = 1;
    public static final byte CYCLE = 2;
    public static final byte CUSTOM = 3;
    public String name;
    public float fps;
    public int totalFrames;
    public HashMap<Integer, KeyFrame> keyFrames;
    public byte mode;

    public Channel(final String _name) {
        this.keyFrames = new HashMap<Integer, KeyFrame>();
        this.mode = 0;
        this.name = _name;
        this.totalFrames = 0;
        this.initializeAllFrames();
    }

    public Channel(final String _name, final float _fps, final int _totalFrames, final byte _mode) {
        this(_name);
        this.fps = _fps;
        this.totalFrames = _totalFrames;
        this.mode = _mode;
    }

    protected void initializeAllFrames() {}

    public KeyFrame getPreviousRotationKeyFrameForBox(final String boxName, final float currentFrame) {
        int latestFramePosition = -1;
        KeyFrame latestKeyFrame = null;
        for (final Map.Entry<Integer, KeyFrame> entry : this.keyFrames.entrySet()) {
            final Integer key = entry.getKey();
            final KeyFrame value = entry.getValue();
            if (key <= currentFrame && key > latestFramePosition && value.useBoxInRotations(boxName)) {
                latestFramePosition = key;
                latestKeyFrame = value;
            }
        }
        return latestKeyFrame;
    }

    public KeyFrame getNextRotationKeyFrameForBox(final String boxName, final float currentFrame) {
        int nextFramePosition = -1;
        KeyFrame nextKeyFrame = null;
        for (final Map.Entry<Integer, KeyFrame> entry : this.keyFrames.entrySet()) {
            final Integer key = entry.getKey();
            final KeyFrame value = entry.getValue();
            if (key > currentFrame && (key < nextFramePosition || nextFramePosition == -1)
                && value.useBoxInRotations(boxName)) {
                nextFramePosition = key;
                nextKeyFrame = value;
            }
        }
        return nextKeyFrame;
    }

    public KeyFrame getPreviousTranslationKeyFrameForBox(final String boxName, final float currentFrame) {
        int latestFramePosition = -1;
        KeyFrame latestKeyFrame = null;
        for (final Map.Entry<Integer, KeyFrame> entry : this.keyFrames.entrySet()) {
            final Integer key = entry.getKey();
            final KeyFrame value = entry.getValue();
            if (key <= currentFrame && key > latestFramePosition && value.useBoxInTranslations(boxName)) {
                latestFramePosition = key;
                latestKeyFrame = value;
            }
        }
        return latestKeyFrame;
    }

    public KeyFrame getNextTranslationKeyFrameForBox(final String boxName, final float currentFrame) {
        int nextFramePosition = -1;
        KeyFrame nextKeyFrame = null;
        for (final Map.Entry<Integer, KeyFrame> entry : this.keyFrames.entrySet()) {
            final Integer key = entry.getKey();
            final KeyFrame value = entry.getValue();
            if (key > currentFrame && (key < nextFramePosition || nextFramePosition == -1)
                && value.useBoxInTranslations(boxName)) {
                nextFramePosition = key;
                nextKeyFrame = value;
            }
        }
        return nextKeyFrame;
    }

    public int getKeyFramePosition(final KeyFrame keyFrame) {
        if (keyFrame != null) {
            for (final Map.Entry<Integer, KeyFrame> entry : this.keyFrames.entrySet()) {
                final Integer key = entry.getKey();
                final KeyFrame keyframe = entry.getValue();
                if (keyframe == keyFrame) {
                    return key;
                }
            }
        }
        return -1;
    }

    public static boolean shouldAnimationStop() {
        return false;
    }
}
