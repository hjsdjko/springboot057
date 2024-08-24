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

import com.cl.entity.JiaolianyuyueEntity;
import com.cl.entity.view.JiaolianyuyueView;

import com.cl.service.JiaolianyuyueService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 教练预约
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-03 22:37:39
 */
@RestController
@RequestMapping("/jiaolianyuyue")
public class JiaolianyuyueController {
    @Autowired
    private JiaolianyuyueService jiaolianyuyueService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiaolianyuyueEntity jiaolianyuyue,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaolian")) {
			jiaolianyuyue.setJiaolianzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JiaolianyuyueEntity> ew = new EntityWrapper<JiaolianyuyueEntity>();

		PageUtils page = jiaolianyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaolianyuyue), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiaolianyuyueEntity jiaolianyuyue, 
		HttpServletRequest request){
        EntityWrapper<JiaolianyuyueEntity> ew = new EntityWrapper<JiaolianyuyueEntity>();

		PageUtils page = jiaolianyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaolianyuyue), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiaolianyuyueEntity jiaolianyuyue){
       	EntityWrapper<JiaolianyuyueEntity> ew = new EntityWrapper<JiaolianyuyueEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiaolianyuyue, "jiaolianyuyue")); 
        return R.ok().put("data", jiaolianyuyueService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiaolianyuyueEntity jiaolianyuyue){
        EntityWrapper< JiaolianyuyueEntity> ew = new EntityWrapper< JiaolianyuyueEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiaolianyuyue, "jiaolianyuyue")); 
		JiaolianyuyueView jiaolianyuyueView =  jiaolianyuyueService.selectView(ew);
		return R.ok("查询教练预约成功").put("data", jiaolianyuyueView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiaolianyuyueEntity jiaolianyuyue = jiaolianyuyueService.selectById(id);
		jiaolianyuyue = jiaolianyuyueService.selectView(new EntityWrapper<JiaolianyuyueEntity>().eq("id", id));
        return R.ok().put("data", jiaolianyuyue);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiaolianyuyueEntity jiaolianyuyue = jiaolianyuyueService.selectById(id);
		jiaolianyuyue = jiaolianyuyueService.selectView(new EntityWrapper<JiaolianyuyueEntity>().eq("id", id));
        return R.ok().put("data", jiaolianyuyue);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiaolianyuyueEntity jiaolianyuyue, HttpServletRequest request){
    	jiaolianyuyue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiaolianyuyue);
        jiaolianyuyueService.insert(jiaolianyuyue);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiaolianyuyueEntity jiaolianyuyue, HttpServletRequest request){
    	jiaolianyuyue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiaolianyuyue);
        jiaolianyuyueService.insert(jiaolianyuyue);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiaolianyuyueEntity jiaolianyuyue, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiaolianyuyue);
        jiaolianyuyueService.updateById(jiaolianyuyue);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiaolianyuyueService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
