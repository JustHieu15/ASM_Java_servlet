package com.t2308e.assignment.nftmanagement.servlet;

import com.t2308e.assignment.nftmanagement.dao.NFTDao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/deleteNFT")
public class NFTDeleteServlet extends HttpServlet {
    private NFTDao nftDao;

    @Override
    public void init() throws ServletException {
        nftDao = new NFTDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            nftDao.deleteNFT(id);
            response.sendRedirect("nft");
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
    }
}
