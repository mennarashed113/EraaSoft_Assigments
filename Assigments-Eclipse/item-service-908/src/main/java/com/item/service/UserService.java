package com.item.service;

import com.item.model.User;

public interface UserService {
	  boolean registerUser(User user);
	   User loginUser(String username, String password);
}
