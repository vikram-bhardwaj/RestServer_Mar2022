package com.test.RestServerAPPS;

import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/details")

public class Details
{
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public JsonObject getDetails()
	{
		JsonObjectBuilder rootBuilder = Json.createObjectBuilder();
		JsonObjectBuilder empBuilder = Json.createObjectBuilder();
		JsonObjectBuilder compBuilder = Json.createObjectBuilder();
		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
		JsonArrayBuilder compArrayBuilder = Json.createArrayBuilder();
		
		List<EmpDetails> empDetail = new ArrayList<EmpDetails>();
		EmpDetails empDetails1 = new EmpDetails();
		empDetails1.setID("OURA12101070");
		empDetails1.setName("Vikram Bhardwaj");
		empDetails1.setAge("29");
		empDetails1.setGender("Male");
		empDetails1.setAddress("Somewhere on earth");
		empDetails1.setPhoneNumber("8305XXXXXX");
		
		EmpDetails empDetails2 = new EmpDetails();
		empDetails2.setID("OURA12101072");
		empDetails2.setName("Momina Mustehsan");
		empDetails2.setAge("26");
		empDetails2.setGender("Female");
		empDetails2.setAddress("in my dreams");
		empDetails2.setPhoneNumber("8305XXXXXX");
		
		empDetail.add(empDetails1);
		empDetail.add(empDetails2);
		
		
		List<CompanyDetails> companyDetail = new ArrayList<CompanyDetails>();
		CompanyDetails companyDetails = new CompanyDetails();
		companyDetails.setCompanyName("CitiCorp");
		companyDetails.setCompanyLocation("Pune");
		companyDetails.setCompanyType("Banking/IT");
		companyDetail.add(companyDetails);
		
		List<Object> myDetails = new ArrayList<Object>();
		//myDetails.add(empDetail);
		myDetails.add(companyDetail);
		
		for(EmpDetails empDetils : empDetail)
		{
			JsonObjectBuilder builder = Json.createObjectBuilder();
			JsonObject obj = builder.add("ID", empDetils.getID() != null ? empDetils.getID() : "")
					.add("name", empDetils.getName() != null ? empDetils.getName() : "")
					.add("age", empDetils.getAge() != null ? empDetils.getAge() : "")
					.add("gender", empDetils.getGender() != null ? empDetils.getGender() : "")
					.add("address", empDetils.getAddress() != null ? empDetils.getAddress() : "")
					.add("phonenumber", empDetils.getPhoneNumber() != null ? empDetils.getPhoneNumber() : "")
					.build();
			arrayBuilder.add(obj);
			
		}
		
		for(CompanyDetails compDetails : companyDetail)
		{
			JsonObjectBuilder builder = Json.createObjectBuilder();
			JsonObject obj = builder.add("companyName", compDetails.getCompanyName() != null ? compDetails.getCompanyName() : "")
					.add("companyLocation", compDetails.getCompanyLocation() != null ? compDetails.getCompanyLocation() : "")
					.add("companyType", compDetails.getCompanyType() != null ? compDetails.getCompanyType() : "")
					.build();
			compArrayBuilder.add(obj);
		}
		JsonObject builders = empBuilder.add("empDetails", arrayBuilder)
		.add("compDetails", compArrayBuilder).build();
		
		JsonObject root = rootBuilder.add("details", builders).build();
		return root;
	}
}
