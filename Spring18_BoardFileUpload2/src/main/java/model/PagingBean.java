package model;
/**
 * 페이징 로직을 위한 클래스 
 * @author inst
 *
 */
public class PagingBean {
	/**
	 * 총 게시물 수 
	 */
	private int totalContent;
	public int getNowPage() {
		return nowPage;
	}
	/**
	 * 현재 페이지 넘버 
	 */
	private int nowPage=1;
	/**
	 * 한 페이지에서 보여줄 게시물 수 
	 */
	private int numberOfContentPerPage=CommonConstants.CONTENT_NUMBER_PER_PAGE;
	/**
	 * 한 페이지 그룹내 페이지 수 
	 */
	private int numberOfPageGroup=CommonConstants.PAGEGROUP_NUMBER_PER_PAGE;
	/**
	 * PagingBean을 통해 페이징 로직을 정의하기 위해서는 
	 * 전체 게시물 수와 현재 페이지 넘버를 필요로 한다. 
	 * @param totalContent
	 * @param nowPage
	 */
	public PagingBean(int totalContent, int nowPage) {
		super();
		this.totalContent = totalContent;
		this.nowPage = nowPage;
	}
	/**
	 * 총 페이지 수 리턴  
	 * ex) 총게시물 수 - 15 개 , 한화면에서 보여질 게시물 수 - 5개 
	 *      몇페이지 ? 총 3 페이지 
	 *      16개면 총 4페이지 
	 *  총게시물수 % 한페이지에 보여질 게시물수 
	 *  0 이면 나눈 값
	 *  0 이 아니면 나눈 값 + 1     
	 * @return
	 */
	public int getTotalPage(){
		int num=totalContent%this.numberOfContentPerPage;
		int totalPage=0;
		if(num==0)
			totalPage=totalContent/this.numberOfContentPerPage;
		else
			totalPage=totalContent/this.numberOfContentPerPage+1;
		return totalPage;
	}
	/**
	 * 전체 페이지 그룹수 리턴 
	 * ex) 총 게시물 수 23개 - 총페이지수?5페이지   총페이지그룹수?2그룹
	 * 총페이지수 % Page Group 내 페이지 수 
	 * --> 0이면 나눈값 
	 * --> 0이 아니면 나눈값+1  
	 * @return
	 */
	public int getTotalPageGroup(){
		int num=this.getTotalPage()%this.numberOfPageGroup;
		int totalGroup=0;
		if(num==0)
			totalGroup=this.getTotalPage()/this.numberOfPageGroup;
		else
			totalGroup=this.getTotalPage()/this.numberOfPageGroup+1;
		return totalGroup;
	}
	/**
	 * 현재 페이지가 속한 페이지 그룹 번호를 리턴 
	 * 현재 페이지 % Page 그룹내 페이지 수 
	 * 0 -> 나눈 값이 페이지 그룹 번호 
	 * 0 이 아니면 나눈 값 + 1 
	 * @return
	 */
	public int getNowPageGroup(){
		int num=this.nowPage%this.numberOfPageGroup;
		int nowGroup=0;
		if(num==0)
			nowGroup=this.nowPage/this.numberOfPageGroup;
		else
			nowGroup=this.nowPage/this.numberOfPageGroup+1;
		return nowGroup;
	}
	/**
	 * 현재 페이지가 속한 페이지 그룹의 시작 페이지 번호를 리턴 
	 * PageGroup내 페이지 수 * (현재 페이지 그룹-1) + 1 
	 * 전 페이지 그룹의 마지막 번호 + 1 이 결국 시작 페이지가 된다 
	 * @return
	 */
	public int getStartPageOfPageGroup(){
		//이전 페이지 그룹의 마지막 페이지 번호+1하면 시작 페이지가 됨
		int start=this.numberOfPageGroup*(this.getNowPageGroup()-1)+1;
		return start;
	}
	/**
	 * 현재 페이지가 속한 페이지 그룹의 마지막 페이지 번호를 리턴 
	 * 현재 페이지 그룹 * 페이지 그룹내 페이지 수 
	 * 만약 전체 페이지 수보다 위의 값보다 클 경우 
	 * 전체 페이지 수가 마지막 페이지 번호가 된다. 
	 * @return
	 */
	public int getEndPageOfPageGroup(){
		int end=this.numberOfPageGroup*this.getNowPageGroup();
		if(end>this.getTotalPage()){
			end=this.getTotalPage();
		}
		return end;
	}
	/**
	 * 이전 페이지 그룹이 있는지 확인하여 있으면 true 없으면 false 
	 * 현재 페이지 그룹이 1보다 크면 true 
	 * @return
	 */
	public boolean isPreviousPageGroup(){
		boolean flag=false;
		if(this.getNowPageGroup()>1)
			flag=true;
		return flag;
	}
	/**
	 * 다음 페이지 그룹이 있는 지 확인 
	 * 현재 페이지 그룹이 전체 페이지 그룹 수보다 작으면 true
	 * @return
	 */
	public boolean isNextPageGroup(){
		boolean flag=false;
		if(this.getNowPageGroup()<this.getTotalPageGroup())
			flag=true;
		return flag;
	}
	public static void main(String args[]){
		PagingBean bean=new PagingBean(26,6);
		System.out.println(bean.getTotalPage()+"페이지");
		System.out.println(bean.getTotalPageGroup()+"페이지 그룹");
		System.out.println(bean.getNowPageGroup()+" 현재 페이지 그룹");
	}
}











