package com.frontier.back.lemon_tree.data.dao;

import com.frontier.back.lemon_tree.data.entity.FlowRecord;

public interface FlowRecordDAO {
    void saveFlowRecord(FlowRecord flowRecord);

    int getIdFlowRecord(int idRecord);
}
