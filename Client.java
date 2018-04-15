//Author: Onur Bayrak
//Date: 14/04/2018

public class Client 

{
    
    private String companyName;
    private String companyAddress;
    private String contactName;
    private ArrayList<Campaign> clientCampaigns = new ArrayList<Campaign>();

    public Client(String companyName, String companyAddress, String contactName)
    
    {
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.contactName = contactName;
        
    }

    public void addNewCampaign(Campaign campaign) {
        this.clientCampaigns.add(campaign);
        
    }

    public ArrayList<Campaign> getClientCampaigns() {
        return this.clientCampaigns;
        
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
}