package com.tony.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tony.commons.response.BaseResponse;
import com.tony.model.UserModel;
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class UserResponse extends BaseResponse{
	private UserModel user;

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}
	
	
}
