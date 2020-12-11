package com.frontier.back.lemon_tree.ws;

import com.frontier.back.lemon_tree.biz.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.frontier.back.lemon_tree.biz.vo.EmployeeVO;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@RestController
@RequestMapping("/login")
public class EmployeeWS {
    @Autowired
    private EmployeeDTO employeeDTO;

    @PostMapping("/get")
    public Response loginValidation(@RequestBody EmployeeVO employeeVO){
        boolean bandera = employeeDTO.loginValidation(employeeVO);
        return Response.status(Response.Status.OK)
                .entity(bandera)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}