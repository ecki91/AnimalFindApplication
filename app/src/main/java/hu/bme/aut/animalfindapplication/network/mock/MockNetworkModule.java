package hu.bme.aut.animalfindapplication.network.mock;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.bme.aut.animalfindapplication.network.AnimalFindApi;
import hu.bme.aut.animalfindapplication.network.live.NetworkModule;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;

/**
 * Created by Norbert on 2016. 05. 15..
 */
@Module
public class MockNetworkModule {
    private NetworkModule networkModule = new NetworkModule();

    @Provides
    @Singleton
    public OkHttpClient.Builder provideOkHttpClientBuilder() {
        return networkModule.provideOkHttpClientBuilder();
    }


    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder) {
        builder.interceptors().add(0, new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                return MockHttpServer.call(request);
            }
        });
        return builder.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient client) {
        return networkModule.provideRetrofit(client);
    }

    @Provides
    @Singleton
    public AnimalFindApi provideDefaultApi(Retrofit retrofit) {
        return retrofit.create(AnimalFindApi.class);
    }
}
