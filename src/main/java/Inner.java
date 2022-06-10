public class Inner {

    private String field1;

    private String field2;

    private String field3;

    private Deep deep1;

    private Deep deep2;

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

    public Deep getDeep1() {
        return deep1;
    }

    public void setDeep1(Deep deep1) {
        this.deep1 = deep1;
    }

    public Deep getDeep2() {
        return deep2;
    }

    public void setDeep2(Deep deep2) {
        this.deep2 = deep2;
    }

    @Override
    public String toString() {
        return "Inner{" +
                "field1='" + field1 + '\'' +
                ", field2='" + field2 + '\'' +
                ", field3='" + field3 + '\'' +
                ", deep1=" + deep1 +
                ", deep2=" + deep2 +
                '}';
    }
}
