package com.cl.dao;

import com.cl.entity.JiaolianyuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiaolianyuyueView;


/**
 * 教练预约
 * 
 * @author 
 * @email 
 * @date 2024-03-03 22:37:39
 */
public interface JiaolianyuyueDao extends BaseMapper<JiaolianyuyueEntity> {
	
	List<JiaolianyuyueView> selectListView(@Param("ew") Wrapper<JiaolianyuyueEntity> wrapper);

	List<JiaolianyuyueView> selectListView(Pagination page,@Param("ew") Wrapper<JiaolianyuyueEntity> wrapper);
	
	JiaolianyuyueView selectView(@Param("ew") Wrapper<JiaolianyuyueEntity> wrapper);
	

}
