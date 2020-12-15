package com.frontier.back.lemon_tree.ws;

import com.frontier.back.lemon_tree.biz.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.frontier.back.lemon_tree.biz.vo.EmployeeVO;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@RestController
@RequestMapping("/employee")
public class EmployeeWS {
    @Autowired
    private EmployeeDTO employeeDTO;

    @PostMapping("/login")
    public Response loginValidation(@RequestBody EmployeeVO employeeVO){
        boolean bandera = employeeDTO.loginValidation(employeeVO);
        return Response.status(Response.Status.OK)
                .entity(bandera)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

    @PostMapping("/get_employee_information")
    public Response getEmployeeInformation(@RequestBody EmployeeVO employeeVO){
        EmployeeVO employeeResponse = employeeDTO.getEmployeeInformation(employeeVO);
        return Response.status(Response.Status.OK)
                .entity(employeeResponse)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}