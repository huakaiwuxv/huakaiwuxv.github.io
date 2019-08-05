package cn.example.qixiu.mapper.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import cn.example.qixiu.bean.Weixiujilu;


/**
 * @author syt
 * @date 2019年5月9日
 * @version 1.0
 */
public class WeixiuProvider {
	/** 
	* @Fields TABLE_NAME : 数据库表名字 
	*/ 
	private final String TABLE_NAME="weixiujilu";
	/**
	 * 查询客户
	 * @param condition
	 * @return
	 */
	public String getWeixiuByCondition(Map<String, Object> condition){
		SQL sql=new SQL();
		sql.SELECT("*");
		sql.FROM(TABLE_NAME);
		if(condition != null){
			//修改字段
//			if(condition.get("chepaihao") != null) sql.SET("chepaihao = #{chepaihao}");
//			if(condition.get("id") != null) sql.SET("id = #{id}");
//			if(condition.get("chexing") != null) sql.SET("chexing = #{chexing}");	
//			//修改条件
			if(condition.get("id") != null) sql.WHERE("id = #{id}");
//			if(condition.get("huiyuanka") != null) sql.WHERE("huiyuanka = #{huiyuanka}");
//			if(condition.get("startdate") != null) sql.WHERE("startdate = #{startdate}");
		}
		return sql.toString();
	}
	/**
	 * 查询客户
	 * @param condition
	 * @return
	 */
	public String getWeixiuByConditions(Map<String, Object> condition){
		SQL sql=new SQL();
		sql.SELECT("*");
		sql.FROM(TABLE_NAME);
		if(condition != null){
			//修改字段
//			if(condition.get("chepaihao") != null) sql.SET("chepaihao = #{chepaihao}");
//			if(condition.get("id") != null) sql.SET("id = #{id}");
//			if(condition.get("chexing") != null) sql.SET("chexing = #{chexing}");	
//			//修改条件
			if(condition.get("chepaihao") != null) sql.WHERE("chepaihao = #{chepaihao}");
			if(condition.get("chezhuxingming") != null) sql.WHERE("chezhuxingming = #{chezhuxingming}");
//			if(condition.get("chexing") != null) sql.WHERE("chexing = #{chexing}");
		}
		sql.ORDER_BY("weixiudate desc");
		return sql.toString();
	}
	/*
	 * 插入信息
	 */
	public String insertWeixiu(Weixiujilu weixiujilu){
		SQL sql=new SQL();
		sql.INSERT_INTO(TABLE_NAME);
		//sql.VALUES("chepaihao", "#{chepaihao}");
		sql.VALUES("id", "#{id}");
		sql.VALUES("fuwugongshi", "#{fuwugongshi}");
		sql.VALUES("peijianjine", "#{peijianjine}");
		sql.VALUES("suoshoujine", "#{suoshoujine}");
		sql.VALUES("weixiudate", "#{weixiudate}");
		sql.VALUES("weixiuleixing", "#{weixiuleixing}");
		sql.VALUES("shifoujiesuan", "#{shifoujiesuan}");
		sql.VALUES("jiesuanleixing", "#{jiesuanleixing}");
		sql.VALUES("fulu", "#{fulu}");
		sql.VALUES("chepaihao", "#{chepaihao}");
		sql.VALUES("chezhuxingming", "#{chezhuxingming}");
		
		return sql.toString();
		
	}
	/*
	 * 修改信息
	 */
	public String updateWeixiuByCondition(Map<String, Object> condition){
		SQL sql=new SQL();
		sql.UPDATE(TABLE_NAME);
		if(condition != null){
			//修改字段
			
			if(condition.get("fuwugongshi") != null) sql.SET("fuwugongshi = #{fuwugongshi}");
			if(condition.get("peijianjine") != null) sql.SET("peijianjine = #{peijianjine}");
			if(condition.get("suoshoujine") != null) sql.SET("suoshoujine = #{suoshoujine}");
			if(condition.get("weixiuleixing") != null) sql.SET("weixiuleixing = #{weixiuleixing}");	
			if(condition.get("shifoujiesuan") != null) sql.SET("shifoujiesuan = #{shifoujiesuan}");
			if(condition.get("jiesuanleixing") != null) sql.SET("jiesuanleixing = #{jiesuanleixing}");
			if(condition.get("fulu") != null) sql.SET("fulu = #{fulu}");	
			if(condition.get("chepaihao") != null) sql.SET("chepaihao = #{chepaihao}");	
			if(condition.get("chezhuxingming") != null) sql.SET("chezhuxingming = #{chezhuxingming}");	

			
			
			//修改条件
			
			if(condition.get("id") != null) sql.WHERE("id = #{id}");
			
		}
		return sql.toString();
	}
}
