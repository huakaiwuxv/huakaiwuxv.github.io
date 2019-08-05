package cn.example.qixiu.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import cn.example.qixiu.bean.Weixiujilu;
import cn.example.qixiu.mapper.provider.WeixiuProvider;

@Mapper
public interface WeixiuMapper {
	@Select("select * from weixiujilu order by weixiudate desc")
    List<Weixiujilu> findAll();
	//SELECT COUNT(*) FROM table_name
	@Select("select count(*) from weixiujilu ")
    public int countsum();
	
	@SelectProvider(method="getWeixiuByCondition",type=WeixiuProvider.class)
	public Weixiujilu getWeixiuByCondition(Map<String, Object> condition);
	
	@SelectProvider(method="getWeixiuByConditions",type=WeixiuProvider.class)
	public List<Weixiujilu> getWeixiuByConditions(Map<String, Object> condition);
    
	@InsertProvider(method = "insertWeixiu", type = WeixiuProvider.class)
	public int insertWeixiu(Weixiujilu weixiujilu);
      
    @Delete(" delete from weixiujilu where id= #{id} ")
    public void delete(String id);
       
    @UpdateProvider(method="updateWeixiuByCondition",type=WeixiuProvider.class)
	public int updateWeixiuByCondition(Map<String , Object> condition);
}
