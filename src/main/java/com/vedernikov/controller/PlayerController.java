package com.vedernikov.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.vedernikov.DTO.PlayerDTO;
import com.vedernikov.domain.Player;
import com.vedernikov.mapper.impl.PlayerMapper;
import com.vedernikov.service.impl.PlayerService;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping(value = "/api/player")
@RestController
@AllArgsConstructor
public class PlayerController {
    private final PlayerService playerService;
    private final PlayerMapper playerMapper;

    @GetMapping
    public ResponseEntity<List<PlayerDTO>> getAll() {
        List<PlayerDTO> dtoList = playerService.getAll().stream().map(playerMapper::map).collect(Collectors.toList());
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PlayerDTO> get(@PathVariable Integer id) {
        return new ResponseEntity<>(playerMapper.map(playerService.get(id)), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<PlayerDTO> delete(@PathVariable Integer id) {
        return new ResponseEntity<>(playerMapper.map(playerService.delete(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PlayerDTO> create(@RequestBody Player player) {
        return new ResponseEntity<>(playerMapper.map(playerService.create(player)), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<PlayerDTO> update(@PathVariable Integer id, @RequestBody Player player) {
        return new ResponseEntity<>(playerMapper.map(playerService.update(id, player)), HttpStatus.OK);
    }
}
