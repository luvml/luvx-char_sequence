package luvx;

/**
 * A {@link CharSequence} in name only. A type implements this so it can stand in a {@code CharSequence...}
 * argument list next to plain strings (an HTML fragment beside text, for example), while being no text at all.
 * None of the text methods work: each throws.
 *
 * <p>Any code that turns a {@code CharSequence} into text calls {@link #requireText} first, so a value of this
 * kind fails loudly with the place it was passed to, instead of printing its {@code toString()} into the output.
 */
public interface NameOnlyCharSeq extends CharSequence {

    @Override default int length() { throw notText(this, "length()"); }
    @Override default char charAt(int index) { throw notText(this, "charAt()"); }
    @Override default CharSequence subSequence(int start, int end) { throw notText(this, "subSequence()"); }

    /** Returns {@code cs} unchanged, or throws if it is a name-only CharSequence. {@code where} names the receiving API. */
    static <C extends CharSequence> C requireText(C cs, String where) {
        if (cs instanceof NameOnlyCharSeq) throw notText(cs, where);
        return cs;
    }

    /** Checks every element of {@code values}; returns the array unchanged. */
    static CharSequence[] requireText(CharSequence[] values, String where) {
        if (values != null) for (int i = 0; i < values.length; i++) {
            if (values[i] instanceof NameOnlyCharSeq) throw notText(values[i], where + ", argument " + (i + 1));
        }
        return values;
    }

    private static IllegalArgumentException notText(Object o, String where) {
        return new IllegalArgumentException(where + ": expected text, got " + o.getClass().getSimpleName()
            + ". A fragment or element cannot be used as a CSS value, class name, selector or string.");
    }
}
