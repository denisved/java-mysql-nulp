package com.vedernikov.DAO.implementation;

import com.vedernikov.DAO.DAO;
import com.vedernikov.model.Referee;
import com.vedernikov.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RefereeDAO implements DAO<Referee> {
    private static final String GET_ALL = "SELECT * FROM lab3.referee";
    private static final String GET_BY_ID = "SELECT * FROM lab3.referee WHERE id=?";
    private static final String CREATE = "" +
            "INSERT INTO lab3.referee (match_id, name, surname, age, nationality) VALUES (?,?,?,?,?);";
    private static final String UPDATE = "" +
            "UPDATE lab3.referee " +
            "SET `Match_id` = ?, `name` = ?, `surname` = ?, `age` = ?, `nationality`" +
            " = ?  WHERE (`id` = ?);";
    private static final String DELETE = "DELETE FROM lab3.referee WHERE `id` = ?;";

    @Override
    public List<Referee> findAll() throws SQLException {
        List<Referee> referees = new ArrayList<Referee>();

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Referee referee = new Referee(resultSet.getInt("id"),
                        resultSet.getInt("match_id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("age"),
                        resultSet.getString("nationality")
                );
                referees.add(referee);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return referees;
    }


    @Override
    public Referee findById(Integer id) throws SQLException {
        Referee referee = null;

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                referee = new Referee(resultSet.getInt("id"),
                        resultSet.getInt("match_id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("age"),
                        resultSet.getString("nationality")
                );
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return referee;
    }

    @Override
    public void create(Referee referee) throws SQLException {
        try(PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setInt(1, referee.getMatch_id());
            statement.setString(2, referee.getName());
            statement.setString(3, referee.getSurname());
            statement.setInt(4, referee.getAge());
            statement.setString(5, referee.getNationality());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Integer id, Referee referee) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, referee.getMatch_id());
            statement.setString(2, referee.getName());
            statement.setString(3, referee.getSurname());
            statement.setInt(4, referee.getAge());
            statement.setString(5, referee.getNationality());
            statement.setInt(6, referee.getId());
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