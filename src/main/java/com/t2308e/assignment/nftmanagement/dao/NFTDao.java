package com.t2308e.assignment.nftmanagement.dao;

import com.t2308e.assignment.nftmanagement.model.NFT;
import com.t2308e.assignment.nftmanagement.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NFTDao {
    public List<NFT> getAllNFTs() throws SQLException {
        List<NFT> nftList = new ArrayList<>();
        String query = "SELECT * FROM nft";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                NFT nft = new NFT(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getString("url"),
                        rs.getLong("created_date"),
                        rs.getString("owner"),
                        rs.getString("category"),
                        rs.getDouble("price"),
                        rs.getString("wallet_address"),
                        rs.getString("status")
                );
                nftList.add(nft);
            }
        }
        return nftList;
    }

    public void addNFT(NFT nft) throws SQLException {
        String query = "INSERT INTO nft (name, description, url, created_date, owner, category, price, wallet_address, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nft.getName());
            stmt.setString(2, nft.getDescription());
            stmt.setString(3, nft.getUrl());
            stmt.setLong(4, nft.getCreatedDate());
            stmt.setString(5, nft.getOwner());
            stmt.setString(6, nft.getCategory());
            stmt.setDouble(7, nft.getPrice());
            stmt.setString(8, nft.getWalletAddress());
            stmt.setString(9, nft.getStatus());
            stmt.executeUpdate();
        }
    }

    public NFT getNFTById(int id) throws SQLException {
        String query = "SELECT * FROM nft WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new NFT(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("description"),
                            rs.getString("url"),
                            rs.getLong("created_date"),
                            rs.getString("owner"),
                            rs.getString("category"),
                            rs.getDouble("price"),
                            rs.getString("wallet_address"),
                            rs.getString("status")
                    );
                }
            }
        }
        return null;
    }

    public void updateNFT(NFT nft) throws SQLException {
        String query = "UPDATE nft SET name = ?, description = ?, url = ?, created_date = ?, owner = ?, category = ?, price = ?, wallet_address = ?, status = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nft.getName());
            stmt.setString(2, nft.getDescription());
            stmt.setString(3, nft.getUrl());
            stmt.setLong(4, nft.getCreatedDate());
            stmt.setString(5, nft.getOwner());
            stmt.setString(6, nft.getCategory());
            stmt.setDouble(7, nft.getPrice());
            stmt.setString(8, nft.getWalletAddress()); // Đúng: `wallet_address` ở vị trí 8
            stmt.setString(9, nft.getStatus()); // Đúng: `status` ở vị trí 9
            stmt.setInt(10, nft.getId());
            stmt.executeUpdate();
        }
    }
    // In NFTDao.java
    public void deleteNFT(int id) throws SQLException {
        String query = "DELETE FROM nft WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}

