public class Schema {
    private String item;
    private String value;
    private String active;

    public Schema(String item, String value, String active){
        this.item = item;
        this.value = value;
        this.active = active;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}
