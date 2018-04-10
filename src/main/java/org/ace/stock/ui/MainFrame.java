package org.ace.stock.ui;

import org.ace.stock.pojo.StockCode;
import org.ace.stock.pojo.StockValue;
import org.ace.stock.service.QueryService;
import org.ace.stock.utils.CommonUtil;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainFrame  extends JFrame {

	private static final long serialVersionUID = 1L;

	private static  int height = 200;
	private static  int width = 500;
	
	private JLabel codeLabel;
	private JTextField codeField;
	private JTable dataTable;
	private JScrollPane JSP;
	
	private JLabel totalLabel;
	private JLabel totalValue;
	
	private QueryService queryService = new QueryService();
	private List<StockValue> stockValues = new ArrayList<StockValue>();// 用户定义的要显示的股票列表
	
	public MainFrame() {
		super();
		initialize();
	}

	private void initialize() {
		stockValues = queryService.readCache();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(width,height);
//		setResizable(false);
		setLocation();
		setIcon();
		setTitle("Mini Stock");
		setHotKey();
		setContentPane(getJContentPane());
	}
	
	private void setHotKey() {
//		this.setAlwaysOnTop(true);
		KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
		//然后得到当前键盘事件的管理器
		manager.addKeyEventPostProcessor(new MainKeyListener(this));
//		this.addKeyListener(new MainKeyListener(this));
	}
	
	private void setIcon(){
		URL url = this.getClass().getClassLoader().getResource("stock.png");
		Image image= Toolkit.getDefaultToolkit().createImage(url);
		this.setIconImage(image);
	}
	
	/**
	 * 右下角窗口
	 */
	private void setLocation() {
		Dimension displaySize = Toolkit.getDefaultToolkit().getScreenSize();// 获得显示器大小对象
		Dimension frameSize = getSize();// 获得窗口大小对象
		if (frameSize.width > displaySize.width)
			frameSize.width = displaySize.width;// 窗口的宽度不能大于显示器的宽度
		if (frameSize.height > displaySize.height)
			frameSize.height = displaySize.height;// 窗口的高度不能大于显示器的高度
		setLocation(displaySize.width - frameSize.width,
				displaySize.height - frameSize.height - 50);
	}
	
	private Container getJContentPane() {
		JPanel jPanel = new JPanel(new BorderLayout());
		jPanel.add(getPanelNorth(), BorderLayout.NORTH);
		jPanel.add(getTable(), BorderLayout.CENTER);
		jPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
		return jPanel;
	}
	
	/*private Component getPanelCenter() {
		JPanel jPanel = new JPanel(new FlowLayout());
		jPanel.add();
		return jPanel;
	}*/

	private Component getPanelNorth() {
		JPanel jPanel = new JPanel(new FlowLayout());
		
		if (codeLabel == null) {
			codeLabel = new JLabel("添加:");
		}
		jPanel.add(codeLabel);
		jPanel.add(getCodeField());
		
		if (totalLabel == null) {
			totalLabel = new JLabel("总盈亏:");
		}
		if (totalValue == null) {
			totalValue = new JLabel();
		}
		jPanel.add(totalLabel);
		jPanel.add(totalValue);
		
		/*DelButton b = new DelButton();
		jPanel.add(b);*/
		
		return jPanel;
	}
	
	private Component getTable() {
		if(dataTable == null){
			dataTable = new JTable();
		} 
		if(JSP == null){
			JSP= new JScrollPane(dataTable);
		}
//		dataTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  
		dataTable.setBorder(new LineBorder(UIManager.getColor("Button.darkShadow")));
		upateData();
		return JSP;
	}
	
	private void updateColor(){
		updateColorColumn("盈亏");
		updateColorColumn("涨跌率");
	}
	
	private void updateColorColumn(String columnName){
		 TableColumn moneyColumn = dataTable.getColumn(columnName);
		 
		 DefaultTableCellRenderer fontColor = new DefaultTableCellRenderer(){

			private static final long serialVersionUID = 1L;
			
			@Override
			protected void setValue(Object value) {
				if(value == null) {
					setText("");  
					return;
				}
				String temp = value.toString().replaceAll("%", "");
				/*if(value instanceof String) {
					temp = CommonUtil.str2float(((String) value).replace((String) value, "%"), 0);
				} else if(value instanceof Float){
					temp = CommonUtil.obj2float(value, 0); //获取列中的值   
				}*/
				float a = CommonUtil.str2float(temp, 0); //获取盈亏列中的值   
                setForeground((a  > 0) ? Color.red : (a ==0 ? Color.black :new Color(3,129,3))); //如果盈亏大于0元，就将字体设置为红色
                setText(value.toString());  
			}
			 
		 };
		 moneyColumn.setCellRenderer(fontColor);   
	}
	
	private void addDeleteBtn(){
		 TableColumn handleColumn = dataTable.getColumn("操作");
		 handleColumn.setCellRenderer(new MyButtonRender());   
		 handleColumn.setCellEditor(new MyButtonEditor(this));
	}
	
	public void upateData(){
		dataTable.setModel(queryService.getTableModel(stockValues));
		updateColor();
		addDeleteBtn();
		totalValue.setText(queryService.getTotalGain()+"");
		totalValue.setForeground(queryService.getTotalGain() > 0 ? Color.red : Color.green);
		dataTable.getColumn("名称代码").setMinWidth(100);
	}
	
	/**
	 * 弹出修改框
	 */
	public void newEditFrame(int index) {
		EditFrame editFrame = new EditFrame(this, index);
		editFrame.setVisible(true);
	}
	
	/**
	 * 修改股票的成本价和数量
	 * @param index
	 * @param myPrice
	 * @param count
	 */
	public void editStockMyPrice(int index, float price, int count){
		if(index >= stockValues.size()) {
			return;
		}
		StockValue sv = stockValues.get(index);
		if(sv == null) {
			return;
		}
		sv.setMyPrice(price);
		sv.setCount(count);
		queryService.saveCache(stockValues);
		upateData();
	}
	
	public void removeStockcode(int index) {
		stockValues.remove(index);
		queryService.saveCache(stockValues);
		upateData();
	}

	public void addStockcode(StockValue stockValue) {
		if(stockValues.contains(stockValue)) {
			return;
		}
		stockValues.add(stockValue);
		queryService.saveCache(stockValues);
		upateData();
	}

	public List<StockValue> getStockcodes() {
		return stockValues;
	}

	private Component getCodeField() {
		if (codeField == null) {
			codeField = new JTextField(15);
		}
		setupAutoComplete(codeField, this, queryService, stockValues);
		return codeField;
	}
	
	
	public static void setupAutoComplete(final JTextField txtInput, final MainFrame mainFrame, final QueryService queryService, final List<StockValue> stockvalues) {
		final DefaultComboBoxModel<StockCode> model = new DefaultComboBoxModel<StockCode>();
		final JComboBox<StockCode> cbInput = new JComboBox<StockCode>(model) {
			private static final long serialVersionUID = 1L;

			public Dimension getPreferredSize() {
				return new Dimension(super.getPreferredSize().width, 0);
			}
			
		};
		setAdjusting(cbInput, false);
		cbInput.setSelectedItem(null);
		cbInput.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!isAdjusting(cbInput)) {
					if (cbInput.getSelectedItem() != null) {
						//txtInput.setText(cbInput.getSelectedItem().toString());
						StockCode stockCode = (StockCode)cbInput.getSelectedItem();
						StockValue stockValue = new StockValue(stockCode.getCode(), stockCode.getFullcode());
						txtInput.setText("");
						mainFrame.addStockcode(stockValue);
					}
				}
			}
		});
		
	       txtInput.addKeyListener(new KeyAdapter() {

	            @Override
	            public void keyPressed(KeyEvent e) {
	                setAdjusting(cbInput, true);
	                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
	                    if (cbInput.isPopupVisible()) {
	                        e.setKeyCode(KeyEvent.VK_ENTER);
	                    }
	                }
	                if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN) {
	                    e.setSource(cbInput);
	                    cbInput.dispatchEvent(e);
	                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//	                        txtInput.setText(cbInput.getSelectedItem().toString());
	                        cbInput.setPopupVisible(false);
	                        
	    					if (cbInput.getSelectedItem() != null) {
	    						//txtInput.setText(cbInput.getSelectedItem().toString());
	    						StockCode stockCode = (StockCode)cbInput.getSelectedItem();
	    						StockValue stockValue = new StockValue(stockCode.getCode(), stockCode.getFullcode());
	    						stockvalues.add(stockValue);
	    						mainFrame.upateData();
	    						txtInput.setText("");
	    					}
	                    }
	                }
	                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
	                    cbInput.setPopupVisible(false);
	                }
	                setAdjusting(cbInput, false);
	            }
	        });
	        txtInput.getDocument().addDocumentListener(new DocumentListener() {
	            public void insertUpdate(DocumentEvent e) {
	                updateList();
	            }

	            public void removeUpdate(DocumentEvent e) {
	                updateList();
	            }

	            public void changedUpdate(DocumentEvent e) {
	                updateList();
	            }

	            private void updateList() {
	                setAdjusting(cbInput, true);
	                model.removeAllElements();
	                String input = txtInput.getText();
	                if (!input.isEmpty()) {
	                	List<StockCode> items = queryService.queryCode(input);
	                	int i=0;
	                    for (StockCode stockCode : items) {
	                    	if(i++>5){
	                    		break;
	                    	}
	                        model.addElement(stockCode);
	                    }
	                }
	                cbInput.setPopupVisible(model.getSize() > 0);
	                setAdjusting(cbInput, false);
	            }
	        });
	        txtInput.setLayout(new BorderLayout());
	        txtInput.add(cbInput, BorderLayout.SOUTH);
	}

	private static void setAdjusting(JComboBox<StockCode> cbInput, boolean adjusting) {
		cbInput.putClientProperty("is_adjusting", adjusting);
	}
	
	private static void addStockValue(){
		
	}

	private static boolean isAdjusting(JComboBox<StockCode> cbInput) {
		if (cbInput.getClientProperty("is_adjusting") instanceof Boolean) {
			return (Boolean) cbInput.getClientProperty("is_adjusting");
		}
		return false;
	}
}
