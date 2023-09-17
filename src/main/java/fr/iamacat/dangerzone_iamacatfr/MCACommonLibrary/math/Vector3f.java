

package fr.iamacat.dangerzone_iamacatfr.MCACommonLibrary.math;

import java.io.Serializable;
import java.util.logging.Logger;

public final class Vector3f implements Cloneable, Serializable
{
    static final long serialVersionUID = 1L;
    private static final Logger logger;
    public static final Vector3f ZERO;
    public static final Vector3f NAN;
    public static final Vector3f UNIT_X;
    public static final Vector3f UNIT_Y;
    public static final Vector3f UNIT_Z;
    public static final Vector3f UNIT_XYZ;
    public static final Vector3f POSITIVE_INFINITY;
    public static final Vector3f NEGATIVE_INFINITY;
    public float x;
    public float y;
    public float z;

    public Vector3f() {
        final float x = 0.0f;
        this.z = x;
        this.y = x;
        this.x = x;
    }

    public Vector3f(final float x, final float y, final float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3f(final Vector3f copy) {
        this.set(copy);
    }

    public Vector3f set(final float x, final float y, final float z) {
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }

    public Vector3f set(final Vector3f vect) {
        this.x = vect.x;
        this.y = vect.y;
        this.z = vect.z;
        return this;
    }

    public Vector3f add(final Vector3f vec) {
        if (null == vec) {
            Vector3f.logger.warning("Provided vector is null, null returned.");
            return null;
        }
        return new Vector3f(this.x + vec.x, this.y + vec.y, this.z + vec.z);
    }

    public Vector3f add(final Vector3f vec, final Vector3f result) {
        result.x = this.x + vec.x;
        result.y = this.y + vec.y;
        result.z = this.z + vec.z;
        return result;
    }

    public Vector3f addLocal(final Vector3f vec) {
        if (null == vec) {
            Vector3f.logger.warning("Provided vector is null, null returned.");
            return null;
        }
        this.x += vec.x;
        this.y += vec.y;
        this.z += vec.z;
        return this;
    }

    public Vector3f add(final float addX, final float addY, final float addZ) {
        return new Vector3f(this.x + addX, this.y + addY, this.z + addZ);
    }

    public Vector3f addLocal(final float addX, final float addY, final float addZ) {
        this.x += addX;
        this.y += addY;
        this.z += addZ;
        return this;
    }

    public Vector3f scaleAdd(final float scalar, final Vector3f add) {
        this.x = this.x * scalar + add.x;
        this.y = this.y * scalar + add.y;
        this.z = this.z * scalar + add.z;
        return this;
    }

    public Vector3f scaleAdd(final float scalar, final Vector3f mult, final Vector3f add) {
        this.x = mult.x * scalar + add.x;
        this.y = mult.y * scalar + add.y;
        this.z = mult.z * scalar + add.z;
        return this;
    }

    public float dot(final Vector3f vec) {
        if (null == vec) {
            Vector3f.logger.warning("Provided vector is null, 0 returned.");
            return 0.0f;
        }
        return this.x * vec.x + this.y * vec.y + this.z * vec.z;
    }

    public Vector3f cross(final Vector3f v) {
        return this.cross(v, null);
    }

    public Vector3f cross(final Vector3f v, final Vector3f result) {
        return this.cross(v.x, v.y, v.z, result);
    }

    public Vector3f cross(final float otherX, final float otherY, final float otherZ, Vector3f result) {
        if (result == null) {
            result = new Vector3f();
        }
        final float resX = this.y * otherZ - this.z * otherY;
        final float resY = this.z * otherX - this.x * otherZ;
        final float resZ = this.x * otherY - this.y * otherX;
        result.set(resX, resY, resZ);
        return result;
    }

    public Vector3f crossLocal(final Vector3f v) {
        return this.crossLocal(v.x, v.y, v.z);
    }

    public Vector3f crossLocal(final float otherX, final float otherY, final float otherZ) {
        final float tempx = this.y * otherZ - this.z * otherY;
        final float tempy = this.z * otherX - this.x * otherZ;
        this.z = this.x * otherY - this.y * otherX;
        this.x = tempx;
        this.y = tempy;
        return this;
    }

    public Vector3f project(final Vector3f other) {
        final float n = this.dot(other);
        final float d = other.lengthSquared();
        return new Vector3f(other).normalizeLocal().multLocal(n / d);
    }

    public boolean isUnitVector() {
        final float len = this.length();
        return 0.99f < len && len < 1.01f;
    }

    public float length() {
        return FastMath.sqrt(this.lengthSquared());
    }

    public float lengthSquared() {
        return this.x * this.x + this.y * this.y + this.z * this.z;
    }

    public float distanceSquared(final Vector3f v) {
        final double dx = this.x - v.x;
        final double dy = this.y - v.y;
        final double dz = this.z - v.z;
        return (float)(dx * dx + dy * dy + dz * dz);
    }

    public float distance(final Vector3f v) {
        return FastMath.sqrt(this.distanceSquared(v));
    }

    public Vector3f mult(final float scalar) {
        return new Vector3f(this.x * scalar, this.y * scalar, this.z * scalar);
    }

    public Vector3f mult(final float scalar, Vector3f product) {
        if (null == product) {
            product = new Vector3f();
        }
        product.x = this.x * scalar;
        product.y = this.y * scalar;
        product.z = this.z * scalar;
        return product;
    }

    public Vector3f multLocal(final float scalar) {
        this.x *= scalar;
        this.y *= scalar;
        this.z *= scalar;
        return this;
    }

    public Vector3f multLocal(final Vector3f vec) {
        if (null == vec) {
            Vector3f.logger.warning("Provided vector is null, null returned.");
            return null;
        }
        this.x *= vec.x;
        this.y *= vec.y;
        this.z *= vec.z;
        return this;
    }

    public Vector3f multLocal(final float x, final float y, final float z) {
        this.x *= x;
        this.y *= y;
        this.z *= z;
        return this;
    }

    public Vector3f mult(final Vector3f vec) {
        if (null == vec) {
            Vector3f.logger.warning("Provided vector is null, null returned.");
            return null;
        }
        return this.mult(vec, null);
    }

    public Vector3f mult(final Vector3f vec, Vector3f store) {
        if (null == vec) {
            Vector3f.logger.warning("Provided vector is null, null returned.");
            return null;
        }
        if (store == null) {
            store = new Vector3f();
        }
        return store.set(this.x * vec.x, this.y * vec.y, this.z * vec.z);
    }

    public Vector3f divide(float scalar) {
        scalar = 1.0f / scalar;
        return new Vector3f(this.x * scalar, this.y * scalar, this.z * scalar);
    }

    public Vector3f divideLocal(float scalar) {
        scalar = 1.0f / scalar;
        this.x *= scalar;
        this.y *= scalar;
        this.z *= scalar;
        return this;
    }

    public Vector3f divide(final Vector3f scalar) {
        return new Vector3f(this.x / scalar.x, this.y / scalar.y, this.z / scalar.z);
    }

    public Vector3f divideLocal(final Vector3f scalar) {
        this.x /= scalar.x;
        this.y /= scalar.y;
        this.z /= scalar.z;
        return this;
    }

    public Vector3f negate() {
        return new Vector3f(-this.x, -this.y, -this.z);
    }

    public Vector3f negateLocal() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
        return this;
    }

