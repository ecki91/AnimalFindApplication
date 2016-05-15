package hu.bme.aut.animalfindapplication.network.mock;

import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Norbert on 2016. 05. 15..
 */
public class MockHttpServer {
    public static Response call(Request request) {
        MockInterceptor mockInterceptor = new MockInterceptor();
        return mockInterceptor.process(request);
    }
}


