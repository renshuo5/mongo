package com.rensframework.model;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class AjaxResult extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6306468832160470274L;
	
	private int status=200;
	
	private String message="操作成功";
	
	private Map<String,Object> data;
	
	public AjaxResult(){
	}
	
	public AjaxResult(int status,Map<String,Object> data){
		this.status=status;
		this.data=data;
	}
	public AjaxResult(Map<String,Object> data){
		this.data=data;
	}
	
	

}
