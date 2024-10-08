package org.northcoders.recordshopapp.service;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstanceProvider {
    private static Retrofit retrofit = null;

//    private static final String BASE_URL = "https://127.0.0.1:8080/";
    private static final String BASE_URL = "http://record-shop-api-env.eba-nahrmp8h.eu-west-2.elasticbeanstalk.com/";


    private static Retrofit getRetrofitInstance() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }

        return retrofit;
    }
    public static <T> T getService(Class<T> apiServiceClass) {
        return getRetrofitInstance().create(apiServiceClass);
    }
}
