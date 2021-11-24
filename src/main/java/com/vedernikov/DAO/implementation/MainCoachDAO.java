package com.vedernikov.DAO.implementation;

import com.vedernikov.DAO.DAO;
import com.vedernikov.model.MainCoach;
import com.vedernikov.persistant.ConnectionManager;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainCoachDAO implements DAO<MainCoach> {
    private static final String GET_ALL = "SELECT * FROM lab3.main_coach";
    private static final String GET_BY_ID = "SELECT * FROM lab3.main_coach WHERE id=?";
    private static final String CREATE = "" +
            "INSERT INTO lab3.main_coach (name, surname, age, salary_for_season_in_euros, start_of_contract, " +
            "end_of_contract, nationality) VALUES (?,?,?,?,?,?,?);";
    private static final String UPDATE = "" +
            "UPDATE lab3.main_coach " +
            "SET `name` = ?, `surname` = ?, `age` = ?, `salary_for_season_in_euros` = ?, `start_of_contract` = ?, " +
            "`end_of_contract` = ?, `nationality` = ? WHERE (`id` = ?);";
    private static final String DELETE = "DELETE FROM lab3.main_coach WHERE `id` = ?;";

    @Override
    public List<MainCoach> findAll() throws SQLException {
        List<MainCoach> mainCoaches = new ArrayList<MainCoach>();

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                MainCoach mainCoach = new MainCoach(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("age"),
                        resultSet.getInt("salary_for_season_in_euros"),
                        resultSet.getString("start_of_contract"),
                        resultSet.getString("end_of_contract"),
                        resultSet.getString("nationality")
                );
                mainCoaches.add(mainCoach);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return mainCoaches;
    }


    @Override
    public MainCoach findById(Integer id) throws SQLException {
        MainCoach mainCoach = null;

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                mainCoach = new MainCoach(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("age"),
                        resultSet.getInt("salary_for_season_in_euros"),
                        resultSet.getString("start_of_contract"),
                        resultSet.getString("end_of_contract"),
                        resultSet.getString("nationality")
                );
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return mainCoach;
    }

    @Override
    public void create(MainCoach mainCoach) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, mainCoach.getName());
            statement.setString(2, mainCoach.getSurname());
            statement.setInt(3, mainCoach.getAge());
            statement.setInt(4, mainCoach.getSalary_for_season_in_euros());
            statement.setString(5, mainCoach.getStart_of_contract());
            statement.setString(6, mainCoach.getEnd_of_contract());
            statement.setString(7, mainCoach.getNationality());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Integer id, MainCoach mainCoach) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, mainCoach.getName());
            statement.setString(2, mainCoach.getSurname());
            statement.setInt(3, mainCoach.getAge());
            statement.setInt(4, mainCoach.getSalary_for_season_in_euros());
            statement.setString(5, mainCoach.getStart_of_contract());
            statement.setString(6, mainCoach.getEnd_of_contract());
            statement.setString(7, mainCoach.getNationality());
            statement.setInt(8, mainCoach.getId());
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