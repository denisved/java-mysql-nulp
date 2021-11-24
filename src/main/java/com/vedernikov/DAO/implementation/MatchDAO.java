package com.vedernikov.DAO.implementation;

import com.vedernikov.DAO.DAO;
import com.vedernikov.model.Match;
import com.vedernikov.persistant.ConnectionManager;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MatchDAO implements DAO<Match> {
    private static final String GET_ALL = "SELECT * FROM lab3.match";
    private static final String GET_BY_ID = "SELECT * FROM lab3.match WHERE id=?";
    private static final String CREATE = "" +
            "INSERT INTO lab3.match (stadium_id, winner, loser, draw, final_score, goals_total, red_cards, yellow_cards," +
            "number_of_replacements, number_of_fouls, number_of_offsides, number_of_corners, start_time, end_time) " +
            "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
    private static final String UPDATE = "" +
            "UPDATE lab3.match " +
            "SET `Stadium_id` = ?, `winner` = ?, `loser` = ?, `draw` = ?, `final_score` = ?, " +
            "`goals_total` = ?, `red_cards` = ?, `yellow_cards` = ?, `number_of_replacements` = ?, " +
            "`number_of_fouls` = ?, `number_of_offsides` = ?, `number_of_corners` = ?, `start_time` = ?, " +
            "`end_time` = ? WHERE (`id` = ?);";
    private static final String DELETE = "DELETE FROM lab3.match WHERE `id` = ?;";

    @Override
    public List<Match> findAll() throws SQLException {
        List<Match> matches = new ArrayList<Match>();

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Match match = new Match(resultSet.getInt("id"),
                        resultSet.getInt("Stadium_id"),
                        resultSet.getString("winner"),
                        resultSet.getString("loser"),
                        resultSet.getInt("draw"),
                        resultSet.getString("final_score"),
                        resultSet.getInt("goals_total"),
                        resultSet.getInt("red_cards"),
                        resultSet.getInt("yellow_cards"),
                        resultSet.getInt("number_of_replacemnets"),
                        resultSet.getInt("number_of_fouls"),
                        resultSet.getInt("number_of_offsides"),
                        resultSet.getInt("number_of_corners"),
                        resultSet.getString("start_time"),
                        resultSet.getString("end_time")
                );
                matches.add(match);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return matches;
    }


    @Override
    public Match findById(Integer id) throws SQLException {
        Match match = null;

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                match = new Match(resultSet.getInt("id"),
                        resultSet.getInt("Stadium_id"),
                        resultSet.getString("winner"),
                        resultSet.getString("loser"),
                        resultSet.getInt("draw"),
                        resultSet.getString("final_score"),
                        resultSet.getInt("goals_total"),
                        resultSet.getInt("red_cards"),
                        resultSet.getInt("yellow_cards"),
                        resultSet.getInt("number_of_replacemnets"),
                        resultSet.getInt("number_of_fouls"),
                        resultSet.getInt("number_of_offsides"),
                        resultSet.getInt("number_of_corners"),
                        resultSet.getString("start_time"),
                        resultSet.getString("end_time")
                );
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return match;
    }

    @Override
    public void create(Match match) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setInt(1, match.getStadium_id());
            statement.setString(2, match.getWinner());
            statement.setString(3, match.getLoser());
            statement.setInt(4, match.getDraw());
            statement.setString(5, match.getFinal_score());
            statement.setInt(6, match.getGoals_total());
            statement.setInt(7, match.getRed_cards());
            statement.setInt(8, match.getYellow_cards());
            statement.setInt(9, match.getNumber_of_replacements());
            statement.setInt(10, match.getNumber_of_fouls());
            statement.setInt(11, match.getNumber_of_offsides());
            statement.setInt(12, match.getNumber_of_corners());
            statement.setString(13, match.getStart_time());
            statement.setString(14, match.getEnd_time());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Integer id, Match match) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, match.getStadium_id());
            statement.setString(2, match.getWinner());
            statement.setString(3, match.getLoser());
            statement.setInt(4, match.getDraw());
            statement.setString(5, match.getFinal_score());
            statement.setInt(6, match.getGoals_total());
            statement.setInt(7, match.getRed_cards());
            statement.setInt(8, match.getYellow_cards());
            statement.setInt(9, match.getNumber_of_replacements());
            statement.setInt(10, match.getNumber_of_fouls());
            statement.setInt(11, match.getNumber_of_offsides());
            statement.setInt(12, match.getNumber_of_corners());
            statement.setString(13, match.getStart_time());
            statement.setString(14, match.getEnd_time());
            statement.setInt(15, match.getId());
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