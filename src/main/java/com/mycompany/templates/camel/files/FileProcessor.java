package com.mycompany.templates.camel.files;

import java.io.File;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.Message;

public class FileProcessor implements Processor {

	private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	@Override
	public void process(Exchange exchange) {
		try {
			Message message = exchange.getIn();
			File fileToProcess = message.getBody(File.class);
			saveFileInDB(fileToProcess);
		} catch (Exception e) {
			System.err.println("Exception while trying to process file: " + e);
		}
	}

	private void saveFileInDB(File fileToProcess) {
		String hostName = "mcwtest.database.windows.net";
		String dbName = "testd";
		String user = "bizadmin";
		String password = "4rMhaBGwXUQPhsnWCzcKsqnm";
		String url = String.format(
				"jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;"
						+ "hostNameInCertificate=*.database.windows.net;loginTimeout=30;",
				hostName, dbName, user, password);
		// String dbURL =
		// "jdbc:sqlserver://DESKTOP-I0ES2FG\\SQLEXPRESS;databaseName=Documents;user=admon;password=admon";
		//String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=master;user=sa;password=your_password";
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url);
			String[] partsFileName = fileToProcess.getName().split("_");
			String selectSql = String.format(
					"INSERT INTO Document (IdNumberClient, Name, FullPath, ModifiedDate) VALUES ('%s', '%s','%s','%s')",
					partsFileName[0], partsFileName[1], fileToProcess.getAbsolutePath(), sdf.format(new Date()));
			try (Statement statement = connection.createStatement()) {
				statement.execute(selectSql);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null && !connection.isClosed())
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
