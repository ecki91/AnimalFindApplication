package hu.bme.aut.animalfindapplication.network.mock;

import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

import hu.bme.aut.animalfindapplication.model.animal.Animal;
import hu.bme.aut.animalfindapplication.model.user.User;
import hu.bme.aut.animalfindapplication.network.GsonHelper;
import hu.bme.aut.animalfindapplication.network.NetworkConfig;
import hu.bme.aut.animalfindapplication.other.BreedSearch;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

/**
 * Created by Norbert on 2016. 05. 15..
 */
public class NetworkMock {
    private static List<Animal> animalList = new ArrayList<>();
    private static List<User> userList = new ArrayList<>();
    private static boolean isInitialised = false;
    private static Animal animal1 = new Animal();
    private static Animal animal2 = new Animal();
    private static Animal animal3 = new Animal();
    private static User user1 = new User();
    private static long idSequenceForAnimal = 0;
    private static long idSequenceForUser = 0;
    private static User loggedInUser = new User();

    public static Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());
        String responseString;
        int responseCode;
        Headers headers = request.headers();
        if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "getAllAnimals") && request.method().equals("GET")) {
            return processGetAllAnimals(request);
        } else if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "createAnimal") && request.method().equals("POST")) {
            return processCreateAnimal(request);
        } else if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "createUser") && request.method().equals("POST")) {
            return processCreateUser(request);
        } else if(uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "getAnimalsForBreed") && request.method().equals("POST")) {
            return processGetAnimalsForBreed(request);
        } else if(uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "updateAnimal") && request.method().equals("POST")) {
            return processUpdateAnimal(request);
        } else if(uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "deleteAnimal") && request.method().equals("POST")) {
            return processDeleteAnimal(request);
        } else if(uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "logIn") && request.method().equals("POST")) {
            return processLogIn(request);
        } else {
            responseString = "ERROR";
            responseCode = 503;
            return MockHelper.makeResponse(request, headers, responseCode, responseString);
        }
    }

    private static Response processGetAllAnimals(Request request) {
        String responseString;
        int responseCode;
        Headers headers = request.headers();
        if (!isInitialised) {
            addThreeAnimal();
        }

        responseString = GsonHelper.getGson().toJson(animalList);
        responseCode = 200;
        return MockHelper.makeResponse(request, headers, responseCode, responseString);
    }

    private static Response processCreateAnimal(Request request) {
        String responseString;
        int responseCode;
        Headers headers = request.headers();
        try {
            final Buffer buffer = new Buffer();
            final RequestBody requestBody = request.body();
            if (requestBody != null) {
                requestBody.writeTo(buffer);
            }
            Animal animal = GsonHelper.getGson().getAdapter(Animal.class).fromJson(buffer.readUtf8());
            animal.setId(idSequenceForAnimal++);

            animal.setContactName(loggedInUser.getName());
            animalList.add(animal);
            responseString = "";
            responseCode = 200;
            return MockHelper.makeResponse(request, headers, responseCode, responseString);
        } catch(Exception e) {
            responseString = "";
            responseCode = 500;
            return MockHelper.makeResponse(request, headers, responseCode, responseString);
        }
    }

    private static Response processCreateUser(Request request) {
        String responseString;
        int responseCode;
        Headers headers = request.headers();
        try {
            final Buffer buffer = new Buffer();
            final RequestBody requestBody = request.body();
            if (requestBody != null) {
                requestBody.writeTo(buffer);
            }
            User user = GsonHelper.getGson().getAdapter(User.class).fromJson(buffer.readUtf8());
            user.setId(idSequenceForAnimal++);
            userList.add(user);
            loggedInUser = user;
            responseString = "";
            responseCode = 200;
            return MockHelper.makeResponse(request, headers, responseCode, responseString);
        } catch(Exception e) {
            responseString = "";
            responseCode = 500;
            return MockHelper.makeResponse(request, headers, responseCode, responseString);
        }
    }

    private static Response processUpdateAnimal(Request request) {

        String responseString;
        int responseCode;
        Headers headers = request.headers();
        try {
            final Buffer buffer = new Buffer();
            final RequestBody requestBody = request.body();
            if (requestBody != null) {
                requestBody.writeTo(buffer);
            }
            Animal animal = GsonHelper.getGson().getAdapter(Animal.class).fromJson(buffer.readUtf8());
            if(loggedInUser.getName().equals(animal.getContactName())) {
                for(Animal a : animalList) {
                    if(a.getId().equals(animal.getId()))
                    {
                        animalList.remove(a);
                        animalList.add(animal);;
                        responseString = "";
                        responseCode = 200;
                        return MockHelper.makeResponse(request, headers, responseCode, responseString);
                    }
                }
                responseString = "";
                responseCode = 404;
                return MockHelper.makeResponse(request, headers, responseCode, responseString);
            }

        } catch(Exception e) {
            responseString = "";
            responseCode = 500;
            return MockHelper.makeResponse(request, headers, responseCode, responseString);
        }
        responseString = "";
        responseCode = 200;
        return MockHelper.makeResponse(request, headers, responseCode, responseString);
    }

    private static Response processDeleteAnimal(Request request) {
        String responseString;
        int responseCode;
        Headers headers = request.headers();
        try {
            final Buffer buffer = new Buffer();
            final RequestBody requestBody = request.body();
            if (requestBody != null) {
                requestBody.writeTo(buffer);
            }
            Animal animal = GsonHelper.getGson().getAdapter(Animal.class).fromJson(buffer.readUtf8());
            animalList.remove(animal);
            responseString = "";
            responseCode = 200;
            return MockHelper.makeResponse(request, headers, responseCode, responseString);
        } catch(Exception e) {
            responseString = "";
            responseCode = 500;
            return MockHelper.makeResponse(request, headers, responseCode, responseString);
        }
    }

    private static Response processGetAnimalsForBreed(Request request) {
        String responseString;
        int responseCode;
        Headers headers = request.headers();
        try {
            final Buffer buffer = new Buffer();
            final RequestBody requestBody = request.body();
            if (requestBody != null) {
                requestBody.writeTo(buffer);
            }
            BreedSearch breedSearch = GsonHelper.getGson().getAdapter(BreedSearch.class).fromJson(buffer.readUtf8());

            List<Animal> returnList = new ArrayList<Animal>();
            if(breedSearch.getBreed().equals("")) {
                responseString = GsonHelper.getGson().toJson(animalList);
                responseCode = 200;
                return MockHelper.makeResponse(request, headers, responseCode, responseString);
            }
            for(Animal a : animalList) {
                if(a.getBreed().equals(breedSearch.getBreed())) {
                    returnList.add(a);
                }
            }
            responseString = GsonHelper.getGson().toJson(returnList);
            responseCode = 200;
            return MockHelper.makeResponse(request, headers, responseCode, responseString);
        } catch(Exception e) {
            responseString = "";
            responseCode = 500;
            return MockHelper.makeResponse(request, headers, responseCode, responseString);
        }



    }

    private static Response processLogIn(Request request) {
        String responseString;
        int responseCode;
        Headers headers = request.headers();
        try {
            final Buffer buffer = new Buffer();
            final RequestBody requestBody = request.body();
            if (requestBody != null) {
                requestBody.writeTo(buffer);
            }
            User user = GsonHelper.getGson().getAdapter(User.class).fromJson(buffer.readUtf8());

            if(user == null) {
                responseString = "";
                responseCode = 404;
                return MockHelper.makeResponse(request, headers, responseCode, responseString);
            }
            for(User u : userList) {
                if((u.getName().equals(user.getName()) && (u.getPassword().equals(user.getPassword())))) {
                    loggedInUser = user;
                    responseString = GsonHelper.getGson().toJson(animalList);
                    responseCode = 200;
                    return MockHelper.makeResponse(request, headers, responseCode, responseString);
                }
            }
            responseString = "";
            responseCode = 401;
            return MockHelper.makeResponse(request, headers, responseCode, responseString);
        } catch(Exception e) {
            responseString = "";
            responseCode = 500;
            return MockHelper.makeResponse(request, headers, responseCode, responseString);
        }
    }

    public static void deleteAnimalList() {
        if(animalList != null) {
            animalList.clear();
        } else {
            animalList = new ArrayList<Animal>();
        }
        isInitialised = false;
    }

    public static void addThreeAnimal() {
        Animal animal1 = new Animal();
        animal1.setId(100l);
        animal1.setAdvertisementTitle("Network Berci");
        animal1.setLostOrFound("eltűnt");
        animal1.setCity("Budapest");
        animal1.setSpecies("kutya");
        animal1.setBreed("vizsla");
        animal1.setDate("2016-04-11");
        animal1.setContactName("alma");

        Animal animal2 = new Animal();
        animal2.setId(102l);
        animal2.setAdvertisementTitle("Network Cica");
        animal2.setLostOrFound("megtalált");
        animal2.setCity("Siófok");
        animal2.setSpecies("macska");
        animal2.setBreed("házi");
        animal2.setDate("2016-03-22");
        animal2.setContactName("alma");

        Animal animal3 = new Animal();
        animal3.setId(103l);
        animal3.setAdvertisementTitle("Network Pindur");
        animal3.setLostOrFound("megtalált");
        animal3.setCity("Siófok");
        animal3.setSpecies("macska");
        animal3.setBreed("házi");
        animal3.setDate("2016-03-23");
        animal3.setContactName("alma");
        animalList.add(animal1);
        animalList.add(animal2);
        animalList.add(animal3);
        isInitialised = true;
    }

    public static void setLoggedInUser(User u) {
        loggedInUser = u;
    }

    public static User getLoggedInUser() {
        return loggedInUser;
    }

}
