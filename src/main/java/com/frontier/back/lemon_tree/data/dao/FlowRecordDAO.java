package com.frontier.back.lemon_tree.data.dao;

import com.frontier.back.lemon_tree.data.entity.FlowRecord;
import com.frontier.back.lemon_tree.data.output.StaticInformation;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface FlowRecordDAO {
    void saveFlowRecord(FlowRecord flowRecord);

    int getIdFlowRecord(int idRecord);

    List<StaticInformation> getStaticInformation(int idRecord) throws DataAccessException;
}