    public Vector3f subtract(final Vector3f vec) {
        return new Vector3f(this.x - vec.x, this.y - vec.y, this.z - vec.z);
    }

    public Vector3f subtractLocal(final Vector3f vec) {
        if (null == vec) {
            Vector3f.logger.warning("Provided vector is null, null returned.");
            return null;
        }
        this.x -= vec.x;
        this.y -= vec.y;
        this.z -= vec.z;
        return this;
    }

    public Vector3f subtract(final Vector3f vec, Vector3f result) {
        if (result == null) {
            result = new Vector3f();
        }
        result.x = this.x - vec.x;
        result.y = this.y - vec.y;
        result.z = this.z - vec.z;
        return result;
    }

    public Vector3f subtract(final float subtractX, final float subtractY, final float subtractZ) {
        return new Vector3f(this.x - subtractX, this.y - subtractY, this.z - subtractZ);
    }

    public Vector3f subtractLocal(final float subtractX, final float subtractY, final float subtractZ) {
        this.x -= subtractX;
        this.y -= subtractY;
        this.z -= subtractZ;
        return this;
    }

    public Vector3f normalize() {
        float length = this.x * this.x + this.y * this.y + this.z * this.z;
        if (length != 1.0f && length != 0.0f) {
            length = 1.0f / FastMath.sqrt(length);
            return new Vector3f(this.x * length, this.y * length, this.z * length);
        }
        return this.clone();
    }

    public Vector3f normalizeLocal() {
        float length = this.x * this.x + this.y * this.y + this.z * this.z;
        if (length != 1.0f && length != 0.0f) {
            length = 1.0f / FastMath.sqrt(length);
            this.x *= length;
            this.y *= length;
            this.z *= length;
        }
        return this;
    }

    public void maxLocal(final Vector3f other) {
        this.x = ((other.x > this.x) ? other.x : this.x);
        this.y = ((other.y > this.y) ? other.y : this.y);
        this.z = ((other.z > this.z) ? other.z : this.z);
    }

    public void minLocal(final Vector3f other) {
        this.x = ((other.x < this.x) ? other.x : this.x);
        this.y = ((other.y < this.y) ? other.y : this.y);
        this.z = ((other.z < this.z) ? other.z : this.z);
    }

    public Vector3f zero() {
        final float x = 0.0f;
        this.z = x;
        this.y = x;
        this.x = x;
        return this;
    }

