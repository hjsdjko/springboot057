package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JiaolianEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiaolianView;


/**
 * 教练
 *
 * @author 
 * @email 
 * @date 2024-03-03 22:37:39
 */
public interface JiaolianService extends IService<JiaolianEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiaolianView> selectListView(Wrapper<JiaolianEntity> wrapper);
   	
   	JiaolianView selectView(@Param("ew") Wrapper<JiaolianEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiaolianEntity> wrapper);
   	

}

