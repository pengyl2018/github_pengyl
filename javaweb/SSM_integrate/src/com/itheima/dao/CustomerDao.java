package com.itheima.dao;

import com.itheima.po.Customer;

public interface CustomerDao {
	/**
	 * ����id��ѯ�ͻ���Ϣ
	 */
	public Customer findCustomerById(Integer id);
}
