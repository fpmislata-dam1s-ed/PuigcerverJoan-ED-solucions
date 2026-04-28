package ud8.users.persistance.dao.impl;

import ud8.users.domain.entity.User;
import ud8.users.persistance.dao.UserDao;
import ud8.users.persistance.rowmapper.UserRowMapper;
import ud8.common.persistance.database.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoJdbc implements UserDao {
    private final DatabaseConnection connection;
    private final UserRowMapper userRowMapper;

    public UserDaoJdbc() {
        this.connection = DatabaseConnection.getInstance();
        this.userRowMapper = new UserRowMapper();
    }

    @Override
    public User findById(int userId) {
        String sql = "SELECT * FROM `user` WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();
            if (!rs.next())
                return null;

            return userRowMapper.mapItem(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public User findByEmail(String email) {
        String sql = "SELECT * FROM `user` WHERE email = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, email);
            ResultSet rs = preparedStatement.executeQuery();
            if (!rs.next())
                return null;

            return userRowMapper.mapItem(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public int insert(User user) {
        String sql = "INSERT INTO `user` (name, email) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public int update(User user) {
        String sql = "UPDATE `user` SET name = ?, email = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setInt(3, user.getId());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public int delete(int userId) {
        String sql = "DELETE FROM `user` WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, userId);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
