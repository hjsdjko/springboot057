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

import com.cl.entity.KechenggoumaiEntity;
import com.cl.entity.view.KechenggoumaiView;

import com.cl.service.KechenggoumaiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 课程购买
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-03 22:37:39
 */
@RestController
@RequestMapping("/kechenggoumai")
public class KechenggoumaiController {
    @Autowired
    private KechenggoumaiService kechenggoumaiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KechenggoumaiEntity kechenggoumai,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaolian")) {
			kechenggoumai.setJiaolianzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			kechenggoumai.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<KechenggoumaiEntity> ew = new EntityWrapper<KechenggoumaiEntity>();

		PageUtils page = kechenggoumaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kechenggoumai), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KechenggoumaiEntity kechenggoumai, 
		HttpServletRequest request){
        EntityWrapper<KechenggoumaiEntity> ew = new EntityWrapper<KechenggoumaiEntity>();

		PageUtils page = kechenggoumaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kechenggoumai), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KechenggoumaiEntity kechenggoumai){
       	EntityWrapper<KechenggoumaiEntity> ew = new EntityWrapper<KechenggoumaiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kechenggoumai, "kechenggoumai")); 
        return R.ok().put("data", kechenggoumaiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KechenggoumaiEntity kechenggoumai){
        EntityWrapper< KechenggoumaiEntity> ew = new EntityWrapper< KechenggoumaiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kechenggoumai, "kechenggoumai")); 
		KechenggoumaiView kechenggoumaiView =  kechenggoumaiService.selectView(ew);
		return R.ok("查询课程购买成功").put("data", kechenggoumaiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KechenggoumaiEntity kechenggoumai = kechenggoumaiService.selectById(id);
		kechenggoumai = kechenggoumaiService.selectView(new EntityWrapper<KechenggoumaiEntity>().eq("id", id));
        return R.ok().put("data", kechenggoumai);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KechenggoumaiEntity kechenggoumai = kechenggoumaiService.selectById(id);
		kechenggoumai = kechenggoumaiService.selectView(new EntityWrapper<KechenggoumaiEntity>().eq("id", id));
        return R.ok().put("data", kechenggoumai);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KechenggoumaiEntity kechenggoumai, HttpServletRequest request){
    	kechenggoumai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kechenggoumai);
        kechenggoumaiService.insert(kechenggoumai);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KechenggoumaiEntity kechenggoumai, HttpServletRequest request){
    	kechenggoumai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kechenggoumai);
        kechenggoumaiService.insert(kechenggoumai);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody KechenggoumaiEntity kechenggoumai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kechenggoumai);
        kechenggoumaiService.updateById(kechenggoumai);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        kechenggoumaiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
