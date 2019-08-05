package cn.example.qixiu.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import cn.example.qixiu.bean.Kehuxinxi;
import cn.example.qixiu.mapper.provider.KehuxinxiProvider;

@Mapper
public interface KehuxinxiMapper {
	@Select("select * from kehuxinxi order by startdate desc")
    List<Kehuxinxi> findAll();
        
	@SelectProvider(method="getKehuxinxiByCondition",type=KehuxinxiProvider.class)
	public Kehuxinxi getKehuxinxiByCondition(Map<String, Object> condition);
    
	@SelectProvider(method="getKehuxinxiByConditions",type=KehuxinxiProvider.class)
	public List<Kehuxinxi> getKehuxinxiByConditions(Map<String, Object> condition);
	
	@InsertProvider(method = "insertKehuxinxi", type = KehuxinxiProvider.class)
	public int insertKehuxinxi(Kehuxinxi kehuxinxi);
      
    @Delete(" delete from kehuxinxi where id= #{id} ")
    public void delete(String id);
       
    @UpdateProvider(method="updateKehuxinxiByCondition",type=KehuxinxiProvider.class)
	public int updateKehuxinxiByCondition(Map<String , Object> condition);
}
