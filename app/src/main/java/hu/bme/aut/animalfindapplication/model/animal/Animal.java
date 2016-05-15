package hu.bme.aut.animalfindapplication.model.animal;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

import java.io.Serializable;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        Animal animal = (Animal) o;
        return Objects.equals(this.getId(), animal.getId()) &&
                Objects.equals(advertisementTitle, animal.advertisementTitle) &&
                Objects.equals(advertisementDescription, animal.advertisementDescription) &&
                Objects.equals(lostOrFound, animal.lostOrFound) &&
                Objects.equals(species, animal.species) &&
                Objects.equals(breed, animal.breed) &&
                Objects.equals(city, animal.city) &&
                Objects.equals(date, animal.date) &&
                Objects.equals(contactName, animal.contactName) &&
                Objects.equals(contactPhone, animal.contactPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), advertisementTitle, advertisementDescription, lostOrFound, species, breed, city, date, contactName, contactPhone);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Animal {\n");

        sb.append("    id: ").append(toIndentedString(this.getId())).append("\n");
        sb.append("    advertisementTitle: ").append(toIndentedString(advertisementTitle)).append("\n");
        sb.append("    advertisementDescription: ").append(toIndentedString(advertisementDescription)).append("\n");
        sb.append("    lostOrFound: ").append(toIndentedString(lostOrFound)).append("\n");
        sb.append("    species: ").append(toIndentedString(species)).append("\n");
        sb.append("    breed: ").append(toIndentedString(breed)).append("\n");
        sb.append("    city: ").append(toIndentedString(city)).append("\n");
        sb.append("    date: ").append(toIndentedString(date)).append("\n");
        sb.append("    contactName: ").append(toIndentedString(contactName)).append("\n");
        sb.append("    contactPhone: ").append(toIndentedString(contactPhone)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
