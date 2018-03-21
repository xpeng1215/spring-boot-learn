package com.ucmed.jdbc.template;

import com.ucmed.demo.model.jdbc.template.Account;
import com.ucmed.demo.service.jdbc.template.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ucmed on 2018/3/21.
 */
@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	IAccountService accountService;

	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public List<Account> getAccounts(){
		return accountService.findAccountList();
	}

	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public  Account getAccountById(@PathVariable("id") int id){
		return accountService.findAccountById(id);
	}

	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public  String updateAccount(@PathVariable("id")int id , @RequestParam(value = "name",required = true)String name,
			@RequestParam(value = "money" ,required = true)double money){
		Account account=new Account();
		account.setMoney(money);
		account.setName(name);
		account.setId(id);
		int t=accountService.update(account);
		if(t==1){
			return account.toString();
		}else {
			return "fail";
		}
	}

	@RequestMapping(value = "",method = RequestMethod.POST)
	public  String postAccount(@RequestBody Account account){
		int t= accountService.add(account);
		if(t==1){
			return account.toString();
		}else {
			return "fail";
		}

	}
}
