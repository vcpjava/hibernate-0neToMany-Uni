package com.vcp.dao;

public class OToManyDaoFactory {
   
	public static OToManyDAO getInstance() {
		return new OToManyDaoImpl();
	}
}
