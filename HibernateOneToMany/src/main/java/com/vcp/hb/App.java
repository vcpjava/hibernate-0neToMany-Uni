package com.vcp.hb;

import com.vcp.dao.OToManyDAO;
import com.vcp.dao.OToManyDaoFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	OToManyDAO dao;
    	 //get DAO
    	dao = OToManyDaoFactory.getInstance();
    	//dao.save();
    	//dao.load();
    	//dao.addNewNumberToExistingUser();
    	//dao.deleteUserWithPhoneNumbers();
    	dao.deleteOnePhoneNumberOfAUser();
    }
}
