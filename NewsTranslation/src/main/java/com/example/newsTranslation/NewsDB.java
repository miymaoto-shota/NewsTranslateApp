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

	private int parametarCount = 0;

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
			this.parametarCount = 0;
			prepareStmt.clearParameters();
			conn.close();
		} catch (SQLException e) {
			System.out.print(e.getMessage());
		}
	}

	public void SetSql(String sql) throws SQLException {
		prepareStmt = conn.prepareStatement(sql);
	}

	public void setParameters(String data) throws SQLException {
		this.parametarCount++;
		prepareStmt.setString(this.parametarCount, data);
	}

	// データ取得
	public void Select() throws SQLException {
		rs = prepareStmt.executeQuery();
	}

	// データ追加,更新,削除
	public void ExecuteUpdate() throws SQLException {
		prepareStmt.executeUpdate();
		this.Close();
	}

	public ResultSet getResultSet() {
		return rs;
	}
}
