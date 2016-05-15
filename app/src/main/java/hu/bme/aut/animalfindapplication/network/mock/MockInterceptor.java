package hu.bme.aut.animalfindapplication.network.mock;

import android.net.Uri;
import android.util.Log;

import java.io.IOException;

import hu.bme.aut.animalfindapplication.network.NetworkConfig;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Norbert on 2016. 05. 15..
 */
public class MockInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        return process(chain.request());
    }

    public Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());
        Log.d("Test Http Client", "URL call: " + uri.toString());
        Headers headers = request.headers();
        if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "getAllAnimals") ||
                uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "createAnimal") ||
                uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "updateAnimal") ||
                uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "deleteAnimal") ||
                uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "getAnimalsForBreed") ||
                uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "createUser") ||
                uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "logIn") ) {
            return NetworkMock.process(request);
        } else {
            return MockHelper.makeResponse(request, headers, 404, "Unknown");
        }
    }
}
