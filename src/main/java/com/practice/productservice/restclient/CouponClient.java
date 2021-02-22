package com.practice.productservice.restclient;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.practice.productservice.model.Coupon;

@FeignClient("COUPON-SERVICE")
@RibbonClient("COUPON-SERVICE")
public interface CouponClient {

	@GetMapping("/couponapi/coupons/{code}")
	Coupon getCoupon(@PathVariable("code") String code);

}
