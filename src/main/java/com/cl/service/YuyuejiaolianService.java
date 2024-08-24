package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YuyuejiaolianEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YuyuejiaolianView;


/**
 * 预约教练
 *
 * @author 
 * @email 
 * @date 2024-03-03 22:37:39
 */
public interface YuyuejiaolianService extends IService<YuyuejiaolianEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YuyuejiaolianView> selectListView(Wrapper<YuyuejiaolianEntity> wrapper);
   	
   	YuyuejiaolianView selectView(@Param("ew") Wrapper<YuyuejiaolianEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YuyuejiaolianEntity> wrapper);
   	

}

