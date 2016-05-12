package hu.bme.aut.animalfindapplication.model.animal;

import com.orm.SugarRecord;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Norbert on 2016. 04. 22..
 */
public class Animal extends SugarRecord implements IAnimalDal, Serializable {

    public Animal() {}
    String advertisementTitle;
    String advertisementDescription;
    String lostOrFound;
    String species;
    String breed;
    String city;
    String date;
    String contactName;
    String contactPhone;

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
    public List<Animal> getAllAnimals() {
        return Animal.find(Animal.class, null, null, null, null, null);
    }

    @Override
    public void createAnimal(Animal animal) {
        animal.save();
    }

    @Override
    public void deleteAnimal(Animal animal) {

    }

    @Override
    public void updateAnimal(Animal animal) {
        for(Animal a : getAllAnimals()) {
            if(a.getId().equals(animal.getId()))
            {
                Animal.delete(a);
                Animal.save(animal);
                return;
            }
        }

    }

    @Override
    public List<Animal> getAllAnimalsForBreed(String breed) {
        return Animal.find(Animal.class, "breed = ?", breed);
    }

}
