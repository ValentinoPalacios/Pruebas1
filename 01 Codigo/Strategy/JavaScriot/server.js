const express = require("express");
const mongoose = require("mongoose");
const numberRoutes = require("./routes/numbers.routes");

const app = express();

app.use(express.json());
app.use(express.static("public"));

mongoose.connect(
  "mongodb+srv://Paulo:paulo2004@cluster0.9uxqgih.mongodb.net/Strategy",
)
.then(() => console.log("MongoDB connected"))
.catch(err => console.error(err));

// Routes
app.use("/api/numbers", numberRoutes);

app.listen(3000, () => {
  console.log("Server running on http://localhost:3000");
});
