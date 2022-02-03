package com.vedernikov.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.vedernikov.DTO.TeamHasSponsorDTO;
import com.vedernikov.domain.TeamHasSponsor;
import com.vedernikov.mapper.impl.TeamHasSponsorMapper;
import com.vedernikov.service.impl.TeamHasSponsorService;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping(value = "/api/teamHasSponsor")
@RestController
@AllArgsConstructor
public class TeamHasSponsorController {
    private final TeamHasSponsorService teamHasSponsorService;
    private final TeamHasSponsorMapper teamHasSponsorMapper;

    @GetMapping
    public ResponseEntity<List<TeamHasSponsorDTO>> getAll() {
        List<TeamHasSponsorDTO> dtoList = teamHasSponsorService.getAll().stream().map(teamHasSponsorMapper::map).collect(Collectors.toList());
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<TeamHasSponsorDTO> get(@PathVariable Integer id) {
        return new ResponseEntity<>(teamHasSponsorMapper.map(teamHasSponsorService.get(id)), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<TeamHasSponsorDTO> delete(@PathVariable Integer id) {
        return new ResponseEntity<>(teamHasSponsorMapper.map(teamHasSponsorService.delete(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TeamHasSponsorDTO> create(@RequestBody TeamHasSponsor teamHasSponsor) {
        return new ResponseEntity<>(teamHasSponsorMapper.map(teamHasSponsorService.create(teamHasSponsor)), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<TeamHasSponsorDTO> update(@PathVariable Integer id, @RequestBody TeamHasSponsor teamHasSponsor) {
        return new ResponseEntity<>(teamHasSponsorMapper.map(teamHasSponsorService.update(id, teamHasSponsor)), HttpStatus.OK);
    }
}
