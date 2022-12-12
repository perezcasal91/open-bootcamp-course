package homework.task7.model;

public class CarWeight {
    private Double value;
    private String unit;

    public CarWeight(){}
    public CarWeight(Double value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
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
