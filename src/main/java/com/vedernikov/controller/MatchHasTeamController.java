package com.vedernikov.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.vedernikov.DTO.MatchHasTeamDTO;
import com.vedernikov.domain.MatchHasTeam;
import com.vedernikov.mapper.impl.MatchHasTeamMapper;
import com.vedernikov.service.impl.MatchHasTeamService;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping(value = "/api/matchHasTeam")
@RestController
@AllArgsConstructor
public class MatchHasTeamController {
    private final MatchHasTeamService matchHasTeamService;
    private final MatchHasTeamMapper matchHasTeamMapper;

    @GetMapping
    public ResponseEntity<List<MatchHasTeamDTO>> getAll() {
        List<MatchHasTeamDTO> dtoList = matchHasTeamService.getAll().stream().map(matchHasTeamMapper::map).collect(Collectors.toList());
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<MatchHasTeamDTO> get(@PathVariable Integer id) {
        return new ResponseEntity<>(matchHasTeamMapper.map(matchHasTeamService.get(id)), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<MatchHasTeamDTO> delete(@PathVariable Integer id) {
        return new ResponseEntity<>(matchHasTeamMapper.map(matchHasTeamService.delete(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MatchHasTeamDTO> create(@RequestBody MatchHasTeam entity) {
        return new ResponseEntity<>(matchHasTeamMapper.map(matchHasTeamService.create(entity)), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<MatchHasTeamDTO> update(@PathVariable Integer id, @RequestBody MatchHasTeam matchHasTeam) {
        return new ResponseEntity<>(matchHasTeamMapper.map(matchHasTeamService.update(id, matchHasTeam)), HttpStatus.OK);
    }
}