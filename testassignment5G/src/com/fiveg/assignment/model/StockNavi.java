package com.fiveg.assignment.model;

public class StockNavi {
  private long id;
  private String t;
  private String e;
  private float l;
  private float l_fix;
  private float l_cur;
  private int s;
  private String ltt;
  private String lt;
  private String lt_dt;

  public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getT() {
	return t;
}
public void setT(String t) {
	this.t = t;
}
public String getE() {
	return e;
}
public void setE(String e) {
	this.e = e;
}
public float getL() {
	return l;
}
public void setL(float l) {
	this.l = l;
}
public float getL_fix() {
	return l_fix;
}
public void setL_fix(float l_fix) {
	this.l_fix = l_fix;
}
public float getL_cur() {
	return l_cur;
}
public void setL_cur(float l_cur) {
	this.l_cur = l_cur;
}
public int getS() {
	return s;
}
public void setS(int s) {
	this.s = s;
}
public String getLtt() {
	return ltt;
}
public void setLtt(String ltt) {
	this.ltt = ltt;
}
public String getLt() {
	return lt;
}
public void setLt(String lt) {
	this.lt = lt;
}
public String getLt_dt() {
	return lt_dt;
}
public void setLt_dt(String lt_dt) {
	this.lt_dt = lt_dt;
}

  public void showData() {
	  System.out.println(id + " : "+t +" : " + e+" : "+l+" :"+l_fix+" : "+l_cur+" : "+s+" : "+ltt+" : "+lt+" : "+lt_dt+" : ");
  }
}
