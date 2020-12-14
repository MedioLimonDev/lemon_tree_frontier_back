package com.frontier.back.lemon_tree.ws;

import com.frontier.back.lemon_tree.biz.dto.RecordDTO;
import com.frontier.back.lemon_tree.biz.vo.EmployeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RestController
@RequestMapping("/record")
public class RecordWS {
    @Autowired
    private RecordDTO recordDTO;

    @PostMapping("/save")
    public Response addRecord(@RequestBody EmployeeVO employeeVO){
        recordDTO.addRecord(employeeVO.getId());
        int responseInt = recordDTO.getRecord(employeeVO.getId());
        return Response.status(Response.Status.OK)
                .entity(responseInt)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}