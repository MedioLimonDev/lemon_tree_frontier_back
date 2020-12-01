package com.frontier.back.lemon_tree.data.dao;

import com.frontier.back.lemon_tree.data.entity.Notes;

import java.util.List;

public interface NotesDAO{
    void addNote(String note, int id_flow_record);

    List<Notes> getByIdRecord(int idRecord);
}
