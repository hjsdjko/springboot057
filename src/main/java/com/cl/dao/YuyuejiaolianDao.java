package com.cl.dao;

import com.cl.entity.YuyuejiaolianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YuyuejiaolianView;


/**
 * 预约教练
 * 
 * @author 
 * @email 
 * @date 2024-03-03 22:37:39
 */
public interface YuyuejiaolianDao extends BaseMapper<YuyuejiaolianEntity> {
	
	List<YuyuejiaolianView> selectListView(@Param("ew") Wrapper<YuyuejiaolianEntity> wrapper);

	List<YuyuejiaolianView> selectListView(Pagination page,@Param("ew") Wrapper<YuyuejiaolianEntity> wrapper);
	
	YuyuejiaolianView selectView(@Param("ew") Wrapper<YuyuejiaolianEntity> wrapper);
	

}
