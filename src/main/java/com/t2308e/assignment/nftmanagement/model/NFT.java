package com.t2308e.assignment.nftmanagement.model;

public class NFT {
    private int id;
    private String name;
    private String description;
    private String url;
    private long createdDate;
    private String owner;
    private String category;
    private double price;
    private String wallet_address;
    private String status;

    // Constructor
    public NFT() {}

    public NFT(int id, String name, String description, String url, long createdDate, String owner, String category, double price, String status, String wallet_address) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.url = url;
        this.createdDate = createdDate;
        this.owner = owner;
        this.category = category;
        this.price = price;
        this.status = status;
        this.wallet_address = wallet_address;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    public long getCreatedDate() { return createdDate; }
    public void setCreatedDate(long createdDate) { this.createdDate = createdDate; }
    public String getOwner() { return owner; }
    public void setOwner(String owner) { this.owner = owner; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getStatus() { return status; }
    public void setStatus(String status) {
       this.status = status;
    }
    public String getWalletAddress() { return wallet_address; }
    public void setWalletAddress(String wallet_address) { this.wallet_address = wallet_address; }
}
