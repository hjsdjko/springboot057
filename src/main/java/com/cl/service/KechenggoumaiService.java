package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.KechenggoumaiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.KechenggoumaiView;


/**
 * 课程购买
 *
 * @author 
 * @email 
 * @date 2024-03-03 22:37:39
 */
public interface KechenggoumaiService extends IService<KechenggoumaiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KechenggoumaiView> selectListView(Wrapper<KechenggoumaiEntity> wrapper);
   	
   	KechenggoumaiView selectView(@Param("ew") Wrapper<KechenggoumaiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KechenggoumaiEntity> wrapper);
   	

}

