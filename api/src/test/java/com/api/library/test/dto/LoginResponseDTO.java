package com.api.library.test.dto;

import java.util.Calendar;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class LoginResponseDTO {

	private Long id;
	private String name;

	private String access_token;
	private String refresh_token;
	private String token_type;
	private String scope;
	private String jti;

	private Calendar expires_in;

}
