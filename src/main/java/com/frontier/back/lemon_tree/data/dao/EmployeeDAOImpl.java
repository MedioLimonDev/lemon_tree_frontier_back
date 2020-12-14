package com.frontier.back.lemon_tree.data.dao;

import com.frontier.back.lemon_tree.biz.vo.EmployeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDAOImpl implements EmployeeDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private StringBuilder sql;

    @Override
    public boolean loginValidation(EmployeeVO employeeVO) throws DataAccessException {
        try{
            sql = new StringBuilder();
            sql.append(" SELECT count(*) FROM employee WHERE email LIKE '");
            sql.append(employeeVO.getEmail());
            sql.append("' AND password = '");
            sql.append(employeeVO.getPassword());
            sql.append("'");

            Integer count = jdbcTemplate.queryForObject(sql.toString(),Integer.class);

            if(count != 1)
                return false;
            else
                return true;

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