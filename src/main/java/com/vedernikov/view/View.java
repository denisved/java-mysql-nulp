package com.vedernikov.view;

import com.vedernikov.controller.implementation.*;
import com.vedernikov.model.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.out;

public class View {
    private static final String KEY_EXIT = "Q";
    private final static Scanner scanner = new Scanner(System.in);
    private final Map<String, Printable> menu = new HashMap<>();

    private final CityController cityController = new CityController();
    private final MainCoachController mainCoachController = new MainCoachController();
    private final MatchController matchController = new MatchController();
    private final MatchHasTeamController matchHasTeamController = new MatchHasTeamController();
    private final PlayerController playerController = new PlayerController();
    private final RefereeController refereeController = new RefereeController();
    private final SponsorController sponsorController = new SponsorController();
    private final StadiumController stadiumController = new StadiumController();
    private final TeamController teamController = new TeamController();


    public View() {
        menu.put("11", this::getAllCities);
        menu.put("12", this::getCityById);
        menu.put("13", this::createCity);
        menu.put("14", this::updateCity);
        menu.put("15", this::deleteCity);

        menu.put("21", this::getAllMainCoaches);
        menu.put("22", this::getMainCoachById);
        menu.put("23", this::createMainCoach);
        menu.put("24", this::updateMainCoach);
        menu.put("25", this::deleteMainCoach);
    }

    private void getAllMainCoaches() throws SQLException {
        mainCoachController.findAll().forEach(out::println);
    }

    private void getMainCoachById() throws SQLException {
        out.println(mainCoachController.findById(getId()));
    }

    private void createMainCoach() throws SQLException {
        mainCoachController.create(getMainCoachFromInput());
    }

    private void updateMainCoach() throws SQLException {
        Integer id = getId();
        MainCoach mainCoach = getMainCoachFromInput();
        mainCoach.setId(id);
        mainCoachController.update(mainCoach.getId(), mainCoach);
    }

    private void deleteMainCoach() throws SQLException {
        mainCoachController.delete(getId());
    }

    private void getAllCities() throws SQLException {
        cityController.findAll().forEach(out::println);
    }

    private void getCityById() throws SQLException {
        out.println(cityController.findById(getId()));
    }

    private void createCity() throws SQLException {
        cityController.create(getCityFromInput());
    }

    private void updateCity() throws SQLException {
        Integer id = getId();
        City city = getCityFromInput();
        city.setId(id);
        cityController.update(city.getId(), city);
    }

    private void deleteCity() throws SQLException {
        cityController.delete(getId());
    }


    private Integer getId() {
        out.println("Id:");
        String input = scanner.nextLine();
        return Integer.parseInt(input);
    }

    private City getCityFromInput() {
        out.println("City id: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        out.println("Name: ");
        String name = scanner.nextLine();
        return new City(id, name);
    }

    private MainCoach getMainCoachFromInput() {
        out.println("Name: ");
        String name = scanner.nextLine();
        out.println("Surname: ");
        String surname = scanner.nextLine();
        out.println("Age: ");
        Integer age = Integer.parseInt(scanner.nextLine());
        out.println("Salary: ");
        Integer salary_for_season_in_euros = Integer.parseInt(scanner.nextLine());
        out.println("Start of contract: ");
        String start_of_contract = scanner.nextLine();
        out.println("End of contract: ");
        String end_of_contract = scanner.nextLine();
        out.println("Nationality: ");
        String nationality = scanner.nextLine();
        return new MainCoach(name, surname, age, salary_for_season_in_euros, start_of_contract, end_of_contract, nationality);
    }

    private static void displayMenu() {
        out.println(
                        "1: city                                         1: GET ALL  \n" +
                        "2: main_coach                                   2: GET      \n" +
                        "3: match                                        3: CREATE   \n" +
                        "4: match_has_team                               4: UPDATE   \n" +
                        "5: player                                       5: DELETE   \n" +
                        "6: referee"   +
                        "7: sponsor\n" +
                        "8: stadium\n" +
                        "9: team\n" +
                        "Q - exit\n"
        );
    }

    public void show() throws SQLException {
        displayMenu();
        out.println("Select a table and action: ");
        String input = scanner.nextLine();

        while (!input.equals(KEY_EXIT)) {
            menu.get(input).print();
            input = scanner.nextLine();
        }
    }

}
