package com.tep.backend.service;

import com.tep.backend.model.dto.CompanyDTO;
import com.tep.backend.model.dto.CompanyMinDTO;
import com.tep.backend.model.dto.CompanyPublicDTO;
import com.tep.backend.model.entity.Company;
import com.tep.backend.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository repository;

    @Transactional(readOnly = true)
    public CompanyPublicDTO findPublicById(Long id) {
        Company entity = repository.findById(id).get();
        return new CompanyPublicDTO(entity);
    }

    @Transactional(readOnly = true)
    public List<CompanyMinDTO> findAllMin() {
        List<Company> entities = repository.findAll();
        return entities.stream().map(CompanyMinDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public CompanyDTO findById(Long id) {
        Company entity = repository.findById(id).get();
        return new CompanyDTO(entity);
    }

    @Transactional(readOnly = true)
    public List<CompanyDTO> findAll() {
        List<Company> entities = repository.findAll();
        return entities.stream().map(CompanyDTO::new).toList();
    }

    @Transactional
    public CompanyDTO insert(CompanyDTO dto) {
        Company entity = toEntity(dto);
        entity = repository.save(entity);
        return new CompanyDTO(entity);
    }

    @Transactional
    public CompanyDTO update(Long id, CompanyDTO dto) {
        Company entity = repository.findById(id).get();

        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setSector(dto.getSector());
        entity.setLogoUrl(dto.getLogoUrl());
        entity.setWebsite(dto.getWebsite());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        entity.setCnpj(dto.getCnpj());
        entity.setStatus(dto.getStatus());
        entity.setRegisteredAt(dto.getRegisteredAt());

        entity = repository.save(entity);
        return new CompanyDTO(entity);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private Company toEntity(CompanyDTO dto) {
        Company entity = new Company();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setSector(dto.getSector());
        entity.setLogoUrl(dto.getLogoUrl());
        entity.setWebsite(dto.getWebsite());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        entity.setCnpj(dto.getCnpj());
        entity.setStatus(dto.getStatus());
        entity.setRegisteredAt(dto.getRegisteredAt());
        return entity;
    }
}
