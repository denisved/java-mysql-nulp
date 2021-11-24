CREATE DATABASE IF NOT EXISTS lab3;
USE lab3;

DROP TABLE IF EXISTS Match_has_Team;
DROP TABLE IF EXISTS Team_has_Sponsor;
DROP TABLE IF EXISTS Player;
DROP TABLE IF EXISTS Team;
DROP TABLE IF EXISTS Referee;
DROP TABLE IF EXISTS `Match`;
DROP TABLE IF EXISTS Sponsor;
DROP TABLE IF EXISTS Main_Coach;
DROP TABLE IF EXISTS Stadium;
DROP TABLE IF EXISTS City;

CREATE TABLE City (
                      `id` INT NOT NULL AUTO_INCREMENT,
                      `name` VARCHAR(45) NOT NULL,
                      PRIMARY KEY (`id`),
                      UNIQUE INDEX `Name_UNIQUE` (`name` ASC) VISIBLE)
    ENGINE = InnoDB;

CREATE TABLE Stadium (
                         `id` INT NOT NULL AUTO_INCREMENT,
                         `City_id` INT NOT NULL,
                         `name` VARCHAR(45) NOT NULL,
                         `capacity` INT NOT NULL,
                         PRIMARY KEY (`id`, `City_id`),
                         INDEX `fk_Stadium_City1_idx` (`City_id` ASC) VISIBLE,
                         UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE,
                         CONSTRAINT `fk_Stadium_City1`
                             FOREIGN KEY (`City_id`)
                                 REFERENCES `lab3`.`City` (`id`)
                                 ON DELETE NO ACTION
                                 ON UPDATE NO ACTION)
    ENGINE = InnoDB;

CREATE TABLE `Match` (
                         `id` INT NOT NULL AUTO_INCREMENT,
                         `Stadium_id` INT NOT NULL,
                         `winner` VARCHAR(45) NULL,
                         `loser` VARCHAR(45) NULL,
                         `draw` TINYINT NULL,
                         `final_score` VARCHAR(5) NOT NULL,
                         `goals_total` INT NOT NULL,
                         `red_cards` INT NOT NULL,
                         `yellow_cards` INT NOT NULL,
                         `number_of_replacements` INT NOT NULL,
                         `number_of_fouls` INT NOT NULL,
                         `number_of_offsides` INT NOT NULL,
                         `number_of_corners` INT NOT NULL,
                         `start_time` DATETIME NOT NULL,
                         `end_time` DATETIME NOT NULL,
                         PRIMARY KEY (`id`, `Stadium_id`),
                         INDEX `fk_Match_Stadium1_idx` (`Stadium_id` ASC) VISIBLE,
                         CONSTRAINT `fk_Match_Stadium1`
                             FOREIGN KEY (`Stadium_id`)
                                 REFERENCES `lab3`.`Stadium` (`id`)
                                 ON DELETE NO ACTION
                                 ON UPDATE NO ACTION)
    ENGINE = InnoDB;

CREATE TABLE Main_Coach (
                            `id` INT NOT NULL AUTO_INCREMENT,
                            `name` VARCHAR(45) NOT NULL,
                            `surname` VARCHAR(45) NOT NULL,
                            `age` INT NOT NULL,
                            `salary_for_season_in_euros` INT NOT NULL,
                            `start_of_contract` DATE NOT NULL,
                            `end_of_contract` DATE NOT NULL,
                            `nationality` VARCHAR(45) NOT NULL,
                            PRIMARY KEY (`id`))
    ENGINE = InnoDB;

CREATE TABLE Team (
                      `id` INT NOT NULL AUTO_INCREMENT,
                      `Main_Coach_id` INT NOT NULL,
                      `name` VARCHAR(45) NOT NULL,
                      `UPL_position` INT NOT NULL,
                      `number_of_wins` INT NOT NULL,
                      `number_of_loses` INT NOT NULL,
                      `number_of_draws` INT NOT NULL,
                      `number_of_points` INT NOT NULL,
                      PRIMARY KEY (`id`, `Main_Coach_id`),
                      INDEX `fk_Team_Main_Coach1_idx` (`Main_Coach_id` ASC) VISIBLE,
                      UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE,
                      UNIQUE INDEX `Main_Coach_id_UNIQUE` (`Main_Coach_id` ASC) VISIBLE,
                      UNIQUE INDEX `UPL_position_UNIQUE` (`UPL_position` ASC) VISIBLE,
                      CONSTRAINT `fk_Team_Main_Coach1`
                          FOREIGN KEY (`Main_Coach_id`)
                              REFERENCES `lab3`.`Main_Coach` (`id`)
                              ON DELETE NO ACTION
                              ON UPDATE NO ACTION)
    ENGINE = InnoDB;

