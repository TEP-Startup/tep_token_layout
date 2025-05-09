package com.tep.backend.service;

import com.tep.backend.model.dto.TokenDTO;
import com.tep.backend.model.entity.Company;
import com.tep.backend.model.entity.Token;
import com.tep.backend.model.entity.Product;
import com.tep.backend.repository.CompanyRepository;
import com.tep.backend.repository.TokenRepository;
import com.tep.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TokenService {

    @Autowired
    private TokenRepository repository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public TokenDTO findById(Long id) {
        return new TokenDTO(repository.findById(id).get());
    }

    @Transactional(readOnly = true)
    public List<TokenDTO> findAll() {
        List<Token> entities = repository.findAll();
        return entities.stream().map(TokenDTO::new).toList();
    }

    @Transactional
    public TokenDTO insert(TokenDTO dto) {
        Token entity = new Token();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new TokenDTO(entity);
    }

    @Transactional
    public TokenDTO update(Long id, TokenDTO dto) {
        Token entity = repository.getReferenceById(id);
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new TokenDTO(entity);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private void copyDtoToEntity(TokenDTO dto, Token entity) {
        Company company = companyRepository.getReferenceById(dto.getCompanyId());
        entity.setCompany(company);
        
        if (dto.getProduct() != null && dto.getProduct().getId() != null) {
            Product product = productRepository.getReferenceById(dto.getProduct().getId());
            entity.setProduct(product);
        }
        
        entity.setType(dto.getType());
        entity.setName(dto.getName());
        entity.setSymbol(dto.getSymbol());
        entity.setDescription(dto.getDescription());
        entity.setImageUrl(dto.getImageUrl());
        entity.setContractAddress(dto.getContractAddress());
        entity.setActive(dto.getActive());
    }
}
