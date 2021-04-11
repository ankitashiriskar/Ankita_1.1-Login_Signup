package com.login.register;

public interface UserDAO {

	public int insertUser(User user);

	public User getUser(String username, String password);
}
