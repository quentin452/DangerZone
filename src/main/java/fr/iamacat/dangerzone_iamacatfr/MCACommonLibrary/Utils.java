

package fr.iamacat.dangerzone_iamacatfr.MCACommonLibrary;

import fr.iamacat.dangerzone_iamacatfr.MCACommonLibrary.math.Matrix4f;
import fr.iamacat.dangerzone_iamacatfr.MCACommonLibrary.math.Quaternion;
import fr.iamacat.dangerzone_iamacatfr.MCACommonLibrary.math.Vector3f;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class Utils
{
    public static FloatBuffer makeFloatBuffer(final float[] arr) {
        final ByteBuffer bb = ByteBuffer.allocateDirect(arr.length * 4);
        bb.order(ByteOrder.nativeOrder());
        final FloatBuffer fb = bb.asFloatBuffer();
        fb.put(arr);
        fb.position(0);
        return fb;
    }

    public static ByteBuffer makeByteBuffer(final byte[] arr) {
        final ByteBuffer bb = ByteBuffer.allocateDirect(arr.length);
        bb.order(ByteOrder.nativeOrder());
        bb.put(arr);
        bb.position(0);
        return bb;
    }

    public static Quaternion getQuaternionFromMatrix(final Matrix4f matrix) {
        final Matrix4f copy = new Matrix4f(matrix);
        return new Quaternion(copy.transpose());
    }

    public static Quaternion getQuaternionFromEulers(final float x, final float y, final float z) {
        final Quaternion quatX = new Quaternion(Vector3f.UNIT_X, (float)Math.toRadians(x));
        final Quaternion quatY = new Quaternion(Vector3f.UNIT_Y, (float)Math.toRadians(y));
        final Quaternion quatZ = new Quaternion(Vector3f.UNIT_Z, (float)Math.toRadians(z));
        quatY.mul(quatY, quatX);
        quatZ.mul(quatZ, quatY);
        return quatZ;
    }
}
