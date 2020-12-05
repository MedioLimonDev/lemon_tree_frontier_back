package com.frontier.back.lemon_tree.ws;

import com.frontier.back.lemon_tree.biz.dto.FlowRecordDTO;
import com.frontier.back.lemon_tree.biz.vo.FlowRecordVO;
import com.frontier.back.lemon_tree.biz.vo.NotesVO;
import com.frontier.back.lemon_tree.biz.vo.RecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@RequestMapping("/flow-record")
public class FlowRecordWS {
    @Autowired
    private FlowRecordDTO flowRecordDTO;

    @PostMapping("/done-flow-record")
    public Response doneFlowRecord(@RequestBody RecordVO recordVO) {
        List<NotesVO> list = flowRecordDTO.doneRecord(recordVO.getId());
        return Response.status(Response.Status.OK)
                .entity(list)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

    @PostMapping("/save")
    public Response saveFlowRecord(@RequestBody FlowRecordVO flowRecordVO){
        flowRecordDTO.saveFlowRecord(flowRecordVO);
        return Response.status(Response.Status.OK)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }//Checar que aquí no va el entity
}