package com.nuc.library.book.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 描述:导出数据库
 *
 * @author 闫文强
 * @create 2018-01-17 15:12
 */
public class OutputExcelAction extends ActionSupport {
	@Override
	public String execute() throws Exception {
		Thread.currentThread().sleep(3000);
		return SUCCESS;
	}
}