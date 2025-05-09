package com.tep.backend.controller;

import com.tep.backend.model.dto.TokenDTO;
import com.tep.backend.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/tokens")
public class TokenAdminController {

    @Autowired
    private TokenService service;

    @GetMapping("/{id}")
    public TokenDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<TokenDTO> findAll() {
        return service.findAll();
    }

    @PostMapping
    public TokenDTO insert(@RequestBody TokenDTO dto) {
        return service.insert(dto);
    }

    @PutMapping("/{id}")
    public TokenDTO update(@PathVariable Long id, @RequestBody TokenDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
