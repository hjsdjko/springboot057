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


import com.cl.dao.HuiyuanDao;
import com.cl.entity.HuiyuanEntity;
import com.cl.service.HuiyuanService;
import com.cl.entity.view.HuiyuanView;

@Service("huiyuanService")
public class HuiyuanServiceImpl extends ServiceImpl<HuiyuanDao, HuiyuanEntity> implements HuiyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HuiyuanEntity> page = this.selectPage(
                new Query<HuiyuanEntity>(params).getPage(),
                new EntityWrapper<HuiyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HuiyuanEntity> wrapper) {
		  Page<HuiyuanView> page =new Query<HuiyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<HuiyuanView> selectListView(Wrapper<HuiyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HuiyuanView selectView(Wrapper<HuiyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
