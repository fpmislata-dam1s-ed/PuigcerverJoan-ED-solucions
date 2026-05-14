package exam3.dish.persistance.rowmapper;

import exam3.dish.domain.entity.Dish;
import ud8.common.persistance.rowmapper.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DishRowMapper extends RowMapper<Dish> {
    @Override
    public Dish mapRow(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        double price = rs.getDouble("price");

        return new Dish(
                id,
                name,
                price
        );
    }
}
