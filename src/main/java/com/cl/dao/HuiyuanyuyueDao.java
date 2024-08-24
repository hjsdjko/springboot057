package com.cl.dao;

import com.cl.entity.HuiyuanyuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HuiyuanyuyueView;


/**
 * 会员预约
 * 
 * @author 
 * @email 
 * @date 2024-03-03 22:37:39
 */
public interface HuiyuanyuyueDao extends BaseMapper<HuiyuanyuyueEntity> {
	
	List<HuiyuanyuyueView> selectListView(@Param("ew") Wrapper<HuiyuanyuyueEntity> wrapper);

	List<HuiyuanyuyueView> selectListView(Pagination page,@Param("ew") Wrapper<HuiyuanyuyueEntity> wrapper);
	
	HuiyuanyuyueView selectView(@Param("ew") Wrapper<HuiyuanyuyueEntity> wrapper);
	

}
