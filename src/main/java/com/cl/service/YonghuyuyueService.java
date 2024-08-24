package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YonghuyuyueEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YonghuyuyueView;


/**
 * 用户预约
 *
 * @author 
 * @email 
 * @date 2024-03-03 22:37:39
 */
public interface YonghuyuyueService extends IService<YonghuyuyueEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YonghuyuyueView> selectListView(Wrapper<YonghuyuyueEntity> wrapper);
   	
   	YonghuyuyueView selectView(@Param("ew") Wrapper<YonghuyuyueEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YonghuyuyueEntity> wrapper);
   	

}

