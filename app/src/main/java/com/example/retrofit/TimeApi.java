package com.example.retrofit;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
public interface TimeApi {
    @GET("prices?key=5948f72ffc31e867c8ee94103f5b7f621b7a5caf")
    Call <List<TimeAze>> gettime();
}

