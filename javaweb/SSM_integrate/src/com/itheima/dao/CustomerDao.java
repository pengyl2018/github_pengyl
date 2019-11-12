package com.itheima.dao;

import com.itheima.po.Customer;

public interface CustomerDao {
	/**
	 * 根据id查询客户信息
	 */
	public Customer findCustomerById(Integer id);
}
