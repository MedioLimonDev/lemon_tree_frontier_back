package com.frontier.back.lemon_tree.data.dao;

import com.frontier.back.lemon_tree.data.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeDAOImpl implements EmployeeDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private StringBuilder sql;

    @Override
    public boolean loginValidation(Employee employee) throws DataAccessException {
        try{
            sql = new StringBuilder();
            sql.append(" SELECT count(*) FROM employee WHERE email LIKE '");
            sql.append(employee.getEmail());
            sql.append("' AND password = '");
            sql.append(employee.getPassword());
            sql.append("'");

            Integer count = jdbcTemplate.queryForObject(sql.toString(),Integer.class);

            if(count != 1)
                return false;
            else
                return true;

        } catch (Exception e){
            throw new DataAccessException(e.getMessage(), e) {
                @Override
                public String getMessage() {
                    return super.getMessage();
                }
            };
        }
    }

    @Override
    public Employee getEmployeeInformation(Employee employee) throws DataAccessException {
        try {
            sql = new StringBuilder();
            sql.append(" SELECT id, name, email  FROM employee WHERE email LIKE '");
            sql.append(employee.getEmail());
            sql.append("' AND fg_active = 1");

             List<Employee> employeeList = jdbcTemplate.query(sql.toString(),
                    (rs, rowNum) ->
                            new Employee(
                                    rs.getInt("id"),
                                    rs.getString("name"),
                                    rs.getString("email")
                            )

                    );

             if(employeeList != null){
                 return employeeList.get(0);
             } else {
                 return new Employee();
             }

        } catch (Exception e){
            throw new DataAccessException(e.getMessage(), e) {
                @Override
                public String getMessage() {
                    return super.getMessage();
                }
            };
        }
    }
}
