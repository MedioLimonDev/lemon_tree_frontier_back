package com.frontier.back.lemon_tree.data.dao;

import com.frontier.back.lemon_tree.data.entity.Notes;

import java.util.List;

public interface NotesDAO{
    List<Notes> getByIdRecord(int idRecord);
}
