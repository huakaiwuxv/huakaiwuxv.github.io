package cn.example.qixiu.mapper.provider;

import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.jdbc.SQL;

import cn.example.qixiu.bean.Kehuxinxi;


/**
 * @author syt
 * @date 2019年5月9日
 * @version 1.0
 */
public class KehuxinxiProvider {
	/** 
	* @Fields TABLE_NAME : 数据库表名字 
	*/ 
	private final String TABLE_NAME="kehuxinxi";
	/**
	 * 查询客户
	 * @param condition
	 * @return
	 */
	public String getKehuxinxiByCondition(Map<String, Object> condition){
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
//			if(condition.get("chepaihao") != null) sql.WHERE("chepaihao = #{chepaihao}");
//			if(condition.get("chezhuxingming") != null) sql.WHERE("chezhuxingming = #{chezhuxingming}");
//			if(condition.get("chexing") != null) sql.WHERE("chexing = #{chexing}");
		}
		//System.out.println(sql.toString());
		return sql.toString();
	}
	/**
	 * 查询客户
	 * @param condition
	 * @return
	 */
	public String getKehuxinxiByConditions(Map<String, Object> condition){
		SQL sql=new SQL();
		sql.SELECT("*");
		sql.FROM(TABLE_NAME);
		if(condition != null){
			//修改字段
//			if(condition.get("chepaihao") != null) sql.SET("chepaihao = #{chepaihao}");
//			if(condition.get("id") != null) sql.SET("id = #{id}");
//			if(condition.get("chexing") != null) sql.SET("chexing = #{chexing}");	
//			//修改条件
			//if(condition.get("id") != null) sql.WHERE("id = #{id}");
			if(condition.get("chepaihao") != null) sql.WHERE("chepaihao = #{chepaihao}");
			if(condition.get("chezhuxingming") != null) sql.WHERE("chezhuxingming = #{chezhuxingming}");
			if(condition.get("chexing") != null) sql.WHERE("chexing = #{chexing}");
		}
//		@Select("select * from kehuxinxi order by startdate desc")
		sql.ORDER_BY("startdate desc");
		
		return sql.toString();
	}
	/*
	 * 插入信息
	 */
	public String insertKehuxinxi(Kehuxinxi kehuxinxi){
		SQL sql=new SQL();
		sql.INSERT_INTO(TABLE_NAME);
		sql.VALUES("chepaihao", "#{chepaihao}");
		sql.VALUES("id", "#{id}");
		sql.VALUES("chexing", "#{chexing}");
		sql.VALUES("chezhuxingming", "#{chezhuxingming}");
		sql.VALUES("huiyuanka", "#{huiyuanka}");
		sql.VALUES("startdate", "#{startdate}");
		sql.VALUES("yue", "#{yue}");
		
		return sql.toString();
		
	}
	/*
	 * 修改信息
	 */
	public String updateKehuxinxiByCondition(Map<String, Object> condition){
		SQL sql=new SQL();
		sql.UPDATE(TABLE_NAME);
		if(condition != null){
			//修改字段
			if(condition.get("chepaihao") != null) sql.SET("chepaihao = #{chepaihao}");
			if(condition.get("chezhuxingming") != null) sql.SET("chezhuxingming = #{chezhuxingming}");
			if(condition.get("huiyuanka") != null) sql.SET("huiyuanka = #{huiyuanka}");
			if(condition.get("chexing") != null) sql.SET("chexing = #{chexing}");	
//			if(condition.get("chexing") != null) sql.SET("chexing = #{chexing}");
			if(condition.get("yue") != null) sql.SET("yue = #{yue}");

			//修改条件
			
			if(condition.get("id") != null) sql.WHERE("id = #{id}");
			
		}
		return sql.toString();
	}
}