    public float angleBetween(final Vector3f otherVector) {
        final float dotProduct = this.dot(otherVector);
        final float angle = FastMath.acos(dotProduct);
        return angle;
    }

    public Vector3f interpolate(final Vector3f finalVec, final float changeAmnt) {
        this.x = (1.0f - changeAmnt) * this.x + changeAmnt * finalVec.x;
        this.y = (1.0f - changeAmnt) * this.y + changeAmnt * finalVec.y;
        this.z = (1.0f - changeAmnt) * this.z + changeAmnt * finalVec.z;
        return this;
    }

    public Vector3f interpolate(final Vector3f beginVec, final Vector3f finalVec, final float changeAmnt) {
        this.x = (1.0f - changeAmnt) * beginVec.x + changeAmnt * finalVec.x;
        this.y = (1.0f - changeAmnt) * beginVec.y + changeAmnt * finalVec.y;
        this.z = (1.0f - changeAmnt) * beginVec.z + changeAmnt * finalVec.z;
        return this;
    }

    public static boolean isValidVector(final Vector3f vector) {
        return vector != null && !Float.isNaN(vector.x) && !Float.isNaN(vector.y) && !Float.isNaN(vector.z) && !Float.isInfinite(vector.x) && !Float.isInfinite(vector.y) && !Float.isInfinite(vector.z);
    }

    public static void generateOrthonormalBasis(final Vector3f u, final Vector3f v, final Vector3f w) {
        w.normalizeLocal();
        generateComplementBasis(u, v, w);
    }

    public static void generateComplementBasis(final Vector3f u, final Vector3f v, final Vector3f w) {
        if (FastMath.abs(w.x) >= FastMath.abs(w.y)) {
            final float fInvLength = FastMath.invSqrt(w.x * w.x + w.z * w.z);
            u.x = -w.z * fInvLength;
            u.y = 0.0f;
            u.z = w.x * fInvLength;
            v.x = w.y * u.z;
            v.y = w.z * u.x - w.x * u.z;
            v.z = -w.y * u.x;
        }
        else {
            final float fInvLength = FastMath.invSqrt(w.y * w.y + w.z * w.z);
            u.x = 0.0f;
            u.y = w.z * fInvLength;
            u.z = -w.y * fInvLength;
            v.x = w.y * u.z - w.z * u.y;
            v.y = -w.x * u.z;
            v.z = w.x * u.y;
        }
    }

    public Vector3f clone() {
        try {
            return (Vector3f)super.clone();
        }
        catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public float[] toArray(float[] floats) {
        if (floats == null) {
            floats = new float[3];
        }
        floats[0] = this.x;
        floats[1] = this.y;
        floats[2] = this.z;
        return floats;
    }

    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof Vector3f)) {
            return false;
        }
        if (this == o) {
            return true;
        }
        final Vector3f comp = (Vector3f)o;
        return Float.compare(this.x, comp.x) == 0 && Float.compare(this.y, comp.y) == 0 && Float.compare(this.z, comp.z) == 0;
    }

    @Override
    public int hashCode() {
        int hash = 37;
        hash += 37 * hash + Float.floatToIntBits(this.x);
        hash += 37 * hash + Float.floatToIntBits(this.y);
        hash += 37 * hash + Float.floatToIntBits(this.z);
        return hash;
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ", " + this.z + ")";
    }

    public float getX() {
        return this.x;
    }

    public Vector3f setX(final float x) {
        this.x = x;
        return this;
    }

    public float getY() {
        return this.y;
    }

    public Vector3f setY(final float y) {
        this.y = y;
        return this;
    }

    public float getZ() {
        return this.z;
    }

    public Vector3f setZ(final float z) {
        this.z = z;
        return this;
    }

    public float get(final int index) {
        switch (index) {
            case 0: {
                return this.x;
            }
            case 1: {
                return this.y;
            }
            case 2: {
                return this.z;
            }
            default: {
                throw new IllegalArgumentException("index must be either 0, 1 or 2");
            }
        }
    }

    public void set(final int index, final float value) {
        switch (index) {
            case 0: {
                this.x = value;
            }
            case 1: {
                this.y = value;
            }
            case 2: {
                this.z = value;
            }
            default: {
                throw new IllegalArgumentException("index must be either 0, 1 or 2");
            }
        }
    }

    static {
        logger = Logger.getLogger(Vector3f.class.getName());
        ZERO = new Vector3f(0.0f, 0.0f, 0.0f);
        NAN = new Vector3f(Float.NaN, Float.NaN, Float.NaN);
        UNIT_X = new Vector3f(1.0f, 0.0f, 0.0f);
        UNIT_Y = new Vector3f(0.0f, 1.0f, 0.0f);
        UNIT_Z = new Vector3f(0.0f, 0.0f, 1.0f);
        UNIT_XYZ = new Vector3f(1.0f, 1.0f, 1.0f);
        POSITIVE_INFINITY = new Vector3f(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
        NEGATIVE_INFINITY = new Vector3f(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
    }
}
