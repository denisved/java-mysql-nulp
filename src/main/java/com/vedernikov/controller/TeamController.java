package com.vedernikov.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.vedernikov.DTO.TeamDTO;
import com.vedernikov.domain.Team;
import com.vedernikov.mapper.impl.TeamMapper;
import com.vedernikov.service.impl.TeamService;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping(value = "/api/team")
@RestController
@AllArgsConstructor
public class TeamController {
    private final TeamService teamService;
    private final TeamMapper teamMapper;

    @GetMapping
    public ResponseEntity<List<TeamDTO>> getAll() {
        List<TeamDTO> dtoList = teamService.getAll().stream().map(teamMapper::map).collect(Collectors.toList());
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<TeamDTO> get(@PathVariable Integer id) {
        return new ResponseEntity<>(teamMapper.map(teamService.get(id)), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<TeamDTO> delete(@PathVariable Integer id) {
        return new ResponseEntity<>(teamMapper.map(teamService.delete(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TeamDTO> create(@RequestBody Team team) {
        return new ResponseEntity<>(teamMapper.map(teamService.create(team)), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<TeamDTO> update(@PathVariable Integer id, @RequestBody Team team) {
        return new ResponseEntity<>(teamMapper.map(teamService.update(id, team)), HttpStatus.OK);
    }
}