CREATE TABLE Player (
                        `id` INT NOT NULL AUTO_INCREMENT,
                        `Team_id` INT NOT NULL,
                        `name` VARCHAR(45) NOT NULL,
                        `surname` VARCHAR(45) NOT NULL,
                        `age` INT NOT NULL,
                        `positon` VARCHAR(30) NOT NULL,
                        `salary_for_season_in_euros` INT NOT NULL,
                        `start_of_contract` DATE NOT NULL,
                        `end_of_contract` DATE NOT NULL,
                        `nationality` VARCHAR(45) NOT NULL,
                        `goals` INT NOT NULL,
                        `assists` INT NOT NULL,
                        PRIMARY KEY (`id`, `Team_id`),
                        INDEX `fk_Player_Team1_idx` (`Team_id` ASC) VISIBLE,
                        CONSTRAINT `fk_Player_Team1`
                            FOREIGN KEY (`Team_id`)
                                REFERENCES `lab3`.`Team` (`id`)
                                ON DELETE NO ACTION
                                ON UPDATE NO ACTION)
    ENGINE = InnoDB;

CREATE TABLE Sponsor (
                         `id` INT NOT NULL AUTO_INCREMENT,
                         `name` VARCHAR(45) NOT NULL,
                         `start_of_contract` DATE NOT NULL,
                         `end_of_contract` DATE NOT NULL,
                         PRIMARY KEY (`id`),
                         UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
    ENGINE = InnoDB;

CREATE TABLE Referee (
                         `id` INT NOT NULL AUTO_INCREMENT,
                         `Match_id` INT NOT NULL,
                         `name` VARCHAR(45) NOT NULL,
                         `surname` VARCHAR(45) NOT NULL,
                         `age` INT NOT NULL,
                         `nationality` VARCHAR(45) NOT NULL,
                         PRIMARY KEY (`id`, `Match_id`),
                         INDEX `fk_Referee_Match1_idx` (`Match_id` ASC) VISIBLE,
                         CONSTRAINT `fk_Referee_Match1`
                             FOREIGN KEY (`Match_id`)
                                 REFERENCES `lab3`.`Match` (`id`)
                                 ON DELETE NO ACTION
                                 ON UPDATE NO ACTION)
    ENGINE = InnoDB;

CREATE TABLE Team_has_Sponsor (
                                  `id` INT NOT NULL AUTO_INCREMENT,
                                  `Team_id` INT NOT NULL,
                                  `Sponsor_id` INT NOT NULL,
                                  INDEX `fk_Team_has_Sponsor_Sponsor1_idx` (`Sponsor_id` ASC) VISIBLE,
                                  INDEX `fk_Team_has_Sponsor_Team1_idx` (`Team_id` ASC) VISIBLE,
                                  PRIMARY KEY (`id`),
                                  CONSTRAINT `fk_Team_has_Sponsor_Team1`
                                      FOREIGN KEY (`Team_id`)
                                          REFERENCES `lab3`.`Team` (`id`)
                                          ON DELETE NO ACTION
                                          ON UPDATE NO ACTION,
                                  CONSTRAINT `fk_Team_has_Sponsor_Sponsor1`
                                      FOREIGN KEY (`Sponsor_id`)
                                          REFERENCES `lab3`.`Sponsor` (`id`)
                                          ON DELETE NO ACTION
                                          ON UPDATE NO ACTION)
    ENGINE = InnoDB;

CREATE TABLE Match_has_Team (
                                `Match_id` INT NOT NULL,
                                `Team_id` INT NOT NULL,
                                `id` INT NOT NULL AUTO_INCREMENT,
                                INDEX `fk_Match_has_Team_Team1_idx` (`Team_id` ASC) VISIBLE,
                                INDEX `fk_Match_has_Team_Match1_idx` (`Match_id` ASC) VISIBLE,
                                PRIMARY KEY (`id`),
                                CONSTRAINT `fk_Match_has_Team_Match1`
                                    FOREIGN KEY (`Match_id`)
                                        REFERENCES `lab3`.`Match` (`id`)
                                        ON DELETE NO ACTION
                                        ON UPDATE NO ACTION,
                                CONSTRAINT `fk_Match_has_Team_Team1`
                                    FOREIGN KEY (`Team_id`)
                                        REFERENCES `lab3`.`Team` (`id`)
                                        ON DELETE NO ACTION
                                        ON UPDATE NO ACTION)
    ENGINE = InnoDB;

INSERT INTO `lab3`.`city` (`id`, `name`) VALUES ('1', 'Lviv');
INSERT INTO `lab3`.`city` (`id`, `name`) VALUES ('2', 'Kyiv');
INSERT INTO `lab3`.`city` (`id`, `name`) VALUES ('3', 'Odessa');
INSERT INTO `lab3`.`city` (`id`, `name`) VALUES ('4', 'Kharkiv');
INSERT INTO `lab3`.`city` (`id`, `name`) VALUES ('5', 'Ivano-Frankivsk');
INSERT INTO `lab3`.`city` (`id`, `name`) VALUES ('6', 'Donetsk');
INSERT INTO `lab3`.`city` (`id`, `name`) VALUES ('7', 'Lugansk');
INSERT INTO `lab3`.`city` (`id`, `name`) VALUES ('8', 'Poltava');
INSERT INTO `lab3`.`city` (`id`, `name`) VALUES ('9', 'Herson');
INSERT INTO `lab3`.`city` (`id`, `name`) VALUES ('10', 'Dnirpo');

INSERT INTO `lab3`.`stadium` (`id`, `City_id`, `name`, `capacity`) VALUES ('1', '6', 'Donbass Arena', '51504');
INSERT INTO `lab3`.`stadium` (`id`, `City_id`, `name`, `capacity`) VALUES ('2', '4', 'Metalist', '40003');
INSERT INTO `lab3`.`stadium` (`id`, `City_id`, `name`, `capacity`) VALUES ('3', '1', 'Arena Lviv', '34915');
INSERT INTO `lab3`.`stadium` (`id`, `City_id`, `name`, `capacity`) VALUES ('4', '1', 'Ukraine', '28051');
INSERT INTO `lab3`.`stadium` (`id`, `City_id`, `name`, `capacity`) VALUES ('5', '1', 'SKA', '23040');
INSERT INTO `lab3`.`stadium` (`id`, `City_id`, `name`, `capacity`) VALUES ('6', '6', 'Shakhtar', '31718');
INSERT INTO `lab3`.`stadium` (`id`, `City_id`, `name`, `capacity`) VALUES ('7', '10', 'Dnepr Arena', '31003');
INSERT INTO `lab3`.`stadium` (`id`, `City_id`, `name`, `capacity`) VALUES ('8', '2', 'NSK Olimpiyskiy', '70050');
INSERT INTO `lab3`.`stadium` (`id`, `City_id`, `name`, `capacity`) VALUES ('9', '7', 'Avangard', '22288');
INSERT INTO `lab3`.`stadium` (`id`, `City_id`, `name`, `capacity`) VALUES ('10', '5', 'Ruh', '15000');

INSERT INTO `lab3`.`main_coach` (`id`, `name`, `surname`, `age`, `salary_for_season_in_euros`, `start_of_contract`, `end_of_contract`, `nationality`) VALUES ('1', 'Mircha', 'Luchesku', '76', '1200000', '2020-09-01', '2024-09-01', 'Romanian');
INSERT INTO `lab3`.`main_coach` (`id`, `name`, `surname`, `age`, `salary_for_season_in_euros`, `start_of_contract`, `end_of_contract`, `nationality`) VALUES ('2', 'Roberto', 'De Dzerbi', '42', '900000', '2021-09-01', '2025-09-01', 'Italian');
INSERT INTO `lab3`.`main_coach` (`id`, `name`, `surname`, `age`, `salary_for_season_in_euros`, `start_of_contract`, `end_of_contract`, `nationality`) VALUES ('3', 'Yuriy', 'Maksimov', '52', '250000', '2019-03-15', '2023-03-15', 'Ukranian');
INSERT INTO `lab3`.`main_coach` (`id`, `name`, `surname`, `age`, `salary_for_season_in_euros`, `start_of_contract`, `end_of_contract`, `nationality`) VALUES ('4', 'Victor', 'Skripnik', '51', '230000', '2018-05-12', '2022-05-12', 'Ukranian');
INSERT INTO `lab3`.`main_coach` (`id`, `name`, `surname`, `age`, `salary_for_season_in_euros`, `start_of_contract`, `end_of_contract`, `nationality`) VALUES ('5', 'Igor', 'Yovichevich', '47', '200000', '2018-09-01', '2022-09-01', 'Chroatian');
INSERT INTO `lab3`.`main_coach` (`id`, `name`, `surname`, `age`, `salary_for_season_in_euros`, `start_of_contract`, `end_of_contract`, `nationality`) VALUES ('6', 'Yuriy', 'Gura', '45', '150000', '2017-12-15', '2021-12-15', 'Ukranian');
INSERT INTO `lab3`.`main_coach` (`id`, `name`, `surname`, `age`, `salary_for_season_in_euros`, `start_of_contract`, `end_of_contract`, `nationality`) VALUES ('7', 'Oleksandr', 'Ryabokon', '57', '120000', '2019-01-01', '2023-01-01', 'Ukranian');
INSERT INTO `lab3`.`main_coach` (`id`, `name`, `surname`, `age`, `salary_for_season_in_euros`, `start_of_contract`, `end_of_contract`, `nationality`) VALUES ('8', 'Valeriy', 'Krivencov', '48', '100000', '2018-05-20', '2022-05-20', 'Ukranian');
INSERT INTO `lab3`.`main_coach` (`id`, `name`, `surname`, `age`, `salary_for_season_in_euros`, `start_of_contract`, `end_of_contract`, `nationality`) VALUES ('9', 'Oleksandr', 'Zotov', '46', '50000', '2020-03-05', '2024-03-05', 'Ukranian');
INSERT INTO `lab3`.`main_coach` (`id`, `name`, `surname`, `age`, `salary_for_season_in_euros`, `start_of_contract`, `end_of_contract`, `nationality`) VALUES ('10', 'Leonid', 'Kuchuk', '62', '45000', '2020-06-01', '2024-06-01', 'Belarusian');

INSERT INTO `lab3`.`team` (`id`, `Main_Coach_id`, `name`, `UPL_position`, `number_of_wins`, `number_of_loses`, `number_of_draws`, `number_of_points`) VALUES ('1', '1', 'Dynamo Kiev', '1', '8', '0', '2', '26');
INSERT INTO `lab3`.`team` (`id`, `Main_Coach_id`, `name`, `UPL_position`, `number_of_wins`, `number_of_loses`, `number_of_draws`, `number_of_points`) VALUES ('2', '2', 'Shakhtar Donetsk', '2', '7', '1', '2', '23');
INSERT INTO `lab3`.`team` (`id`, `Main_Coach_id`, `name`, `UPL_position`, `number_of_wins`, `number_of_loses`, `number_of_draws`, `number_of_points`) VALUES ('3', '3', 'Vorskla', '3', '6', '1', '3', '21');
INSERT INTO `lab3`.`team` (`id`, `Main_Coach_id`, `name`, `UPL_position`, `number_of_wins`, `number_of_loses`, `number_of_draws`, `number_of_points`) VALUES ('4', '4', 'Zorya', '4', '6', '2', '2', '20');
INSERT INTO `lab3`.`team` (`id`, `Main_Coach_id`, `name`, `UPL_position`, `number_of_wins`, `number_of_loses`, `number_of_draws`, `number_of_points`) VALUES ('5', '5', 'Dnipro-1', '5', '6', '3', '1', '19');
INSERT INTO `lab3`.`team` (`id`, `Main_Coach_id`, `name`, `UPL_position`, `number_of_wins`, `number_of_loses`, `number_of_draws`, `number_of_points`) VALUES ('6', '6', 'Oleksandria', '6', '5', '2', '3', '18');
INSERT INTO `lab3`.`team` (`id`, `Main_Coach_id`, `name`, `UPL_position`, `number_of_wins`, `number_of_loses`, `number_of_draws`, `number_of_points`) VALUES ('7', '7', 'Desna', '7', '5', '4', '1', '16');
INSERT INTO `lab3`.`team` (`id`, `Main_Coach_id`, `name`, `UPL_position`, `number_of_wins`, `number_of_loses`, `number_of_draws`, `number_of_points`) VALUES ('8', '8', 'Metalist 1925', '8', '4', '5', '1', '13');
INSERT INTO `lab3`.`team` (`id`, `Main_Coach_id`, `name`, `UPL_position`, `number_of_wins`, `number_of_loses`, `number_of_draws`, `number_of_points`) VALUES ('9', '9', 'Veres', '9', '3', '4', '3', '12');
INSERT INTO `lab3`.`team` (`id`, `Main_Coach_id`, `name`, `UPL_position`, `number_of_wins`, `number_of_loses`, `number_of_draws`, `number_of_points`) VALUES ('10', '10', 'Ruh', '10', '3', '5', '2', '11');

INSERT INTO `lab3`.`player` (`id`, `Team_id`, `name`, `surname`, `age`, `positon`, `salary_for_season_in_euros`, `start_of_contract`, `end_of_contract`, `nationality`, `goals`, `assists`) VALUES ('1', '1', 'Georgiy', 'Bushchan', '27', 'Goalkeeper', '150000', '2020-08-01', '2024-08-01', 'Ukranian', '0', '0');
INSERT INTO `lab3`.`player` (`id`, `Team_id`, `name`, `surname`, `age`, `positon`, `salary_for_season_in_euros`, `start_of_contract`, `end_of_contract`, `nationality`, `goals`, `assists`) VALUES ('2', '2', 'Michael', 'Mudryk', '20', 'Midfielder', '70000', '2019-08-01', '2023-08-01', 'Ukranian', '1', '3');
INSERT INTO `lab3`.`player` (`id`, `Team_id`, `name`, `surname`, `age`, `positon`, `salary_for_season_in_euros`, `start_of_contract`, `end_of_contract`, `nationality`, `goals`, `assists`) VALUES ('3', '3', 'Ivan', 'Peshich', '29', 'Midfielder', '50000', '2018-06-20', '2020-06-20', 'Croatian', '0', '0');
INSERT INTO `lab3`.`player` (`id`, `Team_id`, `name`, `surname`, `age`, `positon`, `salary_for_season_in_euros`, `start_of_contract`, `end_of_contract`, `nationality`, `goals`, `assists`) VALUES ('4', '4', 'Dmytro', 'Homchenovskiy', '31', 'Stricker', '45000', '2017-07-01', '2021-07-01', 'Ukranian', '0', '1');
INSERT INTO `lab3`.`player` (`id`, `Team_id`, `name`, `surname`, `age`, `positon`, `salary_for_season_in_euros`, `start_of_contract`, `end_of_contract`, `nationality`, `goals`, `assists`) VALUES ('5', '5', 'Monte', 'Nelson', '26', 'Defender', '42000', '2020-06-01', '2024-06-01', 'Portuguese', '0', '0');
INSERT INTO `lab3`.`player` (`id`, `Team_id`, `name`, `surname`, `age`, `positon`, `salary_for_season_in_euros`, `start_of_contract`, `end_of_contract`, `nationality`, `goals`, `assists`) VALUES ('6', '6', 'Klaudio', 'Spinelli', '24', 'Stricker', '40000', '2020-06-01', '2024-06-01', 'Argentinian', '1', '0');
INSERT INTO `lab3`.`player` (`id`, `Team_id`, `name`, `surname`, `age`, `positon`, `salary_for_season_in_euros`, `start_of_contract`, `end_of_contract`, `nationality`, `goals`, `assists`) VALUES ('7', '7', 'Maksym', 'Degtyarov', '28', 'Stricker', '39000', '2019-08-05', '2024-08-05', 'Ukranian', '0', '0');
INSERT INTO `lab3`.`player` (`id`, `Team_id`, `name`, `surname`, `age`, `positon`, `salary_for_season_in_euros`, `start_of_contract`, `end_of_contract`, `nationality`, `goals`, `assists`) VALUES ('8', '8', 'Dmytro', 'Kryskiv', '21', 'Midfielder', '35000', '2021-07-01', '2025-07-01', 'Ukranian', '1', '0');
INSERT INTO `lab3`.`player` (`id`, `Team_id`, `name`, `surname`, `age`, `positon`, `salary_for_season_in_euros`, `start_of_contract`, `end_of_contract`, `nationality`, `goals`, `assists`) VALUES ('9', '9', 'Bogdan', 'Kogut', '33', 'Goalkeeper', '30000', '2018-08-01', '2022-08-01', 'Ukranian', '0', '0');
INSERT INTO `lab3`.`player` (`id`, `Team_id`, `name`, `surname`, `age`, `positon`, `salary_for_season_in_euros`, `start_of_contract`, `end_of_contract`, `nationality`, `goals`, `assists`) VALUES ('10', '10', 'Ostap', 'Prytula', '21', 'Midfielder', '30000', '2020-08-10', '2024-08-10', 'Ukranian', '0', '0');

INSERT INTO `lab3`.`sponsor` (`id`, `name`, `start_of_contract`, `end_of_contract`) VALUES ('1', 'Parimatch', '2020-06-01', '2024-06-01');
INSERT INTO `lab3`.`sponsor` (`id`, `name`, `start_of_contract`, `end_of_contract`) VALUES ('2', 'VBET', '2019-08-01', '2023-08-01');
INSERT INTO `lab3`.`sponsor` (`id`, `name`, `start_of_contract`, `end_of_contract`) VALUES ('3', '1XBET', '2021-09-01', '2025-09-01');

INSERT INTO `lab3`.`team_has_sponsor` (`id`, `Team_id`, `Sponsor_id`) VALUES ('1', '1', '1');
INSERT INTO `lab3`.`team_has_sponsor` (`id`, `Team_id`, `Sponsor_id`) VALUES ('2', '2', '1');
INSERT INTO `lab3`.`team_has_sponsor` (`id`, `Team_id`, `Sponsor_id`) VALUES ('3', '3', '3');
INSERT INTO `lab3`.`team_has_sponsor` (`id`, `Team_id`, `Sponsor_id`) VALUES ('4', '4', '3');
INSERT INTO `lab3`.`team_has_sponsor` (`id`, `Team_id`, `Sponsor_id`) VALUES ('5', '5', '2');
INSERT INTO `lab3`.`team_has_sponsor` (`id`, `Team_id`, `Sponsor_id`) VALUES ('6', '6', '3');
INSERT INTO `lab3`.`team_has_sponsor` (`id`, `Team_id`, `Sponsor_id`) VALUES ('7', '7', '3');
INSERT INTO `lab3`.`team_has_sponsor` (`id`, `Team_id`, `Sponsor_id`) VALUES ('8', '8', '1');
INSERT INTO `lab3`.`team_has_sponsor` (`id`, `Team_id`, `Sponsor_id`) VALUES ('9', '9', '2');
INSERT INTO `lab3`.`team_has_sponsor` (`id`, `Team_id`, `Sponsor_id`) VALUES ('10', '10', '3');

INSERT INTO `lab3`.`match` (`id`, `Stadium_id`, `winner`, `loser`, `draw`, `final_score`, `goals_total`, `red_cards`, `yellow_cards`, `number_of_replacements`, `number_of_fouls`, `number_of_offsides`, `number_of_corners`, `start_time`, `end_time`) VALUES ('1', '5', 'Zorya', 'Desna', '0', '2:1', '3', '0', '2', '6', '10', '0', '12', '2021-09-01 19:00:00', '2021-09-01 20:30:00');
INSERT INTO `lab3`.`match` (`id`, `Stadium_id`, `winner`, `loser`, `draw`, `final_score`, `goals_total`, `red_cards`, `yellow_cards`, `number_of_replacements`, `number_of_fouls`, `number_of_offsides`, `number_of_corners`, `start_time`, `end_time`) VALUES ('2', '4', 'Metalist 1925', 'Ruh', '0', '1:0', '1', '0', '2', '4', '7', '2', '10', '2021-09-01 20:00:00', '2021-09-01 21:35:00');
INSERT INTO `lab3`.`match` (`id`, `Stadium_id`, `winner`, `loser`, `draw`, `final_score`, `goals_total`, `red_cards`, `yellow_cards`, `number_of_replacements`, `number_of_fouls`, `number_of_offsides`, `number_of_corners`, `start_time`, `end_time`) VALUES ('3', '3', 'Shakhtar Donetsk', 'Veres', '0', '3:0', '3', '2', '1', '3', '12', '1', '9', '2021-09-01 21:00:00', '2021-09-01 22:34:00');
INSERT INTO `lab3`.`match` (`id`, `Stadium_id`, `winner`, `loser`, `draw`, `final_score`, `goals_total`, `red_cards`, `yellow_cards`, `number_of_replacements`, `number_of_fouls`, `number_of_offsides`, `number_of_corners`, `start_time`, `end_time`) VALUES ('4', '2', 'Dynamo Kiev', 'Vorskla', '0', '2:0', '2', '1', '3', '2', '15', '0', '11', '2021-09-01 21:00:00', '2021-09-01 22:35:00');
INSERT INTO `lab3`.`match` (`id`, `Stadium_id`, `winner`, `loser`, `draw`, `final_score`, `goals_total`, `red_cards`, `yellow_cards`, `number_of_replacements`, `number_of_fouls`, `number_of_offsides`, `number_of_corners`, `start_time`, `end_time`) VALUES ('5', '1', 'Dynamo Kiev', 'Metalist 1925', '0', '3:0', '3', '0', '0', '3', '13', '1', '13', '2021-09-02 19:00:00', '2021-09-02 20:36:00');
INSERT INTO `lab3`.`match` (`id`, `Stadium_id`, `draw`, `final_score`, `goals_total`, `red_cards`, `yellow_cards`, `number_of_replacements`, `number_of_fouls`, `number_of_offsides`, `number_of_corners`, `start_time`, `end_time`) VALUES ('6', '10', '1', '3:3', '6', '0', '0', '4', '9', '1', '14', '2021-09-02 19:00:00', '2021-09-02 20:32:00');
INSERT INTO `lab3`.`match` (`id`, `Stadium_id`, `draw`, `final_score`, `goals_total`, `red_cards`, `yellow_cards`, `number_of_replacements`, `number_of_fouls`, `number_of_offsides`, `number_of_corners`, `start_time`, `end_time`) VALUES ('7', '9', '1', '2:2', '4', '1', '3', '5', '8', '2', '10', '2021-09-02 20:00:00', '2021-09-02 21:36:00');
INSERT INTO `lab3`.`match` (`id`, `Stadium_id`, `draw`, `final_score`, `goals_total`, `red_cards`, `yellow_cards`, `number_of_replacements`, `number_of_fouls`, `number_of_offsides`, `number_of_corners`, `start_time`, `end_time`) VALUES ('8', '8', '1', '1:1', '2', '0', '2', '2', '11', '0', '9', '2021-09-02 20:00:00', '2021-09-02 21:36:00');
INSERT INTO `lab3`.`match` (`id`, `Stadium_id`, `draw`, `final_score`, `goals_total`, `red_cards`, `yellow_cards`, `number_of_replacements`, `number_of_fouls`, `number_of_offsides`, `number_of_corners`, `start_time`, `end_time`) VALUES ('9', '7', '1', '0:0', '0', '0', '0', '1', '14', '0', '10', '2021-09-02 21:00:00', '2021-09-02 22:40:00');
INSERT INTO `lab3`.`match` (`id`, `Stadium_id`, `draw`, `final_score`, `goals_total`, `red_cards`, `yellow_cards`, `number_of_replacements`, `number_of_fouls`, `number_of_offsides`, `number_of_corners`, `start_time`, `end_time`) VALUES ('10', '6', '1', '2:2', '4', '1', '1', '3', '12', '3', '8', '2021-09-02 21:00:00', '2021-09-02 22:39:00');

INSERT INTO `lab3`.`match_has_team` (`Match_id`, `Team_id`, `id`) VALUES ('1', '7', '1');
INSERT INTO `lab3`.`match_has_team` (`Match_id`, `Team_id`, `id`) VALUES ('1', '4', '2');
INSERT INTO `lab3`.`match_has_team` (`Match_id`, `Team_id`, `id`) VALUES ('2', '8', '3');
INSERT INTO `lab3`.`match_has_team` (`Match_id`, `Team_id`, `id`) VALUES ('2', '10', '4');
INSERT INTO `lab3`.`match_has_team` (`Match_id`, `Team_id`, `id`) VALUES ('3', '2', '5');
INSERT INTO `lab3`.`match_has_team` (`Match_id`, `Team_id`, `id`) VALUES ('3', '9', '6');
INSERT INTO `lab3`.`match_has_team` (`Match_id`, `Team_id`, `id`) VALUES ('4', '1', '7');
INSERT INTO `lab3`.`match_has_team` (`Match_id`, `Team_id`, `id`) VALUES ('4', '3', '8');
INSERT INTO `lab3`.`match_has_team` (`Match_id`, `Team_id`, `id`) VALUES ('5', '1', '9');
INSERT INTO `lab3`.`match_has_team` (`Match_id`, `Team_id`, `id`) VALUES ('5', '8', '10');
INSERT INTO `lab3`.`match_has_team` (`Match_id`, `Team_id`, `id`) VALUES ('6', '4', '11');
INSERT INTO `lab3`.`match_has_team` (`Match_id`, `Team_id`, `id`) VALUES ('6', '5', '12');
INSERT INTO `lab3`.`match_has_team` (`Match_id`, `Team_id`, `id`) VALUES ('7', '1', '13');
INSERT INTO `lab3`.`match_has_team` (`Match_id`, `Team_id`, `id`) VALUES ('7', '2', '14');
INSERT INTO `lab3`.`match_has_team` (`Match_id`, `Team_id`, `id`) VALUES ('8', '3', '15');
INSERT INTO `lab3`.`match_has_team` (`Match_id`, `Team_id`, `id`) VALUES ('8', '5', '16');
INSERT INTO `lab3`.`match_has_team` (`Match_id`, `Team_id`, `id`) VALUES ('9', '10', '17');
INSERT INTO `lab3`.`match_has_team` (`Match_id`, `Team_id`, `id`) VALUES ('9', '9', '18');
INSERT INTO `lab3`.`match_has_team` (`Match_id`, `Team_id`, `id`) VALUES ('10', '8', '19');
INSERT INTO `lab3`.`match_has_team` (`Match_id`, `Team_id`, `id`) VALUES ('10', '6', '20');

INSERT INTO `lab3`.`referee` (`id`, `Match_id`, `name`, `surname`, `age`, `nationality`) VALUES ('1', '5', 'Aleksandr', 'Derdo', '29', 'Ukranian');
INSERT INTO `lab3`.`referee` (`id`, `Match_id`, `name`, `surname`, `age`, `nationality`) VALUES ('2', '4', 'Aleksandr', 'Shandor', '31', 'Ukranian');
INSERT INTO `lab3`.`referee` (`id`, `Match_id`, `name`, `surname`, `age`, `nationality`) VALUES ('3', '3', 'Denis', 'Shurman', '32', 'Ukranian');
INSERT INTO `lab3`.`referee` (`id`, `Match_id`, `name`, `surname`, `age`, `nationality`) VALUES ('4', '2', 'Igor', 'Pashal', '36', 'Ukranian');
INSERT INTO `lab3`.`referee` (`id`, `Match_id`, `name`, `surname`, `age`, `nationality`) VALUES ('5', '1', 'Yuriy', 'Ivanov', '33', 'Ukranian');
INSERT INTO `lab3`.`referee` (`id`, `Match_id`, `name`, `surname`, `age`, `nationality`) VALUES ('6', '10', 'Sergiy', 'Boiko', '34', 'Ukranian');
INSERT INTO `lab3`.`referee` (`id`, `Match_id`, `name`, `surname`, `age`, `nationality`) VALUES ('7', '6', 'Yaroslav', 'Kozuk', '37', 'Ukranian');
INSERT INTO `lab3`.`referee` (`id`, `Match_id`, `name`, `surname`, `age`, `nationality`) VALUES ('8', '7', 'Vitaliy', 'Romanov', '40', 'Ukranian');
INSERT INTO `lab3`.`referee` (`id`, `Match_id`, `name`, `surname`, `age`, `nationality`) VALUES ('9', '8', 'Anatoliy', 'Abdula', '38', 'Ukranian');
INSERT INTO `lab3`.`referee` (`id`, `Match_id`, `name`, `surname`, `age`, `nationality`) VALUES ('10', '9', 'Dmitriy', 'Bondarenko', '39', 'Ukranian');