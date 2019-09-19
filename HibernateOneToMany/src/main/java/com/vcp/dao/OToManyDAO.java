package com.vcp.dao;

public interface OToManyDAO {
  public void save();
  public void load();
  public void addNewNumberToExistingUser();
  public void deleteUserWithPhoneNumbers();
  public void deleteOnePhoneNumberOfAUser();
}
