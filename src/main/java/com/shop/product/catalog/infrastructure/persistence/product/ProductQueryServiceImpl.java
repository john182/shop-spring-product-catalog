package com.shop.product.catalog.infrastructure.persistence.product;


import com.shop.product.catalog.application.product.query.PageModel;
import com.shop.product.catalog.application.product.query.ProductDetailOutput;
import com.shop.product.catalog.application.product.query.ProductQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductQueryServiceImpl implements ProductQueryService {


    @Override
    public ProductDetailOutput findById(UUID productId) {
        return null;
    }

    @Override
    public PageModel<ProductDetailOutput> filter(Integer size, Integer number) {
        return null;
    }
}