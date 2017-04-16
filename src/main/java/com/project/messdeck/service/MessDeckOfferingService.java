package com.project.messdeck.service;

import java.util.List;

import com.project.messdeck.entity.MessDeckOffering;
import com.project.messdeck.entity.MessDeckOfferingInstance;

public interface MessDeckOfferingService extends CRUDService<MessDeckOffering> {
	List<MessDeckOfferingInstance> getInstances(Long id);
}
