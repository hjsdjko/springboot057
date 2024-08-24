package com.cl.dao;

import com.cl.entity.YonghuyuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YonghuyuyueView;


/**
 * 用户预约
 * 
 * @author 
 * @email 
 * @date 2024-03-03 22:37:39
 */
public interface YonghuyuyueDao extends BaseMapper<YonghuyuyueEntity> {
	
	List<YonghuyuyueView> selectListView(@Param("ew") Wrapper<YonghuyuyueEntity> wrapper);

	List<YonghuyuyueView> selectListView(Pagination page,@Param("ew") Wrapper<YonghuyuyueEntity> wrapper);
	
	YonghuyuyueView selectView(@Param("ew") Wrapper<YonghuyuyueEntity> wrapper);
	

}
