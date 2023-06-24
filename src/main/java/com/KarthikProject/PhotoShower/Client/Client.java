package com.KarthikProject.PhotoShower.Client;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.*;

public class Client {
	OkHttpClient client = new OkHttpClient();
	private String url;
	public Client(String URL){
		this.url=URL;
	}
	public String run() throws IOException {
		Request request = new Request.Builder()
				.url(this.url)
				.build();

		try (Response response = client.newCall(request).execute()) {
			return response.body().string();
		}

	}
}
