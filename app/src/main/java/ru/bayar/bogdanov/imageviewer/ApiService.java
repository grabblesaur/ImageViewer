package ru.bayar.bogdanov.imageviewer;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Majo on 24.05.2017.
 */

public interface ApiService {

    @GET("list.php")
    Call<List<String>> getLinks();
}
