package com.frontier.back.lemon_tree.ws;

import com.frontier.back.lemon_tree.biz.dto.FlowRecordDTO;
import com.frontier.back.lemon_tree.biz.vo.FlowRecordVO;
import com.frontier.back.lemon_tree.biz.vo.NotesVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@RequestMapping("/flow-record")
public class FlowRecordWS {
    @Autowired
    private FlowRecordDTO flowRecordDTO;

    @PostMapping("/{idRecord}")
    public List<NotesVO> doneFlowRecord(@PathVariable int idRecord) {
        return flowRecordDTO.doneRecord(idRecord);
    }

    @PostMapping("/save")
    public void saveFlowRecord(@RequestBody FlowRecordVO flowRecordVO){
        flowRecordDTO.saveFlowRecord(flowRecordVO);
    }
}