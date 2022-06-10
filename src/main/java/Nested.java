public class Nested {

    private String field1;

    private String field2;

    private String field3;

    private Inner inner1;

    private Inner inner2;

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

    public Inner getInner1() {
        return inner1;
    }

    public void setInner1(Inner inner1) {
        this.inner1 = inner1;
    }

    public Inner getInner2() {
        return inner2;
    }

    public void setInner2(Inner inner2) {
        this.inner2 = inner2;
    }

    @Override
    public String toString() {
        return "Nested{" +
                "field1='" + field1 + '\'' +
                ", field2='" + field2 + '\'' +
                ", field3='" + field3 + '\'' +
                ", inner1=" + inner1 +
                ", inner2=" + inner2 +
                '}';
    }
}
