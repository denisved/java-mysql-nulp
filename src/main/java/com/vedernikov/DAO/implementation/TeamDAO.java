package com.vedernikov.DAO.implementation;

import com.vedernikov.DAO.DAO;
import com.vedernikov.model.Team;
import com.vedernikov.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeamDAO implements DAO<Team> {
    private static final String GET_ALL = "SELECT * FROM lab3.team";
    private static final String GET_BY_ID = "SELECT * FROM lab3.team WHERE id=?";
    private static final String CREATE = "" +
            "INSERT INTO lab3.team (main_coach_id, name, upl_position, number_of_wins, number_of_loses, number_of_draws," +
            " number_of_points) VALUES (?,?,?,?,?,?,?);";
    private static final String UPDATE = "" +
            "UPDATE lab3.team " +
            "SET `Main_Coach_id` = ?, `name` = ?, `UPL_position` = ?, `number_of_wins` = ?, `number_of_loses` = ?," +
            " `number_of_draws` = ?, `number_of_points` = ? WHERE (`id` = ?);";
    private static final String DELETE = "DELETE FROM lab3.team WHERE `id` = ?;";

    @Override
    public List<Team> findAll() throws SQLException {
        List<Team> teams = new ArrayList<Team>();

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Team team = new Team(resultSet.getInt("id"),
                        resultSet.getInt("Main_Coach_id"),
                        resultSet.getString("name"),
                        resultSet.getInt("UPL_position"),
                        resultSet.getInt("number_of_wins"),
                        resultSet.getInt("number_of_loses"),
                        resultSet.getInt("number_of_draws"),
                        resultSet.getInt("number_of_points")
                );
                teams.add(team);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return teams;
    }


    @Override
    public Team findById(Integer id) throws SQLException {
        Team team = null;

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                team= new Team(resultSet.getInt("id"),
                        resultSet.getInt("Main_Coach_id"),
                        resultSet.getString("name"),
                        resultSet.getInt("UPL_position"),
                        resultSet.getInt("number_of_wins"),
                        resultSet.getInt("number_of_loses"),
                        resultSet.getInt("number_of_draws"),
                        resultSet.getInt("number_of_points")
                );
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return team;
    }

    @Override
    public void create(Team team) throws SQLException {
        try(PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setInt(1, team.getMain_Coach_id());
            statement.setString(2, team.getName());
            statement.setInt(3, team.getUPL_position());
            statement.setInt(4, team.getNumber_of_wins());
            statement.setInt(5, team.getNumber_of_loses());
            statement.setInt(6, team.getNumber_of_draws());
            statement.setInt(7, team.getNumber_of_points());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Integer id, Team team) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, team.getMain_Coach_id());
            statement.setString(2, team.getName());
            statement.setInt(3, team.getUPL_position());
            statement.setInt(4, team.getNumber_of_wins());
            statement.setInt(5, team.getNumber_of_loses());
            statement.setInt(6, team.getNumber_of_draws());
            statement.setInt(7, team.getNumber_of_points());
            statement.setInt(8, team.getId());
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