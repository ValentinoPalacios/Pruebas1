const SortingStrategy = require("./SortingStrategy");

class InsertionSort extends SortingStrategy {
  sort(data) {
    console.log("Selected strategy InsertionSort");
    return [...data].sort((a, b) => a - b);
  }
}

module.exports = InsertionSort;
