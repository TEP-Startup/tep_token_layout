package com.tep.backend.service;

import com.tep.backend.model.dto.ProductDTO;
import com.tep.backend.model.entity.Product;
import com.tep.backend.repository.CompanyRepository;
import com.tep.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private CompanyRepository companyRepository;

    @Transactional
    public ProductDTO insert(ProductDTO dto){
        Product entity = new Product();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new ProductDTO(entity);
    }

    @Transactional(readOnly = true)
    public List<ProductDTO> findAll(){
        return repository.findAll().stream().map(ProductDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id){
        return new ProductDTO(repository.findById(id).get());
    }

    @Transactional(readOnly = true)
    public List<ProductDTO> findByCompany(Long companyId){
        return repository.findByCompanyId(companyId).stream().map(ProductDTO::new).toList();
    }

    @Transactional
    public ProductDTO update(Long id, ProductDTO dto){
        Product entity = repository.getReferenceById(id);
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new ProductDTO(entity);
    }

    @Transactional
    public void deactivate(Long id){
        Product entity = repository.getReferenceById(id);
        entity.setActive(false);
        repository.save(entity);
    }

    @Transactional
    public boolean isValid(Long id){
        Product entity = repository.getReferenceById(id);
        return Boolean.TRUE.equals(entity.getActive()) &&
                (entity.getValidityPeriod() == null || entity.getValidityPeriod().isAfter(LocalDateTime.now()));
    }

    private void copyDtoToEntity(ProductDTO dto, Product entity){
        entity.setCompany(companyRepository.getReferenceById(dto.getCompanyId()));
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setImageUrl(dto.getImageUrl());
        entity.setRedemptionRules(dto.getRedemptionRules());
        entity.setValidityPeriod(dto.getValidityPeriod());
        entity.setActive(dto.getActive());
        entity.setCreatedAt(dto.getCreatedAt());
    }

}
