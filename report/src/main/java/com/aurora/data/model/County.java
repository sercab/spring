package com.aurora.data.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class County implements Serializable {

	private static final long serialVersionUID = 1L;

	public County() {
	}

	@Id
	private long feature_id;
	private String county_name;
	private String description;
	private String feat_class;
	private String fips_class;
	private String fips_county_cd;
	private String full_county_name;
	private String link_title;
	private String url;
	private String name;
	private String primary_latitude;
	private String primary_longitude;
	private String state_abbreviation;
	private String state_name;

	public long getFeature_id() {
		return feature_id;
	}

	public void setFeature_id(long id) {
		this.feature_id = id;
	}

	public String getCounty_name() {
		return county_name;
	}

	public void setCounty_name(String param) {
		this.county_name = param;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String param) {
		this.description = param;
	}

	public String getFeat_class() {
		return feat_class;
	}

	public void setFeat_class(String param) {
		this.feat_class = param;
	}

	public String getFips_class() {
		return fips_class;
	}

	public void setFips_class(String param) {
		this.fips_class = param;
	}

	public String getFips_county_cd() {
		return fips_county_cd;
	}

	public void setFips_county_cd(String param) {
		this.fips_county_cd = param;
	}

	public String getFull_county_name() {
		return full_county_name;
	}

	public void setFull_county_name(String param) {
		this.full_county_name = param;
	}

	public String getLink_title() {
		return link_title;
	}

	public void setLink_title(String param) {
		this.link_title = param;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String param) {
		this.url = param;
	}

	public String getName() {
		return name;
	}

	public void setName(String param) {
		this.name = param;
	}

	public String getPrimary_latitude() {
		return primary_latitude;
	}

	public void setPrimary_latitude(String param) {
		this.primary_latitude = param;
	}

	public String getPrimary_longitude() {
		return primary_longitude;
	}

	public void setPrimary_longitude(String param) {
		this.primary_longitude = param;
	}

	public String getState_abbreviation() {
		return state_abbreviation;
	}

	public void setState_abbreviation(String param) {
		this.state_abbreviation = param;
	}

	public String getState_name() {
		return state_name;
	}

	public void setState_name(String param) {
		this.state_name = param;
	}

}