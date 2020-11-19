package dk.gruppea3moro.moroa3.model;

import java.util.ArrayList;
import java.util.Date;

public class EventDTO {
    String title, subtext, eventLink, imageLink;
    Date startDate, endDate;
    double price;
    AddressDTO addressDTO;
    ArrayList<String> types, moods;




    public EventDTO(String title, String subtext, String eventLink, Date startDate, Date endDate, double price, String imageLink) {
        this.title = title;
        this.subtext = subtext;
        this.eventLink = eventLink;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.imageLink = imageLink;
    }

    public EventDTO() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtext() {
        return subtext;
    }

    public void setSubtext(String subtext) {
        this.subtext = subtext;
    }

    public String getEventLink() {
        return eventLink;
    }

    public void setEventLink(String eventLink) {
        this.eventLink = eventLink;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }

    public ArrayList<String> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<String> types) {
        this.types = types;
    }

    public ArrayList<String> getMoods() {
        return moods;
    }

    public void setMoods(ArrayList<String> moods) {
        this.moods = moods;
    }

    @Override
    public String toString() {
        return "EventDTO{" +
                "title='" + title + '\'' +
                ", subtext='" + subtext + '\'' +
                ", eventLink='" + eventLink + '\'' +
                ", imageLink='" + imageLink + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", price=" + price +
                ", addressDTO=" + addressDTO +
                ", types=" + types +
                ", moods=" + moods +
                '}';
    }
}
