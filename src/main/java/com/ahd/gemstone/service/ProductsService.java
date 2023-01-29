package com.ahd.gemstone.service;

import com.ahd.gemstone.exception.BadRequest;
import com.ahd.gemstone.exception.NotFoundException;
import com.ahd.gemstone.models.ProductsModel;
import com.ahd.gemstone.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductsService {

    @Autowired
    private ProductRepository productRepository;

    public ProductsModel getProduct(int id) {
        try {
            if (productRepository.existsById(id)) {
                return productRepository.findById(id).get();
            }
        } catch (NoSuchElementException exception) {
            throw new NotFoundException(String.format("Not Found this id [%s]", id));
        } catch (HttpClientErrorException.BadRequest exception) {
            throw new BadRequest("illegal request");
        }
        throw new NotFoundException(String.format("Not Found this id [%s]", id));
    }

    public List<ProductsModel> getListProducts(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<ProductsModel> pagedResult = productRepository.findAll(paging);
        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }

    public ProductsModel addProduct(ProductsModel almaktab) {
        return productRepository.save(almaktab);
    }

    public ProductsModel updateProduct(ProductsModel almaktab) {
        try {
            if (productRepository.existsById(almaktab.getId())) {
                return productRepository.save(almaktab);
            }
        } catch (NoSuchElementException exception) {
            throw new NotFoundException(String.format("Not Found this id [%s]", almaktab.getId()));
        } catch (HttpClientErrorException.BadRequest exception) {
            throw new BadRequest("illegal request");
        }
        throw new NotFoundException(String.format("Not Found this id [%s]", almaktab.getId()));
    }

    public ProductsModel deleteProduct(int id) {
        try {
            if (productRepository.existsById(id)) {
                ProductsModel productsModel = productRepository.findById(id).get();
                productRepository.deleteById(id);
                return productsModel;
            }
        } catch (NoSuchElementException exception) {
            throw new NotFoundException(String.format("Not Found this id [%s]", id));
        } catch (HttpClientErrorException.BadRequest exception) {
            throw new BadRequest("illegal request");
        }
        throw new NotFoundException(String.format("Not Found this id [%s]", id));
    }

    public List<ProductsModel> findByName(String name) {
        List<ProductsModel> credentials = productRepository.findByName(name);
        return credentials;
    }
}
