package com.frontier.back.lemon_tree.ws;

import com.frontier.back.lemon_tree.biz.dto.StepDTO;
import com.frontier.back.lemon_tree.biz.input.StepGetInput;
import com.frontier.back.lemon_tree.biz.vo.StepVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RestController
@RequestMapping("/step")
public class StepWS {
    @Autowired
    private StepDTO stepDTO;

    @PostMapping("/get")
    public Response get(@RequestBody StepGetInput stepGetInput){
        StepVO newStepVO = stepDTO.getStep(stepGetInput.getIdNextStep());

        return Response.status(Response.Status.OK)
                .entity(newStepVO)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
