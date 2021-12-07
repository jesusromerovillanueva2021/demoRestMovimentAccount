package com.example.demoRestMovimentAccount.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Operation {
    private int id;
    private Date dateOperation;
    private double amount;
    OperationType type;
    private int idAccount;

    public enum OperationType{
        Deposit, Retirement
    }
}
