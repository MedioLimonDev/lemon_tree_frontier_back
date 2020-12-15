package com.frontier.back.lemon_tree.biz.dto;

import com.frontier.back.lemon_tree.biz.vo.EmployeeVO;
import com.frontier.back.lemon_tree.data.dao.EmployeeDAO;
import com.frontier.back.lemon_tree.data.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDTOImpl implements EmployeeDTO {
    @Autowired
    EmployeeDAO employeeDAO;

    @Override
    public boolean loginValidation(EmployeeVO employeeVO) {
        return employeeDAO.loginValidation(build(employeeVO));
    }

    @Override
    public EmployeeVO getEmployeeInformation(EmployeeVO employeeVO) {
        return buildVO(employeeDAO.getEmployeeInformation(build(employeeVO)));
    }

    private Employee build(EmployeeVO employeeVO){
        if (employeeVO != null){
            Employee employee = new Employee();
            employee.setId(employeeVO.getId());
            employee.setName(employeeVO.getName());
            employee.setEmail(employeeVO.getEmail());
            employee.setPassword(employeeVO.getPassword());

            return employee;
        }
        return new Employee();
    }

    private EmployeeVO buildVO(Employee employee){
        if (employee != null){
            EmployeeVO employeeVO = new EmployeeVO();
            employeeVO.setId(employee.getId());
            employeeVO.setName(employee.getName());
            employeeVO.setEmail(employee.getEmail());
            employeeVO.setPassword(employee.getPassword());

            return employeeVO;
        }
        return new EmployeeVO();
    }
}
