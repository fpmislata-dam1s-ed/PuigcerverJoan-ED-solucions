package exam3.dish.persistance.dao;

import exam3.dish.domain.entity.Dish;
import exam3.dish.persistance.rowmapper.DishRowMapper;
import ud8.common.persistance.database.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DishDaoJdbc implements DishDao {
    private final DatabaseConnection connection;
    private final DishRowMapper rowMapper;

    public DishDaoJdbc() {
        this.connection = DatabaseConnection.getInstance();
        this.rowMapper = new DishRowMapper();
    }

    @Override
    public Dish findById(int dishId) {
        String sql = "SELECT * FROM `dish` WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, dishId);
            ResultSet rs = preparedStatement.executeQuery();
            if (!rs.next())
                return null;

            return rowMapper.mapRow(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public int insert(Dish dish) {
        String sql = "INSERT INTO `dish` (name, price) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, dish.getName());
            preparedStatement.setDouble(2, dish.getPrice());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public int update(Dish dish) {
        String sql = "UPDATE `dish` SET name = ?, price = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, dish.getName());
            preparedStatement.setDouble(2, dish.getPrice());
            preparedStatement.setInt(3, dish.getId());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}

