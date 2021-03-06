package com.example.mpi2_maps;

import java.security.acl.Owner;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface GitHubClient {

    @GET("/users/{user}/repos")
    Call<List<GitHubDet>> reposForuser(@Path("user") String user);

    @GET("/users/user/repos")
    Call<List<GitHubDet>> reposLogin(@Header("owner") Owner owner);
}