package exam3.dish.persistance.rowmapper;

import exam3.dish.domain.entity.Allergen;
import ud8.common.persistance.rowmapper.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AllergenRowMapper extends RowMapper<Allergen> {
    @Override
    public Allergen mapRow(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");

        return new Allergen(id, name);
    }
}
