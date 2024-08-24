package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.HuiyuanyuyueEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HuiyuanyuyueView;


/**
 * 会员预约
 *
 * @author 
 * @email 
 * @date 2024-03-03 22:37:39
 */
public interface HuiyuanyuyueService extends IService<HuiyuanyuyueEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HuiyuanyuyueView> selectListView(Wrapper<HuiyuanyuyueEntity> wrapper);
   	
   	HuiyuanyuyueView selectView(@Param("ew") Wrapper<HuiyuanyuyueEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HuiyuanyuyueEntity> wrapper);
   	

}

