package com.api.library.test.configurations;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;

import com.api.library.test.dto.LoginResponseDTO;

public abstract class AbstractTest {

	protected String getToken() throws ClientProtocolException, IOException {

		HttpPost httpPost = new HttpPost("http://localhost:9000/oauth/token?grant_type=password&username="
				+ "admin@library.com" + "&password=" + "1234567");
		httpPost.addHeader("authorization", "Basic d2ViOjEyMw==");

		HttpResponse response = HttpClientBuilder.create().build().execute(httpPost);

		LoginResponseDTO resource = RetrieveUtil.retrieveResourceFromResponse(response, LoginResponseDTO.class);
		return resource.getAccess_token();
	}

	protected HttpPost getAuthenticationHeader(HttpPost httpPost) throws ClientProtocolException, IOException {
		httpPost.addHeader("authorization", "bearer " + this.getToken());
		return httpPost;
	}

}
