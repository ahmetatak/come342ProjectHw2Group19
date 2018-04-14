import javax.swing.table.DefaultTableModel;

public class AddNewCampaign {

    // ENHANCEMENT:
    // used "getClientCampaigns" instead of "showClientCampaigns"
    // because holding the controller class responsible of "showing" is not a good idea
    static Campaign[] getClientCampaigns(Client client) {
        return client.getClientCampaigns();
    }

    public static Campaign createNewCampaign(Client client, String title, String campaignStartDate, String campaignFinishDate, double estimatedCost) {
        Campaign campaign = new Campaign(title, campaignStartDate, campaignFinishDate, estimatedCost);
        client.addNewCampaign(campaign);
        return campaign;
    }
}
