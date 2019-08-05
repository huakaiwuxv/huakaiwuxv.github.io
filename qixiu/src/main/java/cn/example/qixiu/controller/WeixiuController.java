package cn.example.qixiu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import cn.example.qixiu.bean.Kehuxinxi;
import cn.example.qixiu.bean.Weixiujilu;
import cn.example.qixiu.mapper.WeixiuMapper;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class WeixiuController {
    @Autowired
    WeixiuMapper weixiuMapper;

    //查询所有客户返回列表页面
    //@ResponseBody
    @GetMapping("/weixiujilus")
    public String  list(Model model){
        Collection<Weixiujilu> weixiujilus = weixiuMapper.findAll();
        //放在请求域中
        model.addAttribute("weixiujilus",weixiujilus);
        return "weixiujilu/weixiujilulist";
    }

    //来到客户添加页面
    @GetMapping("/weixiujilu")
    public String toAddPage(Model model){
        //来到添加页面
        return "weixiujilu/weixiujiluadd";
    }
    //员工添加
    //SpringMVC自动将请求参数和入参对象的属性进行一一绑定；要求请求参数的名字和javaBean入参的对象里面的属性名是一样的
    @RequestMapping("/weixiujilu")
    public String addWeixiujilu(Model model,@ModelAttribute Weixiujilu weixiujilu){
        //来到员工列表页面
    	Weixiujilu weixiujilutmp = new Weixiujilu();
    	//int countsum = weixiuMapper.countsum();
    	weixiujilutmp.setId(weixiujilu.getChepaihao()+new Date());
    	weixiujilutmp.setChepaihao(weixiujilu.getChepaihao());
    	weixiujilutmp.setChezhuxingming(weixiujilu.getChezhuxingming());
    	weixiujilutmp.setFuwugongshi(weixiujilu.getFuwugongshi());
    	weixiujilutmp.setPeijianjine(weixiujilu.getPeijianjine());
    	weixiujilutmp.setSuoshoujine(weixiujilu.getSuoshoujine());
    	weixiujilutmp.setWeixiudate(new Date());
    	weixiujilutmp.setWeixiuleixing(weixiujilu.getWeixiuleixing());
    	weixiujilutmp.setShifoujiesuan(weixiujilu.getShifoujiesuan());
    	weixiujilutmp.setJiesuanleixing(weixiujilu.getJiesuanleixing());
    	weixiujilutmp.setFulu(weixiujilu.getFulu());
    	
        int res = weixiuMapper.insertWeixiu(weixiujilutmp);
        // redirect: 表示重定向到一个地址  /代表当前项目路径
        // forward: 表示转发到一个地址
        return "redirect:/weixiujilus";
    }

    //来到修改页面，查出当前客户，在页面回显
    @GetMapping("/weixiujilu/{id}")
    public String toEditPage(@PathVariable("id") String id,Model model){
    	Map<String, Object> condition = new HashMap<String, Object>();
    	condition.put("id", id);
        Weixiujilu weixiujilu = weixiuMapper.getWeixiuByCondition(condition);
        model.addAttribute("weixiujilu",weixiujilu);
        //回到修改页面(add是一个修改添加二合一的页面);
        return "weixiujilu/weixiujiluadd";
    }

    //员工修改；需要提交员工id；
//    @ResponseBody
    @PutMapping("/weixiujilu")
    public String updateWeixiujilu(Weixiujilu weixiujilu){
        //System.out.println("修改的员工数据："+kehuxinxi);
        Map<String, Object> condition = new HashMap<String, Object>();
        condition.put("id",weixiujilu.getId());
        condition.put("chepaihao", weixiujilu.getChepaihao());
        condition.put("chezhuxingming", weixiujilu.getChezhuxingming());
        condition.put("fuwugongshi",weixiujilu.getFuwugongshi());
        condition.put("peijianjine",weixiujilu.getPeijianjine());
        condition.put("suoshoujine",weixiujilu.getSuoshoujine());
        condition.put("weixiuleixing",weixiujilu.getWeixiuleixing());
        condition.put("shifoujiesuan",weixiujilu.getShifoujiesuan());
        condition.put("jiesuanleixing",weixiujilu.getJiesuanleixing());
        condition.put("fulu",weixiujilu.getFulu());
        //System.out.println(condition);
        weixiuMapper.updateWeixiuByCondition(condition);
        return "redirect:/weixiujilus";
    }

    //员工删除
    @DeleteMapping("/weixiujilu/{id}")
    public String deleteWeixiujilu(@PathVariable("id") String id){
        weixiuMapper.delete(id);
        return "redirect:/weixiujilus";
    }
    
  //客户查询
    @PostMapping(value = "/weixiujilusearch")
    public String Weixiujilusearch(@RequestParam("chepaihao") String chepaihao,
                        @RequestParam("chezhuxingming") String chezhuxingming,
                        Model model){
        Map<String, Object> condition = new HashMap<String, Object>();       
        if (!chepaihao.isEmpty()) {
            condition.put("chepaihao", chepaihao);
		}
        if (!chezhuxingming.isEmpty()) {
            condition.put("chezhuxingming", chezhuxingming);
		}
        List<Weixiujilu> weixiujilus = weixiuMapper.getWeixiuByConditions(condition);                
		model.addAttribute("weixiujilus",weixiujilus);
    	return "weixiujilu/weixiujilulist";
    }
}
