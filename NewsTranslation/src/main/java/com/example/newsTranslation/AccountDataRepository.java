package com.example.newsTranslation;

import java.sql.SQLException;

public interface AccountDataRepository {
	NewsDB newsDB = new NewsDB();
	
	public void getAccountData(String name ,String password)  throws SQLException;
	public void createAccountData(String name, String password) throws SQLException;

	public String findByName();
	
	public String findByPassword();
};