const express = require("express");
const path = require("path");
const connectDB = require("../controller/MongoConnection");
const MongoCrud = require("../controller/MongoCrud");

const app = express(); 
const mongoCrud = new MongoCrud();

connectDB();

app.use(express.json());
app.use(express.urlencoded({ extended: true }));

app.use(express.static(path.join(__dirname)));

app.post("/store", async (req, res) => {
  const store = await mongoCrud.create(req.body);
  res.json(store);
});

app.get("/store/:id", async (req, res) => {
  const store = await mongoCrud.readById(parseInt(req.params.id));
  res.json(store || { message: "Store no encontrado" });
});

app.put("/store", async (req, res) => {
  await mongoCrud.update(req.body);
  res.json({ message: "Store actualizado" });
});

app.delete("/store/:id", async (req, res) => {
  await mongoCrud.delete(parseInt(req.params.id));
  res.json({ message: "Store eliminado" });
});

app.listen(3000, () => {
  console.log("Servidor corriendo en http://localhost:3000");
});
