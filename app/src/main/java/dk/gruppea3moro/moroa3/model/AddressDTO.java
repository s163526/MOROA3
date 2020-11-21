package dk.gruppea3moro.moroa3.model;

public class AddressDTO {
    String area;
    String streetName;
    int streetNumber;
    int zipCode;

    //Optional information, could be null.
    String additionalText;
    String addressName;

    public AddressDTO(String area, String streetName, int streetNumber, int zipCode) {
        this.area = area;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.zipCode = zipCode;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getAdditionalText() {
        return additionalText;
    }

    public void setAdditionalText(String additionalText) {
        this.additionalText = additionalText;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    @Override
    public String toString() {//TODO make real address string
        return "AddressDTO{" +
                "area='" + area + '\'' +
                ", streetName='" + streetName + '\'' +
                ", streetNumber=" + streetNumber +
                ", zipCode=" + zipCode +
                ", additionalText='" + additionalText + '\'' +
                ", addressName='" + addressName + '\'' +
                '}';
    }
}
