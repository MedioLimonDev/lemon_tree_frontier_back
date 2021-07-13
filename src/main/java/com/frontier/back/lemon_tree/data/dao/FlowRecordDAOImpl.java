package com.frontier.back.lemon_tree.data.dao;

import com.frontier.back.lemon_tree.data.entity.FlowRecord;
import com.frontier.back.lemon_tree.data.entity.Response;
import com.frontier.back.lemon_tree.data.output.StaticInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FlowRecordDAOImpl implements FlowRecordDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private StringBuilder sql;

    @Override
    public void saveFlowRecord(FlowRecord flowRecord) throws DataAccessException {
        try{
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
        } catch (Exception e){
            throw new DataAccessException(e.getMessage(), e) {
                @Override
                public String getMessage() {
                    return super.getMessage();
                }
            };
        }

    }

    @Override
    public int getIdFlowRecord(int idRecord) throws DataAccessException{
        try {
            sql = new StringBuilder();
            sql.append(" SELECT max(id) as id FROM flow_record WHERE id_record = ");
            sql.append(idRecord);

            return jdbcTemplate.queryForObject(sql.toString(), Integer.class);
        } catch (Exception e){
            throw new DataAccessException(e.getMessage(), e) {
                @Override
                public String getMessage() {
                    return super.getMessage();
                }
            };
        }
    }


    @Override
    public List<StaticInformation> getStaticInformation(int idRecord) throws DataAccessException{
        try {
            sql = new StringBuilder();
            sql.append("SELECT title, respuesta_escrita as respuestaEscrita FROM flow_record fr INNER JOIN step s ON s.id = fr.id_step INNER JOIN response r ON r.id = fr.id_response WHERE r.response_type LIKE 'STATIC' AND fr.id_record = ");
            sql.append(idRecord);

            List<StaticInformation> staticInformations;
            staticInformations = jdbcTemplate.query(
                    sql.toString(),
                    (rs, rowNum) ->
                            new StaticInformation(
                                    rs.getString("title"),
                                    rs.getString("respuestaEscrita")
                            )
            );

            return staticInformations;
        } catch (Exception e){
            throw new DataAccessException(e.getMessage(), e) {
                @Override
                public String getMessage() {
                    return super.getMessage();
                }
            };
        }
    }
}