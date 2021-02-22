package com.practice.productservice.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.practice.productservice.model.Coupon;

//@FeignClient("COUPON-SERVICE")
@FeignClient("gateway-api-service")

// Load balancer not needed as zuul provides server side load balancing
//@LoadBalancerClient("COUPON-SERVICE")
public interface CouponClient {

	@GetMapping("/coupon-service/couponapi/coupons/{code}")
	Coupon getCoupon(@PathVariable("code") String code);

}
