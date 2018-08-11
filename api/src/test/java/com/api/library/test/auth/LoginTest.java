package com.api.library.test.auth;

import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.api.library.models.User;
import com.api.library.resources.UserRepository;
import com.api.library.services.UserService;
import com.api.library.test.configurations.RetrieveUtil;
import com.api.library.test.dto.LoginResponseDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class LoginTest {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	User user = new User();

	@Before
	public void createUser() {

		this.user.setName("User 1");
		this.user.setEmail("user@email.com");
		this.user.setPassword("1234567");
		this.user.setPasswordConfirmation("1234567");

		this.userService.save(this.user);
		this.userRepository.save(this.user);
	}

	@Test
	public void test() throws ClientProtocolException, IOException {
		HttpPost httpPost = new HttpPost("http://localhost:9000/oauth/token?grant_type=password&username="
				+ this.user.getEmail() + "&password=" + this.user.getPassword());
		httpPost.addHeader("authorization", "Basic d2ViOjEyMw==");

		HttpResponse response = HttpClientBuilder.create().build().execute(httpPost);

		LoginResponseDTO resource = RetrieveUtil.retrieveResourceFromResponse(response, LoginResponseDTO.class);

		assertThat(this.user.getName(), Matchers.is(resource.getName()));
	}

	@After
	public void deleteUser() {
		this.userRepository.delete(user);
	}

}
