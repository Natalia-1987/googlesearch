package google;

public class Parkas {
    private String color;
    private String size;
    private String name;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Parkas{" +
                "color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
