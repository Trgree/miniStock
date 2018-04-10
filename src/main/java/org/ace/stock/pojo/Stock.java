package org.ace.stock.pojo;

import org.ace.stock.utils.CommonUtil;

public class Stock {
	private String name;// 1名字
	private String code;// 2代码
	private float currentPrice;//3 当前价格  
	private float yesterdayClose;// 4 昨收  
	private float todayOpen;// 5 今开  
	private int turnover;// 6 成交量（手）
	private int outer;// 7: 外盘  
	private int inner;//8: 内盘  
	private float buyOne;// 9: 买一 
	private int buyOneAmount;//10: 买一量（手）  
	private float buyTwo;//
	private int buyTwoAmount;//
	private float buyThree;//
	private int buyThreeAmount;//
	private float buyFour;//
	private int buyFourAmount;//
	private float buyFive;//
	private int buyFiveAmount;//
	private float sellOne;//19: 卖一  
	private int sellOneAmount;//20: 卖一量  
	private float sellTwo;//
	private int sellTwoAmount;//
	private float sellThree;//
	private int sellThreeAmount;//
	private float sellTour;//
	private int sellTourAmount;//
	private float sellFive;//
	private int sellFiveAmount;//
 
	private String lately;//29 最近逐笔成交
	private String time;//30 时间
	private float upAndDown;//31 涨跌 
	private float upAndDownPertent;//32 涨跌%  
	private float highest;//33 最高  
	private float lowest;//34 最低
	private String price_turnover;// 35 价格/成交量（手）/成交额
	private int turnover2;// 36  成交量（手）
	private int turnoverW;// 36  成交量（万）
	private float turnoverRate;// 38: 换手率
	private float tradingRate;// 39: 市盈率 

	private float highest2;//41 最高
	private float lowest2;//41 最低  
	private float swing;//43: 振幅  
	private float circulates; // 44 流通市值
	private float total;//	45: 总市值  
	private float pbRatio;//	46: 市净率  
	private float riseUp;//	47: 涨停价  
	private float dropUp;//	48: 跌停价
	
	private float myPrice;// 成交价
	private int count;// 成交量
		
	public Stock(String msg){
		String[] arr = msg.split("~");
		this.name = arr[1];
		this.code = arr[2];
		this.currentPrice = CommonUtil.str2float(arr[3], 0);
		this.yesterdayClose = CommonUtil.str2float(arr[4], 0);
		this.todayOpen = CommonUtil.str2float(arr[5], 0);
		this.turnover =CommonUtil.str2int(arr[6], 0);
		this.outer =CommonUtil.str2int(arr[7], 0);
		this.inner =CommonUtil.str2int(arr[8], 0);
		this.buyOne =CommonUtil.str2float(arr[9], 0);
		this.buyOneAmount =CommonUtil.str2int(arr[10], 0);
		this.buyTwo =CommonUtil.str2float(arr[11], 0);
		this.buyTwoAmount =CommonUtil.str2int(arr[12], 0);
		this.buyThree  = CommonUtil.str2float(arr[13], 0);
		this.buyThreeAmount =CommonUtil.str2int(arr[14], 0);
		this.buyFour =CommonUtil.str2float(arr[15], 0);
		this.buyFourAmount =CommonUtil.str2int(arr[16], 0);
		this.buyFive =CommonUtil.str2float(arr[17], 0);
		this.buyFiveAmount =CommonUtil.str2int(arr[18], 0);
		this.sellOne =CommonUtil.str2float(arr[19], 0);
		this.sellOneAmount =CommonUtil.str2int(arr[20], 0);
		this.sellTwo =CommonUtil.str2float(arr[21], 0);
		this.sellTwoAmount =CommonUtil.str2int(arr[22], 0);
		this.sellThree =CommonUtil.str2float(arr[23], 0);
		this.sellThreeAmount =CommonUtil.str2int(arr[24], 0);
		this.sellTour =CommonUtil.str2float(arr[25], 0);
		this.sellTourAmount =CommonUtil.str2int(arr[26], 0);
		this.sellFive =CommonUtil.str2float(arr[17], 0);
		this.sellFiveAmount =CommonUtil.str2int(arr[28], 0);
		this.lately =arr[29];
		this.time =arr[30];
		this.upAndDown =CommonUtil.str2float(arr[31], 0);
		this.upAndDownPertent =CommonUtil.str2float(arr[32], 0);
		this.highest =CommonUtil.str2int(arr[33], 0);
		this.lowest =CommonUtil.str2int(arr[34], 0);
		this.price_turnover =arr[35];
		this.turnover2 =CommonUtil.str2int(arr[36], 0);
		this.turnoverW =CommonUtil.str2int(arr[37], 0);
		this.turnoverRate =CommonUtil.str2float(arr[38], 0);
		this.tradingRate =CommonUtil.str2float(arr[39], 0);
		
		this.highest2 = CommonUtil.str2float(arr[41], 0);
		this.lowest2 = CommonUtil.str2float(arr[42], 0);
		this.swing = CommonUtil.str2float(arr[43], 0);
		this.circulates = CommonUtil.str2float(arr[44], 0);
		this.total = CommonUtil.str2int(arr[45], 0);
		this.pbRatio =CommonUtil.str2float(arr[46], 0);
		this.riseUp = CommonUtil.str2float(arr[47], 0);
		this.dropUp = CommonUtil.str2float(arr[48], 0);
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.name).append("\n")
		.append(this.code).append("\n")
		.append("当前价格=").append(this.currentPrice ).append("\n") 
		.append("昨收=").append(this.yesterdayClose ).append("\n") 
		.append("今开=").append(this.todayOpen ).append("\n") 
		.append("成交量（手）=").append(this.turnover ).append("\n")
		.append("外盘=").append(this.outer ).append("\n")
		.append("内盘=").append(this.inner ).append("\n")
		.append("买1=").append(this.buyOne ).append("\n")
		.append("买1量=").append(this.buyOneAmount ).append("\n")
		.append("买2=").append(this.buyTwo ).append("\n")
		.append("买2量=").append(this.buyTwoAmount ).append("\n")
		.append("买3=").append(this.buyThree ).append("\n")
		.append("买3量=").append(this.buyThreeAmount ).append("\n")
		.append("买4=").append(this.buyFour ).append("\n")
		.append("买4量=").append(this.buyFourAmount ).append("\n")
		.append("买5=").append(this.buyFive ).append("\n")
		.append("买5量=").append(this.buyFiveAmount ).append("\n")
		.append("卖1=").append(this.sellOne ).append("\n")
		.append("卖1量=").append(this.sellOneAmount ).append("\n")
		.append("卖2=").append(this.sellTwo ).append("\n")
		.append("卖2量=").append(this.sellTwoAmount ).append("\n")
		.append("卖3=").append(this.sellThree ).append("\n")
		.append("卖3量=").append(this.sellThreeAmount ).append("\n")
		.append("卖4=").append(this.sellTour ).append("\n")
		.append("卖4量=").append(this.sellTourAmount ).append("\n")
		.append("卖5=").append(this.sellFive ).append("\n")
		.append("卖5量=").append(this.sellFiveAmount ).append("\n")
		.append("最近逐笔成交  =").append(this.lately ).append("\n")
		.append("时间=").append(this.time ).append("\n")
		.append("涨跌=").append(this.upAndDown ).append("\n")
		.append("涨跌%=").append(this.upAndDownPertent ).append("\n")
		.append("最高=").append(this.highest ).append("\n")
		.append("最低=").append(this.lowest ).append("\n")
		.append("价格/成交量（手）/成交额=").append(this.price_turnover ).append("\n")
		.append("成交量（手）=").append(this.turnover2 ).append("\n")
		.append("成交量（万）=").append(this.turnoverW ).append("\n")
		.append("换手率=").append(this.turnoverRate ).append("\n")
		.append("市盈率=").append(this.tradingRate ).append("\n")

