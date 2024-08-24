package com.cl.dao;

import com.cl.entity.LanqiukechengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.LanqiukechengView;


/**
 * 篮球课程
 * 
 * @author 
 * @email 
 * @date 2024-03-03 22:37:39
 */
public interface LanqiukechengDao extends BaseMapper<LanqiukechengEntity> {
	
	List<LanqiukechengView> selectListView(@Param("ew") Wrapper<LanqiukechengEntity> wrapper);

	List<LanqiukechengView> selectListView(Pagination page,@Param("ew") Wrapper<LanqiukechengEntity> wrapper);
	
	LanqiukechengView selectView(@Param("ew") Wrapper<LanqiukechengEntity> wrapper);
	

}
