package com.example.uptoyou_game3.controller;

import com.example.uptoyou_game3.dto.DefaultDto;
import com.example.uptoyou_game3.dto.GspeedDto;
import com.example.uptoyou_game3.service.GspeedService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/gspeed")
@RestController
public class GspeedRestController {

    private final GspeedService gspeedService;

    public GspeedRestController(
            GspeedService gspeedService
    ) {
        this.gspeedService = gspeedService;
    }

    @PostMapping("")
    public ResponseEntity<GspeedDto.CreateResDto> create(@RequestBody GspeedDto.CreateReqDto param){
        return ResponseEntity.ok(gspeedService.create(param));
    }
    @PutMapping("")
    public ResponseEntity<String> update(@RequestBody GspeedDto.UpdateReqDto param){
        gspeedService.update(param);
        return ResponseEntity.ok().build();
    }
    @GetMapping("")
    public ResponseEntity<GspeedDto.DetailResDto> detail(DefaultDto.DetailReqDto param){
        return ResponseEntity.ok(gspeedService.detail(param));
    }
    @GetMapping("/list")
    public ResponseEntity<List<GspeedDto.DetailResDto>> list(GspeedDto.ListReqDto param){
        return ResponseEntity.ok(gspeedService.list(param));
    }
}

