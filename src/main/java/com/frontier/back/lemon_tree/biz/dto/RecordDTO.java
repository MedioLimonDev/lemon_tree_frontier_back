package com.frontier.back.lemon_tree.biz.dto;

public interface RecordDTO {
    void doneRecord(int idRecord);

    void addRecord(int idEmployee);

    int getRecord(int idEmployee);
}
