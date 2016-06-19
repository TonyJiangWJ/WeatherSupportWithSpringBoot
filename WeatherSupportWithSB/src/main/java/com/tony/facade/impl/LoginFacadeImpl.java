package com.tony.facade.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tony.commons.DateUtil;
import com.tony.commons.Md5Utils;
import com.tony.commons.ResultCodeDesc;
import com.tony.commons.ResultMessageDesc;
import com.tony.entity.User;
import com.tony.facade.LoginFacade;
import com.tony.model.UserModel;
import com.tony.request.UserRequest;
import com.tony.response.UserResponse;
import com.tony.service.UserService;
@Service("loginFacade")
public class LoginFacadeImpl implements LoginFacade {
	@Autowired
	private UserService userService;
	private Logger logger = LoggerFactory.getLogger(LoginFacadeImpl.class);

	@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
	@Override
	public UserResponse login(UserRequest request) {
		UserResponse response = new UserResponse();
		response.setResultCode(ResultCodeDesc.ERROR);
		response.setResultMsg(ResultMessageDesc.ERROR);
		try {
			if (StringUtils.isEmpty(request.getUserName()) || StringUtils.isEmpty(request.getPassword())) {
				response.setResultCode(ResultCodeDesc.PARAMS_ERROR);
				response.setResultMsg(ResultMessageDesc.PARAMS_ERROR);
				return response;
			}
			User record = new User();
			record.setUsername(request.getUserName());
			record.setPassword(password(request.getPassword()));
			logger.info("LoginRequest:{}",JSON.toJSONString(request));
			if (userService.find(record) == null) {
				response.setResultCode(ResultCodeDesc.USER_ERROR);
				response.setResultMsg(ResultMessageDesc.USER_ERROR);
				return response;
			} else {
				record = userService.find(record);
				UserModel model = new UserModel();
				model.setImage(record.getImage());
				model.setLastLogin(record.getLastLogin());
				model.setPhone(record.getPhone());
				model.setName(record.getName());
				model.setUserName(record.getUsername());
				model.setSex(record.getSex());
				record.setLastLogin(DateUtil.GetDateString());
				userService.updateByPrimaryKey(record);
				response.setResultCode(ResultCodeDesc.SUCCESS);
				response.setResultMsg(ResultMessageDesc.SUCCESS);
				response.setUser(model);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setResultMsg(ResultMessageDesc.SYSTEM_ERROR);
			response.setResultCode(ResultCodeDesc.SYSTEM_ERROR);
		}
		return response;
	}

	@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
	@Override
	public UserResponse register(UserRequest request) {
		UserResponse response = new UserResponse();
		response.setResultCode(ResultCodeDesc.ERROR);
		response.setResultMsg(ResultMessageDesc.ERROR);
		try {
			if (StringUtils.isEmpty(request.getUserName()) || StringUtils.isEmpty(request.getPassword())) {
				response.setResultCode(ResultCodeDesc.PARAMS_ERROR);
				response.setResultMsg(ResultMessageDesc.PARAMS_ERROR);
				return response;
			}
			User record = new User();
			record.setUsername(request.getUserName());
			if (userService.find(record) != null) {
				response.setResultCode(ResultCodeDesc.USER_EXIST);
				response.setResultMsg(ResultMessageDesc.USER_EXIST);
				return response;
			}
			logger.info("password:{},afterMD5:{}",request.getPassword(),password(request.getPassword()));
			record.setPassword(password(request.getPassword()));
			logger.info("register:user{}",record);
			if (userService.save(record) > 0) {
				
				response.setResultCode(ResultCodeDesc.SUCCESS);
				response.setResultMsg(ResultMessageDesc.SUCCESS);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setResultCode(ResultCodeDesc.SYSTEM_ERROR);
			response.setResultMsg(ResultMessageDesc.SYSTEM_ERROR);
		}
		return response;
	}

	@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
	@Override
	public UserResponse updateInfo(UserRequest request) {

		UserResponse response = new UserResponse();
		response.setResultCode(ResultCodeDesc.ERROR);
		response.setResultMsg(ResultMessageDesc.ERROR);
		try {

			if (StringUtils.isEmpty(request.getPassword()) || StringUtils.isEmpty(request.getUserName())) {
				response.setResultCode(ResultCodeDesc.PARAMS_ERROR);
				response.setResultMsg(ResultMessageDesc.PARAMS_ERROR);
				return response;
			}
			User record = new User();
			record.setUsername(request.getUserName());
			record.setPassword(password(request.getPassword()));
			record = userService.find(record);
			if (record == null) {
				response.setResultCode(ResultCodeDesc.USER_ERROR);
				response.setResultMsg(ResultMessageDesc.USER_ERROR);
				return response;
			} else {
				if (StringUtils.isEmpty(request.getLogo()) == false) {
					record.setImage(request.getLogo());
				}
				if (StringUtils.isEmpty(request.getName()) == false) {
					record.setName(request.getName());
				}
				if (StringUtils.isEmpty(request.getPhone()) == false) {
					record.setPhone(request.getPhone());
				}
				if (StringUtils.isEmpty(request.getSex()) == false) {
					record.setSex(request.getSex());
				}
				if (userService.updateByPrimaryKey(record) > 0) {
					response.setResultCode(ResultCodeDesc.SUCCESS);
					response.setResultMsg(ResultMessageDesc.SUCCESS);
					return response;
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setResultCode(ResultCodeDesc.SYSTEM_ERROR);
			response.setResultMsg(ResultMessageDesc.SYSTEM_ERROR);
		}
		return response;
	}

	@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
	@Override
	public UserResponse reSetPassword(UserRequest request) {
		UserResponse response = new UserResponse();
		response.setResultCode(ResultCodeDesc.ERROR);
		response.setResultMsg(ResultMessageDesc.ERROR);
		try {
			if(StringUtils.isEmpty(request.getUserName())
					||StringUtils.isEmpty(request.getPassword())
					||StringUtils.isEmpty(request.getNewPassword())){
				response.setResultCode(ResultCodeDesc.PARAMS_ERROR);
				response.setResultMsg(ResultMessageDesc.PARAMS_ERROR);
				return response;
			}
			
			User record = new User();
			record.setPassword(password(request.getPassword()));
			record.setUsername(request.getUserName());
			record=userService.find(record);
			if(record==null){
				response.setResultCode(ResultCodeDesc.USER_ERROR);
				response.setResultMsg(ResultMessageDesc.USER_ERROR);
				return response;
			}
			record.setPassword(password(request.getNewPassword()));
			
			if(userService.updateByPrimaryKey(record)>0){
				response.setResultCode(ResultCodeDesc.SUCCESS);
				response.setResultMsg(ResultMessageDesc.SUCCESS);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setResultCode(ResultCodeDesc.SYSTEM_ERROR);
			response.setResultMsg(ResultMessageDesc.SYSTEM_ERROR);
		}
		return response;
	}

	private String password(String password) {
		return Md5Utils.md5(Md5Utils.md5(password));
	}
}
