<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Product Page</title>
    
    <style>
        /* Add antique-style CSS */
        body {
            font-family: 'Times New Roman', serif;
            background-color: #f0e1d0;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        form {
            max-width: 350px;
            padding: 20px;
            background: #f5eae1;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            text-align: center;
        }
        h2 {
            font-size: 24px;
            color: #3c2e2e;
            margin-bottom: 20px;
        }
        .form-group {
            margin: 10px 0;
        }
        .form-group label {
            display: block;
            font-size: 18px;
            color: #3c2e2e;
            text-align: left;
        }
        .form-group input {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #6b574d;
            border-radius: 5px;
            font-size: 16px;
            color: #3c2e2e;
            background: #f0e1d0;
        }
        .form-group button {
            background-color: #6b574d;
            color: #f0e1d0;
            border: none;
            border-radius: 5px;
            padding: 12px 24px;
            font-size: 18px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        .form-group button:hover {
            background-color: #3c2e2e;
        }
    </style>
</head>
<body>

<form action="/jspdemo/AddProduct" method="post">
    <h2>Add a New Product</h2>
    <div class="form-group">
        <label for="pid">Product ID:</label>
        <input type="text" id="pid" name="pid" required>
    </div>
    <div class="form-group">
        <label for="pname">Product Name:</label>
        <input type="text" id="pname" name="pname" required>
    </div>
    <div class="form-group">
        <label for="pprice">Product Price:</label>
        <input type="text" id="pprice" name="pprice" required>
    </div>
    <div class="form-group">
        <button type="submit">Add Product</button>
    </div>
    
</form>

</body>
</html>
