package com.devsenior.nmanja.actuator_postgresql.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.nmanja.actuator_postgresql.model.dto.ProductRequestDTO;
import com.devsenior.nmanja.actuator_postgresql.model.dto.ProductResponseDTO;
import com.devsenior.nmanja.actuator_postgresql.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin(origins = "*")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Get all products
     * GET /api/v1/products
     */
    @GetMapping
    public List<ProductResponseDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    /**
     * Get product by id
     * GET /api/v1/products/{id}
     */
    @GetMapping("/{id}")
    public ProductResponseDTO getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    /**
     * Create a new product
     * POST /api/v1/products
     */
    @PostMapping
    public ProductResponseDTO createProduct(@Valid @RequestBody ProductRequestDTO productRequestDTO) {
        return productService.createProduct(productRequestDTO);
    }

    /**
     * Update a product
     * PUT /api/v1/products/{id}
     */
    @PutMapping("/{id}")
    public ProductResponseDTO updateProduct(
            @PathVariable Long id,
            @Valid @RequestBody ProductRequestDTO productRequestDTO) {
        return productService.updateProduct(id, productRequestDTO);
    }

    /**
     * Delete a product
     * DELETE /api/v1/products/{id}
     */
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    /**
     * Search products by name
     * GET /api/v1/products/search?name=productName
     */
    @GetMapping("/search")
    public List<ProductResponseDTO> searchProductsByName(@RequestParam String name) {
        return productService.searchProductsByName(name);
    }
}