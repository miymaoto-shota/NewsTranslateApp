package com.example.newsTranslation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NewsDB {
	private Connection conn = null;
	private PreparedStatement prepareStmt = null;
	private Statement stmt = null;
	private ResultSet rs = null;

	// DB接続
	public boolean Connect() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newsdb", "root", "88884444MMmm0000");
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	// DB切断
	public void Close() {
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}
	}

	// データ取得
	public boolean Select(String sql) {
		try {
			prepareStmt = conn.prepareStatement(sql);
			rs = prepareStmt.executeQuery();
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	// データ追加,更新,削除
	public boolean ExecuteUpdate(String sql) {
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	public ResultSet getResultSet() {
		return rs;
	}
}
