package com.vedernikov.DAO.implementation;

import com.vedernikov.DAO.DAO;
import com.vedernikov.model.MatchHasTeam;
import com.vedernikov.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MatchHasTeamDAO implements DAO<MatchHasTeam> {
    private static final String GET_ALL = "SELECT * FROM lab3.match_has_team";
    private static final String GET_BY_ID = "SELECT * FROM lab3.match_has_team WHERE id=?";
    private static final String CREATE = "" +
            "INSERT INTO lab3.match_has_team (match_id, team_id) VALUES (?, ?);";
    private static final String UPDATE = "" +
            "UPDATE lab3.match_has_team " +
            "SET `Match_id` = ?, `Team_id` = ? WHERE (`id` = ?);";
    private static final String DELETE = "DELETE FROM lab3.match_has_team WHERE `id` = ?;";

    @Override
    public List<MatchHasTeam> findAll() throws SQLException {
        List<MatchHasTeam> matchHasTeams = new ArrayList<MatchHasTeam>();

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                MatchHasTeam matchHasTeam = new MatchHasTeam(resultSet.getInt("id"),
                        resultSet.getInt("Match_id"),
                        resultSet.getInt("Team_id")
                );
                matchHasTeams.add(matchHasTeam);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return matchHasTeams;
    }


    @Override
    public MatchHasTeam findById(Integer id) throws SQLException {
        MatchHasTeam matchHasTeam = null;

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                matchHasTeam = new MatchHasTeam(resultSet.getInt("id"),
                        resultSet.getInt("Match_id"),
                        resultSet.getInt("Team_id")
                );
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return matchHasTeam;
    }

    @Override
    public void create(MatchHasTeam matchHasTeam) throws SQLException {
        try(PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setInt(1, matchHasTeam.getMatch_id());
            statement.setInt(2, matchHasTeam.getTeam_id());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Integer id, MatchHasTeam matchHasTeam) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, matchHasTeam.getMatch_id());
            statement.setInt(2, matchHasTeam.getTeam_id());
            statement.setInt(3, matchHasTeam.getId());
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
