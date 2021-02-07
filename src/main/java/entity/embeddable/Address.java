package entity.embeddable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
    @Column(name = "building_num")
    private String buildingNum;
    @Column(name = "street")
    private String Street;
    @Column(name = "city")
    private String city;

    public Address() {
    }

    public Address(String buildingNum, String street, String city) {
        this.buildingNum = buildingNum;
        this.Street = street;
        this.city = city;
    }

    public String getBuildingNum() {
        return buildingNum;
    }

    public void setBuildingNum(String buildingNum) {
        this.buildingNum = buildingNum;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
