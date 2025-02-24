package com.bocktom.utils.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StatementBuilder {

	private final PreparedStatement statement;

	public StatementBuilder(Connection con, InputStream input) throws SQLException, IOException {
		String sql = new String(input.readAllBytes());

		statement = con.prepareStatement(sql);
	}

	public StatementBuilder setInt(int parameterIndex, int value) throws SQLException {
		statement.setInt(parameterIndex, value);
		return this;
	}

	public StatementBuilder setBytes(int parameterIndex, byte[] value) throws SQLException {
		statement.setBytes(parameterIndex, value);
		return this;
	}

	public StatementBuilder setLong(int parameterIndex, long amount) throws SQLException {
		statement.setLong(parameterIndex, amount);
		return this;
	}


	public StatementBuilder setString(int parameterIndex, String text) throws SQLException {
		statement.setString(parameterIndex, text);
		return this;
	}

	public int executeUpdate() throws SQLException {
		return statement.executeUpdate();
	}

	public ResultSet executeQuery() throws SQLException {
		return statement.executeQuery();
	}
}
