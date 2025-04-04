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
import java.util.List;

@WebServlet("/nft")
public class NFTServlet extends HttpServlet {
    private NFTDao nftDao;

    @Override
    public void init() throws ServletException {
        nftDao = new NFTDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<NFT> nftList = nftDao.getAllNFTs();
            request.setAttribute("nftList", nftList);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
    }


}
