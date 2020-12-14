package com.frontier.back.lemon_tree.data.dao;

public interface RecordDAO {
    void doneRecord(int idRecord);
    void addRecord(int idEmployee);
    int getRecord(int idEmployee);
}
