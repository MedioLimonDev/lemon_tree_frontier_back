package com.frontier.back.lemon_tree.data.dao;

import com.frontier.back.lemon_tree.data.entity.FlowRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FlowRecordDAOImpl implements FlowRecordDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private StringBuilder sql;

    @Override
    public void saveFlowRecord(FlowRecord flowRecord){
        sql = new StringBuilder();
        sql.append(" INSERT INTO flow_record(id_record, id_step, Id_response, respuesta_escrita) VALUES(");
        sql.append(flowRecord.getIdRecord());
        sql.append(",");
        sql.append(flowRecord.getIdStep());
        sql.append(",");
        sql.append(flowRecord.getIdResponse());
        sql.append(",\"");
        sql.append(flowRecord.getRespuestaEscrita());
        sql.append("\")");

        jdbcTemplate.execute(sql.toString());
    }

    @Override
    public int getIdFlowRecord(int idRecord){
        sql = new StringBuilder();
        sql.append(" SELECT max(id) as id FROM flow_record WHERE id_record = ");
        sql.append(idRecord);

        return jdbcTemplate.queryForObject(sql.toString(), Integer.class);
    }
}
