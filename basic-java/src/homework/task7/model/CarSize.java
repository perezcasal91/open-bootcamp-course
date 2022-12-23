package homework.task7.model;

public class CarSize {
    private Integer length;
    private Integer width;
    public CarSize() {}
    public CarSize(Integer length, Integer width) {
        this.length = length;
        this.width = width;
    }
    public Integer getLength() {
        return length;
    }
    public void setLength(Integer length) {
        this.length = length;
    }
    public Integer getWidth() {
        return width;
    }
    public void setWidth(Integer width) {
        this.width = width;
    }
    @Override
    public String toString() {
        return this.getLength() + "L" + this.getWidth() + "W";
    }
}
