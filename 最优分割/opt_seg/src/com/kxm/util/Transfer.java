package com.kxm.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Transfer implements Serializable{

	// 图表名称
	private String chartTitle;

	// X轴名称
	private String xTitle;

	// Y轴名称
	private String yTitle;

	// 所以线的名称
	private String[] lineTitle;

	// 所画月份
	private int[][] mon;

	// 所画年
	private int[][] yea;

	// 所画日期
	private int[][] day;

	// 所画的值
	private List value;

	// 图的高
	private int width;

	// 图的宽
	private int height;

	// 单纯数字
	double[][] xx;

	double[][] yy;

	String[][][] result = null;  //分割结果集
	
	List presult = null;         //离差平方总和
	
	String[][] lineresult = null; // 对应样品各次分割点位图的结果集
	
	String[] cutend = null;
	
	public String[] getCutend() {
		return cutend;
	}

	public void setCutend(String[] cutend) {
		this.cutend = cutend;
	}

	public String[][][] getResult() {
		return result;
	}
	
	public void setResult(String[][][] result) {
		this.result = result;
	}
	
	public List getPresult() {
		return presult;
	}
	
	public void setPresult(List presult) {
		this.presult = presult;
	}
	
	public String[][] getLineresult() {
		return lineresult;
	}
	
	public void setLineresult(String[][] lineresult) {
		this.lineresult = lineresult;
	}
	
	public double[][] getXx() {
		double[][] xx1 = { { 1, 2, 3, 4, 5, 6 }, { 1, 2, 3, 4, 5, 6 },
				{ 1, 2, 3, 4, 5, 6 }, { 1, 2, 3, 4, 5, 6 },
				{ 1, 2, 3, 4, 5, 6 }, { 1, 2, 3, 4, 5, 6 },
				{ 1, 2, 3, 4, 5, 6 }, { 1, 2, 3, 4, 5, 6 },
				{ 1, 2, 3, 4, 5, 6 }, { 1, 2, 3, 4, 5, 6 },
				{ 1, 2, 3, 4, 5, 6 }, { 1, 2, 3, 4, 5, 6 } };
		xx = xx1;
		return this.xx;

	}

	public double[][] getYy() {
		double[][] yy1 = { { 1, 2, 3, 4, 5, 6 }, { 0, 5, 15, 25, 30, 0 },
				{ 0, 5, 15, 55, 5, 0 }, { 2, 5, 3, 4, 5, 6 },
				{ 1, 2, 3, 4, 5, 6 }, { 0, 5, 15, 25, 30, 0 },
				{ 0, 5, 15, 55, 5, 0 }, { 2, 5, 3, 4, 5, 6 },
				{ 1, 2, 3, 4, 5, 6 }, { 0, 5, 15, 25, 30, 0 },
				{ 0, 5, 15, 55, 5, 0 }, { 2, 5, 3, 4, 5, 6 } };
		yy = yy1;
		return this.yy;

	}

	// x轴刻度说明（非时序）
	private String[] xscale;

	public void setChartTitle(String c) {
		this.chartTitle = c;

	}

	public String getChartTitle() {
		return this.chartTitle;

	}

	public void setXTitle(String c) {
		this.xTitle = c;

	}

	public String getXTitle() {
		xTitle = "年份";
		return this.xTitle;

	}

	public void setYTitle(String c) {
		this.yTitle = c;

	}

	public String getYTitle() {
		yTitle = "产值";
		return this.yTitle;

	}

	public void setlineTitle(String[] c) {
		this.lineTitle = c;

	}

	public String[] getLineTitle() {
		return this.lineTitle;
	}

	public void setMon(int[][] c) {
		this.mon = c;

	}

	public int[][] getMon() {
		int[][] mon1 = {

		{ 2, 3, 4, 5, 6, 3, 4, 5, 6, 3, 4, 5, 6, 3, 4, 5, 6, 3, 4 },
				{ 2, 3, 4, 5, 6, 3, 4, 5, 6, 3, 4, 5, 6, 3, 4, 5, 6, 3, 4 },
				{ 2, 3, 4, 5, 6, 3, 4, 5, 6, 3, 4, 5, 6, 3, 4, 5, 6, 3, 4 },
				{ 2, 3, 4, 5, 6, 3, 4, 5, 6, 3, 4, 5, 6, 3, 4, 5, 6, 3, 4 },
				{ 2, 3, 4, 5, 6, 3, 4, 5, 6, 3, 4, 5, 6, 3, 4, 5, 6, 3, 4 },
				{ 2, 3, 4, 5, 6, 3, 4, 5, 6, 3, 4, 5, 6, 3, 4, 5, 6, 3, 4 },
				{ 2, 3, 4, 5, 6, 3, 4, 5, 6, 3, 4, 5, 6, 3, 4, 5, 6, 3, 4 },
				{ 2, 3, 4, 5, 6, 3, 4, 5, 6, 3, 4, 5, 6, 3, 4, 5, 6, 3, 4 },
				{ 2, 3, 4, 5, 6, 3, 4, 5, 6, 3, 4, 5, 6, 3, 4, 5, 6, 3, 4 },
				{ 2, 3, 4, 5, 6, 3, 4, 5, 6, 3, 4, 5, 6, 3, 4, 5, 6, 3, 4 },
				{ 2, 3, 4, 5, 6, 3, 4, 5, 6, 3, 4, 5, 6, 3, 4, 5, 6, 3, 4 },
				{ 2, 3, 4, 5, 6, 3, 4, 5, 6, 3, 4, 5, 6, 3, 4, 5, 6, 3, 4 } };
		mon = mon1;
		return this.mon;

	}

	public void setYea(int[][] c) {
		this.yea = c;

	}

	public int[][] getYea() {
		int[][] yea1 = {
				{ 2006, 2005, 2004, 2003, 2002, 2001, 2000, 1999, 1998, 1997,
						1996, 1995, 1994, 1993, 1992, 1991, 1990, 1989, 1988 },
				{ 2006, 2005, 2004, 2003, 2002, 2001, 2000, 1999, 1998, 1997,
						1996, 1995, 1994, 1993, 1992, 1991, 1990, 1989, 1988 },
				{ 2006, 2005, 2004, 2003, 2002, 2001, 2000, 1999, 1998, 1997,
						1996, 1995, 1994, 1993, 1992, 1991, 1990, 1989, 1988 },
				{ 2006, 2005, 2004, 2003, 2002, 2001, 2000, 1999, 1998, 1997,
						1996, 1995, 1994, 1993, 1992, 1991, 1990, 1989, 1988 },
				{ 2006, 2005, 2004, 2003, 2002, 2001, 2000, 1999, 1998, 1997,
						1996, 1995, 1994, 1993, 1992, 1991, 1990, 1989, 1988 },
				{ 2006, 2005, 2004, 2003, 2002, 2001, 2000, 1999, 1998, 1997,
						1996, 1995, 1994, 1993, 1992, 1991, 1990, 1989, 1988 },
				{ 2006, 2005, 2004, 2003, 2002, 2001, 2000, 1999, 1998, 1997,
						1996, 1995, 1994, 1993, 1992, 1991, 1990, 1989, 1988 },
				{ 2006, 2005, 2004, 2003, 2002, 2001, 2000, 1999, 1998, 1997,
						1996, 1995, 1994, 1993, 1992, 1991, 1990, 1989, 1988 },
				{ 2006, 2005, 2004, 2003, 2002, 2001, 2000, 1999, 1998, 1997,
						1996, 1995, 1994, 1993, 1992, 1991, 1990, 1989, 1988 },
				{ 2006, 2005, 2004, 2003, 2002, 2001, 2000, 1999, 1998, 1997,
						1996, 1995, 1994, 1993, 1992, 1991, 1990, 1989, 1988 },
				{ 2006, 2005, 2004, 2003, 2002, 2001, 2000, 1999, 1998, 1997,
						1996, 1995, 1994, 1993, 1992, 1991, 1990, 1989, 1988 },
				{ 2006, 2005, 2004, 2003, 2002, 2001, 2000, 1999, 1998, 1997,
						1996, 1995, 1994, 1993, 1992, 1991, 1990, 1989, 1988 } };
		yea = yea1;
		return this.yea;

	}

	public void setDay(int[][] c) {
		this.day = c;

	}

	public int[][] getDay() {
		int[][] day1 = {

				{ 2, 3, 7, 19, 23, 3, 7, 19, 23, 3, 7, 19, 23, 3, 7, 19, 23, 3,
						7 },
				{ 2, 3, 7, 19, 23, 3, 7, 19, 23, 3, 7, 19, 23, 3, 7, 19, 23, 3,
						7 },
				{ 2, 3, 7, 19, 23, 3, 7, 19, 23, 3, 7, 19, 23, 3, 7, 19, 23, 3,
						7 },
				{ 2, 3, 7, 19, 23, 3, 7, 19, 23, 3, 7, 19, 23, 3, 7, 19, 23, 3,
						7 },
				{ 2, 3, 7, 19, 23, 3, 7, 19, 23, 3, 7, 19, 23, 3, 7, 19, 23, 3,
						7 },
				{ 2, 3, 7, 19, 23, 3, 7, 19, 23, 3, 7, 19, 23, 3, 7, 19, 23, 3,
						7 },
				{ 2, 3, 7, 19, 23, 3, 7, 19, 23, 3, 7, 19, 23, 3, 7, 19, 23, 3,
						7 },
				{ 2, 3, 7, 19, 23, 3, 7, 19, 23, 3, 7, 19, 23, 3, 7, 19, 23, 3,
						7 },
				{ 2, 3, 7, 19, 23, 3, 7, 19, 23, 3, 7, 19, 23, 3, 7, 19, 23, 3,
						7 },
				{ 2, 3, 7, 19, 23, 3, 7, 19, 23, 3, 7, 19, 23, 3, 7, 19, 23, 3,
						7 },
				{ 2, 3, 7, 19, 23, 3, 7, 19, 23, 3, 7, 19, 23, 3, 7, 19, 23, 3,
						7 },
				{ 2, 3, 7, 19, 23, 3, 7, 19, 23, 3, 7, 19, 23, 3, 7, 19, 23, 3,
						7 } };
		day = day1;
		return this.day;

	}

	public void setValue(List c) {
		this.value = c;

	}

	public List getValue() {
		return this.value;

	}

	public void setWidth(int c) {
		this.width = c;

	}

	public int getWidth() {
		return this.width;

	}

	public void setHeight(int c) {
		this.height = c;

	}

	public int getHeight() {
		return this.height;

	}

	public void setXscale(String[] c) {
		this.xscale = c;
	}

	public String[] getXscale() {
		return this.xscale;

	}
	
	
}
