package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.LanqiukechengEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.LanqiukechengView;


/**
 * 篮球课程
 *
 * @author 
 * @email 
 * @date 2024-03-03 22:37:39
 */
public interface LanqiukechengService extends IService<LanqiukechengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LanqiukechengView> selectListView(Wrapper<LanqiukechengEntity> wrapper);
   	
   	LanqiukechengView selectView(@Param("ew") Wrapper<LanqiukechengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LanqiukechengEntity> wrapper);
   	

}

