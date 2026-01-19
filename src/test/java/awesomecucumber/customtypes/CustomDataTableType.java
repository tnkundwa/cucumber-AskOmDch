package awesomecucumber.customtypes;

import awesomecucumber.domainobjects.BillingDetails;
import awesomecucumber.domainobjects.Customer;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class CustomDataTableType {
    @DataTableType
    public BillingDetails billingDetails(Map<String, String> entry) {
        return new BillingDetails(entry.get("firstname"),
                entry.get("lastname"),
                entry.get("address_line1"),
                entry.get("city"),
                entry.get("state"),
                entry.get("zip"),
                entry.get("email"));
    }

    @DataTableType
    public Customer customer(Map<String, String> entry) {
        return new Customer(entry.get("Username"), entry.getOrDefault("email", null), entry.get("password"));
    }
}
