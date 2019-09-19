package com.vcp.domain;

public class PhoneNumbers {

	private long phoneNumber;
	private String nymberType;
	private String provider;

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getNymberType() {
		return nymberType;
	}

	public void setNymberType(String nymberType) {
		this.nymberType = nymberType;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	@Override
	public String toString() {
		return "PhoneNumbers [phoneNumber=" + phoneNumber + ", nymberType=" + nymberType + ", provider=" + provider
				+ "]";
	}
	
	

}
