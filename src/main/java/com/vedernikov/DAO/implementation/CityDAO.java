package com.vedernikov.DAO.implementation;

import com.vedernikov.DAO.DAO;
import com.vedernikov.model.City;
import com.vedernikov.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDAO implements DAO<City> {
    private static final String GET_ALL = "SELECT * FROM lab3.City";
    private static final String GET_BY_ID = "SELECT * FROM lab3.City WHERE id=?";
    private static final String CREATE = "" +
            "INSERT INTO lab3.City (name) VALUES (?);";
    private static final String UPDATE = "" +
            "UPDATE lab3.City " +
            "SET `name` = ? WHERE (`id` = ?);";
    private static final String DELETE = "DELETE FROM lab3.City WHERE `id` = ?;";

    @Override
    public List<City> findAll() throws SQLException {
        List<City> cities = new ArrayList<City>();

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                City city = new City(resultSet.getInt("id"),
                        resultSet.getString("name")
                );
                cities.add(city);
            }

            } catch (Exception e) {
                System.out.println(e.getMessage());
        }
            return cities;
        }


    @Override
    public City findById(Integer id) throws SQLException {
        City city = null;

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                city = new City(resultSet.getInt("id"),
                        resultSet.getString("name")
                );
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return city;
    }

    @Override
    public void create(City city) throws SQLException {
        try(PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, city.getName());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Integer id, City city) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, city.getName());
            statement.setInt(2, city.getId());
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