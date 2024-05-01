package com.mycompany.springframework.dto;

import lombok.Data;

@Data
public class Ch13Pager {
   private int totalRows;     	 // 페이징 대상이 되는 전체 행수  	ex. 10000
   private int totalPageNo;   	 // 전체 페이지 수  				ex. 1000 
   private int totalGroupNo;     // 전체 그룹 수 				ex. 100
   private int startPageNo;      // 그룹의 시작 페이지 번호		ex. 1, 11, 21, ....
   private int endPageNo;        // 그룹의 끝 페이지 번호			ex. 10, 20, 30, ....
   private int pageNo;           // 현재 페이지 번호				
   private int pagesPerGroup;    // 그룹당 페이지 수				ex. 1~ 10 그룹 내에 페이지 수 -> 10 
   private int groupNo;          // 현재 그룹 번호				ex. 1그룹, 2그룹.. 10그룹 
   private int rowsPerPage;      // 페이지당 행 수 				
   private int startRowNo;       // 페이지의 시작 행 번호(1, ..., n)
   private int startRowIndex;    // 페이지의 시작 행 인덱스(0, ..., n-1) for mysql
   private int endRowNo;         // 페이지의 마지막 행 번호
   private int endRowIndex;      // 페이지의 마지막 행 인덱스

   public Ch13Pager(int rowsPerPage, int pagesPerGroup, int totalRows, int pageNo) {
      this.rowsPerPage = rowsPerPage;
      this.pagesPerGroup = pagesPerGroup;
      this.totalRows = totalRows;
      this.pageNo = pageNo;

      totalPageNo = totalRows / rowsPerPage;
      if(totalRows % rowsPerPage != 0) totalPageNo++;  // 나누어 떨어지지 않는 경우, 전체 페이지수+1;
      
      totalGroupNo = totalPageNo / pagesPerGroup;
      if(totalPageNo % pagesPerGroup != 0) totalGroupNo++; 
      
      groupNo = (pageNo - 1) / pagesPerGroup + 1;
      
      startPageNo = (groupNo-1) * pagesPerGroup + 1;
      
      endPageNo = startPageNo + pagesPerGroup - 1;
      if(groupNo == totalGroupNo) endPageNo = totalPageNo;
      
      startRowNo = (pageNo - 1) * rowsPerPage + 1;
      startRowIndex = startRowNo - 1;
      endRowNo = pageNo * rowsPerPage;
      endRowIndex = endRowNo - 1; 
   }
}