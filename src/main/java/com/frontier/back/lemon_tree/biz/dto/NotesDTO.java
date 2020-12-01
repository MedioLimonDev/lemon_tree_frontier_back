package com.frontier.back.lemon_tree.biz.dto;

import com.frontier.back.lemon_tree.biz.vo.NotesVO;

import java.util.List;

public interface NotesDTO {
    List<NotesVO> getByIdRecord(int idRecord);

    void addNote(String note, int id_flow_record);
}
