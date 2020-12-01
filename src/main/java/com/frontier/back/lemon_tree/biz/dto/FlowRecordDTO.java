package com.frontier.back.lemon_tree.biz.dto;

import com.frontier.back.lemon_tree.biz.vo.FlowRecordVO;
import com.frontier.back.lemon_tree.biz.vo.NotesVO;

import java.util.List;

public interface FlowRecordDTO {
    List<NotesVO> doneRecord(int idRecord);
    void saveFlowRecord(FlowRecordVO flowRecordVO);
}
