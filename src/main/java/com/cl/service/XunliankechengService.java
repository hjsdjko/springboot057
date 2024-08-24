package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.XunliankechengEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XunliankechengView;


/**
 * 训练课程
 *
 * @author 
 * @email 
 * @date 2024-03-03 22:37:39
 */
public interface XunliankechengService extends IService<XunliankechengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XunliankechengView> selectListView(Wrapper<XunliankechengEntity> wrapper);
   	
   	XunliankechengView selectView(@Param("ew") Wrapper<XunliankechengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XunliankechengEntity> wrapper);
   	

}

