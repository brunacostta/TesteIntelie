public class Facts {
    private String name;
    private String item;
    private String value;
    private boolean active;

    public Facts(String name, String item, String value, boolean active){
        this.name = name;
        this.item = item;
        this.value = value;
        this.active = active;
    }

    public void setNome(String nome) {
        this.name = nome;
    }
    
    public String getName() {
        return name;
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}
