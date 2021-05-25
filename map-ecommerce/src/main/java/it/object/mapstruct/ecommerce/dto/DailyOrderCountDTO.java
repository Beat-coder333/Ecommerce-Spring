package it.object.mapstruct.ecommerce.dto;

public class DailyOrderCountDTO {

	private String date;
	private Integer countOrders;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getCountOrders() {
		return countOrders;
	}

	public void setCountOrders(Integer countOrders) {
		this.countOrders = countOrders;
	}

	public DailyOrderCountDTO(String date, Integer countOrders) {
		super();
		this.date = date;
		this.countOrders = countOrders;
	}

	@Override
	public String toString() {
		return "DailyOrderCountDTO [date=" + date + ", countOrders=" + countOrders + "]";
	}

}
