public class Root {

   private String field1;

   private String field2;

   private String field3;

   private Nested nested1;

   private Nested nested2;

   private Nested nested3;

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    public Nested getNested1() {
        return nested1;
    }

    public void setNested1(Nested nested1) {
        this.nested1 = nested1;
    }

    public Nested getNested2() {
        return nested2;
    }

    public void setNested2(Nested nested2) {
        this.nested2 = nested2;
    }

    public Nested getNested3() {
        return nested3;
    }

    public void setNested3(Nested nested3) {
        this.nested3 = nested3;
    }

    @Override
    public String toString() {
        return "Root{" +
                "field1='" + field1 + '\'' +
                ", field2='" + field2 + '\'' +
                ", field3='" + field3 + '\'' +
                ", nested1=" + nested1 +
                ", nested2=" + nested2 +
                ", nested3=" + nested3 +
                '}';
    }
}
