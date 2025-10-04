package luvx;

public interface DelegatedCharSeq extends CharSequence {
    String delegatedCharSeqVal();
    default int length() {
        return delegatedCharSeqVal().length();
    }
    default char charAt(int index) {
        return delegatedCharSeqVal().charAt(index);
    }
    default CharSequence subSequence(int start, int end) {
        return delegatedCharSeqVal().subSequence(start, end);
    }
}
