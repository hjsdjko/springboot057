package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JiaolianyuyueEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiaolianyuyueView;


/**
 * 教练预约
 *
 * @author 
 * @email 
 * @date 2024-03-03 22:37:39
 */
public interface JiaolianyuyueService extends IService<JiaolianyuyueEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiaolianyuyueView> selectListView(Wrapper<JiaolianyuyueEntity> wrapper);
   	
   	JiaolianyuyueView selectView(@Param("ew") Wrapper<JiaolianyuyueEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiaolianyuyueEntity> wrapper);
   	

}

