package org.ace.stock.service;

import org.ace.stock.common.Constant;
import org.ace.stock.pojo.Stock;
import org.ace.stock.pojo.StockCode;
import org.ace.stock.pojo.StockValue;
import org.ace.stock.utils.CommonUtil;
import org.ace.stock.utils.FileUtil;
import org.ace.stock.utils.HttpUtil;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class QueryService {

	/**
	 * 总收益
	 */
	private float totalGain = 0; 
	
	/**
	 * 根据股票代码，查询股票信息
	 * 
	 * @param stockCode
	 * @return
	 */
	public List<Stock> queryStock(List<StockValue> stockCode) {
		List<Stock> result = new ArrayList<Stock>();
		if(stockCode == null || stockCode.isEmpty()) {
			return result;
		}
		String key = "";
		for (int i = 0; i < stockCode.size(); i++) {
			if (i == 0) {
				key = stockCode.get(i).getFullcode();
			} else {
				key = key + "," + stockCode.get(i).getFullcode();
			}
		}

		
		String url = "http://qt.gtimg.cn/q=" + key;
		System.out.println(url);
		String response = HttpUtil.httpGet(url);
		if(response == null) {
			return result;
		}
		for (String res : response.split(";")) {
			if (res.trim().equals("")) {
				continue;
			}
			Stock stock = new Stock(res);
			result.add(stock);
		}
		return result;
	}

	/**
	 * 根据输入，实时返回符合的股票代码
	 * 
	 * @param key
	 * @return
	 */
	public List<StockCode> queryCode(String key) {
		List<StockCode> result = new ArrayList<StockCode>();
		String url = "http://suggest3.sinajs.cn/suggest/?type=11,12,13,14,15&key=" + key;
		String response = HttpUtil.httpGet(url);
		if(response == null) {
			return result;
		}
		String codes = response.substring(response.indexOf("\"") + 1, response.lastIndexOf("\""));
		for (String str : codes.split(";")) {
			String[] arr = str.split(",");
			if(arr.length>=6) {
				StockCode code = new StockCode(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5]);
				result.add(code);
			}
		}
		return result;
	}
	
	public TableModel getTableModel(List<StockValue> StockValues) {
		Vector<String> title = new Vector<String>();
		title.add("操作");
		title.add("名称代码");
		title.add("现价");
		title.add("涨跌");
		title.add("涨跌率");
		title.add("成本");
		title.add("持有量");
		title.add("盈亏");
		title.add("盈亏%");
		
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		List<Stock> stocks = queryStock(StockValues);
		
		totalGain = 0;
		for(Stock s : stocks) {
			Vector<String> row = new Vector<String>();
			row.add("");
			row.add(s.getName() + " " + s.getCode());
			row.add(s.getCurrentPrice() + "");
			row.add(s.getUpAndDown() + "");
			row.add(s.getUpAndDownPertent() + "%");
			for(StockValue stockValue : StockValues){
				if(stockValue.getCount()>0 && stockValue.getCode().equals(s.getCode())){
					row.add(stockValue.getMyPrice() + "");
					row.add(stockValue.getCount()+"");
					float gain = CommonUtil.getEarning(s.getCurrentPrice(), stockValue.getMyPrice(), stockValue.getCount());
					row.add(gain+ "");
					row.add(CommonUtil.round2(gain * 100 /(stockValue.getMyPrice() * stockValue.getCount()))+ "%");
					totalGain+=gain;
				}
			}
			
			data.add(row);
		}
		DefaultTableModel model = new DefaultTableModel(data, title){

			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return column > 0 ? false : true;
			}
			
		};
		
		return model;
	}
	
	public List<StockValue> readCache(){
		List<String> stockcodes = new ArrayList<String>();
		FileUtil.readFile(Constant.CACHE_FILE, stockcodes);
		List<StockValue> result = new ArrayList<StockValue>(stockcodes.size());
		for(String line : stockcodes) {
			String[] arr = line.split(",");
			if(arr.length>=4) {
				result.add(new StockValue(arr[0],arr[1],arr[2],arr[3]));
			} else if (arr.length>=2){
				result.add(new StockValue(arr[0],arr[01]));
			}
		}
		System.out.println("缓存的股票信息size:" + result.size());
		return result;
	}
	
	public boolean saveCache(List<StockValue> stockValues){
		List<String> valueList  = new ArrayList<String>(stockValues.size());
		for(StockValue val : stockValues){
			StringBuffer sb = new StringBuffer();
			sb.append(val.getCode()).append(",").append(val.getFullcode());
			if(val.getCount()>0) {
				sb.append(",").append(val.getMyPrice()).append(",").append(val.getCount());
			}
			valueList.add(sb.toString());
		}
		FileUtil.writeFile(Constant.CACHE_FILE, valueList, false);
		return true;
	}

	/**
	 * 总盈利
	 * @param StockValues
	 * @return
	 */
	public float getTotalGain() {
		return totalGain;
	}

	public static void main(String[] args) {
		QueryService service = new QueryService();
		System.out.println(service.queryCode("sh6012"));
//		System.out.println(service.queryStock("sh601216"));
	}
}
