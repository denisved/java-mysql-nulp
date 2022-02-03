package com.vedernikov.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.vedernikov.DTO.RefereeDTO;
import com.vedernikov.domain.Referee;
import com.vedernikov.mapper.impl.RefereeMapper;
import com.vedernikov.service.impl.RefereeService;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping(value = "/api/referee")
@RestController
@AllArgsConstructor
public class RefereeController {
    private final RefereeService refereeService;
    private final RefereeMapper refereeMapper;

    @GetMapping
    public ResponseEntity<List<RefereeDTO>> getAll() {
        List<RefereeDTO> dtoList = refereeService.getAll().stream().map(refereeMapper::map).collect(Collectors.toList());
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<RefereeDTO> get(@PathVariable Integer id) {
        return new ResponseEntity<>(refereeMapper.map(refereeService.get(id)), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<RefereeDTO> delete(@PathVariable Integer id) {
        return new ResponseEntity<>(refereeMapper.map(refereeService.delete(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RefereeDTO> create(@RequestBody Referee referee) {
        return new ResponseEntity<>(refereeMapper.map(refereeService.create(referee)), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<RefereeDTO> update(@PathVariable Integer id, @RequestBody Referee referee) {
        return new ResponseEntity<>(refereeMapper.map(refereeService.update(id, referee)), HttpStatus.OK);
    }
}
