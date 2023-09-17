
package fr.iamacat.dangerzone_iamacatfr.MCACommonLibrary.math;

import java.io.Serializable;

public class Quaternion implements Serializable {

    public static final Quaternion EMPTY;
    static final double EPS = 1.0E-6;
    public float x;
    public float y;
    public float z;
    public float w;

    public Quaternion(final float x, final float y, final float z, final float w) {
        final float mag = (float) (1.0 / Math.sqrt(x * x + y * y + z * z + w * w));
        this.x = x * mag;
        this.y = y * mag;
        this.z = z * mag;
        this.w = w * mag;
    }

    public Quaternion() {
        this(0.0f, 0.0f, 0.0f, 1.0f);
    }

    public Quaternion(final Quaternion q1) {
        this.x = q1.x;
        this.y = q1.y;
        this.z = q1.z;
        this.w = q1.w;
    }

    public Quaternion(final Vector3f axis, final float angle) {
        final double s = Math.sin(angle / 2.0f);
        this.x = (float) (axis.x * s);
        this.y = (float) (axis.y * s);
        this.z = (float) (axis.z * s);
        this.w = (float) Math.cos(angle / 2.0f);
    }

    public Quaternion(final Matrix4f mat) {
        final double T = 1.0f + mat.m00 + mat.m11 + mat.m22;
        if (T > 1.0E-8) {
            final double S = Math.sqrt(T) * 2.0;
            this.x = (float) ((mat.m12 - mat.m21) / S);
            this.y = (float) ((mat.m02 - mat.m20) / S);
            this.z = (float) ((mat.m10 - mat.m01) / S);
            this.w = (float) (0.25 * S);
        } else if (T == 0.0) {
            if (mat.m00 > mat.m11 && mat.m00 > mat.m22) {
                final double S = Math.sqrt(1.0 + mat.m00 - mat.m11 - mat.m22) * 2.0;
                this.x = (float) (0.25 * S);
                this.y = (float) ((mat.m10 + mat.m01) / S);
                this.z = (float) ((mat.m02 + mat.m20) / S);
                this.w = (float) ((mat.m21 - mat.m12) / S);
            } else if (mat.m11 > mat.m22) {
                final double S = Math.sqrt(1.0 + mat.m11 - mat.m00 - mat.m22) * 2.0;
                this.x = (float) ((mat.m10 + mat.m01) / S);
                this.y = (float) (0.25 * S);
                this.z = (float) ((mat.m21 + mat.m12) / S);
                this.w = (float) ((mat.m02 - mat.m20) / S);
            } else {
                final double S = Math.sqrt(1.0 + mat.m22 - mat.m00 - mat.m11) * 2.0;
                this.x = (float) ((mat.m02 + mat.m20) / S);
                this.y = (float) ((mat.m21 + mat.m12) / S);
                this.z = (float) (0.25 * S);
                this.w = (float) ((mat.m10 - mat.m01) / S);
            }
        }
    }

    public Quaternion set(final Quaternion q) {
        this.x = q.x;
        this.y = q.y;
        this.z = q.z;
        this.w = q.w;
        return this;
    }

    public final void conjugate(final Quaternion q1) {
        this.x = -q1.x;
        this.y = -q1.y;
        this.z = -q1.z;
        this.w = q1.w;
    }

