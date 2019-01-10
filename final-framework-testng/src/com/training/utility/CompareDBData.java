package com.training.utility;

import java.util.List;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;

public class CompareDBData {
	
	private ELearningDAO edao = new ELearningDAO();
	//edao = new ELearningDAO();
	
	public boolean dbMatch(String name, String slug, String pFeature, String desc) {
	List<LoginBean> listOfElements = edao.getLogins();
	String fNamedb="";
	  String slugdb="";
	  String parentFeaturedb="";
	  String descriptiondb="";
	  for(LoginBean element : listOfElements) {
		  fNamedb = element.getFeatureName().trim();
		  slugdb = element.getSlug().trim();
		  parentFeaturedb = element.getParentFeature().trim();
		  descriptiondb = element.getDescription().trim();
		}
	  System.out.println(fNamedb + " " + name);
	  System.out.println(slugdb + " " + slug);
	  System.out.println(parentFeaturedb + " " + pFeature);
	  System.out.println(descriptiondb + " " + desc);
	  
	  boolean flag = false;
	  if(fNamedb.equals(name) && slugdb.equals(slug) && parentFeaturedb.equals(pFeature) && descriptiondb.equals(desc)) {
		  flag=true;
	  }
	  return flag;

}
}
