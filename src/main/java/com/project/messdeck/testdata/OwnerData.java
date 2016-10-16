package com.project.messdeck.testdata;

import com.project.messdeck.entity.EmailID;
import com.project.messdeck.entity.Gender;
import com.project.messdeck.entity.Name;
import com.project.messdeck.entity.Owner;

public class OwnerData {

	public static Owner getOwnerData() {
		Owner owner = new Owner();
		owner.setEmailID(new EmailID("santosh@gamil.com"));
		owner.setGender(Gender.MALE);
		owner.setMobileNo("7276248187");
		owner.setName(new Name("Santosh", "Pawar"));
		owner.setOwnerAddress(AddressData.getAddressData());
		return owner;

	}

}
