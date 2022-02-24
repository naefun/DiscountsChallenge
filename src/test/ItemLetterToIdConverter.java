package test;

public enum ItemLetterToIdConverter {
    A(1),
    B(2),
    C(3),
    D(4),
    E(5);

    public final int label;

    private ItemLetterToIdConverter(int label) {
        this.label = label;
    }

    public int getId(){
        return label;
    }
}
