import java.util.ArrayList;
import java.util.List;

// Class representing a financial advisor
class FinancialAdvisor {
    private int advisorId;
    private String name;
    private String email;
    private String phoneNumber;
    private String workingHours;
    private List<Client> clients;

    public FinancialAdvisor(int advisorId, String name, String email, String phoneNumber, String workingHours) {
        this.advisorId = advisorId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.workingHours = workingHours;
        this.clients = new ArrayList<>();
    }

    public int getAdvisorId() { return advisorId; }
    public String getName() { return name; }
    public List<Client> getClients() { return clients; }

    public void addClient(Client client) {
        clients.add(client);
    }
}

// Class representing a client
class Client {
    private int clientId;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private Portfolio portfolio;

    public Client(int clientId, String name, String email, String phoneNumber, String address) {
        this.clientId = clientId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.portfolio = new Portfolio(clientId);
    }

    public int getClientId() { return clientId; }
    public String getName() { return name; }
    public Portfolio getPortfolio() { return portfolio; }
}

// Class representing a portfolio
class Portfolio {
    private int portfolioId;
    private List<Security> securities;

    public Portfolio(int portfolioId) {
        this.portfolioId = portfolioId;
        this.securities = new ArrayList<>();
    }

    public int getPortfolioId() { return portfolioId; }
    public List<Security> getSecurities() { return securities; }

    public void addSecurity(Security security) {
        securities.add(security);
    }
}

// Class representing a security
class Security {
    private int securityId;
    private String name;
    private String category;
    private String purchaseDate;
    private double purchasePrice;
    private int quantity;

    public Security(int securityId, String name, String category, String purchaseDate, double purchasePrice, int quantity) {
        this.securityId = securityId;
        this.name = name;
        this.category = category;
        this.purchaseDate = purchaseDate;
        this.purchasePrice = purchasePrice;
        this.quantity = quantity;
    }

    public int getSecurityId() { return securityId; }
    public String getName() { return name; }
    public String getCategory() { return category; }
}

// Main class
public class Main {
    public static void main(String[] args) {
        // Create a financial advisor
        FinancialAdvisor advisor = new FinancialAdvisor(1, "John Doe", "john.doe@example.com", "123-456-7890", "9AM to 5PM");

        // Create a client and assign to the advisor
        Client client = new Client(101, "Jane Smith", "jane.smith@example.com", "987-654-3210", "123 Elm Street");
        advisor.addClient(client);

        // Add securities to the client's portfolio
        Security security1 = new Security(201, "Stock A", "Equity", "2023-01-01", 150.50, 10);
        Security security2 = new Security(202, "Bond B", "Fixed Income", "2023-02-01", 200.75, 5);

        client.getPortfolio().addSecurity(security1);
        client.getPortfolio().addSecurity(security2);

        // Print details
        System.out.println("Advisor: " + advisor.getName());
        for (Client c : advisor.getClients()) {
            System.out.println("  Client: " + c.getName());
            for (Security s : c.getPortfolio().getSecurities()) {
                System.out.println("    Security: " + s.getName() + ", Category: " + s.getCategory());
            }
        }
    }
}
