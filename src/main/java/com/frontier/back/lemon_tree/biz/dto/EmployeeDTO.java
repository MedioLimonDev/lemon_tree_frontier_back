package com.frontier.back.lemon_tree.biz.dto;

import com.frontier.back.lemon_tree.biz.vo.EmployeeVO;

public interface EmployeeDTO {
    boolean loginValidation(EmployeeVO employeeVO);

    EmployeeVO getEmployeeInformation(EmployeeVO employeeVO);
}
