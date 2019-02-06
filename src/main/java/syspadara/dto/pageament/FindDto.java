package syspadara.dto.pageament;

public class FindDto {
	private Integer page;
	private Integer size;
	
	//Construtores
	public FindDto() {
	}
	
	public FindDto(Integer page, Integer size) {
		this.page = page;
		this.size = size;
	}
	
	//Metodos
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
}
