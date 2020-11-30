package com.frontier.back.lemon_tree.biz.dto;

import com.frontier.back.lemon_tree.biz.vo.EmployeeVO;
import com.frontier.back.lemon_tree.data.dao.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDTOImpl implements EmployeeDTO {
    @Autowired
    EmployeeDAO employeeDAO;

    @Override
    public boolean loginValidation(EmployeeVO employeeVO) {
        return employeeDAO.loginValidation(employeeVO);
    }
}
