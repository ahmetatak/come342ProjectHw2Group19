//Author: Abdulkerim Toker
//Date: 14/04/2018
public class test {
    public static void main(String[] args) {
        Client client = new Client("Company 1", "Address 1", "Name 1");
        AddNewCampaign.createNewCampaign(client, "Campaign Title 1", "11/11/2011", "12/12/2012", 200.0);

        new AddNewCampaignUI().startInterface();
    }
}
