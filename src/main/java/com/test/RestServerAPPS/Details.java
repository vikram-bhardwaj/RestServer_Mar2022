package com.test.RestServerAPPS;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/details")

public class Details
{
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Object> getDetails()
	{
		List<EmpDetails> empDetail = new ArrayList<EmpDetails>();
		EmpDetails empDetails1 = new EmpDetails();
		empDetails1.setID("OURA12101070");
		empDetails1.setName("Vikram Bhardwaj");
		empDetails1.setAge("29");
		empDetails1.setGender("Male");
		empDetails1.setAddress("Lakhisarai, Bihar");
		empDetails1.setPhoneNumber("8305153512");
		
		EmpDetails empDetails2 = new EmpDetails();
		empDetails2.setID("OURA12101070");
		empDetails2.setName("Panda");
		empDetails2.setAge("26");
		empDetails2.setGender("Female");
		empDetails2.setAddress("Karnataka");
		empDetails2.setPhoneNumber("NA");
		
		empDetail.add(empDetails1);
		empDetail.add(empDetails2);
		
		List<CompanyDetails> companyDetail = new ArrayList<CompanyDetails>();
		CompanyDetails companyDetails = new CompanyDetails();
		companyDetails.setCompanyName("CitiCorp");
		companyDetails.setCompanyLocation("Pune");
		companyDetails.setCompanyType("Banking/IT");
		companyDetail.add(companyDetails);
		
		List<Object> myDetails = new ArrayList<Object>();
		myDetails.add(empDetail);
		myDetails.add(companyDetail);
		
		return myDetails;
	}
}
