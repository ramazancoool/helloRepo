package com.example.couchdb.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({"id", "revision"})
public class Sofa {
	
	 	@JsonProperty("_id")
	    private String id;

	    @JsonProperty("_rev")
	    private String revision;

	    private String color;
	    
	    private Double amount;

	    public void setId(String id) {
	        this.id = id;
	    }

	    public String getId() {
	        return id;
	    }

	    public String getRevision() {
	        return revision;
	    }

	    public void setColor(String s) {
	        color = s;
	    }

	    public String getColor() {
	        return color;
	    }

		public Double getAmount() {
			return amount;
		}

		public void setAmount(Double amount) {
			this.amount = amount;
		}
}
