const SortingStrategy = require("./SortingStrategy");

class QuickSort extends SortingStrategy {
  sort(data) {
    console.log("Selected strategy QuickSort");
    return [...data].sort((a, b) => a - b);
  }
}

module.exports = QuickSort;
