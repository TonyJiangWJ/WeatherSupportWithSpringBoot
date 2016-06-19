package com.tony.facade;

import com.tony.request.UserRequest;
import com.tony.response.UserResponse;

public interface LoginFacade {
	public UserResponse login(UserRequest request);
	public UserResponse register(UserRequest request);
	public UserResponse updateInfo(UserRequest request);
	public UserResponse reSetPassword(UserRequest request);
}
