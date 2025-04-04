<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add NFT</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">
    <h1 class="text-center mb-4">Add New NFT</h1>
    <form action="${pageContext.request.contextPath}/addNFT" method="post">
        <div class="mb-3">
            <label for="name" class="form-label">Name:</label>
            <input type="text" class="form-control" id="name" name="name" required>
        </div>
        <div class="mb-3">
            <label for="description" class="form-label">Description:</label>
            <textarea class="form-control" id="description" name="description" rows="3"></textarea>
        </div>
        <div class="mb-3">
            <label for="url" class="form-label">URL:</label>
            <input type="url" class="form-control" id="url" name="url">
        </div>
        <div class="mb-3">
            <label for="owner" class="form-label">Owner:</label>
            <input type="text" class="form-control" id="owner" name="owner">
        </div>
        <div class="mb-3">
            <label for="category" class="form-label">Category:</label>
            <select class="form-select" id="category" name="category" required>
                <option value="">Select a category</option>
                <option value="Digital Art">Digital Art</option>
                <option value="Sound">Sound</option>
                <option value="Video">Video</option>
                <option value="GIF">GIF</option>
                <option value="3D Model">3D Model</option>
            </select>
        </div>
        <div class="mb-3">
            <label for="price" class="form-label">Price:</label>
            <input type="number" step="0.01" class="form-control" id="price" name="price" required>
        </div>
        <div class="mb-3">
            <label for="status" class="form-label">Status:</label>
            <select class="form-select" id="status" name="status">
                <option value="ForSale">Đang bán</option>
                <option value="Sold">Đã bán</option>
                <option value="NotForSale">Không bán</option>
            </select>
        </div>
        <div class="mb-3">
            <label for="wallet_address" class="form-label">Wallet Address:</label>
            <input type="text" class="form-control" id="wallet_address" name="wallet_address">
        </div>
        <div class="text-center">
            <button type="submit" class="btn btn-success">Add NFT</button>
            <a href="${pageContext.request.contextPath}/nft" class="btn btn-secondary">Back to List</a>
        </div>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>