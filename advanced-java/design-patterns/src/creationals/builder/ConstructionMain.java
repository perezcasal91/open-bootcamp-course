package creationals.builder;

public class ConstructionMain {
    public static void main(String[] args) {
        House house = new HouseBuilder().
                setAttic("yes")
                .setBathroom("yes")
                .build();
        System.out.println(house);
    }
}
class HouseBuilder {
    private House house;
    public HouseBuilder() {init();}
    private void init() {house = new HouseImplement();}
    public HouseBuilder setFoundation(String foundation) {this.house.setFoundation(foundation); return this;}
    public HouseBuilder setAttic(String attic) {this.house.setAttic(attic); return this;}
    public HouseBuilder setBasement(String basement) {this.house.setBasement(basement); return this;}
    public HouseBuilder setBathroom(String bathroom) {this.house.setBathroom(bathroom); return this;}
    public HouseBuilder setBedroom(String bedroom) {this.house.setBedroom(bedroom); return this;}
    public HouseBuilder setRoof(String roof) {this.house.setRoof(roof); return this;}
    public HouseBuilder setCellar(String cellar) {this.house.setCellar(cellar); return this;}
    public HouseBuilder setDiningRoom(String diningRoom) {this.house.setDiningRoom(diningRoom); return this;}
    public HouseBuilder setFloor(String floor) {this.house.setFloor(floor); return this;}
    public HouseBuilder setGarage(String garage) {this.house.setGarage(garage); return this;}
    public HouseBuilder setHall(String hall) {this.house.setHall(hall); return this;}
    public HouseBuilder setKitchen(String kitchen) {this.house.setKitchen(kitchen); return this;}
    public HouseBuilder setLaundryRoom(String laundryRoom) {this.house.setLaundryRoom(laundryRoom); return this;}
    public HouseBuilder setLivingRoom(String livingRoom) {this.house.setLivingRoom(livingRoom); return this;}
    public HouseBuilder setPool(String pool) {this.house.setPool(pool); return this;}
    public HouseBuilder setSittingRoom(String sittingRoom) {this.house.setSittingRoom(sittingRoom); return this;}
    public HouseBuilder setStairs(String stairs) {this.house.setStairs(stairs); return this;}
    public HouseBuilder setStudy(String study) {this.house.setStudy(study); return this;}
    public House build(){return house;}
}
interface House {
    String getFoundation();
    void setFoundation(String foundation);
    String getAttic();
    void setAttic(String attic);
    String getBasement();
    void setBasement(String basement);
    String getBathroom();
    void setBathroom(String bathroom);
    String getBedroom();
    void setBedroom(String bedroom);
    String getRoof();
    void setRoof(String roof);
    String getCellar();
    void setCellar(String cellar);
    String getDiningRoom();
    void setDiningRoom(String diningRoom);
    String getFloor();
    void setFloor(String floor);
    String getGarage();
    void setGarage(String garage);
    String getHall();
    void setHall(String hall);
    String getKitchen();
    void setKitchen(String kitchen);
    String getLaundryRoom();
    void setLaundryRoom(String laundryRoom);
    String getLivingRoom();
    void setLivingRoom(String livingRoom);
    String getPool();
    void setPool(String pool);
    String getSittingRoom();
    void setSittingRoom(String sittingRoom);
    String getStairs();
    void setStairs(String stairs);
    String getStudy();
    void setStudy(String study);
}
class HouseImplement implements House{
    private String foundation;
    private String attic;
    private String basement;
    private String bathroom;
    private String bedroom;
    private String roof;
    private String cellar;
    private String diningRoom;
    private String floor;
    private String garage;
    private String hall;
    private String kitchen;
    private String laundryRoom;
    private String livingRoom;
    private String pool;
    private String sittingRoom;
    private String stairs;
    private String study;
    @Override
    public String getFoundation() {return foundation;}
    @Override
    public void setFoundation(String foundation) {this.foundation = foundation;}
    @Override
    public String getAttic() {return attic;}
    @Override
    public void setAttic(String attic) {this.attic = attic;}
    @Override
    public String getBasement() {return basement;}
    @Override
    public void setBasement(String basement) {this.basement = basement;}
    @Override
    public String getBathroom() {return bathroom;}
    @Override
    public void setBathroom(String bathroom) {this.bathroom = bathroom;}
    @Override
    public String getBedroom() {return bedroom;}
    @Override
    public void setBedroom(String bedroom) {this.bedroom = bedroom;}
    @Override
    public String getRoof() {return roof;}
    @Override
    public void setRoof(String roof) {this.roof = roof;}
    @Override
    public String getCellar() {return cellar;}
    @Override
    public void setCellar(String cellar) {this.cellar = cellar;}
    @Override
    public String getDiningRoom() {return diningRoom;}
    @Override
    public void setDiningRoom(String diningRoom) {this.diningRoom = diningRoom;}
    @Override
    public String getFloor() {return floor;}
    @Override
    public void setFloor(String floor) {this.floor = floor;}
    @Override
    public String getGarage() {return garage;}
    @Override
    public void setGarage(String garage) {this.garage = garage;}
    @Override
    public String getHall() {return hall;}
    @Override
    public void setHall(String hall) {this.hall = hall;}
    @Override
    public String getKitchen() {return kitchen;}
    @Override
    public void setKitchen(String kitchen) {this.kitchen = kitchen;}
    @Override
    public String getLaundryRoom() {return laundryRoom;}
    @Override
    public void setLaundryRoom(String laundryRoom) {this.laundryRoom = laundryRoom;}
    @Override
    public String getLivingRoom() {return livingRoom;}
    @Override
    public void setLivingRoom(String livingRoom) {this.livingRoom = livingRoom;}
    @Override
    public String getPool() {return pool;}
    @Override
    public void setPool(String pool) {this.pool = pool;}
    @Override
    public String getSittingRoom() {return sittingRoom;}
    @Override
    public void setSittingRoom(String sittingRoom) {this.sittingRoom = sittingRoom;}
    @Override
    public String getStairs() {return stairs;}
    @Override
    public void setStairs(String stairs) {this.stairs = stairs;}
    @Override
    public String getStudy() {return study;}
    @Override
    public void setStudy(String study) {this.study = study;}
    @Override
    public String toString() {
        return "HouseImplement { " +
                "foundation='" + foundation + '\'' +
                ", attic='" + attic + '\'' +
                ", basement='" + basement + '\'' +
                ", bathroom='" + bathroom + '\'' +
                ", bedroom='" + bedroom + '\'' +
                ", roof='" + roof + '\'' +
                ", cellar='" + cellar + '\'' +
                ", diningRoom='" + diningRoom + '\'' +
                ", floor='" + floor + '\'' +
                ", garage='" + garage + '\'' +
                ", hall='" + hall + '\'' +
                ", kitchen='" + kitchen + '\'' +
                ", laundryRoom='" + laundryRoom + '\'' +
                ", livingRoom='" + livingRoom + '\'' +
                ", pool='" + pool + '\'' +
                ", sittingRoom='" + sittingRoom + '\'' +
                ", stairs='" + stairs + '\'' +
                ", study='" + study + '\'' +
                " } ";
    }
}
