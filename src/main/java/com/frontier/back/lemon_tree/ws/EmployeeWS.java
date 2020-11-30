package com.frontier.back.lemon_tree.ws;

import com.frontier.back.lemon_tree.biz.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.frontier.back.lemon_tree.biz.vo.EmployeeVO;

@RestController
@RequestMapping("/login")
public class EmployeeWS {
    @Autowired
    private EmployeeDTO employeeDTO;

    @PostMapping("/")
    public boolean loginValidation(@RequestBody EmployeeVO employeeVO){
        return employeeDTO.loginValidation(employeeVO);
    }
}