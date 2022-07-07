package org.scriptobi.openschoolswing.entities;

public class EntityCity {
    private int cpl;
    private String name;

    public EntityCity() {}
    public EntityCity(int cpl, String name) {
        this.cpl = cpl;
        this.name = name;
    }

    public int getCpl() { return cpl; }
    public void setCpl(int cpl) { this.cpl = cpl; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
