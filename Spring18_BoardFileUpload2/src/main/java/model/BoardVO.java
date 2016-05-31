package model;

import org.springframework.web.multipart.MultipartFile;

public class BoardVO {
	private int no;
	private String title;
	private String content;
	private int count;
	private String writeDate; //컬럼명이랑 필드가 다르다.
	
	//반드시 필드가 이게 추가되어야 한다.
	private MemberVO memberVO;
	








	/// FileUpload 부분 추가 ///
	private String orgfilename;
	private String newfilename;
	private MultipartFile uploadFile;

	public BoardVO(int no, String title, String content, int count,
			String writeDate, MemberVO memberVO) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.count = count;
		this.writeDate = writeDate;
		this.memberVO = memberVO;
	}

	public BoardVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoardVO(int no, String title, String content, int count,
			String writeDate) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.count = count;
		this.writeDate = writeDate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

	public MemberVO getMemberVO() {
		return memberVO;
	}

	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}

	public String getOrgfilename() {
		return orgfilename;
	}

	public void setOrgfilename(String orgfilename) {
		this.orgfilename = orgfilename;
	}

	public String getNewfilename() {
		return newfilename;
	}

	public void setNewfilename(String newfilename) {
		this.newfilename = newfilename;
	}

	public MultipartFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}

	@Override
	public String toString() {
		return "BoardVO [no=" + no + ", title=" + title + ", content="
				+ content + ", count=" + count + ", writeDate=" + writeDate
				+ ", memberVO=" + memberVO + ", orgfilename=" + orgfilename
				+ ", newfilename=" + newfilename + ", uploadFile=" + uploadFile
				+ "]";
	}

}














