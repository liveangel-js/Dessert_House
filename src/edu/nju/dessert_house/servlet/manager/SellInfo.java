package edu.nju.dessert_house.servlet.manager;

import java.awt.Font;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.chart.urls.StandardPieURLGenerator;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import com.sun.org.apache.xpath.internal.operations.Or;

import edu.nju.dessert_house.dao.impl.HouseDaoImpl;
import edu.nju.dessert_house.dao.impl.OrderDaoIpml;
import edu.nju.dessert_house.dao.impl.RecordDaoImpl;
import edu.nju.dessert_house.model.House;

/**
 * Servlet implementation class SellInfo
 */
@WebServlet("/manager/sell_info")
public class SellInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SellInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		process(request, response);
	}

	private void process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String hid = request.getParameter("hid");
		if (hid == null) {
			hid = "1";
		}
		ArrayList<House> houses = HouseDaoImpl.getInnstance().getHouses();
		request.setAttribute("houses", houses);
		request.setAttribute("records", RecordDaoImpl.getInstance()
				.getRecordsByHouse(Integer.parseInt(hid)));
		request.setAttribute("total",
				OrderDaoIpml.getInstance().getTotalPrice(Integer.parseInt(hid)));
		request.setAttribute("pie", getPieURL(request, response));
		request.setAttribute("zhu", getZhuURL(request, response));
		request.setAttribute("type", "销售信息");
		request.getRequestDispatcher("/manager/sell_info.jsp").forward(request,
				response);
	}

	public String getPieURL(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		DefaultPieDataset data = new DefaultPieDataset();
		ArrayList<House> houses = OrderDaoIpml.getInstance().getHouseTotal();
		// System.out.println(houses.size());
		for (int i = 0; i < houses.size(); i++) {
			House house = houses.get(i);
			data.setValue(house.getName(), house.getTotal());
			// System.out.println(houses.size());
		}

		PiePlot3D plot = new PiePlot3D(data);// 3D饼图
		plot.setURLGenerator(new StandardPieURLGenerator("barview.jsp"));// 设定链接

		JFreeChart chart = new JFreeChart("", JFreeChart.DEFAULT_TITLE_FONT,
				plot, true);
		chart.setBackgroundPaint(java.awt.Color.white);// 可选，设置图片背景色
		chart.setTitle("店面营业金额情况饼图");// 可选，设置图片标题
		plot = (PiePlot3D) chart.getPlot();
		plot.setToolTipGenerator(new StandardPieToolTipGenerator());

		// plot.setLabelGenerator(new StandardPieSectionLabelGenerator());
		StandardEntityCollection sec = new StandardEntityCollection();
		ChartRenderingInfo info = new ChartRenderingInfo(sec);
		DecimalFormat df = new DecimalFormat("0.00%");// 获得一个DecimalFormat对象，主要是设置小数问题
		NumberFormat nf = NumberFormat.getNumberInstance();// 获得一个NumberFormat对象
		StandardPieSectionLabelGenerator sp1 = new StandardPieSectionLabelGenerator(
				"{0}  {2}", nf, df);// 获得StandardPieSectionLabelGenerator对象
		plot.setLabelGenerator(sp1);// 设置饼图显示百分比

		PrintWriter w;
		try {
			w = new PrintWriter(response.getWriter());
			String filename = ServletUtilities.saveChartAsPNG(chart, 500, 300,
					info, request.getSession(true));
			ChartUtilities.writeImageMap(w, "map0", info, false);
			String graphURL = request.getContextPath()
					+ "/servlet/DisplayChart?filename=" + filename;
			return graphURL;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 输出MAP信息
			// 500是图片长度，300是图片高度
		return null;
	}

	public String getZhuURL(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();  

		ArrayList<House> houses = OrderDaoIpml.getInstance().getHouseTotal();
		// System.out.println(houses.size());
		for (int i = 0; i < houses.size(); i++) {
			House house = houses.get(i);
			dataset.setValue(house.getTotal(),house.getName(),house.getName());
			// System.out.println(houses.size());
		}
        
        
		
		
		JFreeChart chart = ChartFactory.createBarChart3D("店面营业金额情况柱状图", // 图表标题
				"金额", // 目录轴的显示标签
				"店面", // 数值轴的显示标签
				dataset, // 数据集
				PlotOrientation.VERTICAL, // 图表方向：水平、垂直
				true, // 是否显示图例(对于简单的柱状图必须是false)
				false, // 是否生成工具
				false // 是否生成URL链接
				);

		// 从这里开始
		CategoryPlot plot = chart.getCategoryPlot();// 获取图表区域对象
		CategoryAxis domainAxis = plot.getDomainAxis(); // 水平底部列表
		domainAxis.setLabelFont(new Font("黑体", Font.BOLD, 14)); // 水平底部标题
		domainAxis.setTickLabelFont(new Font("宋体", Font.BOLD, 12)); // 垂直标题
		ValueAxis rangeAxis = plot.getRangeAxis();// 获取柱状
		rangeAxis.setLabelFont(new Font("黑体", Font.BOLD, 15));
		chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
		chart.getTitle().setFont(new Font("宋体", Font.BOLD, 20));// 设置标题字体
		
		StandardEntityCollection sec = new StandardEntityCollection();
		ChartRenderingInfo info = new ChartRenderingInfo(sec);
		
		
		PrintWriter w;
		try {
			w = new PrintWriter(response.getWriter());
			String filename = ServletUtilities.saveChartAsPNG(chart, 550, 300,
					info, request.getSession(true));
			ChartUtilities.writeImageMap(w, "map1", info, false);
			String graphURL = request.getContextPath()
					+ "/servlet/DisplayChart?filename=" + filename;
			return graphURL;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 输出MAP信息
			// 500是图片长度，300是图片高度
		return null;
	}

}
