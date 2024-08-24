package com.cl.dao;

import com.cl.entity.KechengyuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.KechengyuyueView;


/**
 * 课程预约
 * 
 * @author 
 * @email 
 * @date 2024-03-03 22:37:39
 */
public interface KechengyuyueDao extends BaseMapper<KechengyuyueEntity> {
	
	List<KechengyuyueView> selectListView(@Param("ew") Wrapper<KechengyuyueEntity> wrapper);

	List<KechengyuyueView> selectListView(Pagination page,@Param("ew") Wrapper<KechengyuyueEntity> wrapper);
	
	KechengyuyueView selectView(@Param("ew") Wrapper<KechengyuyueEntity> wrapper);
	

}
