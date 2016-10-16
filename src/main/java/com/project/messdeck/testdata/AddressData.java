package com.project.messdeck.testdata;

import com.project.messdeck.entity.Address;
import com.project.messdeck.entity.Area;

public class AddressData {

	public static Address getAddressData() {
		Address address = new Address();
		address.setArea(Area.Omkar_Nagar);
		address.setAddressLine2("F no 101, Siddhi Apt");
		address.setLattitude(10.0);
		address.setLongitude(11.0);

		return address;

	}

}
