package com.cl.dao;

import com.cl.entity.PeixunjihuaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.PeixunjihuaView;


/**
 * 培训计划
 * 
 * @author 
 * @email 
 * @date 2024-03-03 22:37:39
 */
public interface PeixunjihuaDao extends BaseMapper<PeixunjihuaEntity> {
	
	List<PeixunjihuaView> selectListView(@Param("ew") Wrapper<PeixunjihuaEntity> wrapper);

	List<PeixunjihuaView> selectListView(Pagination page,@Param("ew") Wrapper<PeixunjihuaEntity> wrapper);
	
	PeixunjihuaView selectView(@Param("ew") Wrapper<PeixunjihuaEntity> wrapper);
	

}
