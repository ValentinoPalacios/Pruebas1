from model.sorting_strategy import SortingStrategy

class QuickSort(SortingStrategy):

    def sort(self, data):
        print("Selected strategy QuickSort")
        arr = data.copy()
        arr.sort()
        return arr
