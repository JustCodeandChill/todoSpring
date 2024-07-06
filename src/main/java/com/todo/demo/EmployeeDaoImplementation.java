package com.todo.demo;

import org.springframework.boot.availability.ReadinessState;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDaoImplementation implements EmployeeDAO{
    @Override
    public Employee get(int id) throws SQLException {
        Connection con = Database.getConnection();
        Employee e = null;
        try {



            String sql = "SELECT id, employeeId, fName, lName, departmentId FROM employee WHERE id = ?";

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                int oid = rs.getInt("id");
                int eid = rs.getInt("employeeId");
                String fName = rs.getString("fName");
                String lName = rs.getString("lName");
                int did = rs.getInt("departmentId");
                e = new Employee(oid, eid, fName, lName, did);
            }



        } catch (SQLException er) {
            er.printStackTrace();
        } finally {

            Database.closeConnection(con);
        }

        return e;
    }

    @Override
    public List<Employee> getAll() throws SQLException {
        return List.of();
    }

    @Override
    public int save(Employee employee) throws SQLException {
        return 0;
    }

    @Override
    public int insert(Employee employee) throws SQLException {
        return 0;
    }

    @Override
    public int update(Employee employee) throws SQLException {
        return 0;
    }

    @Override
    public int delete(int id) throws SQLException {
        return 0;
    }
}
