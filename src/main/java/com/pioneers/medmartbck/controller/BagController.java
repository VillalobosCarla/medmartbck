package com.pioneers.medmartbck.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pioneers.medmartbck.DTO.BagDTO;
import com.pioneers.medmartbck.model.Bag;
import com.pioneers.medmartbck.model.Product;
import com.pioneers.medmartbck.repository.BagRepository;
import com.pioneers.medmartbck.repository.ProductRepository;

@RestController
@RequestMapping("api/v1/bag")
public class BagController {

    @Autowired
    BagRepository bagRepository;

    @Autowired
    ProductRepository productRepository;

    @PostMapping("/new")
    public String addToBag(@RequestBody BagDTO entity) {
        Optional<Product> product = productRepository.findById(entity.getProductId());
        if(product.isPresent()){
            Product currentProduct = product.get();
            Bag bag = new Bag();
            bag.setProduct(Collections.singleton(currentProduct));
            bag.setUserId(entity.getUserId());
            bag.setNumberOfOrder(entity.getNumberOfOrder());
            bagRepository.save(bag);
            return "Added to bag!";
        }

        return "Unable to add to cart";
    
    }

    @GetMapping("/{userId}")
    public List<Bag> getBagItems(@PathVariable Long userId) {
        return bagRepository.findAllByUserId(userId);
    }
}
