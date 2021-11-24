package com.vedernikov.DAO.implementation;

import com.vedernikov.DAO.DAO;
import com.vedernikov.model.Sponsor;
import com.vedernikov.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SponsorDAO implements DAO<Sponsor> {
    private static final String GET_ALL = "SELECT * FROM lab3.sponsor";
    private static final String GET_BY_ID = "SELECT * FROM lab3.sponsor WHERE id=?";
    private static final String CREATE = "" +
            "INSERT INTO lab3.sponsor (name, start_of_contract, end_of_contract) VALUES (?,?,?);";
    private static final String UPDATE = "" +
            "UPDATE lab3.sponsor " +
            "SET `name` = ?, `start_of_contract` = ?, `end_of_contract`= ? WHERE (`id` = ?);";
    private static final String DELETE = "DELETE FROM lab3.sponsor WHERE `id` = ?;";

    @Override
    public List<Sponsor> findAll() throws SQLException {
        List<Sponsor> sponsors = new ArrayList<Sponsor>();

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Sponsor sponsor = new Sponsor(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("start_of_contract"),
                        resultSet.getString("end_of_contract")
                );
                sponsors.add(sponsor);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return sponsors;
    }


    @Override
    public Sponsor findById(Integer id) throws SQLException {
        Sponsor sponsor = null;

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                sponsor = new Sponsor(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("start_of_contract"),
                        resultSet.getString("end_of_contract")
                );
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return sponsor;
    }

    @Override
    public void create(Sponsor sponsor) throws SQLException {
        try(PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, sponsor.getName());
            statement.setString(2, sponsor.getStart_of_contract());
            statement.setString(3, sponsor.getEnd_of_contract());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Integer id, Sponsor sponsor) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, sponsor.getName());
            statement.setString(2, sponsor.getStart_of_contract());
            statement.setString(3, sponsor.getEnd_of_contract());
            statement.setInt(4, sponsor.getId());
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