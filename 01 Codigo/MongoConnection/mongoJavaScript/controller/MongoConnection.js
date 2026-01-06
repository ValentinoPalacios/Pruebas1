const mongoose = require("mongoose");

const connectDB = async () => {
  try {
    await mongoose.connect(
      "mongodb+srv://Paulo:paulo2004@cluster0.9uxqgih.mongodb.net/Stores"
    );
    console.log("MongoDB conectado");
  } catch (error) {
    console.error("Error al conectar MongoDB", error);
  }
};

module.exports = connectDB;
