package com.example.demoRestMovimentAccount.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demoRestMovimentAccount.entity.Account;
import com.example.demoRestMovimentAccount.entity.Operation;

import reactor.core.publisher.Mono;

@Service
public class MovimentAccountService {
	@Autowired
	static RestTemplate restTemplate=new RestTemplate();
	private String UPDATE_ACCOUNT_API="http://localhost:8027/accounts/update/{id}";
	private String GET_ACCOUNT_BY_ID_API="http://localhost:8027/accounts/{id}";

	public Mono<String> increaseAmountAccount(int id,double amount) {
		Map<String, Integer> param=new HashMap<>();
		param.put("id", id);
		Account account=restTemplate.getForObject(GET_ACCOUNT_BY_ID_API, Account.class, param);
		
		Map<String, Integer> paramAmount=new HashMap<>();
		paramAmount.put("id", id);
		Account updateAccount=new Account();
		updateAccount.setId(id);
		updateAccount.setAmount(account.getAmount()+amount);
		restTemplate.put(UPDATE_ACCOUNT_API, updateAccount, paramAmount);
		return Mono.just("increased amount");
	}
	
	public Mono<String> decreaseAmountAccount(int id,double amount) {
		Map<String, Integer> param=new HashMap<>();
		param.put("id", id);
		Account account=restTemplate.getForObject(GET_ACCOUNT_BY_ID_API, Account.class, param);
		
		Map<String, Integer> paramAmount=new HashMap<>();
		paramAmount.put("id", id);
		Account updateAccount=new Account();
		updateAccount.setId(id);
		updateAccount.setAmount(account.getAmount()-amount);
		restTemplate.put(UPDATE_ACCOUNT_API, updateAccount, paramAmount);
		return Mono.just("decreased amount");
	}
}
