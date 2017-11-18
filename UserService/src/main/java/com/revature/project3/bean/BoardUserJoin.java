package com.revature.project3.bean;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.revature.project3.dto.BoardUserJoidIdDto;

@Entity
@Table(name = "BOARD_USER_JOIN")
public class BoardUserJoin implements Serializable {

	private static final long serialVersionUID = 1290117661830525220L;

	@EmbeddedId
	private BoardUserJoidIdDto boardUserJoinIdDto;

	public BoardUserJoin() {
		super();
	}

	public BoardUserJoin(BoardUserJoidIdDto boardUserJoinIdDto) {
		super();
		this.boardUserJoinIdDto = boardUserJoinIdDto;
	}

	public BoardUserJoidIdDto getBoardUserJoinIdDto() {
		return boardUserJoinIdDto;
	}

	public void setBoardUserJoinIdDto(BoardUserJoidIdDto boardUserJoinIdDto) {
		this.boardUserJoinIdDto = boardUserJoinIdDto;
	}

	@Override
	public String toString() {
		return "BoardUserJoin [boardUserJoinIdDto=" + boardUserJoinIdDto + "]";
	}

}
