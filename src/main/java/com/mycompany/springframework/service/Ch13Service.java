package com.mycompany.springframework.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.springframework.dao.mybatis.Ch13BoardDao;
import com.mycompany.springframework.dto.Ch13Board;
import com.mycompany.springframework.dto.Ch13Pager;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Ch13Service {
	@Autowired
	private Ch13BoardDao boardDao;
	
	public void writeBoard(Ch13Board board) {
		// 비즈니스 로직 처리
		int rowNum = boardDao.insert(board);
		log.info("rowNum: " + rowNum + ", bno: " + board.getBno());
		
	}
	
	public List<Ch13Board> getBoardList(Ch13Pager pager) {
		return boardDao.selectByPage(pager);
	}
	
	public int getTotalRows() {
		return boardDao.count();
	}

	public Ch13Board getBoard(int bno) {
		return boardDao.selectByBno(bno);
	}

	public byte[] getAttachData(int bno) {
		Ch13Board board = boardDao.selectAttachData(bno);
		return board.getBattachdata();
	}

	public void updateBoard(Ch13Board board) {
		boardDao.update(board);
	}

	public void removeBoard(int bno) {
		boardDao.deleteByBno(bno);
	}
	
}
