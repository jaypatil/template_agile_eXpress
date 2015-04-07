package org.template.rm;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.template.domain.User;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {
        User user = new User();
        user.setUserId(rs.getInt("userId"));
        user.setFirstName(rs.getString("firstName"));
        user.setLastName(rs.getString("lastName"));
        user.setGender(rs.getString("gender"));
        user.setDob(rs.getDate("dob"));
        user.setCityId(rs.getInt("cityId"));
        user.setAddress(rs.getString("address"));
        user.setUserName(rs.getString("userName"));
        user.setEmail(rs.getString("email"));
        user.setReqDate(rs.getDate("reqDate"));
        user.setByUserId(rs.getInt("byUserId"));
        user.setPassword(rs.getString("password"));
        user.setStatus(rs.getString("status"));
        user.setRole(rs.getString("role"));
        user.setDor(rs.getDate("dor"));
        user.setVcode(rs.getString("vcode"));
        return user;
    }
}