		.append("最高=").append(this.highest2 ).append("\n") 
		.append("最低=").append(this.lowest2 ).append("\n") 
		.append("振幅=").append(this.swing ).append("\n") 
		.append("流通市值=").append(this.circulates ).append("\n") 
		.append("总市值=").append(this.total ).append("\n") 
		.append("市净率=").append(this.pbRatio ).append("\n") 
		.append("涨停价=").append(this.riseUp ).append("\n") 
		.append("跌停价=").append(this.dropUp ).append("\n") ;
		
		return sb.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public float getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(float currentPrice) {
		this.currentPrice = currentPrice;
	}

	public float getYesterdayClose() {
		return yesterdayClose;
	}

	public void setYesterdayClose(float yesterdayClose) {
		this.yesterdayClose = yesterdayClose;
	}

	public float getTodayOpen() {
		return todayOpen;
	}

	public void setTodayOpen(float todayOpen) {
		this.todayOpen = todayOpen;
	}

	public int getTurnover() {
		return turnover;
	}

	public void setTurnover(int turnover) {
		this.turnover = turnover;
	}

	public int getOuter() {
		return outer;
	}

	public void setOuter(int outer) {
		this.outer = outer;
	}

	public int getInner() {
		return inner;
	}

	public void setInner(int inner) {
		this.inner = inner;
	}

	public float getBuyOne() {
		return buyOne;
	}

	public void setBuyOne(float buyOne) {
		this.buyOne = buyOne;
	}

	public int getBuyOneAmount() {
		return buyOneAmount;
	}

	public void setBuyOneAmount(int buyOneAmount) {
		this.buyOneAmount = buyOneAmount;
	}

	public float getBuyTwo() {
		return buyTwo;
	}

	public void setBuyTwo(float buyTwo) {
		this.buyTwo = buyTwo;
	}

	public int getBuyTwoAmount() {
		return buyTwoAmount;
	}

	public void setBuyTwoAmount(int buyTwoAmount) {
		this.buyTwoAmount = buyTwoAmount;
	}

	public float getBuyThree() {
		return buyThree;
	}

	public void setBuyThree(float buyThree) {
		this.buyThree = buyThree;
	}

