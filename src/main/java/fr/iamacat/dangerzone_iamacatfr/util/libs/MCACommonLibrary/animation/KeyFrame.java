
package fr.iamacat.dangerzone_iamacatfr.util.libs.MCACommonLibrary.animation;

import java.util.HashMap;

import fr.iamacat.dangerzone_iamacatfr.util.libs.MCACommonLibrary.math.Quaternion;
import fr.iamacat.dangerzone_iamacatfr.util.libs.MCACommonLibrary.math.Vector3f;

public class KeyFrame {

    public HashMap<String, Quaternion> modelRenderersRotations;
    public HashMap<String, Vector3f> modelRenderersTranslations;

    public KeyFrame() {
        this.modelRenderersRotations = new HashMap<String, Quaternion>();
        this.modelRenderersTranslations = new HashMap<String, Vector3f>();
    }

    public boolean useBoxInRotations(final String boxName) {
        return this.modelRenderersRotations.get(boxName) != null;
    }

    public boolean useBoxInTranslations(final String boxName) {
        return this.modelRenderersTranslations.get(boxName) != null;
    }
}
