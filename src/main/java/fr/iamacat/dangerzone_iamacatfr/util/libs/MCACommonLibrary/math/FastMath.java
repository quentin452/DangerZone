
package fr.iamacat.dangerzone_iamacatfr.util.libs.MCACommonLibrary.math;

public class FastMath {

    public static final double DBL_EPSILON = 2.220446049250313E-16;
    public static final float FLT_EPSILON = 1.1920929E-7f;
    public static final float ZERO_TOLERANCE = 1.0E-4f;
    public static final float PI = 3.1415927f;
    public static final float TWO_PI = 6.2831855f;
    public static final float HALF_PI = 1.5707964f;
    public static final float QUARTER_PI = 0.7853982f;

    public static float sqrt(final float fValue) {
        return (float) Math.sqrt(fValue);
    }

    public static float invSqrt(final float fValue) {
        return (float) (1.0 / Math.sqrt(fValue));
    }

    public static float abs(final float fValue) {
        if (fValue < 0.0f) {
            return -fValue;
        }
        return fValue;
    }

    public static float sin(final float v) {
        return (float) Math.sin(v);
    }

    public static float cos(final float v) {
        return (float) Math.cos(v);
    }

    public static float tan(final float fValue) {
        return (float) Math.tan(fValue);
    }

    public static float asin(final float fValue) {
        if (-1.0f >= fValue) {
            return -1.5707964f;
        }
        if (fValue < 1.0f) {
            return (float) Math.asin(fValue);
        }
        return 1.5707964f;
    }

    public static float acos(final float fValue) {
        if (-1.0f >= fValue) {
            return 3.1415927f;
        }
        if (fValue < 1.0f) {
            return (float) Math.acos(fValue);
        }
        return 0.0f;
    }

    public static float atan(final float fValue) {
        return (float) Math.atan(fValue);
    }

    public static float atan2(final float fY, final float fX) {
        return (float) Math.atan2(fY, fX);
    }

    public static float ceil(final float fValue) {
        return (float) Math.ceil(fValue);
    }

    public static float floor(final float fValue) {
        return (float) Math.floor(fValue);
    }
}
