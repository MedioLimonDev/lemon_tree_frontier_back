package com.frontier.back.lemon_tree.data.dao;

import com.frontier.back.lemon_tree.biz.vo.EmployeeVO;

public interface EmployeeDAO {
    boolean loginValidation(EmployeeVO employeeVO);
}
