package com.ucmed.jdbc.template;

import com.ucmed.demo.model.jdbc.template.Account;
import com.ucmed.demo.service.jdbc.template.IAccountService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Created by ucmed on 2018/3/21.
 */
@RestController
@RequestMapping("/account")
public class AccountController {

	private Logger logger = LoggerFactory.getLogger(AccountController.class);

	@Autowired
	IAccountService accountService;

	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public List<Account> getAccounts(){
		return accountService.findAccountList();
	}

	@Cacheable(value = "getAccountById")
	@ApiOperation(value="查看详情", notes="根据url的id来指定查看的记录")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "记录Id", required = true, dataType = "int",paramType = "path"),
	})
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public  Account getAccountById(@PathVariable("id") int id){
		logger.info("访问的ID："+id);
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

	@ApiIgnore//使用该注解忽略这个API
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
