package com.marcoscarvalho;

import java.io.Serializable;
import java.util.Date;

public class Log implements Serializable {

	private static final long serialVersionUID = 4258507227996842735L;

	private String app;
	private String msg;
	private String level = "INFO";
	private Date date;

	public Log() {
		date = new Date();
	}

	public Log(String app, String msg) {
		this();
		this.app = app;
		this.msg = msg;
	}

	public Log(String level, String app, String msg) {
		this();
		this.level = level;
		this.app = app;
		this.msg = msg;
	}

	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("[");
		str.append(app);
		str.append(" | ");
		str.append(level);
		str.append(" | ");
		str.append(LogController.FORMAT_DATE.format(date));
		str.append(" | ");
		str.append(msg);
		str.append("]");
		return str.toString();
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

}
