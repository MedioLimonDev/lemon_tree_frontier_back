package com.frontier.back.lemon_tree.data.dao;

import com.frontier.back.lemon_tree.data.entity.Response;
import com.frontier.back.lemon_tree.data.entity.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StepDAOImpl implements StepDAO{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //@Override
    public void getLastAnswer(int idStep, int idRecord){
        try {
            StringBuilder sql = new StringBuilder();
            //sql.append();

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
    public Step getStep(int idNextStep){
        try {
            List<Step> step;

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT id, title, description, agent_activity, customer_activity FROM step s WHERE s.id = ");
            sql.append(idNextStep);
            step = jdbcTemplate.query(
                    sql.toString(),
                    (rs, rowNum) ->
                            new Step(
                                    rs.getInt("id"),
                                    rs.getString("title"),
                                    rs.getString("description"),
                                    rs.getString("agent_activity"),
                                    rs.getString("customer_activity")
                            )
            );

            StringBuilder sql2 = new StringBuilder();
            sql2.append("SELECT r.id, r.description , r.id_original_step as idOriginalStep, r.id_next_step as idNextStep, r.response_type as responseType FROM step s RIGHT JOIN response r on r.id_original_step = s.id WHERE r.id_original_step = ");
            sql2.append(idNextStep);

            List<Response> response;
            response = jdbcTemplate.query(
                    sql2.toString(),
                    (rs, rowNum) ->
                            new Response(
                                    rs.getInt("id"),
                                    rs.getString("description"),
                                    rs.getInt("idOriginalStep"),
                                    rs.getInt("idNextStep"),
                                    rs.getString("responseType")
                            )
            );

            step.get(0).setResponse(response);

            return step.get(0);
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
