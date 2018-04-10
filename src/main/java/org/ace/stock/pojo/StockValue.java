package org.ace.stock.pojo;

import org.ace.stock.utils.CommonUtil;

public class StockValue {
	private String code;// 代码
	private String fullcode;// 代码
	private float myPrice;// 成交价
	private int count;// 成交量
	
	public StockValue() {
		super();
	}
	
	public StockValue(String code, String fullcode) {
		super();
		this.code = code;
		this.fullcode = fullcode;
	}

	public StockValue(String code, String fullcode, String myPrice, String count) {
		super();
		this.code = code;
		this.fullcode = fullcode;
		this.myPrice = CommonUtil.str2float(myPrice, 0);
		this.count = CommonUtil.str2int(count, 0);
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public float getMyPrice() {
		return myPrice;
	}
	public void setMyPrice(float myPrice) {
		this.myPrice = myPrice;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	
	public String getFullcode() {
		return fullcode;
	}

	public void setFullcode(String fullcode) {
		this.fullcode = fullcode;
	}

	@Override
	public String toString() {
		return "StockValue [code=" + code + ", fullcode=" + fullcode + ", myPrice=" + myPrice + ", count=" + count
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fullcode == null) ? 0 : fullcode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StockValue other = (StockValue) obj;
		if (fullcode == null) {
			if (other.fullcode != null)
				return false;
		} else if (!fullcode.equals(other.fullcode))
			return false;
		return true;
	}


}
