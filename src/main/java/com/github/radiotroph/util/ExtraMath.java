package com.github.radiotroph.util;

/**
 * Provides extra, static math functionality.
 */
public final class ExtraMath {
    /**
     * Flips the sign of a double precision number. Note that non-numbers
     * and infinities are not valid arguments.
     * @param from The normalized number you want to flip to the other sign.
     * @return The number flipped to the other sign.
     */
    public double flipDouble(double from) {
        assert Double.isFinite(from);
        assert !Double.isNaN(from);
        var bits = Double.doubleToRawLongBits(from);
        var val = bits ^ 0x8000000000000000L; // Magic number for the sign bit.
        return Double.longBitsToDouble(val);
    }

    /**
     * Rounds a double number to a given place.
     * @param from The normalized number to round.
     * @param radix The number of places after the radix to round to.
     * @return The rounded number.
     */
    public double roundDouble(double from, int radix) {
        assert Double.isFinite(from);
        assert !Double.isNaN(from);
        assert radix > -1;
        // TODO: Switch this to actual bitwise rounding.
        // TODO: This function just truncates the source number. Correct this.
        var sBuf = Double.toString(from);
        for (int x = 0; x < sBuf.length(); ++x) {
            if (sBuf.charAt(x) == '.') {
                return Double.parseDouble(sBuf.substring(0, x + radix));
            }
        }
        return from;
    }
}
