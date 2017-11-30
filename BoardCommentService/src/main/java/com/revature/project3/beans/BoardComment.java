package com.revature.project3.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "BOARD_COMMENT")
public class BoardComment implements Serializable {

	private static final long serialVersionUID = -8741164612408608164L;

	@Id
	@Column(name = "BOARD_COMMENT_ID")
	@SequenceGenerator(name = "boardCommentSeq", sequenceName = "board_comment_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "boardCommentSeq")
	private int boardCommentId;

	@Column(name = "BOARD_ID")
	private int boardId;

	@Column(name = "SU_ID")
	private int scrumUserId;

	@Column(name = "COMMENT_DESC")
	private String comment;

	@Column(name = "COMMENT_DATE")
	private String commentDate;

	public BoardComment() {
		super();
	}

	public BoardComment(int boardCommentId, int boardId, int scrumUserId, String comment, String commentDate) {
		super();
		this.boardCommentId = boardCommentId;
		this.boardId = boardId;
		this.scrumUserId = scrumUserId;
		this.comment = comment;
		this.commentDate = commentDate;
	}

	public BoardComment(int boardId, int scrumUserId, String comment, String commentDate) {
		super();
		this.boardId = boardId;
		this.scrumUserId = scrumUserId;
		this.comment = comment;
		this.commentDate = commentDate;
	}

	public BoardComment(int boardId, int scrumUserId, String comment) {
		super();
		this.boardId = boardId;
		this.scrumUserId = scrumUserId;
		this.comment = comment;
	}

	public int getBoardCommentId() {
		return boardCommentId;
	}

	public void setBoardCommentId(int boardCommentId) {
		this.boardCommentId = boardCommentId;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public int getScrumUserId() {
		return scrumUserId;
	}

	public void setScrumUserId(int scrumUserId) {
		this.scrumUserId = scrumUserId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}

	@Override
	public String toString() {
		return "BoardComment [boardCommentId=" + boardCommentId + ", boardId=" + boardId + ", scrumUserId="
				+ scrumUserId + ", comment=" + comment + ", commentDate=" + commentDate + "]";
	}

}
