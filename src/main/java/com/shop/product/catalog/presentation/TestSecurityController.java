package com.shop.product.catalog.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/test-security")
public class TestSecurityController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('SCOPE_products:write')")
    public ProductDetailOutput create(@RequestBody ProductInput input) {
        return ProductDetailOutput.builder()
                .id(UUID.randomUUID())
                .addedAt(OffsetDateTime.now())
                .inStock(false)
                .name(input.getName())
                .brand(input.getBrand())
                .name(input.getName())
                .brand(input.getBrand())
                .description(input.getDescription())
                .regularPrice(input.getRegularPrice())
                .salePrice(input.getSalePrice())
                .enabled(input.getEnabled())
                .category(
                        CategoryMinimalOutput.builder()
                                .id(input.getCategoryId())
                                .name("Notebook")
                                .build()
                )
                .build();
    }

    @GetMapping("/{productId}")
    @PreAuthorize("hasAuthority('SCOPE_products:read')")
    public ProductDetailOutput findById(@PathVariable UUID productId) {
        return ProductDetailOutput.builder()
                .id(productId)
                .addedAt(OffsetDateTime.now())
                .name("Notebook X11")
                .brand("Deep Diver")
                .description("A Gamer Notebook")
                .regularPrice(new BigDecimal("1500.00"))
                .salePrice(new BigDecimal("1000.00"))
                .inStock(true)
                .enabled(true)
                .category(CategoryMinimalOutput.builder()
                        .id(UUID.randomUUID())
                        .name("Notebook")
                        .build())
                .build();
    }
}
