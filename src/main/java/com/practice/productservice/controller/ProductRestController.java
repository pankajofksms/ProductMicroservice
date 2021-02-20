package com.practice.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.productservice.model.Coupon;
import com.practice.productservice.model.Product;
import com.practice.productservice.repository.ProductRepo;
import com.practice.productservice.restclient.CouponClient;

@RestController
@RequestMapping("/productapi")
public class ProductRestController {

	@Autowired
	private ProductRepo repo;

	@Autowired
	private CouponClient couponClient;

	@PostMapping(value = "/products")
	public Product create(@RequestBody Product product) {
		String code = product.getCouponCode();
		Coupon coupon = couponClient.getCoupon(code);
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
		return repo.save(product);

	}

}