	public int getBuyThreeAmount() {
		return buyThreeAmount;
	}

	public void setBuyThreeAmount(int buyThreeAmount) {
		this.buyThreeAmount = buyThreeAmount;
	}

	public float getBuyFour() {
		return buyFour;
	}

	public void setBuyFour(float buyFour) {
		this.buyFour = buyFour;
	}

	public int getBuyFourAmount() {
		return buyFourAmount;
	}

	public void setBuyFourAmount(int buyFourAmount) {
		this.buyFourAmount = buyFourAmount;
	}

	public float getBuyFive() {
		return buyFive;
	}

	public void setBuyFive(float buyFive) {
		this.buyFive = buyFive;
	}

	public int getBuyFiveAmount() {
		return buyFiveAmount;
	}

	public void setBuyFiveAmount(int buyFiveAmount) {
		this.buyFiveAmount = buyFiveAmount;
	}

	public float getSellOne() {
		return sellOne;
	}

	public void setSellOne(float sellOne) {
		this.sellOne = sellOne;
	}

	public int getSellOneAmount() {
		return sellOneAmount;
	}

	public void setSellOneAmount(int sellOneAmount) {
		this.sellOneAmount = sellOneAmount;
	}

	public float getSellTwo() {
		return sellTwo;
	}

	public void setSellTwo(float sellTwo) {
		this.sellTwo = sellTwo;
	}

	public int getSellTwoAmount() {
		return sellTwoAmount;
	}

	public void setSellTwoAmount(int sellTwoAmount) {
		this.sellTwoAmount = sellTwoAmount;
	}

	public float getSellThree() {
		return sellThree;
	}

	public void setSellThree(float sellThree) {
		this.sellThree = sellThree;
	}

	public int getSellThreeAmount() {
		return sellThreeAmount;
	}

	public void setSellThreeAmount(int sellThreeAmount) {
		this.sellThreeAmount = sellThreeAmount;
	}

	public float getSellTour() {
		return sellTour;
	}

	public void setSellTour(float sellTour) {
		this.sellTour = sellTour;
	}

	public int getSellTourAmount() {
		return sellTourAmount;
	}

	public void setSellTourAmount(int sellTourAmount) {
		this.sellTourAmount = sellTourAmount;
	}

	public float getSellFive() {
		return sellFive;
	}

	public void setSellFive(float sellFive) {
		this.sellFive = sellFive;
	}

	public int getSellFiveAmount() {
		return sellFiveAmount;
	}

	public void setSellFiveAmount(int sellFiveAmount) {
		this.sellFiveAmount = sellFiveAmount;
	}

	public String getLately() {
		return lately;
	}

	public void setLately(String lately) {
		this.lately = lately;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public float getUpAndDown() {
		return upAndDown;
	}

	public void setUpAndDown(float upAndDown) {
		this.upAndDown = upAndDown;
	}

	public float getUpAndDownPertent() {
		return upAndDownPertent;
	}

	public void setUpAndDownPertent(float upAndDownPertent) {
		this.upAndDownPertent = upAndDownPertent;
	}

	public float getHighest() {
		return highest;
	}

	public void setHighest(float highest) {
		this.highest = highest;
	}

	public float getLowest() {
		return lowest;
	}

	public void setLowest(float lowest) {
		this.lowest = lowest;
	}

	public String getPrice_turnover() {
		return price_turnover;
	}

	public void setPrice_turnover(String price_turnover) {
		this.price_turnover = price_turnover;
	}

	public int getTurnover2() {
		return turnover2;
	}

	public void setTurnover2(int turnover2) {
		this.turnover2 = turnover2;
	}

	public int getTurnoverW() {
		return turnoverW;
	}

	public void setTurnoverW(int turnoverW) {
		this.turnoverW = turnoverW;
	}

	public float getTurnoverRate() {
		return turnoverRate;
	}

	public void setTurnoverRate(float turnoverRate) {
		this.turnoverRate = turnoverRate;
	}

	public float getTradingRate() {
		return tradingRate;
	}

	public void setTradingRate(float tradingRate) {
		this.tradingRate = tradingRate;
	}

	public float getHighest2() {
		return highest2;
	}

	public void setHighest2(float highest2) {
		this.highest2 = highest2;
	}

	public float getLowest2() {
		return lowest2;
	}

	public void setLowest2(float lowest2) {
		this.lowest2 = lowest2;
	}

	public float getSwing() {
		return swing;
	}

	public void setSwing(float swing) {
		this.swing = swing;
	}

	public float getCirculates() {
		return circulates;
	}

	public void setCirculates(float circulates) {
		this.circulates = circulates;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public float getPbRatio() {
		return pbRatio;
	}

	public void setPbRatio(float pbRatio) {
		this.pbRatio = pbRatio;
	}

	public float getRiseUp() {
		return riseUp;
	}

	public void setRiseUp(float riseUp) {
		this.riseUp = riseUp;
	}

	public float getDropUp() {
		return dropUp;
	}

	public void setDropUp(float dropUp) {
		this.dropUp = dropUp;
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
	
	
	
	
}
