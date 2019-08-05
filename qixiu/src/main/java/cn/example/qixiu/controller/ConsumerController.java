package cn.example.qixiu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import cn.example.qixiu.bean.Kehuxinxi;
import cn.example.qixiu.mapper.KehuxinxiMapper;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ConsumerController {
    @Autowired
    KehuxinxiMapper kehuxinxiMapper;

    //查询所有客户返回列表页面
    @GetMapping("/consumers")
    public String  list(Model model){
        Collection<Kehuxinxi> consumers = kehuxinxiMapper.findAll(); 
        //放在请求域中
        model.addAttribute("consumers",consumers);
        return "consumer/list";
    }

    //来到客户添加页面
    @GetMapping("/consumer")
    public String toAddPage(Model model){
        //来到添加页面
        return "consumer/add";
    }
    //员工添加
    //SpringMVC自动将请求参数和入参对象的属性进行一一绑定；要求请求参数的名字和javaBean入参的对象里面的属性名是一样的
    @RequestMapping("/consumer")
    public String addConsumer(Model model,@ModelAttribute Kehuxinxi kehuxinxi){
        //来到员工列表页面
    	Kehuxinxi kehuxinxitmp = new Kehuxinxi();
    	kehuxinxitmp.setChepaihao(kehuxinxi.getChepaihao());
    	kehuxinxitmp.setChezhuxingming(kehuxinxi.getChezhuxingming());
    	kehuxinxitmp.setChexing(kehuxinxi.getChexing());
    	kehuxinxitmp.setHuiyuanka(kehuxinxi.getHuiyuanka());
    	kehuxinxitmp.setId(kehuxinxi.getChepaihao());
    	kehuxinxitmp.setStartdate(new Date());
    	if (kehuxinxi.getYue().isEmpty()) {
    		kehuxinxitmp.setYue("0");
		}
    	else {
    		kehuxinxitmp.setYue(kehuxinxi.getYue());
		}
        int res = kehuxinxiMapper.insertKehuxinxi(kehuxinxitmp);
        // redirect: 表示重定向到一个地址  /代表当前项目路径
        // forward: 表示转发到一个地址
        return "redirect:/consumers";
    }

    //来到修改页面，查出当前客户，在页面回显
    @GetMapping("/consumer/{id}")
    public String toEditPage(@PathVariable("id") String id,Model model){
    	Map<String, Object> condition = new HashMap<String, Object>();
    	condition.put("id", id);
        Kehuxinxi kehuxinxi = kehuxinxiMapper.getKehuxinxiByCondition(condition);
        model.addAttribute("kehuxinxi",kehuxinxi);
        //回到修改页面(add是一个修改添加二合一的页面);
        return "consumer/add";
    }

    //员工修改；需要提交员工id；
//    @ResponseBody
    @PutMapping("/consumer")
    public String updateKehuxinxi(Kehuxinxi kehuxinxi){
        //System.out.println("修改的员工数据："+kehuxinxi);
        Map<String, Object> condition = new HashMap<String, Object>();
        condition.put("chepaihao",kehuxinxi.getChepaihao());
        condition.put("chezhuxingming",kehuxinxi.getChezhuxingming());
        condition.put("chexing",kehuxinxi.getChexing());
        condition.put("huiyuanka",kehuxinxi.getHuiyuanka());
        condition.put("id",kehuxinxi.getId());
        condition.put("startdate",kehuxinxi.getStartdate());
        condition.put("yue", kehuxinxi.getYue());
        //System.out.println(condition);
        kehuxinxiMapper.updateKehuxinxiByCondition(condition);
        return "redirect:/consumers";
    }

    //员工删除
    @DeleteMapping("/consumer/{id}")
    public String deleteEmployee(@PathVariable("id") String id){
        kehuxinxiMapper.delete(id);
        return "redirect:/consumers";
    }
    //客户查询
    @PostMapping(value = "/consumersearch")
    public String Consumersearch(@RequestParam("chepaihao") String chepaihao,
                        @RequestParam("chezhuxingming") String chezhuxingming,
                        @RequestParam("chexing") String chexing,
                        Model model){
        Map<String, Object> condition = new HashMap<String, Object>();   
        if (!chepaihao.isEmpty()) {
            condition.put("chepaihao", chepaihao);
		}
        if (!chezhuxingming.isEmpty()) {
            condition.put("chezhuxingming", chezhuxingming);
		}
        if (!chexing.isEmpty()) {
            condition.put("chexing", chexing);
		}
        List<Kehuxinxi> consumers = kehuxinxiMapper.getKehuxinxiByConditions(condition);    
		model.addAttribute("consumers",consumers);
    	return "consumer/list";
    }
}
