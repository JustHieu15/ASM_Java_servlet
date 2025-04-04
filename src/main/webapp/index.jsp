<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>NFT Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">
    <h1 class="text-center mb-4">NFT Management</h1>
    <div class="text-end mb-3">
        <a href="${pageContext.request.contextPath}/addNFT" class="btn btn-primary">Add New NFT</a>
    </div>
    <table class="table table-striped table-bordered">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>URL</th>
            <th>Created Date</th>
            <th>Owner</th>
            <th>Category</th>
            <th>Price</th>
            <th>Status</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="nft" items="${nftList}">
            <tr>
                <td>${nft.id}</td>
                <td>${nft.name}</td>
                <td>${nft.description}</td>
                <td><a href="${nft.url}" target="_blank" class="btn btn-sm btn-info">View</a></td>
                <td>${nft.createdDate}</td>
                <td>${nft.owner}</td>
                <td>${nft.category}</td>
                <td>${nft.price}</td>
                <td>
                <span class="badge
                                ${nft.status == 'ForSale' ? 'bg-success' :
                                  nft.status == 'Sold' ? 'bg-danger' :
                                  'bg-secondary'}">
                        ${nft.status}
                </span>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/editNFT?id=${nft.id}" class="btn btn-sm btn-warning">Edit</a>
                    <a href="${pageContext.request.contextPath}/deleteNFT?id=${nft.id}" class="btn btn-sm btn-danger" onclick="return confirm('Are you sure you want to delete this NFT?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>