    public final void conjugate() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
    }

    public final void mul(final Quaternion q1) {
        this.mul(this, q1);
    }

    public final void mul(final Quaternion q1, final Quaternion q2) {
        if (this != q1 && this != q2) {
            this.w = q1.w * q2.w - q1.x * q2.x - q1.y * q2.y - q1.z * q2.z;
            this.x = q1.w * q2.x + q2.w * q1.x + q1.y * q2.z - q1.z * q2.y;
            this.y = q1.w * q2.y + q2.w * q1.y - q1.x * q2.z + q1.z * q2.x;
            this.z = q1.w * q2.z + q2.w * q1.z + q1.x * q2.y - q1.y * q2.x;
        } else {
            final float w = q1.w * q2.w - q1.x * q2.x - q1.y * q2.y - q1.z * q2.z;
            final float x = q1.w * q2.x + q2.w * q1.x + q1.y * q2.z - q1.z * q2.y;
            final float y = q1.w * q2.y + q2.w * q1.y - q1.x * q2.z + q1.z * q2.x;
            this.z = q1.w * q2.z + q2.w * q1.z + q1.x * q2.y - q1.y * q2.x;
            this.w = w;
            this.x = x;
            this.y = y;
        }
    }

    public final void mulInverse(final Quaternion q1, final Quaternion q2) {
        final Quaternion tempQuat = new Quaternion(q2);
        tempQuat.inverse();
        this.mul(q1, tempQuat);
    }

    public final void inverse(final Quaternion q1) {
        final float norm = 1.0f / (q1.w * q1.w + q1.x * q1.x + q1.y * q1.y + q1.z * q1.z);
        this.w = norm * q1.w;
        this.x = -norm * q1.x;
        this.y = -norm * q1.y;
        this.z = -norm * q1.z;
    }

    public final void inverse() {
        final float norm = 1.0f / (this.w * this.w + this.x * this.x + this.y * this.y + this.z * this.z);
        this.w *= norm;
        this.x *= -norm;
        this.y *= -norm;
        this.z *= -norm;
    }

    public final void normalize(final Quaternion q1) {
        float norm = q1.x * q1.x + q1.y * q1.y + q1.z * q1.z + q1.w * q1.w;
        if (norm > 0.0f) {
            norm = 1.0f / (float) Math.sqrt(norm);
            this.x = norm * q1.x;
            this.y = norm * q1.y;
            this.z = norm * q1.z;
            this.w = norm * q1.w;
        } else {
            this.x = 0.0f;
            this.y = 0.0f;
            this.z = 0.0f;
            this.w = 0.0f;
        }
    }

    public final void normalize() {
        float norm = this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w;
        if (norm > 0.0f) {
            norm = 1.0f / (float) Math.sqrt(norm);
            this.x *= norm;
            this.y *= norm;
            this.z *= norm;
            this.w *= norm;
        } else {
            this.x = 0.0f;
            this.y = 0.0f;
            this.z = 0.0f;
            this.w = 0.0f;
        }
    }

    public Quaternion add(final Quaternion q) {
        this.x += q.x;
        this.y += q.y;
        this.z += q.z;
        this.w += q.w;
        return this;
    }

    public Quaternion subtract(final Quaternion q) {
        this.x -= q.x;
        this.y -= q.y;
        this.z -= q.z;
        this.w -= q.w;
        return this;
    }

    public float dot(final Quaternion q) {
        return this.w * q.w + this.x * q.x + this.y * q.y + this.z * q.z;
    }

    public float norm() {
        return this.w * this.w + this.x * this.x + this.y * this.y + this.z * this.z;
    }

    public Quaternion normalizeLocal() {
        final float n = FastMath.invSqrt(this.norm());
        this.x *= n;
        this.y *= n;
        this.z *= n;
        this.w *= n;
        return this;
    }

    public Quaternion slerp(final Quaternion q1, final Quaternion q2, final float t) {
        if (q1.x == q2.x && q1.y == q2.y && q1.z == q2.z && q1.w == q2.w) {
            this.set(q1);
            return this;
        }
        float result = q1.x * q2.x + q1.y * q2.y + q1.z * q2.z + q1.w * q2.w;
        if (result < 0.0f) {
            q2.x = -q2.x;
            q2.y = -q2.y;
            q2.z = -q2.z;
            q2.w = -q2.w;
            result = -result;
        }
        float scale0 = 1.0f - t;
        float scale2 = t;
        if (1.0f - result > 0.1f) {
            final float theta = FastMath.acos(result);
            final float invSinTheta = 1.0f / FastMath.sin(theta);
            scale0 = FastMath.sin((1.0f - t) * theta) * invSinTheta;
            scale2 = FastMath.sin(t * theta) * invSinTheta;
        }
        this.x = scale0 * q1.x + scale2 * q2.x;
        this.y = scale0 * q1.y + scale2 * q2.y;
        this.z = scale0 * q1.z + scale2 * q2.z;
        this.w = scale0 * q1.w + scale2 * q2.w;
        return this;
    }

    public void slerp(final Quaternion q2, final float changeAmnt) {
        if (this.x == q2.x && this.y == q2.y && this.z == q2.z && this.w == q2.w) {
            return;
        }
        float result = this.x * q2.x + this.y * q2.y + this.z * q2.z + this.w * q2.w;
        if (result < 0.0f) {
            q2.x = -q2.x;
            q2.y = -q2.y;
            q2.z = -q2.z;
            q2.w = -q2.w;
            result = -result;
        }
        float scale0 = 1.0f - changeAmnt;
        float scale2 = changeAmnt;
        if (1.0f - result > 0.1f) {
            final float theta = FastMath.acos(result);
            final float invSinTheta = 1.0f / FastMath.sin(theta);
            scale0 = FastMath.sin((1.0f - changeAmnt) * theta) * invSinTheta;
            scale2 = FastMath.sin(changeAmnt * theta) * invSinTheta;
        }
        this.x = scale0 * this.x + scale2 * q2.x;
        this.y = scale0 * this.y + scale2 * q2.y;
        this.z = scale0 * this.z + scale2 * q2.z;
        this.w = scale0 * this.w + scale2 * q2.w;
    }

    public void nlerp(final Quaternion q2, final float blend) {
        final float dot = this.dot(q2);
        final float blendI = 1.0f - blend;
        if (dot < 0.0f) {
            this.x = blendI * this.x - blend * q2.x;
            this.y = blendI * this.y - blend * q2.y;
            this.z = blendI * this.z - blend * q2.z;
            this.w = blendI * this.w - blend * q2.w;
        } else {
            this.x = blendI * this.x + blend * q2.x;
            this.y = blendI * this.y + blend * q2.y;
            this.z = blendI * this.z + blend * q2.z;
            this.w = blendI * this.w + blend * q2.w;
        }
        this.normalizeLocal();
    }

    static {
        EMPTY = new Quaternion(0.0f, 0.0f, 0.0f, 0.0f);
    }
}
