package com.aninfo.service;

import com.aninfo.exceptions.DepositNegativeSumException;
import com.aninfo.exceptions.InsufficientFundsException;
import com.aninfo.model.Transaction;
import com.aninfo.model.Account;
import com.aninfo.repository.TransactionRepository;
import com.aninfo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private AccountService account;
    public Transaction createTransaction(Long cbu, String type, Double amount ){
        if(type.equals("deposit")){
            account.deposit(cbu,amount);
        } else if (type.equals("withdraw")) {
            account.withdraw(cbu,amount);
        }
        Transaction transaction = new Transaction(cbu,type,amount);
        return transactionRepository.save(transaction);
    }
    public Collection<Transaction> getTransactions(){ return transactionRepository.findAll(); }
    public Optional<Transaction> findById(long id){ return transactionRepository.findById(id);}
    public  Collection<Transaction> findByCbu(long cbu){
        List<Transaction> transactionsByCbu = new ArrayList<>();
        for (Transaction transaction: transactionRepository.findAll()){
            if(transaction.getCbu() == cbu){
                transactionsByCbu.add(transaction);
            }
        }
        return transactionsByCbu;
    }
    public void save(Transaction transaction){ transactionRepository.save(transaction);}
    public void deleteById(long id){ transactionRepository.deleteById(id);}

}
