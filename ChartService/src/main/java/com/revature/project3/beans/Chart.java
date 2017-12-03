package com.revature.project3.beans;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CHART")
public class Chart implements Serializable {

	private static final long serialVersionUID = 8410665221636520198L;

	@Id
	@Column(name = "CHART_ID")
	@SequenceGenerator(allocationSize = 1, sequenceName = "CHART_SEQ", name = "C_SEQ")
	@GeneratedValue(generator = "C_SEQ", strategy = GenerationType.SEQUENCE)
	private int chartId;

	@Column(name = "BOARD_ID")
	private int boardId;

	@Column(name = "CHART_TITLE")
	private String chartTitle;
	@Column(name = "START_DATE")
	private Date startDate;

	public Chart() {
		super();
	}

	public Chart(int chartId, int boardId, String chartTitle, Date startDate) {
		super();
		this.chartId = chartId;
		this.boardId = boardId;
		this.chartTitle = chartTitle;
		this.startDate = startDate;
	}

	public Chart(int boardId, String chartTitle) {
		super();
		this.boardId = boardId;
		this.chartTitle = chartTitle;
		this.startDate = Date.valueOf(LocalDate.now().minusDays(1));
	}

	public int getChartId() {
		return chartId;
	}

	public void setChartId(int chartId) {
		this.chartId = chartId;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getChartTitle() {
		return chartTitle;
	}

	public void setChartTitle(String chartTitle) {
		this.chartTitle = chartTitle;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Chart [chartId=" + chartId + ", boardId=" + boardId + ", chartTitle=" + chartTitle + ", startDate="
				+ startDate + "]";
	}
}