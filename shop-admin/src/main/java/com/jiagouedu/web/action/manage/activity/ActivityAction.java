package com.jiagouedu.web.action.manage.activity;import com.jiagouedu.core.dao.page.PagerModel;import com.jiagouedu.core.util.DateTimeUtil;import com.jiagouedu.services.manage.activity.ActivityService;import com.jiagouedu.services.manage.activity.bean.Activity;import com.jiagouedu.web.action.BaseController;import org.slf4j.Logger;import org.slf4j.LoggerFactory;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Controller;import org.springframework.ui.ModelMap;import org.springframework.web.bind.annotation.RequestMapping;/** * 活动管理 * @author wukong 源码学院 Java互联网技术QQ群：940577921（备注：11） */@Controller@RequestMapping("/manage/activity/")public class ActivityAction extends BaseController<Activity> {	private static final Logger logger = LoggerFactory.getLogger(ActivityAction.class);	private static final long serialVersionUID = 1L;	@Autowired	private ActivityService activityService;	private static final String page_toList = "/manage/activity/activityList";	private static final String page_toEdit = "/manage/activity/activityEdit";	private static final String page_toAdd = "/manage/activity/activityEdit";	private ActivityAction() {		super.page_toList = page_toList;		super.page_toAdd = page_toAdd;		super.page_toEdit = page_toEdit;	}	@Override	public ActivityService getService() {		return activityService;	}	@Override	public String toEdit(Activity e, ModelMap model) throws Exception {		e = getService().selectOne(e);		String[] selectAccountRange = e.getAccountRange().split(",");		for(int i=0;i<selectAccountRange.length;i++){			//去除因struts2控件提交导致的空格			selectAccountRange[i]  = selectAccountRange[i].trim();			logger.error("selectAccountRange[i]="+selectAccountRange[i]);		}		model.addAttribute("e", e);		return page_toEdit;	}		@Override	protected void selectListAfter(PagerModel pager) {		if(pager!=null && pager.getList()!=null && pager.getList().size()>0){			for(int i=0;i<pager.getList().size();i++){				Activity activity = (Activity) pager.getList().get(i);				activity.setExpire(activity.checkActivity());				if(!activity.isExpire()){					//计算活动多久结束，是否已结束					activity.setActivityEndDateTime(DateTimeUtil.getActivityEndDateTimeString(activity.getEndDate()));				}			}		}		super.selectListAfter(pager);	}}