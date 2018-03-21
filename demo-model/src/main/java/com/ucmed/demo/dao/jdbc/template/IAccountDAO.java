package com.ucmed.demo.dao.jdbc.template;

import com.ucmed.demo.model.jdbc.template.Account;

import java.util.List;

/**
 * Created by ucmed on 2018/3/21.
 */
public interface IAccountDAO {

	int add(Account account);

	int update(Account account);

	int delete(int id);

	Account findAccountById(int id);

	List<Account> findAccountList();
}
