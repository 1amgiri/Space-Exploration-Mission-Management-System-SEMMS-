package models;

public class Spacecraft {
    private int id;
    private String name;
    private String type;
    private int capacity;

    public Spacecraft(int id, String name, String type, int capacity) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.capacity = capacity;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getType() { return type; }
    public int getCapacity() { return capacity; }
}
