package com.ucmed.demo.service.jdbc.template;

import com.ucmed.demo.model.jdbc.template.Account;

import java.util.List;

/**
 * Created by ucmed on 2018/3/21.
 */
public interface IAccountService {

	int add(Account account);

	int update(Account account);

	int delete(int id);

	Account findAccountById(int id);

	List<Account> findAccountList();

}
