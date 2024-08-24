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


import com.cl.dao.KechengyuyueDao;
import com.cl.entity.KechengyuyueEntity;
import com.cl.service.KechengyuyueService;
import com.cl.entity.view.KechengyuyueView;

@Service("kechengyuyueService")
public class KechengyuyueServiceImpl extends ServiceImpl<KechengyuyueDao, KechengyuyueEntity> implements KechengyuyueService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KechengyuyueEntity> page = this.selectPage(
                new Query<KechengyuyueEntity>(params).getPage(),
                new EntityWrapper<KechengyuyueEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KechengyuyueEntity> wrapper) {
		  Page<KechengyuyueView> page =new Query<KechengyuyueView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<KechengyuyueView> selectListView(Wrapper<KechengyuyueEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KechengyuyueView selectView(Wrapper<KechengyuyueEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
