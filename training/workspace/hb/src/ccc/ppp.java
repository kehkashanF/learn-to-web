package ccc;
import java.sql.Date;


public class ppp {
	int m;
	double y;
	String s;
	Date date;
	long l;
	
	public ppp() {
		super();
	}
	public ppp(int m, double y, String s, Date date, long l) {
		super();
		this.m = m;
		this.y = y;
		this.s = s;
		this.date = date;
		this.l = l;
	}
	public int getM() {
		return m;
	}
	public void setM(int m) {
		this.m = m;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public String getS() {
		return s;
	}
	public void setS(String s) {
		this.s = s;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public long getL() {
		return l;
	}
	public void setL(long l) {
		this.l = l;
	}
	
}
