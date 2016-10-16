package com.project.messdeck.service;

import java.util.List;

import com.project.messdeck.entity.Owner;
import com.project.messdeck.entity.Vendor;

public interface OwnerService extends CRUDService<Owner> {
	public List<Vendor> getAllVendors(Long id);

	public Owner readDetails(Long id);
}
