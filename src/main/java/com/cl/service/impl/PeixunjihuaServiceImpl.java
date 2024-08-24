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


import com.cl.dao.PeixunjihuaDao;
import com.cl.entity.PeixunjihuaEntity;
import com.cl.service.PeixunjihuaService;
import com.cl.entity.view.PeixunjihuaView;

@Service("peixunjihuaService")
public class PeixunjihuaServiceImpl extends ServiceImpl<PeixunjihuaDao, PeixunjihuaEntity> implements PeixunjihuaService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PeixunjihuaEntity> page = this.selectPage(
                new Query<PeixunjihuaEntity>(params).getPage(),
                new EntityWrapper<PeixunjihuaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PeixunjihuaEntity> wrapper) {
		  Page<PeixunjihuaView> page =new Query<PeixunjihuaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<PeixunjihuaView> selectListView(Wrapper<PeixunjihuaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PeixunjihuaView selectView(Wrapper<PeixunjihuaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
