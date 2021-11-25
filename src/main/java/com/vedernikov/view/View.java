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

        menu.put("31", this::getAllMatches);
        menu.put("32", this::getMatchById);
        menu.put("33", this::createMatch);
        menu.put("34", this::updateMatch);
        menu.put("35", this::deleteMatch);

        menu.put("41", this::getAllMatcheHasTeams);
        menu.put("42", this::getMatchHasTeamById);
        menu.put("43", this::createMatchHasTeam);
        menu.put("44", this::updateMatchHasTeam);
        menu.put("45", this::deleteMatchHasTeam);

        menu.put("51", this::getAllPlayers);
        menu.put("52", this::getPlayerById);
        menu.put("53", this::createPlayer);
        menu.put("54", this::updatePlayer);
        menu.put("55", this::deletePlayer);

        menu.put("61", this::getAllReferees);
        menu.put("62", this::getRefereeById);
        menu.put("63", this::createReferee);
        menu.put("64", this::updateReferee);
        menu.put("65", this::deleteReferee);

        menu.put("71", this::getAllSponsors);
        menu.put("72", this::getSponsorById);
        menu.put("73", this::createSponsor);
        menu.put("74", this::updateSponsor);
        menu.put("75", this::deleteSponsor);

        menu.put("81", this::getAllStadiums);
        menu.put("82", this::getStadiumById);
        menu.put("83", this::createStadium);
        menu.put("84", this::updateStadium);
        menu.put("85", this::deleteStadium);

        menu.put("91", this::getAllTeams);
        menu.put("92", this::getTeamById);
        menu.put("93", this::createTeam);
        menu.put("94", this::updateTeam);
        menu.put("95", this::deleteTeam);
    }

    private void getAllTeams() throws SQLException {
        teamController.findAll().forEach(out::println);
    }

    private void getTeamById() throws SQLException {
        out.println(teamController.findById(getId()));
    }

    private void createTeam() throws SQLException {
        teamController.create(getTeamFromInput());
    }

    private void updateTeam() throws SQLException {
        Integer id = getId();
        Team team = getTeamFromInput();
        team.setId(id);
        teamController.update(team.getId(), team);
    }

    private void deleteTeam() throws SQLException {
        teamController.delete(getId());
    }

    private Team getTeamFromInput() {
        out.println("Main coach id: ");
        Integer main_coach_id = Integer.parseInt(scanner.nextLine());
        out.println("Name: ");
        String name = scanner.nextLine();
        out.println("UPL position: ");
        Integer UPL_position = Integer.parseInt(scanner.nextLine());
        out.println("Number of wins: ");
        Integer number_of_wins = Integer.parseInt(scanner.nextLine());
        out.println("Number of loses: ");
        Integer number_of_loses = Integer.parseInt(scanner.nextLine());
        out.println("Number of draws: ");
        Integer number_of_draws = Integer.parseInt(scanner.nextLine());
        out.println("Number of points: ");
        Integer number_of_points = Integer.parseInt(scanner.nextLine());
        return new Team(main_coach_id, name, UPL_position, number_of_wins, number_of_loses, number_of_draws,
                number_of_points);
    }

    private void getAllStadiums() throws SQLException {
        stadiumController.findAll().forEach(out::println);
    }

    private void getStadiumById() throws SQLException {
        out.println(stadiumController.findById(getId()));
    }

    private void createStadium() throws SQLException {
        stadiumController.create(getStadiumFromInput());
    }

    private void updateStadium() throws SQLException {
        Integer id = getId();
        Stadium stadium = getStadiumFromInput();
        stadium.setId(id);
        stadiumController.update(stadium.getId(), stadium);
    }

    private void deleteStadium() throws SQLException {
        stadiumController.delete(getId());
    }

    private Stadium getStadiumFromInput() {
        out.println("City id: ");
        Integer city_id = Integer.parseInt(scanner.nextLine());
        out.println("Name: ");
        String name = scanner.nextLine();
        out.println("Capacity: ");
        Integer capacity = Integer.parseInt(scanner.nextLine());
        return new Stadium(city_id, name, capacity);
    }


    private void getAllSponsors() throws SQLException {
        sponsorController.findAll().forEach(out::println);
    }

    private void getSponsorById() throws SQLException {
        out.println(sponsorController.findById(getId()));
    }

    private void createSponsor() throws SQLException {
        sponsorController.create(getSponsorFromInput());
    }

    private void updateSponsor() throws SQLException {
        Integer id = getId();
        Sponsor sponsor = getSponsorFromInput();
        sponsor.setId(id);
        sponsorController.update(sponsor.getId(), sponsor);
    }

    private void deleteSponsor() throws SQLException {
        sponsorController.delete(getId());
    }

    private Sponsor getSponsorFromInput() {
        out.println("Name: ");
        String name = scanner.nextLine();
        out.println("Start of contract: ");
        String start_of_contract = scanner.nextLine();
        out.println("End of contract: ");
        String end_of_contract = scanner.nextLine();
        return new Sponsor(name, start_of_contract, end_of_contract);
    }

    private void getAllReferees() throws SQLException {
        refereeController.findAll().forEach(out::println);
    }

    private void getRefereeById() throws SQLException {
        out.println(refereeController.findById(getId()));
    }

    private void createReferee() throws SQLException {
        refereeController.create(getRefereeFromInput());
    }

    private void updateReferee() throws SQLException {
        Integer id = getId();
        Referee referee = getRefereeFromInput();
        referee.setId(id);
        refereeController.update(referee.getId(), referee);
    }

    private void deleteReferee() throws SQLException {
        refereeController.delete(getId());
    }

    private Referee getRefereeFromInput() {
        out.println("Match Id: ");
        Integer match_id = Integer.parseInt(scanner.nextLine());
        out.println("Name: ");
        String name = scanner.nextLine();
        out.println("Surname: ");
        String surname = scanner.nextLine();
        out.println("Age: ");
        Integer age = Integer.parseInt(scanner.nextLine());
        out.println("Nationality: ");
        String nationality = scanner.nextLine();
        return new Referee(match_id, name, surname, age, nationality);
    }

    private void getAllPlayers() throws SQLException {
        playerController.findAll().forEach(out::println);
    }

    private void getPlayerById() throws SQLException {
        out.println(playerController.findById(getId()));
    }

    private void createPlayer() throws SQLException {
        playerController.create(getPlayerFromInput());
    }

    private void updatePlayer() throws SQLException {
        Integer id = getId();
        Player player = getPlayerFromInput();
        player.setId(id);
        playerController.update(player.getId(), player);
    }

    private void deletePlayer() throws SQLException {
        playerController.delete(getId());
    }

    private Player getPlayerFromInput() {
        out.println("Team Id: ");
        Integer team_id = Integer.parseInt(scanner.nextLine());
        out.println("Name: ");
        String name = scanner.nextLine();
        out.println("Surname: ");
        String surname = scanner.nextLine();
        out.println("Age: ");
        Integer age = Integer.parseInt(scanner.nextLine());
        out.println("Positon: ");
        String positon = scanner.nextLine();
        out.println("Salary: ");
        Integer salary_for_season_in_euros = Integer.parseInt(scanner.nextLine());
        out.println("Start of contract: ");
        String start_of_contract = scanner.nextLine();
        out.println("End of contract: ");
        String end_of_contract = scanner.nextLine();
        out.println("Nationality: ");
        String nationality = scanner.nextLine();
        out.println("Goals: ");
        Integer goals = Integer.parseInt(scanner.nextLine());
        out.println("Assists: ");
        Integer assists = Integer.parseInt(scanner.nextLine());
        return new Player(team_id, name, surname, age, positon, salary_for_season_in_euros, start_of_contract,
                end_of_contract, nationality, goals, assists);
    }

    private void getAllMatcheHasTeams() throws SQLException {
        matchHasTeamController.findAll().forEach(out::println);
    }

    private void getMatchHasTeamById() throws SQLException {
        out.println(matchHasTeamController.findById(getId()));
    }

    private void createMatchHasTeam() throws SQLException {
        matchHasTeamController.create(getMatchHasTeamFromInput());
    }

    private void updateMatchHasTeam() throws SQLException {
        Integer id = getId();
        MatchHasTeam matchHasTeam = getMatchHasTeamFromInput();
        matchHasTeam.setId(id);
        matchHasTeamController.update(matchHasTeam.getId(), matchHasTeam);
    }

    private void deleteMatchHasTeam() throws SQLException {
        matchHasTeamController.delete(getId());
    }

    private MatchHasTeam getMatchHasTeamFromInput() {
        out.println("Match Id: ");
        Integer match_id = Integer.parseInt(scanner.nextLine());
        out.println("Team id: ");
        Integer team_id = Integer.parseInt(scanner.nextLine());
        return new MatchHasTeam(match_id, team_id);
    }

    private void getAllMatches() throws SQLException {
        matchController.findAll().forEach(out::println);
    }

    private void getMatchById() throws SQLException {
        out.println(matchController.findById(getId()));
    }

    private void createMatch() throws SQLException {
        matchController.create(getMatchFromInput());
    }

    private void updateMatch() throws SQLException {
        Integer id = getId();
        Match match = getMatchFromInput();
        match.setId(id);
        matchController.update(match.getId(), match);
    }

    private Match getMatchFromInput() {
        out.println("Stadium Id: ");
        Integer stadium_id = Integer.parseInt(scanner.nextLine());
        out.println("Winner: ");
        String winner = scanner.nextLine();
        out.println("Loser: ");
        String loser = scanner.nextLine();
        out.println("Draw: ");
        Integer draw = Integer.parseInt(scanner.nextLine());
        out.println("Final score: ");
        String final_score = scanner.nextLine();
        out.println("Goals total: ");
        Integer goals_total = Integer.parseInt(scanner.nextLine());
        out.println("Red cards: ");
        Integer red_cards = Integer.parseInt(scanner.nextLine());
        out.println("Yellow cards: ");
        Integer yellow_cards = Integer.parseInt(scanner.nextLine());
        out.println("Number of replacements: ");
        Integer number_of_replacements = Integer.parseInt(scanner.nextLine());
        out.println("Number of fouls: ");
        Integer number_of_fouls = Integer.parseInt(scanner.nextLine());
        out.println("Number of offsides: ");
        Integer number_of_offsides = Integer.parseInt(scanner.nextLine());
        out.println("Number of corners: ");
        Integer number_of_corners = Integer.parseInt(scanner.nextLine());
        out.println("Start time: ");
        String start_time = scanner.nextLine();
        out.println("End time: ");
        String end_time = scanner.nextLine();
        return new Match(stadium_id, winner, loser, draw, final_score, goals_total, red_cards, yellow_cards,
                number_of_replacements, number_of_fouls, number_of_offsides, number_of_corners, start_time, end_time);
    }

    private void deleteMatch() throws SQLException {
        matchController.delete(getId());
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
        out.println("Name: ");
        String name = scanner.nextLine();
        return new City(name);
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
        return new MainCoach(name, surname, age, salary_for_season_in_euros, start_of_contract, end_of_contract,
                nationality);
    }

    private static void displayMenu() {
        out.println(
                        "1: city                                         1: GET ALL  \n" +
                        "2: main_coach                                   2: GET      \n" +
                        "3: match                                        3: CREATE   \n" +
                        "4: match_has_team                               4: UPDATE   \n" +
                        "5: player                                       5: DELETE   \n" +
                        "6: referee\n"   +
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
