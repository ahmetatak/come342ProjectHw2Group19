//Author: Onur Bayrak
//Date: 13/04/2018

public class Campaign {
	String title;
	String campaignStartDate;
	String campaignFinishDate;
	String estimatedCost;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCampaignStartDate() {
		return campaignStartDate;
	}

	public void setCampaignStartDate(String campaignStartDate) {
		this.campaignStartDate = campaignStartDate;
	}

	public String getCampaignFinishDate() {
		return campaignFinishDate;
	}

	public void setCampaignFinishDate(String campaignFinishDate) {
		this.campaignFinishDate = campaignFinishDate;
	}

	public String getEstimatedCost() {
		return estimatedCost;
	}

	public void setEstimatedCost(String estimatedCost) {
		this.estimatedCost = estimatedCost;
	}

	public void createCampaign(String title,String campaignStartDate,String campaignFinishDate,String estimatedCost) {
		this.title=title;
		this.campaignStartDate=campaignStartDate;
		this.campaignFinishDate=campaignFinishDate;
		this.estimatedCost=estimatedCost;

	}
}