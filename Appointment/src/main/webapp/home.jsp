<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Patient Choice</title>
    <style>
        body {
            font-family: sans-serif;
            background-color: #fff;
            margin: 0;
            padding: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        h2 {
            background-color: #007BFF;
            color: #fff;
            text-align: center;
            padding: 20px 0;
            border-radius: 10px;
            margin: 0;
        }

        form {
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            max-width: 300px;
            text-align: center;
        }

        button {
            background-color: #007BFF;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
            margin: 5px;
        }

        button:hover {
            background-color: #755040;
        }
    </style>
</head>
<body>
    <h2>Welcome to the KTHJ Portal</h2>
    <form>
        <button type="submit" formaction="/patientregistration">Register</button>
        <button type="submit" formaction="/patientlogin">Login</button>
    </form>
</body>
</html>
