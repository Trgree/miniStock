package org.ace.stock.pojo;

public class StockCode {

	private String serachKey;
	private String type;
	private String code;
	private String fullcode;
	private String name;
	private String mininame;
	
	
	
	public StockCode() {
		super();
	}
	public StockCode(String serachKey, String type, String code, String fullcode, String name, String mininame) {
		super();
		this.serachKey = serachKey;
		this.type = type;
		this.code = code;
		this.fullcode = fullcode;
		this.name = name;
		this.mininame = mininame;
	}


	public String getSerachKey() {
		return serachKey;
	}
	public void setSerachKey(String serachKey) {
		this.serachKey = serachKey;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}


	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getFullcode() {
		return fullcode;
	}
	public void setFullcode(String fullcode) {
		this.fullcode = fullcode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMininame() {
		return mininame;
	}
	public void setMininame(String mininame) {
		this.mininame = mininame;
	}
	@Override
	public String toString() {
		return name + " " + fullcode;
	}
	
	
	
}

