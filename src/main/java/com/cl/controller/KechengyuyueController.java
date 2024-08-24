package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.KechengyuyueEntity;
import com.cl.entity.view.KechengyuyueView;

import com.cl.service.KechengyuyueService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 课程预约
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-03 22:37:39
 */
@RestController
@RequestMapping("/kechengyuyue")
public class KechengyuyueController {
    @Autowired
    private KechengyuyueService kechengyuyueService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KechengyuyueEntity kechengyuyue,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaolian")) {
			kechengyuyue.setJiaolianzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("huiyuan")) {
			kechengyuyue.setHuiyuanzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<KechengyuyueEntity> ew = new EntityWrapper<KechengyuyueEntity>();

		PageUtils page = kechengyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kechengyuyue), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KechengyuyueEntity kechengyuyue, 
		HttpServletRequest request){
        EntityWrapper<KechengyuyueEntity> ew = new EntityWrapper<KechengyuyueEntity>();

		PageUtils page = kechengyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kechengyuyue), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KechengyuyueEntity kechengyuyue){
       	EntityWrapper<KechengyuyueEntity> ew = new EntityWrapper<KechengyuyueEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kechengyuyue, "kechengyuyue")); 
        return R.ok().put("data", kechengyuyueService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KechengyuyueEntity kechengyuyue){
        EntityWrapper< KechengyuyueEntity> ew = new EntityWrapper< KechengyuyueEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kechengyuyue, "kechengyuyue")); 
		KechengyuyueView kechengyuyueView =  kechengyuyueService.selectView(ew);
		return R.ok("查询课程预约成功").put("data", kechengyuyueView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KechengyuyueEntity kechengyuyue = kechengyuyueService.selectById(id);
		kechengyuyue = kechengyuyueService.selectView(new EntityWrapper<KechengyuyueEntity>().eq("id", id));
        return R.ok().put("data", kechengyuyue);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KechengyuyueEntity kechengyuyue = kechengyuyueService.selectById(id);
		kechengyuyue = kechengyuyueService.selectView(new EntityWrapper<KechengyuyueEntity>().eq("id", id));
        return R.ok().put("data", kechengyuyue);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KechengyuyueEntity kechengyuyue, HttpServletRequest request){
    	kechengyuyue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kechengyuyue);
        kechengyuyueService.insert(kechengyuyue);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KechengyuyueEntity kechengyuyue, HttpServletRequest request){
    	kechengyuyue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kechengyuyue);
        kechengyuyueService.insert(kechengyuyue);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody KechengyuyueEntity kechengyuyue, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kechengyuyue);
        kechengyuyueService.updateById(kechengyuyue);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        kechengyuyueService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
