package com.cl.dao;

import com.cl.entity.JiaolianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiaolianView;


/**
 * 教练
 * 
 * @author 
 * @email 
 * @date 2024-03-03 22:37:39
 */
public interface JiaolianDao extends BaseMapper<JiaolianEntity> {
	
	List<JiaolianView> selectListView(@Param("ew") Wrapper<JiaolianEntity> wrapper);

	List<JiaolianView> selectListView(Pagination page,@Param("ew") Wrapper<JiaolianEntity> wrapper);
	
	JiaolianView selectView(@Param("ew") Wrapper<JiaolianEntity> wrapper);
	

}
