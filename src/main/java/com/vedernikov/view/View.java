package com.vedernikov.view;

import com.vedernikov.controller.impl.*;
import com.vedernikov.model.entities.*;

import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class View {
    private static final Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

    private final CityController cityController = new CityController();
    private final MainCoachController mainCoachController = new MainCoachController();
    private final MatchController matchController = new MatchController();
    private final MatchHasTeamController matchHasTeamController = new MatchHasTeamController();
    private final PlayerController playerController = new PlayerController();
    private final RefereeController refereeController = new RefereeController();
    private final SponsorController sponsorController = new SponsorController();
    private final StadiumController stadiumController = new StadiumController();
    private final TeamController teamController = new TeamController();
    private final TeamHasSponsorController teamHasSponsorController = new TeamHasSponsorController();

    private final Map<String, Printable> menu = new LinkedHashMap<>();

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

        menu.put("41", this::getAllMatchHasTeam);
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

        menu.put("101", this::getAllTeamHasSponsor);
        menu.put("102", this::getTeamHasSponsorById);
        menu.put("103", this::createTeamHasSponsor);
        menu.put("104", this::updateTeamHasSponsor);
        menu.put("105", this::deleteTeamHasSponsor);

    }

    private void deleteTeamHasSponsor(){
        System.out.println("Enter ID: ");
        int id = scanner.nextInt();

        teamHasSponsorController.delete(id);
        System.out.println("Team Has Sponsor with ID = " + id + " successfully deleted");
    }

    private void deleteTeam(){
        System.out.println("Enter ID: ");
        int id = scanner.nextInt();

        teamController.delete(id);
        System.out.println("Team with ID = " + id + " successfully deleted");
    }

    private void deleteStadium(){
        System.out.println("Enter ID: ");
        int id = scanner.nextInt();

        stadiumController.delete(id);
        System.out.println("Stadium with ID = " + id + " successfully deleted");
    }

    private void deleteSponsor(){
        System.out.println("Enter ID: ");
        int id = scanner.nextInt();

        sponsorController.delete(id);
        System.out.println("Sponsor with ID = " + id + " successfully deleted");
    }

    private void deleteReferee(){
        System.out.println("Enter ID: ");
        int id = scanner.nextInt();

        refereeController.delete(id);
        System.out.println("Referee with ID = " + id + " successfully deleted");
    }

    private void deletePlayer(){
        System.out.println("Enter ID: ");
        int id = scanner.nextInt();

        playerController.delete(id);
        System.out.println("Player with ID = " + id + " successfully deleted");
    }

    private void deleteMatchHasTeam(){
        System.out.println("Enter ID: ");
        int id = scanner.nextInt();

        matchHasTeamController.delete(id);
        System.out.println("Match Has Team with ID = " + id + " successfully deleted");
    }

    private void deleteMatch(){
        System.out.println("Enter ID: ");
        int id = scanner.nextInt();

        matchController.delete(id);
        System.out.println("Match with ID = " + id + " successfully deleted");
    }

    private void deleteMainCoach(){
        System.out.println("Enter ID: ");
        int id = scanner.nextInt();

        mainCoachController.delete(id);
        System.out.println("Main Coach with ID = " + id + " successfully deleted");
    }

    private void deleteCity(){
        System.out.println("Enter ID: ");
        int id = scanner.nextInt();

        cityController.delete(id);
        System.out.println("City with ID = " + id + " successfully deleted");
    }

    private void updateTeamHasSponsor(){
        System.out.println("\nEnter ID: ");
        Integer id = scanner.nextInt();
        TeamHasSponsor teamHasSponsor = getTeamHasSponsorFromInput();
        teamHasSponsor.setId(id);
        teamHasSponsorController.update(teamHasSponsor.getId(), teamHasSponsor);

        System.out.println("Team Has Sponsor with ID = " + id + " successfully updated");
    }

    private void updateTeam(){
        System.out.println("\nEnter ID: ");
        Integer id = scanner.nextInt();
        Team team = getTeamFromInput();
        team.setId(id);
        teamController.update(team.getId(), team);

        System.out.println("Team with ID = " + id + " successfully updated");
    }

    private void updateStadium(){
        System.out.println("\nEnter ID: ");
        Integer id = scanner.nextInt();
        Stadium stadium = getStadiumFromInput();
        stadium.setId(id);
        stadiumController.update(stadium.getId(), stadium);

        System.out.println("Stadium with ID = " + id + " successfully updated");
    }

    private void updateSponsor(){
        System.out.println("\nEnter ID: ");
        Integer id = scanner.nextInt();
        Sponsor sponsor = getSponsorFromInput();
        sponsor.setId(id);
        sponsorController.update(sponsor.getId(), sponsor);

        System.out.println("Sponsor with ID = " + id + " successfully updated");
    }

    private void updateReferee(){
        System.out.println("\nEnter ID: ");
        Integer id = scanner.nextInt();
        Referee referee = getRefereeFromInput();
        referee.setId(id);
        refereeController.update(referee.getId(), referee);

        System.out.println("Referee with ID = " + id + " successfully updated");
    }

    private void updatePlayer(){
        System.out.println("\nEnter ID: ");
        Integer id = scanner.nextInt();
        Player player = getPlayerFromInput();
        player.setId(id);
        playerController.update(player.getId(), player);

        System.out.println("Player with ID = " + id + " successfully updated");
    }

    private void updateMatchHasTeam(){
        System.out.println("\nEnter ID: ");
        Integer id = scanner.nextInt();
        MatchHasTeam matchHasTeam = getMatchHasTeamFromInput();
        matchHasTeam.setId(id);
        matchHasTeamController.update(matchHasTeam.getId(), matchHasTeam);

        System.out.println("Match Has Team with ID = " + id + " successfully updated");
    }

    private void updateMatch(){
        System.out.println("\nEnter ID: ");
        Integer id = scanner.nextInt();
        Match match = getMatchFromInput();
        match.setId(id);
        matchController.update(match.getId(), match);

        System.out.println("Match with ID = " + id + " successfully updated");
    }

    private void updateMainCoach(){
        System.out.println("\nEnter ID: ");
        Integer id = scanner.nextInt();
        MainCoach mainCoach = getMainCoachFromInput();
        mainCoach.setId(id);
        mainCoachController.update(mainCoach.getId(), mainCoach);

        System.out.println("Main coach with ID = " + id + " successfully updated");
    }

    private void updateCity(){
        System.out.println("\nEnter ID: ");
        Integer id = scanner.nextInt();
        City city = getCityFromInput();
        city.setId(id);
        cityController.update(city.getId(), city);

        System.out.println("City with ID = " + id + " successfully updated");
    }

    private TeamHasSponsor getTeamHasSponsorFromInput() {
        System.out.println("Team Id: ");
        Integer team_id = Integer.parseInt(scanner.nextLine());
        System.out.println("Sponsor id: ");
        Integer sponsor_id = Integer.parseInt(scanner.nextLine());
        return new TeamHasSponsor(0, team_id, sponsor_id);
    }

    private void createTeamHasSponsor(){
        TeamHasSponsor teamHasSponsor = getTeamHasSponsorFromInput();
        teamHasSponsorController.create(teamHasSponsor);
    }

    private Team getTeamFromInput() {
        System.out.println("Main coach id: ");
        Integer main_coach_id = Integer.parseInt(scanner.nextLine());
        System.out.println("Name: ");
        String name = scanner.nextLine();
        System.out.println("UPL position: ");
        Integer UPL_position = Integer.parseInt(scanner.nextLine());
        System.out.println("Number of wins: ");
        Integer number_of_wins = Integer.parseInt(scanner.nextLine());
        System.out.println("Number of loses: ");
        Integer number_of_loses = Integer.parseInt(scanner.nextLine());
        System.out.println("Number of draws: ");
        Integer number_of_draws = Integer.parseInt(scanner.nextLine());
        System.out.println("Number of points: ");
        Integer number_of_points = Integer.parseInt(scanner.nextLine());
        return new Team(0, main_coach_id, name, UPL_position, number_of_wins, number_of_loses, number_of_draws,
                number_of_points);
    }

    private void createTeam(){
        Team team = getTeamFromInput();
        teamController.create(team);
    }

    private Stadium getStadiumFromInput() {
        System.out.println("City id: ");
        Integer city_id = Integer.parseInt(scanner.nextLine());
        System.out.println("Name: ");
        String name = scanner.nextLine();
        System.out.println("Capacity: ");
        Integer capacity = Integer.parseInt(scanner.nextLine());
        return new Stadium(0, city_id, name, capacity);
    }

    private void createStadium(){
        Stadium stadium = getStadiumFromInput();
        stadiumController.create(stadium);
    }

    private Sponsor getSponsorFromInput() {
        System.out.println("Name: ");
        String name = scanner.nextLine();
        System.out.println("Start of contract: ");
        String start_of_contract = scanner.nextLine();
        System.out.println("End of contract: ");
        String end_of_contract = scanner.nextLine();
        return new Sponsor(0, name, start_of_contract, end_of_contract);
    }

    private void createSponsor(){
        Sponsor sponsor = getSponsorFromInput();
        sponsorController.create(sponsor);
    }

    private Referee getRefereeFromInput() {
        System.out.println("Match Id: ");
        Integer match_id = Integer.parseInt(scanner.nextLine());
        System.out.println("Name: ");
        String name = scanner.nextLine();
        System.out.println("Surname: ");
        String surname = scanner.nextLine();
        System.out.println("Age: ");
        Integer age = Integer.parseInt(scanner.nextLine());
        System.out.println("Nationality: ");
        String nationality = scanner.nextLine();
        return new Referee(0, match_id, name, surname, age, nationality);
    }

    private void createReferee(){
        Referee referee = getRefereeFromInput();
        refereeController.create(referee);
    }

    private Player getPlayerFromInput() {
        System.out.println("Team Id: ");
        Integer team_id = Integer.parseInt(scanner.nextLine());
        System.out.println("Name: ");
        String name = scanner.nextLine();
        System.out.println("Surname: ");
        String surname = scanner.nextLine();
        System.out.println("Age: ");
        Integer age = Integer.parseInt(scanner.nextLine());
        System.out.println("Positon: ");
        String positon = scanner.nextLine();
        System.out.println("Salary: ");
        Integer salary_for_season_in_euros = Integer.parseInt(scanner.nextLine());
        System.out.println("Start of contract: ");
        String start_of_contract = scanner.nextLine();
        System.out.println("End of contract: ");
        String end_of_contract = scanner.nextLine();
        System.out.println("Nationality: ");
        String nationality = scanner.nextLine();
        System.out.println("Goals: ");
        Integer goals = Integer.parseInt(scanner.nextLine());
        System.out.println("Assists: ");
        Integer assists = Integer.parseInt(scanner.nextLine());
        return new Player(0, team_id, name, surname, age, positon, salary_for_season_in_euros, start_of_contract,
                end_of_contract, nationality, goals, assists);
    }

    private void createPlayer(){
        Player player = getPlayerFromInput();
        playerController.create(player);
    }

    private MatchHasTeam getMatchHasTeamFromInput() {
        System.out.println("Match Id: ");
        Integer match_id = Integer.parseInt(scanner.nextLine());
        System.out.println("Team id: ");
        Integer team_id = Integer.parseInt(scanner.nextLine());
        return new MatchHasTeam(0, match_id, team_id);
    }

    private void createMatchHasTeam(){
        MatchHasTeam matchHasTeam = getMatchHasTeamFromInput();
        matchHasTeamController.create(matchHasTeam);
    }

    private Match getMatchFromInput() {
        System.out.println("Stadium id: ");
        Integer stadium_id = Integer.parseInt(scanner.nextLine());
        System.out.println("Winner: ");
        String winner = scanner.nextLine();
        System.out.println("Loser: ");
        String loser = scanner.nextLine();
        System.out.println("Draw: ");
        Integer draw = Integer.parseInt(scanner.nextLine());
        System.out.println("Final score: ");
        String final_score = scanner.nextLine();
        System.out.println("Goals total: ");
        Integer goals_total = Integer.parseInt(scanner.nextLine());
        System.out.println("Red cards: ");
        Integer red_cards = Integer.parseInt(scanner.nextLine());
        System.out.println("Yellow cards: ");
        Integer yellow_cards = Integer.parseInt(scanner.nextLine());
        System.out.println("Number of replacements: ");
        Integer number_of_replacements = Integer.parseInt(scanner.nextLine());
        System.out.println("Number of fouls: ");
        Integer number_of_fouls = Integer.parseInt(scanner.nextLine());
        System.out.println("Number of offsides: ");
        Integer number_of_offsides = Integer.parseInt(scanner.nextLine());
        System.out.println("Number of corners: ");
        Integer number_of_corners = Integer.parseInt(scanner.nextLine());
        System.out.println("Start time: ");
        String start_time = scanner.nextLine();
        System.out.println("End time: ");
        String end_time = scanner.nextLine();
        return new Match(0, stadium_id, winner, loser, draw, final_score, goals_total, red_cards, yellow_cards,
                number_of_replacements, number_of_fouls, number_of_offsides, number_of_corners, start_time, end_time);
    }

    private void createMatch(){
        Match match = getMatchFromInput();
        matchController.create(match);
    }

    private MainCoach getMainCoachFromInput(){
        System.out.println("Enter name: ");
        String name = scanner.next();
        System.out.println("Enter surname: ");
        String surname = scanner.next();
        System.out.println("Enter age: ");
        Integer age = Integer.parseInt(scanner.next());
        System.out.println("Enter salary: ");
        Integer salary = Integer.parseInt(scanner.next());
        System.out.println("Enter start of contract: ");
        String start = scanner.next();
        System.out.println("Enter end of contract: ");
        String end = scanner.next();
        System.out.println("Enter nationality: ");
        String nationality = scanner.next();
        return new MainCoach(0, name, surname, age, salary, start, end, nationality);
    }

    private void createMainCoach(){
        MainCoach mainCoach = getMainCoachFromInput();
        mainCoachController.create(mainCoach);
    }

    private City getCityFromInput(){
        System.out.println("Enter name: ");
        String name = scanner.next();
        return new City(0, name);
    }

    private void createCity(){
        City city = getCityFromInput();
        cityController.create(city);
    }

    private void getCityById(){
        System.out.println("\nEnter ID: ");
        Integer id = scanner.nextInt();
        System.out.println(cityController.findById(id) + "\n");
    }

    private void getMainCoachById(){
        System.out.println("\nEnter ID: ");
        Integer id = scanner.nextInt();
        System.out.println(mainCoachController.findById(id) + "\n");
    }

    private void getMatchById(){
        System.out.println("\nEnter ID: ");
        Integer id = scanner.nextInt();
        System.out.println(matchController.findById(id) + "\n");
    }

    private void getMatchHasTeamById(){
        System.out.println("\nEnter ID: ");
        Integer id = scanner.nextInt();
        System.out.println(matchHasTeamController.findById(id) + "\n");
    }

    private void getPlayerById(){
        System.out.println("\nEnter ID: ");
        Integer id = scanner.nextInt();
        System.out.println(playerController.findById(id) + "\n");
    }

    private void getRefereeById(){
        System.out.println("\nEnter ID: ");
        Integer id = scanner.nextInt();
        System.out.println(refereeController.findById(id) + "\n");
    }

    private void getSponsorById(){
        System.out.println("\nEnter ID: ");
        Integer id = scanner.nextInt();
        System.out.println(sponsorController.findById(id) + "\n");
    }

    private void getStadiumById(){
        System.out.println("\nEnter ID: ");
        Integer id = scanner.nextInt();
        System.out.println(stadiumController.findById(id) + "\n");
    }

    private void getTeamById(){
        System.out.println("\nEnter ID: ");
        Integer id = scanner.nextInt();
        System.out.println(teamController.findById(id) + "\n");
    }

    private void getTeamHasSponsorById(){
        System.out.println("\nEnter ID: ");
        Integer id = scanner.nextInt();
        System.out.println(teamHasSponsorController.findById(id) + "\n");
    }

    private void getAllCities(){
        System.out.println(cityController.findAll() + "\n");
    }

    private void getAllMainCoaches(){
        System.out.println(mainCoachController.findAll() + "\n");
    }

    private void getAllMatches(){
        System.out.println(matchController.findAll() + "\n");
    }

    private void getAllMatchHasTeam(){
        System.out.println(matchHasTeamController.findAll() + "\n");
    }

    private void getAllPlayers(){
        System.out.println(playerController.findAll() + "\n");
    }

    private void getAllReferees(){
        System.out.println(refereeController.findAll() + "\n");
    }

    private void getAllSponsors(){
        System.out.println(sponsorController.findAll() + "\n");
    }

    private void getAllStadiums(){
        System.out.println(stadiumController.findAll() + "\n");
    }

    private void getAllTeams(){
        System.out.println(teamController.findAll() + "\n");
    }

    private void getAllTeamHasSponsor(){
        System.out.println(teamHasSponsorController.findAll() + "\n");
    }

    public void displayMenu(){
        System.out.println("----------------------------------------------------------");
        System.out.println("  1 - City                   |        1 - GET ALL");
        System.out.println("  2 - Main Coach             |        2 - GET ONE");
        System.out.println("  3 - Match                  |        3 - CREATE");
        System.out.println("  4 - Match Has Team         |        4 - UPDATE");
        System.out.println("  5 - Player                 |        5 - DELETE");
        System.out.println("  6 - Referee                |                     ");
        System.out.println("  7 - Sponsor                |                     ");
        System.out.println("  8 - Stadium                |                     ");
        System.out.println("  9 - Team                   |                     ");
        System.out.println("  10 - Team Has Sponsor      |                     ");

        System.out.println("----------------------------------------------------------");
    }

    public final void show() {
        String input;
        displayMenu();
        System.out.println("\nChoose your table:\n");
        do {
            try {
                input = scanner.next();
                menu.get(input).print();
            } catch (Exception ignored) {
            }
        } while (scanner.hasNext());
    }
}
