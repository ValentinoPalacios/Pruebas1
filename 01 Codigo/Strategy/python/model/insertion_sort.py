from model.sorting_strategy import SortingStrategy

class InsertionSort(SortingStrategy):

    def sort(self, data):
        print("Selected strategy InsertionSort")
        arr = data.copy()
        arr.sort()
        return arr
