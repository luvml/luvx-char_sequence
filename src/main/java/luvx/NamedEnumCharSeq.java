package luvx;

public interface NamedEnumCharSeq extends NamedEnum, DelegatedCharSeq{

    default String delegatedCharSeqVal() {
        return name();
    }
    
}
