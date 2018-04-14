import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class AddNewCampaignUI {

    private JFrame frame;

    private JLabel labelEnterClientName;
    private JLabel labelClientCompany;
    private JLabel labelClientCompanyAddress;
    private JLabel labelClientContactName;

    private JLabel labelCampaignTitle;
    private JLabel labelCampaignStartDate;
    private JLabel labelCampaignFinishDate;
    private JLabel labelCampaignCost;

    private JTextField textClientName;

    private JTextField textCampaignTitle;
    private JTextField textCampaignStartDate;
    private JTextField textCampaignFinishDate;
    private JTextField textCampaignCost;

    private JButton buttonGetClient;
    private JButton buttonShowClientCampaigns;
    private JButton buttonCreateCampaign;

    private JTable campaignTable;

    public void startInterface() {
        frame = new JFrame("Add a new campaign");
        frame.setSize(900, 400);
        frame.setLayout(new GridLayout(0,1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(0,4));
        frame.add(panel);

        labelEnterClientName = new JLabel("Client name:");
        panel.add(labelEnterClientName);

        textClientName = new JTextField();
        panel.add(textClientName);

        buttonGetClient = new JButton("Get Client");
        buttonGetClient.addActionListener((event) -> {
            selectClient();
        });
        panel.add(buttonGetClient);

        panel.add(new JLabel());

        labelClientCompany = new JLabel("Company:");
        panel.add(labelClientCompany);

        labelClientCompanyAddress = new JLabel("Company Address:");
        panel.add(labelClientCompanyAddress);

        labelClientContactName = new JLabel("Contact Name:");
        panel.add(labelClientContactName);

        buttonShowClientCampaigns = new JButton("Show Client's Campaigns");
        buttonShowClientCampaigns.addActionListener((event) -> {
            showClientCampaigns();
        });
        panel.add(buttonShowClientCampaigns);

        labelCampaignTitle = new JLabel("Title:");
        panel.add(labelCampaignTitle);

        textCampaignTitle = new JTextField();
        panel.add(textCampaignTitle);

        labelCampaignStartDate = new JLabel("Start Date:");
        panel.add(labelCampaignStartDate);

        textCampaignStartDate = new JTextField();
        panel.add(textCampaignStartDate);

        labelCampaignFinishDate = new JLabel("Finish Date:");
        panel.add(labelCampaignFinishDate);

        textCampaignFinishDate = new JTextField();
        panel.add(textCampaignFinishDate);

        labelCampaignCost = new JLabel("Estimated Cost:");
        panel.add(labelCampaignCost);

        textCampaignCost = new JTextField();
        panel.add(textCampaignCost);

        buttonCreateCampaign = new JButton("Create Campaign");
        buttonCreateCampaign.addActionListener((e) -> {
            createNewCampaign();
        });
        panel.add(buttonCreateCampaign);

        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Title");
        tableModel.addColumn("Start Date");
        tableModel.addColumn("Finish Date");
        tableModel.addColumn("Estimated Cost");

        Vector<String> headerRowData = new Vector<>();
        headerRowData.add("Title");
        headerRowData.add("Start Date");
        headerRowData.add("Finish Date");
        headerRowData.add("Estimated Cost");
        tableModel.addRow(headerRowData);

        campaignTable = new JTable(tableModel);
        frame.add(campaignTable);

        frame.setVisible(true);
    }

    private void selectClient() {
        String clientContactName = textClientName.getText();
        Client client = Client.getClient(clientContactName);

        if (client != null) {
            labelClientContactName.setText("Contact Name: " + client.getContactName());
            labelClientCompanyAddress.setText("Company Address: " + client.getCompanyAddress());
            labelClientCompany.setText("Company: " + client.getCompanyName());
        }
    }

    private void createNewCampaign() {
        String selectedContactName = textClientName.getText();

        if (!selectedContactName.isEmpty()) {
            Client client = Client.getClient(selectedContactName);

            if (client != null) {
                AddNewCampaign.createNewCampaign(client,
                        textCampaignTitle.getText(),
                        textCampaignStartDate.getText(),
                        textCampaignFinishDate.getText(),
                        Double.parseDouble(textCampaignCost.getText()));
                showClientCampaigns();
            }
        }
    }

    private void showClientCampaigns() {
        String selectedContactName = textClientName.getText();

        if (!selectedContactName.isEmpty()) {
            DefaultTableModel tableModel = (DefaultTableModel) campaignTable.getModel();

            for (int i = 0; i < tableModel.getRowCount(); i++) {
                tableModel.removeRow(i);
            }

            Vector<String> headerRowData = new Vector<>();
            headerRowData.add("Title");
            headerRowData.add("Start Date");
            headerRowData.add("Finish Date");
            headerRowData.add("Estimated Cost");
            tableModel.addRow(headerRowData);

            Client client = Client.getClient(selectedContactName);

            if (client != null) {
                for (Campaign campaign : AddNewCampaign.getClientCampaigns(client)) {
                    Vector<String> rowData = new Vector<>();
                    rowData.add(campaign.getTitle());
                    rowData.add(campaign.getCampaignStartDate());
                    rowData.add(campaign.getCampaignFinishDate());
                    rowData.add(String.valueOf(campaign.getEstimatedCost()));

                    tableModel.addRow(rowData);
                }
            }
        }
    }
}
