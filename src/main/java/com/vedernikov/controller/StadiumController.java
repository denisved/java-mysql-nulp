package com.vedernikov.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.vedernikov.DTO.StadiumDTO;
import com.vedernikov.domain.Stadium;
import com.vedernikov.mapper.impl.StadiumMapper;
import com.vedernikov.service.impl.StadiumService;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping(value = "/api/stadium")
@RestController
@AllArgsConstructor
public class StadiumController {
    private final StadiumService stadiumService;
    private final StadiumMapper stadiumMapper;

    @GetMapping
    public ResponseEntity<List<StadiumDTO>> getAll() {
        List<StadiumDTO> dtoList = stadiumService.getAll().stream().map(stadiumMapper::map).collect(Collectors.toList());
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<StadiumDTO> get(@PathVariable Integer id) {
        return new ResponseEntity<>(stadiumMapper.map(stadiumService.get(id)), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<StadiumDTO> delete(@PathVariable Integer id) {
        return new ResponseEntity<>(stadiumMapper.map(stadiumService.delete(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StadiumDTO> create(@RequestBody Stadium stadium) {
        return new ResponseEntity<>(stadiumMapper.map(stadiumService.create(stadium)), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<StadiumDTO> update(@PathVariable Integer id, @RequestBody Stadium stadium) {
        return new ResponseEntity<>(stadiumMapper.map(stadiumService.update(id, stadium)), HttpStatus.OK);
    }
}
