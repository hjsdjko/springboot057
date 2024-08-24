package com.cl.dao;

import com.cl.entity.ChangdixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ChangdixinxiView;


/**
 * 场地信息
 * 
 * @author 
 * @email 
 * @date 2024-03-03 22:37:39
 */
public interface ChangdixinxiDao extends BaseMapper<ChangdixinxiEntity> {
	
	List<ChangdixinxiView> selectListView(@Param("ew") Wrapper<ChangdixinxiEntity> wrapper);

	List<ChangdixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<ChangdixinxiEntity> wrapper);
	
	ChangdixinxiView selectView(@Param("ew") Wrapper<ChangdixinxiEntity> wrapper);
	

}
