package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.JiaolianyuyueDao;
import com.cl.entity.JiaolianyuyueEntity;
import com.cl.service.JiaolianyuyueService;
import com.cl.entity.view.JiaolianyuyueView;

@Service("jiaolianyuyueService")
public class JiaolianyuyueServiceImpl extends ServiceImpl<JiaolianyuyueDao, JiaolianyuyueEntity> implements JiaolianyuyueService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiaolianyuyueEntity> page = this.selectPage(
                new Query<JiaolianyuyueEntity>(params).getPage(),
                new EntityWrapper<JiaolianyuyueEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiaolianyuyueEntity> wrapper) {
		  Page<JiaolianyuyueView> page =new Query<JiaolianyuyueView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<JiaolianyuyueView> selectListView(Wrapper<JiaolianyuyueEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiaolianyuyueView selectView(Wrapper<JiaolianyuyueEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
