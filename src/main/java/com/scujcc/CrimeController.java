package com.scujcc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crime")
public class CrimeController{
	
	@Autowired
	CrimeRepository repo;
	@Cacheable("Customers")
	@RequestMapping(method = RequestMethod.GET)
	public List<Crime> findAll(){
		List<Crime> result = repo.findAll();
		for(Crime cr : result){
			System.out.println("输出");
			System.out.println(cr);
		}
		
		return result;
	}
	
	@RequestMapping("/{id}")
	public Crime findOne(@PathVariable("id") String id){
		System.out.println("id等于:"+id);
		Crime result = repo.findOne(id);
		System.out.println(result);
		return result;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String save(@RequestBody Crime crime){
		System.out.println(crime);
		repo.save(crime);
		return "SUCCESS";
	}   
	
	@RequestMapping(value ="/{id}" ,method = RequestMethod.PUT)
	public String update(@PathVariable("id") String id,@RequestBody Crime crime){
		System.out.println("id等于："+id);
		Crime result = repo.findOne(id);
//		System.out.println("传入的crime："+crime);
//		System.out.println("更新前："+result);
//		System.out.println(crime.getTitle());
		result.setTitle(crime.getTitle());
//		result.setId(crime.getId());
		result.setSolved(crime.getSolved());
		result.setCreateDate(crime.getCreateDate());
		result.setDescription(crime.getDescription());
//		System.out.println("更新后："+result);
		repo.save(result);
		return "SUCCESS";
	}
	
	@RequestMapping(value ="/{id}" ,method = RequestMethod.DELETE)
	@CacheEvict("Customers")
	public String delete(@PathVariable("id") String id){
		repo.delete(id);
		return "SUCCESS";
	}
}