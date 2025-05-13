package com.tep.backend.controller;

import com.tep.backend.model.dto.ProductDTO;
import com.tep.backend.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // [ADMIN/EMPRESA] Criar um novo produto
    @PostMapping
    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO dto) {
        dto = productService.insert(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    // [PÚBLICO] Obter detalhes de um produto pelo ID (usado na página do token)
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    // [PÚBLICO] Listar os produtos de uma empresa
    @GetMapping("/company/{companyId}")
    public ResponseEntity<List<ProductDTO>> getByCompany(@PathVariable Long companyId) {
        return ResponseEntity.ok(productService.findByCompany(companyId));
    }

    // [ADMIN/EMPRESA] Atualizar um produto
    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody ProductDTO dto) {
        return ResponseEntity.ok(productService.update(id, dto));
    }

    // [ADMIN/EMPRESA] Inativar produto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deactivate(@PathVariable Long id) {
        productService.deactivate(id);
        return ResponseEntity.noContent().build();
    }
}

