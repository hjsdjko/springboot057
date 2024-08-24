package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.KechengyuyueEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.KechengyuyueView;


/**
 * 课程预约
 *
 * @author 
 * @email 
 * @date 2024-03-03 22:37:39
 */
public interface KechengyuyueService extends IService<KechengyuyueEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KechengyuyueView> selectListView(Wrapper<KechengyuyueEntity> wrapper);
   	
   	KechengyuyueView selectView(@Param("ew") Wrapper<KechengyuyueEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KechengyuyueEntity> wrapper);
   	

}

