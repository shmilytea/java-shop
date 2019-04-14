package com.jiagouedu.services.manage.attribute.dao.impl;import com.jiagouedu.core.dao.BaseDao;import com.jiagouedu.core.dao.page.PagerModel;import com.jiagouedu.services.manage.attribute.bean.Attribute;import com.jiagouedu.services.manage.attribute.dao.AttributeDao;import org.springframework.stereotype.Repository;import javax.annotation.Resource;import java.util.List;@Repository("attributeDaoManage")public class AttributeDaoImpl implements AttributeDao {    @Resource	private BaseDao dao;	public void setDao(BaseDao dao) {		this.dao = dao;	}	public PagerModel selectPageList(Attribute e) {		return dao.selectPageList("manage.attribute.selectPageList",				"manage.attribute.selectPageCount", e);	}	public List selectList(Attribute e) {		return dao.selectList("manage.attribute.selectList", e);	}	public Attribute selectOne(Attribute e) {		return (Attribute) dao.selectOne("manage.attribute.selectOne", e);	}	public int delete(Attribute e) {		return dao.delete("manage.attribute.delete", e);	}	public int update(Attribute e) {		return dao.update("manage.attribute.update", e);	}	public int deletes(String[] ids) {		Attribute e = new Attribute();		for (int i = 0; i < ids.length; i++) {			e.setId(ids[i]);			delete(e);		}		return 0;	}	public int insert(Attribute e) {		return dao.insert("manage.attribute.insert", e);	}	public int deleteById(int id) {		return dao.delete("manage.attribute.deleteById", id);	}	public void deleteByPid(int pid) {		 dao.delete("manage.attribute.deleteByPid", pid);	}	public Attribute selectById(String id) {		return (Attribute) dao.selectOne("manage.attribute.selectById",id);	}	public void deleteAllById(int id) {		dao.delete("manage.attribute.deleteAllById", id);	}	@Override	public int selectCount(Attribute ee) {		// TODO Auto-generated method stub		return (Integer) dao.selectOne("manage.attribute.selectCount", ee);	}	public List<Attribute>  selectListToCache(Attribute e){		return dao.selectList("manage.attribute.selectListToCache", e);	}}