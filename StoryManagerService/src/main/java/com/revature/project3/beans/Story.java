package com.revature.project3.beans;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "STORY")
public class Story implements Serializable {

	private static final long serialVersionUID = 3437652641718304355L;

	@Id
	@Column(name = "STORY_ID")
	@SequenceGenerator(name = "storySeq", sequenceName = "story_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "storySeq")
	private int storyId;

	@Column(name = "BOARD_ID")
	private int boardId;

	@Column(name = "LANE_TYPE")
	private int laneTypeId;

	@Column(name = "STORY_NAME")
	private String storyName;

	@Column(name = "STORY_POINTS")
	private int storyPoints;

	@Column(name = "STORY_DESC")
	private String storyDesc;

	@Column(name = "LAST_MOVE_DATE")
	private Date lastMoveDate;

	public Story() {
		super();
	}

	public Story(int storyId) {
		super();
		this.storyId = storyId;
	}

	public Story(int boardId, int laneTypeId, String storyName, int storyPoints, String storyDesc,
			Date lastMoveDate) {
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
		//{"storyId":103,"boardId":0,"laneTypeId":1,"storyName":"","storyPoints":0,"storyDesc":"","lastMoveDate":"2017-11-29"}
		return "{\"storyId\":" + storyId + ",\"boardId\":" + boardId + ",\"laneTypeId\":" + laneTypeId + ",\"storyName\":\"" + storyName
				+ "\",\"storyPoints\":" + storyPoints + ",\"storyDesc\":\"" + storyDesc + "\",\"lastMoveDate\":\"" + lastMoveDate + "\"}";
	}
}