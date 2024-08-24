package com.cl.dao;

import com.cl.entity.XunliankechengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XunliankechengView;


/**
 * 训练课程
 * 
 * @author 
 * @email 
 * @date 2024-03-03 22:37:39
 */
public interface XunliankechengDao extends BaseMapper<XunliankechengEntity> {
	
	List<XunliankechengView> selectListView(@Param("ew") Wrapper<XunliankechengEntity> wrapper);

	List<XunliankechengView> selectListView(Pagination page,@Param("ew") Wrapper<XunliankechengEntity> wrapper);
	
	XunliankechengView selectView(@Param("ew") Wrapper<XunliankechengEntity> wrapper);
	

}
