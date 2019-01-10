package com.training.rough.tests;

import java.util.List;

import org.testng.annotations.Test;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;

public class FetchDataFromDB {
	private ELearningDAO edao;
  @Test
  public void dbTest() {
	  
	  edao = new ELearningDAO();
	  List<LoginBean> listOfElements = edao.getLogins();
	  String fName="";
	  String slug="";
	  String parentFeature="";
	  String description="";
	  for(LoginBean element : listOfElements) {
		  fName = element.getFeatureName();
		  slug = element.getSlug();
		  parentFeature = element.getParentFeature();
		  description = element.getDescription();
		}
	  System.out.println(fName);
	  System.out.println(slug);
	  System.out.println(parentFeature);
	  System.out.println(description);
  }
}
