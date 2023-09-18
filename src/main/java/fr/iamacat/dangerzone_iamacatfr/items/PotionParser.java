
package fr.iamacat.dangerzone_iamacatfr.items;

public class PotionParser {

    public static int readID(final int value) {
        final byte lowByte = (byte) (value & getLeastBitMask(4));
        return lowByte & 0xFF;
    }

    public static int setID(int iD, final int value) {
        if (iD < 0 || iD > 15) {
            iD = ((iD < 0) ? 0 : 15);
        }
        return setBitRange(value, iD, 0, 4);
    }

    public static int readLevel(final int value) {
        final byte lowByte = (byte) (value >> 4 & getLeastBitMask(2));
        return lowByte & 0xFF;
    }

    public static int setLevel(int level, final int value) {
        if (level < 0 || level > 3) {
            level = ((level < 0) ? 0 : 3);
        }
        return setBitRange(value, level, 4, 2);
    }

    public static int readPower(final int value) {
        final byte lowByte = (byte) (value >> 6 & getLeastBitMask(2));
        return lowByte & 0xFF;
    }

    public static int setPower(int power, final int value) {
        if (power < 0 || power > 3) {
            power = ((power < 0) ? 0 : 3);
        }
        return setBitRange(value, power, 6, 2);
    }

    public static int readDuration(final int value) {
        final byte lowByte = (byte) (value >> 8 & getLeastBitMask(2));
        return lowByte & 0xFF;
    }

    public static int setDuration(int duration, final int value) {
        if (duration < 0 || duration > 3) {
            duration = ((duration < 0) ? 0 : 3);
        }
        return setBitRange(value, duration, 8, 2);
    }

    public static int readContainer(final int value) {
        final byte lowByte = (byte) (value >> 10 & getLeastBitMask(2));
        return lowByte & 0xFF;
    }

    public static int setContainer(int container, final int value) {
        if (container < 0 || container > 3) {
            container = ((container < 0) ? 0 : 3);
        }
        return setBitRange(value, container, 10, 2);
    }

    public static boolean isSplash(final int value) {
        return isBitSet(value, 14);
    }

    public static int setSplash(final int value) {
        return setBit(value, 14);
    }

    private static int setBitRange(int origValue, final int valueToSet, final int startingBitToSet,
        final int bitsToSet) {
        for (int i = 0; i < bitsToSet; ++i) {
            if (isBitSet(origValue, startingBitToSet + i) == !isBitSet(valueToSet, i)) {
                origValue = flipBit(origValue, startingBitToSet + i);
            }
        }
        return origValue;
    }

    private static boolean isBitSet(final int value, final int index) {
        return ((long) value & 1L << index) != 0x0L;
    }

    private static int setBit(final int value, final int index) {
        return value | 1 << index;
    }

    private static int unSetBit(final int value, final int index) {
        return value & ~(1 << index);
    }

    private static int flipBit(final int value, final int index) {
        return value ^ 1 << index;
    }

    private static int getLeastBitMask(final int numBits) {
        return (1 << numBits) - 1;
    }
}
