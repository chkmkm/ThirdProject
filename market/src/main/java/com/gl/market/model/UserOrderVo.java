package com.gl.market.model;

import java.sql.Date;

public class UserOrderVo {
	
	private String orderid;
	private String proid;
	private String userid;
	private int people;
	private Date payment;
	private int cancel;
	
	public UserOrderVo() {
		// TODO Auto-generated constructor stub
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getProid() {
		return proid;
	}

	public void setProid(String proid) {
		this.proid = proid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getPeople() {
		return people;
	}

	public void setPeople(int people) {
		this.people = people;
	}

	public Date getPayment() {
		return payment;
	}

	public void setPayment(Date payment) {
		this.payment = payment;
	}

	public int getCancel() {
		return cancel;
	}

	public void setCancel(int cancel) {
		this.cancel = cancel;
	}

	public UserOrderVo(String orderid, String proid, String userid, int people,
			Date payment, int cancel) {
		super();
		this.orderid = orderid;
		this.proid = proid;
		this.userid = userid;
		this.people = people;
		this.payment = payment;
		this.cancel = cancel;
	}

	@Override
	public String toString() {
		return "UserOrderVo [orderid=" + orderid + ", proid=" + proid
				+ ", userid=" + userid + ", people=" + people + ", payment="
				+ payment + ", cancel=" + cancel + "]";
	}
	
	
	
}
