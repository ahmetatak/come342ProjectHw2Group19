import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Client {
    private String companyName;
    private String companyAddress;
    private String contactName;

    private ArrayList<Campaign> campaigns;

    public Client(String companyName, String companyAddress, String contactName) {
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.contactName = contactName;
        this.campaigns = new ArrayList<>();

        if (!clients.contains(this)) {
            clients.add(this);
        }
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public String getContactName() {
        return contactName;
    }

    public Campaign[] getClientCampaigns() {
        return campaigns.toArray(new Campaign[] {});
    }

    public void addNewCampaign(Campaign campaign) {
        campaigns.add(campaign);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Client) {
            Client client = (Client) obj;
            //2 Campaigns objects are considered the same if their contact names are the same
            return client.contactName.equals(this.contactName);
        } else {
            return false;
        }
    }

    private static ArrayList<Client> clients = new ArrayList<>();

    public static Client getClient(String contactName) {
        for (Client client : clients) {
            if (client.contactName.equals(contactName)) {
                return client;
            }
        }
        return null;
    }
}
