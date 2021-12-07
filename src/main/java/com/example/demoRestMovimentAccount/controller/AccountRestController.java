package com.example.demoRestMovimentAccount.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demoRestMovimentAccount.entity.Account;
import com.example.demoRestMovimentAccount.entity.Operation;
import com.example.demoRestMovimentAccount.service.MovimentAccountService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/restmovimentsaccount")
public class AccountRestController {
	@Autowired
	private MovimentAccountService service;
	
	@PutMapping("/increaseamount/{id}/{amount}")
	public Mono<String> updateAmountPerDeposit(@PathVariable int id,  @PathVariable double amount) {
		return service.increaseAmountAccount(id, amount);
	}
	
	@PutMapping("/decreaseamount/{id}/{amount}")
	public Mono<String> updateAmountPerRetirement(@PathVariable int id,  @PathVariable double amount) {
		return service.decreaseAmountAccount(id, amount);
	}
}
