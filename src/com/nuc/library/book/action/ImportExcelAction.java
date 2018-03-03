package com.nuc.library.book.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 描述:导入数据库
 *
 * @author 闫文强
 * @create 2018-01-17 15:07
 */
public class ImportExcelAction extends ActionSupport{
	@Override
	public String execute() throws Exception {
		Thread.currentThread().sleep(3000);
		return SUCCESS;
	}
}