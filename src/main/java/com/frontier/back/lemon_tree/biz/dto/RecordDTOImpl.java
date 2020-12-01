package com.frontier.back.lemon_tree.biz.dto;

import com.frontier.back.lemon_tree.data.dao.RecordDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordDTOImpl implements RecordDTO{
    @Autowired
    RecordDAO recordDAO;

    @Override
    public void doneRecord(int idRecord) {
        recordDAO.doneRecord(idRecord);
    }

    @Override
    public void addRecord(int idEmployee) {
        recordDAO.addRecord(idEmployee);
    }

    @Override
    public int getRecord(int idEmployee) {
        return recordDAO.getRecord(idEmployee);
    }
}
