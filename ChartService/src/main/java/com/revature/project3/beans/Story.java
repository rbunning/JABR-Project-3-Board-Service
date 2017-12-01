package com.revature.project3.beans;

import java.io.Serializable;
import java.sql.Date;

public class Story implements Serializable {

	private static final long serialVersionUID = 3437652641718304355L;

	private int storyId;

	private int boardId;

	private int laneTypeId;

	private String storyName;

	private int storyPoints;

	private String storyDesc;

	private Date lastMoveDate;

	public Story() {
		super();
	}

	public Story(int boardId, int laneTypeId, String storyName, int storyPoints, String storyDesc, Date lastMoveDate) {
		super();
		this.boardId = boardId;
		this.laneTypeId = laneTypeId;
		this.storyName = storyName;
		this.storyPoints = storyPoints;
		this.storyDesc = storyDesc;
		this.lastMoveDate = lastMoveDate;
	}

	public Story(int storyId, int boardId, int laneTypeId, String storyName, int storyPoints, String storyDesc,
			Date lastMoveDate) {
		super();
		this.storyId = storyId;
		this.boardId = boardId;
		this.laneTypeId = laneTypeId;
		this.storyName = storyName;
		this.storyPoints = storyPoints;
		this.storyDesc = storyDesc;
		this.lastMoveDate = lastMoveDate;
	}

	public int getStoryId() {
		return storyId;
	}

	// Won't need tasks for Chart
	public void setStoryId(int storyId) {
		this.storyId = storyId;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoard(int boardId) {
		this.boardId = boardId;
	}

	public int getLaneTypeId() {
		return laneTypeId;
	}

	public void setLaneTypeId(int laneTypeId) {
		this.laneTypeId = laneTypeId;
	}

	public String getStoryName() {
		return storyName;
	}

	public void setStoryName(String storyName) {
		this.storyName = storyName;
	}

	public int getStoryPoints() {
		return storyPoints;
	}

	public void setStoryPoints(int storyPoints) {
		this.storyPoints = storyPoints;
	}

	public String getStoryDesc() {
		return storyDesc;
	}

	public void setStoryDesc(String storyDesc) {
		this.storyDesc = storyDesc;
	}

	public Date getLastMoveDate() {
		return lastMoveDate;
	}

	public void setLastMoveDate(Date lastMoveDate) {
		this.lastMoveDate = lastMoveDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Story [storyId=" + storyId + ", boardId=" + boardId + ", laneId=" + laneTypeId + ", storyName="
				+ storyName + ", storyPoints=" + storyPoints + ", storyDesc=" + storyDesc + ", lastMoveDate="
				+ lastMoveDate + "]";
	}
}