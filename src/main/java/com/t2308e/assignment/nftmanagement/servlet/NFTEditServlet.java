package com.t2308e.assignment.nftmanagement.servlet;

import com.t2308e.assignment.nftmanagement.dao.NFTDao;
import com.t2308e.assignment.nftmanagement.model.NFT;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/editNFT")
public class NFTEditServlet extends HttpServlet {
    private NFTDao nftDao;

    @Override
    public void init() throws ServletException {
        nftDao = new NFTDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            NFT nft = nftDao.getNFTById(id);
            request.setAttribute("nft", nft);
            request.getRequestDispatcher("editNFT.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String url = request.getParameter("url");
        long createdDate = Long.parseLong(request.getParameter("createdDate"));
        String owner = request.getParameter("owner");
        String category = request.getParameter("category");
        double price = Double.parseDouble(request.getParameter("price"));
        String wallet_address = request.getParameter("wallet_address");
        String status = request.getParameter("status");
        NFT nft = new NFT(id, name, description, url, createdDate, owner, category, price, wallet_address, status);
        try {
            nftDao.updateNFT(nft);
            response.sendRedirect("nft");
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
    }
}
