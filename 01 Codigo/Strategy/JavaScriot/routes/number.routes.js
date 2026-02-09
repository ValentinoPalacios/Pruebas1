const express = require("express");
const router = express.Router();
const NumberModel = require("../models/NumberModel");
const SortingContext = require("../strategies/SortingContext");

router.post("/", async (req, res) => {
  try {
    const numbers = req.body.numbers;

    if (!Array.isArray(numbers)) {
      return res.status(400).json({ error: "Invalid numbers" });
    }

    // Strategy (solo para mostrar/usar, NO se guarda)
    const context = new SortingContext();
    const sorted = context.sort(numbers);

    // Guardar SOLO números originales
    const doc = new NumberModel({ numbers });
    await doc.save();

    res.json({
      original: numbers,
      sorted,
      strategy: context.getStrategyName(),
      message: "Numbers saved successfully"
    });

  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

module.exports = router;
