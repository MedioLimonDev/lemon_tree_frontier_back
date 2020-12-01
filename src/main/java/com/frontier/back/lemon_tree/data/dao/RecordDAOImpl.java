package com.frontier.back.lemon_tree.data.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RecordDAOImpl implements RecordDAO{
    @Autowired
    JdbcTemplate jdbcTemplate;

    private StringBuilder sql;

    @Override
    public void doneRecord(int idRecord) {
        sql = new StringBuilder();
        sql.append("UPDATE record SET done = 1 WHERE id = '");
        sql.append(idRecord);
        sql.append("'");

        jdbcTemplate.update(sql.toString());
    }

    @Override
    public void addRecord(int idEmployee) {
        sql = new StringBuilder();
        sql.append("INSERT INTO record(id_employee, done, created_at, updated_at, fg_active) VALUES(");
        sql.append(idEmployee);
        sql.append(",'0', CURDATE(), CURDATE(), '1')");
        jdbcTemplate.execute(sql.toString());
    }

    @Override
    public int getRecord(int idEmployee) {
        sql = new StringBuilder();
        sql.append(" SELECT max(id) AS id FROM record WHERE id_employee =  ");
        sql.append(idEmployee);
        sql.append(" AND done = 0 ");

        return jdbcTemplate.queryForObject(sql.toString(), Integer.class);
    }


}
