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


import com.cl.dao.JiaolianDao;
import com.cl.entity.JiaolianEntity;
import com.cl.service.JiaolianService;
import com.cl.entity.view.JiaolianView;

@Service("jiaolianService")
public class JiaolianServiceImpl extends ServiceImpl<JiaolianDao, JiaolianEntity> implements JiaolianService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiaolianEntity> page = this.selectPage(
                new Query<JiaolianEntity>(params).getPage(),
                new EntityWrapper<JiaolianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiaolianEntity> wrapper) {
		  Page<JiaolianView> page =new Query<JiaolianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<JiaolianView> selectListView(Wrapper<JiaolianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiaolianView selectView(Wrapper<JiaolianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
