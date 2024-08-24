package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ChangdixinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ChangdixinxiView;


/**
 * 场地信息
 *
 * @author 
 * @email 
 * @date 2024-03-03 22:37:39
 */
public interface ChangdixinxiService extends IService<ChangdixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChangdixinxiView> selectListView(Wrapper<ChangdixinxiEntity> wrapper);
   	
   	ChangdixinxiView selectView(@Param("ew") Wrapper<ChangdixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChangdixinxiEntity> wrapper);
   	

}

