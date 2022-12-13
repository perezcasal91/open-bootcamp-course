package homework.task7.model;

public class CarWeightOrSpeed {
    private Integer value;
    private String unit;
    public CarWeightOrSpeed(){}
    public CarWeightOrSpeed(Integer value, String unit) {
        this.value = value;
        this.unit = unit;
    }
    public Integer getValue() {
        return value;
    }
    public void setValue(Integer value) {
        this.value = value;
    }
    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }
    @Override
    public String toString() {
        return this.getValue() + "" + this.getUnit();
    }
}
