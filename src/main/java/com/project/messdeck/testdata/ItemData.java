package com.project.messdeck.testdata;

import com.project.messdeck.entity.Item;
import com.project.messdeck.entity.ItemCategory;

public class ItemData {

	public static Item getItemBatata() {
		Item item = new Item();
		item.setName("Batata");
		item.setDescription("Batata");
		item.setCategory(ItemCategory.SABJI);
		return item;

	}

}
