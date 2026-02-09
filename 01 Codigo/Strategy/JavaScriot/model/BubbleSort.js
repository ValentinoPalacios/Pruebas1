const SortingStrategy = require("./SortingStrategy");

class BubbleSort extends SortingStrategy {
  sort(data) {
    console.log("Selected strategy BubbleSort");
    return [...data].sort((a, b) => a - b);
  }
}

module.exports = BubbleSort;
