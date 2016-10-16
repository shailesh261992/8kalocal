package com.project.messdeck.testdata;

import com.project.messdeck.entity.Unit;
import com.project.messdeck.entity.VendorItem;

public class VendorItemData {
	public static VendorItem getVendorItem_Batata() {
		VendorItem vendorItem = new VendorItem();
		vendorItem.setItem(ItemData.getItemBatata());
		vendorItem.setUnit(Unit.BOWL);
		vendorItem.setCost(20);
		return vendorItem;
	}

}
