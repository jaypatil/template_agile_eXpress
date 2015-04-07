package org.template.rm;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.template.domain.State;

public class StateRowMapper implements RowMapper<State> {

    @Override
    public State mapRow(ResultSet rs, int i) throws SQLException {
        State state = new State();
        state.setStateId(rs.getInt("stateId"));
        state.setName(rs.getString("name"));
        state.setCountryId(rs.getInt("countryId"));
        return state;
    }
}
