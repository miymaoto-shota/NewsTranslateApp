package com.example.newsTranslation;

import java.sql.SQLException;

public class AccountData {
	private String name;
	private String password;
	private NewsDB newsDB;

	public boolean getAccountData(String name, String password) {
		NewsDB newsDB = new NewsDB();
		if (!newsDB.Connect()) {
			newsDB.Close();
			newsDB = null;
			return false;
		}

		String sql = "";
		sql = "select * from accountlist where name = '" + name + "'";
		if (!password.equals("")) {
			sql += " and password = '" + password + "'";
		}

		newsDB.Select(sql);

		try {
			while (newsDB.getResultSet().next()) {
				this.name = newsDB.getResultSet().getString("name");
				this.password = newsDB.getResultSet().getString("password");
			}
		} catch (SQLException e) {
			newsDB.Close();
			newsDB = null;
			return false;
		}
		newsDB.Close();
		newsDB = null;
		return true;
	}

	public boolean createAccountData(String name, String password) {
		NewsDB newsDB = new NewsDB();
		if (!newsDB.Connect()) {
			newsDB.Close();
			newsDB = null;
			return false;
		}
		String sql = "";
		sql = "insert into accountlist value( '" + name + "', " + "'" + password + "');";

		if (!newsDB.ExecuteUpdate(sql)) {
			newsDB.Close();
			newsDB = null;
			return false;
		}
		return true;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}
}
