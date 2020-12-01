package com.frontier.back.lemon_tree.data.dao;

import com.frontier.back.lemon_tree.data.entity.Notes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class NotesDAOImpl implements NotesDAO{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private StringBuilder sql;

    @Override
    public void addNote(String note, int id_flow_record){
        sql = new StringBuilder();

        sql.append("INSERT INTO notes(description, id_flow_record) VALUES(\"");
        sql.append(note);
        sql.append("\",");
        sql.append(id_flow_record);
        sql.append(")");

        jdbcTemplate.execute(sql.toString());
    }

    @Override
    public List<Notes> getByIdRecord(int idRecord) {
        sql = new StringBuilder();

        sql.append("SELECT s.title, fr.respuesta_escrita AS response, n.description AS note FROM flow_record fr ");
        sql.append("INNER JOIN notes n ON n.id_flow_record = fr.id ");
        sql.append("INNER JOIN step s ON s.id = fr.id_step ");
        sql.append("WHERE fr.id_record = '");
        sql.append(idRecord);
        sql.append("'");

        return jdbcTemplate.query(
                sql.toString(),
                (rs, rowNum) ->
                        new Notes(
                                rs.getString("title"),
                                rs.getString("response"),
                                rs.getString("note")
                        )
        );
    }
}
