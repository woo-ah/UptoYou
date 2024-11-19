package com.example.uptoyou_game3.controller;

import com.example.uptoyou_game3.dto.DefaultDto;
import com.example.uptoyou_game3.dto.GtimerDto;
import com.example.uptoyou_game3.service.GtimerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/gtimer")
@RestController
public class GtimerRestController {

    private final GtimerService gtimerService;

    public GtimerRestController(
            GtimerService gtimerService
    ) {
        this.gtimerService = gtimerService;
    }

    @PostMapping("")
    public ResponseEntity<GtimerDto.CreateResDto> create(@RequestBody GtimerDto.CreateReqDto param){
        return ResponseEntity.ok(gtimerService.create(param));
    }
    @PutMapping("")
    public ResponseEntity<String> update(@RequestBody GtimerDto.UpdateReqDto param){
        gtimerService.update(param);
        return ResponseEntity.ok().build();
    }
    @GetMapping("")
    public ResponseEntity<GtimerDto.DetailResDto> detail(DefaultDto.DetailReqDto param){
        return ResponseEntity.ok(gtimerService.detail(param));
    }
    @GetMapping("/list")
    public ResponseEntity<List<GtimerDto.DetailResDto>> list(GtimerDto.ListReqDto param){
        return ResponseEntity.ok(gtimerService.list(param));
    }
}

