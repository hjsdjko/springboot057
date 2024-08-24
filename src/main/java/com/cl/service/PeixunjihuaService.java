package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.PeixunjihuaEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.PeixunjihuaView;


/**
 * 培训计划
 *
 * @author 
 * @email 
 * @date 2024-03-03 22:37:39
 */
public interface PeixunjihuaService extends IService<PeixunjihuaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PeixunjihuaView> selectListView(Wrapper<PeixunjihuaEntity> wrapper);
   	
   	PeixunjihuaView selectView(@Param("ew") Wrapper<PeixunjihuaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PeixunjihuaEntity> wrapper);
   	

}

