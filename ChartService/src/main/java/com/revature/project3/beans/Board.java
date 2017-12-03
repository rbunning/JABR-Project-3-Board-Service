package com.revature.project3.beans;

import java.io.Serializable;

public class Board implements Serializable {

	private static final long serialVersionUID = -3610929458932389168L;

	private int boardId;

	private String boardName;

	public Board() {
		super();
	}

	public Board(int boardId) {
		super();
		this.boardId = boardId;
	}

	public Board(String boardName) {
		super();
		this.boardName = boardName;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	@Override
	public String toString() {
		return "Board [boardId=" + boardId + ", boardName=" + boardName + "]";
	}
}
