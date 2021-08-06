package com.example.newsTranslation;

import java.sql.SQLException;

public class AccountData implements AccountDataRepository {
	AccountDataManager accountDataManager = new AccountDataManager();

	@Override
	public void getAccountData(String name, String password) throws SQLException {

		String sql = "";
		sql = "select * from accountlist where name = ? ";
		if (!password.equals("")) {
			sql += " and password = ?";
		}

		newsDB.SetSql(sql);

		newsDB.setParameters(name);
		newsDB.setParameters(password);

		while (newsDB.getResultSet().next()) {
			accountDataManager.setName(newsDB.getResultSet().getString("name"));
			accountDataManager.setPassword(newsDB.getResultSet().getString("password"));
		}
	}

	@Override
	public void createAccountData(String name, String password) throws SQLException {

		String sql = "";
		sql = "insert into accountlist value( ?, ?);";

		newsDB.SetSql(sql);

		newsDB.setParameters(name);
		newsDB.setParameters(password);
	}

	@Override
	public String findByName() {
		return accountDataManager.getName();
	}

	@Override
	public String findByPassword() {
		return accountDataManager.getPassword();
	}
}
