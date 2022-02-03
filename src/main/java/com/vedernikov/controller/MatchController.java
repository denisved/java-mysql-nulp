package com.vedernikov.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.vedernikov.DTO.MatchDTO;
import com.vedernikov.domain.Match;
import com.vedernikov.mapper.impl.MatchMapper;
import com.vedernikov.service.impl.MatchService;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping(value = "/api/match")
@RestController
@AllArgsConstructor
public class MatchController {
    private final MatchService matchService;
    private final MatchMapper matchMapper;

    @GetMapping
    public ResponseEntity<List<MatchDTO>> getAll() {
        List<MatchDTO> dtoList = matchService.getAll().stream().map(matchMapper::map).collect(Collectors.toList());
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<MatchDTO> get(@PathVariable Integer id) {
        return new ResponseEntity<>(matchMapper.map(matchService.get(id)), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<MatchDTO> delete(@PathVariable Integer id) {
        return new ResponseEntity<>(matchMapper.map(matchService.delete(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MatchDTO> create(@RequestBody Match entity) {
        return new ResponseEntity<>(matchMapper.map(matchService.create(entity)), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<MatchDTO> update(@PathVariable Integer id, @RequestBody Match match) {
        return new ResponseEntity<>(matchMapper.map(matchService.update(id, match)), HttpStatus.OK);
    }
}
