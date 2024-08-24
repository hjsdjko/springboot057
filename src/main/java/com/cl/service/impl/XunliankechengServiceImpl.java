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


import com.cl.dao.XunliankechengDao;
import com.cl.entity.XunliankechengEntity;
import com.cl.service.XunliankechengService;
import com.cl.entity.view.XunliankechengView;

@Service("xunliankechengService")
public class XunliankechengServiceImpl extends ServiceImpl<XunliankechengDao, XunliankechengEntity> implements XunliankechengService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XunliankechengEntity> page = this.selectPage(
                new Query<XunliankechengEntity>(params).getPage(),
                new EntityWrapper<XunliankechengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XunliankechengEntity> wrapper) {
		  Page<XunliankechengView> page =new Query<XunliankechengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<XunliankechengView> selectListView(Wrapper<XunliankechengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XunliankechengView selectView(Wrapper<XunliankechengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
