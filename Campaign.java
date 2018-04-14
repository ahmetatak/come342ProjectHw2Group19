import java.util.Date;

public class Campaign {
    private String title;
    private String campaignStartDate;
    private String campaignFinishDate;
    private double estimatedCost;

    public Campaign(String title, String campaignStartDate, String campaignFinishDate, double estimatedCost) {
        this.title = title;
        this.campaignStartDate = campaignStartDate;
        this.campaignFinishDate = campaignFinishDate;
        this.estimatedCost = estimatedCost;
    }

    public String getTitle() {
        return title;
    }

    public String getCampaignStartDate() {
        return campaignStartDate;
    }

    public String getCampaignFinishDate() {
        return campaignFinishDate;
    }

    public double getEstimatedCost() {
        return estimatedCost;
    }

    // Necessary since a set will be used to store campaign/client data and the set will need the "equals" method to check whether 2 campaign objects are the same
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Campaign) {
            Campaign campaign = (Campaign) obj;
            //2 Campaigns objects are considered the same if their titles are the same
            return campaign.title.equals(this.title);
        } else {
            return false;
        }
    }
}
