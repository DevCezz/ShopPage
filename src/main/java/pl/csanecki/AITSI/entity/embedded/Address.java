package pl.csanecki.AITSI.entity.embedded;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
    @Column(name = "STREET")
    private String street;

    @Column(name = "NUMBER_OF_HOUSE")
    private String numberOfHouse;

    @Column(name = "NUMBER_OF_FLAT")
    private String numberOfFlat;

    @Column(name = "CITY")
    private String city;

    @Column(name = "POST_CODE")
    private String postCode;

    public Address(String street, String numberOfHouse, String numberOfFlat, String city, String postCode) {
        this.street = street;
        this.numberOfHouse = numberOfHouse;
        this.numberOfFlat = numberOfFlat;
        this.city = city;
        this.postCode = postCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", numberOfHouse='" + numberOfHouse + '\'' +
                ", numberOfFlat='" + numberOfFlat + '\'' +
                ", city='" + city + '\'' +
                ", postCode='" + postCode + '\'' +
                '}';
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumberOfHouse() {
        return numberOfHouse;
    }

    public void setNumberOfHouse(String numberOfHouse) {
        this.numberOfHouse = numberOfHouse;
    }

    public String getNumberOfFlat() {
        return numberOfFlat;
    }

    public void setNumberOfFlat(String numberOfFlat) {
        this.numberOfFlat = numberOfFlat;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}
