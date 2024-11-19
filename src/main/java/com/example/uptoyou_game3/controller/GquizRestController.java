package com.example.uptoyou_game3.controller;

import com.example.uptoyou_game3.dto.DefaultDto;
import com.example.uptoyou_game3.dto.GquizDto;
import com.example.uptoyou_game3.service.GquizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/gquiz")
@RestController
public class GquizRestController {

    private final GquizService gquizService;

    public GquizRestController(
            GquizService gquizService
    ) {
        this.gquizService = gquizService;
    }

    @PostMapping("")
    public ResponseEntity<GquizDto.CreateResDto> create(@RequestBody GquizDto.CreateReqDto param){
        return ResponseEntity.ok(gquizService.create(param));
    }
    @PutMapping("")
    public ResponseEntity<String> update(@RequestBody GquizDto.UpdateReqDto param){
        gquizService.update(param);
        return ResponseEntity.ok().build();
    }
    @GetMapping("")
    public ResponseEntity<GquizDto.DetailResDto> detail(DefaultDto.DetailReqDto param){
        return ResponseEntity.ok(gquizService.detail(param));
    }
    @GetMapping("/list")
    public ResponseEntity<List<GquizDto.DetailResDto>> list(GquizDto.ListReqDto param){
        return ResponseEntity.ok(gquizService.list(param));
    }
}

