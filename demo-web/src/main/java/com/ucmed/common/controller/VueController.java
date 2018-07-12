package com.ucmed.common.controller;

import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @auther ucmed xpeng
 * @create 2018/6/7
 * @describe
 */
//注意不是restController
@Controller
@RequestMapping("/vue")
public class VueController {

  @RequestMapping(value="/index")
  public String welcome(ModelMap map){
    Date date = new Date();
    //传到template模板中（会把模板中能找到的所有的ftl文件中的名称都替换掉）
    map.addAttribute("vv", date.toString());
//    index.ftl
    return "index";
  }

}
