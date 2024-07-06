package com.todo.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(DemoApplication.class, args);
		Connection connection = Database.getConnection();

		if (connection != null) {
			System.out.println("connected");
		}

		EmployeeDAO employeeDAO = new EmployeeDaoImplementation();

		Employee e = employeeDAO.get(1);

		System.out.println(e);
	}

}
