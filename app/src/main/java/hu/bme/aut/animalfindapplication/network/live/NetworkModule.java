package hu.bme.aut.animalfindapplication.network.live;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.bme.aut.animalfindapplication.network.AnimalFindApi;
import hu.bme.aut.animalfindapplication.network.NetworkConfig;
import okhttp3.OkHttpClient;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by Norbert on 2016. 05. 15..
*/
@Module
public class NetworkModule {
    @Provides
    @Singleton
    public OkHttpClient.Builder provideOkHttpClientBuilder() {
        OkHttpClient.Builder clientBuilder = null;
        try {
            clientBuilder = UnsafeClientFactory.getUnsafeClient();
        } catch (Exception ignore) {}
        if (clientBuilder == null) {
            throw new RuntimeException("HttpClient cannot be initialized!");
        }
        return clientBuilder;
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder) {
        return builder.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient client) {
        return new Retrofit.Builder().baseUrl(NetworkConfig.SERVICE_ENDPOINT).client(client).addConverterFactory(GsonConverterFactory.create()).build();
    }

    @Provides
    @Singleton
    public AnimalFindApi provideDefaultApi(Retrofit retrofit) {
        return retrofit.create(AnimalFindApi.class);
    }
}
