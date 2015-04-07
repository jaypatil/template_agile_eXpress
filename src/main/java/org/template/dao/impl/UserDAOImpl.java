package org.template.dao.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.template.dao.BaseDAO;
import org.template.dao.UserDAO;
import org.template.domain.User;
import org.template.rm.UserRowMapper;

@Repository
public class UserDAOImpl extends BaseDAO implements UserDAO {

    private static final String SQL_INSERT_QUERY = "INSERT INTO User ( userId, firstName, lastName, gender, dob, cityId, address, userName, email, reqDate, byUserId, password, status, role, dor, vcode) VALUES( :userId, :firstName, :lastName, :gender, :dob, :cityId, :address, :userName, :email, :reqDate, :byUserId, :password, :status, :role, :dor, :vcode)";
    private static final String SQL_UPDATE_QUERY = "UPDATE User SET userId = :userId, firstName = :firstName, lastName = :lastName, gender = :gender, dob = :dob, cityId = :cityId, address = :address, userName = :userName, email = :email, reqDate = :reqDate, byUserId = :byUserId, password = :password, status = :status, role = :role, dor = :dor, vcode = :vcode WHERE userId= :userId";
    private static final String SQL_DELETE_QUERY = "DELETE FROM User WHERE userId= :userId";
    private static final String SQL_SELECT_QUERY = "SELECT * FROM User";
    private static final String SQL_SELECT_BY_ID_QUERY = "SELECT * FROM User WHERE userId= :userId";
    private static final String SQL_SELECT_BY_PROPERTY_QUERY = "SELECT * FROM User WHERE userId?";

    @Override
    public void save(User user) {
        Map p = new HashMap();
        p.put("userId", user.getUserId());
        p.put("firstName", user.getFirstName());
        p.put("lastName", user.getLastName());
        p.put("gender", user.getGender());
        p.put("dob", user.getDob());
        p.put("cityId", user.getCityId());
        p.put("address", user.getAddress());
        p.put("userName", user.getUserName());
        p.put("email", user.getEmail());
        p.put("reqDate", user.getReqDate());
        p.put("byUserId", user.getByUserId());
        p.put("password", user.getPassword());
        p.put("status", user.getStatus());
        p.put("role", user.getRole());
        p.put("dor", user.getDor());
        p.put("vcode", user.getVcode());
        SqlParameterSource ps = new MapSqlParameterSource(p);
        KeyHolder kh = new GeneratedKeyHolder();
        super.getNamedParameterJdbcTemplate().update(SQL_INSERT_QUERY, ps, kh);
        Number no = kh.getKey();
        Integer pk = no.intValue();
        user.setUserId(pk);
    }

    @Override
    public void update(User user) {
        Map p = new HashMap();
        p.put("userId", user.getUserId());
        p.put("firstName", user.getFirstName());
        p.put("lastName", user.getLastName());
        p.put("gender", user.getGender());
        p.put("dob", user.getDob());
        p.put("cityId", user.getCityId());
        p.put("address", user.getAddress());
        p.put("userName", user.getUserName());
        p.put("email", user.getEmail());
        p.put("reqDate", user.getReqDate());
        p.put("byUserId", user.getByUserId());
        p.put("password", user.getPassword());
        p.put("status", user.getStatus());
        p.put("role", user.getRole());
        p.put("dor", user.getDor());
        p.put("vcode", user.getVcode()); 
        super.getNamedParameterJdbcTemplate().update(SQL_UPDATE_QUERY, p);
    }

    @Override
    public void delete(User user) {
        delete(user.getUserId());
    }

    @Override
    public void delete(Integer userId) {
        SqlParameterSource ps = new MapSqlParameterSource("userid", userId);
        getNamedParameterJdbcTemplate().update(SQL_DELETE_QUERY, ps);
    }

    @Override
    public User findById(Integer userId) {
        User user = getJdbcTemplate().queryForObject(SQL_SELECT_BY_ID_QUERY, new UserRowMapper(), userId);
        return user;
    }

    @Override
    public List<User> findAll() {
        return getJdbcTemplate().query(SQL_SELECT_QUERY, new UserRowMapper());
    }

    @Override
    public List<User> findByProperty(String property, Object value) {
        return getJdbcTemplate().query(SQL_SELECT_BY_PROPERTY_QUERY, new UserRowMapper(), value);
    }
}
