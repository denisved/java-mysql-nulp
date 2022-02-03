package com.vedernikov.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.vedernikov.DTO.SponsorDTO;
import com.vedernikov.domain.Sponsor;
import com.vedernikov.mapper.impl.SponsorMapper;
import com.vedernikov.service.impl.SponsorService;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping(value = "/api/sponsorr")
@RestController
@AllArgsConstructor
public class SponsorController {
    private final SponsorService sponsorService;
    private final SponsorMapper sponsorMapper;

    @GetMapping
    public ResponseEntity<List<SponsorDTO>> getAll() {
        List<SponsorDTO> dtoList = sponsorService.getAll().stream().map(sponsorMapper::map).collect(Collectors.toList());
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<SponsorDTO> get(@PathVariable Integer id) {
        return new ResponseEntity<>(sponsorMapper.map(sponsorService.get(id)), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<SponsorDTO> delete(@PathVariable Integer id) {
        return new ResponseEntity<>(sponsorMapper.map(sponsorService.delete(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SponsorDTO> create(@RequestBody Sponsor sponsor) {
        return new ResponseEntity<>(sponsorMapper.map(sponsorService.create(sponsor)), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<SponsorDTO> update(@PathVariable Integer id, @RequestBody Sponsor sponsor) {
        return new ResponseEntity<>(sponsorMapper.map(sponsorService.update(id, sponsor)), HttpStatus.OK);
    }
}
