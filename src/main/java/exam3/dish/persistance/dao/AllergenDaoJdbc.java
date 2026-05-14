package exam3.dish.persistance.dao;

import exam3.dish.domain.entity.Allergen;
import exam3.dish.persistance.rowmapper.AllergenRowMapper;
import ud8.common.persistance.database.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AllergenDaoJdbc implements AllergenDao {
    private final DatabaseConnection connection;
    private final AllergenRowMapper rowMapper;

    public AllergenDaoJdbc() {
        this.connection = DatabaseConnection.getInstance();
        this.rowMapper = new AllergenRowMapper();
    }

    @Override
    public List<Allergen> findByDishId(int id) {
        String sql = """
            SELECT *
            FROM `allergen` as a
            INNER JOIN `dish_allergen` as da ON a.id = da.allergen_id
            INNER JOIN `dish` as d ON da.dish_id = d.id
            WHERE d.id = ?
            """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            return rowMapper.map(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}

