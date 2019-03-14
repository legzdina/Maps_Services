package com.example.mpi2_maps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GithubRepo extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github_repo);
        listView = (ListView) findViewById(R.id.list_item);

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        GitHubClient client = retrofit.create(GitHubClient.class);
        Call<List<GitHubDet>> call = client.reposForuser("legzdina");
        call.enqueue(new Callback<List<GitHubDet>>() {
            @Override
            public void onResponse(Call<List<GitHubDet>> call, Response<List<GitHubDet>> response) {
                List<GitHubDet> repos = response.body();
                listView.setAdapter(new GitHubRepoAdapter(GithubRepo.this, -1, repos));
            }

            @Override
            public void onFailure(Call<List<GitHubDet>> call, Throwable t) {
                Toast.makeText(GithubRepo.this, "ERROR IT IS!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}







