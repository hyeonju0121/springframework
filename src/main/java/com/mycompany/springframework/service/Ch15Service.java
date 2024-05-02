package com.mycompany.springframework.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.springframework.dao.mybatis.Ch13AccountDao;
import com.mycompany.springframework.dto.Ch15Account;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Ch15Service {
	
	@Autowired
	private Ch13AccountDao accountDao;
	
	// account 내역 전체 조회
	public List<Ch15Account> getAccountList() {
		List<Ch15Account> accountList = accountDao.selectAll();
		return accountList;
	}
	
	// account balance 업데이트  (계좌이체)
	@Transactional
	public void transfer(int fromAno, int toAno, int amount) {
		// 출금 작업 ----------------------------------------------
		// 출금 계좌 정보 가져오기
		Ch15Account fromAccount = accountDao.selectByAno(fromAno);
		if (fromAccount == null) { // 출금 계좌가 존재하지 않는 경우, 예외 발생
			throw new RuntimeException("출금 계좌가 존재하지 않습니다.");
		}
		fromAccount.setBalance(fromAccount.getBalance() - amount);
		// 출금한 금액 업데이트 
		accountDao.updateBalance(fromAccount);
		
		// 입금 작업 ------------------------------------------------
		// 입금 계좌 정보 가져오기 
		Ch15Account toAccount = accountDao.selectByAno(toAno);
		if (toAccount == null) { // 입금 계좌가 존재하지 않는 경우, 예외 발생
			throw new RuntimeException("입금 계좌가 존재하지 않습니다.");
		}
		toAccount.setBalance(toAccount.getBalance() + amount);
		// 입금한 금액 업데이트
		accountDao.updateBalance(toAccount);
		
	}
	
	

}
