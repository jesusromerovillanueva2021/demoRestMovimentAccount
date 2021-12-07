package com.example.demoRestMovimentAccount.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
	private int id;
	private AccountType type;
	private double amount;
	
	public enum AccountType{
		Saving,CurrentAccount,FixedTerm
	}
}
