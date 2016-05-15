package hu.bme.aut.animalfindapplication.model.animal;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

import java.io.Serializable;

/**
 * Created by Norbert on 2016. 04. 22..
 */
public class Animal extends SugarRecord implements Serializable {


    @SerializedName("advertisementTitle")
    String advertisementTitle;
    @SerializedName("advertisementDescription")
    String advertisementDescription;
    @SerializedName("lostOrFound")
    String lostOrFound;
    @SerializedName("species")
    String species;
    @SerializedName("breed")
    String breed;
    @SerializedName("city")
    String city;
    @SerializedName("date")
    String date;
    @SerializedName("contactName")
    String contactName;
    @SerializedName("contactPhone")
    String contactPhone;

    public Animal() {

    }

    public String getAdvertisementTitle() {
        return advertisementTitle;
    }

    public void setAdvertisementTitle(String advertisementTitle) {
        this.advertisementTitle = advertisementTitle;
    }

    public String getAdvertisementDescription() {
        return advertisementDescription;
    }

    public void setAdvertisementDescription(String advertisementDescription) {
        this.advertisementDescription = advertisementDescription;
    }

    public String getLostOrFound() {
        return lostOrFound;
    }

    public void setLostOrFound(String lostOrFound) {
        this.lostOrFound = lostOrFound;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

}
