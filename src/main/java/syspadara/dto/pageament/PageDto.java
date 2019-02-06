package syspadara.dto.pageament;

public class PageDto {
	private Integer firstPage;
	private Integer finalPage;
	private Integer acutalPage;
	private Integer previousPage;
	private Integer nextPage;
	private Integer totalPages;
	private Integer totalItems;

	// Construtores
	protected PageDto() {
	}

	public PageDto(Integer firstPage, Integer finalPage, Integer acutalPage, Integer previousPage, Integer nextPage,
			Integer totalPages, Integer totalItems) {
		this.firstPage = firstPage;
		this.finalPage = finalPage;
		this.acutalPage = acutalPage;
		this.previousPage = previousPage;
		this.nextPage = nextPage;
		this.totalPages = totalPages;
		this.totalItems = totalItems;
	}

	// Metodos
	public Integer getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(Integer firstPage) {
		this.firstPage = firstPage;
	}

	public Integer getFinalPage() {
		return finalPage;
	}

	public void setFinalPage(Integer finalPage) {
		this.finalPage = finalPage;
	}

	public Integer getAcutalPage() {
		return acutalPage;
	}

	public void setAcutalPage(Integer acutalPage) {
		this.acutalPage = acutalPage;
	}

	public Integer getPreviousPage() {
		return previousPage;
	}

	public void setPreviousPage(Integer previousPage) {
		this.previousPage = previousPage;
	}

	public Integer getNextPage() {
		return nextPage;
	}

	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public Integer getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(Integer totalItems) {
		this.totalItems = totalItems;
	}
	
}
