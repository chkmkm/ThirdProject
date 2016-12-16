package com.gl.market.model;

import java.sql.Date;

public class UserCopVo {
	
	private String cpid;
	private String cpname;
	private String cpdis;
	private String usid;
	private Date cpdata;
	
	public UserCopVo() {
		// TODO Auto-generated constructor stub
	}

	public UserCopVo(String cpid, String cpname, String cpdis, String usid,
			Date cpdata) {
		super();
		this.cpid = cpid;
		this.cpname = cpname;
		this.cpdis = cpdis;
		this.usid = usid;
		this.cpdata = cpdata;
	}

	public String getCpid() {
		return cpid;
	}

	public void setCpid(String cpid) {
		this.cpid = cpid;
	}

	public String getCpname() {
		return cpname;
	}

	public void setCpname(String cpname) {
		this.cpname = cpname;
	}

	public String getCpdis() {
		return cpdis;
	}

	public void setCpdis(String cpdis) {
		this.cpdis = cpdis;
	}

	public String getUsid() {
		return usid;
	}

	public void setUsid(String usid) {
		this.usid = usid;
	}

	public Date getCpdata() {
		return cpdata;
	}

	public void setCpdata(Date cpdata) {
		this.cpdata = cpdata;
	}

	@Override
	public String toString() {
		return "UserCopVo [cpid=" + cpid + ", cpname=" + cpname + ", cpdis="
				+ cpdis + ", usid=" + usid + ", cpdata=" + cpdata + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpdis == null) ? 0 : cpdis.hashCode());
		result = prime * result + ((cpid == null) ? 0 : cpid.hashCode());
		result = prime * result + ((cpname == null) ? 0 : cpname.hashCode());
		result = prime * result + ((usid == null) ? 0 : usid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserCopVo other = (UserCopVo) obj;
		if (cpdis == null) {
			if (other.cpdis != null)
				return false;
		} else if (!cpdis.equals(other.cpdis))
			return false;
		if (cpid == null) {
			if (other.cpid != null)
				return false;
		} else if (!cpid.equals(other.cpid))
			return false;
		if (cpname == null) {
			if (other.cpname != null)
				return false;
		} else if (!cpname.equals(other.cpname))
			return false;
		if (usid == null) {
			if (other.usid != null)
				return false;
		} else if (!usid.equals(other.usid))
			return false;
		return true;
	}
	
	
	
}
