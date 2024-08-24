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

import com.cl.entity.YonghuyuyueEntity;
import com.cl.entity.view.YonghuyuyueView;

import com.cl.service.YonghuyuyueService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 用户预约
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-03 22:37:39
 */
@RestController
@RequestMapping("/yonghuyuyue")
public class YonghuyuyueController {
    @Autowired
    private YonghuyuyueService yonghuyuyueService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YonghuyuyueEntity yonghuyuyue,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			yonghuyuyue.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YonghuyuyueEntity> ew = new EntityWrapper<YonghuyuyueEntity>();

		PageUtils page = yonghuyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yonghuyuyue), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YonghuyuyueEntity yonghuyuyue, 
		HttpServletRequest request){
        EntityWrapper<YonghuyuyueEntity> ew = new EntityWrapper<YonghuyuyueEntity>();

		PageUtils page = yonghuyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yonghuyuyue), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YonghuyuyueEntity yonghuyuyue){
       	EntityWrapper<YonghuyuyueEntity> ew = new EntityWrapper<YonghuyuyueEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yonghuyuyue, "yonghuyuyue")); 
        return R.ok().put("data", yonghuyuyueService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YonghuyuyueEntity yonghuyuyue){
        EntityWrapper< YonghuyuyueEntity> ew = new EntityWrapper< YonghuyuyueEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yonghuyuyue, "yonghuyuyue")); 
		YonghuyuyueView yonghuyuyueView =  yonghuyuyueService.selectView(ew);
		return R.ok("查询用户预约成功").put("data", yonghuyuyueView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YonghuyuyueEntity yonghuyuyue = yonghuyuyueService.selectById(id);
		yonghuyuyue = yonghuyuyueService.selectView(new EntityWrapper<YonghuyuyueEntity>().eq("id", id));
        return R.ok().put("data", yonghuyuyue);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YonghuyuyueEntity yonghuyuyue = yonghuyuyueService.selectById(id);
		yonghuyuyue = yonghuyuyueService.selectView(new EntityWrapper<YonghuyuyueEntity>().eq("id", id));
        return R.ok().put("data", yonghuyuyue);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YonghuyuyueEntity yonghuyuyue, HttpServletRequest request){
    	yonghuyuyue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yonghuyuyue);
        yonghuyuyueService.insert(yonghuyuyue);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YonghuyuyueEntity yonghuyuyue, HttpServletRequest request){
    	yonghuyuyue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yonghuyuyue);
        yonghuyuyueService.insert(yonghuyuyue);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YonghuyuyueEntity yonghuyuyue, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yonghuyuyue);
        yonghuyuyueService.updateById(yonghuyuyue);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yonghuyuyueService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
