package net.guesthouse.roi.dto.model;

import java.sql.Timestamp;
import java.util.Date;

public class DashboardTimeModel {
	private Timestamp start;
	private Timestamp end;

	public Timestamp getStart() {
		return start;
	}

	public void setStart(Date date){
		this.start = new Timestamp(date.getTime());
	}
	
	public void setEnd(Date date){
		this.end =new Timestamp(date.getTime());
	}
	
	public void setStart(Timestamp start) {
		this.start = start;
	}

	public Timestamp getEnd() {
		return end;
	}

	public void setEnd(Timestamp end) {
		this.end = end;
	}

}
