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


import com.cl.dao.LanqiukechengDao;
import com.cl.entity.LanqiukechengEntity;
import com.cl.service.LanqiukechengService;
import com.cl.entity.view.LanqiukechengView;

@Service("lanqiukechengService")
public class LanqiukechengServiceImpl extends ServiceImpl<LanqiukechengDao, LanqiukechengEntity> implements LanqiukechengService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LanqiukechengEntity> page = this.selectPage(
                new Query<LanqiukechengEntity>(params).getPage(),
                new EntityWrapper<LanqiukechengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LanqiukechengEntity> wrapper) {
		  Page<LanqiukechengView> page =new Query<LanqiukechengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<LanqiukechengView> selectListView(Wrapper<LanqiukechengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LanqiukechengView selectView(Wrapper<LanqiukechengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
