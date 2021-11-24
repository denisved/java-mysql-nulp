package com.vedernikov.DAO.implementation;

import com.vedernikov.DAO.DAO;
import com.vedernikov.model.Stadium;
import com.vedernikov.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StadiumDAO implements DAO<Stadium> {
    private static final String GET_ALL = "SELECT * FROM lab3.stadium";
    private static final String GET_BY_ID = "SELECT * FROM lab3.stadium WHERE id=?";
    private static final String CREATE = "" +
            "INSERT INTO lab3.stadium (city_id, name, capacity) VALUES (?,?,?);";
    private static final String UPDATE = "" +
            "UPDATE lab3.stadium " +
            "SET `City_id` = ?, `name` = ?, `capacity` = ? WHERE (`id` = ?);";
    private static final String DELETE = "DELETE FROM lab3.stadium WHERE `id` = ?;";

    @Override
    public List<Stadium> findAll() throws SQLException {
        List<Stadium> stadiums = new ArrayList<Stadium>();

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Stadium stadium = new Stadium(resultSet.getInt("id"),
                        resultSet.getInt("City_id"),
                        resultSet.getString("name"),
                        resultSet.getInt("capacity")
                );
                stadiums.add(stadium);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return stadiums;
    }


    @Override
    public Stadium findById(Integer id) throws SQLException {
        Stadium stadium = null;

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                stadium = new Stadium(resultSet.getInt("id"),
                        resultSet.getInt("City_id"),
                        resultSet.getString("name"),
                        resultSet.getInt("capacity")
                );
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return stadium;
    }

    @Override
    public void create(Stadium stadium) throws SQLException {
        try(PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setInt(1, stadium.getCity_id());
            statement.setString(2, stadium.getName());
            statement.setInt(3, stadium.getCapcity());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Integer id, Stadium stadium) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, stadium.getCity_id());
            statement.setString(2, stadium.getName());
            statement.setInt(3, stadium.getCapcity());
            statement.setInt(4, stadium.getId());
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
