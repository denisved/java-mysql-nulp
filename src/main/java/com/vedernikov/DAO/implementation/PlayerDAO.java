package com.vedernikov.DAO.implementation;

import com.vedernikov.DAO.DAO;
import com.vedernikov.model.Player;
import com.vedernikov.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAO implements DAO<Player> {
    private static final String GET_ALL = "SELECT * FROM lab3.player";
    private static final String GET_BY_ID = "SELECT * FROM lab3.player WHERE id=?";
    private static final String CREATE = "" +
            "INSERT INTO lab3.player (team_id, name, surname, age, positon, salary_for_season_in_euros, " +
            "start_of_contract, end_of_contract, nationality, goals, assists) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
    private static final String UPDATE = "" +
            "UPDATE lab3.player " +
            "SET `Team_id` = ?,  `name` = ?,  `surname` = ?, `age` = ?, `positon` = ?," +
            " `salary_for_season_in_euros` = ?,  `start_of_contract` = ?, `end_of_contract` = ?," +
            " `nationality` = ?,  `goals` = ?,  `assists` = ? WHERE (`id` = ?);";
    private static final String DELETE = "DELETE FROM lab3.City WHERE `id` = ?;";

    @Override
    public List<Player> findAll() throws SQLException {
        List<Player> players = new ArrayList<Player>();

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Player player = new Player(resultSet.getInt("id"),
                        resultSet.getInt("Team_id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("age"),
                        resultSet.getString("positon"),
                        resultSet.getInt("salary_for_season_in_euros"),
                        resultSet.getString("start_of_contract"),
                        resultSet.getString("end_of_contract"),
                        resultSet.getString("nationality"),
                        resultSet.getInt("goals"),
                        resultSet.getInt("assists")
                );
                players.add(player);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return players;
    }


    @Override
    public Player findById(Integer id) throws SQLException {
        Player player = null;

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                player = new Player(resultSet.getInt("id"),
                        resultSet.getInt("Team_id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("age"),
                        resultSet.getString("positon"),
                        resultSet.getInt("salary_for_season_in_euros"),
                        resultSet.getString("start_of_contract"),
                        resultSet.getString("end_of_contract"),
                        resultSet.getString("nationality"),
                        resultSet.getInt("goals"),
                        resultSet.getInt("assists")
                );
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return player;
    }

    @Override
    public void create(Player player) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setInt(1, player.getTeam_id());
            statement.setString(2, player.getName());
            statement.setString(3, player.getSurname());
            statement.setInt(4, player.getAge());
            statement.setString(5, player.getPosition());
            statement.setInt(6, player.getSalary_for_season_in_euros());
            statement.setString(7, player.getStart_of_contract());
            statement.setString(8, player.getEnd_of_contract());
            statement.setString(9, player.getNationality());
            statement.setInt(10, player.getGoals());
            statement.setInt(11, player.getAssists());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Integer id, Player player) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, player.getTeam_id());
            statement.setString(2, player.getName());
            statement.setString(3, player.getSurname());
            statement.setInt(4, player.getAge());
            statement.setString(5, player.getPosition());
            statement.setInt(6, player.getSalary_for_season_in_euros());
            statement.setString(7, player.getStart_of_contract());
            statement.setString(8, player.getEnd_of_contract());
            statement.setString(9, player.getNationality());
            statement.setInt(10, player.getGoals());
            statement.setInt(11, player.getAssists());
            statement.setInt(12, player.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}