package com.training.bean;

public class LoginBean {
	private String fName;
	private String slug;
	private String pFeature;
	private String description;

	public LoginBean() {
	}

	public LoginBean(String featureName, String slugName, String pFeature, String description) {
		super();
		this.fName = featureName;
		this.slug = slugName;
		this.pFeature = pFeature;
		this.description = description;
		
	}

	public String getFeatureName() {
		return fName;
	}

	public void setFeatureName(String featureName) {
		this.fName = featureName;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slugName) {
		this.slug = slugName;
	}
	
	public String getParentFeature() {
		return pFeature;
	}

	public void setParentFeature(String pFeature) {
		this.pFeature = pFeature;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/*@Override
	public String toString() {
		return "LoginBean [featureName=" + fName + ", slug=" + slug + ", parentFeature=" + pFeature +", description=" + description + "]";
	}*/
	
	
	
	/*@Override
	public String toString() {
		return "LoginBean [featureName=" + fName + ", slug=" + slug + ", parentFeature=" + pFeature +", description=" + description + "]";
	}*/
		
	
	
	
	
	
	

}
