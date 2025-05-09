package com.tep.backend.controller;

import com.tep.backend.model.dto.CompanyMinDTO;
import com.tep.backend.model.dto.CompanyPublicDTO;
import com.tep.backend.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public/companies")
public class CompanyPublicController {

    @Autowired
    private CompanyService service;

    @GetMapping
    public List<CompanyMinDTO> findAllMin(){
        return service.findAllMin();
    }

    @GetMapping("/{id}")
    public CompanyPublicDTO findById(@PathVariable Long id) {
        return service.findPublicById(id);
    }
}
