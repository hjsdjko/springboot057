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


import com.cl.dao.HuiyuanyuyueDao;
import com.cl.entity.HuiyuanyuyueEntity;
import com.cl.service.HuiyuanyuyueService;
import com.cl.entity.view.HuiyuanyuyueView;

@Service("huiyuanyuyueService")
public class HuiyuanyuyueServiceImpl extends ServiceImpl<HuiyuanyuyueDao, HuiyuanyuyueEntity> implements HuiyuanyuyueService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HuiyuanyuyueEntity> page = this.selectPage(
                new Query<HuiyuanyuyueEntity>(params).getPage(),
                new EntityWrapper<HuiyuanyuyueEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HuiyuanyuyueEntity> wrapper) {
		  Page<HuiyuanyuyueView> page =new Query<HuiyuanyuyueView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<HuiyuanyuyueView> selectListView(Wrapper<HuiyuanyuyueEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HuiyuanyuyueView selectView(Wrapper<HuiyuanyuyueEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
