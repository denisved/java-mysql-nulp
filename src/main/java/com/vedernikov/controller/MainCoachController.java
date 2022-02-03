package com.vedernikov.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.vedernikov.DTO.MainCoachDTO;
import com.vedernikov.domain.MainCoach;
import com.vedernikov.mapper.impl.MainCoachMapper;
import com.vedernikov.service.impl.MainCoachService;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping(value = "/api/mainCoach")
@RestController
@AllArgsConstructor
public class MainCoachController {
    private final MainCoachService mainCoachService;
    private final MainCoachMapper mainCoachMapper;

    @GetMapping
    public ResponseEntity<List<MainCoachDTO>> getAll() {
        List<MainCoachDTO> dtoList = mainCoachService.getAll().stream().map(mainCoachMapper::map).collect(Collectors.toList());
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<MainCoachDTO> get(@PathVariable Integer id) {
        return new ResponseEntity<>(mainCoachMapper.map(mainCoachService.get(id)), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<MainCoachDTO> delete(@PathVariable Integer id) {
        return new ResponseEntity<>(mainCoachMapper.map(mainCoachService.delete(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MainCoachDTO> create(@RequestBody MainCoach entity) {
        return new ResponseEntity<>(mainCoachMapper.map(mainCoachService.create(entity)), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<MainCoachDTO> update(@PathVariable Integer id, @RequestBody MainCoach mainCoach) {
        return new ResponseEntity<>(mainCoachMapper.map(mainCoachService.update(id, mainCoach)), HttpStatus.OK);
    }
}
