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

import com.cl.entity.LanqiukechengEntity;
import com.cl.entity.view.LanqiukechengView;

import com.cl.service.LanqiukechengService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 篮球课程
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-03 22:37:39
 */
@RestController
@RequestMapping("/lanqiukecheng")
public class LanqiukechengController {
    @Autowired
    private LanqiukechengService lanqiukechengService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,LanqiukechengEntity lanqiukecheng,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaolian")) {
			lanqiukecheng.setJiaolianzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<LanqiukechengEntity> ew = new EntityWrapper<LanqiukechengEntity>();

		PageUtils page = lanqiukechengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, lanqiukecheng), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,LanqiukechengEntity lanqiukecheng, 
		HttpServletRequest request){
        EntityWrapper<LanqiukechengEntity> ew = new EntityWrapper<LanqiukechengEntity>();

		PageUtils page = lanqiukechengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, lanqiukecheng), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( LanqiukechengEntity lanqiukecheng){
       	EntityWrapper<LanqiukechengEntity> ew = new EntityWrapper<LanqiukechengEntity>();
      	ew.allEq(MPUtil.allEQMapPre( lanqiukecheng, "lanqiukecheng")); 
        return R.ok().put("data", lanqiukechengService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(LanqiukechengEntity lanqiukecheng){
        EntityWrapper< LanqiukechengEntity> ew = new EntityWrapper< LanqiukechengEntity>();
 		ew.allEq(MPUtil.allEQMapPre( lanqiukecheng, "lanqiukecheng")); 
		LanqiukechengView lanqiukechengView =  lanqiukechengService.selectView(ew);
		return R.ok("查询篮球课程成功").put("data", lanqiukechengView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        LanqiukechengEntity lanqiukecheng = lanqiukechengService.selectById(id);
		lanqiukecheng = lanqiukechengService.selectView(new EntityWrapper<LanqiukechengEntity>().eq("id", id));
        return R.ok().put("data", lanqiukecheng);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        LanqiukechengEntity lanqiukecheng = lanqiukechengService.selectById(id);
		lanqiukecheng = lanqiukechengService.selectView(new EntityWrapper<LanqiukechengEntity>().eq("id", id));
        return R.ok().put("data", lanqiukecheng);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LanqiukechengEntity lanqiukecheng, HttpServletRequest request){
    	lanqiukecheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(lanqiukecheng);
        lanqiukechengService.insert(lanqiukecheng);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody LanqiukechengEntity lanqiukecheng, HttpServletRequest request){
    	lanqiukecheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(lanqiukecheng);
        lanqiukechengService.insert(lanqiukecheng);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody LanqiukechengEntity lanqiukecheng, HttpServletRequest request){
        //ValidatorUtils.validateEntity(lanqiukecheng);
        lanqiukechengService.updateById(lanqiukecheng);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        lanqiukechengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
