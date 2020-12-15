package com.frontier.back.lemon_tree.data.dao;

import com.frontier.back.lemon_tree.data.entity.Employee;
import org.springframework.dao.DataAccessException;

public interface EmployeeDAO {
    boolean loginValidation(Employee employee);

    Employee getEmployeeInformation(Employee employee) throws DataAccessException;
}
