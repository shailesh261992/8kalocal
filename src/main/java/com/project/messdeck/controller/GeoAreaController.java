package com.project.messdeck.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.messdeck.entity.Area;
import com.project.messdeck.entity.City;
import com.project.messdeck.entity.Country;
import com.project.messdeck.entity.District;
import com.project.messdeck.entity.State;
import com.project.messdeck.propertyeditors.CityEnumConverter;
import com.project.messdeck.propertyeditors.CountryEnumConverter;
import com.project.messdeck.propertyeditors.DistrictEnumConverter;
import com.project.messdeck.propertyeditors.StateEnumConverter;

@RestController
public class GeoAreaController {

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		dataBinder.registerCustomEditor(Country.class, new CountryEnumConverter());
		dataBinder.registerCustomEditor(State.class, new StateEnumConverter());
		dataBinder.registerCustomEditor(District.class, new DistrictEnumConverter());
		dataBinder.registerCustomEditor(City.class, new CityEnumConverter());
	}

	@RequestMapping(value = "/countries", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Country[] getAllCountries() {
		return Country.values();
	}

	@RequestMapping(value = "/{country}/states", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<State> getStatesWithinCountry(@PathVariable Country country) {
		State[] values = State.values();
		ArrayList<State> states = new ArrayList<>();
		for (State s : values) {
			if (s.getCountry().equals(country)) {
				states.add(s);
			}
		}
		return states;

	}

	@RequestMapping(value = "/{country}/{state}/districts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<District> getDistrictsWithinState(@PathVariable Country country, @PathVariable State state) {
		District[] values = District.values();

		ArrayList<District> districts = new ArrayList<>();
		for (District d : values) {
			if (d.getState().equals(state)) {
				districts.add(d);
			}
		}
		return districts;

	}

	@RequestMapping(value = "/{country}/{state}/{district}/cities", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<City> getCitiesWithinDistricts(@PathVariable Country country, @PathVariable State state,
			@PathVariable District district) {
		City[] values = City.values();

		ArrayList<City> cities = new ArrayList<>();
		for (City c : values) {
			if (c.getDistrict().equals(district)) {
				cities.add(c);
			}
		}
		return cities;

	}

	@RequestMapping(value = "/{country}/{state}/{district}/{city}/areas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Area> getAreasWithinCity(@PathVariable Country country, @PathVariable State state,
			@PathVariable District district, @PathVariable City city) {
		Area[] values = Area.values();

		ArrayList<Area> areas = new ArrayList<>();
		for (Area a : values) {
			if (a.getCity().equals(city)) {
				areas.add(a);
			}
		}
		return areas;

	}

	@RequestMapping(value = "/pinocode", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getAreaPincode(@RequestParam String areaName) {
		areaName.trim();
		areaName = areaName.replaceAll("\\s+", "_");
		String pincode = Area.valueOf(areaName).getPincode().name();
		return pincode.substring(1, pincode.length());
	}

}
